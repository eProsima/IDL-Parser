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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.stringtemplate.v4.ST;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.tree.Inherits;


public class BitsetTypeCode extends MemberedTypeCode implements Inherits
{
    public BitsetTypeCode(
            String scope,
            String name)
    {
        super(Kind.KIND_BITSET, scope, name);
        m_bitfields = new LinkedHashMap<String, Bitfield>();
        super_type_ = null;
    }

    @Override
    public boolean isIsBitsetType()
    {
        return true;
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

    public List<Bitfield> getBitfields()
    {
        return getBitfields(false);
    }

    public List<Bitfield> getBitfields(
            boolean includeParents)
    {
        ArrayList<Bitfield> result = new ArrayList<Bitfield>();

        if (includeParents && super_type_ != null)
        {
            result.addAll(super_type_.getAllBitfields());
        }

        result.addAll(m_bitfields.values());
        return result;
    }

    public List<Bitfield> getAllBitfields() // Alias for getBitfields(true) for stg
    {
        return getBitfields(true);
    }

    public boolean addBitfield(
            Bitfield bitfield)
    {
        if (!m_bitfields.containsKey(bitfield.getName()))
        {
            m_bitfields.put(bitfield.getName(), bitfield);
            bitfield.setBasePosition(m_current_base);
            m_current_base += bitfield.getSpec().getBitSize();
            return true;
        }
        return false;
    }

    @Override
    public void addInheritance(
            Context ctx,
            TypeCode parent) throws ParseException
    {
        if (super_type_ == null && parent instanceof BitsetTypeCode)
        {
            BitsetTypeCode parent_bitset = (BitsetTypeCode)parent;
            super_type_ = parent_bitset;
        }
        else if (super_type_ == null && parent instanceof AliasTypeCode)
        {
            AliasTypeCode alias = (AliasTypeCode)parent;
            if (alias.getContentTypeCode() instanceof BitsetTypeCode)
            {
                BitsetTypeCode parent_bitset = (BitsetTypeCode)alias.getContentTypeCode();
                super_type_ = parent_bitset;
            }
            else
            {
                throw new ParseException(null, "Given alias does not correspond to a bitset");
            }
        }
        else if (super_type_ != null)
        {
            throw new ParseException(null, "Only single type inheritance is supported");
        }
        else
        {
            throw new ParseException(null, "Inheritance must correspond to the name of a previously defined bitset");
        }
    }

    @Override
    public TypeCode getInheritance()
    {
        return super_type_;
    }

    public int getBitSize()
    {
        int size = 0;

        for (Bitfield bf : m_bitfields.values())
        {
            size += bf.getSpec().getBitSize();
        }
        return size;
    }

    public int getFullBitSize()
    {
        int size = 0;

        if (super_type_ != null)
        {
            size += super_type_.getFullBitSize();
        }

        for (Bitfield bf : m_bitfields.values())
        {
            size += bf.getSpec().getBitSize();
        }
        return size;
    }

    private BitsetTypeCode super_type_ = null;
    private LinkedHashMap<String, Bitfield> m_bitfields = null;
    private int m_current_base = 0;
}
