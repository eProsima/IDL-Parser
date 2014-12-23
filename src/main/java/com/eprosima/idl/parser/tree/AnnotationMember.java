package com.eprosima.idl.parser.tree;

import com.eprosima.idl.parser.typecode.TypeCode;

public class AnnotationMember
{
    public AnnotationMember(String name, TypeCode typecode, String value)
    {
        m_typecode = typecode;
        m_name = name;
        m_value = value;
    }

    public AnnotationMember(AnnotationMember ann)
    {
        m_typecode = ann.m_typecode;
        m_name = ann.m_name;
        m_value = ann.m_value;
    }
    
    public String getName()
    {
        return m_name;
    }
    
    /*
     * @brief This function is used with RTI DDS types because array names contains [].
     */
    
    public TypeCode getTypecode()
    {
        return m_typecode;
    }

    public String getValue()
    {
        return m_value;
    } 

    public void setValue(String value)
    {
        m_value = value;
    }
    
    private String m_name = null;
    
    private TypeCode m_typecode = null;

    private String m_value = null;
}
