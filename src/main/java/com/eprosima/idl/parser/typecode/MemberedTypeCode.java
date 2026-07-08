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
<<<<<<< HEAD
        if(m_scope.isEmpty())
=======
        String scoped_name = getFullScopedname();

        if (!ctx.is_enabled_custom_property_in_current_group(ctx.using_explicitly_modules_custom_property))
        {
            return scoped_name;
        }

        String current_scope = ctx.getScope();

        if(current_scope.isEmpty() || !scoped_name.startsWith(current_scope + "::"))
        {
            return scoped_name;
        }

        return scoped_name.replace(current_scope + "::", "");
    }

    /*!
     * @brief Return the scoped name of the type.
     */
    public String getFullScopedname()
    {
        if((m_scope == null) || m_scope.isEmpty())
        {
>>>>>>> 74ea5e2 (Fix handling of null scope and `try_construct` (#196))
            return m_name;

        return m_scope + "::" + m_name;
    }

    public String getROS2Scopedname()
    {
<<<<<<< HEAD
        if(m_scope.isEmpty())
=======
        if((m_scope == null) || m_scope.isEmpty())
        {
>>>>>>> 74ea5e2 (Fix handling of null scope and `try_construct` (#196))
            return m_name;

        return m_scope + "::dds_::" + m_name + "_";
    }

    public String getCScopedname()
    {
<<<<<<< HEAD
        if(m_scope.isEmpty())
=======
        if((m_scope == null) || m_scope.isEmpty())
        {
>>>>>>> 74ea5e2 (Fix handling of null scope and `try_construct` (#196))
            return m_name;

        return m_scope.replace("::", "_") + "_" + m_name;
    }

    public String getJavaScopedname()
    {
<<<<<<< HEAD
        if(m_scope.isEmpty())
=======
        if((m_scope == null) || m_scope.isEmpty())
        {
>>>>>>> 74ea5e2 (Fix handling of null scope and `try_construct` (#196))
            return m_name;

        return m_scope.replace("::", ".") + "." + m_name;
    }

    public String getJniScopedname()
    {
<<<<<<< HEAD
        if(m_scope.isEmpty())
=======
        if((m_scope == null) || m_scope.isEmpty())
        {
>>>>>>> 74ea5e2 (Fix handling of null scope and `try_construct` (#196))
            return m_name;

        return m_scope.replace("::", "/") + "/" + m_name;
    }

    public String getScope()
    {
        return m_scope;
    }

    public boolean getHasScope()
    {
        return (m_scope != null) && !m_scope.isEmpty();
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
        for (Member member : m_members.values())
        {
            if (!member.isIsPlain())
            {
                return false;
            }
        }
        return true;
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

    private String m_name = null;

    private String m_scope = null;

    private LinkedHashMap<String, Member> m_members = null;
}
