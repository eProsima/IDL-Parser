package com.eprosima.idl.parser.typecode;

public class Member
{
    public Member()
    {
    }
    
    public Member(TypeCode typecode, String name)
    {
        m_typecode = typecode;
        m_name = name;
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
    
    private String m_name = null;
    
    private TypeCode m_typecode = null;
}
