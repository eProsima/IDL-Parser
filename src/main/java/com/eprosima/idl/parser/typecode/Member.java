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

<<<<<<< HEAD
public class Member extends MemberAppliedAnnotations
=======
import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.exception.RuntimeGenerationException;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.Notebook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Member implements Notebook
>>>>>>> a2e4485 (Refs #19595: try_construct annotation implementation)
{
    public enum TryConstructFailAction
    {
        INVALID(0),
        DISCARD(1),
        USE_DEFAULT(2),
        TRIM(3);

        private int value_ = 0;

        private TryConstructFailAction(int value)
        {
            value_ = value;
        }

        public int get_value()
        {
            return value_;
        }
    };

    public static TryConstructFailAction default_try_construct = TryConstructFailAction.DISCARD;

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

    public void setId(int id)
    {
        id_ = id;
    }

    public int getId()
    {
        return id_;
    }

    private String m_name = null;

    private TypeCode m_typecode = null;

    private int id_ = 0xFFFFFFF; // MEMBER_ID_INVALID

    private TryConstructFailAction try_construct_ = TryConstructFailAction.INVALID;
}
