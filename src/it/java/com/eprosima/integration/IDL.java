package com.eprosima.integration;

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
    INCLUDE(BASIC);

    private IDL required = null;

    IDL(){}
    IDL(IDL required)
    {
        this.required = required;
    }

    public IDL getRequired()
    {
        return required;
    }
}
