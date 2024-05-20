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

package com.eprosima.idl.parser.tree;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

import com.eprosima.idl.parser.exception.RuntimeGenerationException;
import com.eprosima.idl.parser.typecode.TypeCode;

public class Annotation
{
    public static final String null_default_value = "0";
    public static final String true_str = "true";
    public static final String capitalized_true_str = "TRUE";
    public static final String empty_str = "";
    public static final String any_str = "*";

    public static final String ami_str = "ami";

    //{{{ @autoid
    public static final String autoid_str = "autoid";
    public static final String autoid_enum_str = "AutoidKind";
    public static final String autoid_sequential_str = "SEQUENTIAL";
    public static final String autoid_sequential_value_str = "0";
    public static final String autoid_hash_str = "HASH";
    public static final String autoid_hash_value_str = "1";
    //}}}

    public static final String bit_bound_str = "bit_bound";

    //{{{ @data_representation
    public static final String data_representation_mask_str = "DataRepresentationMask";
    public static final String xcdr1_bitflag_str = "XCDR1";
    public static final String xml_bitflag_str = "XML";
    public static final String xcdr2_bitflag_str = "XCDR2";
    public static final String data_representation_str = "data_representation";
    public static final String allowed_kinds_str = "allowed_kinds";
    //}}}

    public static final String default_str = "default";
    public static final String default_literal_str = "default_literal";
    public static final String default_nested_str = "default_nested";

    //{{{ @extensibility
    public static final String extensibility_str = "extensibility";
    public static final String extensibility_enum_str = "ExtensibilityKind";
    public static final String final_str = "final";
    public static final String appendable_str = "appendable";
    public static final String mutable_str = "mutable";
    public static final String ex_final_str = "FINAL";
    public static final String ex_final_val = "0";
    public static final String ex_appendable_str = "APPENDABLE";
    public static final String ex_appendable_val = "1";
    public static final String ex_mutable_str = "MUTABLE";
    public static final String ex_mutable_val = "2";
    //}}}

    public static final String external_str = "external";
    public static final String hashid_str = "hashid";
    public static final String id_str = "id";
    public static final String ignore_literal_names_str = "ignore_literal_names";

    ///{{{ @key
    public static final String key_str = "key";
    public static final String eprosima_key_str = "Key";
    //}}}

    public static final String max_str = "max";
    public static final String min_str = "min";
    public static final String must_understand_str = "must_understand";
    public static final String nested_str = "nested";
    public static final String non_serialized_str = "non_serialized";
    public static final String oneway_str = "oneway";
    public static final String optional_str = "optional";
    public static final String position_str = "position";
    public static final String range_str = "range";

    //{{{ @service
    public static final String service_str = "service";
    public static final String platform_str = "platform";
    //}}}

    //{{{ @topic
    public static final String topic_str = "topic";
    public static final String name_str = "name";
    //}}}

    //{{{ @try_construct
    public static final String try_construct_str = "try_construct";
    public static final String try_construct_enum_str = "TryConstructFailAction";
    public static final String try_construct_discard_str = "DISCARD";
    public static final String try_construct_use_default_str = "USE_DEFAULT";
    public static final String try_construct_trim_str = "TRIM";
    //}}}

    public static final String unit_str = "unit";
    public static final String value_str = "value";

    //{{{ @verbatim
    public static final String verbatim_str = "verbatim";
    public static final String placement_enum_str = "PlacementKind";
    public static final String begin_file_str = "BEGIN_FILE";
    public static final String before_declaration_str = "BEFORE_DECLARATION";
    public static final String begin_declaration_str = "BEGIN_DECLARATION";
    public static final String end_declaration_str = "END_DECLARATION";
    public static final String after_declaration_str = "AFTER_DECLARATION";
    public static final String end_file_str = "END_FILE";
    public static final String language_str = "language";
    public static final String placement_str = "placement";
    public static final String text_str = "text";
    //}}}

    public Annotation(AnnotationDeclaration declaration)
    {
        m_declaration = declaration;
        m_members = new HashMap<String, AnnotationMember>();

        for(AnnotationMember ann : declaration.getMembers())
        {
            AnnotationMember member = new AnnotationMember(ann);
            m_members.put(member.getName(), member);
        }
    }

    public String getName()
    {
        if(m_declaration != null)
        {
            return m_declaration.getName();
        }

        return null;
    }

    /*!
     * @brief Returns the full scoped name of the type, unless the developer uses
     * `TemplateSTGroup.enable_using_explicitly_modules()`, by removing from the full scoped name the current
     * `Context` scope.
     */
    public String getScopedname() throws RuntimeGenerationException
    {
        String scoped_name = getFullScopedname();

        if (!com.eprosima.idl.parser.typecode.TypeCode.ctx.is_enabled_custom_property_in_current_group(com.eprosima.idl.parser.typecode.TypeCode.ctx.using_explicitly_modules_custom_property))
        {
            return scoped_name;
        }

        String current_scope = com.eprosima.idl.parser.typecode.TypeCode.ctx.getScope();

        if(current_scope.isEmpty() || !scoped_name.startsWith(current_scope + "::"))
        {
            return scoped_name;
        }

        return scoped_name.replace(current_scope + "::", "");
    }

    /*!
     * @brief Return the scoped name of the type.
     */
    public String getFullScopedname() throws RuntimeGenerationException
    {
        if(m_declaration == null)
        {
            throw new RuntimeGenerationException("Annotation declaration not initialized");
        }
        return m_declaration.getScopedname();
    }

    public String getROS2Scopedname() throws RuntimeGenerationException
    {
        if(m_declaration == null)
        {
            throw new RuntimeGenerationException("Annotation declaration not initialized");
        }
        return m_declaration.getROS2Scopedname();
    }

    public boolean addValue(String value)
    {
        if(m_members.size() != 1)
        {
            return false;
        }

        ((AnnotationMember)m_members.values().toArray()[0]).setValue(value);

        return true;
    }

    public boolean addValue(String attribute, String value)
    {
        AnnotationMember member = m_members.get(attribute);

        if(member != null)
        {
            member.setValue(value);
            // Check that in case of an Enum the set value is in the enumeration.
            // ParseException is thrown otherwise.
            member.getEnumStringValue();
        }
        else
        {
            return false;
        }

        return true;
    }

    public String getValue() throws RuntimeGenerationException
    {
        if(m_members.size() != 1)
        {
            throw new RuntimeGenerationException("Error in annotation " + getName() +
                    ": accessing value of a multiple parameter exception");
        }

        return ((AnnotationMember)m_members.values().toArray()[0]).getValue();
    }

    public String getValue(String attribute)
    {
        return m_members.get(attribute).getValue();
    }

    public Map<String, AnnotationMember> getValues()
    {
        return m_members;
    }

    public Collection<AnnotationMember> getValueList()
    {
        return m_members.values();
    }

    public boolean isIsVerbatim()
    {
        return getName().equals(Annotation.verbatim_str);
    }

    public boolean isIsUnit()
    {
        return getName().equals(Annotation.unit_str);
    }

    public boolean isIsMax()
    {
        return getName().equals(Annotation.max_str);
    }

    public boolean isIsMin()
    {
        return getName().equals(Annotation.min_str);
    }

    public boolean isIsRange()
    {
        return getName().equals(Annotation.range_str);
    }

    public boolean isIsHashId()
    {
        return getName().equals(Annotation.hashid_str);
    }

    public boolean isIsBuiltin()
    {
        if (getName().equals(Annotation.ami_str) ||
            getName().equals(Annotation.appendable_str) ||
            getName().equals(Annotation.autoid_str) ||
            getName().equals(Annotation.bit_bound_str) ||
            getName().equals(Annotation.data_representation_str) ||
            getName().equals(Annotation.default_str) ||
            getName().equals(Annotation.default_literal_str) ||
            getName().equals(Annotation.default_nested_str) ||
            getName().equals(Annotation.eprosima_key_str) ||
            getName().equals(Annotation.extensibility_str) ||
            getName().equals(Annotation.external_str) ||
            getName().equals(Annotation.final_str) ||
            getName().equals(Annotation.hashid_str) ||
            getName().equals(Annotation.id_str) ||
            getName().equals(Annotation.ignore_literal_names_str) ||
            getName().equals(Annotation.key_str) ||
            getName().equals(Annotation.max_str) ||
            getName().equals(Annotation.min_str) ||
            getName().equals(Annotation.must_understand_str) ||
            getName().equals(Annotation.mutable_str) ||
            getName().equals(Annotation.nested_str) ||
            getName().equals(Annotation.non_serialized_str) ||
            getName().equals(Annotation.oneway_str) ||
            getName().equals(Annotation.optional_str) ||
            getName().equals(Annotation.position_str) ||
            getName().equals(Annotation.range_str) ||
            getName().equals(Annotation.service_str) ||
            getName().equals(Annotation.topic_str) ||
            getName().equals(Annotation.try_construct_str) ||
            getName().equals(Annotation.unit_str) ||
            getName().equals(Annotation.value_str) ||
            getName().equals(Annotation.verbatim_str))
        {
            return true;
        }
        return false;
    }

    public int getValuesSize()
    {
        return m_members.size();
    }

    public AnnotationDeclaration getAnnotationDeclaration()
    {
        return m_declaration;
    }

    private HashMap<String, AnnotationMember> m_members = null;
    private AnnotationDeclaration m_declaration = null;
}
