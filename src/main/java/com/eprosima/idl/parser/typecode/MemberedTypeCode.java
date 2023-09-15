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

package com.eprosima.idl.parser.typecode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.tree.Annotation;

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

    public String getROS2Scopedname()
    {
        if(m_scope.isEmpty())
            return m_name;

        return m_scope + "::dds_::" + m_name + "_";
    }

    public String getCScopedname()
    {
        if(m_scope.isEmpty())
            return m_name;

        return m_scope.replace("::", "_") + "_" + m_name;
    }

    public String getJavaScopedname()
    {
        if(m_scope.isEmpty())
            return m_name;

        return m_scope.replace("::", ".") + "." + m_name;
    }

    public String getJniScopedname()
    {
        if(m_scope.isEmpty())
            return m_name;

        return m_scope.replace("::", "/") + "/" + m_name;
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
    public abstract String getCTypename();

    @Override
    public abstract String getJavaTypename();

    @Override
    public abstract String getIdlTypename();

    @Override
    public boolean isIsPlain()
    {
        if (isAnnotationFinal())
        {
            for (Member member : m_members.values())
            {
                if (!member.isIsPlain())
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean isIsBounded()
    {
        for (Member member : m_members.values())
        {
            if (!member.isIsBounded())
            {
                return false;
            }
        }
        return true;
    }

    public boolean getContainsOptional()
    {
        for (Member member : m_members.values())
        {
            if (member.isAnnotationOptional())
            {
                return true;
            }
        }
        return false;
    }

    protected void check_annotation_for_aggregated_types(
            Annotation annotation)
    {
        if (Annotation.extensibility_str == annotation.getName() ||
                Annotation.final_str == annotation.getName() ||
                Annotation.appendable_str == annotation.getName() ||
                Annotation.mutable_str == annotation.getName())
        {
            if (getAnnotations().containsKey(Annotation.extensibility_str) ||
                    getAnnotations().containsKey(Annotation.final_str) ||
                    getAnnotations().containsKey(Annotation.appendable_str) ||
                    getAnnotations().containsKey(Annotation.mutable_str))
            {
                throw new ParseException(null, "Extensibility was already defined for " + getName());
            }
        }
    }

    private String m_name = null;

    private String m_scope = null;

    private LinkedHashMap<String, Member> m_members = null;
}
