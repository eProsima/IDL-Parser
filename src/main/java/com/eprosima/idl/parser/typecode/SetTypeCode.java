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


public class SetTypeCode extends ContainerTypeCode
{
    public SetTypeCode(
            String maxsize,
            String evaluate_maxsize)
    {
        super(Kind.KIND_SET);
        m_maxsize = maxsize;
        evaluated_maxsize_ = evaluate_maxsize;
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
        ST st = getCppTypenameFromStringTemplate();
        st.add("type", getContentTypeCode().getCppTypename());
        st.add("maxsize", m_maxsize);
        return st.render();
    }

    @Override
    public String getCTypename()
    {
        ST st = getCTypenameFromStringTemplate();
        st.add("type", getContentTypeCode().getCTypename());
        st.add("maxsize", m_maxsize);
        return st.render();
    }

    @Override
    public String getJavaTypename()
    {
        ST st = getJavaTypenameFromStringTemplate();
        st.add("type", getContentTypeCode().getJavaTypename());
        st.add("maxsize", m_maxsize);
        return st.render();
    }

    @Override
    public String getIdlTypename()
    {
        ST st = getIdlTypenameFromStringTemplate();
        st.add("type", getContentTypeCode().getIdlTypename());
        st.add("maxsize", m_maxsize);
        return st.render();
    }

    public String getMaxsize()
    {
        if (m_maxsize == null)
        {
            return default_unbounded_max_size;
        }

        return m_maxsize;
    }

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
        if (m_maxsize == null)
        {
            return false;
        }

        return super.isIsBounded();
    }

    private String m_maxsize = null;

    private String evaluated_maxsize_ = null;
}
