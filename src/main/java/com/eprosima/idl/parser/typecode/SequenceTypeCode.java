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

import com.eprosima.idl.parser.typecode.StringTypeCode;
import com.eprosima.idl.parser.typecode.MapTypeCode;
import org.stringtemplate.v4.ST;


public class SequenceTypeCode extends ContainerTypeCode
{
    public SequenceTypeCode(
            String maxsize,
            String evaluated_maxsize)
    {
        super(Kind.KIND_SEQUENCE);
        m_maxsize = maxsize;
        evaluated_maxsize_ = evaluated_maxsize;
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
    public boolean isIsSequenceType()
    {
        return true;
    }

    @Override
    public String getCppTypename()
    {
        ST st = getCppTypenameFromStringTemplate();
        st.add("ctx", ctx);
        st.add("type", getContentTypeCode().getCppTypename());
        String contenttype = getContentTypeCode().getCppTypename().replaceAll("::", "_");
        if (getContentTypeCode() instanceof StringTypeCode)
        {
            contenttype = contenttype.replace("*", "_ptr_") + ((StringTypeCode)getContentTypeCode()).getMaxsize();
        }
        st.add("contenttype", contenttype);
        st.add("maxsize", m_maxsize);
        return st.render();
    }

    @Override
    public String getCTypename()
    {
        ST st = getCTypenameFromStringTemplate();
        st.add("type", getContentTypeCode().getCTypename());
        st.add("maxsize", getMaxsize());
        return st.render();
    }

    public String getCTypeDimensions()
    {
        String dimensions = "[" + getMaxsize()  + "]";
        if (getContentTypeCode() instanceof StringTypeCode)
        {
            dimensions += "[" + ((StringTypeCode)getContentTypeCode()).getMaxsize() + "]";
        }

        return dimensions;
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

    @Override
    public String getMaxsize()
    {
        if (m_maxsize == null)
        {
            return "100";
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

    public boolean isUnbound()
    {
        return null == m_maxsize;
    }

    @Override
    public boolean isIsPlain()
    {
        return false;
    }

    @Override
    public boolean isIsBounded()
    {
        boolean ret_value = false;

        if (m_maxsize != null)
        {
            boolean should_set_and_unset = getContentTypeCode().isForwarded() && !detect_recursive_;
            if (should_set_and_unset)
            {
                detect_recursive_ = true;
                ret_value =  super.isIsBounded();
                detect_recursive_ = false;
            }
            else
            {
                ret_value =  super.isIsBounded();
            }
        }

        return ret_value;
    }

    private String m_maxsize = null;

    private String evaluated_maxsize_ = null;

    protected boolean detect_recursive_ = false;
}
