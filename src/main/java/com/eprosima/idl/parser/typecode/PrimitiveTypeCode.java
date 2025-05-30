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



public class PrimitiveTypeCode extends TypeCode
{
    public PrimitiveTypeCode(
            int kind)
    {
        super(kind);
    }

    @Override
    public String getNamespace()
    {
        return "";
    }

    @Override
    public String getCppTypename()
    {
        return getCppTypenameFromStringTemplate().render();
    }

    @Override
    public String getCTypename()
    {
        return getCTypenameFromStringTemplate().render();
    }

    @Override
    public String getJavaTypename()
    {
        return getJavaTypenameFromStringTemplate().render();
    }

    @Override
    public String getIdlTypename()
    {
        return getIdlTypenameFromStringTemplate().render();
    }

    @Override
    public boolean isPrimitive()
    {
        return true;
    }

    @Override
    public String getTypeIdentifier()
    {
        switch (getKind())
        {
            case Kind.KIND_SHORT:
                return "TK_INT16";
            case Kind.KIND_LONG:
                return "TK_INT32";
            case Kind.KIND_USHORT:
                return "TK_UINT16";
            case Kind.KIND_ULONG:
                return "TK_UINT32";
            case Kind.KIND_FLOAT:
                return "TK_FLOAT32";
            case Kind.KIND_DOUBLE:
                return "TK_FLOAT64";
            case Kind.KIND_BOOLEAN:
                return "TK_BOOLEAN";
            case Kind.KIND_CHAR:
                return "TK_CHAR8";
            case Kind.KIND_OCTET:
                return "TK_BYTE";
            case Kind.KIND_LONGLONG:
                return "TK_INT64";
            case Kind.KIND_ULONGLONG:
                return "TK_UINT64";
            case Kind.KIND_LONGDOUBLE:
                return "TK_FLOAT128";
            case Kind.KIND_WCHAR:
                return "TK_CHAR16";
            case Kind.KIND_INT8:
                return "TK_INT8";
            case Kind.KIND_UINT8:
                return "TK_UINT8";
            default:
                return "TK_None";
        }
    }

    @Override
    public boolean isPrimitiveType()
    {
        return true;
    }

    @Override
    public String getInitialValue()
    {
        switch (getKind())
        {
            case Kind.KIND_LONGDOUBLE:
            case Kind.KIND_DOUBLE:
            case Kind.KIND_FLOAT:
                return "0.0";
            case Kind.KIND_LONGLONG:
            case Kind.KIND_ULONGLONG:
            case Kind.KIND_LONG:
            case Kind.KIND_ULONG:
            case Kind.KIND_WCHAR:
            case Kind.KIND_SHORT:
            case Kind.KIND_USHORT:
            case Kind.KIND_CHAR:
            case Kind.KIND_OCTET:
            case Kind.KIND_INT8:
            case Kind.KIND_UINT8:
                return "0";
            case Kind.KIND_BOOLEAN:
                return "false";
        }

        return "";
    }

    @Override
    public String getSize()
    {
        switch (getKind())
        {
            case Kind.KIND_LONGDOUBLE:
                return "16";
            case Kind.KIND_DOUBLE:
            case Kind.KIND_LONGLONG:
            case Kind.KIND_ULONGLONG:
                return "8";
            case Kind.KIND_LONG:
            case Kind.KIND_ULONG:
            case Kind.KIND_FLOAT:
            case Kind.KIND_WCHAR:
                return "4";
            case Kind.KIND_SHORT:
            case Kind.KIND_USHORT:
                return "2";
            case Kind.KIND_BOOLEAN:
            case Kind.KIND_CHAR:
            case Kind.KIND_OCTET:
            case Kind.KIND_INT8:
            case Kind.KIND_UINT8:
                return "1";
        }

        return null;
    }

    @Override
    public boolean isIsType_5()
    {
        return getKind() == Kind.KIND_FLOAT;
    }

    @Override
    public boolean isIsType_6()
    {
        return getKind() == Kind.KIND_DOUBLE;
    }

    @Override
    public boolean isIsType_7()
    {
        return getKind() == Kind.KIND_BOOLEAN;
    }

    @Override
    public boolean isIsType_13()
    {
        return getKind() == Kind.KIND_LONGDOUBLE;
    }

    @Override
    public boolean isIsCharType()
    {
        return getKind() == Kind.KIND_CHAR;
    }

    @Override
    public boolean isIsWCharType()
    {
        return getKind() == Kind.KIND_WCHAR;
    }

    @Override
    public boolean isIsBooleanType()
    {
        return getKind() == Kind.KIND_BOOLEAN;
    }

    @Override
    public boolean isIsByteType()
    {
        return getKind() == Kind.KIND_OCTET;
    }

    @Override
    public boolean isIsInt8Type()
    {
        return getKind() == Kind.KIND_INT8;
    }

    @Override
    public boolean isIsUint8Type()
    {
        return getKind() == Kind.KIND_UINT8;
    }

    @Override
    public boolean isIsInt16Type()
    {
        return getKind() == Kind.KIND_SHORT;
    }

    @Override
    public boolean isIsUint16Type()
    {
        return getKind() == Kind.KIND_USHORT;
    }

    @Override
    public boolean isIsInt32Type()
    {
        return getKind() == Kind.KIND_LONG;
    }

    @Override
    public boolean isIsUint32Type()
    {
        return getKind() == Kind.KIND_ULONG;
    }

    @Override
    public boolean isIsInt64Type()
    {
        return getKind() == Kind.KIND_LONGLONG;
    }

    @Override
    public boolean isIsUint64Type()
    {
        return getKind() == Kind.KIND_ULONGLONG;
    }

    @Override
    public boolean isIsFloat32Type()
    {
        return getKind() == Kind.KIND_FLOAT;
    }

    @Override
    public boolean isIsFloat64Type()
    {
        return getKind() == Kind.KIND_DOUBLE;
    }

    @Override
    public boolean isIsFloat128Type()
    {
        return getKind() == Kind.KIND_LONGDOUBLE;
    }

}
