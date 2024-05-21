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

    /*!
     * @ingroup api_for_stg
     * @brief This function returns all bitfields including the inherited ones.
     * @return A list of all bitfields.
     */
    public List<Bitfield> getBitfields()
    {
        ArrayList<Bitfield> result = new ArrayList<Bitfield>();
        result.addAll(m_bitfields.values());
        return result;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function returns all bitfields including the inherited ones which were defined by name.
     * @return A list of all bitfields defined by name.
     */
    public List<Bitfield> getDefinedBitfields()
    {
        ArrayList<Bitfield> result = new ArrayList<Bitfield>();
        for (Bitfield bitfield : m_bitfields.values())
        {
            if (bitfield.getIsDefined())
            {
                result.add(bitfield);
            }
        }
        return result;
    }

    public boolean addBitfield(
            Bitfield bitfield)
    {
        if (null == bitfield.getName())
        {
            bitfield.setName("");
        }

        String key = bitfield.getName();

        if (key.isEmpty())
        {
            ++annonymous_index_;
            key = "_annonymous_" + Integer.toString(annonymous_index_);
        }

        if (!m_bitfields.containsKey(key))
        {
            m_bitfields.put(key, bitfield);
            bitfield.setBasePosition(m_current_base);
            m_current_base += bitfield.getSpec().getBitSize();

            if (bitfield.getIsDefined())
            {
                addMember(bitfield);
            }

            return true;
        }
        return false;
    }

    /*!
     * @ingroup api_for_g4
     * @brief This function adds the inherited Bitset to this Bitset instance.
     * Internally add the member from inherited Bitset to this instance, making a plain bitset as defined in IDL to
     * C++11 2021.
     * @param ctx Parser context.
     * @param parent Inherited Bitset
     */
    @Override
    public void addInheritance(
            Context ctx,
            TypeCode parent) throws ParseException
    {
        if (super_type_ == null && parent instanceof BitsetTypeCode)
        {
            enclosed_super_type_ = (BitsetTypeCode)parent;
            super_type_ = parent;
        }
        else if (super_type_ == null && parent instanceof AliasTypeCode)
        {
            AliasTypeCode alias = (AliasTypeCode)parent;
            if (alias.getContentTypeCode() instanceof BitsetTypeCode)
            {
                enclosed_super_type_ = (BitsetTypeCode)alias.getContentTypeCode();
            }
            else
            {
                throw new ParseException(null, "Given alias does not correspond to a bitset");
            }
            super_type_ = parent;
        }
        else if (super_type_ != null)
        {
            throw new ParseException(null, "Only single type inheritance is supported");
        }
        else
        {
            throw new ParseException(null, "Inheritance must correspond to the name of a previously defined bitset");
        }

        //{{{ Add members of inherited Bitset.
        if (null != enclosed_super_type_)
        {
            enclosed_super_type_.m_bitfields.forEach((key, bitfield) ->
            {
                Bitfield new_bitfield = new Bitfield(this, bitfield.getSpec(), bitfield.getName());
                m_bitfields.put(key, bitfield);
                m_current_base += bitfield.getSpec().getBitSize();

                if (bitfield.getIsDefined())
                {
                    addMember(bitfield);
                }
            });
        }
        //}}}
    }

    @Override
    public TypeCode getInheritance()
    {
        return super_type_;
    }

    @Override
    public TypeCode getEnclosedInheritance()
    {
        return enclosed_super_type_;
    }

    public int getBitSize()
    {
        return m_current_base;
    }

    private int annonymous_index_ = 0;
    private BitsetTypeCode enclosed_super_type_ = null;
    private TypeCode super_type_ = null;
    private LinkedHashMap<String, Bitfield> m_bitfields = new LinkedHashMap<String, Bitfield>();
    private int m_current_base = 0;
}
