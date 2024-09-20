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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.exception.RuntimeGenerationException;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.Notebook;


public abstract class TypeCode implements Notebook
{
    public enum ExtensibilityKind
    {
        NOT_APPLIED(0),
        FINAL(1),
        APPENDABLE(2),
        MUTABLE(3);

        private int value_ = 0;

        private ExtensibilityKind(int value)
        {
            value_ = value;
        }

        public int get_value()
        {
            return value_;
        }
    };

    public static ExtensibilityKind default_extensibility = ExtensibilityKind.APPENDABLE;
    public static STGroup idltypesgr  = null;
    public static STGroup cpptypesgr  = null;
    public static STGroup ctypesgr    = null;
    public static STGroup javatypesgr = null;
    public static Context ctx = null;
    //TODO Revisar si es el mejor sitio.
    public static String javapackage = "";

    public TypeCode(
            int kind)
    {
        m_kind = kind;
        m_annotations = new HashMap<String, Annotation>();
    }

    public int getKind()
    {
        return m_kind;
    }

    public boolean isIsAnyTypeCode()
    {
        return m_kind == Kind.KIND_NULL;
    }

    /*|
     * @brief This function returns the typename with the scope that is obtained using the cpptypesgr string template.
     * @return The IDL typename.
     */
    public abstract String getCppTypename();

    public abstract String getCTypename();

    protected ST getCppTypenameFromStringTemplate()
    {
        return cpptypesgr.getInstanceOf("type_" + Integer.toHexString(m_kind));
    }

    protected ST getCTypenameFromStringTemplate()
    {
        return ctypesgr.getInstanceOf("type_" + Integer.toHexString(m_kind));
    }

    public abstract String getJavaTypename();

    protected ST getJavaTypenameFromStringTemplate()
    {
        ST st = javatypesgr.getInstanceOf("type_" + Integer.toHexString(m_kind));
        st.add("package", javapackage);
        return st;
    }

    /*|
     * @brief This function returns a typename with scope that is obtained using the m_stringtemplatetypesgr string template.
     * @return The typename.
     */
    public abstract String getIdlTypename();

    protected ST getIdlTypenameFromStringTemplate()
    {
        return idltypesgr.getInstanceOf("type_" + Integer.toHexString(m_kind));
    }

    /*!
     * @brief This function returns the type as a string: "type_2", where the number is the type kind.
     * This function is used in stringtemplates.
     */
    public String getStType()
    {
        return "type_" + Integer.toHexString(m_kind);
    }

    /*!
     * @brief
     */
    public String getFormatedCppTypename()
    {
        return getCppTypename().replaceAll("::", "_");
    }

    /*!
     * @brief Return the `getCppTypename()` without the scope.
     */
    public String getNoScopedCppTypename()
    {
        return getCppTypename().substring(getCppTypename().lastIndexOf(":") + 1);
    }

    // By default a typecode is not primitive. Function used in stringtemplates
    // TODO Cambiar a isIsPrimitive
    public boolean isPrimitive()
    {
        return false;
    }

    // By default there is not initial value. Function used in stringtemplates.
    public String getInitialValue()
    {
        return null;
    }

    public String getJavaInitialValue()
    {
        return getInitialValue();
    }

    // By default a typecode doesn't have a max size limit. Function used in stringtemplates
    public String getMaxsize()
    {
        return null;
    }

    public String getEvaluatedMaxsize() throws RuntimeGenerationException
    {
        throw new RuntimeGenerationException("Non-collection types does not have an evaluated max size");
    }

    /*!
     * @brief This function returns the size of the datatype. By default is null string.
     * @return The size of the datatype.
     */
    protected String getSize()
    {
        return null;
    }

    /*** Functions to know the type in string templates ***/
    // By default a typecode is not string. Function used in stringtemplates
    public boolean isIsType_5()
    {
        return false;
    }

    public boolean isIsType_6()
    {
        return false;
    }

    public boolean isIsType_7()
    {
        return false;
    }

    public boolean isIsType_d()
    {
        return false;
    }

    public boolean isIsType_c()
    {
        return false;
    }

    public boolean isIsType_f()
    {
        return false;
    }

    public boolean isIsType_e()
    {
        return false;
    }

    public boolean isIsType_a()
    {
        return false;
    }

    public boolean isIsType_10()
    {
        return false;
    }

    public boolean isIsType_13()
    {
        return false;
    }

    public boolean isIsBooleanType()
    {
        return false;
    }

    public boolean isIsByteType()
    {
        return false;
    }

    public boolean isIsInt8Type()
    {
        return false;
    }

    public boolean isIsUint8Type()
    {
        return false;
    }

    public boolean isIsInt16Type()
    {
        return false;
    }

    public boolean isIsUint16Type()
    {
        return false;
    }

    public boolean isIsInt32Type()
    {
        return false;
    }

    public boolean isIsUint32Type()
    {
        return false;
    }

    public boolean isIsInt64Type()
    {
        return false;
    }

    public boolean isIsUint64Type()
    {
        return false;
    }

    public boolean isIsFloat32Type()
    {
        return false;
    }

    public boolean isIsFloat64Type()
    {
        return false;
    }

    public boolean isIsFloat128Type()
    {
        return false;
    }

    public boolean isIsEnumType()
    {
        return false;
    }

    public boolean isIsBitmaskType()
    {
        return false;
    }

    public boolean isIsBitsetType()
    {
        return false;
    }

    public boolean isIsStringType()
    {
        return false;
    }

    public boolean isIsWStringType()
    {
        return false;
    }

    public boolean isIsCharType()
    {
        return false;
    }

    public boolean isIsWCharType()
    {
        return false;
    }

    public boolean isIsSetType()
    {
        return false;
    }

    public boolean isIsMapType()
    {
        return false;
    }

    public boolean isIsSequenceType()
    {
        return false;
    }

    public boolean isIsArrayType()
    {
        return false;
    }

    public boolean isIsStructType()
    {
        return isIsType_a();
    }

    public boolean isIsAliasType()
    {
        return isIsType_10();
    }

    public boolean isIsUnionType()
    {
        return m_kind == Kind.KIND_UNION;
    }

    // Functions to ease TypeIdentifier and TypeObject generation.
    public String getCppTypenameForTypeId()
    {
        if (Kind.KIND_OCTET == m_kind)
        {
            return "byte";
        }
        String s = getCppTypename();
        return s.equals("long double") ? "longdouble" : s;
    }

    public String getTypeIdentifier()
    {
        return "TK_None";
    }

    public boolean isPrimitiveType()
    {
        return false;
    }

    public boolean isPlainType()
    {
        return false;
    }

    public boolean isObjectType()
    {
        return false;
    }

    // Functions to ease full preallocation and zero-copy
    public boolean isIsPlain()
    {
        return true;
    }                                           // Don't confuse with isPlainType!

    public boolean isIsBounded()
    {
        return true;
    }

    /*** End of functions to know the type in string templates ***/

    public Object getParent()
    {
        return m_parent;
    }

    public void setParent(
            Object parent)
    {
        m_parent = parent;
    }

    @Override
    public void addAnnotation(
            Context ctx,
            Annotation annotation)
    {
        if (annotation != null)
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

    void calculate_extensibility(
            ExtensibilityKind base_ext)
    {
        if (ExtensibilityKind.NOT_APPLIED == extensibility_)
        {
            try
            {
                if (m_annotations.containsKey(Annotation.final_str) ||
                        (m_annotations.containsKey(Annotation.extensibility_str) &&
                        m_annotations.get(Annotation.extensibility_str).getValue().equals(Annotation.ex_final_val)))
                {
                    extensibility_ = ExtensibilityKind.FINAL;
                }
                else if (m_annotations.containsKey(Annotation.appendable_str) ||
                        (m_annotations.containsKey(Annotation.extensibility_str) &&
                        m_annotations.get(Annotation.extensibility_str).getValue().equals(Annotation.ex_appendable_val)))
                {
                    extensibility_ = ExtensibilityKind.APPENDABLE;
                }
                else if (m_annotations.containsKey(Annotation.mutable_str) ||
                        (m_annotations.containsKey(Annotation.extensibility_str) &&
                        m_annotations.get(Annotation.extensibility_str).getValue().equals(Annotation.ex_mutable_val)))
                {
                    extensibility_ = ExtensibilityKind.MUTABLE;
                }
                else
                {
                    if (ExtensibilityKind.NOT_APPLIED != base_ext)
                    {
                        extensibility_ = base_ext;
                    }
                    else
                    {
                        extensibility_ = default_extensibility;
                    }
                }
            }
            catch (RuntimeGenerationException ex)
            {
                // Should not be called as @extensibility annotation has only one parameter
            }
        }
    }

    public ExtensibilityKind get_extensibility()
    {
        return get_extensibility(ExtensibilityKind.NOT_APPLIED);
    }

    public ExtensibilityKind get_extensibility(
            ExtensibilityKind base_ext)
    {
        calculate_extensibility(base_ext);
        return extensibility_;
    }

    public boolean isAnnotationFinal()
    {
        calculate_extensibility(ExtensibilityKind.NOT_APPLIED);
        return ExtensibilityKind.FINAL == extensibility_;
    }

    public boolean isAnnotationAppendable()
    {
        calculate_extensibility(ExtensibilityKind.NOT_APPLIED);
        return ExtensibilityKind.APPENDABLE == extensibility_;
    }

    public boolean isAnnotationMutable()
    {
        calculate_extensibility(ExtensibilityKind.NOT_APPLIED);
        return ExtensibilityKind.MUTABLE == extensibility_;
    }

    public boolean isAnnotationNested()
    {
        Annotation ann = m_annotations.get(Annotation.nested_str);
        if (ann != null)
        {
            try
            {
                return ann.getValue().toUpperCase().equals(Annotation.capitalized_true_str);
            }
            catch (RuntimeGenerationException ex)
            {
                // Should not be called as @nested annotation has only one parameter
            }
        }
        return false;
    }

    public boolean isAnnotationAutoidHash()
    {
        Annotation ann = m_annotations.get(Annotation.autoid_str);
        if (ann != null)
        {
            try
            {
                return (ann.getValue().toUpperCase().equals(Annotation.autoid_hash_value_str) ||
                        ann.getValue().isEmpty());
            }
            catch (RuntimeGenerationException ex)
            {
                // Should not be called as @autoid annotation has only one parameter
            }
        }
        return false;
    }

    public boolean isForwarded()
    {
        return m_forwarded;
    }

    public void setForwarded(
            boolean fwd)
    {
        m_forwarded = fwd;
    }

    public boolean isDefined()
    {
        return m_defined;
    }

    public void setDefined()
    {
        m_defined = true;
    }

    private int m_kind = Kind.KIND_NULL;

    // Added parent object to typecode because was needed in DDS with our types (TopicsPlugin_gettypecode)
    private Object m_parent = null;

    private HashMap<String, Annotation> m_annotations = null;

    private boolean m_forwarded = false;

    private boolean m_defined = false;

    private ExtensibilityKind extensibility_ = ExtensibilityKind.NOT_APPLIED;

}
