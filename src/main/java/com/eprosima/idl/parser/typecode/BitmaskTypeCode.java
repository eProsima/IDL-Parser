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
import java.util.Set;

import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.exception.RuntimeGenerationException;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.context.Context;

import org.stringtemplate.v4.ST;



public class BitmaskTypeCode extends MemberedTypeCode
{
    public BitmaskTypeCode(
            String scope,
            String name)
    {
        super(Kind.KIND_BITMASK, scope, name);
        m_bitmasks = new LinkedHashMap<String, Bitmask>();
        m_value_bitmasks = new LinkedHashMap<Integer, Bitmask>();
    }

    public BitmaskTypeCode(
            String scope,
            String name,
            Integer bit_bound)
    {
        super(Kind.KIND_BITMASK, scope, name);
        m_bit_bound = bit_bound;
        m_bitmasks = new LinkedHashMap<String, Bitmask>();
        m_value_bitmasks = new LinkedHashMap<Integer, Bitmask>();
    }

    @Override
    public boolean isIsBitmaskType()
    {
        return true;
    }

    @Override
    public boolean isObjectType()
    {
        return true;
    }

    @Override
    public String getSize()
    {
        if (m_bit_bound <= 8)
        {
            return "1";
        }
        else if (m_bit_bound <= 16)
        {
            return "2";
        }
        else if (m_bit_bound <= 32)
        {
            return "4";
        }
        else if (m_bit_bound <= 64)
        {
            return "8";
        }
        return "4";
    }

    @Override
    public String getInitialValue()
    {
        return "0";
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

    public List<Bitmask> getBitmasks()
    {
        return new ArrayList<Bitmask>(m_bitmasks.values());
    }

    public boolean addBitmask(
            Bitmask bitmask)
    {
        if (bitmask.getPosition() == -1)
        {
            if (bitmask.getAnnotations().get("position") != null)
            {
                try
                {
                    // Position from attribute
                    return addBitmask(bitmask, Integer.parseInt(bitmask.getAnnotations().get("position").getValue()));
                }
                catch (RuntimeGenerationException ex)
                {
                    // Should not be called as @position annotation has only one parameter
                }
            }
            // Position autoassigned
            return addBitmask(bitmask, m_current_base);
        }
        // Position by code.
        return addBitmask(bitmask, bitmask.getPosition());
    }

    private boolean addBitmask(
            Bitmask bitmask,
            int position)
    {
        if (m_value_bitmasks.containsKey(position))
        {
            return false;                                         // Position already taken

        }
        if (m_bitmasks.containsKey(bitmask.getName()))
        {
            return false;                                           // Already exists

        }
        bitmask.setPosition(position);
        m_value_bitmasks.put(position, bitmask);
        m_bitmasks.put(bitmask.getName(), bitmask);
        addMember(bitmask); // Use members too.
        m_current_base = position + 1;

        return true;
    }

    public void setParent(
            BitmaskTypeCode parent)
    {
        m_parent = parent;
    }

    public BitmaskTypeCode getParent()
    {
        return m_parent;
    }

    public int getBitBound()
    {
        return m_bit_bound;
    }

    public String getBoundType()
    {
        if (m_bit_bound <= 8)
        {
            return " : uint8_t";
        }
        else if (m_bit_bound <= 16)
        {
            return " : uint16_t";
        }
        else if (m_bit_bound <= 32)
        {
            return " : uint32_t";
        }
        else if (m_bit_bound <= 64)
        {
            return " : uint64_t";
        }
        return "";
    }

    public String getCastingType()
    {
        if (m_bit_bound <= 8)
        {
            return "uint8_t";
        }
        else if (m_bit_bound <= 16)
        {
            return "uint16_t";
        }
        else if (m_bit_bound <= 32)
        {
            return "uint32_t";
        }
        else if (m_bit_bound <= 64)
        {
            return "uint64_t";
        }
        return "";
    }

    @Override
    public void addAnnotation(
            Context ctx,
            Annotation annotation)
    {
        super.addAnnotation(ctx, annotation);
        if (annotation.getName().equals("bit_bound"))
        {
            try
            {
                m_bit_bound = Integer.parseInt(annotation.getValue());
                // Sanity check
                Set<String> keys = m_bitmasks.keySet();
                for (String key : keys) {
                    int position = m_bitmasks.get(key).getPosition();
                    if (position < 0 || position >= m_bit_bound)
                    {
                        throw new ParseException(null, "Bitmask member "+ key +" out of bounds. Requested position: "
                        + position + " with @bit_bound value: " + m_bit_bound);
                    }
                }
            }
            catch (RuntimeGenerationException ex)
            {
               // Should not be called as @bit_bound annotation only has one parameter
            }
        }
    }

    private BitmaskTypeCode m_parent = null;
    private LinkedHashMap<String, Bitmask> m_bitmasks = null;
    private LinkedHashMap<Integer, Bitmask> m_value_bitmasks = null;
    private Integer m_bit_bound = 32;
    private int m_current_base = 0;
}
