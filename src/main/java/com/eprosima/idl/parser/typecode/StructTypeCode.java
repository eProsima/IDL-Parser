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

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.stringtemplate.v4.ST;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.Inherits;



public class StructTypeCode extends MemberedTypeCode implements Inherits
{
    public StructTypeCode(
            String scope,
            String name)
    {
        super(Kind.KIND_STRUCT, scope, name);
        superTypes_ = new ArrayList<StructTypeCode>();
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
    public boolean isIsType_a()
    {
        return true;
    }

    @Override
    public void addInheritance(
            Context ctx,
            TypeCode parent)
    {
        if (parent instanceof StructTypeCode)
        {
            StructTypeCode parent_struct = (StructTypeCode)parent;
            superTypes_.add(parent_struct);
        }
    }

    @Override
    public ArrayList<TypeCode> getInheritances()
    {
        ArrayList<TypeCode> result = new ArrayList<TypeCode>();
        for (StructTypeCode parent : superTypes_)
        {
            result.add(parent);
        }
        return result;
    }

    @Override
    public List<Member> getMembers()
    {
        return getMembers(false);
    }

    public List<Member> getMembers(
            boolean includeParents)
    {
        List<Member> allMembers = new ArrayList<Member>();

        if (includeParents)
        {
            for (StructTypeCode p : superTypes_)
            {
                allMembers.addAll(p.getAllMembers());
            }
        }

        allMembers.addAll(super.getMembers());
        return allMembers;
    }

    public List<Member> getAllMembers() // Alias for getMembers(true) for stg
    {
        return getMembers(true);
    }

    public List<Map.Entry<Integer, Member>> getAllIdentifiedMembers()
    {
        int seq_id = 0;
        List<Map.Entry<Integer, Member>> ret_members = new ArrayList<Map.Entry<Integer,Member>>();

        for (StructTypeCode p : superTypes_)
        {
            for (Member m : p.getAllMembers())
            {
                ret_members.add(new AbstractMap.SimpleEntry<>(seq_id++, m));
            }
        }

        for (Member m : getMembers())
        {
            ret_members.add(new AbstractMap.SimpleEntry<>(seq_id++, m));
        }

        return ret_members;
    }

    @Override
    public boolean isIsPlain()
    {
        for (StructTypeCode parent : superTypes_)
        {
            if (!parent.isIsPlain())
            {
                return false;
            }
        }
        return super.isIsPlain();
    }

    @Override
    public boolean isIsBounded()
    {
        for (StructTypeCode parent : superTypes_)
        {
            if (!parent.isIsBounded())
            {
                return false;
            }
        }
        return super.isIsBounded();
    }

    @Override
    public void addAnnotation(
            Context ctx,
            Annotation annotation)
    {
        // Checks
        check_annotation_for_aggregated_types(annotation);

        super.addAnnotation(ctx, annotation);
    }

    private ArrayList<StructTypeCode> superTypes_;
}
