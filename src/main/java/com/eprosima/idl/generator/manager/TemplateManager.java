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

import com.eprosima.idl.generator.manager.TemplateGroup;

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

            // Obtain instance
            TemplateST template = new TemplateST(m.getValue(), templatename);
            tg.addTemplate(m.getKey(), template);
        }

        return tg;
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

    public TemplateSTGroup get_current_template_stgroup()
    {
        return current_template_stgroup_;
    }
}
