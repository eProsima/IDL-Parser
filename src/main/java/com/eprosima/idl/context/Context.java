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

package com.eprosima.idl.context;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Scanner;
import java.util.Stack;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import org.antlr.v4.runtime.Token;
import org.stringtemplate.v4.STGroupFile;

import com.eprosima.idl.generator.manager.TemplateGroup;
import com.eprosima.idl.generator.manager.TemplateManager;
import com.eprosima.idl.parser.exception.ParseException;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.AnnotationDeclaration;
import com.eprosima.idl.parser.tree.AnnotationMember;
import com.eprosima.idl.parser.tree.ConstDeclaration;
import com.eprosima.idl.parser.tree.Definition;
import com.eprosima.idl.parser.tree.Interface;
import com.eprosima.idl.parser.tree.Operation;
import com.eprosima.idl.parser.tree.Param;
import com.eprosima.idl.parser.tree.TypeDeclaration;
import com.eprosima.idl.parser.tree.TreeNode;
import com.eprosima.idl.parser.typecode.AliasTypeCode;
import com.eprosima.idl.parser.typecode.AnyTypeCode;
import com.eprosima.idl.parser.typecode.ArrayTypeCode;
import com.eprosima.idl.parser.typecode.BitfieldSpec;
import com.eprosima.idl.parser.typecode.BitsetTypeCode;
import com.eprosima.idl.parser.typecode.Bitmask;
import com.eprosima.idl.parser.typecode.BitmaskTypeCode;
import com.eprosima.idl.parser.typecode.EnumMember;
import com.eprosima.idl.parser.typecode.EnumTypeCode;
import com.eprosima.idl.parser.typecode.Kind;
import com.eprosima.idl.parser.typecode.MapTypeCode;
import com.eprosima.idl.parser.typecode.PrimitiveTypeCode;
import com.eprosima.idl.parser.typecode.SequenceTypeCode;
import com.eprosima.idl.parser.typecode.SetTypeCode;
import com.eprosima.idl.parser.typecode.StringTypeCode;
import com.eprosima.idl.parser.typecode.StructTypeCode;
import com.eprosima.idl.parser.typecode.TypeCode;
import com.eprosima.idl.parser.typecode.UnionTypeCode;
import com.eprosima.idl.util.Pair;
import com.eprosima.idl.util.Util;

public class Context
{
    /*!
     * Built-in custom property to specify a TemplateGroup is using explicitly modules (in C++ when opening the
     * namespace "namespace module {")
     */
    public static final String using_explicitly_modules_custom_property = "using_explicitly_modules";

    public Context(
            TemplateManager tmanager,
            String file,
            ArrayList<String> includePaths,
            boolean generate_typesc
            )
    {
        tmanager_ = tmanager;
        generate_typesc_ = generate_typesc;

        // Detect OS
        m_os = System.getProperty("os.name");
        m_userdir = System.getProperty("user.dir");

        m_filename = Util.getIDLFileNameOnly(file).replace('.', '_').replace('-', '_');
        m_directoryFile = Util.getIDLFileDirectoryOnly(file);
        m_file = file;

        // Remove absolute directory where the application was executed
        if (startsWith(m_file, m_userdir))
        {
            m_file = m_file.substring(m_userdir.length());

            // Remove possible separator
            if (startsWith(m_file, java.io.File.separator))
            {
                m_file = m_file.substring(1);
            }
        }
        /*
           // Remove relative directory if is equal that where the processed IDL is.
           if(m_directoryFile != null && startsWith(m_file, m_directoryFile))
            m_file = m_file.substring(m_directoryFile.length());
         */

        m_keywords = new HashSet<String>();
        fillKeywords();

        // TODO Quitar porque solo es para tipos (previous c) (usado para las excepciones). Mirar alternativa.
        m_includedependency = new HashSet<String>();

        // The scope file has to be initialized because could occur the preprocessor
        // is not called (using -ppDisable).
        m_scopeFile = Paths.get(m_file).normalize().toString();

        m_includePaths = new ArrayList<String>();
        m_dependencies = new LinkedHashSet<String>();
        m_directIncludeDependencies = new HashSet<String>();
        m_scopeFilesStack = new Stack<Pair<String, Integer>>();
        for (int i = 0; i < includePaths.size(); ++i)
        {
            String include = includePaths.get(i);
            if (startsWith(include, includeFlag))
            {
                include = include.substring(includeFlag.length());
            }
            if (startsWith(include, m_userdir))
            {
                include = include.substring(m_userdir.length());

                // Remove possible separator
                if (startsWith(include, java.io.File.separator))
                {
                    include = include.substring(1);
                }
            }
            if (m_directoryFile != null && startsWith(include, m_directoryFile))
            {
                include = include.substring(m_directoryFile.length());
            }
            m_includePaths.add(Paths.get(include).normalize().toString() + java.io.File.separator);
        }

        // Reorder include paths;
        int pointer = 0;
        while (pointer < m_includePaths.size())
        {
            int count = pointer + 1;

            while (count < m_includePaths.size())
            {
                if (startsWith(m_includePaths.get(count), m_includePaths.get(pointer)))
                {
                    String first = m_includePaths.get(pointer);
                    String second = m_includePaths.get(count);
                    m_includePaths.set(pointer, second);
                    m_includePaths.set(count, first);
                    break;
                }
                ++count;
            }

            if (count == m_includePaths.size())
            {
                ++pointer;
            }
        }

        // Load IDL types for stringtemplates
        TypeCode.ctx = this;
        TypeCode.idltypesgr = new STGroupFile("com/eprosima/idl/templates/idlTypes.stg", '$', '$');
        if (generate_typesc)
        {
            TypeCode.cpptypesgr = new STGroupFile("com/eprosima/idl/templates/TypesCInterface.stg", '$', '$');
        }
        else
        {
            TypeCode.cpptypesgr = new STGroupFile("com/eprosima/idl/templates/Types.stg", '$', '$');
        }
        TypeCode.ctypesgr = new STGroupFile("com/eprosima/idl/templates/CTypes.stg", '$', '$');
        TypeCode.javatypesgr = new STGroupFile("com/eprosima/idl/templates/JavaTypes.stg", '$', '$');

        // Builtin annotations (IDL 4.2 - 8.3 section & XTypes 1.3 - 7.3.1.2.1 section)

        //{{{ @ami
        AnnotationDeclaration amiann = createAnnotationDeclaration(Annotation.ami_str, null);
        amiann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @autoid
        AnnotationDeclaration autoidann = createAnnotationDeclaration(Annotation.autoid_str, null);
        EnumTypeCode autoidannenum = new EnumTypeCode(autoidann.getScopedname(), Annotation.autoid_enum_str);
        autoidannenum.addMember(new EnumMember(Annotation.autoid_sequential_str));
        autoidannenum.addMember(new EnumMember(Annotation.autoid_hash_str));
        autoidann.addMember(new AnnotationMember(Annotation.value_str, autoidannenum, Annotation.autoid_hash_str));
        //}}}

        //{{{ @bit_bound
        AnnotationDeclaration bit_boundann = createAnnotationDeclaration(Annotation.bit_bound_str, null);
        bit_boundann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_USHORT), Annotation.null_default_value));
        //}}}

        //{{{ @data_representation
        BitmaskTypeCode data_representation_mask_bitmask = new BitmaskTypeCode(null, Annotation.data_representation_mask_str);
        Bitmask xcdr1_bitmask = new Bitmask(data_representation_mask_bitmask, Annotation.xcdr1_bitflag_str);
        xcdr1_bitmask.setPosition(0);
        data_representation_mask_bitmask.addBitmask(xcdr1_bitmask);
        Bitmask xml_bitmask = new Bitmask(data_representation_mask_bitmask, Annotation.xml_bitflag_str);
        xml_bitmask.setPosition(1);
        data_representation_mask_bitmask.addBitmask(xml_bitmask);
        Bitmask xcdr2_bitmask = new Bitmask(data_representation_mask_bitmask, Annotation.xcdr2_bitflag_str);
        xcdr2_bitmask.setPosition(2);
        data_representation_mask_bitmask.addBitmask(xcdr2_bitmask);

        AnnotationDeclaration data_representation_annotation = createAnnotationDeclaration(Annotation.data_representation_str, null);
        data_representation_annotation.addMember(new AnnotationMember(Annotation.allowed_kinds_str, data_representation_mask_bitmask, Annotation.empty_str));
        //}}}

        //{{{ @default
        AnnotationDeclaration defaultann = createAnnotationDeclaration(Annotation.default_str, null);
        defaultann.addMember(new AnnotationMember(Annotation.value_str, new AnyTypeCode(), null));
        //}}}

        //{{{ @default_literal
        createAnnotationDeclaration(Annotation.default_literal_str, null);
        //}}}

        //{{{ @default_nested
        AnnotationDeclaration default_nested_annotation = createAnnotationDeclaration(Annotation.default_nested_str, null);
        default_nested_annotation.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @extensibility
        AnnotationDeclaration extensibilityann = createAnnotationDeclaration(Annotation.extensibility_str, null);
        EnumTypeCode extensibilityannenum = new EnumTypeCode(extensibilityann.getScopedname(), Annotation.extensibility_enum_str);
        extensibilityannenum.addMember(new EnumMember(Annotation.ex_final_str));
        extensibilityannenum.addMember(new EnumMember(Annotation.ex_appendable_str));
        extensibilityannenum.addMember(new EnumMember(Annotation.ex_mutable_str));
        extensibilityann.addMember(new AnnotationMember(Annotation.value_str, extensibilityannenum,
                extensibilityannenum.getInitialValue()));

        createAnnotationDeclaration(Annotation.final_str, null);
        createAnnotationDeclaration(Annotation.appendable_str, null);
        createAnnotationDeclaration(Annotation.mutable_str, null);
        //}}}

        //{{{ @external
        AnnotationDeclaration externalann = createAnnotationDeclaration(Annotation.external_str, null);
        externalann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @hashid
        AnnotationDeclaration hashid_annotation = createAnnotationDeclaration(Annotation.hashid_str, null);
        hashid_annotation.addMember(new AnnotationMember(Annotation.value_str, new StringTypeCode(Kind.KIND_STRING, null, null), Annotation.empty_str));
        //}}}

        //{{{ @id
        AnnotationDeclaration idann = createAnnotationDeclaration(Annotation.id_str, null);
        idann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_ULONG), Annotation.null_default_value));
        //}}}

        //{{{ @ignore_literal_names
        AnnotationDeclaration ignore_literal_names_annotation = createAnnotationDeclaration(Annotation.ignore_literal_names_str, null);
        ignore_literal_names_annotation.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @key
        // Create default @key annotation (@Key annotation also supported and registered in parseIDL)
        AnnotationDeclaration keyann = createAnnotationDeclaration(Annotation.key_str, null);
        keyann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @max
        AnnotationDeclaration maxann = createAnnotationDeclaration(Annotation.max_str, null);
        maxann.addMember(new AnnotationMember(Annotation.value_str, new AnyTypeCode(), null));
        //}}}

        //{{{ @min
        AnnotationDeclaration minann = createAnnotationDeclaration(Annotation.min_str, null);
        minann.addMember(new AnnotationMember(Annotation.value_str, new AnyTypeCode(), null));
        //}}}

        //{{{ @must_understand
        AnnotationDeclaration mustundann = createAnnotationDeclaration(Annotation.must_understand_str, null);
        mustundann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @nested
        AnnotationDeclaration nestedann = createAnnotationDeclaration(Annotation.nested_str, null);
        nestedann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @non_serialized
        AnnotationDeclaration non_serializedann = createAnnotationDeclaration(Annotation.non_serialized_str, null);
        non_serializedann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @oneway
        AnnotationDeclaration onewayann = createAnnotationDeclaration(Annotation.oneway_str, null);
        onewayann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @optional
        AnnotationDeclaration optionalann = createAnnotationDeclaration(Annotation.optional_str, null);
        optionalann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_BOOLEAN), Annotation.true_str));
        //}}}

        //{{{ @position
        AnnotationDeclaration positionann = createAnnotationDeclaration(Annotation.position_str, null);
        positionann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_USHORT), Annotation.null_default_value));
        //}}}

        //{{{ @range
        AnnotationDeclaration rangeann = createAnnotationDeclaration(Annotation.range_str, null);
        rangeann.addMember(new AnnotationMember(Annotation.min_str, new AnyTypeCode(), null));
        rangeann.addMember(new AnnotationMember(Annotation.max_str, new AnyTypeCode(), null));
        //}}}

        //{{{ @service
        AnnotationDeclaration serviceann = createAnnotationDeclaration(Annotation.service_str, null);
        serviceann.addMember(new AnnotationMember(Annotation.platform_str, new PrimitiveTypeCode(Kind.KIND_STRING), Annotation.any_str));
        // CORBA, DDS, * (any), or custom value
        //}}}

        //{{{ topic
        AnnotationDeclaration topic_annotation = createAnnotationDeclaration(Annotation.topic_str, null);
        topic_annotation.addMember(new AnnotationMember(Annotation.name_str, new PrimitiveTypeCode(Kind.KIND_STRING), Annotation.empty_str));
        topic_annotation.addMember(new AnnotationMember(Annotation.platform_str, new PrimitiveTypeCode(Kind.KIND_STRING), Annotation.any_str));
        //}}}

        //{{{ @try_construct
        EnumTypeCode try_construct_fail_action_enum = new EnumTypeCode(null, Annotation.try_construct_enum_str);
        try_construct_fail_action_enum.addMember(new EnumMember(Annotation.try_construct_discard_str));
        try_construct_fail_action_enum.addMember(new EnumMember(Annotation.try_construct_use_default_str));
        try_construct_fail_action_enum.addMember(new EnumMember(Annotation.try_construct_trim_str));

        AnnotationDeclaration try_construct_annotation = createAnnotationDeclaration(Annotation.try_construct_str, null);
        try_construct_annotation.addMember(new AnnotationMember(Annotation.value_str, try_construct_fail_action_enum, Annotation.try_construct_use_default_str));
        //}}}

        //{{{ @unit
        AnnotationDeclaration unitsann = createAnnotationDeclaration(Annotation.unit_str, null);
        unitsann.addMember(new AnnotationMember(Annotation.value_str, new PrimitiveTypeCode(Kind.KIND_STRING), Annotation.empty_str));
        //}}}

        //{{{ @value
        AnnotationDeclaration valueann = createAnnotationDeclaration(Annotation.value_str, null);
        valueann.addMember(new AnnotationMember(Annotation.value_str, new AnyTypeCode(), null));
        //}}}

        //{{{ @verbatim
        AnnotationDeclaration verbatimann = createAnnotationDeclaration(Annotation.verbatim_str, null);
        EnumTypeCode verbatimannenum = new EnumTypeCode(verbatimann.getScopedname(), Annotation.placement_enum_str);
        verbatimannenum.addMember(new EnumMember(Annotation.begin_file_str));
        verbatimannenum.addMember(new EnumMember(Annotation.before_declaration_str));
        verbatimannenum.addMember(new EnumMember(Annotation.begin_declaration_str));
        verbatimannenum.addMember(new EnumMember(Annotation.end_declaration_str));
        verbatimannenum.addMember(new EnumMember(Annotation.after_declaration_str));
        verbatimannenum.addMember(new EnumMember(Annotation.end_file_str));
        verbatimann.addMember(new AnnotationMember(Annotation.language_str, new PrimitiveTypeCode(Kind.KIND_STRING), Annotation.any_str));
        // c, c++, java, idl, * (any), or custom value
        verbatimann.addMember(new AnnotationMember(Annotation.placement_str, verbatimannenum, Annotation.before_declaration_str));
        verbatimann.addMember(new AnnotationMember(Annotation.text_str, new PrimitiveTypeCode(Kind.KIND_STRING), Annotation.empty_str));
        //}}}
    }

    public String getFilename()
    {
        return m_filename;
    }

    public void setFilename(
            String filename)
    {
        m_filename = filename;
    }

    public String getTrimfilename()
    {
        return Util.stringTrimAll(m_filename);
    }

    public String getScope()
    {
        return m_scope;
    }

    public void setScope(
            String scope)
    {
        m_scope = scope;
    }

    public String getRelativeDir(String dependant_idl_dir)
    {
        String relative_dir = Util.getIDLFileDirectoryOnly(m_file);

        if(null != relative_dir)
        {
            File rel_dir = new File(relative_dir);

            if (rel_dir.isAbsolute())
            {
                if (null != dependant_idl_dir && relative_dir.startsWith(dependant_idl_dir))
                {
                    relative_dir = relative_dir.substring(dependant_idl_dir.length());
                }
                else
                {
                    relative_dir = "";
                }
            }
        }
        else
        {
            relative_dir = "";
        }

        return relative_dir;
    }

    /*!
     * @return True if current call is in scoped file.
     */
    public boolean isInScopedFile()
    {
        return m_scopeFile.equals(m_file);
    }

    public String getScopeFile()
    {
        return m_scopeFile;
    }

    public boolean isScopeLimitToAll()
    {
        return m_scopeLimitToAll;
    }

    public void setScopeLimitToAll(
            boolean scopeLimitToAll)
    {
        m_scopeLimitToAll = scopeLimitToAll;
    }

    public int getCurrentIncludeLine()
    {
        return m_currentincludeline;
    }

    public Stack<Pair<String, Integer>> getScopeFilesStack()
    {
        return m_scopeFilesStack;
    }

    /*!
     * @brief This function stores a global definition of the IDL file.
     */
    public void addDefinition(
            Definition definition)
    {
        m_definitions.add(definition);
    }

    public ArrayList<Definition> getDefinitions()
    {
        return m_definitions;
    }

    /*!
     * @brief This function adds a module to the context.
     * This function is used in the parser.
     */
    public TemplateGroup addModule(
            com.eprosima.idl.parser.tree.Module module)
    {
        TemplateGroup moduleTemplates = null;

        if (!m_modules.containsKey(module.getScopedname()))
        {
            m_modules.put(module.getScopedname(), module);
        }

        if(isInScopedFile() || isScopeLimitToAll()) {
            if(tmanager_ != null) {
                moduleTemplates = tmanager_.createTemplateGroup("module");
                moduleTemplates.setAttribute("ctx", this);
                // Set the module object to the TemplateGroup of the module.
                moduleTemplates.setAttribute("module", module);
            }
        }

        // Change context scope.
        if (m_scope.isEmpty())
        {
            setScope(module.getName());
        }
        else
        {
            setScope(m_scope + "::" + module.getName());
        }

        return moduleTemplates;
    }

    public com.eprosima.idl.parser.tree.Module existsModule(
            String scopedName)
    {
        if (m_modules.containsKey(scopedName))
        {
            return m_modules.get(scopedName);
        }

        return null;
    }

    public Interface createInterface(
            String name,
            Token token)
    {
        Interface interfaceObject = new Interface(m_scopeFile, isInScopedFile(), m_scope, name, token);
        addInterface(interfaceObject);
        return interfaceObject;
    }

    /*!
     * @brief This function adds a interface to the context.
     * This function is used in the parser.
     */
    protected void addInterface(
            Interface interf)
    {
        Interface prev = m_interfaces.put(interf.getScopedname(), interf);

        // TODO: Excepcion
        if (prev != null)
        {
            System.out.println("Warning: Redefined interface " + prev.getScopedname());
        }
    }

    public Interface getInterface(
            String name)
    {
        int lastIndex = -1;
        Interface returnedValue = m_interfaces.get(name);

        if (returnedValue == null)
        {
            String scope = m_scope;

            while (returnedValue == null && !scope.isEmpty())
            {
                returnedValue = m_interfaces.get(scope + "::" + name);
                lastIndex = scope.lastIndexOf("::");

                if (lastIndex != -1)
                {
                    scope = scope.substring(0, lastIndex);
                }
                else
                {
                    scope = "";
                }
            }
        }

        return returnedValue;
    }

    /*!
     * @brief This function returns all interfaces.
     * This function is used in string templates.
     */
    public ArrayList<Interface> getInterfaces()
    {
        return new ArrayList<Interface>(m_interfaces.values());
    }

    public ArrayList<Interface> getScopedInterfaces()
    {
        ArrayList<Interface> ret = new ArrayList<Interface>();

        for (Interface interf : m_interfaces.values())
        {
            if (interf.isInScope())
            {
                ret.add(interf);
            }
        }

        return ret;
    }

    public com.eprosima.idl.parser.tree.Exception createException(
            String name,
            Token token)
    {
        com.eprosima.idl.parser.tree.Exception exceptionObject = new com.eprosima.idl.parser.tree.Exception(m_scopeFile,
                        isInScopedFile(), m_scope, name, token);
        addException(exceptionObject);
        return exceptionObject;
    }

    /*!
     * @brief This function adds a global exception to the context.
     */
    protected void addException(
            com.eprosima.idl.parser.tree.Exception exception)
    {
        com.eprosima.idl.parser.tree.Exception prev = m_exceptions.put(exception.getScopedname(), exception);

        // TODO: Exception.
        if (prev != null)
        {
            System.out.println("Warning: Redefined exception " + prev.getScopedname());
        }
    }

    /*!
     * @brief This function tries to retrieve a global typecode.
     */
    public com.eprosima.idl.parser.tree.Exception getException(
            String name)
    {
        int lastIndex = -1;
        com.eprosima.idl.parser.tree.Exception returnedValue = m_exceptions.get(name);

        // Probar si no tiene scope, con el scope actual.
        if (returnedValue == null)
        {
            String scope = m_scope;

            while (returnedValue == null && !scope.isEmpty())
            {
                returnedValue = m_exceptions.get(scope + "::" + name);
                lastIndex = scope.lastIndexOf("::");

                if (lastIndex != -1)
                {
                    scope = scope.substring(0, lastIndex);
                }
                else
                {
                    scope = "";
                }
            }
        }

        return returnedValue;
    }

    public com.eprosima.idl.parser.tree.Module createModule(
            String scope_file,
            boolean is_in_scope,
            String scope,
            String name,
            Token token)
    {
        return new com.eprosima.idl.parser.tree.Module (scope_file, is_in_scope, scope, name, token);
    }

    public Operation createOperation(
            String name,
            Token token)
    {
        Operation operationObject = new Operation(m_scopeFile, isInScopedFile(), null, name, token);
        return operationObject;
    }

    public Param createParam(
            String name,
            TypeCode typecode,
            Param.Kind kind)
    {
        Param paramObject = new Param(name, typecode, kind);
        return paramObject;
    }

    public Param createParam(
            String name,
            Definition definition,
            Param.Kind kind)
    {
        Param paramObject = new Param(name, definition, kind);
        return paramObject;
    }

    public AliasTypeCode createAliasTypeCode(
            String scope,
            String name)
    {
        return new AliasTypeCode(scope, name);
    }

    public ArrayTypeCode createArrayTypeCode()
    {
        return new ArrayTypeCode();
    }

    public BitmaskTypeCode createBitmaskTypeCode(
            String scope,
            String name)
    {
        return new BitmaskTypeCode(scope, name);
    }

    public BitsetTypeCode createBitsetTypeCode(
            String scope,
            String name)
    {
        return new BitsetTypeCode(scope, name);
    }

    public EnumTypeCode createEnumTypeCode(
            String scope,
            String name)
    {
        return new EnumTypeCode(scope, name);
    }

    public MapTypeCode createMapTypeCode(
            String maxsize)
    {
        return new MapTypeCode(maxsize, evaluate_literal(maxsize));
    }

    public PrimitiveTypeCode createPrimitiveTypeCode(
            int kind)
    {
        return new PrimitiveTypeCode(kind);
    }

    public SequenceTypeCode createSequenceTypeCode(
            String maxsize)
    {
        return new SequenceTypeCode(maxsize, evaluate_literal(maxsize));
    }

    public SetTypeCode createSetTypeCode(
            String maxsize)
    {
        return new SetTypeCode(maxsize, evaluate_literal(maxsize));
    }

    public StringTypeCode createStringTypeCode(
            int kind,
            String maxsize)
    {
        return new StringTypeCode(kind, maxsize, evaluate_literal(maxsize));
    }

    public StructTypeCode createStructTypeCode(
            String name)
    {
        return new StructTypeCode(m_scope, name);
    }

    public UnionTypeCode createUnionTypeCode(
            String scope,
            String name)
    {
        return new UnionTypeCode(m_scope, name);
    }

    public UnionTypeCode createUnionTypeCode(
            String scope,
            String name,
            TypeCode discriminatorTypeCode)
    {
        return new UnionTypeCode(m_scope, name, discriminatorTypeCode);
    }

    public BitfieldSpec createBitfieldSpec(
            String size,
            TypeCode type)
    {
        BitfieldSpec object = new BitfieldSpec(m_scope, size, type);
        return object;
    }

    public Collection<com.eprosima.idl.parser.tree.Exception> getExceptions()
    {
        return m_exceptions.values();
    }

    public Collection<TypeDeclaration> getTypes()
    {
        return m_types.values();
    }

    /*!
     * @brief This function adds a global typecode to the context.
     */
    public void addTypeDeclaration(
            TypeDeclaration typedecl)
    {
        TypeDeclaration prev = m_types.put(typedecl.getScopedname(), typedecl);

        if (prev != null)
        {
            throw new ParseException(typedecl.getToken(), "was redefined");
        }
    }

    /*!
     * @brief This function returns a global typecode of the context.
     */
    public TypeDeclaration getTypeDeclaration(
            String scopedName)
    {
        return m_types.get(scopedName);
    }

    /*!
     * @brief This function tries to retrieve a global typecode.
     */
    public TypeCode getTypeCode(
            String name)
    {
        int lastIndex = -1;
        TypeCode returnedValue = null;
        TypeDeclaration typedecl = m_types.get(name);

        // Wether the name doesn't contain scope, test with the current scope.
        if (typedecl == null)
        {
            String scope = m_scope;

            while (typedecl == null && scope != null && !scope.isEmpty())
            {
                typedecl = m_types.get(scope + "::" + name);
                lastIndex = scope.lastIndexOf("::");

                if (lastIndex != -1)
                {
                    scope = scope.substring(0, lastIndex);
                }
                else
                {
                    scope = "";
                }
            }
        }

        if (typedecl != null)
        {
            returnedValue = typedecl.getTypeCode();
        }


        return returnedValue;
    }

    public AnnotationDeclaration createAnnotationDeclaration(
            String name,
            Token token)
    {
        AnnotationDeclaration annotationObject = new AnnotationDeclaration(m_scopeFile,
                        isInScopedFile(), m_scope, name, token);
        addAnnotationDeclaration(annotationObject);
        return annotationObject;
    }

    /*!
     * @brief This function adds an annotation to the context.
     */
    protected void addAnnotationDeclaration(
            AnnotationDeclaration annotation)
    {
        AnnotationDeclaration prev = m_annotations.put(annotation.getScopedname(), annotation);

        // TODO: Exception.
        if (prev != null)
        {
            System.out.println("Warning: Redefined annotation " + prev.getScopedname());
        }
    }

    public AnnotationDeclaration getAnnotationDeclaration(
            String name)
    {
        int lastIndex = -1;
        AnnotationDeclaration returnedValue = m_annotations.get(name);

        // Probar si no tiene scope, con el scope actual.
        if (returnedValue == null)
        {
            String scope = m_scope;

            while (returnedValue == null && !scope.isEmpty())
            {
                returnedValue = m_annotations.get(scope + "::" + name);
                lastIndex = scope.lastIndexOf("::");

                if (lastIndex != -1)
                {
                    scope = scope.substring(0, lastIndex);
                }
                else
                {
                    scope = "";
                }
            }
        }

        return returnedValue;
    }

    /*!
     * @brief This function add a new library dependency to the project.
     */
    public void addDependency(
            String dependency)
    {
        m_dependencies.add(dependency);
    }

    /*!
     * @brief This function get the library dependencies of a project.
     */
    public LinkedHashSet<String> getDependencies()
    {
        // At this level the dependencies are in reverse order. Return them
        // in correct order.
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        LinkedList<String> list = new LinkedList<String>(m_dependencies);
        Iterator<String> it = list.descendingIterator();

        while (it.hasNext())
        {
            String dep = it.next();

            if (getOS().contains("Windows"))
            {
                // In windows substitute \\ by /
                int count = 0;
                while ((count = dep.indexOf("/")) != -1)
                {
                    dep = dep.substring(0, count) + "\\" + dep.substring(count + 1);
                }
            }

            set.add(dep);
        }

        return set;
    }

    /*!
     * @brief This function is used in the stringtemplates. For these reason this function
     * returns an ArrayList
     */
    public ArrayList<String> getDirectIncludeDependencies()
    {
        return new ArrayList<String>(m_directIncludeDependencies);
    }

    // TODO Quitar porque solo es para tipos (previous c) (usado para las excepciones). Mirar alternativa.
    /*!
     * @brief This function add a new include dependency to the project.
     * This dependency will be needed to include our generated file with the types that
     * the (previous c) DDS middleware doesn't generate (right now only exceptions).
     * The include dependencies are added without the .idl extension.
     */
    public void addIncludeDependency(
            String dependency)
    {
        // Remove .idl extension.
        String dep = dependency.substring(0, dependency.length() - 4);
        // Remove directory if it is the same than main IDL file.
        if (m_directoryFile != null && startsWith(dep, m_directoryFile))
        {
            dep = dep.substring(m_directoryFile.length());
        }
        m_includedependency.add(dep);
    }

    // TODO Quitar porque solo es para tipos (previous c) (usado para las excepciones). Mirar alternativa.
    /*!
     * @brief This function is used in the stringtemplates. For these reason this function
     * returns an ArrayList
     */
    public ArrayList<String> getIncludeDependencies()
    {
        return new ArrayList<String>(m_includedependency);
    }

    /*!
     * @brief This function is call when a preprocessor line was found by the lexer.
     * In case the line referring to the content included file, this function sets this file as current scope file.
     * Also this function saves the scope file in the library dependecy map.
     * In case it is a #include directive, this is saved as direct include dependency.
     */
    public void processPreprocessorLine(
            String line,
            int nline)
    {
        // If there is a line referring to the content of an included file.
        if (line.startsWith("# "))
        {
            String line_ = line.substring(2);

            /* The received preprocessor line has the following form:
             * ' numline filename flags'
             * where:
             * - numline Number of the line where the include was.
             * - filename The filename whose content was included.
             * - flags
             */
            Scanner scanner = new Scanner(line_);

            // Read numline
            int numline = scanner.nextInt();

            line_ = scanner.nextLine();
            scanner = new Scanner(line_).useDelimiter("\"");

            // Read filename
            scanner.next();
            String file = Paths.get(scanner.next()).normalize().toString();

            // Read flags.
            boolean systemFile = false, enteringFile = false, exitingFile = false;

            if (m_os.contains("Linux"))
            {
                try
                {
                    line_ = scanner.nextLine();
                    scanner = new Scanner(line_);
                    scanner.next();

                    while (true)
                    {
                        Integer flag = scanner.nextInt();

                        if (flag == 1)
                        {
                            enteringFile = true;
                        }
                        else if (flag == 2)
                        {
                            exitingFile = true;
                        }
                        else if (flag == 3)
                        {
                            systemFile = true;
                        }
                    }
                }
                catch (NoSuchElementException ex)
                {
                    // The line finishes.
                }
            }

            // Only not system files are processed.
            if (!systemFile)
            {
                if (!m_scopeFile.equals(file))
                {
                    // Remove absolute directory where the application was executed
                    if (startsWith(file, m_userdir))
                    {
                        file = file.substring(m_userdir.length());

                        // Remove possible separator
                        if (startsWith(file, java.io.File.separator))
                        {
                            file = file.substring(1);
                        }
                    }
                    // Remove relative ./ directory.
                    if (startsWith(file, currentDirS))
                    {
                        file = file.substring(currentDirS.length());
                        // Remove possible separator
                        if (startsWith(file, java.io.File.separator))
                        {
                            file = file.substring(1);
                        }
                    }


                    //if it is a idl file.
                    if (file.substring(file.length() - 4, file.length()).equals(".idl"))
                    {
                        if (!m_scopeFile.equals(file))
                        {
                            if (!m_scopeFilesStack.empty() && m_scopeFilesStack.peek().first().equals(file))
                            {
                                m_scopeFilesStack.pop();

                                // Add to dependency if there is different IDL file than the processed
                                addDependency(m_scopeFile);

                                // See if it is a direct dependency.
                                if (file.equals(m_file))
                                {
                                    String includeFile = m_scopeFile;
                                    // Remove relative directory if is equal that where the processed IDL is.
                                    if (m_directoryFile != null && startsWith(includeFile, m_directoryFile))
                                    {
                                        includeFile = includeFile.substring(m_directoryFile.length());
                                    }
                                    // Remove relative directory if is equal to a include path.
                                    for (int i = 0; i < m_includePaths.size(); ++i)
                                    {
                                        if (startsWith(includeFile, m_includePaths.get(i)))
                                        {
                                            includeFile = includeFile.substring(m_includePaths.get(i).length());
                                            break;
                                        }
                                    }

                                    String dependency_to_add =
                                    includeFile.substring(0, includeFile.length() - 4).replace('.', '_');
                                    // Change back to "." for relative paths.
                                    dependency_to_add = dependency_to_add.replaceAll("__/", "../");
                                    // Substitute "\\" with File separator.
                                    dependency_to_add = dependency_to_add.replace('\\', '/');

                                    m_directIncludeDependencies.add(dependency_to_add);
                                }
                            }
                            else
                            {
                                m_scopeFilesStack.push(new Pair<String, Integer>(m_scopeFile,
                                        nline - m_currentincludeline - 1));
                            }

                            m_scopeFile = file;
                        }
                    }
                }

                //Update the current line.
                m_currentincludeline = nline - numline;
            }
        }
    }

    protected String getOS()
    {
        return m_os;
    }

    protected boolean startsWith(
            String st,
            String prefix)
    {
        if (m_os.contains("Windows"))
        {
            return st.toLowerCase().startsWith(prefix.toLowerCase());
        }

        return st.startsWith(prefix);
    }

    /*** Function to generate random loop variables in string templates ***/
    public String getNewLoopVarName()
    {
        m_loopVarName = 'a';
        return Character.toString(m_loopVarName);
    }

    public String getNextLoopVarName()
    {
        return Character.toString(++m_loopVarName);
    }

    public String removeEscapeCharacter(
            String id)
    {
        if (id.startsWith("_")) // Escaped identifier?
        {
            id = id.substring(1);
        }
        return id;
    }

    public String checkIdentifier(
            Definition.Kind kind,
            String scope,
            String id)
    {
        if (checkKeyword(id))
        {
            return id + " is a keyword, use escape character if you want to use it as identifier (_" + id + ")";
        }

        String scopedname = (scope == null || scope.isEmpty()) ? id : scope + "::" + id;

        // Check definitions
        for (Definition def : m_definitions)
        {
            if (def instanceof TreeNode)
            {
                TreeNode tn = (TreeNode)def;
                if (m_ignore_case
                        ? tn.getScopedname().equalsIgnoreCase(scopedname)
                        : tn.getScopedname().equals(scopedname)
                        )
                {
                    boolean error = true;

                    if (kind == Definition.Kind.MODULE && tn instanceof com.eprosima.idl.parser.tree.Module)
                    {
                        error = false;
                    }
                    else if (kind == Definition.Kind.TYPE_DECLARATION &&
                            tn instanceof com.eprosima.idl.parser.tree.TypeDeclaration &&
                            !((com.eprosima.idl.parser.tree.TypeDeclaration)tn).getTypeCode().isDefined())
                    {
                        error = false;
                    }

                    if (error)
                    {
                        return scopedname + " is already defined (Definition: " + def + ")";
                    }
                }
            }
        }

        // Check modules
        for (String type : m_modules.keySet())
        {
            if (m_ignore_case
                    ? type.equalsIgnoreCase(scopedname)
                    : type.equals(scopedname)
                    )
            {
                if (kind != Definition.Kind.MODULE)
                {
                    return scopedname + " is already defined (Module: " + type + ")";
                }
            }
        }

        // Check interfaces
        for (String type : m_interfaces.keySet())
        {
            if (m_ignore_case
                    ? type.equalsIgnoreCase(scopedname)
                    : type.equals(scopedname)
                    )
            {
                return scopedname + " is already defined (Interface: " + type + ")";
            }
        }

        // Check Exceptions
        for (String type : m_exceptions.keySet())
        {
            if (m_ignore_case
                    ? type.equalsIgnoreCase(scopedname)
                    : type.equals(scopedname)
                    )
            {
                return scopedname + " is already defined (Exception: " + type + ")";
            }
        }

        // Check TypeDeclarations
        for (Map.Entry<String, TypeDeclaration> type : m_types.entrySet())
        {
            if (m_ignore_case
                    ? type.getKey().equalsIgnoreCase(scopedname)
                    : type.getKey().equals(scopedname)
                    )
            {
                if (type.getValue().getTypeCode().isDefined())
                {
                    return scopedname + " is already defined (Type: " + type + ")";
                }
            }
        }

        // Check Annotations, only check annotations against other annotations
        if (kind == Definition.Kind.ANNOTATION)
        {
            for (String anno : m_annotations.keySet())
            {
                if (m_ignore_case
                        ? anno.equalsIgnoreCase(scopedname)
                        : anno.equals(scopedname)
                        )
                {
                    return scopedname + " is already defined (Annotation: " + anno + ")";
                }
            }
        }

        if (id.startsWith("_")) // Escaped identifier?
        {
            id = id.substring(1);
        }

        return null;
    }

    public void ignore_case(
            boolean ignore_case)
    {
        m_ignore_case = ignore_case;
    }

    protected void fillKeywords()
    {
        m_keywords.add("setraises");
        m_keywords.add("out");
        m_keywords.add("emits");
        m_keywords.add("string");
        m_keywords.add("switch");
        m_keywords.add("publishes");
        m_keywords.add("typedef");
        m_keywords.add("uses");
        m_keywords.add("primarykey");
        m_keywords.add("custom");
        m_keywords.add("octet");
        m_keywords.add("sequence");
        m_keywords.add("import");
        m_keywords.add("struct");
        m_keywords.add("native");
        m_keywords.add("readonly");
        m_keywords.add("finder");
        m_keywords.add("raises");
        m_keywords.add("void");
        m_keywords.add("private");
        m_keywords.add("eventtype");
        m_keywords.add("wchar");
        m_keywords.add("in");
        m_keywords.add("default");
        m_keywords.add("public");
        m_keywords.add("short");
        m_keywords.add("long");
        m_keywords.add("enum");
        m_keywords.add("wstring");
        m_keywords.add("context");
        m_keywords.add("home");
        m_keywords.add("factory");
        m_keywords.add("exception");
        m_keywords.add("getraises");
        m_keywords.add("const");
        m_keywords.add("ValueBase");
        m_keywords.add("valuetype");
        m_keywords.add("supports");
        m_keywords.add("module");
        m_keywords.add("Object");
        m_keywords.add("truncatable");
        m_keywords.add("unsigned");
        m_keywords.add("fixed");
        m_keywords.add("union");
        m_keywords.add("oneway");
        m_keywords.add("any");
        m_keywords.add("char");
        m_keywords.add("case");
        m_keywords.add("float");
        m_keywords.add("boolean");
        m_keywords.add("multiple");
        m_keywords.add("abstract");
        m_keywords.add("inout");
        m_keywords.add("provides");
        m_keywords.add("consumes");
        m_keywords.add("double");
        m_keywords.add("typeprefix");
        m_keywords.add("typeid");
        m_keywords.add("attribute");
        m_keywords.add("local");
        m_keywords.add("manages");
        m_keywords.add("interface");
        m_keywords.add("component");
        m_keywords.add("set");
        m_keywords.add("map");
        m_keywords.add("bitfield");
        m_keywords.add("bitset");
        m_keywords.add("bitmask");
        m_keywords.add("annotation");
    }

    protected boolean checkKeyword(
            String id)
    {
        boolean return_value = false;

        for (String keyword : m_keywords)
        {
            if (m_ignore_case
                    ? keyword.equalsIgnoreCase(id)
                    : keyword.equals(id)
                    )
            {
                return_value = true;
                break;
            }
        }

        return return_value;
    }

    public String concatStringLiterals(
            String literal)
    {
        // Split into separated strings
        String[] substrings = literal.split("\"([ \r\t\u000C\n])*\"");

        String result = "";
        boolean escapeHex = false;
        for (String str : substrings)
        {
            if (escapeHex)
            {
                str = "\"" + str;
            }
            escapeHex = false;
            if (str.matches("\\\\x[a-fA-F0-9]+$"))
            {
                escapeHex = true;
            }
            result += str + (escapeHex ? "\"" : "");
        }

        return result;
    }

    /*** End ***/

    public static ScriptEngine getJSScriptEngine()
    {
        if (Double.parseDouble(System.getProperty("java.specification.version")) < 11)
        {
            return new ScriptEngineManager().getEngineByName("js");
        }
        else
        {
            return new org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory()
                           .getScriptEngine();
        }
    }

    public String evaluate_literal(
            String str)
    {
        if (null == str)
        {
            return null;
        }

        String aux_str = "(" + str.replace("::", "_") + ") | 0";
        String const_str = "";

        // Add all constants.

        for (Definition definition : m_definitions)
        {
            if (definition.isIsConstDeclaration())
            {
                ConstDeclaration const_decl = (ConstDeclaration)definition;

                if ((const_decl.getTypeCode().isPrimitive() && !const_decl.getTypeCode().isIsEnumType())
                || const_decl.getTypeCode().isIsStringType()
                || const_decl.getTypeCode().isIsWStringType())
                {
                    const_str = const_str + ";" + const_decl.getFormatedScopedname() + "=" + const_decl.getEvaluatedValue();

                    if (const_decl.getScope() == getScope())
                    {
                        const_str = const_str + ";" + const_decl.getName() + "=" + const_decl.getEvaluatedValue();
                    }
                }
            }
        }

        const_str = const_str.replace("=L'", "='").replace("=L\"", "=\""); // remove "L" from wchar and wstring declarations
        aux_str = const_str + ";" + aux_str;

        // Process the math expression
        try
        {
            ScriptEngine engine = getJSScriptEngine();
            aux_str = engine.eval(aux_str).toString();
        }
        catch (ScriptException se)
        {
            throw new ParseException(null, "Error evaluating expression: " + aux_str);
        }

        return aux_str;
    }

    public boolean isGenerateTypesC()
    {
        return generate_typesc_;
    }

    /*!
     * @brief Checks a custom property was enables for a TemplateGroup.
     *
     * There are built-in custom properties:
     * - Context.using_explicitly_modules_custom_property: specifies a TemplateGroup is using explicitly modules.
     */
    public boolean is_enabled_custom_property_in_current_group(String custom_property)
    {
        if (null != tmanager_)
        {
            return tmanager_.is_enabled_custom_property_in_current_group(custom_property);
        }

        return false;
    }

    // OS
    String m_os = null;
    String m_userdir = null;

    private String m_filename = "";
    private String m_file = "";
    private String m_directoryFile = "";

    private String m_scope = "";
    private String m_scopeFile = "";
    private boolean m_scopeLimitToAll = false;

    private int m_currentincludeline = 0;

    final String currentDirS = "." + File.separator;
    final String includeFlag = "-I";

    //! Store all global definitions.
    private ArrayList<Definition> m_definitions = new ArrayList<Definition>();
    //! Map that contains all modules that were found processing the IDL file (after preprocessing):
    private HashMap<String, com.eprosima.idl.parser.tree.Module> m_modules = new HashMap<String, com.eprosima.idl.parser.tree.Module>();
    //! Map that contains all interfaces that were found processing the IDL file (after preprocessing):
    private HashMap<String, Interface> m_interfaces = new HashMap<String, Interface>();
    //! Map that contains all global exceptions that were found processing the IDL file (after preprocessing).
    private HashMap<String, com.eprosima.idl.parser.tree.Exception> m_exceptions = new HashMap<String, com.eprosima.idl.parser.tree.Exception>();
    //! Map that contains all types that were found processing the IDL file (after preprocessing).
    private HashMap<String, TypeDeclaration> m_types = new HashMap<String, TypeDeclaration>();
    //! Map that contains all annotations that where found processing the IDL file.
    private HashMap<String, AnnotationDeclaration> m_annotations = new HashMap<String, AnnotationDeclaration>();

    private ArrayList<String> m_includePaths = null;
    //! Set that contains the library dependencies that were found because there was a line of the preprocessor.
    private LinkedHashSet<String> m_dependencies = null;

    //! Set that contains the direct include dependencies in the IDL file. Used to regenerate the IDL in a supported form.
    private HashSet<String> m_directIncludeDependencies = null;

    // TODO Quitar porque solo es para tipos (previous c) (usado para las excepciones). Mirar alternativa.
    //! Set that contains the include dependencies that force to include our type generated file (right now only with exceptions in (previous c) DDS types).
    private HashSet<String> m_includedependency = null;

    // TODO Lleva la cuenta del nombre de variables para bucles anidados.
    private char m_loopVarName = 'a';

    private Stack<Pair<String, Integer>> m_scopeFilesStack;

    // All grammar keywords
    private HashSet<String> m_keywords = null;

    private boolean m_ignore_case = true;

    private boolean generate_typesc_ = false;

    protected TemplateManager tmanager_ = null;
}
