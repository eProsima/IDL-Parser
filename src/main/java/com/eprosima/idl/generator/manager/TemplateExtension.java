package com.eprosima.idl.generator.manager;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

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

    public void setCommonGroup(StringTemplateGroup cgroup)
    {
        cgroup_ = cgroup;
    }

    public StringTemplate createStringTemplate()
    {
        return cgroup_.getInstanceOf(extensionName_);
    }

    private String ruleName_ = null;
    private String extensionName_ = null;
    private StringTemplateGroup cgroup_ = null;
}
