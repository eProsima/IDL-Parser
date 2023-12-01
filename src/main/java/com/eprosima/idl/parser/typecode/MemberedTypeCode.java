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

    /*!
     * @brief Returns the full scoped name of the type, unless the developer uses
     * `TemplateSTGroup.enable_custom_proeprty("using_explicitly_modules")`, by removing from the full scoped name the
     * current `Context` scope.
     */
    public String getScopedname()
    {
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
        if(m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope + "::" + m_name;
    }

    public String getROS2Scopedname()
    {
        if(m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope + "::dds_::" + m_name + "_";
    }

    public String getCScopedname()
    {
        if(m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope.replace("::", "_") + "_" + m_name;
    }

    public String getJavaScopedname()
    {
        if(m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope.replace("::", ".") + "." + m_name;
    }

    public String getJniScopedname()
    {
        if(m_scope.isEmpty())
        {
            return m_name;
        }

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

    public boolean addMember(Member member) throws ParseException
    {
        // Check annotations.
        if (member.isAnnotationOptional() && Kind.KIND_STRUCT != getKind())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @" + Annotation.optional_str +" annotations only supported for structure's members.");
        }
        if (member.isAnnotationExternal() && (
                    Kind.KIND_STRUCT != getKind() && Kind.KIND_UNION != getKind()))
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @" + Annotation.external_str + " annotations only supported for structure's members or union's members.");
        }
        if (member.isAnnotationMustUnderstand() && Kind.KIND_STRUCT != getKind())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @must_understand annotations only supported for structure's members.");
        }
        if (member.isAnnotationNonSerialized() && Kind.KIND_STRUCT != getKind())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @non_serialized annotations only supported for structure's members.");
        }
        if (member.isAnnotationKey() && Kind.KIND_STRUCT != getKind())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @key annotations only supported for structure's members.");
        }
        if (null != member.getAnnotationBitBound() && (
                    Kind.KIND_ENUM != getKind() && Kind.KIND_BITMASK != getKind()))
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @bit_bound annotations only supported for enumeration's members or bitmask's members.");
        }
        if (member.isAnnotationDefaultLiteral() && Kind.KIND_ENUM != getKind())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @default_literal annotations only supported for enumeration's members.");
        }
        if (null != member.getAnnotationValue() && Kind.KIND_ENUM != getKind())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @value annotations only supported for enumeration's members.");
        }
        if (null != member.getAnnotationPosition() && Kind.KIND_BITMASK != getKind())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @position annotations only supported for bitmask's members.");
        }
        if(member.isAnnotationKey() && member.isAnnotationNonSerialized())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @key and @non_serialized annotations are incompatible.");
        }
        if(member.isAnnotationKey() && member.isAnnotationOptional())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @key and @" + Annotation.optional_str + " annotations are incompatible.");
        }

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

    public boolean getContainsExternal()
    {
        for (Member member : m_members.values())
        {
            if (member.isAnnotationExternal())
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
