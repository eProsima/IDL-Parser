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
 * @brief TypeCode of an IDL fixed-point type: fixed<digits, scale>.
 *
 * Language mappings for fixed-point types differ widely, so this TypeCode has no language typename templates:
 * every typename accessor returns the IDL spelling. Generators map it through getDigits() and getScale().
 */
public class FixedTypeCode extends TypeCode
{
    /*!
     * @param digits Total number of digits, as written in the IDL (a literal or a constant expression).
     * @param evaluated_digits Value of @p digits.
     * @param scale Number of fractional digits, as written in the IDL.
     * @param evaluated_scale Value of @p scale.
     */
    public FixedTypeCode(
            String digits,
            String evaluated_digits,
            String scale,
            String evaluated_scale)
    {
        super(Kind.KIND_FIXED);
        digits_ = digits;
        evaluated_digits_ = evaluated_digits;
        scale_ = scale;
        evaluated_scale_ = evaluated_scale;
    }

    /*!
     * @ingroup api_for_stg
     * @brief Returns the total number of digits as written in the IDL.
     */
    public String getDigits()
    {
        return digits_;
    }

    /*!
     * @ingroup api_for_stg
     * @brief Returns the evaluated total number of digits.
     */
    public String getEvaluatedDigits()
    {
        return evaluated_digits_;
    }

    /*!
     * @ingroup api_for_stg
     * @brief Returns the number of fractional digits as written in the IDL.
     */
    public String getScale()
    {
        return scale_;
    }

    /*!
     * @ingroup api_for_stg
     * @brief Returns the evaluated number of fractional digits.
     */
    public String getEvaluatedScale()
    {
        return evaluated_scale_;
    }

    @Override
    public boolean isIsFixedType()
    {
        return true;
    }

    @Override
    public boolean isPlainType()
    {
        return true;
    }

    @Override
    public String getNamespace()
    {
        return "";
    }

    @Override
    public String getCppTypename()
    {
        return getIdlTypename();
    }

    @Override
    public String getCTypename()
    {
        return getIdlTypename();
    }

    @Override
    public String getJavaTypename()
    {
        return getIdlTypename();
    }

    @Override
    public String getIdlTypename()
    {
        return "fixed<" + digits_ + ", " + scale_ + ">";
    }

    private String digits_ = null;
    private String evaluated_digits_ = null;
    private String scale_ = null;
    private String evaluated_scale_ = null;
}
