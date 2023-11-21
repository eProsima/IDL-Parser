// Copyright 2023 Proyectos y Sistemas de Mantenimiento SL (eProsima).
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

import org.stringtemplate.v4.*;

public class TemplateST
{
    public TemplateST(TemplateSTGroup parent_group, String template_name)
    {
        parent_group_ = parent_group;
        st_ = parent_group_.get_stgroup().getInstanceOf(template_name);
    }

    public ST get_st()
    {
        return st_;
    }

    public TemplateSTGroup get_template_stgroup()
    {
        return parent_group_;
    }

    private ST st_ = null;
    private TemplateSTGroup parent_group_ = null;
};
