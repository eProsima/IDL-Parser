package com.eprosima.idl.parser.tree;

import java.util.HashMap;

public class Annotation
{
    public Annotation(AnnotationDeclaration declaration)
    {
        m_declaration = declaration;
        m_members = new HashMap<String, AnnotationMember>();

        for(AnnotationMember ann : declaration.getMembers())
        {
            AnnotationMember member = new AnnotationMember(ann);
            m_members.put(member.getName(), member);
        }
    }

    public String getName()
    {
        if(m_declaration != null)
        {
            return m_declaration.getName();
        }

        return null;
    }

    public boolean addValue(String value)
    {
        if(m_members.size() != 1)
            return false;

        ((AnnotationMember)m_members.values().toArray()[0]).setValue(value);

        return true;
    }

    public boolean addValue(String attribute, String value)
    {
        AnnotationMember member = m_members.get(attribute);

        if(member != null)
        {
            member.setValue(value);
        }
        else
            return false;

        return true;
    }

    public String getValue(String attribute)
    {
        return m_members.get(attribute).getValue();
    }

    private HashMap<String, AnnotationMember> m_members = null;
    private AnnotationDeclaration m_declaration = null;
}
