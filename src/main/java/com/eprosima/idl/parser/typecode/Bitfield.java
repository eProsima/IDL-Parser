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

package com.eprosima.idl.parser.typecode;



public class Bitfield extends Member
{
    public Bitfield()
    {
        super();
    }

    public Bitfield(BitsetTypeCode typecode, BitfieldSpec spec, String name)
    {
        super(typecode, name);
        m_spec = spec;
    }

    public void setBasePosition(
            int position)
    {
        m_base = position;
    }

    public int getBasePosition()
    {
        return m_base;
    }

    public BitfieldSpec getSpec()
    {
        return m_spec;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function check if the bitfield was defined by name.
     * @return true if the bitfield was defined by name in the IDL file. false otherwise.
     */
    public boolean getIsDefined()
    {
        return !getName().isEmpty();
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function returns a string containing the mask in hexadecimal which can be used to make bitwise AND
     * operation over the bitfield.
     * @return The bit mask in hexadecimal.
     */
    public String getBitmask()
    {
        String mask = "";
        int mod = m_spec.getBitSize() / 4;
        int rest = m_spec.getBitSize() % 4;

        while (0 != mod)
        {
            mask += "F";
            --mod;
        }

        switch(rest)
        {
            case 1:
            mask = "1" + mask;
            break;
            case 2:
            mask = "3" + mask;
            break;
            case 3:
            mask = "7" + mask;
            break;
            default:
            break;
        }

        if (mask.isEmpty())
        {
            mask = "0";
        }

        return "0x" + mask;
    }

    @Override
    public boolean isIsPlain()
    {
        return true;
    }

    @Override
    public boolean isIsBounded()
    {
        return true;
    }

    private int m_base = -1;
    private BitfieldSpec m_spec = null;
}
