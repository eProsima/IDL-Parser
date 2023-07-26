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

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

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

    public void setCommonGroup(STGroup cgroup)
    {
        cgroup_ = cgroup;
    }

    public ST createStringTemplate()
    {
        return cgroup_.getInstanceOf(extensionName_);
    }

    private String ruleName_ = null;
    private String extensionName_ = null;
    private STGroup cgroup_ = null;
}
