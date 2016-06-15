package com.eprosima.idl.parser.typecode;

import java.util.List;

public class UnionMember extends Member
{
    public UnionMember(TypeCode typecode, String name, List<String> labels, boolean isDefault)
    {
        super(typecode, name);
        m_internallabels = labels;
        m_default = isDefault;
    }
    
    public List<String> getInternalLabels()
    {
        return m_internallabels;
    }

    public List<String> getLabels()
    {
        return m_labels;
    }

    public void setLabels(List<String> labels)
    {
        m_labels = labels;
    }

    public List<String> getJavaLabels()
    {
        return m_javalabels;
    }

    public void setJavaLabels(List<String> labels)
    {
        m_javalabels = labels;
    }
    
    public boolean isDefault()
    {
        return m_default;
    }
    
    private List<String> m_internallabels = null;
    private List<String> m_labels = null;
    private List<String> m_javalabels = null;
    
    private boolean m_default = false;
}
