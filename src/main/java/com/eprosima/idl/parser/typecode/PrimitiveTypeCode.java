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

import org.antlr.stringtemplate.StringTemplate;

import com.eprosima.idl.util.Pair;

public class PrimitiveTypeCode extends TypeCode
{
    public PrimitiveTypeCode(int kind)
    {
        super(kind);
    }

    @Override
    public String getCppTypename()
    {
        return getCppTypenameFromStringTemplate().toString();
    }

    @Override
    public String getJavaTypename()
    {
        return getJavaTypenameFromStringTemplate().toString();
    }
    
    @Override
    public String getIdlTypename()
    {
        return getIdlTypenameFromStringTemplate().toString();
    }
    
    @Override
    public boolean isPrimitive()
    {
        return true;
    }
    
    @Override
    public String getInitialValue()
    {   
        switch(getKind())
        {
            case KIND_LONGDOUBLE:
            case KIND_DOUBLE:
            case KIND_FLOAT:
                return "0.0";
            case KIND_LONGLONG:
            case KIND_ULONGLONG:
            case KIND_LONG:
            case KIND_ULONG:
            case KIND_WCHAR:
            case KIND_SHORT:
            case KIND_USHORT:
            case KIND_CHAR:
            case KIND_OCTET:
                return "0";         
            case KIND_BOOLEAN:
                return "false";               
        }
    	
    	return "";
    }
    
    /*public Pair<Integer, Integer> getMaxSerializedSize(int currentSize, int lastDataAligned)
    {
        int size = getSize();
        
        if(size <= lastDataAligned)
        {
            return new Pair<Integer, Integer>(currentSize + size, size);
        }
        else
        {
            int align = (size - (currentSize % size)) & (size - 1);
            return new Pair<Integer, Integer>(currentSize + size + align, size);
        }
    }
    
    public int getMaxSerializedSizeWithoutAlignment(int currentSize)
    {
        return currentSize + getSize();
    }*/
    
    @Override
    public String getSize()
    {
        switch(getKind())
        {
            case KIND_DOUBLE:
            case KIND_LONGLONG:
            case KIND_ULONGLONG:
                return "8";
            case KIND_LONG:
            case KIND_ULONG:
            case KIND_FLOAT:
            case KIND_WCHAR:
                return "4";         
            case KIND_SHORT:
            case KIND_USHORT:
                return "2";
            case KIND_BOOLEAN:
            case KIND_CHAR:
            case KIND_OCTET:
                return "1";               
        }
        
        return null;
    }

    public boolean isIsType_5() { return getKind() == KIND_FLOAT;}
    public boolean isIsType_6() { return getKind() == KIND_DOUBLE;}
}
