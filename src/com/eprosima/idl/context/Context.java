package com.eprosima.idl.context;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;

import com.eprosima.idl.parser.tree.ScopedObject;
import com.eprosima.idl.parser.tree.Notebook;
import com.eprosima.idl.parser.tree.Definition;
import com.eprosima.idl.parser.tree.Module;
import com.eprosima.idl.parser.tree.Interface;
import com.eprosima.idl.parser.tree.Operation;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.typecode.TypeCode;

import com.eprosima.idl.util.Util;

public class Context
{
    public Context(String filename, String file, ArrayList includePaths)
    {
        // Detect OS
        m_os = System.getProperty("os.name");
        m_userdir = System.getProperty("user.dir");

        m_filename = filename;
        m_directoryFile = Util.getIDLFileDirectoryOnly(file);
        m_file = file;

        // Remove absolute directory where the application was executed
        if(startsWith(m_file, m_userdir))
        {
        	m_file = m_file.substring(m_userdir.length());
        	
        	// Remove possible separator    
            if(startsWith(m_file, java.io.File.separator))
                m_file = m_file.substring(1);
        }
        // Remove relative directory if is equal that where the processed IDL is.
        if(m_directoryFile != null && startsWith(m_file, m_directoryFile))
        	m_file = m_file.substring(m_directoryFile.length());

        m_definitions = new ArrayList<Definition>();
        m_interfaces = new HashMap<String, Interface>();
        m_exceptions = new HashMap<String, com.eprosima.idl.parser.tree.Exception>();
        m_types = new HashMap<String, TypeCode>();
        m_annotations = new HashMap<String, Annotation>();
        m_tmpAnnotations = new HashMap<String, String>();

        // TODO Quitar porque solo es para tipos RTI (usado para las excepciones). Mirar alternativa.
        m_includedependency = new HashSet<String>();

        // The scope file has to be initialized because could occur the preprocessor
        // is not called (using -ppDisable).
        m_scopeFile = m_file;

        m_includePaths = new ArrayList<String>();
        m_dependencies = new HashSet<String>();
        m_directIncludeDependencies = new HashSet<String>();

        for(int i = 0; i < includePaths.size(); ++i)
        {
            String include = (String)includePaths.get(i);
            if(startsWith(include, includeFlag))
            	include = include.substring(includeFlag.length());
            if(startsWith(include, m_userdir))
            {
            	include = include.substring(m_userdir.length());
            	
            	// Remove possible separator    
                if(startsWith(include, java.io.File.separator))
                    include = include.substring(1);
            }
            if(m_directoryFile != null && startsWith(include, m_directoryFile))
            	include = include.substring(m_directoryFile.length());
            // Add last separator.
            if(include.charAt(include.length() - 1) != java.io.File.separatorChar)
                include += java.io.File.separator;
            m_includePaths.add(include);
        }
        
        // Reorder include paths;
        int pointer = 0;
        while(pointer < m_includePaths.size())
        {
            int count = pointer + 1;
            
            while(count < m_includePaths.size())
            {
                if(startsWith(m_includePaths.get(count), m_includePaths.get(pointer)))
                {
                    String first = m_includePaths.get(pointer);
                    String second = m_includePaths.get(count);
                    m_includePaths.set(pointer, second);
                    m_includePaths.set(count, first);
                    break;
                }
                ++count;
            }
            
            if(count == m_includePaths.size())
                ++pointer;
        }
    }

    public String getFilename()
    {
        return m_filename;
    }

    public void setFilename(String filename)
    {
        m_filename = filename;
    }

    public String getTrimfilename()
    {
        return Util.stringTrimAll(m_filename);
    }

    public String getScope()
    {
        return m_scope;
    }

    public void setScope(String scope)
    {
        m_scope = scope;
    }
    
    /*!
     * @return True if current call is in scoped file.
     */
    public boolean isInScopedFile()
    {
    	return m_scopeFile.equals(m_file);
    }

    public String getScopeFile()
    {
    	return m_scopeFile;
    }

    public boolean isScopeLimitToAll()
    {
    	return m_scopeLimitToAll;
    }

    public void setScopeLimitToAll(boolean scopeLimitToAll)
    {
    	m_scopeLimitToAll = scopeLimitToAll;
    }

    
    /*!
     * @return True if the object belongs to the processed file.
     */
    public boolean setScopedFileToObject(ScopedObject object)
    {
    	object.setScopeFile(m_scopeFile, m_scopeFile.equals(m_file));
    	return m_scopeFile.equals(m_file);
    }

    public int getCurrentIncludeLine()
    {
    	return m_currentincludeline;
    }
    
    /*!
     * @brief This function stores a global definition of the IDL file.
     */
    public void addDefinition(Definition definition)
    {
        m_definitions.add(definition);
    }

    public ArrayList<Definition> getDefinitions()
    {
        return m_definitions;
    }

    /*!
     * @brief This function adds a interface to the context.
     * This function is used in the parser.
     */
    public void addInterface(String name, Interface interf)
    { 
        Interface prev = m_interfaces.put(name, interf);
        
        // TODO: Excepcion
        if(prev != null)
            System.out.println("Warning: Redefined interface " + name);
    }

    /*!
     * @brief This function returns all interfaces.
     * This function is used in string templates.
     */
    public ArrayList<Interface> getInterfaces()
    {
        return new ArrayList<Interface>(m_interfaces.values());
    }
    
    /*!
     * @brief This function adds a global exception to the context.
     */
    public void addException(String name, com.eprosima.idl.parser.tree.Exception exception)
    {
    	com.eprosima.idl.parser.tree.Exception prev = m_exceptions.put(name, exception);
        
        // TODO: Exception.
        if(prev != null)
        	System.out.println("Warning: Redefined exception " + name);
    }

    /*!
     * @brief This function tries to retrieve a global typecode.
     */
    public com.eprosima.idl.parser.tree.Exception getException(String name)
    {
        int lastIndex = -1;
        com.eprosima.idl.parser.tree.Exception returnedValue = m_exceptions.get(name);

        // Probar si no tiene scope, con el scope actual.
        if(returnedValue == null && ((lastIndex = name.lastIndexOf("::")) == -1))
        {
            String scope = m_scope;

            while(returnedValue == null && !scope.isEmpty())
            {
                returnedValue = m_exceptions.get(scope + "::" + name);
                lastIndex = scope.lastIndexOf("::");

                if(lastIndex != -1)
                {
                    scope = scope.substring(0, lastIndex);
                }
                else
                {
                    scope = "";
                }
            }
        }

        return returnedValue;
    }

    /*!
     * @brief This function adds a global typecode to the context.
     */
    public void addTypeCode(String name, TypeCode typecode)
    {
        TypeCode prev = m_types.put(name, typecode);
        
        // TODO: Exception.
        if(prev != null)
        	System.out.println("Warning: Redefined type " + name);
    }

    /*!
     * @brief This function tries to retrieve a global typecode.
     */
    public TypeCode getTypeCode(String name)
    {
        int lastIndex = -1;
        TypeCode returnedValue = m_types.get(name);

        // Probar si no tiene scope, con el scope actual.
        if(returnedValue == null && ((lastIndex = name.lastIndexOf("::")) == -1))
        {
            String scope = m_scope;

            while(returnedValue == null && !scope.isEmpty())
            {
                returnedValue = m_types.get(scope + "::" + name);
                lastIndex = scope.lastIndexOf("::");

                if(lastIndex != -1)
                {
                    scope = scope.substring(0, lastIndex);
                }
                else
                {
                    scope = "";
                }
            }
        }

        return returnedValue;
    }

    /*!
     * @brief This function adds an annotation to the context.
     */
    public void addAnnotation(String name, Annotation annotation)
    {
        Annotation prev = m_annotations.put(name, annotation);
        
        // TODO: Exception.
        if(prev != null)
            System.out.println("Warning: Redefined annotation " + name);
    }

    public Annotation getAnnotation(String name)
    {
        int lastIndex = -1;
        Annotation returnedValue = m_annotations.get(name);

        // Probar si no tiene scope, con el scope actual.
        if(returnedValue == null && ((lastIndex = name.lastIndexOf("::")) == -1))
        {
            String scope = m_scope;

            while(returnedValue == null && !scope.isEmpty())
            {
                returnedValue = m_annotations.get(scope + "::" + name);
                lastIndex = scope.lastIndexOf("::");

                if(lastIndex != -1)
                {
                    scope = scope.substring(0, lastIndex);
                }
                else
                {
                    scope = "";
                }
            }
        }

        return returnedValue;
    }
    

    /*!
     * @brief This function add a temporarily annotation.
     * This annotation will be linked with a future object.
     * @param id Identifier of the annotation.
     * @param value Value of the annotation.
     */
    public void addTmpAnnotation(String id, String value)
    {    		
    	String oldValue = m_tmpAnnotations.put(id, value);
    	
    	// TODO Lanzar una excepcion.
    	if(oldValue != null)
    		System.out.println("Annotation " + id + " was redefined");
    }
    
    /*!
     * @brief This function links the temporarily annotations with an object.
     * @param notebook The object where the temporarily annotations will be stored.
     */
    public void setTmpAnnotations(Notebook notebook)
    {
        notebook.addAnnotations(m_tmpAnnotations);
        m_tmpAnnotations.clear();
    }
    
    /*!
     * @brief This function add a new library dependency to the project.
     */
    public void addDependency(String dependency)
    {
    	m_dependencies.add(dependency);
    }

    /*!
     * @brief This function get the library dependencies of a project.
     */
    public HashSet getDependencies()
    {
    	if(getOS().contains("Windows"))
    	{
    		HashSet<String> set = new HashSet<String>();
    		Iterator<String> it = m_dependencies.iterator();
    		
    		while(it.hasNext())
    		{
    			String dep = it.next();
    			
	            // In windows substitute \\ by /
	            int count = 0;
	    		while((count = dep.indexOf("/")) != -1)
	    		{
	    			dep = dep.substring(0, count) + "\\" + dep.substring(count + 1);
	    		}
	    		
	    		set.add(dep);
    		}
    		
    		return set;
    	}
    	
    	return m_dependencies;
    }

    /*!
     * @brief This function is used in the stringtemplates. For these reason this function
     * returns an ArrayList
     */
    public ArrayList<String> getDirectIncludeDependencies()
    {
        return new ArrayList<String>(m_directIncludeDependencies);
    }

    // TODO Quitar porque solo es para tipos RTI (usado para las excepciones). Mirar alternativa.
    /*!
     * @brief This function add a new include dependency to the project.
     * This dependency will be needed to include our generated file with the types that
     * the RTI DDS middleware doesn't generate (right now only exceptions).
     * The include dependencies are added without the .idl extension.
     */
    public void addIncludeDependency(String dependency)
    {
    	// Remove .idl extension.
        String dep = dependency.substring(0, dependency.length() - 4);
        // Remove directory if it is the same than main IDL file.
        if(m_directoryFile != null && startsWith(dep, m_directoryFile))
        	dep = dep.substring(m_directoryFile.length());
    	m_includedependency.add(dep);
    }
    
    // TODO Quitar porque solo es para tipos RTI (usado para las excepciones). Mirar alternativa.
    /*!
     * @brief This function is used in the stringtemplates. For these reason this function
     * returns an ArrayList
     */
    public ArrayList<String> getIncludeDependencies()
    {
    	return new ArrayList<String>(m_includedependency);
    }

    /*!
     * @brief This function sets the current module that is been processed.
     */
    public void setCurrentModule(Module module)
    {
        m_currentmodule = module;
    }
    
    /*!
     * @brief This function gets the current module that is been processed.
     */
    public Module getCurrentModule()
    {
        return m_currentmodule;
    }
    
    /*!
     * @brief This function is call when a preprocessor line was found by the lexer.
     * In case the line referring to the content included file, this function sets this file as current scope file.
     * Also this function saves the scope file in the library dependecy map.
     * In case it is a #include directive, this is saved as direct include dependency.
     */
    public void processPreprocessorLine(String line, int nline)
    { 	
    	// If there is a line referring to the content of an included file.
    	if(line.charAt(0) == ' ')
    	{
    	    /* The received preprocessor line has the following form:
             * ' numline filename flags'
    	     * where:
    	     * - numline Number of the line where the include was.
    	     * - filename The filename whose content was included.
    	     * - flags
    	     */
    	    Scanner scanner = new Scanner(line);
    	    
    	    // Read numline
    	    int numline = scanner.nextInt();
    	    
    	    // Read filename
    	    String filename = scanner.next("\".*\"");
    	    
    	    // Read flags.
    	    boolean systemFile = false, enteringFile = false, exitingFile = false;
    	    
    	    if(m_os.contains("Linux"))
    	    {
        	    try
        	    {
        	        while(true)
        	        {
        	            Integer flag = scanner.nextInt();
    
        	            if(flag == 1)
        	                enteringFile = true;
        	            else if(flag == 2)
        	                exitingFile = true;
        	            else if(flag == 3)
        	                systemFile = true;
        	        }
        	    }
        	    catch(NoSuchElementException ex)
        	    {
        	        // The line finishes.
        	    }
    	    }
    	    
    	    // Only not system files are processed.
    	    if(!systemFile)
    	    {
    	        // Remove "
	            String file = filename.substring(1, filename.length() - 1);
	            
	            // Remove absolute directory where the application was executed
	            if(startsWith(file, m_userdir))
	            {
	            	file = file.substring(m_userdir.length());
	            	
	            	// Remove possible separator    
	                if(startsWith(file, java.io.File.separator))
	                    file = file.substring(1);
	            }
	            // Remove relative ./ directory.
	            if(startsWith(file, currentDirS))
	            	file = file.substring(currentDirS.length());
	            String depfile = file;
	            // Remove relative directory if is equal that where the processed IDL is.
	            if(m_directoryFile != null && startsWith(file, m_directoryFile))
	            	file = file.substring(m_directoryFile.length());
	            // Remove relative directory if is equal to a include path.
	            for(int i = 0; i < m_includePaths.size(); ++i)
	            {   
	            	if(startsWith(file, m_includePaths.get(i)))
	            	{
	            		file = file.substring(m_includePaths.get(i).length());
	                    break;
	                }
	            }
	            // Remove possible separator    
	            if(startsWith(file, java.io.File.separator))
	            	file = file.substring(1);
	            
	            //if it is a idl file.
	            if(file.substring(file.length() - 4, file.length()).equals(".idl"))
	            {
	                m_scopeFile = file;
	                
	                // Add to dependency if there is different IDL file than the processed
	                if(!m_scopeFile.equals(m_file))
	                {
	                    m_dependencies.add(depfile);
	                    
	                    // See if it is a direct dependency.
	                    if(m_lastDirectDependency != null &&
	                            m_lastDirectDependency.equals(m_file))
	                        m_directIncludeDependencies.add(m_scopeFile.substring(0, file.length() - 4));
	                }

	                // Update last direct dependency
	                m_lastDirectDependency = m_scopeFile;
	                
	                //Update the current line.
	                m_currentincludeline = nline - (numline - 1);
    	        }
    	    }
    	}
    }

    protected String getOS()
    {
        return m_os;
    }
    
    protected boolean startsWith(String st, String prefix)
    {
    	if(m_os.contains("Windows"))
    	{
    		return st.toLowerCase().startsWith(prefix.toLowerCase());
    	}
    	
    	return st.startsWith(prefix);
    }

    // OS
    String m_os = null;
    String m_userdir = null;

    private String m_filename = "";
    private String m_file = "";
    private String m_directoryFile = "";

    private String m_scope = "";
    private String m_scopeFile = "";
    private boolean m_scopeLimitToAll = false;

    private int m_currentincludeline = 0;

    final String currentDirS = "." + File.separator;
    final String includeFlag = "-I";

    //! Store all global definitions.
    private ArrayList<Definition> m_definitions;
    //! Map that contains all interfaces that were found processing the IDL file (after preprocessing):
    private HashMap<String, Interface> m_interfaces = null;
    //! Map that contains all global exceptions that were found processing the IDL file (after preprocessing).
    private HashMap<String, com.eprosima.idl.parser.tree.Exception> m_exceptions = null;
    //! Map that contains all types that were found processing the IDL file (after preprocessing).
    protected HashMap<String, TypeCode> m_types = null;
  //! Map that contains all annotations that where found processing the IDL file.
    private HashMap<String, Annotation> m_annotations = null;
    //! Map that contains temporarily the annotations before to be linked with an element.
    private HashMap<String, String> m_tmpAnnotations = null;
    //! Current Module that is been processing.
    private Module m_currentmodule = null;

    private ArrayList<String> m_includePaths = null;
    //! Set that contains the library dependencies that were found because there was a line of the preprocessor.
    private HashSet<String> m_dependencies = null;

    //! Set that contains the direct include dependencies in the IDL file. Used to regenerate the IDL in a supported form.
    private HashSet<String> m_directIncludeDependencies = null;
    private String m_lastDirectDependency = null;

    // TODO Quitar porque solo es para tipos RTI (usado para las excepciones). Mirar alternativa.
    //! Set that contains the include dependencies that force to include our type generated file (right now only with exceptions in RTI DDS types).
    private HashSet<String> m_includedependency = null;
}
