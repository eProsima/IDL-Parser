package com.eprosima.idl.generator.manager;

import com.eprosima.idl.generator.manager.TemplateGroup;
import com.eprosima.log.ColorMessage;
import com.eprosima.idl.parser.typecode.TypeCode;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class TemplateManager
{
    class TemplateErrorListener implements StringTemplateErrorListener
    {  
        public void error(String arg0, Throwable arg1)
        {
            System.out.println(ColorMessage.error() + arg0);
            arg1.printStackTrace();
        }

        public void warning(String arg0)
        {
            System.out.println(ColorMessage.warning() + arg0);   
        }   
    }

    static private String m_loaderDirectories = "com/eprosima/idl/templates";
    private Map<String, StringTemplateGroup> m_groups;
    private StringTemplateGroup stackgr = null;
    
    public TemplateManager(String stackTemplateNames)
    {
        StringTemplateGroupLoader loader = new CommonGroupLoader(m_loaderDirectories, new TemplateErrorListener());
        StringTemplateGroup.registerGroupLoader(loader);

        // Load IDL types for stringtemplates
        TypeCode.idltypesgr = StringTemplateGroup.loadGroup("idlTypes", DefaultTemplateLexer.class, null);
        TypeCode.cpptypesgr = StringTemplateGroup.loadGroup("Types", DefaultTemplateLexer.class, null);

        m_groups = new HashMap<String, StringTemplateGroup>();
        
        // Load specific template rules.
        if(stackTemplateNames != null && !stackTemplateNames.isEmpty())
        {
            int index = -1, lastIndex = 0;
            String templateName = null;

            while((index = stackTemplateNames.indexOf(':', lastIndex)) != -1)
            {
                templateName = stackTemplateNames.substring(lastIndex, index);
                stackgr = StringTemplateGroup.loadGroup(templateName, DefaultTemplateLexer.class, stackgr); 
                lastIndex = index + 1;
            }

            templateName = stackTemplateNames.substring(lastIndex, stackTemplateNames.length());
            stackgr = StringTemplateGroup.loadGroup(templateName, DefaultTemplateLexer.class, stackgr); 
        }
    }

    static public void setGroupLoaderDirectories(String paths)
    {
        m_loaderDirectories += ":" + paths;
    }

    public void changeCppTypesTemplateGroup(String templateName)
    {
        TypeCode.cpptypesgr = StringTemplateGroup.loadGroup(templateName, DefaultTemplateLexer.class, null);
    }

    public void addGroup(String groupname)
    {
        StringTemplateGroup group = StringTemplateGroup.loadGroup(groupname, DefaultTemplateLexer.class, stackgr);
        m_groups.put(groupname, group);
    }
    
    public TemplateGroup createTemplateGroup(String templatename)
    {
        TemplateGroup tg = new TemplateGroup();
        Set<Entry<String, StringTemplateGroup>> set = m_groups.entrySet();
        Iterator<Entry<String, StringTemplateGroup>> it = set.iterator();
        
        while(it.hasNext())
        {
            Map.Entry<String, StringTemplateGroup> m = (Map.Entry<String, StringTemplateGroup>)it.next();
            
            // Obtain instance
            StringTemplate template = m.getValue().getInstanceOf(templatename);
            tg.addTemplate(m.getKey(), template);
        }
        
        return tg;
    }
    
    public StringTemplate createStringTemplate(String templatename)
    {     
        return stackgr.getInstanceOf(templatename);
    }
}
