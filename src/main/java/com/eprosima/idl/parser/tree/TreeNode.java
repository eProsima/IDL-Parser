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

package com.eprosima.idl.parser.tree;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.exception.RuntimeGenerationException;

import java.util.Map;
import java.util.HashMap;

import org.antlr.v4.runtime.Token;

public class TreeNode implements Notebook
{
    public TreeNode(String scopeFile, boolean isInScope, String scope, String name, Token tk)
    {
        m_scopeFile = scopeFile;
        m_isinscope = isInScope;
        m_name = name;
        m_scope = scope;
        m_annotations = new HashMap<String, Annotation>();
        tk_ = tk;
    }

    public String getScopeFile()
    {
        return m_scopeFile;
    }

    public boolean isInScope()
    {
        return m_isinscope;
    }

    public String getName()
    {
        return m_name;
    }

    public String getScopedname()
    {
        if(m_scope == null || m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope + "::" + m_name;
    }

    public String getROS2Scopedname()
    {
        if(m_scope == null || m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope + "::dds_::" + m_name + "_";
    }

    public String getCScopedname()
    {
        if(m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope.replace("::", "_") + "_" + m_name;
    }

    public String getJavaScopedname()
    {
        if(m_scope.isEmpty())
        {
            return m_name;
        }

        return m_scope.replace("::", ".") + "." + m_name;
    }

    public String getScope()
    {
        return m_scope;
    }

    /*!
     * @ingroup api_for_stg
     * @brief This function returns the namespace where the type would be declared.
     * @return Namespace where the type would be declared.
     */
    public String getNamespace()
    {
        String namespace = m_scope;
        // Remove last scope when declared inside an Interface
        if (isDeclaredInsideInterface())
        {
            int last_index = m_scope.lastIndexOf("::");
            if (last_index == -1)
            {
                namespace = "";
            }
            else
            {
                namespace = m_scope.substring(0, last_index);
            }
        }
        return namespace;
    }

    protected boolean isDeclaredInsideInterface()
    {
        return false;
    }

    /*
     * @brief This function returns the scoped name of the interface but
     * changing "::" by "_".
     */
    public String getFormatedScopedname()
    {
        String ret = null;

        if(m_scope == null || m_scope.isEmpty())
        {
            ret = m_name;
        }
        else
        {
            ret = m_scope + "::" + m_name;
        }

        return ret.replaceAll("::", "_");
    }

    public boolean getHasScope()
    {
        return !(m_scope == null || m_scope.isEmpty());
    }

    @Override
    public void addAnnotation(Context ctx, Annotation annotation)
    {
        if(annotation != null)
        {
            m_annotations.put(annotation.getName(), annotation);
        }
    }

    @Override
    public Map<String, Annotation> getAnnotations()
    {
        return m_annotations;
    }

    /**
     * @ingroup api_for_stg
     * @brief This function checks if the node is annotated as nested.
     *
     * It is designed so it can be used in the templates with `$if(node.annotatedAsNested)$`
     *
     * @return true if the node is annotated as nested, false otherwise.
     */
    public boolean isAnnotatedAsNested()
    {
        Annotation ann = m_annotations.get(Annotation.nested_str);
        if (ann != null)
        {
            try
            {
                return ann.getValue().toUpperCase().equals(Annotation.capitalized_true_str);
            }
            catch (RuntimeGenerationException ex)
            {
                // Should not be called as @nested annotation has only one parameter
            }
        }
        return false;
    }

    public Token getToken()
    {
        return tk_;
    }

    private String m_scopeFile = null;
    private boolean m_isinscope = false;
    private String m_name = null;
    private String m_scope = null;
    //! Map that stores the annotations of the interface.
    private HashMap<String, Annotation> m_annotations = null;
    //! IDL Parser token
    Token tk_ = null;
}
