package com.eprosima.idl.generator.manager;

import com.eprosima.idl.parser.typecode.*;
import com.eprosima.idl.parser.exception.ParseException;

import java.util.List;
import java.util.ArrayList;

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
        if(dist_type != null)
        {
            if(dist_type.getKind() == TypeCode.KIND_SHORT ||
                    dist_type.getKind() == TypeCode.KIND_LONG ||
                    dist_type.getKind() == TypeCode.KIND_LONGLONG ||
                    dist_type.getKind() == TypeCode.KIND_USHORT ||
                    dist_type.getKind() == TypeCode.KIND_ULONG ||
                    dist_type.getKind() == TypeCode.KIND_ULONGLONG ||
                    dist_type.getKind() == TypeCode.KIND_CHAR)
            {
                long dvalue = -1;
                boolean found = true;
                List<Member> list = new ArrayList(members);

                do
                {
                    ++dvalue;
                    found = false;

                    for(Member member : list)
                    {
                        if(member instanceof UnionMember)
                        {
                            UnionMember umember = (UnionMember)member;

                            for(String label : umember.getLabels())
                            {
                                long value = Long.valueOf(label);

                                if(dvalue == value)
                                {
                                    found = true;
                                    break;
                                }
                            }
                        }

                        if(found) break;
                    }
                }
                while(found);

                returnedValue = Long.toString(dvalue);
            }
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
                else
                {
                    if(members.size() > 2)
                        throw new ParseException(null, "boolean switch cannot have more than two elements.");

                    returnedValue = "false";
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
        }
        
        return returnedValue;
    }

    public static String checkUnionLabel(TypeCode dist_type, String label, String scopeFile, int line)
    {
        // TODO Faltan tipos: short, unsigneds...
        if(dist_type != null)
        {
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
        }

        return label;
    }
}
