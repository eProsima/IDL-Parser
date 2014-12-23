package com.eprosima.idl.parser.typecode;

import java.util.List;

public class UnionMember extends Member
{
    public UnionMember(TypeCode typecode, String name, List<String> labels, boolean isDefault)
    {
        super(typecode, name);
        m_labels = labels;
        m_default = isDefault;
    }
    
    public List<String> getLabels()
    {
        return m_labels;
    }
    
    public boolean isDefault()
    {
        return m_default;
    }
    
    private List<String> m_labels = null;
    
    private boolean m_default = false;
}
