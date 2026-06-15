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

import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.typecode.AnyTypeCode;
import com.eprosima.idl.parser.typecode.EnumMember;
import com.eprosima.idl.parser.typecode.EnumTypeCode;
import com.eprosima.idl.parser.typecode.Member;
import com.eprosima.idl.parser.typecode.TypeCode;

import com.eprosima.idl.parser.exception.RuntimeGenerationException;

public class AnnotationMember
{
    public AnnotationMember(String name, TypeCode typecode, String value)
    {
        m_typecode = typecode;
        m_name = name;
        m_value = value;
    }

    public AnnotationMember(AnnotationMember ann)
    {
        m_typecode = ann.m_typecode;
        m_name = ann.m_name;
        m_value = ann.m_value;
    }

    public String getName()
    {
        return m_name;
    }

    /*
     * @brief This function is used with (previous c) types because array names contains [].
     */

    public TypeCode getTypecode()
    {
        return m_typecode;
    }

    public String getNumericValue()
    {
        String value = getValue();

        if (m_typecode.isIsEnumType())
        {
            EnumTypeCode enumTC = (EnumTypeCode)m_typecode;
            int idx = 0;
            for (Member m : enumTC.getMembers())
            {
                String m_str = enumTC.getScopedname() + "::" + m.getName();
                if (m_str.equals(value))
                {
                    return Integer.toString(idx);
                }
                idx++;
            }
        }

        return value;
    }

    public String getValue()
    {
        if (m_typecode.isIsEnumType())
        {
            EnumTypeCode enumTC = (EnumTypeCode)m_typecode;
            String literal_value = "";
            String value = m_value;

            if (null == value)
            {
                value = "";
            }

            if (value.startsWith("\"") && value.endsWith("\""))
            {
                value =  value.substring(1, value.length() - 1);
            }

            for (Member m : enumTC.getMembers())
            {
                if (m.getName().equals(value))
                {
                    return enumTC.getScopedname() + "::" + m.getName();
                }
                else if (m.isAnnotationDefaultLiteral())
                {
                    literal_value = m.getName();
                }
                else if (value.isEmpty())
                {
                    value = m.getName();
                }
            }

            if (!literal_value.isEmpty())
            {
                return enumTC.getScopedname() + "::" + literal_value;
            }

            return enumTC.getScopedname() + "::" + value;
        }
        else if (m_typecode.isIsStringType() || m_typecode.isIsWStringType())
        {
            if (m_value != null)
            {
                if (m_value.startsWith("\"") && m_value.endsWith("\""))
                {
                    return m_value.substring(1, m_value.length() - 1);
                }
            }
            if (m_typecode.isIsWStringType())
            {
                return "L\"\"";
            }
            return "";
        }
        else if (m_typecode.isPrimitiveType())
        {
            if (m_value != null)
            {
                // Check if the string starts with "0x" to determine if it's hexadecimal
                if (m_value.startsWith("0x")) {
                    // If it's hexadecimal, parse it using parseInt with radix 16
                    return Integer.toString(Integer.parseInt(m_value.substring(2), 16));
                }
                else if (m_value.startsWith("0"))
                {
                    return Integer.toString(Integer.parseInt(m_value.substring(1), 8));
                }
                else
                {
                    return m_value;
                }
            }
            return m_typecode.getInitialValue();
        }
        return m_value;
    }

    public String getValueFromAny(TypeCode typecode) throws RuntimeGenerationException
    {
        if (m_typecode instanceof AnyTypeCode)
        {
            if (typecode.isIsEnumType())
            {
                EnumTypeCode enumTC = (EnumTypeCode)typecode;
                String literal_value = "";
                String value = m_value;

                if (null == value)
                {
                    value = "";
                }

                if (value.startsWith("\"") && value.endsWith("\""))
                {
                    value =  value.substring(1, value.length() - 1);
                }
                for (Member m : enumTC.getMembers())
                {
                    if (m.getName().equals(value))
                    {
                        return enumTC.getScopedname() + "::" + m.getName();
                    }
                    else if (m.isAnnotationDefaultLiteral())
                    {
                        literal_value = m.getName();
                    }
                    else if (value.isEmpty())
                    {
                        value = m.getName();
                    }
                }

                if (!literal_value.isEmpty())
                {
                    return enumTC.getScopedname() + "::" + literal_value;
                }

                return enumTC.getScopedname() + "::" + value;
            }
            else if (typecode.isIsStringType() || typecode.isIsWStringType())
            {
                if (m_value != null)
                {
                    if (!m_value.startsWith("\"") && !m_value.endsWith("\""))
                    {
                        return "\"" + m_value + "\"";
                    }
                }
                if (typecode.isIsWStringType())
                {
                    return "L\"\"";
                }
                return "";
            }
            else if (typecode.isPrimitiveType())
            {
                if (m_value != null)
                {
                    // Check if the string starts with "0x" to determine if it's hexadecimal
                    if (m_value.startsWith("0x")) {
                        // If it's hexadecimal, parse it using parseInt with radix 16
                        return Integer.toString(Integer.parseInt(m_value.substring(2), 16));
                    }
                    else if (m_value.startsWith("0"))
                    {
                        return Integer.toString(Integer.parseInt(m_value.substring(1), 8));
                    }
                    else
                    {
                        return m_value;
                    }
                }
                return typecode.getInitialValue();
            }
            return m_value;
        }

        throw new RuntimeGenerationException("Annotation " + m_name + "is not from any type");
    }

    public String getEnumStringValue()
    {
        if (m_value != null && m_typecode.isIsEnumType())
        {
            EnumTypeCode enumTC = (EnumTypeCode)m_typecode;
            for (Member m : enumTC.getMembers())
            {
                String value = m_value;
                if (value.startsWith("\"") && value.endsWith("\""))
                {
                    value = value.substring(1, value.length() - 1);
                }
                String[] value_with_scopes = value.split("::");
                value = value_with_scopes[value_with_scopes.length - 1];
                if (m.getName().equals(value))
                {
                    return value;
                }
            }
            throw new ParseException(null, m_value + " is not a valid label for " + m_name);
        }
        return m_value;
    }

    public void setValue(String value)
    {
        m_value = value;
    }

    public boolean isIsVerbatimPlacement()
    {
        return getName().equals(Annotation.placement_str);
    }

    public boolean isIsVerbatimLanguage()
    {
        return getName().equals(Annotation.language_str);
    }

    public boolean isIsVerbatimText()
    {
        return getName().equals(Annotation.text_str);
    }

    public boolean isIsMax()
    {
        return getName().equals(Annotation.max_str);
    }

    public boolean isIsMin()
    {
        return getName().equals(Annotation.min_str);
    }

    private String m_name = null;

    private TypeCode m_typecode = null;

    private String m_value = null;
}
