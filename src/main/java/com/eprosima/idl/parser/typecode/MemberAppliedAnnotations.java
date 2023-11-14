// Copyright 2023 Proyectos y Sistemas de Mantenimiento SL (eProsima).
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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.Notebook;

public class MemberAppliedAnnotations implements Notebook
{
    @Override
    public void addAnnotation(Context ctx, Annotation annotation)
    {
        if(annotation != null)
        {
            m_annotations.put(annotation.getName(), annotation);
        }
    }

    @Override
    public Map<String, Annotation> getAnnotations()
    {
        return m_annotations;
    }

    public Collection<Annotation> getAnnotationList()
    {
        return m_annotations.values();
    }

    public boolean isAnnotationOptional()
    {
        Annotation ann = m_annotations.get("optional");
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public boolean isAnnotationExternal()
    {
        Annotation ann = m_annotations.get("external");
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public boolean isAnnotationMustUnderstand()
    {
        Annotation ann = m_annotations.get("must_understand");
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public boolean isAnnotationNonSerialized()
    {
        Annotation ann = m_annotations.get("non_serialized");
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public boolean isAnnotationKey()
    {
        Annotation ann = m_annotations.get("key");
        if (ann == null)
        {
            ann = m_annotations.get("Key"); // Try old way
        }
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("TRUE");
        }
        return false;
    }

    public Short getAnnotationBitBound()
    {
        Annotation ann = m_annotations.get("bit_bound");
        if (ann != null)
        {
            String value = ann.getValue();
            if (value.equals("-1"))
            {
                return null;
            }
            return Short.parseShort(value);
        }
        return null;
    }

    public boolean isAnnotationDefaultLiteral()
    {
        return m_annotations.get("default_literal") != null;
    }

    public String getAnnotationValue()
    {
        Annotation ann = m_annotations.get("value");
        if (ann != null)
        {
            return ann.getValue();
        }
        return null;
    }

    public Short getAnnotationPosition()
    {
        Annotation ann = m_annotations.get("position");
        if (ann != null)
        {
            String value = ann.getValue();
            if (value.equals("-1"))
            {
                return null;
            }
            return Short.parseShort(value);
        }
        return null;
    }

    public boolean isAnnotationDefault()
    {
        return m_annotations.get("default") != null;
    }

    public String getAnnotationDefaultValue()
    {
        Annotation ann = m_annotations.get("default");
        if (ann != null)
        {
            return ann.getValue();
        }
        return "";
    }

    public boolean isAnnotationTryConstruct()
    {
        return m_annotations.get(Annotation.try_construct_str) != null;
    }

    void calculate_try_construct() throws RuntimeGenerationException
    {
        if (TryConstructFailAction.INVALID == try_construct_)
        {
            if (isAnnotationTryConstruct())
            {
                if (m_annotations.get(Annotation.try_construct_str).getValue().equals(Annotation.try_construct_discard_str))
                {
                    try_construct_ = TryConstructFailAction.DISCARD;
                }
                else if (m_annotations.get(Annotation.try_construct_str).getValue().equals(Annotation.try_construct_use_default_str))
                {
                    try_construct_ = TryConstructFailAction.USE_DEFAULT;
                }
                else if (m_annotations.get(Annotation.try_construct_str).getValue().equals(Annotation.try_construct_trim_str))
                {
                    try_construct_ = TryConstructFailAction.TRIM;
                }
                else
                {
                    throw new RuntimeGenerationException("try_construct annotation does not have a recognized value");
                }
            }
            else
            {
                try_construct_ = default_try_construct;
            }
        }
    }

    public TryConstructFailAction get_try_construct() throws RuntimeGenerationException
    {
        calculate_try_construct();
        return try_construct_;
    }

    public boolean isAnnotationDiscard() throws RuntimeGenerationException
    {
        calculate_try_construct();
        return TryConstructFailAction.DISCARD == try_construct_;
    }

    public boolean isAnnotationUseDefault() throws RuntimeGenerationException
    {
        calculate_try_construct();
        return TryConstructFailAction.USE_DEFAULT == try_construct_;
    }

    public boolean isAnnotationTrim() throws RuntimeGenerationException
    {
        calculate_try_construct();
        return TryConstructFailAction.TRIM == try_construct_;
    }

    public boolean isAnnotationAutoidHash()
    {
        Annotation ann = m_annotations.get("autoid");
        if (ann != null)
        {
            return ann.getValue().toUpperCase().equals("HASH");
        }
        return false;
    }

    private HashMap<String, Annotation> m_annotations = new HashMap<String, Annotation>();
}
