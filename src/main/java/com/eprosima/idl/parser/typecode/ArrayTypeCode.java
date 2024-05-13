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
import java.util.List;
import org.stringtemplate.v4.ST;



public class ArrayTypeCode extends ContainerTypeCode
{
    public ArrayTypeCode()
    {
        super(Kind.KIND_ARRAY);
    }

    @Override
    public boolean isIsType_f()
    {
        return true;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function can be used to check if TypeIdentifier's kind is the small one or the large one.
     * @return @e false if all dimensions of the array are smaller than 256.
     * Otherwise @e true is returned.
     */
    public boolean getIsTypeIdentifierKindLarge()
    {
        for (int count = 0; count < evaluated_dimensions_.size(); ++count)
        {
            if (Integer.parseInt(evaluated_dimensions_.get(count)) >= 256)
            {
                return true;
            }
        }

        return false;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function can be used to retrieve the TypeIdentifier's kind.
     * @return @e TI_PLAIN_ARRAY_SMALL if all dimensions of the array are smaller than 256.
     * Otherwise @e TI_PLAIN_ARRAY_LARGE is returned.
     */
    @Override
    public String getTypeIdentifier()
    {
        if (getIsTypeIdentifierKindLarge())
        {
            return "TI_PLAIN_ARRAY_LARGE";
        }
        return "TI_PLAIN_ARRAY_SMALL";
    }

    @Override
    public boolean isPlainType()
    {
        return true;
    }

    @Override
    public boolean isIsArrayType()
    {
        return true;
    }

    @Override
    public String getCppTypename()
    {
        ST first = null, second = null, fin = null;
        String prevf = null, prevs = null;

        for (int count = 0; count < m_dimensions.size(); ++count)
        {
            first = cpptypesgr.getInstanceOf("type_" + Integer.toHexString(Kind.KIND_ARRAY) + "_first");
            second = cpptypesgr.getInstanceOf("type_" + Integer.toHexString(Kind.KIND_ARRAY) + "_second");
            second.add("size", m_dimensions.get(count));

            if (prevf != null)
            {
                first.add("prev", prevf);
            }
            if (prevs != null)
            {
                second.add("prev", prevs);
            }

            prevf = first.render();
            prevs = second.render();
        }

        fin = getCppTypenameFromStringTemplate();
        fin.add("firs", prevf);
        fin.add("secon", prevs);
        fin.add("type", getContentTypeCode().getCppTypename());

        return fin.render();
    }

    @Override
    public String getCTypename()
    {
        ST first = null, second = null, fin = null;
        String prevf = null, prevs = null;

        for (int count = 0; count < m_dimensions.size(); ++count)
        {
            first = ctypesgr.getInstanceOf("type_" + Integer.toHexString(Kind.KIND_ARRAY) + "_first");
            second = ctypesgr.getInstanceOf("type_" + Integer.toHexString(Kind.KIND_ARRAY) + "_second");
            second.add("size", m_dimensions.get(count));

            if (prevf != null)
            {
                first.add("prev", prevf);
            }
            if (prevs != null)
            {
                second.add("prev", prevs);
            }

            prevf = first.render();
            prevs = second.render();
        }

        fin = getCTypenameFromStringTemplate();
        fin.add("firs", prevf);
        fin.add("secon", prevs);
        fin.add("type", getContentTypeCode().getCTypename());

        return fin.render();
    }

    public String getCTypeDimensions()
    {
        String dimensions = getArrayExtension();

        if (getContentTypeCode() instanceof StringTypeCode)
        {
            dimensions += "[" + ((StringTypeCode)getContentTypeCode()).getMaxsize() + "]";
        }

        return dimensions;
    }

    @Override
    public String getJavaTypename()
    {
        ST first = null, second = null, fin = null;
        String prevf = null, prevs = null;

        for (int count = 0; count < m_dimensions.size(); ++count)
        {
            first = cpptypesgr.getInstanceOf("type_" + Integer.toHexString(Kind.KIND_ARRAY) + "_first");
            second = cpptypesgr.getInstanceOf("type_" + Integer.toHexString(Kind.KIND_ARRAY) + "_second");
            second.add("size", m_dimensions.get(count));

            if (prevf != null)
            {
                first.add("prev", prevf);
            }
            if (prevs != null)
            {
                second.add("prev", prevs);
            }

            prevf = first.render();
            prevs = second.render();
        }

        fin = getJavaTypenameFromStringTemplate();
        fin.add("firs", prevf);
        fin.add("secon", prevs);
        fin.add("type", getContentTypeCode().getJavaTypename());

        return fin.render();
    }

    public String getIdlTypename()
    {
        return getContentTypeCode().getIdlTypename();
    }

    public void addDimension(
            String dimension,
            String evaluated_dimension)
    {
        m_dimensions.add(dimension);
        evaluated_dimensions_.add(evaluated_dimension);
    }

    public List<String> getDimensions()
    {
        return m_dimensions;
    }

    public List<String> getEvaluatedDimensions()
    {
        return evaluated_dimensions_;
    }

    public int getEvaluatedDimensionsSize()
    {
        return evaluated_dimensions_.size();
    }

    public String getSize()
    {
        String ret = "";

        for (int count = 0; count < m_dimensions.size(); ++count)
        {
            if (ret.isEmpty())
            {
                ret += "(";
            }
            else
            {
                ret += " * ";
            }

            ret += "(" + m_dimensions.get(count) + ")";
        }

        if (!ret.isEmpty())
        {
            ret += ")";
        }

        return ret;
    }

    // TODO Used in stringtemplate for RTI DDS types.
    public String getArrayExtension()
    {
        String ret = "";

        for (int count = 0; count < m_dimensions.size(); ++count)
        {
            ret += "[" + m_dimensions.get(count) + "]";
        }

        return ret;
    }

    @Override
    public String getInitialValue()
    {
        String initial_value =  getContentTypeCode().getInitialValue();

        if (null != initial_value)
        {
            if (1 < getDimensions().size())
            {
                for (int count = 0; count < getDimensions().size() - 1; ++count)
                {
                    initial_value = " {{" + initial_value + "}} ";
                }
            }

            if (getContentTypeCode().isIsArrayType())
            {
                initial_value = " {{" + initial_value + "}} ";
            }
        }

        return initial_value;
    }

    private List<String> m_dimensions = new ArrayList<String>();

    private List<String> evaluated_dimensions_ = new ArrayList<String>();
}
