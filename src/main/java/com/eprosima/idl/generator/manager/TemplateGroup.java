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
import java.util.Set;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

import org.stringtemplate.v4.AutoIndentWriter;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STWriter;

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

                    Log.printDebug("setting attribute (TemplateGroup) to template group " + m.getKey() + " from " +
                            template.get_st().getName() + " to " + m.getValue().get_st().getName());
                    StringWriter out = new StringWriter();
                    STWriter wr = new AutoIndentWriter(out);
                    template.get_st().write(wr, error_listener_);
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
