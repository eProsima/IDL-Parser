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

package com.eprosima.idl.parser.tree;

import java.util.ArrayList;

import org.antlr.v4.runtime.Token;

public class Module extends DefinitionContainer implements Definition
{
    public Module(String scopeFile, boolean isInScope, String scope, String name, Token tk)
    {
        super(scopeFile, isInScope, scope, name, tk);
    }

    public void setParent(Object obj)
    {
        m_parent = obj;
    }

    public Object getParent()
    {
        return m_parent;
    }


    /*!
     * @brief This function is used in stringtemplates to not generate module in some cases (Right now in RequestReply.idl).
     */
    public boolean isThereAreValidDefinitions()
    {
        boolean returnedValue = false;

	    for(int count = 0; !returnedValue && count < getDefinitions().size(); ++count)
        {
            returnedValue = getDefinitions().get(count).isIsInterface();
        }

        return returnedValue;
    }

    /*!
     * @brief This function is used in stringtemplates to not generate module in some cases (Right now in generated (previous c) idl).
     */
    public boolean isThereAreDeclarations()
    {
        boolean returnedValue = false;

        for(int count = 0; !returnedValue && count < getDefinitions().size(); ++count)
        {
            if(getDefinitions().get(count).isIsInterface())
            {
                returnedValue = ((Interface)getDefinitions().get(count)).isThereAreDeclarations();
            }
            else
            {
                returnedValue = getDefinitions().get(count).isIsTypeDeclaration() ||
                    getDefinitions().get(count).isIsException();
            }
        }

        return returnedValue;
    }

    @Override
    public boolean isIsModule()
    {
        return true;
    }

    @Override
    public boolean isIsInterface()
    {
        return false;
    }

    @Override
    public boolean isIsException()
    {
        return false;
    }

    @Override
    public boolean isIsTypeDeclaration()
    {
        return false;
    }

    @Override
    public boolean isIsConstDeclaration()
    {
        return false;
    }

	@Override
    public boolean isIsAnnotation()
    {
        return false;
    }

    private Object m_parent = null;
}
