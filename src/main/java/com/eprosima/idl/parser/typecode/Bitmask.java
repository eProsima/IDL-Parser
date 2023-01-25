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



public class Bitmask extends Member
{
    public Bitmask()
    {
        super();
    }

    public Bitmask(BitmaskTypeCode typecode, String name)
    {
        super(typecode, name);
    }

    public void setPosition(
            int position)
    {
        m_position = position;
    }

    public int getPosition()
    {
        return m_position;
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

    private int m_position = -1;
}
