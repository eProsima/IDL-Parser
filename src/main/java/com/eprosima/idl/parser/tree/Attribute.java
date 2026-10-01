// Copyright 2026 Proyectos y Sistemas de Mantenimiento SL (eProsima).
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

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.typecode.TypeCode;

import org.antlr.v4.runtime.Token;

/*!
 * @brief An attribute of an interface: [readonly] attribute Type name;
 *
 * The type is either a TypeCode or, for attributes whose type is an interface, the interface Definition.
 */
public class Attribute extends TreeNode implements Export
{
    public Attribute(
            String scopeFile,
            boolean isInScope,
            String scope,
            String name,
            TypeCode typecode,
            Definition definition,
            boolean readonly,
            Token token)
    {
        super(scopeFile, isInScope, scope, name, token);
        m_typecode = typecode;
        m_definition = definition;
        m_readonly = readonly;
    }

    /*!
     * @brief Returns the type of the attribute, or null when its type is an interface (see getDefinition()).
     */
    public TypeCode getTypecode()
    {
        return m_typecode;
    }

    /*!
     * @brief Returns the interface that is the type of the attribute, or null when its type is a TypeCode.
     */
    public Definition getDefinition()
    {
        return m_definition;
    }

    public boolean isReadonly()
    {
        return m_readonly;
    }

    @Override
    public void setParent(Object obj)
    {
        m_parent = obj;
    }

    @Override
    public Object getParent()
    {
        return m_parent;
    }

    @Override
    public boolean isIsOperation()
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
    public boolean resolve(Context ctx)
    {
        return true;
    }

    private TypeCode m_typecode = null;
    private Definition m_definition = null;
    private boolean m_readonly = false;
    private Object m_parent = null;
}
