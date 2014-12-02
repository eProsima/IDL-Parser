package com.eprosima.idl.parser.tree;

public interface Definition
{
    void setParent(Object obj);
    
    Object getParent();
    
    public boolean isIsModule();
    
    public boolean isIsInterface();
    
    public boolean isIsException();
    
    public boolean isIsTypeDeclaration();

    public boolean isIsConstDeclaration();
	
    public boolean isIsAnnotation();

	public Interface getFirstInterface(String scopeFile);
	
	public com.eprosima.idl.parser.tree.Exception getFirstException(String scopefile);
}
