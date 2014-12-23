package com.eprosima.idl.parser.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Module extends DefinitionContainer implements Definition, Notebook
{   
    public Module(String scopeFile, boolean isInScope, String scope, String name)
    {
        super(scopeFile, isInScope, scope, name);

        m_annotations = new HashMap<String, Annotation>();
    }
    
    public void setParent(Object obj)
    {
        m_parent = obj;
    }
    
    public Object getParent()
    {
        return m_parent;
    }
    
    
    /*!
     * @brief This function is used in stringtemplates to not generate module in some cases (Right now in RequestReply.idl).
     */
    public boolean isThereAreValidDefinitions()
    {
    	boolean returnedValue = false;
    	
		for(int count = 0; !returnedValue && count < getDefinitions().size(); ++count)
        {
            returnedValue = getDefinitions().get(count).isIsInterface();
        }
    	
    	return returnedValue;
    }
    
    /*!
     * @brief This function is used in stringtemplates to not generate module in some cases (Right now in generated RTI idl).
     */
    public boolean isThereAreDeclarations()
    {
        boolean returnedValue = false;
        
        for(int count = 0; !returnedValue && count < getDefinitions().size(); ++count)
        {
            if(getDefinitions().get(count).isIsInterface())
            {
                returnedValue = ((Interface)getDefinitions().get(count)).isThereAreDeclarations();
            }
            else
            {
                returnedValue = getDefinitions().get(count).isIsTypeDeclaration() ||
                    getDefinitions().get(count).isIsException();
            }
        }
        
        return returnedValue;
    }
    
    @Override
    public boolean isIsModule()
    {
        return true;
    }
    
    @Override
    public boolean isIsInterface()
    {
    	return false;
    }
    
    @Override
    public boolean isIsException()
    {
    	return false;
    }
    
    @Override
    public boolean isIsTypeDeclaration()
    {
        return false;
    }

    @Override
    public boolean isIsConstDeclaration()
    {
        return false;
    }
    
    @Override
    public void addAnnotation(Annotation annotation)
    {
        if(annotation != null)
            m_annotations.put(annotation.getName(), annotation);
    }
    
    @Override
    public Map<String, Annotation> getAnnotations()
    {
        return m_annotations;
    }
	
	@Override
	public boolean isIsAnnotation()
    {
        return false;
    }
    
    ////////// RESTful block //////////
    
    public String getResourceCompleteBaseUri()
    {
        Annotation baseUri = m_annotations.get("RESOURCES_BASE_URI");
        String baseUriStr = baseUri.getValue("value");
        
        if(baseUriStr != null)
        {
            // Remove http://
            int posInit = baseUriStr.indexOf("//");
            
            if(posInit == -1)
                posInit = 0;
            else
                posInit += 2;
            
            return baseUriStr.substring(posInit);
        }
        
        return baseUriStr;
    }
    
    /*
     * @brief This function return the base URI without the host.
     * Also all spaces are converted to %20.
     */
    public String getResourceBaseUri()
    {
        String baseUri = getResourceCompleteBaseUri();
        
        if(baseUri != null)
        {
            // Remove host
            int posEnd = baseUri.indexOf('/');
            
            if(posEnd == -1)
                return "";
            else
                return baseUri.substring(posEnd).replace(" ", "%20");
        }
        
        return null;
    }
    
    /*
     * @brief This function return the base URI without the host.
     * Also all spaces are converted to %20.
     */
    public String getResourceBaseUriWithoutLastBackslace()
    {
        String baseUri = getResourceBaseUri();
        
        if(baseUri != null)
        {
            if(!baseUri.isEmpty() && baseUri.charAt(baseUri.length() - 1) == '/')
            {
                if(baseUri.length() > 1)
                    baseUri = baseUri.substring(0, baseUri.length() - 1);
                else
                    baseUri = "";
            }
            return baseUri;
        }
        
        return null;
    }
    
    public String getResourceHost() {
        Annotation path =  m_annotations.get("RESOURCES_BASE_URI");
        String pathStr = path.getValue("value");
        
        // Remove http://
        int posInit = pathStr.indexOf("//");
        if(posInit == -1)
            posInit = 0;
        else
            posInit += 2;
        
        // Remove path
        int posEnd = pathStr.indexOf('/', posInit);
        
        if(posEnd == -1)
            posEnd = pathStr.length()-1;
        
        return pathStr.substring(posInit, posEnd);     
    }
    
    ////////// End RESTful block //////////

    private Object m_parent = null;
  //! Map that stores the annotations of the interface.
    Map<String, Annotation> m_annotations = null;
}
