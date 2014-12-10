package com.eprosima.idl.parser.typecode;

public abstract class ContainerTypeCode extends TypeCode
{
    protected ContainerTypeCode(int kind)
    {
        super(kind);
    }
    
    @Override
    public abstract String getCppTypename();
    
    @Override
    public abstract String getIdlTypename();
    
    public TypeCode getContentTypeCode()
    {
        return m_contentTypeCode;
    }
    
    public void setContentTypeCode(TypeCode contentTypeCode)
    {
        m_contentTypeCode = contentTypeCode;
    }
    
     public int getDepth()
    {
    	int ret = 1;
    	
    	if (m_contentTypeCode.isPrimitive()) {
    		return ret;
    	} else {
    		if (m_contentTypeCode instanceof ContainerTypeCode) {
    			ret += ((ContainerTypeCode) m_contentTypeCode).getDepth();
    		}
    	}
    	
    	return ret;
    }

    private TypeCode m_contentTypeCode = null;
}
