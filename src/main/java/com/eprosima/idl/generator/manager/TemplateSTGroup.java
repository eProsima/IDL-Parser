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
import java.util.ArrayList;

public class TemplateSTGroup
{
    public TemplateSTGroup(String groupname)
    {
        st_group_ = new STGroupFile(groupname, '$', '$');
    }

    public TemplateSTGroup(String groupname, String text)
    {
        st_group_ = new STGroupString(groupname, text, '$', '$');
    }

    public STGroup get_stgroup()
    {
        return st_group_;
    }

    /*!
     * @brief Checks a custom property was added in this template group.
     */
    public boolean is_enabled_custom_property(String custom_property)
    {
        return custom_properties.contains(custom_property);
    }

    /*!
     * @brief Enables a custom property.
     */
    public void enable_custom_property(String custom_property)
    {
        custom_properties.add(custom_property);
    }

    private STGroup st_group_ = null;

    //! List of custom properties added by the user.
    ArrayList<String> custom_properties = new ArrayList<String>();
};
