package com.eprosima.idl.parser.tree;

import com.eprosima.idl.context.Context;

import java.util.Map;
import java.util.HashMap;

import org.antlr.v4.runtime.Token;

public class TreeNode implements Notebook
{
    public TreeNode(String scopeFile, boolean isInScope, String scope, String name, Token tk)
    {
		m_scopeFile = scopeFile;	
		m_isinscope = isInScope;
        m_name = name;
        m_scope = scope;
        m_annotations = new HashMap<String, Annotation>();
        tk_ = tk;
    }

	public String getScopeFile()
	{
		return m_scopeFile;
	}
	
	public boolean isInScope()
	{
		return m_isinscope;
	}

    public String getName()
    {
        return m_name;
    }
    
    public String getScopedname()
    {
        if(m_scope == null || m_scope.isEmpty())
            return m_name;

        return m_scope + "::" + m_name;
    }

    public String getJavaScopedname()
    {
        if(m_scope.isEmpty())
            return m_name;

        return m_scope.replace("::", ".") + "." + m_name;
    }

    public String getScope()
    {
        return m_scope;
    }
    
    /*
     * @brief This function returns the scoped name of the interface but
     * changing "::" by "_".
     */
    public String getFormatedScopedname()
    {
        String ret = null;
        
        if(m_scope == null || m_scope.isEmpty())
            ret = m_name;
        else
            ret = m_scope + "::" + m_name;
        
        return ret.replaceAll("::", "_");
    }

    public boolean getHasScope()
    {
        return !(m_scope == null || m_scope.isEmpty());
    }

    @Override
    public void addAnnotation(Context ctx, Annotation annotation)
    {
        if(annotation != null)
            m_annotations.put(annotation.getName(), annotation);
    }
    
    @Override
    public Map<String, Annotation> getAnnotations()
    {
        return m_annotations;
    }

    public Token getToken()
    {
        return tk_;
    }
	
	private String m_scopeFile = null;
	private boolean m_isinscope = false;
    private String m_name = null;
    private String m_scope = null;
    //! Map that stores the annotations of the interface.
    private HashMap<String, Annotation> m_annotations = null;
    //! IDL Parser token
    Token tk_ = null;
}

