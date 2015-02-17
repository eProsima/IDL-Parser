package com.eprosima.idl.parser.tree;

import java.util.ArrayList;
import org.antlr.v4.runtime.Token;

public class DefinitionContainer extends TreeNode
{
    protected DefinitionContainer(String scopeFile, boolean isInScope, String scope, String name, Token token)
    {
        super(scopeFile, isInScope, scope, name, token);

        m_definitions = new ArrayList<Definition>();
    }
    
    public void add(Definition def)
    {
        m_definitions.add(def);
        def.setParent(this);
    }
    
    public ArrayList<Definition> getDefinitions()
    {
        return m_definitions;
    }
    
    private ArrayList<Definition> m_definitions;
}
