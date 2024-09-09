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

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.stringtemplate.v4.ST;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.exception.RuntimeGenerationException;
import com.eprosima.idl.parser.tree.Annotation;



public class UnionTypeCode extends MemberedTypeCode
{
    public UnionTypeCode(
            String scope,
            String name)
    {
        super(Kind.KIND_UNION, scope, name);
        discriminator_ = null;
    }

    public UnionTypeCode(
            String scope,
            String name,
            TypeCode discriminatorTypeCode)
    {
        super(Kind.KIND_UNION, scope, name);
        discriminator_ = new UnionMember(discriminatorTypeCode, "discriminator", null, false);
        ++last_index_;
        ++last_id_;
    }

    public void setDiscriminatorType(
            TypeCode discriminatorTypeCode) throws RuntimeGenerationException
    {
        discriminator_ = new UnionMember(discriminatorTypeCode, "discriminator", null, false);
        ++last_index_;
        ++last_id_;
        if(last_id_ != 0)
        {
            throw new RuntimeGenerationException("UnionTypeCode::setDiscriminatorType(): Discriminator member_id is not 0.");
        }
    }

    @Override
    public String getTypeIdentifier()
    {
        return "EK_MINIMAL";
    }

    @Override
    public boolean isObjectType()
    {
        return true;
    }

    @Override
    public boolean isIsUnionType()
    {
        return true;
    }

    /*!
     * @return 0 is ok, -1 the member is repeated, -2 is another default member.
     */
    public int addMember(
            UnionMember member) throws ParseException
    {
        if (member.isDefault())
        {
            if (m_defaultindex == -1)
            {
                m_defaultindex = getMembers().size();
            }
            else
            {
                return -2;
            }
        }

        // Generate labels
        List<String> internal_labels = member.getInternalLabels();
        List<String> labels = null;
        List<String> javalabels = null;

        TypeCode discriminator_typecode = discriminator_.getTypecode();

        if (Kind.KIND_ENUM == discriminator_typecode.getKind() ||
                Kind.KIND_BITMASK == discriminator_typecode.getKind())
        {
            MemberedTypeCode enum_type = (MemberedTypeCode)discriminator_typecode;
            labels = new ArrayList<String>();
            javalabels = new ArrayList<String>();

            for (int count = 0; count < internal_labels.size(); ++count)
            {
                labels.add((Kind.KIND_ENUM == discriminator_.getTypecode().getKind() ?
                            enum_type.getScopedname() + "::" : "")+ internal_labels.get(count));
                javalabels.add(javapackage + enum_type.getJavaScopedname() + "." + internal_labels.get(count));
            }
        }
        else
        {
            labels = internal_labels;
            javalabels = internal_labels;
        }

        // Checks the discriminator has the @default annotation. In that case check the union's member has a label with
        // the @default annotation value and if they match store the union's member index.
        try
        {
            if (discriminator_.isAnnotationDefault())
            {
                String default_value = discriminator_.getAnnotationDefaultValue();

                for (String label : labels)
                {
                    if (label.equals(default_value))
                    {
                        if (m_defaultannotated_index == -1)
                        {
                            m_defaultannotated_index = getMembers().size();
                        }
                        else
                        {
                            // Default value matches with more than one member.
                            return -2;
                        }
                    }
                }
            }
        }
        catch(RuntimeGenerationException ex)
        {
            // Never enter here because we check previously using isAnnotationDefault().
        }


        member.setLabels(labels);
        member.setJavaLabels(javalabels);

        calculate_member_id_(member);
        if (!super.addMember(member))
        {
            return -1;
        }

        return 0;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function returns the union's member which contains a label that matches with discriminator's
     * @default annotation. If no one then return \b null.
     * @return The union's member that passes the conditions or \b null value.
     */
    public Member getDefaultAnnotatedMember()
    {
        if (m_defaultannotated_index != -1)
        {
            return getMembers().get(m_defaultannotated_index);
        }

        return null;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function returns the union's default member (when there is no implicit default).
     * A member is selected as the default one according to one of these cases:
     * - It is under the `default:` case label.
     * - It is under the case label of the default discriminator.
     * - All possible values of the discriminator's type are covered so the first member should be considered the default.
     *
     * @return The union's default member.
     */
    public Member getDefaultMember()
    {
        // Union's default member is explicitly selected (either under the `default:` case label or under the default discriminator value case label).
        if (m_defaultindex != -1)
        {
            return getMembers().get(m_defaultindex);
        }
        // All possible values of a Boolean discriminator or Enumeration discriminator are covered.
        else if((Kind.KIND_BOOLEAN == discriminator_.getTypecode().getKind() && 2 == getTotallabels().size()) ||
                (Kind.KIND_ENUM == discriminator_.getTypecode().getKind() &&
                 ((EnumTypeCode)discriminator_.getTypecode()).getMembers().size() == getTotallabels().size()))
        {
            // First member is selected ad the default one.
            return getMembers().get(0);
        }

        return null;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function can be used to check if a generated language binding union (cpp, java) related to this
     * union object should have the default case generated.
     * @code
       $union.members :{ member |
       $member.labels:{ label |case $label$:}; separator="\n"$
       $if(member.default)$default:$endif$
           // Do something
           break;
       }; separator="\n"$
       $if(union.needDefaultCase)$
       default:
           break;
       $endif$
     * @endcode
     * @return @e false if the union contains a member declared as default member or the union discriminator type is
     * @b boolean and the @e true and @e false case labels were defined. In other case, @e true is returned.
     */
    public boolean getNeedDefaultCase()
    {
        if (m_defaultindex == -1 &&
                !(Kind.KIND_BOOLEAN == discriminator_.getTypecode().getKind() && 2 == getMembers().size()))
        {
            return true;
        }

        return false;
    }

    @Override
    public String getCppTypename()
    {
        ST st = getCppTypenameFromStringTemplate();
        st.add("name", getScopedname());
        return st.render();
    }

    @Override
    public String getCTypename()
    {
        ST st = getCTypenameFromStringTemplate();
        st.add("name", getCScopedname());
        return st.render();
    }

    @Override
    public String getJavaTypename()
    {
        ST st = getJavaTypenameFromStringTemplate();
        st.add("name", getJavaScopedname());
        return st.render();
    }

    @Override
    public String getIdlTypename()
    {
        ST st = getIdlTypenameFromStringTemplate();
        st.add("name", getScopedname());
        return st.render();
    }

    public void setDefaultvalue(
            String value)
    {
        m_defaultValue = value;
    }

    public void setJavaDefaultvalue(
            String value)
    {
        m_javaDefaultValue = value;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function returns the discriminator's @default annotation value as string. If annotation was not
     * defined, returns \b null.
     * @return The discriminator's @default annotation value or \b null if annotation was not defined
     */
    public String getDefaultAnnotatedValue()
    {
        try
        {
            if (discriminator_.isAnnotationDefault())
            {
                return discriminator_.getAnnotationDefaultValue();
            }
        }
        catch(RuntimeGenerationException ex)
        {
            // Never enter here because we check previously using isAnnotationDefault().
        }

        return null;
    }

    // Used in stringtemplates
    public String getDefaultvalue()
    {
        return m_defaultValue;
    }

    // Used in stringtemplates
    public String getJavaDefaultvalue()
    {
        return m_javaDefaultValue;
    }

    // Used in stringtemplates
    public UnionMember getDiscriminator()
    {
        return discriminator_;
    }

    // Used in stringtemplates
    public List<String> getTotallabels()
    {
        List<String> returnList = new ArrayList<String>();
        List<Member> mlist = getMembers();
        List<String> labels = null;

        for (int count = 0; count < mlist.size(); ++count)
        {
            if (count != m_defaultindex)
            {
                labels = ((UnionMember)mlist.get(count)).getLabels();
                for (int i = 0; i < labels.size(); ++i)
                {
                    returnList.add(labels.get(i));
                }
            }
        }

        return returnList;
    }

    @Override
    public boolean isIsPlain()
    {
        return false;
    }

    @Override
    public void addAnnotation(
            Context ctx,
            Annotation annotation)
    {
        // Checks
        check_annotation_for_aggregated_types(annotation);

        super.addAnnotation(ctx, annotation);
    }

    private UnionMember discriminator_ = null;

    private int m_defaultindex = -1;

    /*!
     * Stores the index of the union's member which contains a label that matches with the discriminator's @default
     * annotation.
     */
    private int m_defaultannotated_index = -1;

    private String m_defaultValue = null;

    private String m_javaDefaultValue = null;

    protected boolean detect_recursive_ = false;
}
