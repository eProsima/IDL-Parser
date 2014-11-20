package com.eprosima.idl.parser.tree;

import java.util.ArrayList;

public class ExportContainer extends TreeNode
{
    protected ExportContainer(String scopeFile, boolean isInScope, String scope, String name)
    {
        super(scopeFile, isInScope, scope, name);

        m_exports = new ArrayList<Export>();
    }
    
    public void add(Export exp)
    {
        m_exports.add(exp);
        exp.setParent(this);
    }
    
    public ArrayList<Export> getExports()
    {
        return m_exports;
    }
    
    private ArrayList<Export> m_exports;
}
