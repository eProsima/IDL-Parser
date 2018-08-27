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

public class BitfieldTypeCode extends TypeCode
{
    public BitfieldTypeCode(String scope, String bitsize, TypeCode type)
    {
        super(KIND_BITFIELD);
        m_scope = scope;
        if (type == null)
        {
            int size = Integer.parseInt(bitsize);
            if (size == 1)
            {
                m_type = new PrimitiveTypeCode(KIND_BOOLEAN);
            }
            else if (size <= 8)
            {
                m_type = new PrimitiveTypeCode(KIND_CHAR);
            }
            else if (size <= 16)
            {
                m_type = new PrimitiveTypeCode(KIND_USHORT);
            }
            else if (size <= 32)
            {
                m_type = new PrimitiveTypeCode(KIND_ULONG);
            }
            else if (size <= 64)
            {
                m_type = new PrimitiveTypeCode(KIND_ULONGLONG);
            }
        }
        else
        {
            m_type = type;
        }
        m_bitsize = bitsize;
    }

    public String getScope()
    {
        return m_scope;
    }

    public boolean getHasScope()
    {
        return !m_scope.isEmpty();
    }

    @Override
    public String getCppTypename()
    {
        return m_type.getCppTypename();
    }

    @Override
    public String getCTypename()
    {
        return m_type.getCTypename();
    }

    @Override
    public String getJavaTypename()
    {
        return m_type.getJavaTypename();
    }

    @Override
    public String getIdlTypename() // TODO al template?
    {
        if (m_type == null)
        {
            return "bitfield <" + m_bitsize + ">";
        }
        else
        {
            return "bitfield <" + m_bitsize + ", " + m_type.getIdlTypename() + ">";
        }
    }

    @Override
    public boolean isPrimitive()
    {
        return true; // Use it as alias of m_type
    }

    public int getBitSize()
    {
        if (m_bitsize == null) return 0;
        return Integer.parseInt(m_bitsize);
    }

    @Override
    public String getSize()
    {
        return (m_type != null) ? m_type.getSize() : "0";
    }

    public TypeCode getTypecode()
    {
        return m_type;
    }

    @Override
    public String getInitialValue()
    {
        return m_type.getInitialValue();
    }

    private TypeCode m_type = null;

    private String m_scope = null;

    private String m_bitsize = null;
}
