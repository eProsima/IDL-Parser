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

import com.eprosima.idl.parser.exception.RuntimeGenerationException;
import com.eprosima.idl.parser.tree.Annotation;

public class Member extends MemberAppliedAnnotations
{
    public Member()
    {
        super();
    }

    public Member(TypeCode typecode, String name)
    {
        super();
        m_typecode = typecode;
        m_name = name;
    }

    public String getName()
    {
        return m_name;
    }

    public String getJavaName() {
        if (m_name != null) {
            Character firstChar =Character.toUpperCase(m_name.charAt(0));
            String javaName = firstChar.toString();
            if (m_name.length() > 1) {
                javaName += m_name.substring(1);
            }
            return javaName;
        }
        return null;
    }

    /*
     * @brief This function is used with (previous c) types because array names contains [].
     */

    public TypeCode getTypecode()
    {
        return m_typecode;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public void setTypecode(TypeCode typecode)
    {
         m_typecode = typecode;
    }

    public boolean isIsPlain()
    {
        if (m_typecode != null && !isAnnotationOptional())
        {
            return m_typecode.isIsPlain();
        }
        return false;
    }

    public boolean isIsBounded()
    {
        if (m_typecode != null)
        {
            return m_typecode.isIsBounded();
        }
        return false;
    }

    /*!
     * Sets the member's id.
     *
     * This function is intended to be called by MemberTypeCode.
     */
    public void set_id(int id)
    {
        id_ = id;
    }

    /*!
     * Return the MemberId as Integer.
     */
    public int get_id()
    {
        return id_;
    }

    /*!
     * Return the MemberId as String in hexadecimal format.
     */
    public String getId()
    {
        return String.format("0x%08x", id_);
    }

    /*!
     * Sets the order of definition of the member.
     *
     * This function is intended to be called by MemberTypeCode.
     */
    public void set_index(int index)
    {
        index_ = index;
    }

    public int getIndex()
    {
        return index_;
    }

    public boolean isAnnotationId()
    {
        return null != getAnnotations().get(Annotation.id_str);
    }

    public String getAnnotationIdValue() throws RuntimeGenerationException
    {
        Annotation ann = getAnnotations().get(Annotation.id_str);
        if (ann == null)
        {
            throw new RuntimeGenerationException("Error in member " + m_name + ": @" + Annotation.id_str +
                    " annotation not found.");
        }

        return ann.getValue();
    }

    public boolean isAnnotationHashid()
    {
        return null != getAnnotations().get(Annotation.hashid_str);
    }

    public String getAnnotationHashidValue() throws RuntimeGenerationException
    {
        Annotation ann = getAnnotations().get(Annotation.hashid_str);
        if (ann == null)
        {
            throw new RuntimeGenerationException("Error in member " + m_name + ": @" + Annotation.hashid_str +
                    " annotation not found.");
        }

        return ann.getValue();
    }

    private String m_name = null;

    private TypeCode m_typecode = null;

    public static final int MEMBER_ID_INVALID = 0x0FFFFFFF;

    private int id_ = MEMBER_ID_INVALID;

    private int index_ = 0;
}
