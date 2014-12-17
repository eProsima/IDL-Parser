package com.eprosima.idl.generator.manager;

import com.eprosima.idl.parser.typecode.*;
import com.eprosima.idl.parser.exception.ParseException;

import java.util.List;

public class TemplateUtil
{
    public static String stripType(String type)
    {
        if(type.startsWith("std::array"))
            return "std::array";
        else if(type.startsWith("std::vector"))
            return "std::vector";
        else
            return type;
    }
    
    public static String getUnionDefaultLabel(TypeCode dist_type, List<Member> members, String scopeFile, int line)
    {
        String returnedValue = null;
        // TODO Faltan tipos: short, unsigneds...
        
        if(dist_type.getKind() == TypeCode.KIND_LONG)
            returnedValue = "-1000";
        else if(dist_type.getKind() == TypeCode.KIND_CHAR)
            returnedValue = "254";
        else if(dist_type.getKind() == TypeCode.KIND_BOOLEAN)
        {
            if(members.size() == 1 && ((UnionMember)members.get(0)).getLabels().size() == 1)
            {
                if(((UnionMember)members.get(0)).getLabels().get(0).equals("true"))
                {
                    returnedValue = "false";
                }
                else if(((UnionMember)members.get(0)).getLabels().get(0).equals("false"))
                {
                    returnedValue = "true";
                }
                else
                {
                    //TODO
                    //throw new ParseException(((UnionMember)members.get(0)).getLabels().get(0), "is not a valid label for a boolean discriminator.");
                    throw new ParseException(null, "is not a valid label for a boolean discriminator.");
                }    
            }
        }
        else if(dist_type.getKind() == TypeCode.KIND_ENUM)
        {
            EnumTypeCode enume = (EnumTypeCode)dist_type;
            returnedValue = enume.getInitialValue();
        }
        else
        {
            throw new ParseException(null, "Not supported type discriminator.");
        }
        
        return returnedValue;
    }

    public static String checkUnionLabel(TypeCode dist_type, String label, String scopeFile, int line)
    {
        // TODO Faltan tipos: short, unsigneds...
        
        if(dist_type.getKind() == TypeCode.KIND_ENUM)
        {
            EnumTypeCode enume = (EnumTypeCode)dist_type;

            if(enume.getScope() != null)
            {
                if(label.contains("::"))
                {
                    if(!label.startsWith(enume.getScope()))
                    {
                        //TODO
                        //throw new ParseException(label,  "was not declared previously");
                        throw new ParseException(null,  "was not declared previously");
                    }
                }
                else
                {
                    return enume.getScope() + "::" + label;
                }
            }
            else
            {
                if(label.contains("::"))
                {
                    //TODO
                    //throw new ParseException(label, "was not declared previously");
                    throw new ParseException(null, "was not declared previously");
                }
            }
        }

        return label;
    }
}
