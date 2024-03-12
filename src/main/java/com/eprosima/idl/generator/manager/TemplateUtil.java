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

package com.eprosima.idl.generator.manager;

import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.grammar.IDLParser.DefinitionContext;
import com.eprosima.idl.parser.typecode.*;
import com.eprosima.idl.parser.tree.Definition;
import com.eprosima.idl.parser.tree.ConstDeclaration;
import java.util.ArrayList;
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

    /*!
     * This function tries to find a default discriminator value for the union following next guidelines extracted from
     * standard.
     *
     * "If there is a default case specified, the union is initialized to this default case.
     * In case the union has an implicit default member it is initialized to that case.
     * In all other cases it is initialized to the first discriminant value specified in IDL"
     */
    public static void find_and_set_default_discriminator_value(ArrayList<Definition> defs, UnionTypeCode union_type, String scopeFile, int line)
    {
        List<Member> members = union_type.getMembers();
        TypeCode dist_type = union_type.getDiscriminator().getTypecode();

        if (Kind.KIND_ALIAS == dist_type.getKind())
        {
            dist_type = ((AliasTypeCode)dist_type).getContentTypeCode();
        }

        if(dist_type != null)
        {
            if(dist_type.getKind() == Kind.KIND_OCTET ||
                    dist_type.getKind() == Kind.KIND_INT8 ||
                    dist_type.getKind() == Kind.KIND_SHORT ||
                    dist_type.getKind() == Kind.KIND_LONG ||
                    dist_type.getKind() == Kind.KIND_LONGLONG ||
                    dist_type.getKind() == Kind.KIND_UINT8 ||
                    dist_type.getKind() == Kind.KIND_USHORT ||
                    dist_type.getKind() == Kind.KIND_ULONG ||
                    dist_type.getKind() == Kind.KIND_ULONGLONG ||
                    dist_type.getKind() == Kind.KIND_CHAR ||
                    dist_type.getKind() == Kind.KIND_WCHAR)
            {
                long dvalue = -1;
                boolean found = true;
                List<Member> list = new ArrayList<Member>(members);

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
                                long value = 0;
                                try
                                {
                                    value = Long.decode(label);
                                }
                                catch(NumberFormatException nfe)
                                {
                                    // It could be a const
                                    if (null != defs)
                                    {
                                        for (Definition def : defs)
                                        {
                                            if (def.isIsConstDeclaration())
                                            {
                                                ConstDeclaration decl = (ConstDeclaration)def;
                                                if (decl.getName().equals(label))
                                                {
                                                    value = Long.decode(decl.getValue());
                                                }
                                            }
                                        }
                                    }
                                }

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

                union_type.setDefaultvalue(Long.toString(dvalue));
                union_type.setJavaDefaultvalue(Long.toString(dvalue));
            }
            else if(dist_type.getKind() == Kind.KIND_BOOLEAN)
            {
                if(1 == members.size() && 1 == ((UnionMember)members.get(0)).getLabels().size())
                {
                    if(((UnionMember)members.get(0)).getLabels().get(0).equals("true"))
                    {
                        union_type.setDefaultvalue("false");
                        union_type.setJavaDefaultvalue("false");
                    }
                    else if(((UnionMember)members.get(0)).getLabels().get(0).equals("false"))
                    {
                        union_type.setDefaultvalue("true");
                        union_type.setJavaDefaultvalue("true");
                    }
                    else
                    {
                        throw new ParseException(null, "is not a valid label for a boolean discriminator.");
                    }
                }
                else if(2 == members.size() && 1 == ((UnionMember)members.get(0)).getLabels().size() &&
                        1 == ((UnionMember)members.get(1)).getLabels().size())
                {

                    union_type.setDefaultvalue(((UnionMember)members.get(0)).getLabels().get(0));
                    union_type.setJavaDefaultvalue(((UnionMember)members.get(0)).getLabels().get(0));
                }
                else
                {
                    throw new ParseException(null, "boolean switch is malformed.");
                }
            }
            else if(dist_type.getKind() == Kind.KIND_ENUM)
            {
                EnumTypeCode enume = (EnumTypeCode)dist_type;
                List<Member> list = new ArrayList<Member>(members);
                List<Member> enum_members = new ArrayList<Member>();
                enum_members.addAll(enume.getMembers());

                for(Member member : members)
                {
                    UnionMember umember = (UnionMember)member;

                    for(String label : umember.getInternalLabels())
                    {
                        int count = 0;

                        for(; count < enum_members.size(); ++count)
                        {
                            if(((EnumMember)enum_members.get(count)).getName().equals(label))
                                break;
                        }

                        if(count < enum_members.size())
                            enum_members.remove(count);
                    }
                }

                if(enum_members.size() > 0)
                {
                    union_type.setDefaultvalue(enume.getScopedname() + "::" + enum_members.get(0).getName());
                    union_type.setJavaDefaultvalue(enume.javapackage + enume.getJavaScopedname() + "." + enum_members.get(0).getName());
                }
                else if (0 < members.size() && 0 < ((UnionMember)members.get(0)).getLabels().size())
                {
                    union_type.setDefaultvalue(((UnionMember)members.get(0)).getLabels().get(0));
                    union_type.setJavaDefaultvalue(((UnionMember)members.get(0)).getLabels().get(0));
                }
            }
            else
            {
                throw new ParseException(null, "Not supported type discriminator.");
            }
        }
    }

    public static String checkUnionLabel(TypeCode dist_type, String label, String scopeFile, int line)
    {
        // TODO Faltan tipos: short, unsigneds...
        if(dist_type != null)
        {
            if(dist_type.getKind() == Kind.KIND_ENUM)
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
                        else
                        {
                            label = label.replaceFirst(enume.getScope() + "::", "");
                        }
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
