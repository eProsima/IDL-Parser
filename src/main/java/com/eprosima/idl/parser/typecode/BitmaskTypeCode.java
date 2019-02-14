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

import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.context.Context;

import org.antlr.stringtemplate.StringTemplate;



public class BitmaskTypeCode extends MemberedTypeCode
{
    public BitmaskTypeCode(String scope, String name)
    {
        super(Kind.KIND_BITMASK, scope, name);
        m_bitmasks = new LinkedHashMap<String, Bitmask>();
        m_value_bitmasks = new LinkedHashMap<Integer, Bitmask>();
    }

    public BitmaskTypeCode(String scope, String name, Integer bit_bound)
    {
        super(Kind.KIND_BITMASK, scope, name);
        m_bit_bound = bit_bound;
        m_bitmasks = new LinkedHashMap<String, Bitmask>();
        m_value_bitmasks = new LinkedHashMap<Integer, Bitmask>();
    }

    @Override
    public String getCppTypename()
    {
        StringTemplate st = getCppTypenameFromStringTemplate();
        st.setAttribute("name", getScopedname());
        return st.toString();
    }

    @Override
    public String getCTypename()
    {
        StringTemplate st = getCTypenameFromStringTemplate();
        st.setAttribute("name", getCScopedname());
        return st.toString();
    }

    @Override
    public String getJavaTypename()
    {
        StringTemplate st = getJavaTypenameFromStringTemplate();
        st.setAttribute("name", getJavaScopedname());
        return st.toString();
    }

    @Override
    public String getIdlTypename()
    {
        StringTemplate st = getIdlTypenameFromStringTemplate();
        st.setAttribute("name", getScopedname());
        return st.toString();
    }

    public List<Bitmask> getBitmasks()
    {
        return new ArrayList<Bitmask>(m_bitmasks.values());
    }

    public boolean addBitmask(Bitmask bitmask)
    {
        if (bitmask.getPosition() == -1)
        {
            if (bitmask.getAnnotations().get("position") != null)
            {
                // Position from attribute
                return addBitmask(bitmask, Integer.parseInt(bitmask.getAnnotations().get("position").getValue()));
            }
            // Position autoassigned
            return addBitmask(bitmask, m_current_base);
        }
        // Position by code.
        return addBitmask(bitmask, bitmask.getPosition());
    }

    private boolean addBitmask(Bitmask bitmask, int position)
    {
        if (position < 0 || position >= m_bit_bound) return false; // Out of bounds

        if (m_value_bitmasks.containsKey(position)) return false; // Position already taken

        if(m_bitmasks.containsKey(bitmask.getName())) return false; // Already exists

        bitmask.setPosition(position);
        m_value_bitmasks.put(position, bitmask);
        m_bitmasks.put(bitmask.getName(), bitmask);
        addMember(bitmask); // Use members too.
        m_current_base = position + 1;

        return true;
    }

    public void setParent(BitmaskTypeCode parent)
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

    @Override
    public void addAnnotation(Context ctx, Annotation annotation)
    {
        super.addAnnotation(ctx, annotation);
        if (annotation.getName().equals("bit_bound"))
        {
            m_bit_bound = Integer.parseInt(annotation.getValue());
        }
    }

    private BitmaskTypeCode m_parent = null;
    private LinkedHashMap<String, Bitmask> m_bitmasks = null;
    private LinkedHashMap<Integer, Bitmask> m_value_bitmasks = null;
    private Integer m_bit_bound = 32;
    private int m_current_base = 0;
}
