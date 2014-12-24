package com.eprosima.idl.generator.manager;

import org.antlr.stringtemplate.StringTemplate;

public class TemplateExtension
{
    public TemplateExtension(String ruleName, String extensionName)
    {
        ruleName_ = ruleName;
        extensionName_ = extensionName;
    }

    public String getRuleName()
    {
        return ruleName_;
    }

    public String getExtensionName()
    {
        return extensionName_;
    }

    public void setStringTemplate(StringTemplate template)
    {
        template_ = template;
    }

    public StringTemplate getStringTemplate()
    {
        return template_;
    }

    private String ruleName_ = null;
    private String extensionName_ = null;
    private StringTemplate template_ = null;
}
