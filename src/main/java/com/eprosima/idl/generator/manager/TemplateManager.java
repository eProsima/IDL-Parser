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

package com.eprosima.idl.generator.manager;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import org.stringtemplate.v4.*;
import org.stringtemplate.v4.misc.STMessage;

public class TemplateManager
{
    private Map<String, TemplateSTGroup> m_groups = new HashMap<String, TemplateSTGroup>();

    private boolean st_error_ = false;

    private TemplateSTGroup current_template_stgroup_ = null;

    /*!
     * Names declared inside the class being rendered (members, accessors, operations...), for each nested render.
     * Inside that class they hide any type with the same name.
     */
    private Deque<HidingNames> hiding_names_stack_ = new ArrayDeque<HidingNames>();

    /*!
     * @brief Names declared inside the class of a type being rendered.
     */
    public static class HidingNames
    {
        /*!
         * @param full_scoped_name Full scoped name of the type whose class is being rendered.
         * @param name Name of the type whose class is being rendered (its injected class name).
         * @param declared_names Names declared inside the class (members, accessors, operations...).
         */
        public HidingNames(
                String full_scoped_name,
                String name,
                Set<String> declared_names)
        {
            full_scoped_name_ = full_scoped_name;
            name_ = name;
            declared_names_ = declared_names;
        }

        /*!
         * @brief Returns whether a type referenced as `first_identifier[::...]` inside the class would be resolved to
         * a declaration of the class instead of the type.
         * @param first_identifier First identifier of the name used to reference the type.
         * @param full_scoped_name Full scoped name of the referenced type.
         */
        public boolean hides(
                String first_identifier,
                String full_scoped_name)
        {
            if (declared_names_.contains(first_identifier))
            {
                return true;
            }

            // The injected class name only hides other types (i.e. `::S` inside `m::S`).
            return first_identifier.equals(name_) && !full_scoped_name.equals(full_scoped_name_);
        }

        private String full_scoped_name_;

        private String name_;

        private Set<String> declared_names_;
    }

    public TemplateSTGroup addGroup(String groupname)
    {
        TemplateSTGroup group = new TemplateSTGroup(groupname);
        m_groups.put(groupname, group);
        return group;
    }

    public TemplateSTGroup addGroupFromString(String groupname, String text)
    {
        TemplateSTGroup group = new TemplateSTGroup(groupname, text);
        m_groups.put(groupname, group);
        return group;
    }

    public TemplateGroup createTemplateGroup(String templatename)
    {
        TemplateGroup tg = new TemplateGroup(this);
        Set<Entry<String, TemplateSTGroup>> set = m_groups.entrySet();
        Iterator<Entry<String, TemplateSTGroup>> it = set.iterator();

        while(it.hasNext())
        {
            Map.Entry<String, TemplateSTGroup> m = it.next();

            // Groups that do not define the template do not take part in it.
            if (!m.getValue().get_stgroup().isDefined(templatename))
            {
                continue;
            }

            // Obtain instance
            TemplateST template = new TemplateST(m.getValue(), templatename);
            tg.addTemplate(m.getKey(), template);
        }

        return tg;
    }


    /*!
     * @brief Returns whether any loaded template group defines a template.
     */
    public boolean isTemplateDefined(String templatename)
    {
        for (TemplateSTGroup group : m_groups.values())
        {
            if (group.get_stgroup().isDefined(templatename))
            {
                return true;
            }
        }

        return false;
    }

    public STGroup createStringTemplateGroup(String templateGroupName)
    {
        return new STGroupFile(templateGroupName, '$', '$');
    }

    public void set_st_error()
    {
        st_error_ = true;
    }

    public boolean get_st_error()
    {
        return st_error_;
    }

    public void set_current_template_stgroup(TemplateSTGroup template_stgroup)
    {
        current_template_stgroup_ = template_stgroup;
    }

    public boolean is_enabled_custom_property_in_current_group(String custom_property)
    {
        if (null != current_template_stgroup_)
        {
            return current_template_stgroup_.is_enabled_custom_property(custom_property);
        }

        return false;
    }

    /*!
     * @brief Starts rendering the class of a type. Until `pop_hiding_names()`, the names declared inside it hide
     * types with the same name.
     */
    public void push_hiding_names(HidingNames hiding_names)
    {
        hiding_names_stack_.push(hiding_names);
    }

    public void pop_hiding_names()
    {
        hiding_names_stack_.pop();
    }

    /*!
     * @brief Returns whether a type referenced as `first_identifier[::...]` would be hidden by a declaration of the
     * class being rendered.
     */
    public boolean is_hidden_in_current_class(
            String first_identifier,
            String full_scoped_name)
    {
        HidingNames current = hiding_names_stack_.peek();
        return null != current && current.hides(first_identifier, full_scoped_name);
    }
}
