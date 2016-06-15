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

import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.Notebook;
import com.eprosima.idl.context.Context;

import java.util.Map;
import java.util.HashMap;

public class Member implements Notebook
{
    public Member()
    {
        m_annotations = new HashMap<String, Annotation>();
    }
    
    public Member(TypeCode typecode, String name)
    {
        m_typecode = typecode;
        m_name = name;
        m_annotations = new HashMap<String, Annotation>();
    }
    
    public String getName()
    {
        return m_name;
    }
    
    public String getJavaName() {
    	if (m_name != null) {
	    	Character firstChar =Character.toUpperCase(m_name.charAt(0));
	    	String javaName = firstChar.toString();
	    	if (m_name.length() > 1) {
	    		javaName += m_name.substring(1);
	    	}
	    	return javaName;
    	}
    	return null;
    }

    /*
     * @brief This function is used with RTI DDS types because array names contains [].
     */
    
    public TypeCode getTypecode()
    {
        return m_typecode;
    }
    
    public void setName(String name)
    {
        m_name = name;
    }
    
    public void setTypecode(TypeCode typecode)
    {
         m_typecode = typecode;
    }

    @Override
    public void addAnnotation(Context ctx, Annotation annotation)
    {
        if(annotation != null)
            m_annotations.put(annotation.getName(), annotation);
    }

    @Override
    public Map<String, Annotation> getAnnotations()
    {
        return m_annotations;
    }
    
    private String m_name = null;
    
    private TypeCode m_typecode = null;

    private HashMap<String, Annotation> m_annotations = null;
}
