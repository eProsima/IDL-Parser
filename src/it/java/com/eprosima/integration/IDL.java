package com.eprosima.integration;

import java.util.List;
import java.util.Map;

public enum IDL
{
    BASIC,
    STRING,
    CUSTOM,
    INCLUDE(BASIC),
    INHERITANCE(BASIC),
    ARRAY_BASIC,
    ARRAY_STRING,
    ARRAY_CUSTOM,
    ARRAY_MULTI_DIM,
    ARRAY_NESTED,
    SEQUENCE_BASIC,
    SEQUENCE_BASIC_IN_MODULE_TYPEDEF(SEQUENCE_BASIC),
    SEQUENCE_STRING,
    SEQUENCE_STRING_IN_MODULE_TYPEDEF(SEQUENCE_STRING),
    SEQUENCE_CUSTOM,
    SEQUENCE_CUSTOM_IN_MODULE_TYPEDEF(SEQUENCE_CUSTOM),
    SEQUENCE_NESTED,
    STRUCT_EMPTY,
    BITSET_BITMASK,
    COVERAGE_BASIC,
    COVERAGE_COMPLEX,
    FORWARD_DECLS,
    NEW_FEATURES_4_2,
    DECLARATION_ORDER;

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
