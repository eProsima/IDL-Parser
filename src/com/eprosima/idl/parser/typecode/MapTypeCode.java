package com.eprosima.idl.parser.typecode;

import org.antlr.stringtemplate.StringTemplate;

import com.eprosima.idl.util.Pair;

public class MapTypeCode extends ContainerTypeCode
{
    public MapTypeCode(String maxsize)
    {
        super(MapTypeCode.KIND_MAP);
        m_maxsize = maxsize;
    }

    @Override
    public boolean isIsType_e(){return true;}

    @Override
    public String getCppTypename()
    {
        StringTemplate st = getCppTypenameFromStringTemplate();
        st.setAttribute("key", getKeyTypeCode().getCppTypename());
        st.setAttribute("value", getValueTypeCode().getCppTypename());
        st.setAttribute("maxsize", m_maxsize);
        return st.toString();
    }

    @Override
    public String getIdlTypename()
    {
        StringTemplate st = getIdlTypenameFromStringTemplate();
        st.setAttribute("key", getKeyTypeCode().getIdlTypename());
        st.setAttribute("value", getValueTypeCode().getIdlTypename());
        st.setAttribute("maxsize", m_maxsize);
        return st.toString();
    }

    public String getMaxsize()
    {
        if(m_maxsize == null)
            return "100";
        return m_maxsize;
    }
	
    public TypeCode getKeyTypeCode()
    {
        return m_keyTypeCode;
    }
    
    public void setKeyTypeCode(TypeCode keyTypeCode)
    {
        m_keyTypeCode = keyTypeCode;
    }
	
	public TypeCode getValueTypeCode()
    {
        return m_valueTypeCode;
    }
    
    public void setValueTypeCode(TypeCode valueTypeCode)
    {
        m_valueTypeCode = valueTypeCode;
    }
    
    private TypeCode m_keyTypeCode = null;
	private TypeCode m_valueTypeCode = null;
    private String m_maxsize = null;
}
