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

import java.util.ArrayList;

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

    /*!
     * @brief Adds an exception of the getraises clause (raises, for a readonly attribute). It is resolved by resolve().
     */
    public void addGetRaises(String ename)
    {
        m_unresolvedGetRaises.add(ename);
    }

    /*!
     * @brief Adds an exception of the setraises clause. It is resolved by resolve().
     */
    public void addSetRaises(String ename)
    {
        m_unresolvedSetRaises.add(ename);
    }

    /*!
     * @brief Returns the exceptions that reading the attribute may raise.
     */
    public ArrayList<com.eprosima.idl.parser.tree.Exception> getGetRaises()
    {
        return m_getRaises;
    }

    /*!
     * @brief Returns the exceptions that writing the attribute may raise.
     */
    public ArrayList<com.eprosima.idl.parser.tree.Exception> getSetRaises()
    {
        return m_setRaises;
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
    public boolean isIsAttribute()
    {
        return true;
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
        boolean ret = resolveRaises(ctx, m_unresolvedGetRaises, m_getRaises);
        return resolveRaises(ctx, m_unresolvedSetRaises, m_setRaises) && ret;
    }

    /*!
     * @brief Looks up the exceptions of a raises clause among the declared ones and those of the parent interface.
     */
    private boolean resolveRaises(
            Context ctx,
            ArrayList<String> names,
            ArrayList<com.eprosima.idl.parser.tree.Exception> exceptions)
    {
        boolean ret = true;

        for (String name : names)
        {
            // Exceptions are stored by their scoped name, without the leading "::" of a fully qualified name.
            com.eprosima.idl.parser.tree.Exception exception = ctx.getException(
                name.startsWith("::") ? name.substring(2) : name);

            if (exception == null && m_parent instanceof Interface)
            {
                exception = ((Interface)m_parent).getException(ctx.getScope(), name);
            }

            if (exception != null)
            {
                exceptions.add(exception);
            }
            else
            {
                System.out.println("ERROR: The definition of exception " + name + " was not found");
                ret = false;
            }
        }

        names.clear();
        return ret;
    }

    private TypeCode m_typecode = null;
    private Definition m_definition = null;
    private boolean m_readonly = false;
    private ArrayList<String> m_unresolvedGetRaises = new ArrayList<String>();
    private ArrayList<String> m_unresolvedSetRaises = new ArrayList<String>();
    private ArrayList<com.eprosima.idl.parser.tree.Exception> m_getRaises =
            new ArrayList<com.eprosima.idl.parser.tree.Exception>();
    private ArrayList<com.eprosima.idl.parser.tree.Exception> m_setRaises =
            new ArrayList<com.eprosima.idl.parser.tree.Exception>();
    private Object m_parent = null;
}
