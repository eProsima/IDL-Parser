package com.eprosima.idl.generator.manager;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import com.eprosima.log.Log;

public class TemplateGroup
{
    private Map<String, StringTemplate> m_templates = null;
    private Map<String, List<TemplateExtension>> m_extensions = null;
    
    public TemplateGroup()
    {
        m_templates = new HashMap<String, StringTemplate>();
        m_extensions = new HashMap<String, List<TemplateExtension>>();
    }
    
    public void addTemplate(String groupname, StringTemplate template)
    {
        m_templates.put(groupname, template);
    }

    public void addTemplate(String groupname, StringTemplate template, List<TemplateExtension> extensions)
    {
        addTemplate(groupname, template);
        m_extensions.put(groupname + "_" + template.getName(), extensions);
    }
    
    public StringTemplate getTemplate(String groupname)
    {
        StringTemplate template = m_templates.get(groupname);

        //If there is extensiones, add them before return the template.
        if(m_extensions.containsKey(groupname + "_" + template.getName()))
        {
            List<StringTemplate> extemplates = new ArrayList<StringTemplate>();
            List<TemplateExtension> extensions = m_extensions.get(groupname + "_" + template.getName());

            for(TemplateExtension extension : extensions)
            {
                extemplates.add(extension.getStringTemplate());
            }

            template.setAttribute("extensions", extemplates);
        }

        return template;
    }
    
    public void setAttribute(String attribute, TemplateGroup tg)
    {
    	if(tg != null)
    	{
	        Set<Entry<String, StringTemplate>> set = m_templates.entrySet();
	        Iterator<Entry<String, StringTemplate>> it = set.iterator();
	        
	        while(it.hasNext())
	        {
	            Map.Entry<String, StringTemplate> m = (Map.Entry<String, StringTemplate>)it.next();
	            
	            // Call setAttribute
                StringTemplate template = tg.getTemplate(m.getKey());
                
                if(template != null)
                {
                    Log.printDebug("setting attribute (TemplateGroup) to template group " + m.getKey() + " from " + template.getName() + " to " + m.getValue().getName());
                    m.getValue().setAttribute(attribute, template.toString());
                }
	        }
    	}
    }
    
    public void setAttribute(String attribute, Object obj1)
    {
        Set<Entry<String, StringTemplate>> set = m_templates.entrySet();
        Iterator<Entry<String, StringTemplate>> it = set.iterator();
        
        while(it.hasNext())
        {
            Map.Entry<String, StringTemplate> m = (Map.Entry<String, StringTemplate>)it.next();
            
            // Call setAttribute
            Log.printDebug("setting attribute (obj1) to template group " + m.getKey() + " to " + m.getValue().getName());
            StringTemplate template = m.getValue();
            template.setAttribute(attribute, obj1);
            // Update extensions
            List<TemplateExtension> extensions = m_extensions.get(m.getKey() + "_" + template.getName());
            if(extensions != null)
            {
                for(TemplateExtension extension : extensions)
                {
                    StringTemplate tp = extension.getStringTemplate();

                    if(tp != null)
                        tp.setAttribute(attribute, obj1);
                }
            }
        }
    }
    
    public void setAttribute(String attribute, Object obj1, Object obj2)
    {
        Set<Entry<String, StringTemplate>> set = m_templates.entrySet();
        Iterator<Entry<String, StringTemplate>> it = set.iterator();
        
        while(it.hasNext())
        {
            Map.Entry<String, StringTemplate> m = (Map.Entry<String, StringTemplate>)it.next();
            
            // Call setAttribute
            Log.printDebug("setting attribute (obj1,obj2) to template group " + m.getKey() + " to " + m.getValue().getName());
            m.getValue().setAttribute(attribute, obj1, obj2);
        }
    }
    
    public void setAttribute(String attribute, Object obj1, Object obj2, Object obj3)
    {
        Set<Entry<String, StringTemplate>> set = m_templates.entrySet();
        Iterator<Entry<String, StringTemplate>> it = set.iterator();
        
        while(it.hasNext())
        {
            Map.Entry<String, StringTemplate> m = (Map.Entry<String, StringTemplate>)it.next();
            
            // Call setAttribute
            Log.printDebug("setting attribute (obj1,obj2,obj3) to template group " + m.getKey() + " to " + m.getValue().getName());
            m.getValue().setAttribute(attribute, obj1, obj2, obj3);
        }
    }
    
    public void setAttribute(String attribute, Object obj1, Object obj2, Object obj3, Object obj4)
    {
        Set<Entry<String, StringTemplate>> set = m_templates.entrySet();
        Iterator<Entry<String, StringTemplate>> it = set.iterator();
        
        while(it.hasNext())
        {
            Map.Entry<String, StringTemplate> m = (Map.Entry<String, StringTemplate>)it.next();
            
            // Call setAttribute
            Log.printDebug("setting attribute (obj1,obj2,obj3,obj4) to template group " + m.getKey() + " to " + m.getValue().getName());
            m.getValue().setAttribute(attribute, obj1, obj2, obj3, obj4);
        }
    }
    
    public void setAttribute(String attribute, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
    {
        Set<Entry<String, StringTemplate>> set = m_templates.entrySet();
        Iterator<Entry<String, StringTemplate>> it = set.iterator();
        
        while(it.hasNext())
        {
            Map.Entry<String, StringTemplate> m = (Map.Entry<String, StringTemplate>)it.next();
            
            // Call setAttribute
            Log.printDebug("setting attribute (obj1,obj2,obj3,obj4,obj5) to template group " + m.getKey() + " to " + m.getValue().getName());
            m.getValue().setAttribute(attribute, obj1, obj2, obj3, obj4, obj5);
        }
    }
}
