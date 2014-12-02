package com.eprosima.idl.parser.tree;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.typecode.TypeCode;

public class ConstDeclaration extends TreeNode implements Definition, Export
{
    public ConstDeclaration(String scopeFile, boolean isInScope, String scope, String name, TypeCode typecode, String value)
    {
        super(scopeFile, isInScope, scope, name);

        m_typecode = typecode;
        m_value = value;
        // Set as parent to the Typecode.
        m_typecode.setParent(this);
    }
    
    public TypeCode getTypeCode()
    {
        return m_typecode;
    }

    public String getValue()
    {
        return m_value;
    }

    public void setParent(Object obj)
    {
        m_parent = obj;
    }
    
    public Object getParent()
    {
        return m_parent;
    }
    
    @Override
    public boolean isIsModule()
    {
        return false;
    }
    
    @Override
    public boolean isIsOperation()
    {
        return false;
    }
    
    @Override
    public boolean isIsException()
    {
        return false;
    }
    
    @Override
    public boolean isIsInterface()
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
        return true;
    }
    
    @Override
    public boolean resolve(Context ctx)
    {
    	return true;
    }
	
	@Override
	public boolean isIsAnnotation()
    {
        return false;
    }
	
	@Override
    public Interface getFirstInterface(String idlFile)
    {
        return null;
    }
	
	@Override
    public com.eprosima.idl.parser.tree.Exception getFirstException(String idlFile)
    {
        return null;
    }
    
    private TypeCode m_typecode = null;
    private String m_value = null;
    private Object m_parent = null;
}
