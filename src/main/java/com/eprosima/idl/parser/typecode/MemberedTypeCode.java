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

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.LinkedHashMap;
import java.util.List;

import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.exception.RuntimeGenerationException;
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

    public boolean addMember(
            Member member) throws ParseException
    {
        // Check annotations.
        if (member.isAnnotationOptional() && Kind.KIND_STRUCT != getKind())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @optional annotations only supported for structure's members.");
        }
        if (member.isAnnotationExternal() && (
                    Kind.KIND_STRUCT != getKind() && Kind.KIND_UNION != getKind()))
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @external annotations only supported for structure's members or union's members.");
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
                    ": @" + Annotation.key_str + " annotations only supported for structure's members (Union discriminator still pending implementation).");
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
                    ": @" + Annotation.key_str + " and @non_serialized annotations are incompatible.");
        }
        if(member.isAnnotationKey() && member.isAnnotationOptional())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @" + Annotation.key_str + " and @optional annotations are incompatible.");
        }
        if (member.isAnnotationId() && (
                    Kind.KIND_STRUCT != getKind() && Kind.KIND_UNION != getKind()))
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @" + Annotation.id_str +
                    " annotations only supported for structure's members or union's members.");
        }
        if (member.isAnnotationHashid() && (
                    Kind.KIND_STRUCT != getKind() && Kind.KIND_UNION != getKind()))
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @" + Annotation.hashid_str +
                     "annotations only supported for structure's members or union's members.");
        }
        if (member.isAnnotationId() && member.isAnnotationHashid())
        {
            throw new ParseException(null, "Error in member " + member.getName() +
                    ": @" + Annotation.id_str + " and @" + Annotation.hashid_str + " annotations cannot be together.");
        }

        if(!m_members.containsKey(member.getName()))
        {
            if (Member.MEMBER_ID_INVALID != member.get_id() && !check_unique_member_id(member))
            {
                throw new ParseException(null, member.getName() + " has a MemberId already in use.");
            }
            member.set_index(last_index_++);
            last_id_ = member.get_id();
            m_members.put(member.getName(), member);
            return true;
        }

        return false;
    }

    /*!
     * This function calculates the MemberId for the given member.
     * Derived classes can use this function but it must be called from an override addMember().
     */
    protected void calculate_member_id_(
            Member member)
    {
        Function<String, Integer> calculate_hash = (String member_name) ->
        {
            int hash_id = 0;
            try {
                byte[] bytes = member_name.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] md5 = md.digest(bytes);
                hash_id = ((md5[3] & 0xFF) << 24) + ((md5[2] & 0xFF) << 16) + ((md5[1] & 0xFF) << 8) + (md5[0] & 0xFF);
                hash_id &= 0x0FFFFFFF;
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return hash_id;
        };

        try
        {
            if (member.isAnnotationId())
            {
                member.set_id(Integer.parseInt(member.getAnnotationIdValue()));
            }
            else if (member.isAnnotationHashid())
            {
                String value = member.getAnnotationHashidValue();
                member.set_id(calculate_hash.apply(value.isEmpty() ? member.getName() : value));
            }
            else if (!isAnnotationAutoid() || getAnnotationAutoidValue().equals(Annotation.autoid_sequential_value_str))
            {
                member.set_id(++last_id_);
            }
            else
            {
                member.set_id(calculate_hash.apply(member.getName()));
            }
        }
        catch (RuntimeGenerationException ex)
        {
            // Should be never called because was previously called isAnnotationId() or similar.
        }
    }

    /*!
     * This function checks there is no other member with same id.
     */
    protected boolean check_unique_member_id(
            Member member)
    {
        for(Member m : m_members.values())
        {
            if (m.get_id() == member.get_id())
            {
                return false;
            }
        }

        return true;
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

    public boolean isAnnotationAutoid()
    {
        return null != getAnnotations().get(Annotation.autoid_str);
    }

    public String getAnnotationAutoidValue() throws RuntimeGenerationException
    {
        Annotation ann = getAnnotations().get(Annotation.autoid_str);
        if (ann == null)
        {
            throw new RuntimeGenerationException("Error in member " + m_name + ": @" + Annotation.autoid_str +
                    " annotation not found.");
        }

        return ann.getValue();
    }

    private String m_name = null;

    private String m_scope = null;

    private LinkedHashMap<String, Member> m_members = null;

    protected int last_index_ = 0;

    protected int last_id_ = -1;
}
