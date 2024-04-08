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
import com.eprosima.idl.parser.exception.RuntimeGenerationException;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.Notebook;

public class MemberAppliedAnnotations implements Notebook
{
    public enum TryConstructFailAction
    {
        INVALID(0),
        DISCARD(1),
        USE_DEFAULT(2),
        TRIM(3);

        private int value_ = 0;

        private TryConstructFailAction(int value)
        {
            value_ = value;
        }

        public int get_value()
        {
            return value_;
        }
    };

    public static TryConstructFailAction default_try_construct = TryConstructFailAction.DISCARD;

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

    //{{{ Auxiliary function to check which built-in annotation is the instance.

    public boolean isAnnotationBitBound()
    {
        return m_annotations.get(Annotation.bit_bound_str) != null;
    }

    public Short getAnnotationBitBoundValue() throws RuntimeGenerationException
    {
        try
        {
            if (isAnnotationBitBound())
            {
                return Short.parseShort(m_annotations.get(Annotation.bit_bound_str).getValue());
            }
        }
        catch (RuntimeGenerationException ex)
        {
            // Should never be called because isAnnotationBitBound() was previously called.
        }
        return 0;
    }

    public boolean isAnnotationDefault()
    {
        return m_annotations.get(Annotation.default_str) != null;
    }

    public String getAnnotationDefaultValue() throws RuntimeGenerationException
    {
        Annotation ann = m_annotations.get(Annotation.default_str);
        if (ann != null)
        {
            return ann.getValue();
        }
        throw new RuntimeGenerationException("Error getting @" + Annotation.default_str +
                " annotation value: annotation not found");
    }

    public boolean isAnnotationDefaultLiteral()
    {
        return m_annotations.get(Annotation.default_literal_str) != null;
    }

    public boolean isAnnotationExternal()
    {
        Annotation ann = m_annotations.get(Annotation.external_str);
        if (ann != null)
        {
            try
            {
                return ann.getValue().toUpperCase().equals(Annotation.capitalized_true_str);
            }
            catch (RuntimeGenerationException ex)
            {
                // Should not be called as @external annotation has only one parameter
            }
        }
        return false;
    }

    public boolean isAnnotationHashid()
    {
        return m_annotations.get(Annotation.hashid_str) != null;
    }

    public boolean isAnnotationId()
    {
        return m_annotations.get(Annotation.id_str) != null;
    }

    public boolean isAnnotationKey()
    {
        Annotation ann = m_annotations.get(Annotation.key_str);
        if (ann == null)
        {
            ann = m_annotations.get(Annotation.eprosima_key_str); // Try old way
        }
        if (ann != null)
        {
            try
            {
                return ann.getValue().toUpperCase().equals(Annotation.capitalized_true_str);
            }
            catch (RuntimeGenerationException ex)
            {
                // Should not be called as @key annotation has only one parameter
            }
        }
        return false;
    }

    public boolean isAnnotationMustUnderstand()
    {
        Annotation ann = m_annotations.get(Annotation.must_understand_str);
        if (ann != null)
        {
            try
            {
                return ann.getValue().toUpperCase().equals(Annotation.capitalized_true_str);
            }
            catch (RuntimeGenerationException ex)
            {
                // Should not be called as @must_understand annotation has only one parameter
            }
        }
        return false;
    }

    public boolean isAnnotationNonSerialized()
    {
        Annotation ann = m_annotations.get(Annotation.non_serialized_str);
        if (ann != null)
        {
            try
            {
                return ann.getValue().toUpperCase().equals(Annotation.capitalized_true_str);
            }
            catch (RuntimeGenerationException ex)
            {
                // Should not be called as @non_serialized annotation has only one parameter
            }
        }
        return false;
    }

    public boolean isAnnotationOptional()
    {
        Annotation ann = m_annotations.get(Annotation.optional_str);
        if (ann != null)
        {
            try
            {
                return ann.getValue().toUpperCase().equals(Annotation.capitalized_true_str);
            }
            catch (RuntimeGenerationException ex)
            {
                // Should not be called as @optional annotation only has one parameter
            }
        }
        return false;
    }

    public boolean isAnnotationPosition()
    {
        return m_annotations.get(Annotation.position_str) != null;
    }

    public Short getAnnotationPositionValue()
    {
        try
        {
            if (isAnnotationPosition())
            {
                return Short.parseShort(m_annotations.get(Annotation.position_str).getValue());
            }
        }
        catch (RuntimeGenerationException ex)
        {
            // Should never be called because isAnnotationPosition() was previously called.
        }
        return 0;
    }

    //{{{ @try_construct
    public boolean isAnnotationTryConstruct()
    {
        return m_annotations.containsKey(Annotation.try_construct_str);
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
    //}}}

    public boolean isAnnotationValue()
    {
        return m_annotations.get(Annotation.value_str) != null;
    }

    public String getAnnotationValueValue()
    {
        try
        {
            if (isAnnotationValue())
            {
                return m_annotations.get(Annotation.value_str).getValue();
            }
        }
        catch (RuntimeGenerationException ex)
        {
            // Should never be called because isAnnotationValue() was previously called.
        }
        return "";
    }
    //}}}

    private HashMap<String, Annotation> m_annotations = new HashMap<String, Annotation>();

    private TryConstructFailAction try_construct_ = TryConstructFailAction.INVALID;
}
