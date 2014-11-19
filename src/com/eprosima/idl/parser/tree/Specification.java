package com.eprosima.idl.parser.tree;

import java.util.ArrayList;
import java.util.List;

public class Specification
{
    public Specification()
    {
		m_definitions = new ArrayList<Definition>();
    }
	
	public void setDefinitions(List<Definition> children) { m_definitions = children; }
	public List<Definition> getDefinitions() { return m_definitions; }
	public void addChild(Definition child) { m_definitions.add(child); }
	
	private List<Definition> m_definitions;
}

