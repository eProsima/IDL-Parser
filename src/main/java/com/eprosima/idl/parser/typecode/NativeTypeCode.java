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

package com.eprosima.idl.parser.typecode;

/*!
 * @brief TypeCode of an IDL native declaration: native Name;
 *
 * A native type is opaque to IDL: each language mapping supplies its own representation. Every typename accessor
 * returns the scoped IDL name, so references to the native type resolve like references to any declared type.
 */
public class NativeTypeCode extends TypeCode
{
    public NativeTypeCode(
            String scope,
            String name)
    {
        super(Kind.KIND_NATIVE);
        scope_ = scope;
        name_ = name;
    }

    /*!
     * @ingroup api_for_stg
     * @brief Returns the unscoped name of the native type.
     */
    public String getName()
    {
        return name_;
    }

    /*!
     * @ingroup api_for_stg
     * @brief Returns the scoped name of the native type.
     */
    public String getScopedname()
    {
        return (scope_ == null || scope_.isEmpty()) ? name_ : scope_ + "::" + name_;
    }

    public String getScope()
    {
        return scope_;
    }

    @Override
    public boolean isIsNativeType()
    {
        return true;
    }

    @Override
    public String getNamespace()
    {
        return generate_namespace(scope_);
    }

    @Override
    public String getCppTypename()
    {
        return getScopedname();
    }

    @Override
    public String getCTypename()
    {
        return getScopedname().replace("::", "_");
    }

    @Override
    public String getJavaTypename()
    {
        return getScopedname().replace("::", ".");
    }

    @Override
    public String getIdlTypename()
    {
        return getScopedname();
    }

    private String scope_ = null;
    private String name_ = null;
}
