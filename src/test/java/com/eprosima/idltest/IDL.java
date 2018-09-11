package com.eprosima.idltest;

public enum IDL
{
    BASIC,
    STRING,
    CUSTOM,
    ARRAY_BASIC,
    ARRAY_STRING,
    ARRAY_CUSTOM,
    ARRAY_NESTED,
    SEQUENCE_BASIC,
    SEQUENCE_STRING,
    SEQUENCE_CUSTOM,
    SEQUENCE_NESTED,
    INCLUDED_TYPE(BASIC);

    private IDL required = null;

    IDL(){}
    IDL(IDL required)
    {
        required = null;
    }

    public IDL getRequired()
    {
        return required;
    }
}
