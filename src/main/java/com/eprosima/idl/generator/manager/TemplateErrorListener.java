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

import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.misc.STMessage;

import com.eprosima.log.ColorMessage;

public class TemplateErrorListener implements STErrorListener
{
    private TemplateManager manager_;
    public TemplateErrorListener(TemplateManager manager)
    {
        manager_ = manager;
    }

    @Override
    public void compileTimeError(STMessage msg)
    {
        System.err.println(ColorMessage.error() + msg.toString());
        if (null != manager_)
        {
            manager_.set_st_error();
        }
    }

    @Override
    public void runTimeError(STMessage msg)
    {
        System.err.println(ColorMessage.error() + msg.toString());
        if (null != manager_)
        {
            manager_.set_st_error();
        }
    }

    @Override
    public void IOError(STMessage msg)
    {
        System.err.println(ColorMessage.error() + msg.toString());
        if (null != manager_)
        {
            manager_.set_st_error();
        }
    }

    @Override
    public void internalError(STMessage msg)
    {
        System.err.println(ColorMessage.error() + msg.toString());
        if (null != manager_)
        {
            manager_.set_st_error();
        }
    }
}
