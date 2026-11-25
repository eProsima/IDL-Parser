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

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

import org.stringtemplate.v4.AutoIndentWriter;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STWriter;

import com.eprosima.idl.parser.tree.Export;
import com.eprosima.idl.parser.tree.Interface;
import com.eprosima.idl.parser.tree.TreeNode;
import com.eprosima.idl.parser.typecode.Bitfield;
import com.eprosima.idl.parser.typecode.BitsetTypeCode;
import com.eprosima.idl.parser.typecode.Member;
import com.eprosima.idl.parser.typecode.StructTypeCode;
import com.eprosima.idl.parser.typecode.UnionTypeCode;
import com.eprosima.log.Log;

public class TemplateGroup
{
    private Map<String, TemplateST> m_templates = new HashMap<String, TemplateST>();
    private Map<String, List<ST>> m_extensionstemplates = new HashMap<String, List<ST>>();
    private TemplateErrorListener error_listener_ = null;
    private TemplateManager manager_ = null;

    public TemplateGroup(TemplateManager manager)
    {
        manager_ = manager;
        error_listener_ = new TemplateErrorListener(manager);
    }

    public void addTemplate(String groupname, TemplateST template)
    {
        m_templates.put(groupname, template);
    }

    public void addTemplate(String groupname, TemplateST template, List<ST> extensionstemplates)
    {
        addTemplate(groupname, template);
        m_extensionstemplates.put(groupname + "_" + template.get_st().getName(), extensionstemplates);
    }

    public TemplateST getTemplate(String groupname)
    {
        TemplateST template = m_templates.get(groupname);

        // The group may not define this template.
        if (template == null)
        {
            return null;
        }

        //If there is extensiones, add them before return the template.
        if(m_extensionstemplates.containsKey(groupname + "_" + template.get_st().getName()))
        {
            List<ST> extemplates = new ArrayList<ST>();
            List<ST> extensions = m_extensionstemplates.get(groupname + "_" + template.get_st().getName());

            for(ST extension : extensions)
            {
                extemplates.add(extension);
            }

            template.get_st().add("extensions", extemplates);
        }

        return template;
    }

    public void setAttribute(String attribute, TemplateGroup tg)
    {
        if(tg != null)
        {
            Set<Entry<String, TemplateST>> set = m_templates.entrySet();
            Iterator<Entry<String, TemplateST>> it = set.iterator();

            while(it.hasNext())
            {
                Map.Entry<String, TemplateST> m = it.next();

                // Call setAttribute
                TemplateST template = tg.getTemplate(m.getKey());

                if(template != null)
                {
                    // Before render, set the current TemplateSTGroup in TemplateManager.
                    manager_.set_current_template_stgroup(m.getValue().get_template_stgroup());

                    // If the template renders the class of a type, the names declared inside it hide types with the
                    // same name while rendering it.
                    TemplateManager.HidingNames hiding_names = get_hiding_names(template.get_st());

                    if (null != hiding_names)
                    {
                        manager_.push_hiding_names(hiding_names);
                    }

                    Log.printDebug("setting attribute (TemplateGroup) to template group " + m.getKey() + " from " +
                            template.get_st().getName() + " to " + m.getValue().get_st().getName());
                    StringWriter out = new StringWriter();
                    STWriter wr = new AutoIndentWriter(out);
                    try
                    {
                        template.get_st().write(wr, error_listener_);
                    }
                    finally
                    {
                        if (null != hiding_names)
                        {
                            manager_.pop_hiding_names();
                        }
                    }
                    String out_string = out.toString();

                    if (!out_string.isBlank())
                    {
                        m.getValue().get_st().add(attribute, out.toString());
                    }

                    // Unset the current TemplateSTGroup in TemplateManager.
                    manager_.set_current_template_stgroup(null);
                }
            }
        }
    }

    /*!
     * @brief Returns the names declared inside the class rendered by a template (`struct_type`, `union_type`,
     * `bitset_type`, `exception` or `interface`), or null if the template does not render the class of a type.
     * Members of inherited types are also taken into account, as they are visible inside the derived class.
     */
    private static TemplateManager.HidingNames get_hiding_names(
            ST st)
    {
        Map<String, Object> attributes = st.getAttributes();

        if (null == attributes)
        {
            return null;
        }

        Set<String> names = new HashSet<String>();
        Object type = null;

        if (null != (type = attributes.get("struct")) && type instanceof StructTypeCode)
        {
            StructTypeCode struct_type = (StructTypeCode)type;
            add_member_names(names, struct_type.getAllMembers());
            return new TemplateManager.HidingNames(struct_type.getFullScopedname(), struct_type.getName(), names);
        }
        else if (null != (type = attributes.get("union")) && type instanceof UnionTypeCode)
        {
            UnionTypeCode union_type = (UnionTypeCode)type;
            add_member_names(names, union_type.getMembers());
            return new TemplateManager.HidingNames(union_type.getFullScopedname(), union_type.getName(), names);
        }
        else if (null != (type = attributes.get("bitset")) && type instanceof BitsetTypeCode)
        {
            BitsetTypeCode bitset_type = (BitsetTypeCode)type;
            for (Bitfield bitfield : bitset_type.getBitfields())
            {
                names.add(bitfield.getName());
            }
            names.remove("");
            return new TemplateManager.HidingNames(bitset_type.getFullScopedname(), bitset_type.getName(), names);
        }
        else if (null != (type = attributes.get("exception")) &&
                type instanceof com.eprosima.idl.parser.tree.Exception)
        {
            com.eprosima.idl.parser.tree.Exception exception = (com.eprosima.idl.parser.tree.Exception)type;
            add_member_names(names, exception.getMembers());
            return new TemplateManager.HidingNames(exception.getScopedname(), exception.getName(), names);
        }
        else if (null != (type = attributes.get("interface")) && type instanceof Interface)
        {
            Interface interface_object = (Interface)type;
            add_operation_and_attribute_names(names, interface_object, new HashSet<Interface>());
            return new TemplateManager.HidingNames(interface_object.getScopedname(), interface_object.getName(),
                           names);
        }

        return null;
    }

    private static void add_member_names(
            Set<String> names,
            List<Member> members)
    {
        if (null != members)
        {
            for (Member member : members)
            {
                names.add(member.getName());
            }
        }
    }

    private static void add_operation_and_attribute_names(
            Set<String> names,
            Interface interface_object,
            Set<Interface> visited)
    {
        if (!visited.add(interface_object))
        {
            return;
        }

        for (Export export : interface_object.getExports())
        {
            if ((export.isIsOperation() || export.isIsAttribute()) && export instanceof TreeNode)
            {
                names.add(((TreeNode)export).getName());
            }
        }

        for (Interface base : interface_object.getBases())
        {
            add_operation_and_attribute_names(names, base, visited);
        }
    }

    public void setAttribute(String attribute, Object obj1)
    {
        Set<Entry<String, TemplateST>> set = m_templates.entrySet();
        Iterator<Entry<String, TemplateST>> it = set.iterator();

        while(it.hasNext())
        {
            Map.Entry<String, TemplateST> m = it.next();

            // Call setAttribute
            Log.printDebug("setting attribute (obj1) to template group " + m.getKey() + " to " +
                    m.getValue().get_st().getName());
            TemplateST template = m.getValue();
            template.get_st().add(attribute, obj1);
            // Update extensions
            List<ST> extensions = m_extensionstemplates.get(m.getKey() + "_" + template.get_st().getName());
            if(extensions != null)
            {
                for(ST extension : extensions)
                {
                    extension.add(attribute, obj1);
                }
            }
        }
    }
}
