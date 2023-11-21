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
     * @brief Returns if the current `Context` scope will be remove from the scoped name of types (returned by
     * `getScopedname()`).
     */
    public boolean is_enabled_using_explicitly_modules()
    {
        return using_explicitly_modules_;
    }

    /*!
     * @brief Enable removing the current `Context` scope from the scoped name of types (returned by `getScopedname()`).
     */
    public void enable_using_explicitly_modules()
    {
        using_explicitly_modules_ = true;
    }

    private STGroup st_group_ = null;

    //! If set, the scoped name of types (returned by `getScopedname()`) will remove the current `Context` scope.
    private boolean using_explicitly_modules_ = false;
};
