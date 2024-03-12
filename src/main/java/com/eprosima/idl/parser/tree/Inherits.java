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
import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.typecode.TypeCode;

public interface Inherits
{
    /*!
     * @brief This function links the super type to the object.
     * @param ctx Context used in the IDL parser. Can be useful for developers.
     * @param parent Super TypeCode to be linked.
     * @throw ParseException if the super type has already been defined.
     */
    public void addInheritance(Context ctx, TypeCode parent) throws ParseException;

    /*!
     * @brief This function returns the super type linked with the object.
     *        XTypes v1.3 Clause 7.2.2.4.5 The Type System supports single inheritance of Aggregated Types.
     * @return Linked super type.
     */
    public TypeCode getInheritance();

    public TypeCode getEnclosedInheritance();
}
