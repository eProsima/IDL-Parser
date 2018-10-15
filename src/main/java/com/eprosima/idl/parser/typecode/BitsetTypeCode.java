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

import com.eprosima.idl.util.Pair;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.antlr.stringtemplate.StringTemplate;

public class BitsetTypeCode extends MemberedTypeCode
{
    public BitsetTypeCode(String scope, String name)
    {
        super(TypeCode.Kind.KIND_BITSET, scope, name);
        m_bitfields = new LinkedHashMap<String, Bitfield>();
    }

    @Override
    public String getCppTypename()
    {
        StringTemplate st = getCppTypenameFromStringTemplate();
        st.setAttribute("name", getScopedname());
        return st.toString();
    }

    @Override
    public String getCTypename()
    {
        StringTemplate st = getCTypenameFromStringTemplate();
        st.setAttribute("name", getCScopedname());
        return st.toString();
    }

    @Override
    public String getJavaTypename()
    {
        StringTemplate st = getJavaTypenameFromStringTemplate();
        st.setAttribute("name", getJavaScopedname());
        return st.toString();
    }

    @Override
    public String getIdlTypename()
    {
        StringTemplate st = getIdlTypenameFromStringTemplate();
        st.setAttribute("name", getScopedname());
        return st.toString();
    }

    public List<Bitfield> getBitfields()
    {
        return new ArrayList<Bitfield>(m_bitfields.values());
    }

    public boolean addBitfield(Bitfield bitfield)
    {
        if(!m_bitfields.containsKey(bitfield.getName()))
        {
            m_bitfields.put(bitfield.getName(), bitfield);
            bitfield.setBasePosition(m_current_base);
            m_current_base += ((BitfieldSpec)bitfield.getTypecode()).getBitSize();
            return true;
        }
        return false;
    }

    public void setParent(BitsetTypeCode parent)
    {
        m_parent = parent;
    }

    public BitsetTypeCode getParent()
    {
        return m_parent;
    }

    public int getBitSize()
    {
        int size = 0;
        for (Bitfield bf : m_bitfields.values())
        {
            size += ((BitfieldSpec)bf.getTypecode()).getBitSize();
        }
        return size;
    }

    private BitsetTypeCode m_parent = null;
    private LinkedHashMap<String, Bitfield> m_bitfields = null;
    private int m_current_base = 0;
}
