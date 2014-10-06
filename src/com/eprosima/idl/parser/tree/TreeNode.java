package com.eprosima.idl.parser.tree;

public class TreeNode
{
    public TreeNode(String scopeFile, boolean isInScope, String scope, String name)
    {
		m_scopeFile = scopeFile;	
		m_isinscope = isInScope;
        m_name = name;
        m_scope = scope;
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
	
	private String m_scopeFile = null;
	private boolean m_isinscope = false;
    private String m_name = null;
    private String m_scope = null;
}

