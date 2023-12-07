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
import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.Inherits;



public class StructTypeCode extends MemberedTypeCode implements Inherits
{
    public StructTypeCode(
            String scope,
            String name)
    {
        super(Kind.KIND_STRUCT, scope, name);
        super_type_ = null;
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
            TypeCode parent) throws ParseException
    {
        if (super_type_ == null && parent instanceof StructTypeCode)
        {
            StructTypeCode parent_struct = (StructTypeCode)parent;
            super_type_ = parent_struct;
        }
        else if (super_type_ == null && parent instanceof AliasTypeCode)
        {
            AliasTypeCode alias = (AliasTypeCode)parent;
            if (alias.getContentTypeCode() instanceof StructTypeCode)
            {
                StructTypeCode parent_struct = (StructTypeCode)alias.getContentTypeCode();
                super_type_ = parent_struct;
            }
            else
            {
                throw new ParseException(null, "Given alias does not correspond to a structure");
            }
        }
        else if (super_type_ != null)
        {
            throw new ParseException(null, "Only single type inheritance is supported");
        }
        else
        {
            throw new ParseException(null, "Inheritance must correspond to the name of a previously defined structure");
        }


        last_id_ = super_type_.last_id_;
        last_index_ = super_type_.last_index_;
        if (get_extensibility(super_type_.get_extensibility()) != super_type_.get_extensibility())
        {
            throw new ParseException(null, "Base structure and derived structure must have same " +
                    Annotation.extensibility_enum_str);
        }
    }

    @Override
    public TypeCode getInheritance()
    {
        return super_type_;
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

        if (includeParents && super_type_ != null)
        {
            allMembers.addAll(super_type_.getAllMembers());
        }

        allMembers.addAll(super.getMembers());
        return allMembers;
    }

    public List<Member> getAllMembers() // Alias for getMembers(true) for stg
    {
        return getMembers(true);
    }

    @Override
    public boolean isIsPlain()
    {
        boolean returned_value = true;

        if (!detect_recursive_)
        {
            detect_recursive_ = true;
            if (super_type_ != null)
            {
                returned_value &= super_type_.isIsPlain();
            }
            returned_value &= super.isIsPlain();
            detect_recursive_ = false;
        }
        else
        {
            returned_value = false;
        }

        return returned_value;
    }

    @Override
    public boolean isIsBounded()
    {
        boolean returned_value = true;

        if (!detect_recursive_)
        {
            detect_recursive_ = true;
            if (super_type_ != null)
            {
                returned_value &= super_type_.isIsBounded();
            }
            returned_value &= super.isIsBounded();
            detect_recursive_ = false;
        }
        else
        {
            returned_value = false;
        }

        return returned_value;
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

    @Override
    public boolean addMember(
            Member member) throws ParseException
    {
        if (member.isAnnotationKey() && null != super_type_)
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @" + Annotation.key_str + " cannot be used in a derived structure.");
        }
        calculate_member_id_(member);
        return super.addMember(member);
    }

    @Override
    protected boolean check_unique_member_id(
            Member member)
    {
        if (null != super_type_)
        {
            for (Member m : super_type_.getAllMembers())
            {
                if (m.get_id() == member.get_id())
                {
                    return false;
                }
            }
        }

        for (Member m : getMembers())
        {
            if (m.get_id() == member.get_id())
            {
                return false;
            }
        }

        return true;
    }

    private StructTypeCode super_type_;

    protected boolean detect_recursive_ = false;
}
