package com.eprosima.idl.parser.tree;

import com.eprosima.idl.parser.typecode.TypeCode;

public class OutputParam extends Param
{
    public OutputParam(String name, TypeCode typecode)
    {
        super(name, typecode);
    }

    @Override
    public boolean isInput()
    {
        return false;
    }

    @Override
    public boolean isOutput()
    {
        return true;
    }

    @Override
    public String getComment()
    {
        return "out";
    }

}
