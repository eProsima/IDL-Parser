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
import org.stringtemplate.v4.ST;


public class StringTypeCode extends TypeCode
{
    public StringTypeCode(
            int kind,
            String maxsize,
            String evaluated_maxsize)
    {
        super(kind);
        m_maxsize = maxsize;
        evaluated_maxsize_ = evaluated_maxsize;
    }

    @Override
    public boolean isIsType_d()
    {
        return true;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function can be used to check if TypeIdentifier's kind is the small one or the large one.
     * @return @e false if string is unbound or smaller than 256.
     * Otherwise @e true is returned.
     */
    public boolean getIsTypeIdentifierKindLarge()
    {
        if (isIsBounded() && Integer.parseInt(evaluated_maxsize_) >= 256)
        {
            return true;
        }

        return false;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function can be used to retrieve the TypeIdentifier's kind.
     * @return @e TI_STRING8_SMALL or TI_STRING16_SMALL if string is unbound or smaller than 256.
     * Otherwise @e TI_STRING8_LARGE or TI_STRING16_LARGE is returned.
     */
    @Override
    public String getTypeIdentifier()
    {
        switch (getKind())
        {
            case Kind.KIND_STRING:
                if (getIsTypeIdentifierKindLarge())
                {
                    return "TI_STRING8_LARGE";
                }
                else
                {
                    return "TI_STRING8_SMALL";
                }
            case Kind.KIND_WSTRING:
                if (getIsTypeIdentifierKindLarge())
                {
                    return "TI_STRING16_LARGE";
                }
                else
                {
                    return "TI_STRING16_SMALL";
                }
            default:
                return "TK_None";
        }
    }

    @Override
    public boolean isPlainType()
    {
        return true;
    }

    @Override
    public boolean isIsStringType()
    {
        return getKind() == Kind.KIND_STRING;
    }

    @Override
    public boolean isIsWStringType()
    {
        return getKind() == Kind.KIND_WSTRING;
    }

    @Override
    public String getCppTypename()
    {
        ST st = getCppTypenameFromStringTemplate();
        st.add("max_size", m_maxsize);
        return st.render();
    }

    @Override
    public String getCTypename()
    {
        ST st = getCTypenameFromStringTemplate();
        st.add("maxsize", getMaxsize());
        return st.render();
    }

    @Override
    public String getJavaTypename()
    {
        return getJavaTypenameFromStringTemplate().toString();
    }

    @Override
    public String getIdlTypename()
    {
        return getIdlTypenameFromStringTemplate().toString();
    }

    @Override
    public String getMaxsize()
    {
        if (m_maxsize == null)
        {
            return "255";
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

    @Override
    public boolean isIsPlain()
    {
        return false;
    }

    @Override
    public boolean isIsBounded()
    {
        return (m_maxsize != null);
    }

    private String m_maxsize = null;
    private String evaluated_maxsize_ = null;
}
