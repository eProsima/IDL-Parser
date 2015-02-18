package com.eprosima.idl.parser.typecode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class MemberedTypeCode extends TypeCode
{    
    protected MemberedTypeCode(int kind, String scope, String name)
    {
        super(kind);
        m_scope = scope;
        m_name = name;
        m_members = new LinkedHashMap<String, Member>();
    }
    
    public String getName()
    {
        return m_name;
    }
    
    public String getScopedname()
    {
        if(m_scope.isEmpty())
            return m_name;

        return m_scope + "::" + m_name;
    }

    public String getJavaScopedname()
    {
        if(m_scope.isEmpty())
            return m_name;

        return m_scope + "." + m_name;
    }

    public String getScope()
    {
        return m_scope;
    }

    public boolean getHasScope()
    {
        return !m_scope.isEmpty();
    }
    
    public List<Member> getMembers()
    {
        return new ArrayList<Member>(m_members.values());
    }
    
    public boolean addMember(Member member)
    {
        if(!m_members.containsKey(member.getName()))
        {
            m_members.put(member.getName(), member);
            return true;
        }
        return false;
    }
    
    @Override
    public abstract String getCppTypename();

    @Override
    public abstract String getJavaTypename();
    
    @Override
    public abstract String getIdlTypename();
    
    private String m_name = null;
    
    private String m_scope = null;
    
    private LinkedHashMap<String, Member> m_members = null;
}
