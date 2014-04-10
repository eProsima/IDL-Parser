package com.eprosima.idl.parser.tree;

import com.eprosima.idl.parser.typecode.TypeCode;

public class InputParam extends Param
{
    public InputParam(String name, TypeCode typecode)
    {
        super(name, typecode);
    }
    
    @Override
    public boolean isInput()
    {
        return true;
    }

    @Override
    public boolean isOutput()
    {
        return false;
    }
    
    @Override
    public String getComment()
    {
        return "in";
    }
}
