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

import org.antlr.stringtemplate.StringTemplate;


public class SetTypeCode extends ContainerTypeCode
{
    public SetTypeCode(
            String maxsize)
    {
        super(Kind.KIND_SET);
        m_maxsize = maxsize;
    }

    @Override
    public boolean isIsType_e()
    {
        return true;
    }

    @Override
    public String getTypeIdentifier()
    {
        return "TI_PLAIN_SEQUENCE_SMALL";
    }

    @Override
    public boolean isPlainType()
    {
        return true;
    }

    @Override
    public boolean isIsSetType()
    {
        return true;
    }

    @Override
    public String getCppTypename()
    {
        StringTemplate st = getCppTypenameFromStringTemplate();
        st.setAttribute("type", getContentTypeCode().getCppTypename());
        st.setAttribute("maxsize", m_maxsize);
        return st.toString();
    }

    @Override
    public String getCTypename()
    {
        StringTemplate st = getCTypenameFromStringTemplate();
        st.setAttribute("type", getContentTypeCode().getCTypename());
        st.setAttribute("maxsize", m_maxsize);
        return st.toString();
    }

    @Override
    public String getJavaTypename()
    {
        StringTemplate st = getJavaTypenameFromStringTemplate();
        st.setAttribute("type", getContentTypeCode().getJavaTypename());
        st.setAttribute("maxsize", m_maxsize);
        return st.toString();
    }

    @Override
    public String getIdlTypename()
    {
        StringTemplate st = getIdlTypenameFromStringTemplate();
        st.setAttribute("type", getContentTypeCode().getIdlTypename());
        st.setAttribute("maxsize", m_maxsize);
        return st.toString();
    }

    public String getMaxsize()
    {
        if (m_maxsize == null)
        {
            return "100";
        }

        return m_maxsize;
    }

    @Override
    public boolean isIsPlain()
    {
        return false;
    }

    @Override
    public boolean isIsBounded()
    {
        if (m_maxsize == null)
        {
            return false;
        }

        return super.isIsBounded();
    }

    @Override
    protected long maxSerializedSize(
            long current_alignment)
    {
        long initial_alignment = current_alignment;
        long maxsize = (null == m_maxsize ? 100 : Long.parseLong(m_maxsize, 10));

        current_alignment += 4 + TypeCode.cdr_alignment(current_alignment, 4);

        for (long count = 0; count < maxsize; ++count)
        {
            current_alignment += getContentTypeCode().maxSerializedSize(current_alignment);
        }

        return current_alignment - initial_alignment;
    }

    private String m_maxsize = null;
}
