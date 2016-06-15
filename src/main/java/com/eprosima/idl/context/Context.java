// Copyright 2016 Proyectos y Sistemas de Mantenimiento SL (eProsima).
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.eprosima.idl.context;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Collection;

import com.eprosima.idl.util.Pair;
import com.eprosima.idl.parser.tree.TreeNode;
import com.eprosima.idl.parser.tree.Notebook;
import com.eprosima.idl.parser.tree.Definition;
import com.eprosima.idl.parser.tree.Module;
import com.eprosima.idl.parser.tree.Interface;
import com.eprosima.idl.parser.tree.Operation;
import com.eprosima.idl.parser.tree.Param;
import com.eprosima.idl.parser.tree.AnnotationDeclaration;
import com.eprosima.idl.parser.tree.TypeDeclaration;
import com.eprosima.idl.parser.typecode.TypeCode;
import com.eprosima.idl.parser.typecode.StructTypeCode;

import com.eprosima.idl.util.Util;
import com.eprosima.idl.parser.exception.ParseException;

import org.antlr.v4.runtime.Token;

public class Context
{
    public Context(String filename, String file, ArrayList<String> includePaths)
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
        /*
        // Remove relative directory if is equal that where the processed IDL is.
        if(m_directoryFile != null && startsWith(m_file, m_directoryFile))
        	m_file = m_file.substring(m_directoryFile.length());
        */

        m_definitions = new ArrayList<Definition>();
        m_modules = new HashMap<String, Module>();
        m_interfaces = new HashMap<String, Interface>();
        m_exceptions = new HashMap<String, com.eprosima.idl.parser.tree.Exception>();
        m_types = new HashMap<String, TypeDeclaration>();
        m_annotations = new HashMap<String, AnnotationDeclaration>();

        // TODO Quitar porque solo es para tipos RTI (usado para las excepciones). Mirar alternativa.
        m_includedependency = new HashSet<String>();

        // The scope file has to be initialized because could occur the preprocessor
        // is not called (using -ppDisable).
        m_scopeFile = m_file;

        m_includePaths = new ArrayList<String>();
        m_dependencies = new LinkedHashSet<String>();
        m_directIncludeDependencies = new HashSet<String>();
        m_scopeFilesStack = new Stack<Pair<String, Integer>>();

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

    public int getCurrentIncludeLine()
    {
    	return m_currentincludeline;
    }

    public Stack<Pair<String, Integer>> getScopeFilesStack()
    {
        return m_scopeFilesStack;
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
     * @brief This function adds a module to the context.
     * This function is used in the parser.
     */
    public void addModule(Module module)
    { 
        if(!m_modules.containsKey(module.getScopedname()))
        {
            m_modules.put(module.getScopedname(), module);
        }
    }

    public Module existsModule(String scopedName)
    {
        if(m_modules.containsKey(scopedName))
        {
            return m_modules.get(scopedName);
        }

        return null;
    }

    public Interface createInterface(String name, Token token)
    {
        Interface interfaceObject = new Interface(m_scopeFile, isInScopedFile(), m_scope, name, token);
        addInterface(interfaceObject);
        return interfaceObject;
    }

    /*!
     * @brief This function adds a interface to the context.
     * This function is used in the parser.
     */
    protected void addInterface(Interface interf)
    { 
        Interface prev = m_interfaces.put(interf.getScopedname(), interf);
        
        // TODO: Excepcion
        if(prev != null)
            System.out.println("Warning: Redefined interface " + prev.getScopedname());
    }

    public Interface getInterface(String name)
    {
        int lastIndex = -1;
        Interface returnedValue = m_interfaces.get(name);

        if(returnedValue == null)
        {
            String scope = m_scope;

            while(returnedValue == null && !scope.isEmpty())
            {
                returnedValue = m_interfaces.get(scope + "::" + name);
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
     * @brief This function returns all interfaces.
     * This function is used in string templates.
     */
    public ArrayList<Interface> getInterfaces()
    {
        return new ArrayList<Interface>(m_interfaces.values());
    }

    public ArrayList<Interface> getScopedInterfaces()
    {
        ArrayList<Interface> ret = new ArrayList<Interface>();

        for(Interface interf : m_interfaces.values())
        {
            if(interf.isInScope())
                ret.add(interf);
        }

        return ret;
    }

    public com.eprosima.idl.parser.tree.Exception createException(String name, Token token)
    {
        com.eprosima.idl.parser.tree.Exception exceptionObject = new com.eprosima.idl.parser.tree.Exception(m_scopeFile, isInScopedFile(), m_scope, name, token);
        addException(exceptionObject);
        return exceptionObject;
    }
    
    /*!
     * @brief This function adds a global exception to the context.
     */
    protected void addException(com.eprosima.idl.parser.tree.Exception exception)
    {
    	com.eprosima.idl.parser.tree.Exception prev = m_exceptions.put(exception.getScopedname(), exception);
        
        // TODO: Exception.
        if(prev != null)
        	System.out.println("Warning: Redefined exception " + prev.getScopedname());
    }

    /*!
     * @brief This function tries to retrieve a global typecode.
     */
    public com.eprosima.idl.parser.tree.Exception getException(String name)
    {
        int lastIndex = -1;
        com.eprosima.idl.parser.tree.Exception returnedValue = m_exceptions.get(name);

        // Probar si no tiene scope, con el scope actual.
        if(returnedValue == null)
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

    public Operation createOperation(String name, Token token)
    {
        Operation operationObject = new Operation(m_scopeFile, isInScopedFile(), null, name, token);
        return operationObject;
    }

    public Param createParam(String name, TypeCode typecode, Param.Kind kind)
    {
        Param paramObject = new Param(name, typecode, kind);
        return paramObject;
    }

    public StructTypeCode createStructTypeCode(String name)
    {
        StructTypeCode structObject = new StructTypeCode(m_scope, name);
        return structObject;
    }

    public Collection<TypeDeclaration> getTypes()
    {
        return m_types.values();
    }

    /*!
     * @brief This function adds a global typecode to the context.
     */
    public void addTypeDeclaration(TypeDeclaration typedecl)
    {
        TypeDeclaration prev = m_types.put(typedecl.getScopedname(), typedecl);
        
        if(prev != null)
            throw new ParseException(typedecl.getToken(), "was redefined");
    }

    /*!
     * @brief This function tries to retrieve a global typecode.
     */
    public TypeCode getTypeCode(String name)
    {
        int lastIndex = -1;
        TypeCode returnedValue = null;
        TypeDeclaration typedecl = m_types.get(name);

        // Probar si no tiene scope, con el scope actual.
        if(typedecl == null)
        {
            String scope = m_scope;

            while(typedecl == null && !scope.isEmpty())
            {
                typedecl = m_types.get(scope + "::" + name);
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

        if(typedecl != null)
            returnedValue = typedecl.getTypeCode();


        return returnedValue;
    }


    public AnnotationDeclaration createAnnotationDeclaration(String name, Token token)
    {
        AnnotationDeclaration annotationObject = new AnnotationDeclaration(m_scopeFile, isInScopedFile(), m_scope, name, token);
        addAnnotationDeclaration(annotationObject);
        return annotationObject;
    }

    /*!
     * @brief This function adds an annotation to the context.
     */
    protected void addAnnotationDeclaration(AnnotationDeclaration annotation)
    {
        AnnotationDeclaration prev = m_annotations.put(annotation.getScopedname(), annotation);
        
        // TODO: Exception.
        if(prev != null)
            System.out.println("Warning: Redefined annotation " + prev.getScopedname());
    }

    public AnnotationDeclaration getAnnotationDeclaration(String name)
    {
        int lastIndex = -1;
        AnnotationDeclaration returnedValue = m_annotations.get(name);

        // Probar si no tiene scope, con el scope actual.
        if(returnedValue == null)
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
     * @brief This function add a new library dependency to the project.
     */
    public void addDependency(String dependency)
    {
    	m_dependencies.add(dependency);
    }

    /*!
     * @brief This function get the library dependencies of a project.
     */
    public LinkedHashSet<String> getDependencies()
    {
        // At this level the dependencies are in reverse order. Return them
        // in correct order.
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        LinkedList<String> list = new LinkedList<String>(m_dependencies);
        Iterator<String> it = list.descendingIterator();

        while(it.hasNext())
        {
            String dep = it.next();

            if(getOS().contains("Windows"))
            {
                // In windows substitute \\ by /
                int count = 0;
                while((count = dep.indexOf("/")) != -1)
                {
                    dep = dep.substring(0, count) + "\\" + dep.substring(count + 1);
                }
            }

            set.add(dep);
        }

        return set;
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
     * @brief This function is call when a preprocessor line was found by the lexer.
     * In case the line referring to the content included file, this function sets this file as current scope file.
     * Also this function saves the scope file in the library dependecy map.
     * In case it is a #include directive, this is saved as direct include dependency.
     */
    public void processPreprocessorLine(String line, int nline)
    { 	
        // If there is a line referring to the content of an included file.
        if(line.startsWith("# "))
        {
            String line_ = line.substring(2);

            /* The received preprocessor line has the following form:
             * ' numline filename flags'
             * where:
             * - numline Number of the line where the include was.
             * - filename The filename whose content was included.
             * - flags
             */
            Scanner scanner = new Scanner(line_);

            // Read numline
            int numline = scanner.nextInt();

            line_ = scanner.nextLine();
            scanner = new Scanner(line_).useDelimiter("\"");

            // Read filename
            scanner.next();
            String file = scanner.next();

            // Read flags.
            boolean systemFile = false, enteringFile = false, exitingFile = false;

            if(m_os.contains("Linux"))
            {
                try
                {
                    line_ = scanner.nextLine();
                    scanner = new Scanner(line_);
                    scanner.next();

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
                if(!m_scopeFile.equals(file))
                {
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
                    // Remove possible separator    
                    if(startsWith(file, java.io.File.separator))
                        file = file.substring(1);


                    //if it is a idl file.
                    if(file.substring(file.length() - 4, file.length()).equals(".idl"))
                    {
                        if(!m_scopeFile.equals(file))
                        {
                            if(!m_scopeFilesStack.empty() && m_scopeFilesStack.peek().first().equals(file))
                            {
                                m_scopeFilesStack.pop();

                                // Add to dependency if there is different IDL file than the processed
                                addDependency(m_scopeFile);

                                // See if it is a direct dependency.
                                if(file.equals(m_file))
                                {
                                    String includeFile = m_scopeFile;
                                    // Remove relative directory if is equal that where the processed IDL is.
                                    if(m_directoryFile != null && startsWith(includeFile, m_directoryFile))
                                        includeFile = includeFile.substring(m_directoryFile.length());
                                    // Remove relative directory if is equal to a include path.
                                    for(int i = 0; i < m_includePaths.size(); ++i)
                                    {   
                                        if(startsWith(includeFile, m_includePaths.get(i)))
                                        {
                                            includeFile = includeFile.substring(m_includePaths.get(i).length());
                                            break;
                                        }
                                    }

                                    m_directIncludeDependencies.add(includeFile.substring(0, includeFile.length() - 4));
                                }
                            }
                            else
                            {
                                m_scopeFilesStack.push(new Pair<String, Integer>(m_scopeFile, nline - m_currentincludeline - 1));
                            }

                            m_scopeFile = file;
                        }
                    }
                }

                //Update the current line.
                m_currentincludeline = nline - numline;
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

    /*** Function to generate random loop variables in string templates ***/
    public String getNewLoopVarName()
    {
        m_loopVarName = 'a';
        return Character.toString(m_loopVarName);
    }

    public String getNextLoopVarName()
    {
        return Character.toString(++m_loopVarName);
    }
    /*** End ***/

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
    //! Map that contains all modules that were found processing the IDL file (after preprocessing):
    private HashMap<String, Module> m_modules = null;
    //! Map that contains all interfaces that were found processing the IDL file (after preprocessing):
    private HashMap<String, Interface> m_interfaces = null;
    //! Map that contains all global exceptions that were found processing the IDL file (after preprocessing).
    private HashMap<String, com.eprosima.idl.parser.tree.Exception> m_exceptions = null;
    //! Map that contains all types that were found processing the IDL file (after preprocessing).
    protected HashMap<String, TypeDeclaration> m_types = null;
    //! Map that contains all annotations that where found processing the IDL file.
    private HashMap<String, AnnotationDeclaration> m_annotations = null;

    private ArrayList<String> m_includePaths = null;
    //! Set that contains the library dependencies that were found because there was a line of the preprocessor.
    private LinkedHashSet<String> m_dependencies = null;

    //! Set that contains the direct include dependencies in the IDL file. Used to regenerate the IDL in a supported form.
    private HashSet<String> m_directIncludeDependencies = null;

    // TODO Quitar porque solo es para tipos RTI (usado para las excepciones). Mirar alternativa.
    //! Set that contains the include dependencies that force to include our type generated file (right now only with exceptions in RTI DDS types).
    private HashSet<String> m_includedependency = null;

    // TODO Lleva la cuenta del nombre de variables para bucles anidados.
    private char m_loopVarName = 'a';

    private Stack<Pair<String, Integer>> m_scopeFilesStack;
}
