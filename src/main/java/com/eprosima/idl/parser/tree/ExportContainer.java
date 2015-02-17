package com.eprosima.idl.parser.tree;

import java.util.ArrayList;
import org.antlr.v4.runtime.Token;

public class ExportContainer extends TreeNode
{
    protected ExportContainer(String scopeFile, boolean isInScope, String scope, String name, Token token)
    {
        super(scopeFile, isInScope, scope, name, token);

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
