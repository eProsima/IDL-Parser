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

import org.stringtemplate.v4.ST;


public class EnumTypeCode extends MemberedTypeCode
{
    public EnumTypeCode(
            String scope,
            String name)
    {
        super(Kind.KIND_ENUM, scope, name);
    }

    @Override
    public boolean isPrimitive()
    {
        return true;
    }

    @Override
    public boolean isIsType_c()
    {
        return true;
    }

    @Override
    public boolean isIsEnumType()
    {
        return true;
    }

    @Override
    public String getTypeIdentifier()
    {
        return "EK_MINIMAL";
    }

    @Override
    public boolean isObjectType()
    {
        return true;
    }

    public void addMember(
            EnumMember member)
    {
        addMember((Member)member);
    }

    @Override
    public String getCppTypename()
    {
        ST st = getCppTypenameFromStringTemplate();
        st.add("name", getScopedname());
        return st.render();
    }

    @Override
    public String getCTypename()
    {
        ST st = getCTypenameFromStringTemplate();
        st.add("name", getCScopedname());
        return st.render();
    }

    @Override
    public String getJavaTypename()
    {
        ST st = getJavaTypenameFromStringTemplate();
        st.add("name", getJavaScopedname());
        return st.render();
    }

    @Override
    public String getIdlTypename()
    {
        ST st = getIdlTypenameFromStringTemplate();
        st.add("name", getScopedname());
        return st.render();
    }

    @Override
    public String getInitialValue()
    {
        if (getMembers().size() > 0)
        {
            return getScopedname() + "::" + getMembers().get(0).getName();
        }

        return "";
    }

    @Override
    public String getJavaInitialValue()
    {
        if (getMembers().size() > 0)
        {
            return javapackage + getJavaScopedname() + "." + getMembers().get(0).getName();
        }

        return "";
    }

    @Override
    public String getSize()
    {
        return "4";
    }

    @Override
    public boolean isIsBounded()
    {
        return true;
    }

    @Override
    public boolean isIsPlain()
    {
        return true;
    }
    
    public int getBitBound()
    {
        // TODO: pending @bit_bound annotation application to enum types
        return 32;
    }

}
