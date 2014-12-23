package com.eprosima.idl.parser.tree;

import java.util.Map;

public interface Notebook 
{
    /*!
     * @brief This function links all annotations to the object.
     * @param annotations Annotations to be linked.
     */
    public void addAnnotation(Annotation annotation);
    
    /*!
     * @brief This function returns all annotations linked with the object.
     * @return Map with the linked annotations.
     */
    public Map<String, Annotation> getAnnotations();
}
