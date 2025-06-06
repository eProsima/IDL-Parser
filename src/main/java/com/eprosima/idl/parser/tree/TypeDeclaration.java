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

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.typecode.TypeCode;

import org.antlr.v4.runtime.Token;

public class TypeDeclaration extends TreeNode implements Definition, Export
{
    public TypeDeclaration(String scopeFile, boolean isInScope, String scope, String name, TypeCode typecode, Token token)
    {
        super(scopeFile, isInScope, scope, name, token);

        m_typecode = typecode;
        // Set as parent to the Typecode.
        m_typecode.setParent(this);
        for(Annotation annotation : typecode.getAnnotationList())
        {
            addAnnotation(null, annotation);
        }
    }

    public TypeCode getTypeCode()
    {
        return m_typecode;
    }

    public void setParent(Object obj)
    {
        m_parent = obj;
    }

    public Object getParent()
    {
        return m_parent;
    }

    @Override
    public boolean isIsModule()
    {
        return false;
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
    public boolean isIsInterface()
    {
        return false;
    }

    @Override
    public boolean isIsTypeDeclaration()
    {
        return true;
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

    @Override
    public boolean resolve(Context ctx)
    {
        return true;
    }

    @Override
    public boolean isAnnotatedAsNested()
    {
        if (getParent() instanceof Interface)
        {
            return true;
        }

        return super.isAnnotatedAsNested();
    }

    @Override
    protected boolean isDeclaredInsideInterface()
    {
        return m_parent instanceof Interface;
    }

    private TypeCode m_typecode = null;
    private Object m_parent = null;
}
