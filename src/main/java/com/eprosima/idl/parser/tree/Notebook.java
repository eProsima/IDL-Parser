package com.eprosima.idl.parser.tree;

import com.eprosima.idl.context.Context;

import java.util.Map;

public interface Notebook 
{
    /*!
     * @brief This function links all annotations to the object.
     * @param ctx Context used in the IDL parser. Can be useful for developers.
     * @param annotations Annotations to be linked.
     */
    public void addAnnotation(Context ctx, Annotation annotation);
    
    /*!
     * @brief This function returns all annotations linked with the object.
     * @return Map with the linked annotations.
     */
    public Map<String, Annotation> getAnnotations();
}
