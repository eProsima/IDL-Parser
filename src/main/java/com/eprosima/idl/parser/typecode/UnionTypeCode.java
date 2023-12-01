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
        discriminator_.setId(0);
    }

    public void setDiscriminatorType(
            TypeCode discriminatorTypeCode)
    {
        discriminator_ = new UnionMember(discriminatorTypeCode, "discriminator", null, false);
        discriminator_.setId(0);
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
            UnionMember member)
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

        if (Kind.KIND_ENUM == discriminator_.getTypecode().getKind() ||
                Kind.KIND_BITMASK == discriminator_.getTypecode().getKind())
        {
            MemberedTypeCode enum_type = (MemberedTypeCode)discriminator_.getTypecode();
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

        member.setLabels(labels);
        member.setJavaLabels(javalabels);

        if (!addMember((Member)member))
        {
            return -1;
        }

        return 0;
    }

    public Member getDefaultMember()
    {
        if (m_defaultindex != -1)
        {
            return getMembers().get(m_defaultindex);
        }

        return null;
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

    // Add member and the default one at the end.
    public List<Map.Entry<Integer, Member>> getIdentifiedMembers()
    {
        int position = 0;
        List<Map.Entry<Integer, Member>> ret_members = new ArrayList<Map.Entry<Integer,Member>>();
        AbstractMap.SimpleEntry<Integer, Member> default_member = null;

        for (Member m : getMembers())
        {
            if (position == m_defaultindex)
            {
                default_member = new AbstractMap.SimpleEntry<>(position++, m);
            }
            else
            {
                ret_members.add(new AbstractMap.SimpleEntry<>(position++, m));
            }
        }

        if (null != default_member)
        {
            ret_members.add(default_member);
        }

        return ret_members;
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

    private String m_defaultValue = null;

    private String m_javaDefaultValue = null;

    protected boolean detect_recursive_ = false;
}
