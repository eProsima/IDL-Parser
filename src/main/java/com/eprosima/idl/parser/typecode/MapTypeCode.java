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

import org.stringtemplate.v4.ST;
import com.eprosima.idl.parser.tree.Definition;


public class MapTypeCode extends ContainerTypeCode
{
    public MapTypeCode(
            String maxsize,
            String evaluated_maxsize)
    {
        super(Kind.KIND_MAP);
        m_maxsize = maxsize;
        evaluated_maxsize_ = evaluated_maxsize;
    }

    public boolean isIsType_19()
    {
        return true;
    }


    /*!
     * @ingroup api_for_stg
     * @brief This function can be used to check if TypeIdentifier's kind is the small one or the large one.
     * @return @e false if map is unbound or smaller than 256.
     * Otherwise @e true is returned.
     */
    public boolean getIsTypeIdentifierKindLarge()
    {
        if (!isUnbound() && Integer.parseInt(evaluated_maxsize_) >= 256)
        {
            return true;
        }

        return false;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function can be used to retrieve the TypeIdentifier's kind.
     * @return @e TI_PLAIN_MAP_SMALL if map is unbound or smaller than 256.
     * Otherwise @e TI_PLAIN_MAP_LARGE is returned.
     */
    @Override
    public String getTypeIdentifier()
    {
        if (getIsTypeIdentifierKindLarge())
        {
            return "TI_PLAIN_MAP_LARGE";
        }
        return "TI_PLAIN_MAP_SMALL";
    }

    @Override
    public boolean isPlainType()
    {
        return true;
    }

    @Override
    public boolean isIsMapType()
    {
        return true;
    }

    @Override
    public String getCppTypename()
    {
        ST st = getCppTypenameFromStringTemplate();
        st.add("key", getKeyTypeCode().getCppTypename());
        st.add("value", getValueTypeCode().getCppTypename());
        st.add("maxsize", m_maxsize);
        return st.render();
    }

    @Override
    public String getCTypename()
    {
        ST st = getCTypenameFromStringTemplate();
        st.add("key", getKeyTypeCode().getCTypename());
        st.add("value", getValueTypeCode().getCTypename());
        st.add("maxsize", m_maxsize);
        return st.render();
    }

    @Override
    public String getJavaTypename()
    {
        ST st = getJavaTypenameFromStringTemplate();
        st.add("key", getKeyTypeCode().getJavaTypename());
        st.add("value", getValueTypeCode().getJavaTypename());
        st.add("maxsize", m_maxsize);
        return st.render();
    }

    @Override
    public String getIdlTypename()
    {
        ST st = getIdlTypenameFromStringTemplate();
        st.add("key", getKeyTypeCode().getIdlTypename());
        st.add("value", getValueTypeCode().getIdlTypename());
        st.add("maxsize", m_maxsize);
        return st.render();
    }

    @Override
    public String getMaxsize()
    {
        if (m_maxsize == null)
        {
            return default_unbounded_max_size;
        }

        return m_maxsize;
    }

    @Override
    public String getEvaluatedMaxsize()
    {
        if (evaluated_maxsize_ == null)
        {
            return getMaxsize();
        }

        return evaluated_maxsize_;
    }

    public TypeCode getKeyTypeCode()
    {
        return m_keyTypeCode;
    }

    public void setKeyTypeCode(
            TypeCode keyTypeCode)
    {
        m_keyTypeCode = keyTypeCode;
    }

    public TypeCode getValueTypeCode()
    {
        return m_valueTypeCode;
    }

    public void setValueTypeCode(
            TypeCode valueTypeCode)
    {
        m_valueTypeCode = valueTypeCode;
    }

    public Definition getKeyDefinition()
    {
        return m_keyDefinition;
    }

    public void setKeyDefinition(
            Definition keyDefinition)
    {
        m_keyDefinition = keyDefinition;
    }

    public Definition getValueDefinition()
    {
        return m_valueDefinition;
    }

    public void setValueDefinition(
            Definition valueDefinition)
    {
        m_valueDefinition = valueDefinition;
    }

    /**
     * This API is to check if this specific collection has a bound set.
     * It does not check if the complete collection is bounded or not.
     */
    public boolean isUnbound()
    {
        return null == m_maxsize;
    }

    @Override
    public boolean isIsPlain()
    {
        return false;
    }

    /**
     * This API is to check if ultimately the collection element is bounded.
     * In order to check if this specific collection has bounds, please use isUnbound API.
     */
    @Override
    public boolean isIsBounded()
    {
        if (m_maxsize == null)
        {
            return false;
        }

        if (m_keyTypeCode != null && m_valueTypeCode != null)
        {
            return m_keyTypeCode.isIsBounded() && m_valueTypeCode.isIsBounded();
        }
        return false;
    }

    private TypeCode m_keyTypeCode = null;
    private TypeCode m_valueTypeCode = null;
    private Definition m_keyDefinition = null;
    private Definition m_valueDefinition = null;
    private String m_maxsize = null;
    private String evaluated_maxsize_ = null;
}
