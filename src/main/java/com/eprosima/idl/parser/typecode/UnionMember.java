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

import java.util.List;

public class UnionMember extends Member
{
    public UnionMember(TypeCode typecode, String name, List<String> labels, boolean isDefault)
    {
        super(typecode, name);
        m_internallabels = labels;
        m_default = isDefault;
    }

    public List<String> getInternalLabels()
    {
        return m_internallabels;
    }

    public List<String> getLabels()
    {
        return m_labels;
    }

    public void setLabels(List<String> labels)
    {
        m_labels = labels;
    }

    public List<String> getJavaLabels()
    {
        return m_javalabels;
    }

    public void setJavaLabels(List<String> labels)
    {
        m_javalabels = labels;
    }

    public boolean isDefault()
    {
        return m_default;
    }

    public boolean isPrintable()
    {
        return m_default || (null != m_labels && 0 < m_labels.size());
    }

    private List<String> m_internallabels = null;
    private List<String> m_labels = null;
    private List<String> m_javalabels = null;

    private boolean m_default = false;
}
