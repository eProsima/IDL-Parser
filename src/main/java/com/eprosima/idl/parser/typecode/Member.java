package com.eprosima.idl.parser.typecode;

import java.util.Map;
import java.util.HashMap;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.Notebook;

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
    public void addAnnotation(Annotation annotation)
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
