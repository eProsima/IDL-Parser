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
import com.eprosima.log.ColorMessage;
import com.eprosima.idl.parser.typecode.TypeCode;
import com.eprosima.idl.context.Context;

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
    class TemplateErrorListener implements STErrorListener
    {
        @Override
        public void compileTimeError(STMessage msg)
        {
            System.out.println(ColorMessage.error() + msg.toString());
        }

        @Override
        public void runTimeError(STMessage msg)
        {
            System.out.println(ColorMessage.error() + msg.toString());
        }

        @Override
        public void IOError(STMessage msg)
        {
            System.out.println(ColorMessage.error() + msg.toString());
        }

        @Override
        public void internalError(STMessage msg)
        {
            System.out.println(ColorMessage.error() + msg.toString());
        }
    }

    private Map<String, STGroup> m_groups = null;
    private Map<String, List<TemplateExtension>> m_extensions = null;
    private STGroup strackgr_ = null;

    public TemplateManager(String stackTemplateNames, Context ctx, boolean generate_typesc)
    {
        // Load IDL types for stringtemplates
        TypeCode.idltypesgr = new STGroupFile("com/eprosima/idl/templates/idlTypes.stg", '$', '$');
        if (generate_typesc)
        {
            TypeCode.cpptypesgr = new STGroupFile("com/eprosima/idl/templates/TypesCInterface.stg", '$', '$');
        }
        else
        {
            TypeCode.cpptypesgr = new STGroupFile("com/eprosima/idl/templates/Types.stg", '$', '$');
        }
        TypeCode.ctypesgr = new STGroupFile("com/eprosima/idl/templates/CTypes.stg", '$', '$');
        TypeCode.javatypesgr = new STGroupFile("com/eprosima/idl/templates/JavaTypes.stg", '$', '$');
        TypeCode.ctx = ctx;

        m_groups = new HashMap<String, STGroup>();
        m_extensions = new HashMap<String, List<TemplateExtension>>();

        // Load specific template rules.
        /*
        if(stackTemplateNames != null && !stackTemplateNames.isEmpty())
        {
            int index = -1, lastIndex = 0;
            String templateName = null;

            while((index = stackTemplateNames.indexOf(':', lastIndex)) != -1)
            {
                templateName = stackTemplateNames.substring(lastIndex, index);
                strackgr_ = STGroup.loadGroup(templateName, DefaultTemplateLexer.class, strackgr_);
                lastIndex = index + 1;
            }

            templateName = stackTemplateNames.substring(lastIndex, stackTemplateNames.length());
            strackgr_ = STGroup.loadGroup(templateName, DefaultTemplateLexer.class, strackgr_);
        }
        */
    }

    public void changeCppTypesTemplateGroup(String templateName)
    {
        TypeCode.cpptypesgr = new STGroupFile(templateName, '$', '$');
    }

    public void addGroup(String groupname)
    {
        STGroup group = new STGroupFile(groupname, '$', '$');
        m_groups.put(groupname, group);
    }

    public void addGroup(String groupname, List<TemplateExtension> extensions)
    {
        addGroup(groupname);

        for(TemplateExtension extension : extensions)
        {
            String str = groupname + "_" + extension.getRuleName();
            List<TemplateExtension> list = null;

            if(m_extensions.containsKey(str))
            {
                list = m_extensions.get(str);
            }
            else
            {
                list = new ArrayList<TemplateExtension>();
            }

            // Set stack groups.
            extension.setCommonGroup(strackgr_);
            list.add(extension);
            m_extensions.put(str, list);
        }
    }

    public TemplateGroup createTemplateGroup(String templatename)
    {
        TemplateGroup tg = new TemplateGroup();
        Set<Entry<String, STGroup>> set = m_groups.entrySet();
        Iterator<Entry<String, STGroup>> it = set.iterator();

        while(it.hasNext())
        {
            Map.Entry<String, STGroup> m = (Map.Entry<String, STGroup>)it.next();

            // Obtain instance
            ST template = m.getValue().getInstanceOf(templatename);

            if(!m_extensions.containsKey(m.getKey() + "_" + template.getName()))
            {
                tg.addTemplate(m.getKey(), template);
            }
            else
            {
                List<TemplateExtension> extensions = m_extensions.get(m.getKey() + "_" + template.getName());
                List<ST> extensionstemplates = new ArrayList<ST>();

                for(TemplateExtension extension : extensions)
                {
                    extensionstemplates.add(extension.createStringTemplate());
                }

                tg.addTemplate(m.getKey(), template, extensionstemplates);
            }
        }

        return tg;
    }

    public ST createStringTemplate(String templatename)
    {
        return strackgr_.getInstanceOf(templatename);
    }

    public STGroup createStringTemplateGroup(String templateGroupName)
    {
        return new STGroupFile(templateGroupName, '$', '$');
    }
}
