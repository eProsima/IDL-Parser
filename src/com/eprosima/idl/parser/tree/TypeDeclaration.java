package com.eprosima.idl.parser.tree;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.typecode.TypeCode;

public class TypeDeclaration implements Definition, Export
{
    public TypeDeclaration(TypeCode typecode)
    {
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
    public Interface getFirstInterface(String idlFile)
    {
        return null;
    }
    
    @Override
    public com.eprosima.idl.parser.tree.Exception getFirstException(String idlFile)
    {
        return null;
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
    public boolean resolve(Context ctx)
    {
    	return true;
    }
    
    private TypeCode m_typecode = null;
    private Object m_parent = null;
}
