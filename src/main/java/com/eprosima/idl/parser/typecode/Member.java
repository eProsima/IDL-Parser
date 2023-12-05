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
import com.eprosima.idl.parser.tree.Notebook;
import com.eprosima.idl.context.Context;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class Member implements Notebook
{
    public Member()
    {
        m_annotations = new HashMap<String, Annotation>();
    }

    public Member(TypeCode typecode, String name)
    {
        m_typecode = typecode;
        m_name = name;
        m_annotations = new HashMap<String, Annotation>();
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

    @Override
    public void addAnnotation(Context ctx, Annotation annotation)
    {
        if(annotation != null)
        {
            m_annotations.put(annotation.getName(), annotation);
        }
    }

    @Override
    public Map<String, Annotation> getAnnotations()
    {
        return m_annotations;
    }

    public Collection<Annotation> getAnnotationList()
    {
        return m_annotations.values();
    }

    public boolean isAnnotationOptional()
    {
        Annotation ann = m_annotations.get("optional");
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public boolean isAnnotationExternal()
    {
        Annotation ann = m_annotations.get("external");
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public boolean isAnnotationMustUnderstand()
    {
        Annotation ann = m_annotations.get("must_understand");
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public boolean isAnnotationNonSerialized()
    {
        Annotation ann = m_annotations.get("non_serialized");
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public boolean isAnnotationKey()
    {
        Annotation ann = m_annotations.get("key");
        if (ann == null)
        {
            ann = m_annotations.get("Key"); // Try old way
        }
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public Short getAnnotationBitBound()
    {
        Annotation ann = m_annotations.get("bit_bound");
        if (ann != null)
        {
            String value = ann.getValue();
            if (value.equals("-1"))
            {
                return null;
            }
            return Short.parseShort(value);
        }
        return null;
    }

    public boolean isAnnotationDefaultLiteral()
    {
        return m_annotations.get("default_literal") != null;
    }

    public String getAnnotationValue()
    {
        Annotation ann = m_annotations.get("value");
        if (ann != null)
        {
            return ann.getValue();
        }
        return null;
    }

    public Short getAnnotationPosition()
    {
        Annotation ann = m_annotations.get("position");
        if (ann != null)
        {
            String value = ann.getValue();
            if (value.equals("-1"))
            {
                return null;
            }
            return Short.parseShort(value);
        }
        return null;
    }

    public boolean isAnnotationDefault()
    {
        return m_annotations.get("default") != null;
    }

    public String getAnnotationDefaultValue()
    {
        Annotation ann = m_annotations.get("default");
        if (ann != null)
        {
            return ann.getValue();
        }
        return "";
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

    public boolean isAnnotationId()
    {
        return null != m_annotations.get(Annotation.id_str);
    }

    public String getAnnotationIdValue() throws RuntimeGenerationException
    {
        Annotation ann = m_annotations.get(Annotation.id_str);
        if (ann == null)
        {
            throw new RuntimeGenerationException("Error in member " + m_name + ": @" + Annotation.id_str +
                    " annotation not found.");
        }

        return ann.getValue();
    }

    public boolean isAnnotationHashid()
    {
        return null != m_annotations.get(Annotation.hashid_str);
    }

    public String getAnnotationHashidValue() throws RuntimeGenerationException
    {
        Annotation ann = m_annotations.get(Annotation.hashid_str);
        if (ann == null)
        {
            throw new RuntimeGenerationException("Error in member " + m_name + ": @" + Annotation.hashid_str +
                    " annotation not found.");
        }

        return ann.getValue();
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

    private String m_name = null;

    private TypeCode m_typecode = null;

    private HashMap<String, Annotation> m_annotations = null;

    public static final int MEMBER_ID_INVALID = 0x0FFFFFFF;

    private int id_ = MEMBER_ID_INVALID;

    private int index_ = 0;
}
