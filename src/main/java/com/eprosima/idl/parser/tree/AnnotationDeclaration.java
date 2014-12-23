package com.eprosima.idl.parser.tree;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.typecode.TypeCode;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class AnnotationDeclaration extends TreeNode implements Definition
{
    public AnnotationDeclaration(String scopeFile, boolean isInScope, String scope, String name)
    {
        super(scopeFile, isInScope, scope, name);
        m_members = new HashMap<String, AnnotationMember>();
    }

    public List<AnnotationMember> getMembers()
    {
        return new ArrayList<AnnotationMember>(m_members.values());
    }

    public void addMembers(AnnotationDeclaration annotation)
    {
        m_members.putAll(annotation.m_members);
    }

    public boolean addMember(AnnotationMember member)
    {
        if(!m_members.containsKey(member.getName()))
        {
            m_members.put(member.getName(), member);
            return true;
        }

        return false;
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
        return false;
    }
	
	@Override
	public boolean isIsAnnotation()
    {
        return true;
    }
        
    private Object m_parent = null;
    private HashMap<String, AnnotationMember> m_members = null;
}
