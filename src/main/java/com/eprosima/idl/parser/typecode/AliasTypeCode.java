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

import com.eprosima.idl.parser.exception.RuntimeGenerationException;
import com.eprosima.idl.util.Pair;
import java.util.List;
import org.stringtemplate.v4.ST;



public class AliasTypeCode extends ContainerTypeCode
{
    public AliasTypeCode(
            String scope,
            String name)
    {
        super(Kind.KIND_ALIAS);
        m_scope = scope;
        m_name = name;
    }

    @Override
    public TypeCode getContentTypeCode()
    {
        if (super.getContentTypeCode() instanceof AliasTypeCode)
        {
            AliasTypeCode alias = (AliasTypeCode) super.getContentTypeCode();
            return alias.getContentTypeCode();
        }
        else if (super.getContentTypeCode() instanceof ContainerTypeCode)
        {
            ContainerTypeCode container = (ContainerTypeCode) super.getContentTypeCode();
            return container.getContentTypeCode();
        }

        return super.getContentTypeCode();
    }

    public String getCastingType()
    {
        if (super.getContentTypeCode() instanceof AliasTypeCode)
        {
            AliasTypeCode alias = (AliasTypeCode) super.getContentTypeCode();
            return alias.getCastingType();
        }
        else if (super.getContentTypeCode() instanceof BitmaskTypeCode)
        {
            BitmaskTypeCode container = (BitmaskTypeCode) super.getContentTypeCode();
            return container.getCastingType();
        }
        else
        {
            throw new RuntimeException("Error with BitmaskTypeCode alias type.");
        }
    }

    public TypeCode getKeyTypeCode()
    {
        if (super.getContentTypeCode() instanceof AliasTypeCode)
        {
            AliasTypeCode alias = (AliasTypeCode) super.getContentTypeCode();
            return alias.getKeyTypeCode();
        }
        else if (super.getContentTypeCode() instanceof MapTypeCode)
        {
            MapTypeCode container = (MapTypeCode) super.getContentTypeCode();
            return container.getKeyTypeCode();
        }
        else
        {
            throw new RuntimeException("Error with MapTypeCode alias type.");
        }
    }

    public TypeCode getValueTypeCode()
    {
        if (super.getContentTypeCode() instanceof AliasTypeCode)
        {
            AliasTypeCode alias = (AliasTypeCode) super.getContentTypeCode();
            return alias.getValueTypeCode();
        }
        else if (super.getContentTypeCode() instanceof MapTypeCode)
        {
            MapTypeCode container = (MapTypeCode) super.getContentTypeCode();
            return container.getValueTypeCode();
        }
        else
        {
            throw new RuntimeException("Error with MapTypeCode alias type.");
        }
    }

    public boolean isUnbound()
    {
        if (super.getContentTypeCode() instanceof SequenceTypeCode)
        {
            return ((SequenceTypeCode) super.getContentTypeCode()).isUnbound();
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean isObjectType()
    {
        return true;
    }

    public TypeCode getTypedefContentTypeCode()
    {
        return super.getContentTypeCode();
    }

    public String getName()
    {
        return m_name;
    }

    /*!
     * @brief Returns the full scoped name of the type, unless the developer uses
     * `TemplateSTGroup.enable_custom_proeprty("using_explicitly_modules")`, by removing from the full scoped name the
     * current `Context` scope.
     */
    public String getScopedname()
    {
        String scoped_name = getFullScopedname();

        if (!ctx.is_enabled_custom_property_in_current_group(ctx.using_explicitly_modules_custom_property))
        {
            return scoped_name;
        }

        String current_scope = ctx.getScope();

        if(current_scope.isEmpty() || !scoped_name.startsWith(current_scope + "::"))
        {
            return scoped_name;
        }

        return scoped_name.replace(current_scope + "::", "");
    }

    /*!
     * @brief Return the scoped name of the type.
     */
    public String getFullScopedname()
    {
        if(m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope + "::" + m_name;
    }

    public String getROS2Scopedname()
    {
        if (m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope + "::dds_::" + m_name + "_";
    }

    public String getCScopedname()
    {
        if(m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope.replace("::", "_") + "_" + m_name;
    }

    public String getScope()
    {
        return m_scope;
    }

    public boolean getHasScope()
    {
        return !m_scope.isEmpty();
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
        st.add("name", getScopedname());
        return st.render();
    }

    @Override
    public String getJavaTypename()
    {
        ST st = getJavaTypenameFromStringTemplate();
        st.add("name", getTypedefContentTypeCode().getJavaTypename());
        return st.render();
    }

    @Override
    public String getIdlTypename()
    {
        ST st = getIdlTypenameFromStringTemplate();
        st.add("name", getScopedname());
        return st.render();
    }

    @Override
    public String getStType()
    {
        return super.getContentTypeCode().getStType();
    }

    @Override
    public boolean isPrimitive()
    {
        return super.getContentTypeCode().isPrimitive();
    }

    @Override
    public boolean isIsStringType()
    {
        return super.getContentTypeCode().isIsStringType();
    }

    @Override
    public boolean isIsWStringType()
    {
        return super.getContentTypeCode().isIsWStringType();
    }

    @Override
    public String getInitialValue()
    {
        return super.getContentTypeCode().getInitialValue();
    }

    //{{{ Functions to know the type in string templates
    @Override
    public boolean isIsType_d()
    {
        return super.getContentTypeCode().isIsType_d();
    }

    @Override
    public boolean isIsType_c()
    {
        return super.getContentTypeCode().isIsType_c();
    }

    @Override
    public boolean isIsType_f()
    {
        return super.getContentTypeCode().isIsType_f();
    }

    public boolean isIsType_e()
    {
        return super.getContentTypeCode().isIsType_e();
    }

    @Override
    public boolean isIsSequenceType()
    {
        return super.getContentTypeCode().isIsSequenceType();
    }

    @Override
    public boolean isIsArrayType()
    {
        return super.getContentTypeCode().isIsArrayType();
    }

    @Override
    public boolean isIsMapType()
    {
        return super.getContentTypeCode().isIsMapType();
    }

    @Override
    public boolean isIsBitmaskType()
    {
        return super.getContentTypeCode().isIsBitmaskType();
    }

    @Override
    public boolean isIsEnumType()
    {
        return super.getContentTypeCode().isIsEnumType();
    }

    public boolean isIsType_10()
    {
        return true;
    }

    @Override
    public String getTypeIdentifier()
    {
        return "EK_MINIMAL";
    }

    //}}}

    //{{{ Functions that alias has to export because some typecodes have them
    public String getMaxsize()
    {
        return super.getContentTypeCode().getMaxsize();
    }

    public String getSize()
    {
        return super.getContentTypeCode().getSize();
    }

    public String getEvaluatedMaxsize() throws RuntimeGenerationException
    {
        return super.getContentTypeCode().getEvaluatedMaxsize();
    }

    public List<String> getDimensions() throws RuntimeGenerationException
    {
        if (super.getContentTypeCode() instanceof ArrayTypeCode)
        {
            return ((ArrayTypeCode) super.getContentTypeCode()).getDimensions();
        }

        throw new RuntimeGenerationException("Error in alias " + m_name +
                ": trying accessing dimensions for a non-array type");
    }

    public List<String> getEvaluatedDimensions() throws RuntimeGenerationException
    {
        if (super.getContentTypeCode() instanceof ArrayTypeCode)
        {
            return ((ArrayTypeCode) super.getContentTypeCode()).getEvaluatedDimensions();
        }

        throw new RuntimeGenerationException("Error in alias " + m_name +
                ": trying accessing dimensions for a non-array type");
    }

    public TypeCode getInheritance() // Function for alias when enclosed type is a StructTypeCode
    {
        TypeCode returnedValue = null;

        if (getContentTypeCode() instanceof StructTypeCode)
        {
            returnedValue = ((StructTypeCode)getContentTypeCode()).getInheritance();
        }

        return returnedValue;
    }

    public List<Member> getMembers() // Function for alias when enclosed type is a StructTypeCode
    {
        List<Member> returnedValue = null;

        if (getContentTypeCode() instanceof StructTypeCode)
        {
            returnedValue = ((StructTypeCode)getContentTypeCode()).getMembers();
        }

        return returnedValue;
    }

    //}}}

    private String m_name = null;

    private String m_scope = null;
}
