package com.eprosima.idl.parser.tree;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.typecode.TypeCode;

import org.antlr.v4.runtime.Token;

public class TypeDeclaration extends TreeNode implements Definition, Export
{
    public TypeDeclaration(String scopeFile, boolean isInScope, String scope, String name, TypeCode typecode, Token token)
    {
        super(scopeFile, isInScope, scope, name, token);

        m_typecode = typecode;
        // Set as parent to the Typecode.
        m_typecode.setParent(this);
    }
    
    public TypeCode getTypeCode()
    {
        return m_typecode;
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
        return true;
    }
    
    @Override
    public boolean isIsConstDeclaration()
    {
        return false;
    }
	
	@Override
	public boolean isIsAnnotation()
    {
        return false;
    }
    
    @Override
    public boolean resolve(Context ctx)
    {
    	return true;
    }
    
    private TypeCode m_typecode = null;
    private Object m_parent = null;
}
