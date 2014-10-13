package com.eprosima.idl.parser.tree;

import com.eprosima.idl.parser.typecode.TypeCode;

public class Param
{
    public enum Kind
    {
        IN_PARAM,
        OUT_PARAM,
        INOUT_PARAM
    };

    public boolean isInput()
    {
        if(m_kind == Kind.IN_PARAM || m_kind == Kind.INOUT_PARAM)
        {
            return true;
        }

        return false;
    }
    
    public boolean isOutput()
    {
        if(m_kind == Kind.OUT_PARAM || m_kind == Kind.INOUT_PARAM)
        {
            return true;
        }

        return false;
    }
    
    public boolean isOnlyOutput()
    {        
        if(m_kind == Kind.OUT_PARAM)
        {
            return true;
        }

        return false;
    }
    
    public String getComment()
    {
        if(m_kind == Kind.IN_PARAM)
            return "in";
        else if(m_kind == Kind.OUT_PARAM)
            return "out";
        else if(m_kind == Kind. INOUT_PARAM)
            return "inout";

        return "error";
    }
    
    public Param(String name, TypeCode typecode, Kind kind)
    {
        m_name = name;
        m_typecode = typecode;
        m_kind = kind;
    }
    
    public String getName()
    {
        return m_name;
    }
    
    public TypeCode getTypecode()
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
    
    private Kind m_kind = Kind.IN_PARAM;
    private String m_name = null;
    private TypeCode m_typecode = null;
    private Object m_parent = null;
}
