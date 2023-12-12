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

import com.eprosima.idl.parser.typecode.TypeCode;

public class Annotation
{
    public static final String autoid_str = "autoid";
    public static final String autoid_enum_str = "AutoidKind";
    public static final String autoid_sequential_str = "SEQUENTIAL";
    public static final String autoid_sequential_value_str = "0";
    public static final String autoid_hash_str = "HASH";

    public static final String hashid_str = "hashid";
    public static final String id_str = "id";
    public static final String key_str = "key";

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

    public static final String value_str = "value";

    public static final String optional_str = "optional";
    public static final String external_str = "external";
    
    public static final String try_construct_str = "try_construct";
    public static final String try_construct_discard_str = "DISCARD";
    public static final String try_construct_use_default_str = "USE_DEFAULT";
    public static final String try_construct_trim_str = "TRIM";

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
    public String getScopedname()
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
    public String getFullScopedname()
    {
        if(m_declaration != null)
        {
            return m_declaration.getScopedname();
        }

        return null;
    }

    public String getROS2Scopedname()
    {
        if(m_declaration != null)
        {
            return m_declaration.getROS2Scopedname();
        }

        return null;
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

    public String getValue()
    {
        if(m_members.size() != 1)
        {
            return null;
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
        return getName().equals("verbatim");
    }

    public boolean isIsUnit()
    {
        return getName().equals("unit");
    }

    public boolean isIsMax()
    {
        return getName().equals("max");
    }

    public boolean isIsMin()
    {
        return getName().equals("min");
    }

    public boolean isIsRange()
    {
        return getName().equals("range");
    }

    public boolean isIsHashId()
    {
        return getName().equals("hashid");
    }

    public boolean isIsBuiltin()
    {
        if (getName().equals("id") ||
            getName().equals("autoid") ||
            getName().equals("optional") ||
            getName().equals("position") ||
            getName().equals("value") ||
            getName().equals("extensibility") ||
            getName().equals("final") ||
            getName().equals("appendable") ||
            getName().equals("mutable") ||
            getName().equals("key") ||
            getName().equals("Key") ||
            getName().equals("must_understand") ||
            getName().equals("default_literal") ||
            getName().equals("default") ||
            getName().equals("range") ||
            getName().equals("min") ||
            getName().equals("max") ||
            getName().equals("unit") ||
            getName().equals("bit_bound") ||
            getName().equals("external") ||
            getName().equals("nested") ||
            getName().equals("verbatim") ||
            getName().equals("service") ||
            getName().equals("oneway") ||
            getName().equals("ami") ||
            getName().equals("hashid") ||
            getName().equals("default_nested") ||
            getName().equals("ignore_literal_names") ||
            getName().equals("try_construct") ||
            getName().equals("non_serialized") ||
            getName().equals("data_representation") ||
            getName().equals("topic"))
        {
            return true;
        }
        return false;
    }

    public int getValuesSize()
    {
        return m_members.size();
    }

    private HashMap<String, AnnotationMember> m_members = null;
    private AnnotationDeclaration m_declaration = null;
}
