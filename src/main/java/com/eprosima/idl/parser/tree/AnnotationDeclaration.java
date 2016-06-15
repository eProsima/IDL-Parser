// Copyright 2016 Proyectos y Sistemas de Mantenimiento SL (eProsima).
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.eprosima.idl.parser.tree;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.typecode.TypeCode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import org.antlr.v4.runtime.Token;

public class AnnotationDeclaration extends TreeNode implements Definition
{
    public AnnotationDeclaration(String scopeFile, boolean isInScope, String scope, String name, Token token)
    {
        super(scopeFile, isInScope, scope, name, token);
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
