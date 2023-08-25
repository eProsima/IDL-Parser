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

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

import org.stringtemplate.v4.ST;

import com.eprosima.log.Log;

public class TemplateGroup
{
    private Map<String, ST> m_templates = null;
    private Map<String, List<ST>> m_extensionstemplates = null;

    public TemplateGroup()
    {
        m_templates = new HashMap<String, ST>();
        m_extensionstemplates = new HashMap<String, List<ST>>();
    }

    public void addTemplate(String groupname, ST template)
    {
        m_templates.put(groupname, template);
    }

    public void addTemplate(String groupname, ST template, List<ST> extensionstemplates)
    {
        addTemplate(groupname, template);
        m_extensionstemplates.put(groupname + "_" + template.getName(), extensionstemplates);
    }

    public ST getTemplate(String groupname)
    {
        ST template = m_templates.get(groupname);

        //If there is extensiones, add them before return the template.
        if(m_extensionstemplates.containsKey(groupname + "_" + template.getName()))
        {
            List<ST> extemplates = new ArrayList<ST>();
            List<ST> extensions = m_extensionstemplates.get(groupname + "_" + template.getName());

            for(ST extension : extensions)
            {
                extemplates.add(extension);
            }

            template.add("extensions", extemplates);
        }

        return template;
    }

    public void setAttribute(String attribute, TemplateGroup tg)
    {
        if(tg != null)
        {
            Set<Entry<String, ST>> set = m_templates.entrySet();
            Iterator<Entry<String, ST>> it = set.iterator();

            while(it.hasNext())
            {
                Map.Entry<String, ST> m = (Map.Entry<String, ST>)it.next();

                // Call setAttribute
                ST template = tg.getTemplate(m.getKey());

                if(template != null)
                {
                    Log.printDebug("setting attribute (TemplateGroup) to template group " + m.getKey() + " from " + template.getName() + " to " + m.getValue().getName());
                    m.getValue().add(attribute, template.render());
                }
            }
        }
    }

    public void setAttribute(String attribute, Object obj1)
    {
        Set<Entry<String, ST>> set = m_templates.entrySet();
        Iterator<Entry<String, ST>> it = set.iterator();

        while(it.hasNext())
        {
            Map.Entry<String, ST> m = (Map.Entry<String, ST>)it.next();

            // Call setAttribute
            Log.printDebug("setting attribute (obj1) to template group " + m.getKey() + " to " + m.getValue().getName());
            ST template = m.getValue();
            template.add(attribute, obj1);
            // Update extensions
            List<ST> extensions = m_extensionstemplates.get(m.getKey() + "_" + template.getName());
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
