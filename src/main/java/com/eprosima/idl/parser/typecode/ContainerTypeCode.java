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

import com.eprosima.idl.parser.tree.Definition;

public abstract class ContainerTypeCode extends TypeCode
{
    public static String default_unbounded_max_size = "0";

    protected ContainerTypeCode(int kind)
    {
        super(kind);
    }

    @Override
    public abstract String getCppTypename();

    @Override
    public abstract String getCTypename();

    @Override
    public abstract String getIdlTypename();

    public TypeCode getContentTypeCode()
    {
        return collection_element_.getTypecode();
    }

    public Definition getContentDefinition()
    {
        return m_contentDefinition;
    }

    public void setContentTypeCode(TypeCode contentTypeCode)
    {
        collection_element_.setTypecode(contentTypeCode);
    }

    public void setContentDefinition(Definition contentDefinition)
    {
        m_contentDefinition = contentDefinition;
    }

    public int getDepth()
    {
        int ret = 1;

        if (collection_element_.getTypecode().isPrimitive())
        {
            return ret;
        }
        else
        {
            if (collection_element_.getTypecode() instanceof ContainerTypeCode)
            {
                ret += ((ContainerTypeCode) collection_element_.getTypecode()).getDepth();
            }
        }

        return ret;
    }

    @Override
    public boolean isIsPlain()
    {
        if (collection_element_.getTypecode() != null)
        {
            return collection_element_.getTypecode().isIsPlain();
        }
        return false;
    }

    @Override
    public boolean isIsBounded()
    {
        if (collection_element_.getTypecode() != null)
        {
            return collection_element_.getTypecode().isIsBounded();
        }
        return false;
    }

    private CollectionElement collection_element_ = new CollectionElement();
    private Definition m_contentDefinition = null;
}
