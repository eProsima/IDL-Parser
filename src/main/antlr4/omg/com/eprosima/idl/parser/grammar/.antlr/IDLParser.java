// Generated from /home/lgasco/git/eProsima/Fast-RTPS/IDL_4.2/thirdparty/idl/src/main/antlr4/omg/com/eprosima/idl/parser/grammar/IDL.g4 by ANTLR 4.7.1

    //package com.eprosima.idl.parser.grammar;

    import com.eprosima.idl.context.Context;
    import com.eprosima.idl.generator.manager.TemplateManager;
    import com.eprosima.idl.generator.manager.TemplateGroup;
    import com.eprosima.idl.generator.manager.TemplateUtil;
    import com.eprosima.idl.parser.typecode.*;
    import com.eprosima.idl.parser.tree.*;
    import com.eprosima.idl.util.Pair;
    import com.eprosima.idl.parser.strategy.DefaultErrorStrategy;
    import com.eprosima.idl.parser.listener.DefaultErrorListener;
    import com.eprosima.idl.parser.exception.ParseException;

    import java.util.Vector;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IDLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, INTEGER_LITERAL=3, OCTAL_LITERAL=4, HEX_LITERAL=5, FLOATING_PT_LITERAL=6, 
		FIXED_PT_LITERAL=7, WIDE_CHARACTER_LITERAL=8, CHARACTER_LITERAL=9, WIDE_STRING_LITERAL=10, 
		STRING_LITERAL=11, BOOLEAN_LITERAL=12, SEMICOLON=13, COLON=14, COMA=15, 
		LEFT_BRACE=16, RIGHT_BRACE=17, LEFT_BRACKET=18, RIGHT_BRACKET=19, LEFT_SQUARE_BRACKET=20, 
		RIGHT_SQUARE_BRACKET=21, TILDE=22, SLASH=23, LEFT_ANG_BRACKET=24, RIGHT_ANG_BRACKET=25, 
		STAR=26, PLUS=27, MINUS=28, CARET=29, AMPERSAND=30, PIPE=31, EQUAL=32, 
		PERCENT=33, AT=34, DOUBLE_COLON=35, RIGHT_SHIFT=36, LEFT_SHIFT=37, KW_SETRAISES=38, 
		KW_OUT=39, KW_EMITS=40, KW_STRING=41, KW_SWITCH=42, KW_PUBLISHES=43, KW_TYPEDEF=44, 
		KW_USES=45, KW_PRIMARYKEY=46, KW_CUSTOM=47, KW_OCTET=48, KW_SEQUENCE=49, 
		KW_IMPORT=50, KW_STRUCT=51, KW_NATIVE=52, KW_READONLY=53, KW_FINDER=54, 
		KW_RAISES=55, KW_VOID=56, KW_PRIVATE=57, KW_EVENTTYPE=58, KW_WCHAR=59, 
		KW_IN=60, KW_DEFAULT=61, KW_PUBLIC=62, KW_SHORT=63, KW_LONG=64, KW_ENUM=65, 
		KW_WSTRING=66, KW_CONTEXT=67, KW_HOME=68, KW_FACTORY=69, KW_EXCEPTION=70, 
		KW_GETRAISES=71, KW_CONST=72, KW_VALUEBASE=73, KW_VALUETYPE=74, KW_SUPPORTS=75, 
		KW_MODULE=76, KW_OBJECT=77, KW_TRUNCATABLE=78, KW_UNSIGNED=79, KW_FIXED=80, 
		KW_UNION=81, KW_ONEWAY=82, KW_ANY=83, KW_CHAR=84, KW_CASE=85, KW_FLOAT=86, 
		KW_BOOLEAN=87, KW_MULTIPLE=88, KW_ABSTRACT=89, KW_INOUT=90, KW_PROVIDES=91, 
		KW_CONSUMES=92, KW_DOUBLE=93, KW_TYPEPREFIX=94, KW_TYPEID=95, KW_ATTRIBUTE=96, 
		KW_LOCAL=97, KW_MANAGES=98, KW_INTERFACE=99, KW_COMPONENT=100, KW_SET=101, 
		KW_MAP=102, KW_BITFIELD=103, KW_BITSET=104, KW_BITMASK=105, KW_INT8=106, 
		KW_UINT8=107, KW_INT16=108, KW_UINT16=109, KW_INT32=110, KW_UINT32=111, 
		KW_INT64=112, KW_UINT64=113, KW_AT_ANNOTATION=114, ID=115, WS=116, PREPROC_DIRECTIVE=117, 
		COMMENT=118, LINE_COMMENT=119;
	public static final int
		RULE_specification = 0, RULE_definition = 1, RULE_aux_definition = 2, 
		RULE_module = 3, RULE_definition_list = 4, RULE_interface_or_forward_decl = 5, 
		RULE_interface_decl = 6, RULE_forward_decl = 7, RULE_interface_body = 8, 
		RULE_export = 9, RULE_aux_export = 10, RULE_interface_inheritance_spec = 11, 
		RULE_interface_name = 12, RULE_scoped_name_list = 13, RULE_scoped_name = 14, 
		RULE_value = 15, RULE_value_forward_decl = 16, RULE_value_box_decl = 17, 
		RULE_value_abs_decl = 18, RULE_value_decl = 19, RULE_value_header = 20, 
		RULE_value_inheritance_spec = 21, RULE_value_name = 22, RULE_value_element = 23, 
		RULE_state_member = 24, RULE_init_decl = 25, RULE_init_param_decls = 26, 
		RULE_init_param_decl = 27, RULE_init_param_attribute = 28, RULE_const_decl = 29, 
		RULE_const_type = 30, RULE_const_exp = 31, RULE_or_expr = 32, RULE_xor_expr = 33, 
		RULE_and_expr = 34, RULE_shift_expr = 35, RULE_add_expr = 36, RULE_mult_expr = 37, 
		RULE_unary_expr = 38, RULE_primary_expr = 39, RULE_literal = 40, RULE_boolean_literal = 41, 
		RULE_positive_int_const = 42, RULE_type_decl = 43, RULE_type_declarator = 44, 
		RULE_type_spec = 45, RULE_simple_type_spec = 46, RULE_bitfield_type_spec = 47, 
		RULE_base_type_spec = 48, RULE_template_type_spec = 49, RULE_constr_type_spec = 50, 
		RULE_declarators = 51, RULE_simple_declarators = 52, RULE_declarator = 53, 
		RULE_simple_declarator = 54, RULE_complex_declarator = 55, RULE_floating_pt_type = 56, 
		RULE_integer_type = 57, RULE_signed_int = 58, RULE_signed_tiny_int = 59, 
		RULE_signed_short_int = 60, RULE_signed_long_int = 61, RULE_signed_longlong_int = 62, 
		RULE_unsigned_int = 63, RULE_unsigned_tiny_int = 64, RULE_unsigned_short_int = 65, 
		RULE_unsigned_long_int = 66, RULE_unsigned_longlong_int = 67, RULE_char_type = 68, 
		RULE_wide_char_type = 69, RULE_boolean_type = 70, RULE_octet_type = 71, 
		RULE_any_type = 72, RULE_object_type = 73, RULE_annotation_decl = 74, 
		RULE_annotation_def = 75, RULE_annotation_header = 76, RULE_annotation_inheritance_spec = 77, 
		RULE_annotation_body = 78, RULE_annotation_member = 79, RULE_annotation_forward_dcl = 80, 
		RULE_bitset_type = 81, RULE_bitfield = 82, RULE_bitfield_spec = 83, RULE_bitmask_type = 84, 
		RULE_bit_values = 85, RULE_struct_type = 86, RULE_member_list = 87, RULE_member_def = 88, 
		RULE_member = 89, RULE_union_type = 90, RULE_switch_type_spec = 91, RULE_switch_body = 92, 
		RULE_case_stmt_list = 93, RULE_case_stmt = 94, RULE_element_spec = 95, 
		RULE_enum_type = 96, RULE_enumerator_list = 97, RULE_enumerator = 98, 
		RULE_sequence_type = 99, RULE_set_type = 100, RULE_map_type = 101, RULE_string_type = 102, 
		RULE_wide_string_type = 103, RULE_array_declarator = 104, RULE_fixed_array_size = 105, 
		RULE_attr_decl = 106, RULE_except_decl = 107, RULE_opt_member_list = 108, 
		RULE_op_decl = 109, RULE_op_attribute = 110, RULE_op_type_spec = 111, 
		RULE_parameter_decls = 112, RULE_param_decl_list = 113, RULE_param_decl = 114, 
		RULE_raises_expr = 115, RULE_context_expr = 116, RULE_param_type_spec = 117, 
		RULE_fixed_pt_type = 118, RULE_fixed_pt_const_type = 119, RULE_value_base_type = 120, 
		RULE_constr_forward_decl = 121, RULE_import_decl = 122, RULE_imported_scope = 123, 
		RULE_type_id_decl = 124, RULE_type_prefix_decl = 125, RULE_readonly_attr_spec = 126, 
		RULE_readonly_attr_declarator = 127, RULE_attr_spec = 128, RULE_attr_declarator = 129, 
		RULE_attr_raises_expr = 130, RULE_get_excep_expr = 131, RULE_set_excep_expr = 132, 
		RULE_exception_list = 133, RULE_component = 134, RULE_component_forward_decl = 135, 
		RULE_component_decl = 136, RULE_component_header = 137, RULE_supported_interface_spec = 138, 
		RULE_component_inheritance_spec = 139, RULE_component_body = 140, RULE_component_export = 141, 
		RULE_provides_decl = 142, RULE_interface_type = 143, RULE_uses_decl = 144, 
		RULE_emits_decl = 145, RULE_publishes_decl = 146, RULE_consumes_decl = 147, 
		RULE_home_decl = 148, RULE_home_header = 149, RULE_home_inheritance_spec = 150, 
		RULE_primary_key_spec = 151, RULE_home_body = 152, RULE_home_export = 153, 
		RULE_factory_decl = 154, RULE_finder_decl = 155, RULE_event = 156, RULE_event_forward_decl = 157, 
		RULE_event_abs_decl = 158, RULE_event_decl = 159, RULE_event_header = 160, 
		RULE_annotation_appl = 161, RULE_annotation_appl_params = 162, RULE_annotation_appl_param = 163, 
		RULE_identifier = 164;
	public static final String[] ruleNames = {
		"specification", "definition", "aux_definition", "module", "definition_list", 
		"interface_or_forward_decl", "interface_decl", "forward_decl", "interface_body", 
		"export", "aux_export", "interface_inheritance_spec", "interface_name", 
		"scoped_name_list", "scoped_name", "value", "value_forward_decl", "value_box_decl", 
		"value_abs_decl", "value_decl", "value_header", "value_inheritance_spec", 
		"value_name", "value_element", "state_member", "init_decl", "init_param_decls", 
		"init_param_decl", "init_param_attribute", "const_decl", "const_type", 
		"const_exp", "or_expr", "xor_expr", "and_expr", "shift_expr", "add_expr", 
		"mult_expr", "unary_expr", "primary_expr", "literal", "boolean_literal", 
		"positive_int_const", "type_decl", "type_declarator", "type_spec", "simple_type_spec", 
		"bitfield_type_spec", "base_type_spec", "template_type_spec", "constr_type_spec", 
		"declarators", "simple_declarators", "declarator", "simple_declarator", 
		"complex_declarator", "floating_pt_type", "integer_type", "signed_int", 
		"signed_tiny_int", "signed_short_int", "signed_long_int", "signed_longlong_int", 
		"unsigned_int", "unsigned_tiny_int", "unsigned_short_int", "unsigned_long_int", 
		"unsigned_longlong_int", "char_type", "wide_char_type", "boolean_type", 
		"octet_type", "any_type", "object_type", "annotation_decl", "annotation_def", 
		"annotation_header", "annotation_inheritance_spec", "annotation_body", 
		"annotation_member", "annotation_forward_dcl", "bitset_type", "bitfield", 
		"bitfield_spec", "bitmask_type", "bit_values", "struct_type", "member_list", 
		"member_def", "member", "union_type", "switch_type_spec", "switch_body", 
		"case_stmt_list", "case_stmt", "element_spec", "enum_type", "enumerator_list", 
		"enumerator", "sequence_type", "set_type", "map_type", "string_type", 
		"wide_string_type", "array_declarator", "fixed_array_size", "attr_decl", 
		"except_decl", "opt_member_list", "op_decl", "op_attribute", "op_type_spec", 
		"parameter_decls", "param_decl_list", "param_decl", "raises_expr", "context_expr", 
		"param_type_spec", "fixed_pt_type", "fixed_pt_const_type", "value_base_type", 
		"constr_forward_decl", "import_decl", "imported_scope", "type_id_decl", 
		"type_prefix_decl", "readonly_attr_spec", "readonly_attr_declarator", 
		"attr_spec", "attr_declarator", "attr_raises_expr", "get_excep_expr", 
		"set_excep_expr", "exception_list", "component", "component_forward_decl", 
		"component_decl", "component_header", "supported_interface_spec", "component_inheritance_spec", 
		"component_body", "component_export", "provides_decl", "interface_type", 
		"uses_decl", "emits_decl", "publishes_decl", "consumes_decl", "home_decl", 
		"home_header", "home_inheritance_spec", "primary_key_spec", "home_body", 
		"home_export", "factory_decl", "finder_decl", "event", "event_forward_decl", 
		"event_abs_decl", "event_decl", "event_header", "annotation_appl", "annotation_appl_params", 
		"annotation_appl_param", "identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'TRUE'", "'FALSE'", null, null, null, null, null, null, null, null, 
		null, null, "';'", "':'", "','", "'{'", "'}'", "'('", "')'", "'['", "']'", 
		"'~'", "'/'", "'<'", "'>'", "'*'", "'+'", "'-'", "'^'", "'&'", "'|'", 
		"'='", "'%'", "'@'", "'::'", "'>>'", "'<<'", "'setraises'", "'out'", "'emits'", 
		"'string'", "'switch'", "'publishes'", "'typedef'", "'uses'", "'primarykey'", 
		"'custom'", "'octet'", "'sequence'", "'import'", "'struct'", "'native'", 
		"'readonly'", "'finder'", "'raises'", "'void'", "'private'", "'eventtype'", 
		"'wchar'", "'in'", "'default'", "'public'", "'short'", "'long'", "'enum'", 
		"'wstring'", "'context'", "'home'", "'factory'", "'exception'", "'getraises'", 
		"'const'", "'ValueBase'", "'valuetype'", "'supports'", "'module'", "'Object'", 
		"'truncatable'", "'unsigned'", "'fixed'", "'union'", "'oneway'", "'any'", 
		"'char'", "'case'", "'float'", "'boolean'", "'multiple'", "'abstract'", 
		"'inout'", "'provides'", "'consumes'", "'double'", "'typeprefix'", "'typeid'", 
		"'attribute'", "'local'", "'manages'", "'interface'", "'component'", "'set'", 
		"'map'", "'bitfield'", "'bitset'", "'bitmask'", "'int8'", "'uint8'", "'int16'", 
		"'uint16'", "'int32'", "'uint32'", "'int64'", "'uint64'", "'@annotation'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "INTEGER_LITERAL", "OCTAL_LITERAL", "HEX_LITERAL", "FLOATING_PT_LITERAL", 
		"FIXED_PT_LITERAL", "WIDE_CHARACTER_LITERAL", "CHARACTER_LITERAL", "WIDE_STRING_LITERAL", 
		"STRING_LITERAL", "BOOLEAN_LITERAL", "SEMICOLON", "COLON", "COMA", "LEFT_BRACE", 
		"RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_SQUARE_BRACKET", 
		"RIGHT_SQUARE_BRACKET", "TILDE", "SLASH", "LEFT_ANG_BRACKET", "RIGHT_ANG_BRACKET", 
		"STAR", "PLUS", "MINUS", "CARET", "AMPERSAND", "PIPE", "EQUAL", "PERCENT", 
		"AT", "DOUBLE_COLON", "RIGHT_SHIFT", "LEFT_SHIFT", "KW_SETRAISES", "KW_OUT", 
		"KW_EMITS", "KW_STRING", "KW_SWITCH", "KW_PUBLISHES", "KW_TYPEDEF", "KW_USES", 
		"KW_PRIMARYKEY", "KW_CUSTOM", "KW_OCTET", "KW_SEQUENCE", "KW_IMPORT", 
		"KW_STRUCT", "KW_NATIVE", "KW_READONLY", "KW_FINDER", "KW_RAISES", "KW_VOID", 
		"KW_PRIVATE", "KW_EVENTTYPE", "KW_WCHAR", "KW_IN", "KW_DEFAULT", "KW_PUBLIC", 
		"KW_SHORT", "KW_LONG", "KW_ENUM", "KW_WSTRING", "KW_CONTEXT", "KW_HOME", 
		"KW_FACTORY", "KW_EXCEPTION", "KW_GETRAISES", "KW_CONST", "KW_VALUEBASE", 
		"KW_VALUETYPE", "KW_SUPPORTS", "KW_MODULE", "KW_OBJECT", "KW_TRUNCATABLE", 
		"KW_UNSIGNED", "KW_FIXED", "KW_UNION", "KW_ONEWAY", "KW_ANY", "KW_CHAR", 
		"KW_CASE", "KW_FLOAT", "KW_BOOLEAN", "KW_MULTIPLE", "KW_ABSTRACT", "KW_INOUT", 
		"KW_PROVIDES", "KW_CONSUMES", "KW_DOUBLE", "KW_TYPEPREFIX", "KW_TYPEID", 
		"KW_ATTRIBUTE", "KW_LOCAL", "KW_MANAGES", "KW_INTERFACE", "KW_COMPONENT", 
		"KW_SET", "KW_MAP", "KW_BITFIELD", "KW_BITSET", "KW_BITMASK", "KW_INT8", 
		"KW_UINT8", "KW_INT16", "KW_UINT16", "KW_INT32", "KW_UINT32", "KW_INT64", 
		"KW_UINT64", "KW_AT_ANNOTATION", "ID", "WS", "PREPROC_DIRECTIVE", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private TemplateManager tmanager = null;
	    private Context ctx = null;

	    public Context getContext_()
	    {
	        return ctx;
	    }

	public IDLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SpecificationContext extends ParserRuleContext {
		public Context context;
		public TemplateManager templatemanager;
		public TemplateGroup maintemplates;
		public Specification spec = null;
		public DefinitionContext definition;
		public List<Import_declContext> import_decl() {
			return getRuleContexts(Import_declContext.class);
		}
		public Import_declContext import_decl(int i) {
			return getRuleContext(Import_declContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public SpecificationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SpecificationContext(ParserRuleContext parent, int invokingState, Context context, TemplateManager templatemanager, TemplateGroup maintemplates) {
			super(parent, invokingState);
			this.context = context;
			this.templatemanager = templatemanager;
			this.maintemplates = maintemplates;
		}
		@Override public int getRuleIndex() { return RULE_specification; }
	}

	public final SpecificationContext specification(Context context,TemplateManager templatemanager,TemplateGroup maintemplates) throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState(), context, templatemanager, maintemplates);
		enterRule(_localctx, 0, RULE_specification);

		    //! Used to catch each definition grammar element in the whole IDL file.
		    Pair<Vector<Definition>, TemplateGroup> dtg = null;
		    List<Definition> specificationChildren = new ArrayList<Definition>();
		    ctx = context;
		    tmanager = templatemanager;

		    // Set error handler
		    DefaultErrorListener listener = new DefaultErrorListener(ctx);
		    this.setErrorHandler(DefaultErrorStrategy.INSTANCE);
		    // Select listener for errors.
		    ((Lexer)this._input.getTokenSource()).removeErrorListeners();
		    ((Lexer)this._input.getTokenSource()).addErrorListener(listener);
		    this.removeErrorListeners();
		    this.addErrorListener(listener);

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_IMPORT) {
				{
				{
				setState(330);
				import_decl();
				}
				}
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(339); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(336);
				((SpecificationContext)_localctx).definition = definition(null, null);

				            dtg=((SpecificationContext)_localctx).definition.dtg;
				            if (dtg!=null) {
				                if(maintemplates != null) {
				                    maintemplates.setAttribute("definitions", dtg.second());
				                }
				                for(int count = 0; count < dtg.first().size(); ++count)
				                {
				                    ctx.addDefinition(dtg.first().get(count));
				                    specificationChildren.add(dtg.first().get(count));
				                }
				            }
				        
				}
				}
				setState(341); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << KW_TYPEDEF) | (1L << KW_CUSTOM) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_EVENTTYPE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (KW_ENUM - 65)) | (1L << (KW_HOME - 65)) | (1L << (KW_EXCEPTION - 65)) | (1L << (KW_CONST - 65)) | (1L << (KW_VALUETYPE - 65)) | (1L << (KW_MODULE - 65)) | (1L << (KW_UNION - 65)) | (1L << (KW_ABSTRACT - 65)) | (1L << (KW_TYPEPREFIX - 65)) | (1L << (KW_TYPEID - 65)) | (1L << (KW_LOCAL - 65)) | (1L << (KW_INTERFACE - 65)) | (1L << (KW_COMPONENT - 65)) | (1L << (KW_BITSET - 65)) | (1L << (KW_BITMASK - 65)) | (1L << (KW_AT_ANNOTATION - 65)))) != 0) );

			        if(getNumberOfSyntaxErrors() == 0)
			        {
			            ((SpecificationContext)_localctx).spec =  new Specification();
			            _localctx.spec.setDefinitions(specificationChildren);
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public ArrayList<Definition> defs;
		public Pair<Vector<Definition>, TemplateGroup> dtg = null;
		public Type_declContext type_decl;
		public Const_declContext const_decl;
		public Except_declContext except_decl;
		public Interface_or_forward_declContext interface_or_forward_decl;
		public ModuleContext module;
		public Annotation_declContext annotation_decl;
		public Annotation_applContext annotation_appl;
		public Aux_definitionContext aux_definition;
		public Type_declContext type_decl() {
			return getRuleContext(Type_declContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Const_declContext const_decl() {
			return getRuleContext(Const_declContext.class,0);
		}
		public Except_declContext except_decl() {
			return getRuleContext(Except_declContext.class,0);
		}
		public Interface_or_forward_declContext interface_or_forward_decl() {
			return getRuleContext(Interface_or_forward_declContext.class,0);
		}
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Type_id_declContext type_id_decl() {
			return getRuleContext(Type_id_declContext.class,0);
		}
		public Type_prefix_declContext type_prefix_decl() {
			return getRuleContext(Type_prefix_declContext.class,0);
		}
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
		}
		public Home_declContext home_decl() {
			return getRuleContext(Home_declContext.class,0);
		}
		public Annotation_declContext annotation_decl() {
			return getRuleContext(Annotation_declContext.class,0);
		}
		public Annotation_applContext annotation_appl() {
			return getRuleContext(Annotation_applContext.class,0);
		}
		public Aux_definitionContext aux_definition() {
			return getRuleContext(Aux_definitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public DefinitionContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations, ArrayList<Definition> defs) {
			super(parent, invokingState);
			this.annotations = annotations;
			this.defs = defs;
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition(Vector<Annotation> annotations,ArrayList<Definition> defs) throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState(), annotations, defs);
		enterRule(_localctx, 2, RULE_definition);

		    // TODO Cambiar esto. No me gusta la forma.

		    Vector<Definition> vector = new Vector<Definition>();
		    Pair<Vector<TypeDeclaration>, TemplateGroup> tdtg = null;
		    Pair<ConstDeclaration, TemplateGroup> cdtg = null;
		    Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup> etg = null;
		    Pair<Interface, TemplateGroup> itg = null;
		    Pair<com.eprosima.idl.parser.tree.Module, TemplateGroup> mtg = null;
		    Pair<AnnotationDeclaration, TemplateGroup> atg = null;

		    if(annotations == null) annotations = new Vector<Annotation>();

		try {
			setState(392);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				((DefinitionContext)_localctx).type_decl = type_decl(annotations, defs);
				setState(346);
				match(SEMICOLON);
				 tdtg=((DefinitionContext)_localctx).type_decl.returnPair; if(tdtg!=null){ for(TypeDeclaration tydl : tdtg.first()) vector.add(tydl); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, tdtg.second());}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				((DefinitionContext)_localctx).const_decl = const_decl();
				setState(350);
				match(SEMICOLON);
				 cdtg=((DefinitionContext)_localctx).const_decl.returnPair; if(cdtg!=null){ vector.add(cdtg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, cdtg.second());}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
				((DefinitionContext)_localctx).except_decl = except_decl();
				setState(354);
				match(SEMICOLON);
				 etg=((DefinitionContext)_localctx).except_decl.returnPair; if(etg!=null){ vector.add(etg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, etg.second());}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(357);
				((DefinitionContext)_localctx).interface_or_forward_decl = interface_or_forward_decl(annotations);
				setState(358);
				match(SEMICOLON);
				 itg=((DefinitionContext)_localctx).interface_or_forward_decl.itg; if(itg!=null){ vector.add(itg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, itg.second());}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(361);
				((DefinitionContext)_localctx).module = module();
				setState(362);
				match(SEMICOLON);
				 mtg=((DefinitionContext)_localctx).module.returnPair; if(mtg!=null){ vector.add(mtg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, mtg.second());}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(365);
				value();
				setState(366);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(368);
				type_id_decl();
				setState(369);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(371);
				type_prefix_decl();
				setState(372);
				match(SEMICOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(374);
				event();
				setState(375);
				match(SEMICOLON);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(377);
				component();
				setState(378);
				match(SEMICOLON);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(380);
				home_decl();
				setState(381);
				match(SEMICOLON);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(383);
				((DefinitionContext)_localctx).annotation_decl = annotation_decl();
				setState(384);
				match(SEMICOLON);
				 atg=((DefinitionContext)_localctx).annotation_decl.returnPair; if(atg!=null){ vector.add(atg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, atg.second());}
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(387);
				((DefinitionContext)_localctx).annotation_appl = annotation_appl();

				            annotations.add(((DefinitionContext)_localctx).annotation_appl.annotation);
				        
				setState(389);
				((DefinitionContext)_localctx).aux_definition = aux_definition(annotations, defs);
				((DefinitionContext)_localctx).dtg = ((DefinitionContext)_localctx).aux_definition.dtg;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aux_definitionContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public ArrayList<Definition> defs;
		public Pair<Vector<Definition>, TemplateGroup> dtg = null;
		public DefinitionContext definition;
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public Aux_definitionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Aux_definitionContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations, ArrayList<Definition> defs) {
			super(parent, invokingState);
			this.annotations = annotations;
			this.defs = defs;
		}
		@Override public int getRuleIndex() { return RULE_aux_definition; }
	}

	public final Aux_definitionContext aux_definition(Vector<Annotation> annotations,ArrayList<Definition> defs) throws RecognitionException {
		Aux_definitionContext _localctx = new Aux_definitionContext(_ctx, getState(), annotations, defs);
		enterRule(_localctx, 4, RULE_aux_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			((Aux_definitionContext)_localctx).definition = definition(annotations, defs);
			((Aux_definitionContext)_localctx).dtg = ((Aux_definitionContext)_localctx).definition.dtg;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleContext extends ParserRuleContext {
		public Pair<com.eprosima.idl.parser.tree.Module, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public Definition_listContext definition_list;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Definition_listContext definition_list() {
			return getRuleContext(Definition_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public TerminalNode KW_MODULE() { return getToken(IDLParser.KW_MODULE, 0); }
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_module);

		    com.eprosima.idl.parser.tree.Module moduleObject = null;
		    TemplateGroup moduleTemplates = null;
		    TemplateGroup tg = null;
		    // Store old namespace.
		    String name = null, old_scope = ctx.getScope();
		    Token tk = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(397);
			match(KW_MODULE);
			}

			        tk = _input.LT(1);
			    
			setState(399);
			((ModuleContext)_localctx).identifier = identifier();

			        name=((ModuleContext)_localctx).identifier.id;
			        // Check if the module already was defined.
			        moduleObject = ctx.existsModule(ctx.getScope() + "::" + name);

			        if(moduleObject != null)
			        {
			            // Add the module to the context.
			            ctx.addModule(moduleObject);
			        }
			        else
			        {
			            // Create the Module object.
			            moduleObject = new com.eprosima.idl.parser.tree.Module(ctx.getScopeFile(), ctx.isInScopedFile(), ctx.getScope(), name, tk);
			        }

			        if(ctx.isInScopedFile() || ctx.isScopeLimitToAll()) {
			            if(tmanager != null) {
			                moduleTemplates = tmanager.createTemplateGroup("module");
			                moduleTemplates.setAttribute("ctx", ctx);
			                // Set the module object to the TemplateGroup of the module.
			                moduleTemplates.setAttribute("module", moduleObject);
			            }
			        }

			        // Update to a new namespace.
			        if(old_scope.isEmpty())
			            ctx.setScope(name);
			        else
			            ctx.setScope(old_scope + "::" + name);
			    
			setState(401);
			match(LEFT_BRACE);
			setState(402);
			((ModuleContext)_localctx).definition_list = definition_list(moduleObject);
			 tg=((ModuleContext)_localctx).definition_list.dlTemplates; if(moduleTemplates!=null && tg!=null)moduleTemplates.setAttribute("definition_list", tg);
			setState(404);
			match(RIGHT_BRACE);

			        // Set the old namespace.
			        ctx.setScope(old_scope);
			        // Create the returned data.
			        ((ModuleContext)_localctx).returnPair =  new Pair<com.eprosima.idl.parser.tree.Module, TemplateGroup>(moduleObject, moduleTemplates);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Definition_listContext extends ParserRuleContext {
		public DefinitionContainer dc;
		public TemplateGroup dlTemplates;
		public DefinitionContext definition;
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public Definition_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Definition_listContext(ParserRuleContext parent, int invokingState, DefinitionContainer dc) {
			super(parent, invokingState);
			this.dc = dc;
		}
		@Override public int getRuleIndex() { return RULE_definition_list; }
	}

	public final Definition_listContext definition_list(DefinitionContainer dc) throws RecognitionException {
		Definition_listContext _localctx = new Definition_listContext(_ctx, getState(), dc);
		enterRule(_localctx, 8, RULE_definition_list);

		    Pair<Vector<Definition>, TemplateGroup> dtg = null;
		    if(tmanager != null) {
		        ((Definition_listContext)_localctx).dlTemplates =  tmanager.createTemplateGroup("definition_list");
		    }

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(407);
				((Definition_listContext)_localctx).definition = definition(null, dc.getDefinitions());

				            dtg=((Definition_listContext)_localctx).definition.dtg;
				            if(dtg!=null)
				            {
				                for(int count = 0; count < dtg.first().size(); ++count)
				                    dc.add(dtg.first().get(count));

				                if(_localctx.dlTemplates != null && dtg.second() != null)
				                {
				                    // Set parent
				                    dtg.second().setAttribute("parent", dc);
				                    // Print template into definitions rule
				                    _localctx.dlTemplates.setAttribute("definitions", dtg.second());
				                }
				            }
				        
				}
				}
				setState(412); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << KW_TYPEDEF) | (1L << KW_CUSTOM) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_EVENTTYPE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (KW_ENUM - 65)) | (1L << (KW_HOME - 65)) | (1L << (KW_EXCEPTION - 65)) | (1L << (KW_CONST - 65)) | (1L << (KW_VALUETYPE - 65)) | (1L << (KW_MODULE - 65)) | (1L << (KW_UNION - 65)) | (1L << (KW_ABSTRACT - 65)) | (1L << (KW_TYPEPREFIX - 65)) | (1L << (KW_TYPEID - 65)) | (1L << (KW_LOCAL - 65)) | (1L << (KW_INTERFACE - 65)) | (1L << (KW_COMPONENT - 65)) | (1L << (KW_BITSET - 65)) | (1L << (KW_BITMASK - 65)) | (1L << (KW_AT_ANNOTATION - 65)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Interface_or_forward_declContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Interface, TemplateGroup> itg = null;
		public Interface_declContext interface_decl;
		public Interface_declContext interface_decl() {
			return getRuleContext(Interface_declContext.class,0);
		}
		public Forward_declContext forward_decl() {
			return getRuleContext(Forward_declContext.class,0);
		}
		public Interface_or_forward_declContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Interface_or_forward_declContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_interface_or_forward_decl; }
	}

	public final Interface_or_forward_declContext interface_or_forward_decl(Vector<Annotation> annotations) throws RecognitionException {
		Interface_or_forward_declContext _localctx = new Interface_or_forward_declContext(_ctx, getState(), annotations);
		enterRule(_localctx, 10, RULE_interface_or_forward_decl);
		try {
			setState(418);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(414);
				((Interface_or_forward_declContext)_localctx).interface_decl = interface_decl(annotations);
				((Interface_or_forward_declContext)_localctx).itg =  ((Interface_or_forward_declContext)_localctx).interface_decl.returnPair;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(417);
				forward_decl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Interface_declContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Interface, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public Interface_bodyContext interface_body;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Interface_bodyContext interface_body() {
			return getRuleContext(Interface_bodyContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public TerminalNode KW_INTERFACE() { return getToken(IDLParser.KW_INTERFACE, 0); }
		public Interface_inheritance_specContext interface_inheritance_spec() {
			return getRuleContext(Interface_inheritance_specContext.class,0);
		}
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public TerminalNode KW_LOCAL() { return getToken(IDLParser.KW_LOCAL, 0); }
		public Interface_declContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Interface_declContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_interface_decl; }
	}

	public final Interface_declContext interface_decl(Vector<Annotation> annotations) throws RecognitionException {
		Interface_declContext _localctx = new Interface_declContext(_ctx, getState(), annotations);
		enterRule(_localctx, 12, RULE_interface_decl);

		    Token tk = null;
		    Interface interfaceObject = null;
		    TemplateGroup interfaceTemplates = null;
		    TemplateGroup tg = null;
		    String name = null, old_scope = ctx.getScope();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ABSTRACT || _la==KW_LOCAL) {
				{
				setState(420);
				_la = _input.LA(1);
				if ( !(_la==KW_ABSTRACT || _la==KW_LOCAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			{
			setState(423);
			match(KW_INTERFACE);
			}

			            tk = _input.LT(1);
			        
			setState(425);
			((Interface_declContext)_localctx).identifier = identifier();

			            name=((Interface_declContext)_localctx).identifier.id;
			            // Retrieve from forward or Create the Interface object.
			            interfaceObject = ctx.getInterface(name);
			            if (interfaceObject == null)
			            {
			                interfaceObject = ctx.createInterface(name, tk);
			            }

			            // Add annotations.
			            for(Annotation annotation : annotations)
			            {
			               interfaceObject.addAnnotation(ctx, annotation);
			            }

			            if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			            {
			                if(tmanager != null) {
			                    interfaceTemplates = tmanager.createTemplateGroup("interface");
			                    interfaceTemplates.setAttribute("ctx", ctx);
			                    // Set the the interface object to the TemplateGroup of the module.
			                    interfaceTemplates.setAttribute("interface", interfaceObject);
			                }
			            }

			            // Update to a new namespace.
			            if(old_scope.isEmpty())
			                ctx.setScope(name);
			            else
			                ctx.setScope(old_scope + "::" + name);
			        
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(427);
				interface_inheritance_spec(interfaceObject);
				}
			}

			setState(430);
			match(LEFT_BRACE);
			setState(431);
			((Interface_declContext)_localctx).interface_body = interface_body(interfaceObject);
			 tg=((Interface_declContext)_localctx).interface_body.elTemplates; if(interfaceTemplates!=null && tg!=null)interfaceTemplates.setAttribute("export_list", tg);
			setState(433);
			match(RIGHT_BRACE);
			}

			           // Set the old namespace.
			           ctx.setScope(old_scope);
			           // Create the returned data.
			           ((Interface_declContext)_localctx).returnPair =  new Pair<Interface, TemplateGroup>(interfaceObject, interfaceTemplates);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Forward_declContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode KW_INTERFACE() { return getToken(IDLParser.KW_INTERFACE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public TerminalNode KW_LOCAL() { return getToken(IDLParser.KW_LOCAL, 0); }
		public Forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forward_decl; }
	}

	public final Forward_declContext forward_decl() throws RecognitionException {
		Forward_declContext _localctx = new Forward_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forward_decl);

		    Token tk = null;
		    TemplateGroup interfaceTemplates = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ABSTRACT || _la==KW_LOCAL) {
				{
				setState(437);
				_la = _input.LA(1);
				if ( !(_la==KW_ABSTRACT || _la==KW_LOCAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			{
			setState(440);
			match(KW_INTERFACE);
			}

			            tk = _input.LT(1);
			        
			setState(442);
			((Forward_declContext)_localctx).identifier = identifier();

			            // Create the Interface object.
			            Interface interfaceObject = ctx.createInterface(((Forward_declContext)_localctx).identifier.id, tk);

			            if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			            {
			                if(tmanager != null)
			                {
			                    interfaceTemplates = tmanager.createTemplateGroup("interface");
			                    interfaceTemplates.setAttribute("ctx", ctx);
			                    // Set the the interface object to the TemplateGroup of the module.
			                    interfaceTemplates.setAttribute("interface", interfaceObject);
			                }
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Interface_bodyContext extends ParserRuleContext {
		public ExportContainer ec;
		public TemplateGroup elTemplates;
		public ExportContext export;
		public List<ExportContext> export() {
			return getRuleContexts(ExportContext.class);
		}
		public ExportContext export(int i) {
			return getRuleContext(ExportContext.class,i);
		}
		public Interface_bodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Interface_bodyContext(ParserRuleContext parent, int invokingState, ExportContainer ec) {
			super(parent, invokingState);
			this.ec = ec;
		}
		@Override public int getRuleIndex() { return RULE_interface_body; }
	}

	public final Interface_bodyContext interface_body(ExportContainer ec) throws RecognitionException {
		Interface_bodyContext _localctx = new Interface_bodyContext(_ctx, getState(), ec);
		enterRule(_localctx, 16, RULE_interface_body);

		        Pair<Vector<Export>, TemplateGroup> etg = null;
		        if(tmanager != null) {
		            ((Interface_bodyContext)_localctx).elTemplates =  tmanager.createTemplateGroup("export_list");
		        }

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (KW_BITSET - 64)) | (1L << (KW_BITMASK - 64)) | (1L << (KW_INT8 - 64)) | (1L << (KW_UINT8 - 64)) | (1L << (KW_INT16 - 64)) | (1L << (KW_UINT16 - 64)) | (1L << (KW_INT32 - 64)) | (1L << (KW_UINT32 - 64)) | (1L << (KW_INT64 - 64)) | (1L << (KW_UINT64 - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(445);
				((Interface_bodyContext)_localctx).export = export(null);

				            etg=((Interface_bodyContext)_localctx).export.etg;
				            if(etg!=null)
				            {
				                for(int count = 0; count < etg.first().size(); ++count)
				                {
				                    ec.add(etg.first().get(count));
				                    etg.first().get(count).resolve(ctx);
				                }

				                if(_localctx.elTemplates != null && etg.second() != null)
				                {
				                    // Add parent
				                    etg.second().setAttribute("parent", ec);
				                    // Print template into exports rule
				                    _localctx.elTemplates.setAttribute("exports", etg.second());
				                }
				            }
				        
				}
				}
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExportContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Vector<Export>, TemplateGroup> etg = null;
		public Type_declContext type_decl;
		public Const_declContext const_decl;
		public Except_declContext except_decl;
		public Op_declContext op_decl;
		public Annotation_applContext annotation_appl;
		public Aux_exportContext aux_export;
		public Type_declContext type_decl() {
			return getRuleContext(Type_declContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Const_declContext const_decl() {
			return getRuleContext(Const_declContext.class,0);
		}
		public Except_declContext except_decl() {
			return getRuleContext(Except_declContext.class,0);
		}
		public Attr_declContext attr_decl() {
			return getRuleContext(Attr_declContext.class,0);
		}
		public Op_declContext op_decl() {
			return getRuleContext(Op_declContext.class,0);
		}
		public Type_id_declContext type_id_decl() {
			return getRuleContext(Type_id_declContext.class,0);
		}
		public Type_prefix_declContext type_prefix_decl() {
			return getRuleContext(Type_prefix_declContext.class,0);
		}
		public Annotation_applContext annotation_appl() {
			return getRuleContext(Annotation_applContext.class,0);
		}
		public Aux_exportContext aux_export() {
			return getRuleContext(Aux_exportContext.class,0);
		}
		public ExportContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExportContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_export; }
	}

	public final ExportContext export(Vector<Annotation> annotations) throws RecognitionException {
		ExportContext _localctx = new ExportContext(_ctx, getState(), annotations);
		enterRule(_localctx, 18, RULE_export);

		        // TODO Cambiar esto. No me gusta la forma.
		        Vector<Export> vector = new Vector<Export>();
		        Pair<Vector<TypeDeclaration>, TemplateGroup> tetg = null;
		        Pair<ConstDeclaration, TemplateGroup> cetg = null;
		        Pair<Operation, TemplateGroup> oetg = null;
		        Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup> eetg = null;

		        if(annotations == null) annotations = new Vector<Annotation>();

		try {
			setState(484);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_TYPEDEF:
			case KW_STRUCT:
			case KW_NATIVE:
			case KW_ENUM:
			case KW_UNION:
			case KW_BITSET:
			case KW_BITMASK:
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				((ExportContext)_localctx).type_decl = type_decl(annotations, null);
				setState(454);
				match(SEMICOLON);
				 tetg=((ExportContext)_localctx).type_decl.returnPair; if(tetg!=null){ for(TypeDeclaration tydl : tetg.first()) vector.add(tydl); ((ExportContext)_localctx).etg =  new Pair<Vector<Export>, TemplateGroup>(vector, tetg.second());} 
				}
				break;
			case KW_CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(457);
				((ExportContext)_localctx).const_decl = const_decl();
				setState(458);
				match(SEMICOLON);
				 cetg=((ExportContext)_localctx).const_decl.returnPair; if(cetg!=null){ vector.add(cetg.first()); ((ExportContext)_localctx).etg =  new Pair<Vector<Export>, TemplateGroup>(vector, cetg.second());}
				}
				break;
			case KW_EXCEPTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(461);
				((ExportContext)_localctx).except_decl = except_decl();
				setState(462);
				match(SEMICOLON);
				 eetg=((ExportContext)_localctx).except_decl.returnPair; if(eetg!=null){ vector.add(eetg.first()); ((ExportContext)_localctx).etg =  new Pair<Vector<Export>, TemplateGroup>(vector, eetg.second());}
				}
				break;
			case KW_READONLY:
			case KW_ATTRIBUTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(465);
				attr_decl();
				setState(466);
				match(SEMICOLON);
				 System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Attribute declarations are not supported. Ignoring..."); 
				}
				break;
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_OCTET:
			case KW_VOID:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_WSTRING:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_ONEWAY:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(469);
				((ExportContext)_localctx).op_decl = op_decl(annotations);
				setState(470);
				match(SEMICOLON);
				 oetg=((ExportContext)_localctx).op_decl.returnPair; if(oetg!=null){ vector.add(oetg.first()); ((ExportContext)_localctx).etg =  new Pair<Vector<Export>, TemplateGroup>(vector, oetg.second());}
				}
				break;
			case KW_TYPEID:
				enterOuterAlt(_localctx, 6);
				{
				setState(473);
				type_id_decl();
				setState(474);
				match(SEMICOLON);
				}
				break;
			case KW_TYPEPREFIX:
				enterOuterAlt(_localctx, 7);
				{
				setState(476);
				type_prefix_decl();
				setState(477);
				match(SEMICOLON);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 8);
				{
				setState(479);
				((ExportContext)_localctx).annotation_appl = annotation_appl();

				            annotations.add(((ExportContext)_localctx).annotation_appl.annotation);
				        
				setState(481);
				((ExportContext)_localctx).aux_export = aux_export(annotations);
				((ExportContext)_localctx).etg = ((ExportContext)_localctx).aux_export.etg;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aux_exportContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Vector<Export>, TemplateGroup> etg = null;
		public ExportContext export;
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public Aux_exportContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Aux_exportContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_aux_export; }
	}

	public final Aux_exportContext aux_export(Vector<Annotation> annotations) throws RecognitionException {
		Aux_exportContext _localctx = new Aux_exportContext(_ctx, getState(), annotations);
		enterRule(_localctx, 20, RULE_aux_export);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			((Aux_exportContext)_localctx).export = export(annotations);
			((Aux_exportContext)_localctx).etg = ((Aux_exportContext)_localctx).export.etg;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Interface_inheritance_specContext extends ParserRuleContext {
		public Interface interfaceObject;
		public Scoped_name_listContext scoped_name_list;
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Scoped_name_listContext scoped_name_list() {
			return getRuleContext(Scoped_name_listContext.class,0);
		}
		public Interface_inheritance_specContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Interface_inheritance_specContext(ParserRuleContext parent, int invokingState, Interface interfaceObject) {
			super(parent, invokingState);
			this.interfaceObject = interfaceObject;
		}
		@Override public int getRuleIndex() { return RULE_interface_inheritance_spec; }
	}

	public final Interface_inheritance_specContext interface_inheritance_spec(Interface interfaceObject) throws RecognitionException {
		Interface_inheritance_specContext _localctx = new Interface_inheritance_specContext(_ctx, getState(), interfaceObject);
		enterRule(_localctx, 22, RULE_interface_inheritance_spec);

		        Vector<Pair<String, Token>> iflist = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			match(COLON);
			setState(490);
			((Interface_inheritance_specContext)_localctx).scoped_name_list = scoped_name_list();
			 iflist=((Interface_inheritance_specContext)_localctx).scoped_name_list.retlist; 

			        for(Pair<String, Token> pair : iflist)
			        {
			            Interface base = ctx.getInterface(pair.first());

			            if(base != null)
			            {
			                if(!_localctx.interfaceObject.addBase(base))
			                    throw new ParseException(pair.second(), " is duplicated.");
			            }
			            else
			            {
			               throw new ParseException(pair.second(), "was not defined previously");
			            }
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Interface_nameContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Interface_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interface_name; }
	}

	public final Interface_nameContext interface_name() throws RecognitionException {
		Interface_nameContext _localctx = new Interface_nameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_interface_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			scoped_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scoped_name_listContext extends ParserRuleContext {
		public Vector<Pair<String, Token>> retlist = null;
		public Scoped_nameContext scoped_name;
		public List<Scoped_nameContext> scoped_name() {
			return getRuleContexts(Scoped_nameContext.class);
		}
		public Scoped_nameContext scoped_name(int i) {
			return getRuleContext(Scoped_nameContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Scoped_name_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scoped_name_list; }
	}

	public final Scoped_name_listContext scoped_name_list() throws RecognitionException {
		Scoped_name_listContext _localctx = new Scoped_name_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_scoped_name_list);

		   ((Scoped_name_listContext)_localctx).retlist =  new Vector<Pair<String, Token>>();
		   Pair<String, Token> pair = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			((Scoped_name_listContext)_localctx).scoped_name = scoped_name();
			 pair=((Scoped_name_listContext)_localctx).scoped_name.pair; _localctx.retlist.add(pair);
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(498);
				match(COMA);
				setState(499);
				((Scoped_name_listContext)_localctx).scoped_name = scoped_name();
				 pair=((Scoped_name_listContext)_localctx).scoped_name.pair; _localctx.retlist.add(pair);
				}
				}
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scoped_nameContext extends ParserRuleContext {
		public Pair<String, Token> pair = null;
		public IdentifierContext identifier;
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public List<TerminalNode> DOUBLE_COLON() { return getTokens(IDLParser.DOUBLE_COLON); }
		public TerminalNode DOUBLE_COLON(int i) {
			return getToken(IDLParser.DOUBLE_COLON, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Scoped_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scoped_name; }
	}

	public final Scoped_nameContext scoped_name() throws RecognitionException {
		Scoped_nameContext _localctx = new Scoped_nameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_scoped_name);

		    String literalStr = "";
		    Token tk = _input.LT(1);

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOUBLE_COLON) {
				{
				literalStr += _input.LT(1).getText();
				setState(508);
				match(DOUBLE_COLON);
				}
			}

			literalStr += _input.LT(1).getText();
			setState(512);
			match(ID);
			setState(520);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					literalStr += _input.LT(1).getText();
					setState(514);
					match(DOUBLE_COLON);
					setState(515);
					((Scoped_nameContext)_localctx).identifier = identifier();
					 literalStr+=((Scoped_nameContext)_localctx).identifier.id; 
					}
					} 
				}
				setState(522);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			((Scoped_nameContext)_localctx).pair =  new Pair<String, Token>(literalStr, tk);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public Value_declContext value_decl() {
			return getRuleContext(Value_declContext.class,0);
		}
		public Value_abs_declContext value_abs_decl() {
			return getRuleContext(Value_abs_declContext.class,0);
		}
		public Value_box_declContext value_box_decl() {
			return getRuleContext(Value_box_declContext.class,0);
		}
		public Value_forward_declContext value_forward_decl() {
			return getRuleContext(Value_forward_declContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);

		    System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): ValueType declarations are not supported. Ignoring...");

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(525);
				value_decl();
				}
				break;
			case 2:
				{
				setState(526);
				value_abs_decl();
				}
				break;
			case 3:
				{
				setState(527);
				value_box_decl();
				}
				break;
			case 4:
				{
				setState(528);
				value_forward_decl();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_forward_declContext extends ParserRuleContext {
		public TerminalNode KW_VALUETYPE() { return getToken(IDLParser.KW_VALUETYPE, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public Value_forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_forward_decl; }
	}

	public final Value_forward_declContext value_forward_decl() throws RecognitionException {
		Value_forward_declContext _localctx = new Value_forward_declContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value_forward_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ABSTRACT) {
				{
				setState(531);
				match(KW_ABSTRACT);
				}
			}

			setState(534);
			match(KW_VALUETYPE);
			setState(535);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_box_declContext extends ParserRuleContext {
		public TerminalNode KW_VALUETYPE() { return getToken(IDLParser.KW_VALUETYPE, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public Value_box_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_box_decl; }
	}

	public final Value_box_declContext value_box_decl() throws RecognitionException {
		Value_box_declContext _localctx = new Value_box_declContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_value_box_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(KW_VALUETYPE);
			setState(538);
			match(ID);
			setState(539);
			type_spec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_abs_declContext extends ParserRuleContext {
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public TerminalNode KW_VALUETYPE() { return getToken(IDLParser.KW_VALUETYPE, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Value_inheritance_specContext value_inheritance_spec() {
			return getRuleContext(Value_inheritance_specContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public List<ExportContext> export() {
			return getRuleContexts(ExportContext.class);
		}
		public ExportContext export(int i) {
			return getRuleContext(ExportContext.class,i);
		}
		public Value_abs_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_abs_decl; }
	}

	public final Value_abs_declContext value_abs_decl() throws RecognitionException {
		Value_abs_declContext _localctx = new Value_abs_declContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_value_abs_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			match(KW_ABSTRACT);
			setState(542);
			match(KW_VALUETYPE);
			setState(543);
			match(ID);
			setState(544);
			value_inheritance_spec();
			setState(545);
			match(LEFT_BRACE);
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (KW_BITSET - 64)) | (1L << (KW_BITMASK - 64)) | (1L << (KW_INT8 - 64)) | (1L << (KW_UINT8 - 64)) | (1L << (KW_INT16 - 64)) | (1L << (KW_UINT16 - 64)) | (1L << (KW_INT32 - 64)) | (1L << (KW_UINT32 - 64)) | (1L << (KW_INT64 - 64)) | (1L << (KW_UINT64 - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(546);
				export(null);
				}
				}
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(552);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_declContext extends ParserRuleContext {
		public Value_headerContext value_header() {
			return getRuleContext(Value_headerContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public List<Value_elementContext> value_element() {
			return getRuleContexts(Value_elementContext.class);
		}
		public Value_elementContext value_element(int i) {
			return getRuleContext(Value_elementContext.class,i);
		}
		public Value_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_decl; }
	}

	public final Value_declContext value_decl() throws RecognitionException {
		Value_declContext _localctx = new Value_declContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_value_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			value_header();
			setState(555);
			match(LEFT_BRACE);
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_PRIVATE) | (1L << KW_WCHAR) | (1L << KW_PUBLIC) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_FACTORY - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (KW_BITSET - 64)) | (1L << (KW_BITMASK - 64)) | (1L << (KW_INT8 - 64)) | (1L << (KW_UINT8 - 64)) | (1L << (KW_INT16 - 64)) | (1L << (KW_UINT16 - 64)) | (1L << (KW_INT32 - 64)) | (1L << (KW_UINT32 - 64)) | (1L << (KW_INT64 - 64)) | (1L << (KW_UINT64 - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(556);
				value_element();
				}
				}
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(562);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_headerContext extends ParserRuleContext {
		public TerminalNode KW_VALUETYPE() { return getToken(IDLParser.KW_VALUETYPE, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Value_inheritance_specContext value_inheritance_spec() {
			return getRuleContext(Value_inheritance_specContext.class,0);
		}
		public TerminalNode KW_CUSTOM() { return getToken(IDLParser.KW_CUSTOM, 0); }
		public Value_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_header; }
	}

	public final Value_headerContext value_header() throws RecognitionException {
		Value_headerContext _localctx = new Value_headerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_value_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_CUSTOM) {
				{
				setState(564);
				match(KW_CUSTOM);
				}
			}

			setState(567);
			match(KW_VALUETYPE);
			setState(568);
			match(ID);
			setState(569);
			value_inheritance_spec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_inheritance_specContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public List<Value_nameContext> value_name() {
			return getRuleContexts(Value_nameContext.class);
		}
		public Value_nameContext value_name(int i) {
			return getRuleContext(Value_nameContext.class,i);
		}
		public TerminalNode KW_SUPPORTS() { return getToken(IDLParser.KW_SUPPORTS, 0); }
		public List<Interface_nameContext> interface_name() {
			return getRuleContexts(Interface_nameContext.class);
		}
		public Interface_nameContext interface_name(int i) {
			return getRuleContext(Interface_nameContext.class,i);
		}
		public TerminalNode KW_TRUNCATABLE() { return getToken(IDLParser.KW_TRUNCATABLE, 0); }
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Value_inheritance_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_inheritance_spec; }
	}

	public final Value_inheritance_specContext value_inheritance_spec() throws RecognitionException {
		Value_inheritance_specContext _localctx = new Value_inheritance_specContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_value_inheritance_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(571);
				match(COLON);
				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_TRUNCATABLE) {
					{
					setState(572);
					match(KW_TRUNCATABLE);
					}
				}

				setState(575);
				value_name();
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(576);
					match(COMA);
					setState(577);
					value_name();
					}
					}
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(594);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_SUPPORTS) {
				{
				setState(585);
				match(KW_SUPPORTS);
				setState(586);
				interface_name();
				setState(591);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(587);
					match(COMA);
					setState(588);
					interface_name();
					}
					}
					setState(593);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_nameContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Value_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_name; }
	}

	public final Value_nameContext value_name() throws RecognitionException {
		Value_nameContext _localctx = new Value_nameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_value_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			scoped_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_elementContext extends ParserRuleContext {
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public State_memberContext state_member() {
			return getRuleContext(State_memberContext.class,0);
		}
		public Init_declContext init_decl() {
			return getRuleContext(Init_declContext.class,0);
		}
		public Value_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_element; }
	}

	public final Value_elementContext value_element() throws RecognitionException {
		Value_elementContext _localctx = new Value_elementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_value_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_TYPEDEF:
			case KW_OCTET:
			case KW_STRUCT:
			case KW_NATIVE:
			case KW_READONLY:
			case KW_VOID:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_ENUM:
			case KW_WSTRING:
			case KW_EXCEPTION:
			case KW_CONST:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_UNION:
			case KW_ONEWAY:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_TYPEPREFIX:
			case KW_TYPEID:
			case KW_ATTRIBUTE:
			case KW_BITSET:
			case KW_BITMASK:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
			case ID:
				{
				setState(598);
				export(null);
				}
				break;
			case KW_PRIVATE:
			case KW_PUBLIC:
				{
				setState(599);
				state_member();
				}
				break;
			case KW_FACTORY:
				{
				setState(600);
				init_decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_memberContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public DeclaratorsContext declarators() {
			return getRuleContext(DeclaratorsContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public TerminalNode KW_PUBLIC() { return getToken(IDLParser.KW_PUBLIC, 0); }
		public TerminalNode KW_PRIVATE() { return getToken(IDLParser.KW_PRIVATE, 0); }
		public State_memberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_member; }
	}

	public final State_memberContext state_member() throws RecognitionException {
		State_memberContext _localctx = new State_memberContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_state_member);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			_la = _input.LA(1);
			if ( !(_la==KW_PRIVATE || _la==KW_PUBLIC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(604);
			type_spec();
			setState(605);
			declarators();
			setState(606);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_declContext extends ParserRuleContext {
		public TerminalNode KW_FACTORY() { return getToken(IDLParser.KW_FACTORY, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Init_param_declsContext init_param_decls() {
			return getRuleContext(Init_param_declsContext.class,0);
		}
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public Init_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_decl; }
	}

	public final Init_declContext init_decl() throws RecognitionException {
		Init_declContext _localctx = new Init_declContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_init_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			match(KW_FACTORY);
			setState(609);
			match(ID);
			setState(610);
			match(LEFT_BRACKET);
			setState(612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_IN) {
				{
				setState(611);
				init_param_decls();
				}
			}

			setState(614);
			match(RIGHT_BRACKET);
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_RAISES) {
				{
				setState(615);
				raises_expr();
				}
			}

			setState(618);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_param_declsContext extends ParserRuleContext {
		public List<Init_param_declContext> init_param_decl() {
			return getRuleContexts(Init_param_declContext.class);
		}
		public Init_param_declContext init_param_decl(int i) {
			return getRuleContext(Init_param_declContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Init_param_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_param_decls; }
	}

	public final Init_param_declsContext init_param_decls() throws RecognitionException {
		Init_param_declsContext _localctx = new Init_param_declsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_init_param_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			init_param_decl();
			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(621);
				match(COMA);
				setState(622);
				init_param_decl();
				}
				}
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_param_declContext extends ParserRuleContext {
		public Init_param_attributeContext init_param_attribute() {
			return getRuleContext(Init_param_attributeContext.class,0);
		}
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Init_param_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_param_decl; }
	}

	public final Init_param_declContext init_param_decl() throws RecognitionException {
		Init_param_declContext _localctx = new Init_param_declContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_init_param_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			init_param_attribute();
			setState(629);
			param_type_spec();
			setState(630);
			simple_declarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_param_attributeContext extends ParserRuleContext {
		public TerminalNode KW_IN() { return getToken(IDLParser.KW_IN, 0); }
		public Init_param_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_param_attribute; }
	}

	public final Init_param_attributeContext init_param_attribute() throws RecognitionException {
		Init_param_attributeContext _localctx = new Init_param_attributeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_init_param_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			match(KW_IN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_declContext extends ParserRuleContext {
		public Pair<ConstDeclaration, TemplateGroup> returnPair = null;
		public Const_typeContext const_type;
		public IdentifierContext identifier;
		public Const_expContext const_exp;
		public TerminalNode KW_CONST() { return getToken(IDLParser.KW_CONST, 0); }
		public Const_typeContext const_type() {
			return getRuleContext(Const_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(IDLParser.EQUAL, 0); }
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public Const_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_decl; }
	}

	public final Const_declContext const_decl() throws RecognitionException {
		Const_declContext _localctx = new Const_declContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_const_decl);

		    ConstDeclaration constDecl = null;
		    TypeCode typecode = null;
		    String constName = null, constValue = null;
		    TemplateGroup constTemplates = null;
		    if(tmanager != null) {
		        constTemplates = tmanager.createTemplateGroup("const_decl");
		    }
		    Token tk = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			match(KW_CONST);
			setState(635);
			((Const_declContext)_localctx).const_type = const_type();
			 typecode=((Const_declContext)_localctx).const_type.typecode; tk = _input.LT(1);
			setState(637);
			((Const_declContext)_localctx).identifier = identifier();
			 constName=((Const_declContext)_localctx).identifier.id; 
			setState(639);
			match(EQUAL);
			setState(640);
			((Const_declContext)_localctx).const_exp = const_exp();
			 constValue=((Const_declContext)_localctx).const_exp.literalStr; 

			        if(typecode != null)
			        {
			            constDecl = new ConstDeclaration(ctx.getScopeFile(), ctx.isInScopedFile(), ctx.getScope(), constName, typecode, constValue, tk);

			            if(constTemplates != null)
			            {
			                constTemplates.setAttribute("ctx", ctx);
			                constTemplates.setAttribute("const", constDecl);
			            }

			            ((Const_declContext)_localctx).returnPair =  new Pair<ConstDeclaration, TemplateGroup>(constDecl, constTemplates);
			       }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Integer_typeContext integer_type;
		public Char_typeContext char_type;
		public Wide_char_typeContext wide_char_type;
		public Boolean_typeContext boolean_type;
		public Floating_pt_typeContext floating_pt_type;
		public String_typeContext string_type;
		public Wide_string_typeContext wide_string_type;
		public Scoped_nameContext scoped_name;
		public Octet_typeContext octet_type;
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Char_typeContext char_type() {
			return getRuleContext(Char_typeContext.class,0);
		}
		public Wide_char_typeContext wide_char_type() {
			return getRuleContext(Wide_char_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public Floating_pt_typeContext floating_pt_type() {
			return getRuleContext(Floating_pt_typeContext.class,0);
		}
		public String_typeContext string_type() {
			return getRuleContext(String_typeContext.class,0);
		}
		public Wide_string_typeContext wide_string_type() {
			return getRuleContext(Wide_string_typeContext.class,0);
		}
		public Fixed_pt_const_typeContext fixed_pt_const_type() {
			return getRuleContext(Fixed_pt_const_typeContext.class,0);
		}
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Octet_typeContext octet_type() {
			return getRuleContext(Octet_typeContext.class,0);
		}
		public Const_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_type; }
	}

	public final Const_typeContext const_type() throws RecognitionException {
		Const_typeContext _localctx = new Const_typeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_const_type);

		    Pair<String, Token> pair = null;

		try {
			setState(672);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(644);
				((Const_typeContext)_localctx).integer_type = integer_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).integer_type.typecode; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(647);
				((Const_typeContext)_localctx).char_type = char_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).char_type.typecode; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(650);
				((Const_typeContext)_localctx).wide_char_type = wide_char_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).wide_char_type.typecode; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(653);
				((Const_typeContext)_localctx).boolean_type = boolean_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).boolean_type.typecode; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(656);
				((Const_typeContext)_localctx).floating_pt_type = floating_pt_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).floating_pt_type.typecode; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(659);
				((Const_typeContext)_localctx).string_type = string_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).string_type.typecode; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(662);
				((Const_typeContext)_localctx).wide_string_type = wide_string_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).wide_string_type.typecode; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(665);
				fixed_pt_const_type();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(666);
				((Const_typeContext)_localctx).scoped_name = scoped_name();

				           pair = ((Const_typeContext)_localctx).scoped_name.pair;
				           // Find typecode in the global map.
				           ((Const_typeContext)_localctx).typecode =  ctx.getTypeCode(pair.first());

				           if(_localctx.typecode == null)
				           {
				               throw new ParseException(pair.second(), "was not defined previously");
				           }
				        
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(669);
				((Const_typeContext)_localctx).octet_type = octet_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).octet_type.typecode; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_expContext extends ParserRuleContext {
		public String literalStr = null;
		public Or_exprContext or_expr;
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public Const_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_exp; }
	}

	public final Const_expContext const_exp() throws RecognitionException {
		Const_expContext _localctx = new Const_expContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_const_exp);

		    String aux = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			((Const_expContext)_localctx).or_expr = or_expr();
			 ((Const_expContext)_localctx).literalStr =  ((Const_expContext)_localctx).or_expr.literalStr; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Xor_exprContext xor_expr;
		public List<Xor_exprContext> xor_expr() {
			return getRuleContexts(Xor_exprContext.class);
		}
		public Xor_exprContext xor_expr(int i) {
			return getRuleContext(Xor_exprContext.class,i);
		}
		public List<TerminalNode> PIPE() { return getTokens(IDLParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(IDLParser.PIPE, i);
		}
		public Or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expr; }
	}

	public final Or_exprContext or_expr() throws RecognitionException {
		Or_exprContext _localctx = new Or_exprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_or_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			((Or_exprContext)_localctx).xor_expr = xor_expr();
			 ((Or_exprContext)_localctx).literalStr =  ((Or_exprContext)_localctx).xor_expr.literalStr; 
			setState(686);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(680);
				match(PIPE);
				setState(681);
				((Or_exprContext)_localctx).xor_expr = xor_expr();
				 aux=((Or_exprContext)_localctx).xor_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(688);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Xor_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public And_exprContext and_expr;
		public List<And_exprContext> and_expr() {
			return getRuleContexts(And_exprContext.class);
		}
		public And_exprContext and_expr(int i) {
			return getRuleContext(And_exprContext.class,i);
		}
		public List<TerminalNode> CARET() { return getTokens(IDLParser.CARET); }
		public TerminalNode CARET(int i) {
			return getToken(IDLParser.CARET, i);
		}
		public Xor_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor_expr; }
	}

	public final Xor_exprContext xor_expr() throws RecognitionException {
		Xor_exprContext _localctx = new Xor_exprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_xor_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			((Xor_exprContext)_localctx).and_expr = and_expr();
			 ((Xor_exprContext)_localctx).literalStr =  ((Xor_exprContext)_localctx).and_expr.literalStr; 
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CARET) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(692);
				match(CARET);
				setState(693);
				((Xor_exprContext)_localctx).and_expr = and_expr();
				 aux=((Xor_exprContext)_localctx).and_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Shift_exprContext shift_expr;
		public List<Shift_exprContext> shift_expr() {
			return getRuleContexts(Shift_exprContext.class);
		}
		public Shift_exprContext shift_expr(int i) {
			return getRuleContext(Shift_exprContext.class,i);
		}
		public List<TerminalNode> AMPERSAND() { return getTokens(IDLParser.AMPERSAND); }
		public TerminalNode AMPERSAND(int i) {
			return getToken(IDLParser.AMPERSAND, i);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_and_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			((And_exprContext)_localctx).shift_expr = shift_expr();
			 ((And_exprContext)_localctx).literalStr =  ((And_exprContext)_localctx).shift_expr.literalStr; 
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMPERSAND) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(704);
				match(AMPERSAND);
				setState(705);
				((And_exprContext)_localctx).shift_expr = shift_expr();
				 aux=((And_exprContext)_localctx).shift_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shift_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Add_exprContext add_expr;
		public List<Add_exprContext> add_expr() {
			return getRuleContexts(Add_exprContext.class);
		}
		public Add_exprContext add_expr(int i) {
			return getRuleContext(Add_exprContext.class,i);
		}
		public List<TerminalNode> RIGHT_SHIFT() { return getTokens(IDLParser.RIGHT_SHIFT); }
		public TerminalNode RIGHT_SHIFT(int i) {
			return getToken(IDLParser.RIGHT_SHIFT, i);
		}
		public List<TerminalNode> LEFT_SHIFT() { return getTokens(IDLParser.LEFT_SHIFT); }
		public TerminalNode LEFT_SHIFT(int i) {
			return getToken(IDLParser.LEFT_SHIFT, i);
		}
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_shift_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(713);
			((Shift_exprContext)_localctx).add_expr = add_expr();
			 ((Shift_exprContext)_localctx).literalStr =  ((Shift_exprContext)_localctx).add_expr.literalStr; 
			setState(722);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RIGHT_SHIFT || _la==LEFT_SHIFT) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(716);
				_la = _input.LA(1);
				if ( !(_la==RIGHT_SHIFT || _la==LEFT_SHIFT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(717);
				((Shift_exprContext)_localctx).add_expr = add_expr();
				 aux=((Shift_exprContext)_localctx).add_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(724);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Add_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Mult_exprContext mult_expr;
		public List<Mult_exprContext> mult_expr() {
			return getRuleContexts(Mult_exprContext.class);
		}
		public Mult_exprContext mult_expr(int i) {
			return getRuleContext(Mult_exprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(IDLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(IDLParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(IDLParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(IDLParser.MINUS, i);
		}
		public Add_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_expr; }
	}

	public final Add_exprContext add_expr() throws RecognitionException {
		Add_exprContext _localctx = new Add_exprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_add_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			((Add_exprContext)_localctx).mult_expr = mult_expr();
			 ((Add_exprContext)_localctx).literalStr =  ((Add_exprContext)_localctx).mult_expr.literalStr; 
			setState(734);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(728);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(729);
				((Add_exprContext)_localctx).mult_expr = mult_expr();
				 aux=((Add_exprContext)_localctx).mult_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(736);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mult_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Unary_exprContext unary_expr;
		public List<Unary_exprContext> unary_expr() {
			return getRuleContexts(Unary_exprContext.class);
		}
		public Unary_exprContext unary_expr(int i) {
			return getRuleContext(Unary_exprContext.class,i);
		}
		public List<TerminalNode> SLASH() { return getTokens(IDLParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(IDLParser.SLASH, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(IDLParser.PERCENT); }
		public TerminalNode PERCENT(int i) {
			return getToken(IDLParser.PERCENT, i);
		}
		public Mult_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_expr; }
	}

	public final Mult_exprContext mult_expr() throws RecognitionException {
		Mult_exprContext _localctx = new Mult_exprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_mult_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			((Mult_exprContext)_localctx).unary_expr = unary_expr();
			 ((Mult_exprContext)_localctx).literalStr =  ((Mult_exprContext)_localctx).unary_expr.literalStr; 
			setState(746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SLASH) | (1L << STAR) | (1L << PERCENT))) != 0)) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(740);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SLASH) | (1L << STAR) | (1L << PERCENT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(741);
				((Mult_exprContext)_localctx).unary_expr = unary_expr();
				 aux=((Mult_exprContext)_localctx).unary_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(748);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Primary_exprContext primary_expr;
		public Primary_exprContext primary_expr() {
			return getRuleContext(Primary_exprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(IDLParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(IDLParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(IDLParser.TILDE, 0); }
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_unary_expr);

		    String aux = null;

		int _la;
		try {
			setState(757);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TILDE:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				((Unary_exprContext)_localctx).literalStr =  _input.LT(1).getText();
				setState(750);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TILDE) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(751);
				((Unary_exprContext)_localctx).primary_expr = primary_expr();
				 aux=((Unary_exprContext)_localctx).primary_expr.literalStr; _localctx.literalStr += aux;
				}
				break;
			case T__0:
			case T__1:
			case INTEGER_LITERAL:
			case HEX_LITERAL:
			case FLOATING_PT_LITERAL:
			case FIXED_PT_LITERAL:
			case WIDE_CHARACTER_LITERAL:
			case CHARACTER_LITERAL:
			case WIDE_STRING_LITERAL:
			case STRING_LITERAL:
			case LEFT_BRACKET:
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(754);
				((Unary_exprContext)_localctx).primary_expr = primary_expr();
				 ((Unary_exprContext)_localctx).literalStr =  ((Unary_exprContext)_localctx).primary_expr.literalStr; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Scoped_nameContext scoped_name;
		public LiteralContext literal;
		public Const_expContext const_exp;
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Primary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expr; }
	}

	public final Primary_exprContext primary_expr() throws RecognitionException {
		Primary_exprContext _localctx = new Primary_exprContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_primary_expr);

		    String aux = null;

		try {
			setState(771);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(759);
				((Primary_exprContext)_localctx).scoped_name = scoped_name();
				 ((Primary_exprContext)_localctx).literalStr =  ((Primary_exprContext)_localctx).scoped_name.pair.first(); 
				}
				break;
			case T__0:
			case T__1:
			case INTEGER_LITERAL:
			case HEX_LITERAL:
			case FLOATING_PT_LITERAL:
			case FIXED_PT_LITERAL:
			case WIDE_CHARACTER_LITERAL:
			case CHARACTER_LITERAL:
			case WIDE_STRING_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(762);
				((Primary_exprContext)_localctx).literal = literal();
				 ((Primary_exprContext)_localctx).literalStr =  ((Primary_exprContext)_localctx).literal.pair.first(); 
				}
				break;
			case LEFT_BRACKET:
				enterOuterAlt(_localctx, 3);
				{
				((Primary_exprContext)_localctx).literalStr =  _input.LT(1).getText();
				setState(766);
				match(LEFT_BRACKET);
				setState(767);
				((Primary_exprContext)_localctx).const_exp = const_exp();
				 aux=((Primary_exprContext)_localctx).const_exp.literalStr; _localctx.literalStr += aux; _localctx.literalStr += _input.LT(1).getText();
				setState(769);
				match(RIGHT_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public Pair<String, Token> pair = null;
		public Boolean_literalContext boolean_literal;
		public TerminalNode HEX_LITERAL() { return getToken(IDLParser.HEX_LITERAL, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(IDLParser.INTEGER_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(IDLParser.STRING_LITERAL, 0); }
		public TerminalNode WIDE_STRING_LITERAL() { return getToken(IDLParser.WIDE_STRING_LITERAL, 0); }
		public TerminalNode CHARACTER_LITERAL() { return getToken(IDLParser.CHARACTER_LITERAL, 0); }
		public TerminalNode WIDE_CHARACTER_LITERAL() { return getToken(IDLParser.WIDE_CHARACTER_LITERAL, 0); }
		public TerminalNode FIXED_PT_LITERAL() { return getToken(IDLParser.FIXED_PT_LITERAL, 0); }
		public TerminalNode FLOATING_PT_LITERAL() { return getToken(IDLParser.FLOATING_PT_LITERAL, 0); }
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_literal);

		    Token tk = _input.LT(1);
		    String literalStr = tk.getText();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HEX_LITERAL:
				{
				setState(773);
				match(HEX_LITERAL);
				}
				break;
			case INTEGER_LITERAL:
				{
				setState(774);
				match(INTEGER_LITERAL);
				}
				break;
			case STRING_LITERAL:
				{
				setState(775);
				match(STRING_LITERAL);
				}
				break;
			case WIDE_STRING_LITERAL:
				{
				setState(776);
				match(WIDE_STRING_LITERAL);
				}
				break;
			case CHARACTER_LITERAL:
				{
				setState(777);
				match(CHARACTER_LITERAL);
				}
				break;
			case WIDE_CHARACTER_LITERAL:
				{
				setState(778);
				match(WIDE_CHARACTER_LITERAL);
				}
				break;
			case FIXED_PT_LITERAL:
				{
				setState(779);
				match(FIXED_PT_LITERAL);
				}
				break;
			case FLOATING_PT_LITERAL:
				{
				setState(780);
				match(FLOATING_PT_LITERAL);
				}
				break;
			case T__0:
			case T__1:
				{
				setState(781);
				((LiteralContext)_localctx).boolean_literal = boolean_literal();
				literalStr = ((LiteralContext)_localctx).boolean_literal.literalStr;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((LiteralContext)_localctx).pair =  new Pair<String, Token>(literalStr, tk);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_literalContext extends ParserRuleContext {
		public String literalStr = null;
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_boolean_literal);
		try {
			setState(792);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(788);
				match(T__0);
				 ((Boolean_literalContext)_localctx).literalStr =  "true";
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(790);
				match(T__1);
				 ((Boolean_literalContext)_localctx).literalStr =  "false";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Positive_int_constContext extends ParserRuleContext {
		public String literalStr = null;
		public Const_expContext const_exp;
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public Positive_int_constContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positive_int_const; }
	}

	public final Positive_int_constContext positive_int_const() throws RecognitionException {
		Positive_int_constContext _localctx = new Positive_int_constContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_positive_int_const);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			((Positive_int_constContext)_localctx).const_exp = const_exp();
			 ((Positive_int_constContext)_localctx).literalStr =  ((Positive_int_constContext)_localctx).const_exp.literalStr; 

			           // TODO Calcular la expresion
			           /*try {
			               int value = Integer.parseInt(_localctx.literalStr);

			               if(value < 0)
			                   throw new ParseException(_localctx.literalStr, "expression is not supported. You must use a positive integer.");
			           } catch(NumberFormatException e) {
			           }*/
			       
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_declContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public ArrayList<Definition> defs;
		public Pair<Vector<TypeDeclaration>, TemplateGroup> returnPair = null;
		public Type_declaratorContext type_declarator;
		public Struct_typeContext struct_type;
		public Union_typeContext union_type;
		public Enum_typeContext enum_type;
		public Bitset_typeContext bitset_type;
		public Bitmask_typeContext bitmask_type;
		public TerminalNode KW_TYPEDEF() { return getToken(IDLParser.KW_TYPEDEF, 0); }
		public Type_declaratorContext type_declarator() {
			return getRuleContext(Type_declaratorContext.class,0);
		}
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Enum_typeContext enum_type() {
			return getRuleContext(Enum_typeContext.class,0);
		}
		public Bitset_typeContext bitset_type() {
			return getRuleContext(Bitset_typeContext.class,0);
		}
		public Bitmask_typeContext bitmask_type() {
			return getRuleContext(Bitmask_typeContext.class,0);
		}
		public TerminalNode KW_NATIVE() { return getToken(IDLParser.KW_NATIVE, 0); }
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Constr_forward_declContext constr_forward_decl() {
			return getRuleContext(Constr_forward_declContext.class,0);
		}
		public Type_declContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Type_declContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations, ArrayList<Definition> defs) {
			super(parent, invokingState);
			this.annotations = annotations;
			this.defs = defs;
		}
		@Override public int getRuleIndex() { return RULE_type_decl; }
	}

	public final Type_declContext type_decl(Vector<Annotation> annotations,ArrayList<Definition> defs) throws RecognitionException {
		Type_declContext _localctx = new Type_declContext(_ctx, getState(), annotations, defs);
		enterRule(_localctx, 86, RULE_type_decl);

		    Pair<Vector<TypeCode>, TemplateGroup> ttg = null;
		    Vector<TypeDeclaration> vector = null;
		    Token tk = null;
		    String fw_name = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(798);
				match(KW_TYPEDEF);
				tk = _input.LT(1);
				setState(800);
				((Type_declContext)_localctx).type_declarator = type_declarator();
				 ttg=((Type_declContext)_localctx).type_declarator.returnPair; 
				}
				break;
			case 2:
				{
				setState(803);
				((Type_declContext)_localctx).struct_type = struct_type();
				 ttg=((Type_declContext)_localctx).struct_type.returnPair; fw_name = ((Type_declContext)_localctx).struct_type.fw_name; 
				}
				break;
			case 3:
				{
				setState(806);
				((Type_declContext)_localctx).union_type = union_type(defs);
				 ttg=((Type_declContext)_localctx).union_type.returnPair; fw_name = ((Type_declContext)_localctx).union_type.fw_name; 
				}
				break;
			case 4:
				{
				setState(809);
				((Type_declContext)_localctx).enum_type = enum_type();
				 ttg=((Type_declContext)_localctx).enum_type.returnPair; 
				}
				break;
			case 5:
				{
				setState(812);
				((Type_declContext)_localctx).bitset_type = bitset_type();
				 ttg=((Type_declContext)_localctx).bitset_type.returnPair; 
				}
				break;
			case 6:
				{
				setState(815);
				((Type_declContext)_localctx).bitmask_type = bitmask_type();
				 ttg=((Type_declContext)_localctx).bitmask_type.returnPair; 
				}
				break;
			case 7:
				{
				setState(818);
				match(KW_NATIVE);
				 System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Native declarations are not supported. Ignoring..."); 
				setState(820);
				simple_declarator();
				}
				break;
			case 8:
				{
				setState(821);
				constr_forward_decl();
				}
				break;
			}

			        if(ttg!=null)
			        {
			            vector = new Vector<TypeDeclaration>();

			            for(int count = 0; count < ttg.first().size(); ++count)
			            {
			                String name = null;
			                if(ttg.first().get(count) instanceof MemberedTypeCode)
			                    name = ((MemberedTypeCode)ttg.first().get(count)).getName();
			                else if(ttg.first().get(count) instanceof AliasTypeCode)
			                    name = ((AliasTypeCode)ttg.first().get(count)).getName();

			                TypeDeclaration typedeclaration = new TypeDeclaration(ctx.getScopeFile(), ctx.isInScopedFile(), ctx.getScope(), name, ttg.first().get(count), tk);

			                // Add annotations
			                for(Annotation annotation : annotations)
			                {
			                    if (annotation != null) // Some annotations may be ignored
			                    {
			                        typedeclaration.addAnnotation(ctx, annotation);
			                    }
			                }

			                // Add type declaration to the map with all typedeclarations.
			                ctx.addTypeDeclaration(typedeclaration);

			                vector.add(typedeclaration);

			                ((Type_declContext)_localctx).returnPair =  new Pair<Vector<TypeDeclaration>, TemplateGroup>(vector, ttg.second());
			            }
			        }
			        else if (fw_name != null) // It was a forward declaration
			        {
			            if (ctx.getScope() != null && !ctx.getScope().isEmpty())
			            {
			                fw_name = ctx.getScope() + "::" + fw_name;
			            }
			            TypeDeclaration typedeclaration = ctx.getTypeDeclaration(fw_name);
			            // Add annotations
			            for(Annotation annotation : annotations)
			            {
			                if (annotation != null) // Some annotations may be ignored
			                {
			                    typedeclaration.addAnnotation(ctx, annotation);
			                }
			            }
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_declaratorContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public Type_specContext type_spec;
		public DeclaratorsContext declarators;
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public DeclaratorsContext declarators() {
			return getRuleContext(DeclaratorsContext.class,0);
		}
		public Type_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_declarator; }
	}

	public final Type_declaratorContext type_declarator() throws RecognitionException {
		Type_declaratorContext _localctx = new Type_declaratorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_type_declarator);

		    Vector<TypeCode> vector = null;
		    AliasTypeCode typedefTypecode = null;
		    TemplateGroup typedefTemplates =  null;
		    if(tmanager != null) {
		        typedefTemplates = tmanager.createTemplateGroup("typedef_decl");
		    }

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
			((Type_declaratorContext)_localctx).type_spec = type_spec();
			setState(827);
			((Type_declaratorContext)_localctx).declarators = declarators();

			       if(((Type_declaratorContext)_localctx).type_spec.typecode != null)
			       {
			           vector = new Vector<TypeCode>();

			           for(int count = 0; count < ((Type_declaratorContext)_localctx).declarators.ret.size(); ++count)
			           {
			               typedefTypecode = new AliasTypeCode(ctx.getScope(), ((Type_declaratorContext)_localctx).declarators.ret.get(count).first().first());

			               if(((Type_declaratorContext)_localctx).declarators.ret.get(count).second() != null)
			               {
			                   // Array declaration
			                   ((Type_declaratorContext)_localctx).declarators.ret.get(count).second().setContentTypeCode(((Type_declaratorContext)_localctx).type_spec.typecode);
			                   typedefTypecode.setContentTypeCode(((Type_declaratorContext)_localctx).declarators.ret.get(count).second());
			               }
			               else
			               {
			                   // Simple declaration
			                   typedefTypecode.setContentTypeCode(((Type_declaratorContext)_localctx).type_spec.typecode);
			               }

			               if(typedefTemplates != null) {
			                    typedefTemplates.setAttribute("typedefs", typedefTypecode);
			               }

			               vector.add(typedefTypecode);
			           }

			            if(typedefTemplates != null) {
			                typedefTemplates.setAttribute("ctx", ctx);
			            }

			            ((Type_declaratorContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, typedefTemplates);
			       }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Definition def = null;
		public Simple_type_specContext simple_type_spec;
		public Simple_type_specContext simple_type_spec() {
			return getRuleContext(Simple_type_specContext.class,0);
		}
		public Constr_type_specContext constr_type_spec() {
			return getRuleContext(Constr_type_specContext.class,0);
		}
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_type_spec);
		try {
			setState(834);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_OCTET:
			case KW_SEQUENCE:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_WSTRING:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_FIXED:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_SET:
			case KW_MAP:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(830);
				((Type_specContext)_localctx).simple_type_spec = simple_type_spec();
				 ((Type_specContext)_localctx).typecode = ((Type_specContext)_localctx).simple_type_spec.typecode; ((Type_specContext)_localctx).def = ((Type_specContext)_localctx).simple_type_spec.def; 
				}
				break;
			case KW_STRUCT:
			case KW_ENUM:
			case KW_UNION:
			case KW_BITSET:
			case KW_BITMASK:
				enterOuterAlt(_localctx, 2);
				{
				setState(833);
				constr_type_spec();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Definition def = null;
		public Base_type_specContext base_type_spec;
		public Template_type_specContext template_type_spec;
		public Scoped_nameContext scoped_name;
		public Base_type_specContext base_type_spec() {
			return getRuleContext(Base_type_specContext.class,0);
		}
		public Template_type_specContext template_type_spec() {
			return getRuleContext(Template_type_specContext.class,0);
		}
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Simple_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_type_spec; }
	}

	public final Simple_type_specContext simple_type_spec() throws RecognitionException {
		Simple_type_specContext _localctx = new Simple_type_specContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_simple_type_spec);

		    Pair<String, Token> pair = null;

		try {
			setState(845);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_OCTET:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
				enterOuterAlt(_localctx, 1);
				{
				setState(836);
				((Simple_type_specContext)_localctx).base_type_spec = base_type_spec();
				 ((Simple_type_specContext)_localctx).typecode = ((Simple_type_specContext)_localctx).base_type_spec.typecode; 
				}
				break;
			case KW_STRING:
			case KW_SEQUENCE:
			case KW_WSTRING:
			case KW_FIXED:
			case KW_SET:
			case KW_MAP:
				enterOuterAlt(_localctx, 2);
				{
				setState(839);
				((Simple_type_specContext)_localctx).template_type_spec = template_type_spec();
				 ((Simple_type_specContext)_localctx).typecode = ((Simple_type_specContext)_localctx).template_type_spec.typecode; 
				}
				break;
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(842);
				((Simple_type_specContext)_localctx).scoped_name = scoped_name();

				            pair=((Simple_type_specContext)_localctx).scoped_name.pair;

				            // Find typecode in the global map.
				            ((Simple_type_specContext)_localctx).typecode =  ctx.getTypeCode(pair.first());

				            if(_localctx.typecode == null)
				            {
				                // Maybe an interface
				                ((Simple_type_specContext)_localctx).def =  ctx.getInterface(pair.first());

				                if (_localctx.def == null)
				                {
				                    throw new ParseException(pair.second(), "was not defined previously");
				                }
				            }
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bitfield_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Integer_typeContext integer_type;
		public Boolean_typeContext boolean_type;
		public Octet_typeContext octet_type;
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public Octet_typeContext octet_type() {
			return getRuleContext(Octet_typeContext.class,0);
		}
		public Bitfield_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitfield_type_spec; }
	}

	public final Bitfield_type_specContext bitfield_type_spec() throws RecognitionException {
		Bitfield_type_specContext _localctx = new Bitfield_type_specContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_bitfield_type_spec);
		try {
			setState(856);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_SHORT:
			case KW_LONG:
			case KW_UNSIGNED:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
				enterOuterAlt(_localctx, 1);
				{
				setState(847);
				((Bitfield_type_specContext)_localctx).integer_type = integer_type();
				 ((Bitfield_type_specContext)_localctx).typecode = ((Bitfield_type_specContext)_localctx).integer_type.typecode; 
				}
				break;
			case KW_BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(850);
				((Bitfield_type_specContext)_localctx).boolean_type = boolean_type();
				 ((Bitfield_type_specContext)_localctx).typecode = ((Bitfield_type_specContext)_localctx).boolean_type.typecode; 
				}
				break;
			case KW_OCTET:
				enterOuterAlt(_localctx, 3);
				{
				setState(853);
				((Bitfield_type_specContext)_localctx).octet_type = octet_type();
				 ((Bitfield_type_specContext)_localctx).typecode = ((Bitfield_type_specContext)_localctx).octet_type.typecode; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Floating_pt_typeContext floating_pt_type;
		public Integer_typeContext integer_type;
		public Char_typeContext char_type;
		public Wide_char_typeContext wide_char_type;
		public Boolean_typeContext boolean_type;
		public Octet_typeContext octet_type;
		public Floating_pt_typeContext floating_pt_type() {
			return getRuleContext(Floating_pt_typeContext.class,0);
		}
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Char_typeContext char_type() {
			return getRuleContext(Char_typeContext.class,0);
		}
		public Wide_char_typeContext wide_char_type() {
			return getRuleContext(Wide_char_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public Octet_typeContext octet_type() {
			return getRuleContext(Octet_typeContext.class,0);
		}
		public Any_typeContext any_type() {
			return getRuleContext(Any_typeContext.class,0);
		}
		public Object_typeContext object_type() {
			return getRuleContext(Object_typeContext.class,0);
		}
		public Value_base_typeContext value_base_type() {
			return getRuleContext(Value_base_typeContext.class,0);
		}
		public Base_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type_spec; }
	}

	public final Base_type_specContext base_type_spec() throws RecognitionException {
		Base_type_specContext _localctx = new Base_type_specContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_base_type_spec);
		try {
			setState(879);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(858);
				((Base_type_specContext)_localctx).floating_pt_type = floating_pt_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).floating_pt_type.typecode; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(861);
				((Base_type_specContext)_localctx).integer_type = integer_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).integer_type.typecode; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(864);
				((Base_type_specContext)_localctx).char_type = char_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).char_type.typecode; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(867);
				((Base_type_specContext)_localctx).wide_char_type = wide_char_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).wide_char_type.typecode; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(870);
				((Base_type_specContext)_localctx).boolean_type = boolean_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).boolean_type.typecode; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(873);
				((Base_type_specContext)_localctx).octet_type = octet_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).octet_type.typecode; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(876);
				any_type();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(877);
				object_type();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(878);
				value_base_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Template_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Sequence_typeContext sequence_type;
		public Set_typeContext set_type;
		public Map_typeContext map_type;
		public String_typeContext string_type;
		public Wide_string_typeContext wide_string_type;
		public Sequence_typeContext sequence_type() {
			return getRuleContext(Sequence_typeContext.class,0);
		}
		public Set_typeContext set_type() {
			return getRuleContext(Set_typeContext.class,0);
		}
		public Map_typeContext map_type() {
			return getRuleContext(Map_typeContext.class,0);
		}
		public String_typeContext string_type() {
			return getRuleContext(String_typeContext.class,0);
		}
		public Wide_string_typeContext wide_string_type() {
			return getRuleContext(Wide_string_typeContext.class,0);
		}
		public Fixed_pt_typeContext fixed_pt_type() {
			return getRuleContext(Fixed_pt_typeContext.class,0);
		}
		public Template_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_type_spec; }
	}

	public final Template_type_specContext template_type_spec() throws RecognitionException {
		Template_type_specContext _localctx = new Template_type_specContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_template_type_spec);
		try {
			setState(897);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_SEQUENCE:
				enterOuterAlt(_localctx, 1);
				{
				setState(881);
				((Template_type_specContext)_localctx).sequence_type = sequence_type();
				 ((Template_type_specContext)_localctx).typecode = ((Template_type_specContext)_localctx).sequence_type.typecode; 
				}
				break;
			case KW_SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(884);
				((Template_type_specContext)_localctx).set_type = set_type();
				 ((Template_type_specContext)_localctx).typecode = ((Template_type_specContext)_localctx).set_type.typecode; 
				}
				break;
			case KW_MAP:
				enterOuterAlt(_localctx, 3);
				{
				setState(887);
				((Template_type_specContext)_localctx).map_type = map_type();
				 ((Template_type_specContext)_localctx).typecode = ((Template_type_specContext)_localctx).map_type.typecode; 
				}
				break;
			case KW_STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(890);
				((Template_type_specContext)_localctx).string_type = string_type();
				 ((Template_type_specContext)_localctx).typecode = ((Template_type_specContext)_localctx).string_type.typecode; 
				}
				break;
			case KW_WSTRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(893);
				((Template_type_specContext)_localctx).wide_string_type = wide_string_type();
				 ((Template_type_specContext)_localctx).typecode = ((Template_type_specContext)_localctx).wide_string_type.typecode; 
				}
				break;
			case KW_FIXED:
				enterOuterAlt(_localctx, 6);
				{
				setState(896);
				fixed_pt_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constr_type_specContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Enum_typeContext enum_type() {
			return getRuleContext(Enum_typeContext.class,0);
		}
		public Bitset_typeContext bitset_type() {
			return getRuleContext(Bitset_typeContext.class,0);
		}
		public Bitmask_typeContext bitmask_type() {
			return getRuleContext(Bitmask_typeContext.class,0);
		}
		public Constr_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr_type_spec; }
	}

	public final Constr_type_specContext constr_type_spec() throws RecognitionException {
		Constr_type_specContext _localctx = new Constr_type_specContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_constr_type_spec);
		try {
			setState(904);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_STRUCT:
				enterOuterAlt(_localctx, 1);
				{
				setState(899);
				struct_type();
				}
				break;
			case KW_UNION:
				enterOuterAlt(_localctx, 2);
				{
				setState(900);
				union_type(null);
				}
				break;
			case KW_ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(901);
				enum_type();
				}
				break;
			case KW_BITSET:
				enterOuterAlt(_localctx, 4);
				{
				setState(902);
				bitset_type();
				}
				break;
			case KW_BITMASK:
				enterOuterAlt(_localctx, 5);
				{
				setState(903);
				bitmask_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorsContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, ContainerTypeCode>> ret = new Vector<Pair<Pair<String, Token>, ContainerTypeCode>>();
		public DeclaratorContext declarator;
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public DeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarators; }
	}

	public final DeclaratorsContext declarators() throws RecognitionException {
		DeclaratorsContext _localctx = new DeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_declarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(906);
			((DeclaratorsContext)_localctx).declarator = declarator();

			            if(((DeclaratorsContext)_localctx).declarator.ret != null)
			                _localctx.ret.add(((DeclaratorsContext)_localctx).declarator.ret);
			            else
			                throw new ParseException(null, "Cannot parse type declarator");
			        
			setState(914);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(908);
				match(COMA);
				setState(909);
				((DeclaratorsContext)_localctx).declarator = declarator();

				            if(((DeclaratorsContext)_localctx).declarator.ret != null)
				                _localctx.ret.add(((DeclaratorsContext)_localctx).declarator.ret);
				            else
				                throw new ParseException(null, "Cannot parse type declarator");
				        
				}
				}
				setState(916);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_declaratorsContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, ContainerTypeCode>> ret = new Vector<Pair<Pair<String, Token>, ContainerTypeCode>>();
		public Simple_declaratorContext simple_declarator;
		public List<Simple_declaratorContext> simple_declarator() {
			return getRuleContexts(Simple_declaratorContext.class);
		}
		public Simple_declaratorContext simple_declarator(int i) {
			return getRuleContext(Simple_declaratorContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Simple_declaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_declarators; }
	}

	public final Simple_declaratorsContext simple_declarators() throws RecognitionException {
		Simple_declaratorsContext _localctx = new Simple_declaratorsContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_simple_declarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
			((Simple_declaratorsContext)_localctx).simple_declarator = simple_declarator();

			            if(((Simple_declaratorsContext)_localctx).simple_declarator.ret != null)
			                _localctx.ret.add(((Simple_declaratorsContext)_localctx).simple_declarator.ret);
			            else
			                throw new ParseException(null, "Cannot parse type declarator");
			        
			setState(925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(919);
				match(COMA);
				setState(920);
				((Simple_declaratorsContext)_localctx).simple_declarator = simple_declarator();

				            if(((Simple_declaratorsContext)_localctx).simple_declarator.ret != null)
				                _localctx.ret.add(((Simple_declaratorsContext)_localctx).simple_declarator.ret);
				            else
				                throw new ParseException(null, "Cannot parse type declarator");
				        
				}
				}
				setState(927);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends ParserRuleContext {
		public Pair<Pair<String, Token>, ContainerTypeCode> ret = null;
		public Simple_declaratorContext simple_declarator;
		public Complex_declaratorContext complex_declarator;
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Complex_declaratorContext complex_declarator() {
			return getRuleContext(Complex_declaratorContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_declarator);
		try {
			setState(934);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(928);
				((DeclaratorContext)_localctx).simple_declarator = simple_declarator();
				 ((DeclaratorContext)_localctx).ret = ((DeclaratorContext)_localctx).simple_declarator.ret; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(931);
				((DeclaratorContext)_localctx).complex_declarator = complex_declarator();
				 ((DeclaratorContext)_localctx).ret = ((DeclaratorContext)_localctx).complex_declarator.ret; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_declaratorContext extends ParserRuleContext {
		public Pair<Pair<String, Token>, ContainerTypeCode> ret = null;
		public IdentifierContext identifier;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Simple_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_declarator; }
	}

	public final Simple_declaratorContext simple_declarator() throws RecognitionException {
		Simple_declaratorContext _localctx = new Simple_declaratorContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_simple_declarator);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			((Simple_declaratorContext)_localctx).identifier = identifier();

			           Pair<String, Token> p = new Pair<String, Token>(((Simple_declaratorContext)_localctx).identifier.id, tk);
			           ((Simple_declaratorContext)_localctx).ret =  new Pair<Pair<String, Token>, ContainerTypeCode>(p, null);
			       
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Complex_declaratorContext extends ParserRuleContext {
		public Pair<Pair<String, Token>, ContainerTypeCode> ret = null;
		public Array_declaratorContext array_declarator;
		public Array_declaratorContext array_declarator() {
			return getRuleContext(Array_declaratorContext.class,0);
		}
		public Complex_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex_declarator; }
	}

	public final Complex_declaratorContext complex_declarator() throws RecognitionException {
		Complex_declaratorContext _localctx = new Complex_declaratorContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_complex_declarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			((Complex_declaratorContext)_localctx).array_declarator = array_declarator();
			 ((Complex_declaratorContext)_localctx).ret = ((Complex_declaratorContext)_localctx).array_declarator.pair; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Floating_pt_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public TerminalNode KW_FLOAT() { return getToken(IDLParser.KW_FLOAT, 0); }
		public TerminalNode KW_DOUBLE() { return getToken(IDLParser.KW_DOUBLE, 0); }
		public TerminalNode KW_LONG() { return getToken(IDLParser.KW_LONG, 0); }
		public Floating_pt_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floating_pt_type; }
	}

	public final Floating_pt_typeContext floating_pt_type() throws RecognitionException {
		Floating_pt_typeContext _localctx = new Floating_pt_typeContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_floating_pt_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_FLOAT:
				{
				setState(942);
				match(KW_FLOAT);
				 ((Floating_pt_typeContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_FLOAT);
				}
				break;
			case KW_DOUBLE:
				{
				setState(944);
				match(KW_DOUBLE);
				 ((Floating_pt_typeContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_DOUBLE);
				}
				break;
			case KW_LONG:
				{
				setState(946);
				match(KW_LONG);
				setState(947);
				match(KW_DOUBLE);
				 ((Floating_pt_typeContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_LONGDOUBLE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Integer_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Signed_intContext signed_int;
		public Unsigned_intContext unsigned_int;
		public Signed_intContext signed_int() {
			return getRuleContext(Signed_intContext.class,0);
		}
		public Unsigned_intContext unsigned_int() {
			return getRuleContext(Unsigned_intContext.class,0);
		}
		public Integer_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_type; }
	}

	public final Integer_typeContext integer_type() throws RecognitionException {
		Integer_typeContext _localctx = new Integer_typeContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_integer_type);
		try {
			setState(957);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_SHORT:
			case KW_LONG:
			case KW_INT8:
			case KW_INT16:
			case KW_INT32:
			case KW_INT64:
				enterOuterAlt(_localctx, 1);
				{
				setState(951);
				((Integer_typeContext)_localctx).signed_int = signed_int();
				 ((Integer_typeContext)_localctx).typecode =  ((Integer_typeContext)_localctx).signed_int.typecode; 
				}
				break;
			case KW_UNSIGNED:
			case KW_UINT8:
			case KW_UINT16:
			case KW_UINT32:
			case KW_UINT64:
				enterOuterAlt(_localctx, 2);
				{
				setState(954);
				((Integer_typeContext)_localctx).unsigned_int = unsigned_int();
				 ((Integer_typeContext)_localctx).typecode =  ((Integer_typeContext)_localctx).unsigned_int.typecode; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_intContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Signed_short_intContext signed_short_int;
		public Signed_long_intContext signed_long_int;
		public Signed_longlong_intContext signed_longlong_int;
		public Signed_tiny_intContext signed_tiny_int;
		public Signed_short_intContext signed_short_int() {
			return getRuleContext(Signed_short_intContext.class,0);
		}
		public Signed_long_intContext signed_long_int() {
			return getRuleContext(Signed_long_intContext.class,0);
		}
		public Signed_longlong_intContext signed_longlong_int() {
			return getRuleContext(Signed_longlong_intContext.class,0);
		}
		public Signed_tiny_intContext signed_tiny_int() {
			return getRuleContext(Signed_tiny_intContext.class,0);
		}
		public Signed_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_int; }
	}

	public final Signed_intContext signed_int() throws RecognitionException {
		Signed_intContext _localctx = new Signed_intContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_signed_int);
		try {
			setState(971);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(959);
				((Signed_intContext)_localctx).signed_short_int = signed_short_int();
				 ((Signed_intContext)_localctx).typecode =  ((Signed_intContext)_localctx).signed_short_int.typecode; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(962);
				((Signed_intContext)_localctx).signed_long_int = signed_long_int();
				 ((Signed_intContext)_localctx).typecode =  ((Signed_intContext)_localctx).signed_long_int.typecode; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(965);
				((Signed_intContext)_localctx).signed_longlong_int = signed_longlong_int();
				 ((Signed_intContext)_localctx).typecode =  ((Signed_intContext)_localctx).signed_longlong_int.typecode; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(968);
				((Signed_intContext)_localctx).signed_tiny_int = signed_tiny_int();
				 ((Signed_intContext)_localctx).typecode =  ((Signed_intContext)_localctx).signed_tiny_int.typecode; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_tiny_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_INT8() { return getToken(IDLParser.KW_INT8, 0); }
		public Signed_tiny_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_tiny_int; }
	}

	public final Signed_tiny_intContext signed_tiny_int() throws RecognitionException {
		Signed_tiny_intContext _localctx = new Signed_tiny_intContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_signed_tiny_int);

		    ((Signed_tiny_intContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_INT8);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(973);
			match(KW_INT8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_short_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_SHORT() { return getToken(IDLParser.KW_SHORT, 0); }
		public TerminalNode KW_INT16() { return getToken(IDLParser.KW_INT16, 0); }
		public Signed_short_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_short_int; }
	}

	public final Signed_short_intContext signed_short_int() throws RecognitionException {
		Signed_short_intContext _localctx = new Signed_short_intContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_signed_short_int);

		    ((Signed_short_intContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_SHORT);

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(975);
			_la = _input.LA(1);
			if ( !(_la==KW_SHORT || _la==KW_INT16) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_long_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_LONG() { return getToken(IDLParser.KW_LONG, 0); }
		public TerminalNode KW_INT32() { return getToken(IDLParser.KW_INT32, 0); }
		public Signed_long_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_long_int; }
	}

	public final Signed_long_intContext signed_long_int() throws RecognitionException {
		Signed_long_intContext _localctx = new Signed_long_intContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_signed_long_int);

		    ((Signed_long_intContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_LONG);

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(977);
			_la = _input.LA(1);
			if ( !(_la==KW_LONG || _la==KW_INT32) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_longlong_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public List<TerminalNode> KW_LONG() { return getTokens(IDLParser.KW_LONG); }
		public TerminalNode KW_LONG(int i) {
			return getToken(IDLParser.KW_LONG, i);
		}
		public TerminalNode KW_INT64() { return getToken(IDLParser.KW_INT64, 0); }
		public Signed_longlong_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_longlong_int; }
	}

	public final Signed_longlong_intContext signed_longlong_int() throws RecognitionException {
		Signed_longlong_intContext _localctx = new Signed_longlong_intContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_signed_longlong_int);

		    ((Signed_longlong_intContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_LONGLONG);

		try {
			setState(982);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_LONG:
				enterOuterAlt(_localctx, 1);
				{
				setState(979);
				match(KW_LONG);
				setState(980);
				match(KW_LONG);
				}
				break;
			case KW_INT64:
				enterOuterAlt(_localctx, 2);
				{
				setState(981);
				match(KW_INT64);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_intContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Unsigned_short_intContext unsigned_short_int;
		public Unsigned_long_intContext unsigned_long_int;
		public Unsigned_longlong_intContext unsigned_longlong_int;
		public Unsigned_tiny_intContext unsigned_tiny_int;
		public Unsigned_short_intContext unsigned_short_int() {
			return getRuleContext(Unsigned_short_intContext.class,0);
		}
		public Unsigned_long_intContext unsigned_long_int() {
			return getRuleContext(Unsigned_long_intContext.class,0);
		}
		public Unsigned_longlong_intContext unsigned_longlong_int() {
			return getRuleContext(Unsigned_longlong_intContext.class,0);
		}
		public Unsigned_tiny_intContext unsigned_tiny_int() {
			return getRuleContext(Unsigned_tiny_intContext.class,0);
		}
		public Unsigned_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_int; }
	}

	public final Unsigned_intContext unsigned_int() throws RecognitionException {
		Unsigned_intContext _localctx = new Unsigned_intContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_unsigned_int);
		try {
			setState(996);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(984);
				((Unsigned_intContext)_localctx).unsigned_short_int = unsigned_short_int();
				 ((Unsigned_intContext)_localctx).typecode =  ((Unsigned_intContext)_localctx).unsigned_short_int.typecode; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(987);
				((Unsigned_intContext)_localctx).unsigned_long_int = unsigned_long_int();
				 ((Unsigned_intContext)_localctx).typecode =  ((Unsigned_intContext)_localctx).unsigned_long_int.typecode; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(990);
				((Unsigned_intContext)_localctx).unsigned_longlong_int = unsigned_longlong_int();
				 ((Unsigned_intContext)_localctx).typecode =  ((Unsigned_intContext)_localctx).unsigned_longlong_int.typecode; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(993);
				((Unsigned_intContext)_localctx).unsigned_tiny_int = unsigned_tiny_int();
				 ((Unsigned_intContext)_localctx).typecode =  ((Unsigned_intContext)_localctx).unsigned_tiny_int.typecode; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_tiny_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_UINT8() { return getToken(IDLParser.KW_UINT8, 0); }
		public Unsigned_tiny_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_tiny_int; }
	}

	public final Unsigned_tiny_intContext unsigned_tiny_int() throws RecognitionException {
		Unsigned_tiny_intContext _localctx = new Unsigned_tiny_intContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_unsigned_tiny_int);

		    ((Unsigned_tiny_intContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_UINT8);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(998);
			match(KW_UINT8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_short_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_UNSIGNED() { return getToken(IDLParser.KW_UNSIGNED, 0); }
		public TerminalNode KW_SHORT() { return getToken(IDLParser.KW_SHORT, 0); }
		public TerminalNode KW_UINT16() { return getToken(IDLParser.KW_UINT16, 0); }
		public Unsigned_short_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_short_int; }
	}

	public final Unsigned_short_intContext unsigned_short_int() throws RecognitionException {
		Unsigned_short_intContext _localctx = new Unsigned_short_intContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_unsigned_short_int);

		    ((Unsigned_short_intContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_USHORT);

		try {
			setState(1003);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_UNSIGNED:
				enterOuterAlt(_localctx, 1);
				{
				setState(1000);
				match(KW_UNSIGNED);
				setState(1001);
				match(KW_SHORT);
				}
				break;
			case KW_UINT16:
				enterOuterAlt(_localctx, 2);
				{
				setState(1002);
				match(KW_UINT16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_long_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_UNSIGNED() { return getToken(IDLParser.KW_UNSIGNED, 0); }
		public TerminalNode KW_LONG() { return getToken(IDLParser.KW_LONG, 0); }
		public TerminalNode KW_UINT32() { return getToken(IDLParser.KW_UINT32, 0); }
		public Unsigned_long_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_long_int; }
	}

	public final Unsigned_long_intContext unsigned_long_int() throws RecognitionException {
		Unsigned_long_intContext _localctx = new Unsigned_long_intContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_unsigned_long_int);

		    ((Unsigned_long_intContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_ULONG);

		try {
			setState(1008);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_UNSIGNED:
				enterOuterAlt(_localctx, 1);
				{
				setState(1005);
				match(KW_UNSIGNED);
				setState(1006);
				match(KW_LONG);
				}
				break;
			case KW_UINT32:
				enterOuterAlt(_localctx, 2);
				{
				setState(1007);
				match(KW_UINT32);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_longlong_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_UNSIGNED() { return getToken(IDLParser.KW_UNSIGNED, 0); }
		public List<TerminalNode> KW_LONG() { return getTokens(IDLParser.KW_LONG); }
		public TerminalNode KW_LONG(int i) {
			return getToken(IDLParser.KW_LONG, i);
		}
		public TerminalNode KW_UINT64() { return getToken(IDLParser.KW_UINT64, 0); }
		public Unsigned_longlong_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_longlong_int; }
	}

	public final Unsigned_longlong_intContext unsigned_longlong_int() throws RecognitionException {
		Unsigned_longlong_intContext _localctx = new Unsigned_longlong_intContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_unsigned_longlong_int);

		    ((Unsigned_longlong_intContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_ULONGLONG);

		try {
			setState(1014);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_UNSIGNED:
				enterOuterAlt(_localctx, 1);
				{
				setState(1010);
				match(KW_UNSIGNED);
				setState(1011);
				match(KW_LONG);
				setState(1012);
				match(KW_LONG);
				}
				break;
			case KW_UINT64:
				enterOuterAlt(_localctx, 2);
				{
				setState(1013);
				match(KW_UINT64);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_typeContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_CHAR() { return getToken(IDLParser.KW_CHAR, 0); }
		public Char_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_type; }
	}

	public final Char_typeContext char_type() throws RecognitionException {
		Char_typeContext _localctx = new Char_typeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_char_type);

		    ((Char_typeContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_CHAR);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1016);
			match(KW_CHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Wide_char_typeContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_WCHAR() { return getToken(IDLParser.KW_WCHAR, 0); }
		public Wide_char_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wide_char_type; }
	}

	public final Wide_char_typeContext wide_char_type() throws RecognitionException {
		Wide_char_typeContext _localctx = new Wide_char_typeContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_wide_char_type);

		    ((Wide_char_typeContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_WCHAR);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1018);
			match(KW_WCHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_typeContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_BOOLEAN() { return getToken(IDLParser.KW_BOOLEAN, 0); }
		public Boolean_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_type; }
	}

	public final Boolean_typeContext boolean_type() throws RecognitionException {
		Boolean_typeContext _localctx = new Boolean_typeContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_boolean_type);

		    ((Boolean_typeContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_BOOLEAN);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1020);
			match(KW_BOOLEAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Octet_typeContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_OCTET() { return getToken(IDLParser.KW_OCTET, 0); }
		public Octet_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_octet_type; }
	}

	public final Octet_typeContext octet_type() throws RecognitionException {
		Octet_typeContext _localctx = new Octet_typeContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_octet_type);

		    ((Octet_typeContext)_localctx).typecode =  new PrimitiveTypeCode(Kind.KIND_OCTET);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1022);
			match(KW_OCTET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_typeContext extends ParserRuleContext {
		public TerminalNode KW_ANY() { return getToken(IDLParser.KW_ANY, 0); }
		public Any_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_type; }
	}

	public final Any_typeContext any_type() throws RecognitionException {
		Any_typeContext _localctx = new Any_typeContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_any_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1024);
			match(KW_ANY);
			throw new ParseException(tk, ". Any type is not supported"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Object_typeContext extends ParserRuleContext {
		public TerminalNode KW_OBJECT() { return getToken(IDLParser.KW_OBJECT, 0); }
		public Object_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_type; }
	}

	public final Object_typeContext object_type() throws RecognitionException {
		Object_typeContext _localctx = new Object_typeContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_object_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1027);
			match(KW_OBJECT);
			throw new ParseException(tk, ". Object type is not supported"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_declContext extends ParserRuleContext {
		public Pair<AnnotationDeclaration, TemplateGroup> returnPair = null;
		public Annotation_defContext annotation_def;
		public Annotation_defContext annotation_def() {
			return getRuleContext(Annotation_defContext.class,0);
		}
		public Annotation_forward_dclContext annotation_forward_dcl() {
			return getRuleContext(Annotation_forward_dclContext.class,0);
		}
		public Annotation_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_decl; }
	}

	public final Annotation_declContext annotation_decl() throws RecognitionException {
		Annotation_declContext _localctx = new Annotation_declContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_annotation_decl);
		try {
			setState(1034);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1030);
				((Annotation_declContext)_localctx).annotation_def = annotation_def();
				 ((Annotation_declContext)_localctx).returnPair = ((Annotation_declContext)_localctx).annotation_def.returnPair; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1033);
				annotation_forward_dcl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_defContext extends ParserRuleContext {
		public Pair<AnnotationDeclaration, TemplateGroup> returnPair = null;
		public Annotation_headerContext annotation_header;
		public Annotation_headerContext annotation_header() {
			return getRuleContext(Annotation_headerContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Annotation_bodyContext annotation_body() {
			return getRuleContext(Annotation_bodyContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Annotation_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_def; }
	}

	public final Annotation_defContext annotation_def() throws RecognitionException {
		Annotation_defContext _localctx = new Annotation_defContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_annotation_def);

		    TemplateGroup annotationTemplates = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1036);
			((Annotation_defContext)_localctx).annotation_header = annotation_header();
			setState(1037);
			match(LEFT_BRACE);
			setState(1038);
			annotation_body(((Annotation_defContext)_localctx).annotation_header.annotation);
			setState(1039);
			match(RIGHT_BRACE);

			        if(((Annotation_defContext)_localctx).annotation_header.annotation != null)
			        {
			            if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			            {
			                if(tmanager != null)
			                {
			                    annotationTemplates = tmanager.createTemplateGroup("annotation");
			                    annotationTemplates.setAttribute("ctx", ctx);
			                    // Set the annotation object to the TemplateGroup of the annotation.
			                    annotationTemplates.setAttribute("annotation", ((Annotation_defContext)_localctx).annotation_header.annotation);
			                }
			            }

			            ((Annotation_defContext)_localctx).returnPair =  new Pair<AnnotationDeclaration, TemplateGroup>(((Annotation_defContext)_localctx).annotation_header.annotation, annotationTemplates);
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_headerContext extends ParserRuleContext {
		public AnnotationDeclaration annotation = null;
		public IdentifierContext identifier;
		public TerminalNode KW_AT_ANNOTATION() { return getToken(IDLParser.KW_AT_ANNOTATION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Annotation_inheritance_specContext annotation_inheritance_spec() {
			return getRuleContext(Annotation_inheritance_specContext.class,0);
		}
		public Annotation_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_header; }
	}

	public final Annotation_headerContext annotation_header() throws RecognitionException {
		Annotation_headerContext _localctx = new Annotation_headerContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_annotation_header);

		    Token tk = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042);
			match(KW_AT_ANNOTATION);

			        tk = _input.LT(1);
			    
			setState(1044);
			((Annotation_headerContext)_localctx).identifier = identifier();
			 ((Annotation_headerContext)_localctx).annotation =  ctx.createAnnotationDeclaration(((Annotation_headerContext)_localctx).identifier.id, tk); 
			setState(1047);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1046);
				annotation_inheritance_spec(_localctx.annotation);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_inheritance_specContext extends ParserRuleContext {
		public AnnotationDeclaration annotation;
		public Scoped_nameContext scoped_name;
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Annotation_inheritance_specContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_inheritance_specContext(ParserRuleContext parent, int invokingState, AnnotationDeclaration annotation) {
			super(parent, invokingState);
			this.annotation = annotation;
		}
		@Override public int getRuleIndex() { return RULE_annotation_inheritance_spec; }
	}

	public final Annotation_inheritance_specContext annotation_inheritance_spec(AnnotationDeclaration annotation) throws RecognitionException {
		Annotation_inheritance_specContext _localctx = new Annotation_inheritance_specContext(_ctx, getState(), annotation);
		enterRule(_localctx, 154, RULE_annotation_inheritance_spec);

		    AnnotationDeclaration inhanno = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1049);
			match(COLON);
			setState(1050);
			((Annotation_inheritance_specContext)_localctx).scoped_name = scoped_name();

			        if(annotation != null)
			        {
			            inhanno = ctx.getAnnotationDeclaration(((Annotation_inheritance_specContext)_localctx).scoped_name.pair.first());

			            if(inhanno != null)
			            {
			                annotation.addMembers(inhanno);
			            }
			            else
			            {
			                System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Annotation " + ((Annotation_inheritance_specContext)_localctx).scoped_name.pair.first() + " not supported. Ignoring...");
			            }
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_bodyContext extends ParserRuleContext {
		public AnnotationDeclaration annotation;
		public List<Annotation_memberContext> annotation_member() {
			return getRuleContexts(Annotation_memberContext.class);
		}
		public Annotation_memberContext annotation_member(int i) {
			return getRuleContext(Annotation_memberContext.class,i);
		}
		public Annotation_bodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_bodyContext(ParserRuleContext parent, int invokingState, AnnotationDeclaration annotation) {
			super(parent, invokingState);
			this.annotation = annotation;
		}
		@Override public int getRuleIndex() { return RULE_annotation_body; }
	}

	public final Annotation_bodyContext annotation_body(AnnotationDeclaration annotation) throws RecognitionException {
		Annotation_bodyContext _localctx = new Annotation_bodyContext(_ctx, getState(), annotation);
		enterRule(_localctx, 156, RULE_annotation_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_OCTET) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_FIXED - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_INT8 - 64)) | (1L << (KW_UINT8 - 64)) | (1L << (KW_INT16 - 64)) | (1L << (KW_UINT16 - 64)) | (1L << (KW_INT32 - 64)) | (1L << (KW_UINT32 - 64)) | (1L << (KW_INT64 - 64)) | (1L << (KW_UINT64 - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1053);
				annotation_member(annotation);
				}
				}
				setState(1058);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_memberContext extends ParserRuleContext {
		public AnnotationDeclaration annotation;
		public Const_typeContext const_type;
		public Simple_declaratorContext simple_declarator;
		public Const_expContext const_exp;
		public Const_typeContext const_type() {
			return getRuleContext(Const_typeContext.class,0);
		}
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public TerminalNode KW_DEFAULT() { return getToken(IDLParser.KW_DEFAULT, 0); }
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public Annotation_memberContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_memberContext(ParserRuleContext parent, int invokingState, AnnotationDeclaration annotation) {
			super(parent, invokingState);
			this.annotation = annotation;
		}
		@Override public int getRuleIndex() { return RULE_annotation_member; }
	}

	public final Annotation_memberContext annotation_member(AnnotationDeclaration annotation) throws RecognitionException {
		Annotation_memberContext _localctx = new Annotation_memberContext(_ctx, getState(), annotation);
		enterRule(_localctx, 158, RULE_annotation_member);

		    String literalStr = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059);
			((Annotation_memberContext)_localctx).const_type = const_type();
			setState(1060);
			((Annotation_memberContext)_localctx).simple_declarator = simple_declarator();
			setState(1065);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_DEFAULT) {
				{
				setState(1061);
				match(KW_DEFAULT);
				setState(1062);
				((Annotation_memberContext)_localctx).const_exp = const_exp();
				 literalStr=((Annotation_memberContext)_localctx).const_exp.literalStr; 
				}
			}

			setState(1067);
			match(SEMICOLON);

			        if(!_localctx.annotation.addMember(new AnnotationMember(((Annotation_memberContext)_localctx).simple_declarator.ret.first().first(), ((Annotation_memberContext)_localctx).const_type.typecode, literalStr)))
			        {
			            throw new ParseException(((Annotation_memberContext)_localctx).simple_declarator.ret.first().second(), "was defined previously");
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_forward_dclContext extends ParserRuleContext {
		public TerminalNode KW_AT_ANNOTATION() { return getToken(IDLParser.KW_AT_ANNOTATION, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Annotation_forward_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_forward_dcl; }
	}

	public final Annotation_forward_dclContext annotation_forward_dcl() throws RecognitionException {
		Annotation_forward_dclContext _localctx = new Annotation_forward_dclContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_annotation_forward_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1070);
			match(KW_AT_ANNOTATION);
			setState(1071);
			scoped_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bitset_typeContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public Scoped_nameContext scoped_name;
		public TerminalNode KW_BITSET() { return getToken(IDLParser.KW_BITSET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public BitfieldContext bitfield() {
			return getRuleContext(BitfieldContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Bitset_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitset_type; }
	}

	public final Bitset_typeContext bitset_type() throws RecognitionException {
		Bitset_typeContext _localctx = new Bitset_typeContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_bitset_type);

		    String name = null;
		    Vector<TypeCode> vector = null;
		    BitsetTypeCode typecode = null;
		    BitsetTypeCode superType = null;
		    TemplateGroup bitsetTemplates = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1073);
			match(KW_BITSET);
			setState(1074);
			((Bitset_typeContext)_localctx).identifier = identifier();

			           name=((Bitset_typeContext)_localctx).identifier.id;
			           typecode = ctx.createBitsetTypeCode(name);
			        
			setState(1080);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1076);
				match(COLON);
				setState(1077);
				((Bitset_typeContext)_localctx).scoped_name = scoped_name();

				                TypeCode scopedType = ctx.getTypeCode(((Bitset_typeContext)_localctx).scoped_name.pair.first());
				                if (scopedType instanceof BitsetTypeCode)
				                {
				                    superType = (BitsetTypeCode)scopedType;
				                }
				                else
				                {
				                    System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Bitset only can inherit from other bitsets.");
				                }
				            
				}
			}

			setState(1082);
			match(LEFT_BRACE);
			setState(1083);
			bitfield(typecode);
			setState(1084);
			match(RIGHT_BRACE);

			            if (superType != null) typecode.addParent(superType);

			            if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			            {
			                if(tmanager != null) {
			                    bitsetTemplates = tmanager.createTemplateGroup("bitset_type");
			                    bitsetTemplates.setAttribute("ctx", ctx);
			                    bitsetTemplates.setAttribute("bitset", typecode);
			                }
			            }

			            // Return the returned data.
			            vector = new Vector<TypeCode>();
			            vector.add(typecode);
			            ((Bitset_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, bitsetTemplates);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitfieldContext extends ParserRuleContext {
		public BitsetTypeCode owner;
		public Bitfield_specContext bitfield_spec;
		public Simple_declaratorsContext simple_declarators;
		public List<Bitfield_specContext> bitfield_spec() {
			return getRuleContexts(Bitfield_specContext.class);
		}
		public Bitfield_specContext bitfield_spec(int i) {
			return getRuleContext(Bitfield_specContext.class,i);
		}
		public List<Simple_declaratorsContext> simple_declarators() {
			return getRuleContexts(Simple_declaratorsContext.class);
		}
		public Simple_declaratorsContext simple_declarators(int i) {
			return getRuleContext(Simple_declaratorsContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(IDLParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(IDLParser.SEMICOLON, i);
		}
		public BitfieldContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BitfieldContext(ParserRuleContext parent, int invokingState, BitsetTypeCode owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_bitfield; }
	}

	public final BitfieldContext bitfield(BitsetTypeCode owner) throws RecognitionException {
		BitfieldContext _localctx = new BitfieldContext(_ctx, getState(), owner);
		enterRule(_localctx, 164, RULE_bitfield);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1096); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(1096);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					{
					setState(1087);
					((BitfieldContext)_localctx).bitfield_spec = bitfield_spec();
					setState(1088);
					((BitfieldContext)_localctx).simple_declarators = simple_declarators();
					setState(1089);
					match(SEMICOLON);

					                    if(((BitfieldContext)_localctx).bitfield_spec.bitfieldType != null)
					                    {
					                        for(int count = 0; count < ((BitfieldContext)_localctx).simple_declarators.ret.size(); ++count)
					                        {
					                            Bitfield bitfield = null;

					                            // Only simple declaration
					                            bitfield = new Bitfield(_localctx.owner, ((BitfieldContext)_localctx).bitfield_spec.bitfieldType, ((BitfieldContext)_localctx).simple_declarators.ret.get(count).first().first());

					                            _localctx.owner.addBitfield(bitfield);

					                            if(!_localctx.owner.addMember(bitfield))
					                                throw new ParseException(((BitfieldContext)_localctx).simple_declarators.ret.get(count).first().second(), " was defined previously");
					                        }
					                    }
					                
					}
					}
					break;
				case 2:
					{
					{
					setState(1092);
					((BitfieldContext)_localctx).bitfield_spec = bitfield_spec();
					setState(1093);
					match(SEMICOLON);

					                    if(((BitfieldContext)_localctx).bitfield_spec.bitfieldType != null)
					                    {
					                        Bitfield bitfield = null;

					                        // Only simple declaration
					                        bitfield = new Bitfield(_localctx.owner, ((BitfieldContext)_localctx).bitfield_spec.bitfieldType, "");

					                        _localctx.owner.addBitfield(bitfield);

					                        if(!_localctx.owner.addMember(bitfield))
					                            System.out.println("Empty space failed to be inserted.");
					                    }
					                
					}
					}
					break;
				}
				}
				setState(1098); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KW_BITFIELD );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bitfield_specContext extends ParserRuleContext {
		public BitfieldSpec bitfieldType = null;
		public Positive_int_constContext positive_int_const;
		public Bitfield_type_specContext bitfield_type_spec;
		public TerminalNode KW_BITFIELD() { return getToken(IDLParser.KW_BITFIELD, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public TerminalNode COMA() { return getToken(IDLParser.COMA, 0); }
		public Bitfield_type_specContext bitfield_type_spec() {
			return getRuleContext(Bitfield_type_specContext.class,0);
		}
		public Bitfield_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitfield_spec; }
	}

	public final Bitfield_specContext bitfield_spec() throws RecognitionException {
		Bitfield_specContext _localctx = new Bitfield_specContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_bitfield_spec);

		    TypeCode type = null;
		    String bitsize = null;

		try {
			setState(1117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1100);
				match(KW_BITFIELD);
				setState(1101);
				match(LEFT_ANG_BRACKET);
				setState(1102);
				((Bitfield_specContext)_localctx).positive_int_const = positive_int_const();
				 bitsize=((Bitfield_specContext)_localctx).positive_int_const.literalStr; 
				setState(1104);
				match(RIGHT_ANG_BRACKET);

				            ((Bitfield_specContext)_localctx).bitfieldType =  ctx.createBitfieldSpec(bitsize, null);
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1107);
				match(KW_BITFIELD);
				setState(1108);
				match(LEFT_ANG_BRACKET);
				setState(1109);
				((Bitfield_specContext)_localctx).positive_int_const = positive_int_const();
				 bitsize=((Bitfield_specContext)_localctx).positive_int_const.literalStr; 
				setState(1111);
				match(COMA);
				setState(1112);
				((Bitfield_specContext)_localctx).bitfield_type_spec = bitfield_type_spec();
				 type=((Bitfield_specContext)_localctx).bitfield_type_spec.typecode; 
				setState(1114);
				match(RIGHT_ANG_BRACKET);

				            ((Bitfield_specContext)_localctx).bitfieldType =  ctx.createBitfieldSpec(bitsize, type);
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bitmask_typeContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public TerminalNode KW_BITMASK() { return getToken(IDLParser.KW_BITMASK, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Bit_valuesContext bit_values() {
			return getRuleContext(Bit_valuesContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Bitmask_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitmask_type; }
	}

	public final Bitmask_typeContext bitmask_type() throws RecognitionException {
		Bitmask_typeContext _localctx = new Bitmask_typeContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_bitmask_type);

		    String name = null;
		    Vector<TypeCode> vector = null;
		    BitmaskTypeCode typecode = null;
		    TemplateGroup bitmaskTemplates = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119);
			match(KW_BITMASK);
			setState(1120);
			((Bitmask_typeContext)_localctx).identifier = identifier();

			           name=((Bitmask_typeContext)_localctx).identifier.id;
			           typecode = ctx.createBitmaskTypeCode(name);
			        
			setState(1122);
			match(LEFT_BRACE);
			setState(1123);
			bit_values(typecode);
			setState(1124);
			match(RIGHT_BRACE);

			            if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			            {
			                if(tmanager != null) {
			                    bitmaskTemplates = tmanager.createTemplateGroup("bitmask_type");
			                    bitmaskTemplates.setAttribute("ctx", ctx);
			                    bitmaskTemplates.setAttribute("bitmask", typecode);
			                }
			            }

			            // Return the returned data.
			            vector = new Vector<TypeCode>();
			            vector.add(typecode);
			            ((Bitmask_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, bitmaskTemplates);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bit_valuesContext extends ParserRuleContext {
		public BitmaskTypeCode owner;
		public Annotation_applContext annotation_appl;
		public IdentifierContext identifier;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<Annotation_applContext> annotation_appl() {
			return getRuleContexts(Annotation_applContext.class);
		}
		public Annotation_applContext annotation_appl(int i) {
			return getRuleContext(Annotation_applContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Bit_valuesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Bit_valuesContext(ParserRuleContext parent, int invokingState, BitmaskTypeCode owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_bit_values; }
	}

	public final Bit_valuesContext bit_values(BitmaskTypeCode owner) throws RecognitionException {
		Bit_valuesContext _localctx = new Bit_valuesContext(_ctx, getState(), owner);
		enterRule(_localctx, 170, RULE_bit_values);

		    Vector<Annotation> annots = new Vector<Annotation>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1127);
				((Bit_valuesContext)_localctx).annotation_appl = annotation_appl();
				 annots.add(((Bit_valuesContext)_localctx).annotation_appl.annotation); 
				}
				}
				setState(1134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1135);
			((Bit_valuesContext)_localctx).identifier = identifier();

			            Bitmask bitmask_f = new Bitmask(owner, ((Bit_valuesContext)_localctx).identifier.id);
			            for (Annotation ann : annots)
			            {
			                bitmask_f.addAnnotation(ctx, ann);
			            }
			            owner.addBitmask(bitmask_f);
			            annots = new Vector<Annotation>();
			        
			setState(1151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1137);
				match(COMA);
				setState(1143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(1138);
					((Bit_valuesContext)_localctx).annotation_appl = annotation_appl();
					 annots.add(((Bit_valuesContext)_localctx).annotation_appl.annotation); 
					}
					}
					setState(1145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1146);
				((Bit_valuesContext)_localctx).identifier = identifier();

				                Bitmask bitmask_o = new Bitmask(owner, ((Bit_valuesContext)_localctx).identifier.id);
				                for (Annotation ann : annots)
				                {
				                    bitmask_o.addAnnotation(ctx, ann);
				                }
				                owner.addBitmask(bitmask_o);
				                annots = new Vector<Annotation>();
				            
				}
				}
				setState(1153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_typeContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public String fw_name = null;
		public IdentifierContext identifier;
		public Scoped_nameContext scoped_name;
		public TerminalNode KW_STRUCT() { return getToken(IDLParser.KW_STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Member_listContext member_list() {
			return getRuleContext(Member_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Struct_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_type; }
	}

	public final Struct_typeContext struct_type() throws RecognitionException {
		Struct_typeContext _localctx = new Struct_typeContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_struct_type);

		    String name = null;
		    Vector<TypeCode> vector = null;
		    StructTypeCode structTP = null;
		    StructTypeCode parentStruct = null;
		    TemplateGroup structTemplates = null;
		    Boolean fw_declaration = false;

		int _la;
		try {
			setState(1172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1154);
				match(KW_STRUCT);
				setState(1155);
				((Struct_typeContext)_localctx).identifier = identifier();

				            name=((Struct_typeContext)_localctx).identifier.id;

				            // Find typecode in the global map.
				            TypeCode typecode = ctx.getTypeCode(name);

				            if(typecode != null)
				            {
				                if (typecode instanceof StructTypeCode)
				                {
				                    fw_declaration = true;
				                    structTP = (StructTypeCode)typecode;
				                }
				                else
				                {
				                    System.out.println("ERROR (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Identifier already used.");
				                }
				            }
				            else
				            {
				                structTP = ctx.createStructTypeCode(name);
				            }
				        
				setState(1161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1157);
					match(COLON);
					setState(1158);
					((Struct_typeContext)_localctx).scoped_name = scoped_name();

					                TypeCode scopedType = ctx.getTypeCode(((Struct_typeContext)_localctx).scoped_name.pair.first());
					                if (scopedType instanceof StructTypeCode)
					                {
					                    parentStruct = (StructTypeCode)scopedType;
					                }
					                else
					                {
					                    System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Structs only can inherit from other structs.");
					                }
					            
					}
				}

				setState(1163);
				match(LEFT_BRACE);
				setState(1164);
				member_list(structTP);
				setState(1165);
				match(RIGHT_BRACE);

				            if (!fw_declaration)
				            {
				                if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
				                {
				                    if(tmanager != null) {
				                        structTemplates = tmanager.createTemplateGroup("struct_type");
				                        structTemplates.setAttribute("ctx", ctx);
				                        structTemplates.setAttribute("struct", structTP);
				                    }
				                }
				                // Return the returned data.
				                vector = new Vector<TypeCode>();
				                vector.add(structTP);
				                if (parentStruct != null)
				                {
				                    structTP.addInheritance(ctx, parentStruct);
				                }
				                ((Struct_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, structTemplates);
				                ((Struct_typeContext)_localctx).fw_name =  null;
				            }
				            else
				            {
				                ((Struct_typeContext)_localctx).returnPair =  null;
				                ((Struct_typeContext)_localctx).fw_name =  name;
				            }
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1168);
				match(KW_STRUCT);
				setState(1169);
				((Struct_typeContext)_localctx).identifier = identifier();

				            name=((Struct_typeContext)_localctx).identifier.id;
				            structTP = ctx.createStructTypeCode(name);
				            if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
				            {
				                if(tmanager != null) {
				                    structTemplates = tmanager.createTemplateGroup("struct_type");
				                    structTemplates.setAttribute("ctx", ctx);
				                    structTemplates.setAttribute("struct", structTP);
				                }
				            }
				            // Return the returned data.
				            vector = new Vector<TypeCode>();
				            vector.add(structTP);
				            ((Struct_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, structTemplates);
				            ((Struct_typeContext)_localctx).fw_name =  null;
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_listContext extends ParserRuleContext {
		public StructTypeCode structTP;
		public Member_defContext member_def;
		public List<Member_defContext> member_def() {
			return getRuleContexts(Member_defContext.class);
		}
		public Member_defContext member_def(int i) {
			return getRuleContext(Member_defContext.class,i);
		}
		public Member_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Member_listContext(ParserRuleContext parent, int invokingState, StructTypeCode structTP) {
			super(parent, invokingState);
			this.structTP = structTP;
		}
		@Override public int getRuleIndex() { return RULE_member_list; }
	}

	public final Member_listContext member_list(StructTypeCode structTP) throws RecognitionException {
		Member_listContext _localctx = new Member_listContext(_ctx, getState(), structTP);
		enterRule(_localctx, 174, RULE_member_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_OCTET) | (1L << KW_SEQUENCE) | (1L << KW_STRUCT) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_FIXED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_SET - 64)) | (1L << (KW_MAP - 64)) | (1L << (KW_BITSET - 64)) | (1L << (KW_BITMASK - 64)) | (1L << (KW_INT8 - 64)) | (1L << (KW_UINT8 - 64)) | (1L << (KW_INT16 - 64)) | (1L << (KW_UINT16 - 64)) | (1L << (KW_INT32 - 64)) | (1L << (KW_UINT32 - 64)) | (1L << (KW_INT64 - 64)) | (1L << (KW_UINT64 - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1174);
				((Member_listContext)_localctx).member_def = member_def(structTP);

				               if(((Member_listContext)_localctx).member_def.ret != null)
				               {
				                   for(Pair<Pair<String, Token>, Member> pair : ((Member_listContext)_localctx).member_def.ret)
				                   {
				                       if(!_localctx.structTP.addMember(pair.second()))
				                           throw new ParseException(pair.first().second(), "was defined previously");
				                   }
				               }
				           
				}
				}
				setState(1181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_defContext extends ParserRuleContext {
		public StructTypeCode structTP;
		public Vector<Pair<Pair<String, Token>, Member>> ret = null;
		public MemberContext member;
		public Annotation_applContext annotation_appl;
		public Member_defContext defret;
		public MemberContext member() {
			return getRuleContext(MemberContext.class,0);
		}
		public Annotation_applContext annotation_appl() {
			return getRuleContext(Annotation_applContext.class,0);
		}
		public Member_defContext member_def() {
			return getRuleContext(Member_defContext.class,0);
		}
		public Member_defContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Member_defContext(ParserRuleContext parent, int invokingState, StructTypeCode structTP) {
			super(parent, invokingState);
			this.structTP = structTP;
		}
		@Override public int getRuleIndex() { return RULE_member_def; }
	}

	public final Member_defContext member_def(StructTypeCode structTP) throws RecognitionException {
		Member_defContext _localctx = new Member_defContext(_ctx, getState(), structTP);
		enterRule(_localctx, 176, RULE_member_def);
		try {
			setState(1189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_OCTET:
			case KW_SEQUENCE:
			case KW_STRUCT:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_ENUM:
			case KW_WSTRING:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_FIXED:
			case KW_UNION:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_SET:
			case KW_MAP:
			case KW_BITSET:
			case KW_BITMASK:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1182);
				((Member_defContext)_localctx).member = member(structTP);
				 ((Member_defContext)_localctx).ret = ((Member_defContext)_localctx).member.ret; 
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1185);
				((Member_defContext)_localctx).annotation_appl = annotation_appl();
				setState(1186);
				((Member_defContext)_localctx).defret = member_def(structTP);

				            if(((Member_defContext)_localctx).defret.ret != null)
				            {
				                ((Member_defContext)_localctx).ret = ((Member_defContext)_localctx).defret.ret;

				                for(Pair<Pair<String, Token>, Member> pair : _localctx.ret)
				                {
				                    if(pair.second() != null)
				                        pair.second().addAnnotation(ctx, ((Member_defContext)_localctx).annotation_appl.annotation);
				                }
				            }
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberContext extends ParserRuleContext {
		public StructTypeCode structTP;
		public Vector<Pair<Pair<String, Token>, Member>> ret = new Vector<Pair<Pair<String, Token>, Member>>();
		public Type_specContext type_spec;
		public DeclaratorsContext declarators;
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public DeclaratorsContext declarators() {
			return getRuleContext(DeclaratorsContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public MemberContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public MemberContext(ParserRuleContext parent, int invokingState, StructTypeCode structTP) {
			super(parent, invokingState);
			this.structTP = structTP;
		}
		@Override public int getRuleIndex() { return RULE_member; }
	}

	public final MemberContext member(StructTypeCode structTP) throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState(), structTP);
		enterRule(_localctx, 178, RULE_member);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1191);
			((MemberContext)_localctx).type_spec = type_spec();
			setState(1192);
			((MemberContext)_localctx).declarators = declarators();
			setState(1193);
			match(SEMICOLON);

			            /*
			            if (structTP != null)
			            {
			                System.out.println("Pertenezco a " + structTP.getName());
			            }*/

			            if(((MemberContext)_localctx).type_spec.typecode!=null)
			            {
			                for(int count = 0; count < ((MemberContext)_localctx).declarators.ret.size(); ++count)
			                {
			                    Member member = null;

			                    if(((MemberContext)_localctx).declarators.ret.get(count).second() != null)
			                    {
			                        // Array declaration
			                        ((MemberContext)_localctx).declarators.ret.get(count).second().setContentTypeCode(((MemberContext)_localctx).type_spec.typecode);
			                        member = new Member(((MemberContext)_localctx).declarators.ret.get(count).second(), ((MemberContext)_localctx).declarators.ret.get(count).first().first());

			                    }
			                    else
			                    {
			                        // Simple declaration
			                        member = new Member(((MemberContext)_localctx).type_spec.typecode, ((MemberContext)_localctx).declarators.ret.get(count).first().first());
			                    }

			                    _localctx.ret.add(new Pair<Pair<String, Token>, Member>(((MemberContext)_localctx).declarators.ret.get(count).first(), member));
			                }
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Union_typeContext extends ParserRuleContext {
		public ArrayList<Definition> defs;
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public String fw_name = null;
		public IdentifierContext identifier;
		public Switch_type_specContext switch_type_spec;
		public TerminalNode KW_UNION() { return getToken(IDLParser.KW_UNION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode KW_SWITCH() { return getToken(IDLParser.KW_SWITCH, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public Switch_type_specContext switch_type_spec() {
			return getRuleContext(Switch_type_specContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Switch_bodyContext switch_body() {
			return getRuleContext(Switch_bodyContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Union_typeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Union_typeContext(ParserRuleContext parent, int invokingState, ArrayList<Definition> defs) {
			super(parent, invokingState);
			this.defs = defs;
		}
		@Override public int getRuleIndex() { return RULE_union_type; }
	}

	public final Union_typeContext union_type(ArrayList<Definition> defs) throws RecognitionException {
		Union_typeContext _localctx = new Union_typeContext(_ctx, getState(), defs);
		enterRule(_localctx, 180, RULE_union_type);

		    String name = null;
		    int line = 0;
		    TypeCode dist_type = null;
		    Vector<TypeCode> vector = null;
		    UnionTypeCode unionTP = null;
		    TemplateGroup unionTemplates = null;
		    Boolean fw_decl = false;

		try {
			setState(1214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1196);
				match(KW_UNION);
				setState(1197);
				((Union_typeContext)_localctx).identifier = identifier();

				            name=((Union_typeContext)_localctx).identifier.id;

				            // Find typecode in the global map.
				            TypeCode typecode = ctx.getTypeCode(name);

				            if(typecode != null)
				            {
				                if (typecode instanceof UnionTypeCode)
				                {
				                    fw_decl = true;
				                    unionTP = (UnionTypeCode)typecode;
				                }
				                else
				                {
				                    System.out.println("ERROR (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Identifier already used.");
				                }
				            }
				        
				setState(1199);
				match(KW_SWITCH);
				setState(1200);
				match(LEFT_BRACKET);
				setState(1201);
				((Union_typeContext)_localctx).switch_type_spec = switch_type_spec();
				 dist_type=((Union_typeContext)_localctx).switch_type_spec.typecode; 
				setState(1203);
				match(RIGHT_BRACKET);

				            // TODO Check supported types for discriminator: long, enumeration, etc...
				            if (fw_decl)
				            {
				                unionTP.setDiscriminatorType(dist_type);
				            }
				            else
				            {
				                unionTP = new UnionTypeCode(ctx.getScope(), name, dist_type);
				            }
				            line= _input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : 1;
				        
				setState(1205);
				match(LEFT_BRACE);
				setState(1206);
				switch_body(unionTP);
				setState(1207);
				match(RIGHT_BRACE);

				            if (!fw_decl)
				            {
				                // Calculate default label.
				                TemplateUtil.setUnionDefaultLabel(defs, unionTP, ctx.getScopeFile(), line);

				                if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
				                {
				                    if(tmanager != null) {
				                        unionTemplates = tmanager.createTemplateGroup("union_type");
				                        unionTemplates.setAttribute("ctx", ctx);
				                        unionTemplates.setAttribute("union", unionTP);
				                    }
				                }

				                // Return the returned data.
				                vector = new Vector<TypeCode>();
				                vector.add(unionTP);
				                ((Union_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, unionTemplates);
				                ((Union_typeContext)_localctx).fw_name =  null;
				            }
				            else
				            {
				                ((Union_typeContext)_localctx).returnPair =  null;
				                ((Union_typeContext)_localctx).fw_name =  name;
				            }
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1210);
				match(KW_UNION);
				setState(1211);
				((Union_typeContext)_localctx).identifier = identifier();

				            name=((Union_typeContext)_localctx).identifier.id;
				            // TODO Check supported types for discriminator: long, enumeration, etc...
				            unionTP = new UnionTypeCode(ctx.getScope(), name);
				            line= _input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : 1;
				            // Calculate default label.
				            TemplateUtil.setUnionDefaultLabel(defs, unionTP, ctx.getScopeFile(), line);

				            if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
				            {
				                if(tmanager != null) {
				                    unionTemplates = tmanager.createTemplateGroup("union_type");
				                    unionTemplates.setAttribute("ctx", ctx);
				                    unionTemplates.setAttribute("union", unionTP);
				                }
				            }

				            // Return the returned data.
				            vector = new Vector<TypeCode>();
				            vector.add(unionTP);
				            ((Union_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, unionTemplates);
				            ((Union_typeContext)_localctx).fw_name =  null;

				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Switch_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Integer_typeContext integer_type;
		public Char_typeContext char_type;
		public Wide_char_typeContext wide_char_type;
		public Octet_typeContext octet_type;
		public Boolean_typeContext boolean_type;
		public Scoped_nameContext scoped_name;
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Char_typeContext char_type() {
			return getRuleContext(Char_typeContext.class,0);
		}
		public Wide_char_typeContext wide_char_type() {
			return getRuleContext(Wide_char_typeContext.class,0);
		}
		public Octet_typeContext octet_type() {
			return getRuleContext(Octet_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public Enum_typeContext enum_type() {
			return getRuleContext(Enum_typeContext.class,0);
		}
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Switch_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_type_spec; }
	}

	public final Switch_type_specContext switch_type_spec() throws RecognitionException {
		Switch_type_specContext _localctx = new Switch_type_specContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_switch_type_spec);

		    Pair<String, Token> pair = null;

		try {
			setState(1235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_SHORT:
			case KW_LONG:
			case KW_UNSIGNED:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
				enterOuterAlt(_localctx, 1);
				{
				setState(1216);
				((Switch_type_specContext)_localctx).integer_type = integer_type();
				 ((Switch_type_specContext)_localctx).typecode = ((Switch_type_specContext)_localctx).integer_type.typecode; 
				}
				break;
			case KW_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1219);
				((Switch_type_specContext)_localctx).char_type = char_type();
				 ((Switch_type_specContext)_localctx).typecode = ((Switch_type_specContext)_localctx).char_type.typecode; 
				}
				break;
			case KW_WCHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1222);
				((Switch_type_specContext)_localctx).wide_char_type = wide_char_type();
				 ((Switch_type_specContext)_localctx).typecode =  ((Switch_type_specContext)_localctx).wide_char_type.typecode; 
				}
				break;
			case KW_OCTET:
				enterOuterAlt(_localctx, 4);
				{
				setState(1225);
				((Switch_type_specContext)_localctx).octet_type = octet_type();
				 ((Switch_type_specContext)_localctx).typecode = ((Switch_type_specContext)_localctx).octet_type.typecode; 
				}
				break;
			case KW_BOOLEAN:
				enterOuterAlt(_localctx, 5);
				{
				setState(1228);
				((Switch_type_specContext)_localctx).boolean_type = boolean_type();
				 ((Switch_type_specContext)_localctx).typecode = ((Switch_type_specContext)_localctx).boolean_type.typecode; 
				}
				break;
			case KW_ENUM:
				enterOuterAlt(_localctx, 6);
				{
				setState(1231);
				enum_type();
				}
				break;
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(1232);
				((Switch_type_specContext)_localctx).scoped_name = scoped_name();

				           pair=((Switch_type_specContext)_localctx).scoped_name.pair;
				           // Find typecode in the global map.
				           ((Switch_type_specContext)_localctx).typecode =  ctx.getTypeCode(pair.first());
				           if(_localctx.typecode == null)
				               throw new ParseException(pair.second(), "was not defined previously");
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Switch_bodyContext extends ParserRuleContext {
		public UnionTypeCode unionTP;
		public Case_stmt_listContext case_stmt_list() {
			return getRuleContext(Case_stmt_listContext.class,0);
		}
		public Switch_bodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Switch_bodyContext(ParserRuleContext parent, int invokingState, UnionTypeCode unionTP) {
			super(parent, invokingState);
			this.unionTP = unionTP;
		}
		@Override public int getRuleIndex() { return RULE_switch_body; }
	}

	public final Switch_bodyContext switch_body(UnionTypeCode unionTP) throws RecognitionException {
		Switch_bodyContext _localctx = new Switch_bodyContext(_ctx, getState(), unionTP);
		enterRule(_localctx, 184, RULE_switch_body);


		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1237);
			case_stmt_list(unionTP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_stmt_listContext extends ParserRuleContext {
		public UnionTypeCode unionTP;
		public List<Case_stmtContext> case_stmt() {
			return getRuleContexts(Case_stmtContext.class);
		}
		public Case_stmtContext case_stmt(int i) {
			return getRuleContext(Case_stmtContext.class,i);
		}
		public Case_stmt_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Case_stmt_listContext(ParserRuleContext parent, int invokingState, UnionTypeCode unionTP) {
			super(parent, invokingState);
			this.unionTP = unionTP;
		}
		@Override public int getRuleIndex() { return RULE_case_stmt_list; }
	}

	public final Case_stmt_listContext case_stmt_list(UnionTypeCode unionTP) throws RecognitionException {
		Case_stmt_listContext _localctx = new Case_stmt_listContext(_ctx, getState(), unionTP);
		enterRule(_localctx, 186, RULE_case_stmt_list);


		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1240); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1239);
				case_stmt(unionTP);
				}
				}
				setState(1242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KW_DEFAULT || _la==KW_CASE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_stmtContext extends ParserRuleContext {
		public UnionTypeCode unionTP;
		public Const_expContext const_exp;
		public Element_specContext element_spec;
		public Element_specContext element_spec() {
			return getRuleContext(Element_specContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public List<TerminalNode> KW_CASE() { return getTokens(IDLParser.KW_CASE); }
		public TerminalNode KW_CASE(int i) {
			return getToken(IDLParser.KW_CASE, i);
		}
		public List<Const_expContext> const_exp() {
			return getRuleContexts(Const_expContext.class);
		}
		public Const_expContext const_exp(int i) {
			return getRuleContext(Const_expContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(IDLParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(IDLParser.COLON, i);
		}
		public List<TerminalNode> KW_DEFAULT() { return getTokens(IDLParser.KW_DEFAULT); }
		public TerminalNode KW_DEFAULT(int i) {
			return getToken(IDLParser.KW_DEFAULT, i);
		}
		public Case_stmtContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Case_stmtContext(ParserRuleContext parent, int invokingState, UnionTypeCode unionTP) {
			super(parent, invokingState);
			this.unionTP = unionTP;
		}
		@Override public int getRuleIndex() { return RULE_case_stmt; }
	}

	public final Case_stmtContext case_stmt(UnionTypeCode unionTP) throws RecognitionException {
		Case_stmtContext _localctx = new Case_stmtContext(_ctx, getState(), unionTP);
		enterRule(_localctx, 188, RULE_case_stmt);

		    List<String> labels = new ArrayList<String>();
		    boolean defaul = false;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1252); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(1252);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case KW_CASE:
					{
					setState(1244);
					match(KW_CASE);
					setState(1245);
					((Case_stmtContext)_localctx).const_exp = const_exp();

					            labels.add(TemplateUtil.checkUnionLabel(unionTP.getDiscriminator(), ((Case_stmtContext)_localctx).const_exp.literalStr, ctx.getScopeFile(), _input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : 1));
					        
					setState(1247);
					match(COLON);
					}
					break;
				case KW_DEFAULT:
					{
					setState(1249);
					match(KW_DEFAULT);
					 defaul = true; 
					setState(1251);
					match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1254); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KW_DEFAULT || _la==KW_CASE );
			setState(1256);
			((Case_stmtContext)_localctx).element_spec = element_spec(labels, defaul);
			setState(1257);
			match(SEMICOLON);

			           if(((Case_stmtContext)_localctx).element_spec.ret != null)
			           {
			               int ret = unionTP.addMember(((Case_stmtContext)_localctx).element_spec.ret.second());

			               if(ret == -1)
			                   throw new ParseException(((Case_stmtContext)_localctx).element_spec.ret.first().second(), " is already defined.");
			               else if(ret == -2)
			                   throw new ParseException(((Case_stmtContext)_localctx).element_spec.ret.first().second(), " is also a default attribute. Another was defined previously.");
			           }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Element_specContext extends ParserRuleContext {
		public List<String> labels;
		public boolean isDefault;
		public Pair<Pair<String, Token>, UnionMember> ret = null;
		public Type_specContext type_spec;
		public DeclaratorContext declarator;
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Element_specContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Element_specContext(ParserRuleContext parent, int invokingState, List<String> labels, boolean isDefault) {
			super(parent, invokingState);
			this.labels = labels;
			this.isDefault = isDefault;
		}
		@Override public int getRuleIndex() { return RULE_element_spec; }
	}

	public final Element_specContext element_spec(List<String> labels,boolean isDefault) throws RecognitionException {
		Element_specContext _localctx = new Element_specContext(_ctx, getState(), labels, isDefault);
		enterRule(_localctx, 190, RULE_element_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1260);
			((Element_specContext)_localctx).type_spec = type_spec();
			setState(1261);
			((Element_specContext)_localctx).declarator = declarator();

			            if(((Element_specContext)_localctx).type_spec.typecode != null)
			            {
			                UnionMember member = null;

			                if(((Element_specContext)_localctx).declarator.ret.second() != null)
			                {
			                    ((Element_specContext)_localctx).declarator.ret.second().setContentTypeCode(((Element_specContext)_localctx).type_spec.typecode);
			                    member = new UnionMember(((Element_specContext)_localctx).declarator.ret.second(), ((Element_specContext)_localctx).declarator.ret.first().first(), labels, isDefault);
			                }
			                else
			                {
			                    member = new UnionMember(((Element_specContext)_localctx).type_spec.typecode, ((Element_specContext)_localctx).declarator.ret.first().first(), labels, isDefault);
			                }

			                ((Element_specContext)_localctx).ret =  new Pair<Pair<String, Token>, UnionMember>(((Element_specContext)_localctx).declarator.ret.first(), member);
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enum_typeContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public TerminalNode KW_ENUM() { return getToken(IDLParser.KW_ENUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Enumerator_listContext enumerator_list() {
			return getRuleContext(Enumerator_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Enum_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_type; }
	}

	public final Enum_typeContext enum_type() throws RecognitionException {
		Enum_typeContext _localctx = new Enum_typeContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_enum_type);

		    String name = null;
		    Vector<TypeCode> vector = null;
		    EnumTypeCode enumTP = null;
		    TemplateGroup enumTemplates = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1264);
			match(KW_ENUM);
			setState(1265);
			((Enum_typeContext)_localctx).identifier = identifier();
			 name=((Enum_typeContext)_localctx).identifier.id; enumTP = new EnumTypeCode(ctx.getScope(), name); 
			setState(1267);
			match(LEFT_BRACE);
			setState(1268);
			enumerator_list(enumTP);
			setState(1269);
			match(RIGHT_BRACE);

			           if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			           {
			                if(tmanager != null) {
			                    enumTemplates = tmanager.createTemplateGroup("enum_type");
			                    enumTemplates.setAttribute("ctx", ctx);
			                    enumTemplates.setAttribute("enum", enumTP);
			                }
			           }

			           // Return the returned data.
			           vector = new Vector<TypeCode>();
			           vector.add(enumTP);
			           ((Enum_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, enumTemplates);
			       
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enumerator_listContext extends ParserRuleContext {
		public EnumTypeCode enumTP;
		public List<EnumeratorContext> enumerator() {
			return getRuleContexts(EnumeratorContext.class);
		}
		public EnumeratorContext enumerator(int i) {
			return getRuleContext(EnumeratorContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Enumerator_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Enumerator_listContext(ParserRuleContext parent, int invokingState, EnumTypeCode enumTP) {
			super(parent, invokingState);
			this.enumTP = enumTP;
		}
		@Override public int getRuleIndex() { return RULE_enumerator_list; }
	}

	public final Enumerator_listContext enumerator_list(EnumTypeCode enumTP) throws RecognitionException {
		Enumerator_listContext _localctx = new Enumerator_listContext(_ctx, getState(), enumTP);
		enterRule(_localctx, 194, RULE_enumerator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1272);
			enumerator(enumTP);
			setState(1277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1273);
				match(COMA);
				setState(1274);
				enumerator(enumTP);
				}
				}
				setState(1279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorContext extends ParserRuleContext {
		public EnumTypeCode enumTP;
		public IdentifierContext identifier;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EnumeratorContext(ParserRuleContext parent, int invokingState, EnumTypeCode enumTP) {
			super(parent, invokingState);
			this.enumTP = enumTP;
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
	}

	public final EnumeratorContext enumerator(EnumTypeCode enumTP) throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState(), enumTP);
		enterRule(_localctx, 196, RULE_enumerator);

		    String name = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1280);
			((EnumeratorContext)_localctx).identifier = identifier();
			 name=((EnumeratorContext)_localctx).identifier.id; enumTP.addMember(new EnumMember(name));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sequence_typeContext extends ParserRuleContext {
		public SequenceTypeCode typecode = null;
		public Simple_type_specContext simple_type_spec;
		public Positive_int_constContext positive_int_const;
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public Simple_type_specContext simple_type_spec() {
			return getRuleContext(Simple_type_specContext.class,0);
		}
		public TerminalNode COMA() { return getToken(IDLParser.COMA, 0); }
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public TerminalNode KW_SEQUENCE() { return getToken(IDLParser.KW_SEQUENCE, 0); }
		public Sequence_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_type; }
	}

	public final Sequence_typeContext sequence_type() throws RecognitionException {
		Sequence_typeContext _localctx = new Sequence_typeContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_sequence_type);

		    TypeCode type = null;
		    String maxsize = null;
		    Definition def = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				{
				setState(1283);
				match(KW_SEQUENCE);
				}
				setState(1284);
				match(LEFT_ANG_BRACKET);
				setState(1285);
				((Sequence_typeContext)_localctx).simple_type_spec = simple_type_spec();
				 type=((Sequence_typeContext)_localctx).simple_type_spec.typecode; def=((Sequence_typeContext)_localctx).simple_type_spec.def; 
				setState(1287);
				match(COMA);
				setState(1288);
				((Sequence_typeContext)_localctx).positive_int_const = positive_int_const();
				 maxsize=((Sequence_typeContext)_localctx).positive_int_const.literalStr; 
				setState(1290);
				match(RIGHT_ANG_BRACKET);
				}
				break;
			case 2:
				{
				{
				setState(1292);
				match(KW_SEQUENCE);
				}
				setState(1293);
				match(LEFT_ANG_BRACKET);
				setState(1294);
				((Sequence_typeContext)_localctx).simple_type_spec = simple_type_spec();
				 type=((Sequence_typeContext)_localctx).simple_type_spec.typecode; def=((Sequence_typeContext)_localctx).simple_type_spec.def; 
				setState(1296);
				match(RIGHT_ANG_BRACKET);
				}
				break;
			}

			           if(type != null)
			           {
			               ((Sequence_typeContext)_localctx).typecode =  new SequenceTypeCode(maxsize);
			               _localctx.typecode.setContentTypeCode(type);
			           }
			           else if (def != null)
			           {
			               ((Sequence_typeContext)_localctx).typecode =  new SequenceTypeCode(maxsize);
			               _localctx.typecode.setContentDefinition(def);
			           }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_typeContext extends ParserRuleContext {
		public SetTypeCode typecode = null;
		public Simple_type_specContext simple_type_spec;
		public Positive_int_constContext positive_int_const;
		public TerminalNode KW_SET() { return getToken(IDLParser.KW_SET, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public Simple_type_specContext simple_type_spec() {
			return getRuleContext(Simple_type_specContext.class,0);
		}
		public TerminalNode COMA() { return getToken(IDLParser.COMA, 0); }
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public Set_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_type; }
	}

	public final Set_typeContext set_type() throws RecognitionException {
		Set_typeContext _localctx = new Set_typeContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_set_type);

		    TypeCode type = null;
		    String maxsize = null;
		    Definition def = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(1302);
				match(KW_SET);
				setState(1303);
				match(LEFT_ANG_BRACKET);
				setState(1304);
				((Set_typeContext)_localctx).simple_type_spec = simple_type_spec();
				 type=((Set_typeContext)_localctx).simple_type_spec.typecode; def=((Set_typeContext)_localctx).simple_type_spec.def; 
				setState(1306);
				match(COMA);
				setState(1307);
				((Set_typeContext)_localctx).positive_int_const = positive_int_const();
				 maxsize=((Set_typeContext)_localctx).positive_int_const.literalStr; 
				setState(1309);
				match(RIGHT_ANG_BRACKET);
				}
				break;
			case 2:
				{
				setState(1311);
				match(KW_SET);
				setState(1312);
				match(LEFT_ANG_BRACKET);
				setState(1313);
				((Set_typeContext)_localctx).simple_type_spec = simple_type_spec();
				 type=((Set_typeContext)_localctx).simple_type_spec.typecode; def=((Set_typeContext)_localctx).simple_type_spec.def; 
				setState(1315);
				match(RIGHT_ANG_BRACKET);
				}
				break;
			}

				        ((Set_typeContext)_localctx).typecode =  new SetTypeCode(maxsize);
			            if (type != null)
			            {
				            _localctx.typecode.setContentTypeCode(type);
			            }
			            else if (def != null)
			            {
				            _localctx.typecode.setContentDefinition(def);
			            }
				    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Map_typeContext extends ParserRuleContext {
		public MapTypeCode typecode = null;
		public Simple_type_specContext simple_type_spec;
		public Positive_int_constContext positive_int_const;
		public TerminalNode KW_MAP() { return getToken(IDLParser.KW_MAP, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public List<Simple_type_specContext> simple_type_spec() {
			return getRuleContexts(Simple_type_specContext.class);
		}
		public Simple_type_specContext simple_type_spec(int i) {
			return getRuleContext(Simple_type_specContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public Map_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map_type; }
	}

	public final Map_typeContext map_type() throws RecognitionException {
		Map_typeContext _localctx = new Map_typeContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_map_type);

		    TypeCode keyType = null;
		    TypeCode valueType = null;
		    Definition keyDef = null;
		    Definition valueDef = null;
		    String maxsize = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1321);
			match(KW_MAP);
			setState(1322);
			match(LEFT_ANG_BRACKET);
			setState(1323);
			((Map_typeContext)_localctx).simple_type_spec = simple_type_spec();

			            keyType=((Map_typeContext)_localctx).simple_type_spec.typecode;
			            keyDef=((Map_typeContext)_localctx).simple_type_spec.def;
			        
			setState(1325);
			match(COMA);
			setState(1326);
			((Map_typeContext)_localctx).simple_type_spec = simple_type_spec();

			            valueType=((Map_typeContext)_localctx).simple_type_spec.typecode;
			            valueDef=((Map_typeContext)_localctx).simple_type_spec.def;
			        
			setState(1332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(1328);
				match(COMA);
				setState(1329);
				((Map_typeContext)_localctx).positive_int_const = positive_int_const();
				 maxsize=((Map_typeContext)_localctx).positive_int_const.literalStr; 
				}
			}

			setState(1334);
			match(RIGHT_ANG_BRACKET);

				        ((Map_typeContext)_localctx).typecode =  new MapTypeCode(maxsize);

			            if (keyType != null)
			            {
				            _localctx.typecode.setKeyTypeCode(keyType);
			            }
			            else if (keyDef != null)
			            {
			                _localctx.typecode.setKeyDefinition(keyDef);
			            }

			            if (valueType != null)
			            {
				            _localctx.typecode.setValueTypeCode(valueType);
			            }
			            else if (valueDef != null)
			            {
			                _localctx.typecode.setValueDefinition(valueDef);
			            }
				    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Positive_int_constContext positive_int_const;
		public TerminalNode KW_STRING() { return getToken(IDLParser.KW_STRING, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public String_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_type; }
	}

	public final String_typeContext string_type() throws RecognitionException {
		String_typeContext _localctx = new String_typeContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_string_type);

		    String maxsize = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				{
				setState(1337);
				match(KW_STRING);
				setState(1338);
				match(LEFT_ANG_BRACKET);
				setState(1339);
				((String_typeContext)_localctx).positive_int_const = positive_int_const();
				 maxsize=((String_typeContext)_localctx).positive_int_const.literalStr; 
				setState(1341);
				match(RIGHT_ANG_BRACKET);
				}
				break;
			case 2:
				{
				setState(1343);
				match(KW_STRING);
				}
				break;
			}
			((String_typeContext)_localctx).typecode =  new StringTypeCode(Kind.KIND_STRING, maxsize);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Wide_string_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Positive_int_constContext positive_int_const;
		public TerminalNode KW_WSTRING() { return getToken(IDLParser.KW_WSTRING, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public Wide_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wide_string_type; }
	}

	public final Wide_string_typeContext wide_string_type() throws RecognitionException {
		Wide_string_typeContext _localctx = new Wide_string_typeContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_wide_string_type);

		    String maxsize = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				{
				setState(1348);
				match(KW_WSTRING);
				setState(1349);
				match(LEFT_ANG_BRACKET);
				setState(1350);
				((Wide_string_typeContext)_localctx).positive_int_const = positive_int_const();
				 maxsize=((Wide_string_typeContext)_localctx).positive_int_const.literalStr; 
				setState(1352);
				match(RIGHT_ANG_BRACKET);
				}
				break;
			case 2:
				{
				setState(1354);
				match(KW_WSTRING);
				}
				break;
			}
			((Wide_string_typeContext)_localctx).typecode =  new StringTypeCode(Kind.KIND_WSTRING, maxsize);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_declaratorContext extends ParserRuleContext {
		public Pair<Pair<String, Token>, ContainerTypeCode> pair = null;
		public Fixed_array_sizeContext fixed_array_size;
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public List<Fixed_array_sizeContext> fixed_array_size() {
			return getRuleContexts(Fixed_array_sizeContext.class);
		}
		public Fixed_array_sizeContext fixed_array_size(int i) {
			return getRuleContext(Fixed_array_sizeContext.class,i);
		}
		public Array_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_declarator; }
	}

	public final Array_declaratorContext array_declarator() throws RecognitionException {
		Array_declaratorContext _localctx = new Array_declaratorContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_array_declarator);

		    Token tk = _input.LT(1);
		    ArrayTypeCode typecode = new ArrayTypeCode();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1359);
			match(ID);
			setState(1363); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1360);
				((Array_declaratorContext)_localctx).fixed_array_size = fixed_array_size();

				               typecode.addDimension(((Array_declaratorContext)_localctx).fixed_array_size.literalStr);
				            
				}
				}
				setState(1365); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LEFT_SQUARE_BRACKET );

			            Pair<String, Token> p = new Pair<String, Token>(tk.getText(), tk);
			            ((Array_declaratorContext)_localctx).pair =  new Pair<Pair<String, Token>, ContainerTypeCode>(p, typecode);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fixed_array_sizeContext extends ParserRuleContext {
		public String literalStr = null;
		public Positive_int_constContext positive_int_const;
		public TerminalNode LEFT_SQUARE_BRACKET() { return getToken(IDLParser.LEFT_SQUARE_BRACKET, 0); }
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public TerminalNode RIGHT_SQUARE_BRACKET() { return getToken(IDLParser.RIGHT_SQUARE_BRACKET, 0); }
		public Fixed_array_sizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixed_array_size; }
	}

	public final Fixed_array_sizeContext fixed_array_size() throws RecognitionException {
		Fixed_array_sizeContext _localctx = new Fixed_array_sizeContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_fixed_array_size);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1369);
			match(LEFT_SQUARE_BRACKET);
			setState(1370);
			((Fixed_array_sizeContext)_localctx).positive_int_const = positive_int_const();
			 ((Fixed_array_sizeContext)_localctx).literalStr = ((Fixed_array_sizeContext)_localctx).positive_int_const.literalStr; 
			setState(1372);
			match(RIGHT_SQUARE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_declContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, TypeCode>> ret = null;
		public Vector<Pair<Pair<String, Token>, Definition>> retDef = null;
		public Attr_specContext attr_spec;
		public Readonly_attr_specContext readonly_attr_spec() {
			return getRuleContext(Readonly_attr_specContext.class,0);
		}
		public Attr_specContext attr_spec() {
			return getRuleContext(Attr_specContext.class,0);
		}
		public Attr_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_decl; }
	}

	public final Attr_declContext attr_decl() throws RecognitionException {
		Attr_declContext _localctx = new Attr_declContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_attr_decl);
		try {
			setState(1378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_READONLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(1374);
				readonly_attr_spec();
				}
				break;
			case KW_ATTRIBUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1375);
				((Attr_declContext)_localctx).attr_spec = attr_spec();
				 ((Attr_declContext)_localctx).ret = ((Attr_declContext)_localctx).attr_spec.ret; ((Attr_declContext)_localctx).retDef = ((Attr_declContext)_localctx).attr_spec.retDef; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Except_declContext extends ParserRuleContext {
		public Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public TerminalNode KW_EXCEPTION() { return getToken(IDLParser.KW_EXCEPTION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Opt_member_listContext opt_member_list() {
			return getRuleContext(Opt_member_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Except_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_decl; }
	}

	public final Except_declContext except_decl() throws RecognitionException {
		Except_declContext _localctx = new Except_declContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_except_decl);

		    String name = null;
		    com.eprosima.idl.parser.tree.Exception exceptionObject = null;
		    TemplateGroup exTemplates = null;
		    Token tk = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1380);
			match(KW_EXCEPTION);

			            tk = _input.LT(1);
			        
			setState(1382);
			((Except_declContext)_localctx).identifier = identifier();
			 name=((Except_declContext)_localctx).identifier.id; 

			            // Create the Exception object.
			            exceptionObject = ctx.createException(name, tk);

			            if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			            {
			                if(tmanager != null) {
			                    exTemplates = tmanager.createTemplateGroup("exception");
			                    exTemplates.setAttribute("ctx", ctx);
			                    // Set the the exception object to the TemplateGroup of the module.
			                    exTemplates.setAttribute("exception", exceptionObject);
			                }
			            }
			            // Its a dependency.
			            else
			            {
			                ctx.addIncludeDependency(ctx.getScopeFile());
			            }
			        
			setState(1385);
			match(LEFT_BRACE);
			setState(1386);
			opt_member_list(exceptionObject);
			setState(1387);
			match(RIGHT_BRACE);

			            // Create the returned data.
			            ((Except_declContext)_localctx).returnPair =  new Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup>(exceptionObject, exTemplates);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opt_member_listContext extends ParserRuleContext {
		public com.eprosima.idl.parser.tree.Exception exceptionObject;
		public MemberContext member;
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public Opt_member_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Opt_member_listContext(ParserRuleContext parent, int invokingState, com.eprosima.idl.parser.tree.Exception exceptionObject) {
			super(parent, invokingState);
			this.exceptionObject = exceptionObject;
		}
		@Override public int getRuleIndex() { return RULE_opt_member_list; }
	}

	public final Opt_member_listContext opt_member_list(com.eprosima.idl.parser.tree.Exception exceptionObject) throws RecognitionException {
		Opt_member_listContext _localctx = new Opt_member_listContext(_ctx, getState(), exceptionObject);
		enterRule(_localctx, 216, RULE_opt_member_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_OCTET) | (1L << KW_SEQUENCE) | (1L << KW_STRUCT) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_FIXED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_SET - 64)) | (1L << (KW_MAP - 64)) | (1L << (KW_BITSET - 64)) | (1L << (KW_BITMASK - 64)) | (1L << (KW_INT8 - 64)) | (1L << (KW_UINT8 - 64)) | (1L << (KW_INT16 - 64)) | (1L << (KW_UINT16 - 64)) | (1L << (KW_INT32 - 64)) | (1L << (KW_UINT32 - 64)) | (1L << (KW_INT64 - 64)) | (1L << (KW_UINT64 - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1390);
				((Opt_member_listContext)_localctx).member = member(null);

				              for(int count = 0; count < ((Opt_member_listContext)_localctx).member.ret.size(); ++count)
				                  _localctx.exceptionObject.addMember(((Opt_member_listContext)_localctx).member.ret.get(count).second());
				          
				}
				}
				setState(1397);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_declContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Operation, TemplateGroup> returnPair = null;
		public Op_attributeContext op_attribute;
		public Op_type_specContext op_type_spec;
		public Parameter_declsContext parameter_decls;
		public Raises_exprContext raises_expr;
		public Op_type_specContext op_type_spec() {
			return getRuleContext(Op_type_specContext.class,0);
		}
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Parameter_declsContext parameter_decls() {
			return getRuleContext(Parameter_declsContext.class,0);
		}
		public Op_attributeContext op_attribute() {
			return getRuleContext(Op_attributeContext.class,0);
		}
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public Context_exprContext context_expr() {
			return getRuleContext(Context_exprContext.class,0);
		}
		public Op_declContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Op_declContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_op_decl; }
	}

	public final Op_declContext op_decl(Vector<Annotation> annotations) throws RecognitionException {
		Op_declContext _localctx = new Op_declContext(_ctx, getState(), annotations);
		enterRule(_localctx, 218, RULE_op_decl);

		        Operation operationObject = null;
		        TemplateGroup operationTemplates = null;
		        if(tmanager != null) {
		            operationTemplates = tmanager.createTemplateGroup("operation");
		        }
		        TemplateGroup tpl = null;
		        String name = "";
		        Token tk = null, tkoneway = null;
		        TypeCode retType = null;
		        Vector<Pair<String, Token>> exceptions = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ONEWAY) {
				{
				setState(1398);
				((Op_declContext)_localctx).op_attribute = op_attribute();
				 tkoneway=((Op_declContext)_localctx).op_attribute.token; 
				}
			}

			setState(1403);
			((Op_declContext)_localctx).op_type_spec = op_type_spec();
			 retType=((Op_declContext)_localctx).op_type_spec.typecode; 

			            tk = _input.LT(1);
			            name += tk.getText();
			        
			setState(1406);
			match(ID);

			           // Create the Operation object.
			           operationObject = ctx.createOperation(name, tk);

			           // Add annotations.
			           for(Annotation annotation : annotations)
			               operationObject.addAnnotation(ctx, annotation);

			           if(operationTemplates != null)
			           {
			               operationTemplates.setAttribute("ctx", ctx);
			               // Set the the interface object to the TemplateGroup of the module.
			               operationTemplates.setAttribute("operation", operationObject);
			           }

			           // Set return type
			           operationObject.setRettype(retType);

			           // Set oneway
			           if(tkoneway != null)
			           {
			               operationObject.setOneway(true);

			               if(retType != null)
			               {
			                   throw new ParseException(tkoneway, ". Oneway function cannot have a return type.");
			               }
			           }
			        
			setState(1408);
			((Op_declContext)_localctx).parameter_decls = parameter_decls(operationObject);
			 tpl=((Op_declContext)_localctx).parameter_decls.tpl; 
			setState(1414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_RAISES) {
				{
				setState(1410);
				((Op_declContext)_localctx).raises_expr = raises_expr();
				 exceptions=((Op_declContext)_localctx).raises_expr.exlist; 

				              // Search global exceptions and add them to the operation.
				              for(Pair<String, Token> pair : exceptions)
				              {
				                 com.eprosima.idl.parser.tree.Exception exception = ctx.getException(pair.first());

				                 if(exception != null)
				                    operationObject.addException(exception);
				                 else
				                    operationObject.addUnresolvedException(pair.first());
				              }
				           
				}
			}

			setState(1417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_CONTEXT) {
				{
				setState(1416);
				context_expr();
				}
			}


			            if(operationTemplates != null) {
			                // Store the parameter list template group in the operation template group.
			                operationTemplates.setAttribute("param_list", tpl);
			            }
			           // Create the returned data.
			           ((Op_declContext)_localctx).returnPair =  new Pair<Operation, TemplateGroup>(operationObject, operationTemplates);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_attributeContext extends ParserRuleContext {
		public Token token = null;
		public TerminalNode KW_ONEWAY() { return getToken(IDLParser.KW_ONEWAY, 0); }
		public Op_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_attribute; }
	}

	public final Op_attributeContext op_attribute() throws RecognitionException {
		Op_attributeContext _localctx = new Op_attributeContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_op_attribute);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1421);
			match(KW_ONEWAY);
			 ((Op_attributeContext)_localctx).token =  tk;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Definition def = null;
		public Param_type_specContext param_type_spec;
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public TerminalNode KW_VOID() { return getToken(IDLParser.KW_VOID, 0); }
		public Op_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_type_spec; }
	}

	public final Op_type_specContext op_type_spec() throws RecognitionException {
		Op_type_specContext _localctx = new Op_type_specContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_op_type_spec);
		try {
			setState(1428);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_OCTET:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_WSTRING:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1424);
				((Op_type_specContext)_localctx).param_type_spec = param_type_spec();
				 ((Op_type_specContext)_localctx).typecode = ((Op_type_specContext)_localctx).param_type_spec.typecode; ((Op_type_specContext)_localctx).def = ((Op_type_specContext)_localctx).param_type_spec.def; 
				}
				break;
			case KW_VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(1427);
				match(KW_VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_declsContext extends ParserRuleContext {
		public Operation operation;
		public TemplateGroup tpl;
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Param_decl_listContext param_decl_list() {
			return getRuleContext(Param_decl_listContext.class,0);
		}
		public Parameter_declsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Parameter_declsContext(ParserRuleContext parent, int invokingState, Operation operation) {
			super(parent, invokingState);
			this.operation = operation;
		}
		@Override public int getRuleIndex() { return RULE_parameter_decls; }
	}

	public final Parameter_declsContext parameter_decls(Operation operation) throws RecognitionException {
		Parameter_declsContext _localctx = new Parameter_declsContext(_ctx, getState(), operation);
		enterRule(_localctx, 224, RULE_parameter_decls);

		    if(tmanager != null) {
		        ((Parameter_declsContext)_localctx).tpl =  tmanager.createTemplateGroup("param_list");
		    }

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1430);
			match(LEFT_BRACKET);
			setState(1432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (KW_OUT - 39)) | (1L << (KW_IN - 39)) | (1L << (KW_INOUT - 39)))) != 0)) {
				{
				setState(1431);
				param_decl_list(operation, _localctx.tpl);
				}
			}

			setState(1434);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_listContext extends ParserRuleContext {
		public Operation operation;
		public TemplateGroup tpl;
		public Param_declContext param_decl;
		public List<Param_declContext> param_decl() {
			return getRuleContexts(Param_declContext.class);
		}
		public Param_declContext param_decl(int i) {
			return getRuleContext(Param_declContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Param_decl_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Param_decl_listContext(ParserRuleContext parent, int invokingState, Operation operation, TemplateGroup tpl) {
			super(parent, invokingState);
			this.operation = operation;
			this.tpl = tpl;
		}
		@Override public int getRuleIndex() { return RULE_param_decl_list; }
	}

	public final Param_decl_listContext param_decl_list(Operation operation,TemplateGroup tpl) throws RecognitionException {
		Param_decl_listContext _localctx = new Param_decl_listContext(_ctx, getState(), operation, tpl);
		enterRule(_localctx, 226, RULE_param_decl_list);

		        Pair<Param, TemplateGroup> ptg = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1436);
			((Param_decl_listContext)_localctx).param_decl = param_decl();
			 ptg=((Param_decl_listContext)_localctx).param_decl.returnPair; 

			            if(ptg!=null) {
			                operation.add(ptg.first());
			                if(tpl != null) {
			                    tpl.setAttribute("parameters", ptg.second());
			                }
			            }
			        
			setState(1446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1439);
				match(COMA);
				setState(1440);
				((Param_decl_listContext)_localctx).param_decl = param_decl();
				 ptg=((Param_decl_listContext)_localctx).param_decl.returnPair; 

				            if(ptg!=null) {
				                operation.add(ptg.first());
				                if(tpl != null) {
				                    tpl.setAttribute("parameters", ptg.second());
				                }
				            }
				        
				}
				}
				setState(1448);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_declContext extends ParserRuleContext {
		public Pair<Param, TemplateGroup> returnPair = null;
		public Param_type_specContext param_type_spec;
		public Simple_declaratorContext simple_declarator;
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Param_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl; }
	}

	public final Param_declContext param_decl() throws RecognitionException {
		Param_declContext _localctx = new Param_declContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_param_decl);

		        TemplateGroup paramTemplate = null;
		        if(tmanager != null) {
		            paramTemplate = tmanager.createTemplateGroup("param");
		        }
		        TypeCode typecode = null;
		        Definition definition = null;
		        String literalStr = _input.LT(1).getText();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1449);
			_la = _input.LA(1);
			if ( !(((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (KW_OUT - 39)) | (1L << (KW_IN - 39)) | (1L << (KW_INOUT - 39)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1450);
			((Param_declContext)_localctx).param_type_spec = param_type_spec();
			 typecode=((Param_declContext)_localctx).param_type_spec.typecode; definition=((Param_declContext)_localctx).param_type_spec.def; 
			setState(1452);
			((Param_declContext)_localctx).simple_declarator = simple_declarator();

			            if(typecode != null)
			            {
			                Param param = null;
			                if(literalStr.equals("in"))
			                    param = ctx.createParam(((Param_declContext)_localctx).simple_declarator.ret.first().first(), typecode, Param.Kind.IN_PARAM);
			                else if(literalStr.equals("out"))
			                    param = ctx.createParam(((Param_declContext)_localctx).simple_declarator.ret.first().first(), typecode, Param.Kind.OUT_PARAM);
			                else if(literalStr.equals("inout"))
			                    param = ctx.createParam(((Param_declContext)_localctx).simple_declarator.ret.first().first(), typecode, Param.Kind.INOUT_PARAM);

			                if(paramTemplate != null) {
			                    paramTemplate.setAttribute("parameter", param);
			                }
			                ((Param_declContext)_localctx).returnPair =  new Pair<Param, TemplateGroup>(param, paramTemplate);
			            }
			            else if (definition != null)
			            {
			                Param param = null;
			                if(literalStr.equals("in"))
			                    param = ctx.createParam(((Param_declContext)_localctx).simple_declarator.ret.first().first(), definition, Param.Kind.IN_PARAM);
			                else if(literalStr.equals("out"))
			                    param = ctx.createParam(((Param_declContext)_localctx).simple_declarator.ret.first().first(), definition, Param.Kind.OUT_PARAM);
			                else if(literalStr.equals("inout"))
			                    param = ctx.createParam(((Param_declContext)_localctx).simple_declarator.ret.first().first(), definition, Param.Kind.INOUT_PARAM);

			                if(paramTemplate != null) {
			                    paramTemplate.setAttribute("parameter", param);
			                }
			                ((Param_declContext)_localctx).returnPair =  new Pair<Param, TemplateGroup>(param, paramTemplate);
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Raises_exprContext extends ParserRuleContext {
		public Vector<Pair<String, Token>> exlist = null;
		public Scoped_name_listContext scoped_name_list;
		public TerminalNode KW_RAISES() { return getToken(IDLParser.KW_RAISES, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public Scoped_name_listContext scoped_name_list() {
			return getRuleContext(Scoped_name_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Raises_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raises_expr; }
	}

	public final Raises_exprContext raises_expr() throws RecognitionException {
		Raises_exprContext _localctx = new Raises_exprContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_raises_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1455);
			match(KW_RAISES);
			setState(1456);
			match(LEFT_BRACKET);
			setState(1457);
			((Raises_exprContext)_localctx).scoped_name_list = scoped_name_list();
			 ((Raises_exprContext)_localctx).exlist = ((Raises_exprContext)_localctx).scoped_name_list.retlist; 
			setState(1459);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Context_exprContext extends ParserRuleContext {
		public TerminalNode KW_CONTEXT() { return getToken(IDLParser.KW_CONTEXT, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public List<TerminalNode> STRING_LITERAL() { return getTokens(IDLParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(IDLParser.STRING_LITERAL, i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Context_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context_expr; }
	}

	public final Context_exprContext context_expr() throws RecognitionException {
		Context_exprContext _localctx = new Context_exprContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_context_expr);

		    System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Context declarations are not supported. Ignoring...");

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1461);
			match(KW_CONTEXT);
			setState(1462);
			match(LEFT_BRACKET);
			setState(1463);
			match(STRING_LITERAL);
			setState(1468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1464);
				match(COMA);
				setState(1465);
				match(STRING_LITERAL);
				}
				}
				setState(1470);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1471);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Definition def = null;
		public Base_type_specContext base_type_spec;
		public String_typeContext string_type;
		public Wide_string_typeContext wide_string_type;
		public Scoped_nameContext scoped_name;
		public Base_type_specContext base_type_spec() {
			return getRuleContext(Base_type_specContext.class,0);
		}
		public String_typeContext string_type() {
			return getRuleContext(String_typeContext.class,0);
		}
		public Wide_string_typeContext wide_string_type() {
			return getRuleContext(Wide_string_typeContext.class,0);
		}
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Param_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_spec; }
	}

	public final Param_type_specContext param_type_spec() throws RecognitionException {
		Param_type_specContext _localctx = new Param_type_specContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_param_type_spec);

		    Pair<String, Token> pair = null;

		try {
			setState(1485);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_OCTET:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
				enterOuterAlt(_localctx, 1);
				{
				setState(1473);
				((Param_type_specContext)_localctx).base_type_spec = base_type_spec();
				 ((Param_type_specContext)_localctx).typecode = ((Param_type_specContext)_localctx).base_type_spec.typecode; 
				}
				break;
			case KW_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1476);
				((Param_type_specContext)_localctx).string_type = string_type();
				 ((Param_type_specContext)_localctx).typecode = ((Param_type_specContext)_localctx).string_type.typecode; 
				}
				break;
			case KW_WSTRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(1479);
				((Param_type_specContext)_localctx).wide_string_type = wide_string_type();
				 ((Param_type_specContext)_localctx).typecode = ((Param_type_specContext)_localctx).wide_string_type.typecode; 
				}
				break;
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(1482);
				((Param_type_specContext)_localctx).scoped_name = scoped_name();

				            pair=((Param_type_specContext)_localctx).scoped_name.pair;
				            // Find typecode in the global map.
				            ((Param_type_specContext)_localctx).typecode =  ctx.getTypeCode(pair.first());

				            if(_localctx.typecode == null)
				            {
				                // Maybe an interface
				                ((Param_type_specContext)_localctx).def =  ctx.getInterface(pair.first());

				                if (_localctx.def == null)
				                {
				                    throw new ParseException(pair.second(), "was not defined previously");
				                }
				            }
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fixed_pt_typeContext extends ParserRuleContext {
		public TerminalNode KW_FIXED() { return getToken(IDLParser.KW_FIXED, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public List<Positive_int_constContext> positive_int_const() {
			return getRuleContexts(Positive_int_constContext.class);
		}
		public Positive_int_constContext positive_int_const(int i) {
			return getRuleContext(Positive_int_constContext.class,i);
		}
		public TerminalNode COMA() { return getToken(IDLParser.COMA, 0); }
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public Fixed_pt_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixed_pt_type; }
	}

	public final Fixed_pt_typeContext fixed_pt_type() throws RecognitionException {
		Fixed_pt_typeContext _localctx = new Fixed_pt_typeContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_fixed_pt_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1487);
			match(KW_FIXED);
			setState(1488);
			match(LEFT_ANG_BRACKET);
			setState(1489);
			positive_int_const();
			setState(1490);
			match(COMA);
			setState(1491);
			positive_int_const();
			setState(1492);
			match(RIGHT_ANG_BRACKET);
			throw new ParseException(tk, ". Fixed type is not supported");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fixed_pt_const_typeContext extends ParserRuleContext {
		public TerminalNode KW_FIXED() { return getToken(IDLParser.KW_FIXED, 0); }
		public Fixed_pt_const_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixed_pt_const_type; }
	}

	public final Fixed_pt_const_typeContext fixed_pt_const_type() throws RecognitionException {
		Fixed_pt_const_typeContext _localctx = new Fixed_pt_const_typeContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_fixed_pt_const_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1495);
			match(KW_FIXED);
			throw new ParseException(tk, ". Fixed type is not supported");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_base_typeContext extends ParserRuleContext {
		public TerminalNode KW_VALUEBASE() { return getToken(IDLParser.KW_VALUEBASE, 0); }
		public Value_base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_base_type; }
	}

	public final Value_base_typeContext value_base_type() throws RecognitionException {
		Value_base_typeContext _localctx = new Value_base_typeContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_value_base_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1498);
			match(KW_VALUEBASE);
			throw new ParseException(tk, ". Value type is not supported");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constr_forward_declContext extends ParserRuleContext {
		public TerminalNode KW_STRUCT() { return getToken(IDLParser.KW_STRUCT, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_UNION() { return getToken(IDLParser.KW_UNION, 0); }
		public Constr_forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr_forward_decl; }
	}

	public final Constr_forward_declContext constr_forward_decl() throws RecognitionException {
		Constr_forward_declContext _localctx = new Constr_forward_declContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_constr_forward_decl);
		try {
			setState(1505);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_STRUCT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1501);
				match(KW_STRUCT);
				setState(1502);
				match(ID);
				}
				break;
			case KW_UNION:
				enterOuterAlt(_localctx, 2);
				{
				setState(1503);
				match(KW_UNION);
				setState(1504);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_declContext extends ParserRuleContext {
		public TerminalNode KW_IMPORT() { return getToken(IDLParser.KW_IMPORT, 0); }
		public Imported_scopeContext imported_scope() {
			return getRuleContext(Imported_scopeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Import_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_decl; }
	}

	public final Import_declContext import_decl() throws RecognitionException {
		Import_declContext _localctx = new Import_declContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_import_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1507);
			match(KW_IMPORT);

			        System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Import declarations are not supported. Ignoring...");
			    
			setState(1509);
			imported_scope();
			setState(1510);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Imported_scopeContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(IDLParser.STRING_LITERAL, 0); }
		public Imported_scopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imported_scope; }
	}

	public final Imported_scopeContext imported_scope() throws RecognitionException {
		Imported_scopeContext _localctx = new Imported_scopeContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_imported_scope);
		try {
			setState(1514);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1512);
				scoped_name();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1513);
				match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_id_declContext extends ParserRuleContext {
		public TerminalNode KW_TYPEID() { return getToken(IDLParser.KW_TYPEID, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(IDLParser.STRING_LITERAL, 0); }
		public Type_id_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_id_decl; }
	}

	public final Type_id_declContext type_id_decl() throws RecognitionException {
		Type_id_declContext _localctx = new Type_id_declContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_type_id_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1516);
			match(KW_TYPEID);

			            System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): TypeID declarations are not supported. Ignoring...");
			        
			setState(1518);
			scoped_name();
			setState(1519);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_prefix_declContext extends ParserRuleContext {
		public TerminalNode KW_TYPEPREFIX() { return getToken(IDLParser.KW_TYPEPREFIX, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(IDLParser.STRING_LITERAL, 0); }
		public Type_prefix_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_prefix_decl; }
	}

	public final Type_prefix_declContext type_prefix_decl() throws RecognitionException {
		Type_prefix_declContext _localctx = new Type_prefix_declContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_type_prefix_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1521);
			match(KW_TYPEPREFIX);

			            System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): TypePrefix declarations are not supported. Ignoring...");
			        
			setState(1523);
			scoped_name();
			setState(1524);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Readonly_attr_specContext extends ParserRuleContext {
		public TerminalNode KW_READONLY() { return getToken(IDLParser.KW_READONLY, 0); }
		public TerminalNode KW_ATTRIBUTE() { return getToken(IDLParser.KW_ATTRIBUTE, 0); }
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public Readonly_attr_declaratorContext readonly_attr_declarator() {
			return getRuleContext(Readonly_attr_declaratorContext.class,0);
		}
		public Readonly_attr_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readonly_attr_spec; }
	}

	public final Readonly_attr_specContext readonly_attr_spec() throws RecognitionException {
		Readonly_attr_specContext _localctx = new Readonly_attr_specContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_readonly_attr_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1526);
			match(KW_READONLY);
			setState(1527);
			match(KW_ATTRIBUTE);
			setState(1528);
			param_type_spec();
			setState(1529);
			readonly_attr_declarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Readonly_attr_declaratorContext extends ParserRuleContext {
		public List<Simple_declaratorContext> simple_declarator() {
			return getRuleContexts(Simple_declaratorContext.class);
		}
		public Simple_declaratorContext simple_declarator(int i) {
			return getRuleContext(Simple_declaratorContext.class,i);
		}
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Readonly_attr_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readonly_attr_declarator; }
	}

	public final Readonly_attr_declaratorContext readonly_attr_declarator() throws RecognitionException {
		Readonly_attr_declaratorContext _localctx = new Readonly_attr_declaratorContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_readonly_attr_declarator);
		int _la;
		try {
			setState(1542);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1531);
				simple_declarator();
				setState(1532);
				raises_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1534);
				simple_declarator();
				setState(1539);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(1535);
					match(COMA);
					setState(1536);
					simple_declarator();
					}
					}
					setState(1541);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_specContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, TypeCode>> ret = new Vector<Pair<Pair<String, Token>, TypeCode>>();
		public Vector<Pair<Pair<String, Token>, Definition>> retDef = new Vector<Pair<Pair<String, Token>, Definition>>();
		public Param_type_specContext param_type_spec;
		public Attr_declaratorContext attr_declarator;
		public TerminalNode KW_ATTRIBUTE() { return getToken(IDLParser.KW_ATTRIBUTE, 0); }
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public Attr_declaratorContext attr_declarator() {
			return getRuleContext(Attr_declaratorContext.class,0);
		}
		public Attr_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_spec; }
	}

	public final Attr_specContext attr_spec() throws RecognitionException {
		Attr_specContext _localctx = new Attr_specContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_attr_spec);

		    TypeCode typecode = null;
		    Definition definition = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1544);
			match(KW_ATTRIBUTE);
			setState(1545);
			((Attr_specContext)_localctx).param_type_spec = param_type_spec();
			 typecode=((Attr_specContext)_localctx).param_type_spec.typecode; definition=((Attr_specContext)_localctx).param_type_spec.def; 
			setState(1547);
			((Attr_specContext)_localctx).attr_declarator = attr_declarator();

			           if(typecode != null)
			           {
			               for(int count = 0; count < ((Attr_specContext)_localctx).attr_declarator.ret.size(); ++count)
			               {
			                   // attr_declarator always is a simple declarator. Not a complex (array):
			                   // Simple declaration
			                   _localctx.ret.add(new Pair<Pair<String, Token>, TypeCode>(((Attr_specContext)_localctx).attr_declarator.ret.get(count).first(), typecode));
			               }
			           }
			           else if(definition != null)
			           {
			               for(int count = 0; count < ((Attr_specContext)_localctx).attr_declarator.ret.size(); ++count)
			               {
			                   // attr_declarator always is a simple declarator. Not a complex (array):
			                   // Simple declaration
			                   _localctx.retDef.add(new Pair<Pair<String, Token>, Definition>(((Attr_specContext)_localctx).attr_declarator.ret.get(count).first(), definition));
			               }
			           }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_declaratorContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, ContainerTypeCode>> ret;
		public Simple_declaratorContext simple_declarator;
		public List<Simple_declaratorContext> simple_declarator() {
			return getRuleContexts(Simple_declaratorContext.class);
		}
		public Simple_declaratorContext simple_declarator(int i) {
			return getRuleContext(Simple_declaratorContext.class,i);
		}
		public Attr_raises_exprContext attr_raises_expr() {
			return getRuleContext(Attr_raises_exprContext.class,0);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Attr_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_declarator; }
	}

	public final Attr_declaratorContext attr_declarator() throws RecognitionException {
		Attr_declaratorContext _localctx = new Attr_declaratorContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_attr_declarator);

		    ((Attr_declaratorContext)_localctx).ret =  new Vector<Pair<Pair<String, Token>, ContainerTypeCode>>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1550);
			((Attr_declaratorContext)_localctx).simple_declarator = simple_declarator();
			_localctx.ret.add(((Attr_declaratorContext)_localctx).simple_declarator.ret);
			setState(1562);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_SETRAISES:
			case KW_GETRAISES:
				{
				setState(1552);
				attr_raises_expr();
				}
				break;
			case SEMICOLON:
			case COMA:
				{
				setState(1559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(1553);
					match(COMA);
					setState(1554);
					((Attr_declaratorContext)_localctx).simple_declarator = simple_declarator();
					_localctx.ret.add(((Attr_declaratorContext)_localctx).simple_declarator.ret);
					}
					}
					setState(1561);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_raises_exprContext extends ParserRuleContext {
		public Get_excep_exprContext get_excep_expr() {
			return getRuleContext(Get_excep_exprContext.class,0);
		}
		public Set_excep_exprContext set_excep_expr() {
			return getRuleContext(Set_excep_exprContext.class,0);
		}
		public Attr_raises_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_raises_expr; }
	}

	public final Attr_raises_exprContext attr_raises_expr() throws RecognitionException {
		Attr_raises_exprContext _localctx = new Attr_raises_exprContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_attr_raises_expr);
		int _la;
		try {
			setState(1569);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_GETRAISES:
				enterOuterAlt(_localctx, 1);
				{
				setState(1564);
				get_excep_expr();
				setState(1566);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_SETRAISES) {
					{
					setState(1565);
					set_excep_expr();
					}
				}

				}
				break;
			case KW_SETRAISES:
				enterOuterAlt(_localctx, 2);
				{
				setState(1568);
				set_excep_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Get_excep_exprContext extends ParserRuleContext {
		public TerminalNode KW_GETRAISES() { return getToken(IDLParser.KW_GETRAISES, 0); }
		public Exception_listContext exception_list() {
			return getRuleContext(Exception_listContext.class,0);
		}
		public Get_excep_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get_excep_expr; }
	}

	public final Get_excep_exprContext get_excep_expr() throws RecognitionException {
		Get_excep_exprContext _localctx = new Get_excep_exprContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_get_excep_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1571);
			match(KW_GETRAISES);
			setState(1572);
			exception_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_excep_exprContext extends ParserRuleContext {
		public TerminalNode KW_SETRAISES() { return getToken(IDLParser.KW_SETRAISES, 0); }
		public Exception_listContext exception_list() {
			return getRuleContext(Exception_listContext.class,0);
		}
		public Set_excep_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_excep_expr; }
	}

	public final Set_excep_exprContext set_excep_expr() throws RecognitionException {
		Set_excep_exprContext _localctx = new Set_excep_exprContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_set_excep_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1574);
			match(KW_SETRAISES);
			setState(1575);
			exception_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exception_listContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public List<Scoped_nameContext> scoped_name() {
			return getRuleContexts(Scoped_nameContext.class);
		}
		public Scoped_nameContext scoped_name(int i) {
			return getRuleContext(Scoped_nameContext.class,i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Exception_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exception_list; }
	}

	public final Exception_listContext exception_list() throws RecognitionException {
		Exception_listContext _localctx = new Exception_listContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_exception_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1577);
			match(LEFT_BRACKET);
			setState(1578);
			scoped_name();
			setState(1583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1579);
				match(COMA);
				setState(1580);
				scoped_name();
				}
				}
				setState(1585);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1586);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComponentContext extends ParserRuleContext {
		public Component_declContext component_decl() {
			return getRuleContext(Component_declContext.class,0);
		}
		public Component_forward_declContext component_forward_decl() {
			return getRuleContext(Component_forward_declContext.class,0);
		}
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_component);
		try {
			setState(1590);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1588);
				component_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1589);
				component_forward_decl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Component_forward_declContext extends ParserRuleContext {
		public TerminalNode KW_COMPONENT() { return getToken(IDLParser.KW_COMPONENT, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Component_forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_forward_decl; }
	}

	public final Component_forward_declContext component_forward_decl() throws RecognitionException {
		Component_forward_declContext _localctx = new Component_forward_declContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_component_forward_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1592);
			match(KW_COMPONENT);

			            System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Component declarations are not supported. Ignoring...");
			        
			setState(1594);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Component_declContext extends ParserRuleContext {
		public Component_headerContext component_header() {
			return getRuleContext(Component_headerContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Component_bodyContext component_body() {
			return getRuleContext(Component_bodyContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Component_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_decl; }
	}

	public final Component_declContext component_decl() throws RecognitionException {
		Component_declContext _localctx = new Component_declContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_component_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1596);
			component_header();
			setState(1597);
			match(LEFT_BRACE);
			setState(1598);
			component_body();
			setState(1599);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Component_headerContext extends ParserRuleContext {
		public TerminalNode KW_COMPONENT() { return getToken(IDLParser.KW_COMPONENT, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Component_inheritance_specContext component_inheritance_spec() {
			return getRuleContext(Component_inheritance_specContext.class,0);
		}
		public Supported_interface_specContext supported_interface_spec() {
			return getRuleContext(Supported_interface_specContext.class,0);
		}
		public Component_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_header; }
	}

	public final Component_headerContext component_header() throws RecognitionException {
		Component_headerContext _localctx = new Component_headerContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_component_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1601);
			match(KW_COMPONENT);
			setState(1602);
			match(ID);
			setState(1604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1603);
				component_inheritance_spec();
				}
			}

			setState(1607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_SUPPORTS) {
				{
				setState(1606);
				supported_interface_spec();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Supported_interface_specContext extends ParserRuleContext {
		public TerminalNode KW_SUPPORTS() { return getToken(IDLParser.KW_SUPPORTS, 0); }
		public List<Scoped_nameContext> scoped_name() {
			return getRuleContexts(Scoped_nameContext.class);
		}
		public Scoped_nameContext scoped_name(int i) {
			return getRuleContext(Scoped_nameContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Supported_interface_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_supported_interface_spec; }
	}

	public final Supported_interface_specContext supported_interface_spec() throws RecognitionException {
		Supported_interface_specContext _localctx = new Supported_interface_specContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_supported_interface_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1609);
			match(KW_SUPPORTS);
			setState(1610);
			scoped_name();
			setState(1615);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1611);
				match(COMA);
				setState(1612);
				scoped_name();
				}
				}
				setState(1617);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Component_inheritance_specContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Component_inheritance_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_inheritance_spec; }
	}

	public final Component_inheritance_specContext component_inheritance_spec() throws RecognitionException {
		Component_inheritance_specContext _localctx = new Component_inheritance_specContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_component_inheritance_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1618);
			match(COLON);
			setState(1619);
			scoped_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Component_bodyContext extends ParserRuleContext {
		public List<Component_exportContext> component_export() {
			return getRuleContexts(Component_exportContext.class);
		}
		public Component_exportContext component_export(int i) {
			return getRuleContext(Component_exportContext.class,i);
		}
		public Component_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_body; }
	}

	public final Component_bodyContext component_body() throws RecognitionException {
		Component_bodyContext _localctx = new Component_bodyContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_component_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1624);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (KW_EMITS - 40)) | (1L << (KW_PUBLISHES - 40)) | (1L << (KW_USES - 40)) | (1L << (KW_READONLY - 40)) | (1L << (KW_PROVIDES - 40)) | (1L << (KW_CONSUMES - 40)) | (1L << (KW_ATTRIBUTE - 40)))) != 0)) {
				{
				{
				setState(1621);
				component_export();
				}
				}
				setState(1626);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Component_exportContext extends ParserRuleContext {
		public Provides_declContext provides_decl() {
			return getRuleContext(Provides_declContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Uses_declContext uses_decl() {
			return getRuleContext(Uses_declContext.class,0);
		}
		public Emits_declContext emits_decl() {
			return getRuleContext(Emits_declContext.class,0);
		}
		public Publishes_declContext publishes_decl() {
			return getRuleContext(Publishes_declContext.class,0);
		}
		public Consumes_declContext consumes_decl() {
			return getRuleContext(Consumes_declContext.class,0);
		}
		public Attr_declContext attr_decl() {
			return getRuleContext(Attr_declContext.class,0);
		}
		public Component_exportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_export; }
	}

	public final Component_exportContext component_export() throws RecognitionException {
		Component_exportContext _localctx = new Component_exportContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_component_export);
		try {
			setState(1645);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PROVIDES:
				enterOuterAlt(_localctx, 1);
				{
				setState(1627);
				provides_decl();
				setState(1628);
				match(SEMICOLON);
				}
				break;
			case KW_USES:
				enterOuterAlt(_localctx, 2);
				{
				setState(1630);
				uses_decl();
				setState(1631);
				match(SEMICOLON);
				}
				break;
			case KW_EMITS:
				enterOuterAlt(_localctx, 3);
				{
				setState(1633);
				emits_decl();
				setState(1634);
				match(SEMICOLON);
				}
				break;
			case KW_PUBLISHES:
				enterOuterAlt(_localctx, 4);
				{
				setState(1636);
				publishes_decl();
				setState(1637);
				match(SEMICOLON);
				}
				break;
			case KW_CONSUMES:
				enterOuterAlt(_localctx, 5);
				{
				setState(1639);
				consumes_decl();
				setState(1640);
				match(SEMICOLON);
				}
				break;
			case KW_READONLY:
			case KW_ATTRIBUTE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1642);
				attr_decl();
				setState(1643);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Provides_declContext extends ParserRuleContext {
		public TerminalNode KW_PROVIDES() { return getToken(IDLParser.KW_PROVIDES, 0); }
		public Interface_typeContext interface_type() {
			return getRuleContext(Interface_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Provides_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_provides_decl; }
	}

	public final Provides_declContext provides_decl() throws RecognitionException {
		Provides_declContext _localctx = new Provides_declContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_provides_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1647);
			match(KW_PROVIDES);
			setState(1648);
			interface_type();
			setState(1649);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Interface_typeContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode KW_OBJECT() { return getToken(IDLParser.KW_OBJECT, 0); }
		public Interface_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interface_type; }
	}

	public final Interface_typeContext interface_type() throws RecognitionException {
		Interface_typeContext _localctx = new Interface_typeContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_interface_type);
		try {
			setState(1653);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1651);
				scoped_name();
				}
				break;
			case KW_OBJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1652);
				match(KW_OBJECT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Uses_declContext extends ParserRuleContext {
		public TerminalNode KW_USES() { return getToken(IDLParser.KW_USES, 0); }
		public Interface_typeContext interface_type() {
			return getRuleContext(Interface_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_MULTIPLE() { return getToken(IDLParser.KW_MULTIPLE, 0); }
		public Uses_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uses_decl; }
	}

	public final Uses_declContext uses_decl() throws RecognitionException {
		Uses_declContext _localctx = new Uses_declContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_uses_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1655);
			match(KW_USES);
			setState(1657);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MULTIPLE) {
				{
				setState(1656);
				match(KW_MULTIPLE);
				}
			}

			setState(1659);
			interface_type();
			setState(1660);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Emits_declContext extends ParserRuleContext {
		public TerminalNode KW_EMITS() { return getToken(IDLParser.KW_EMITS, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Emits_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emits_decl; }
	}

	public final Emits_declContext emits_decl() throws RecognitionException {
		Emits_declContext _localctx = new Emits_declContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_emits_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1662);
			match(KW_EMITS);
			setState(1663);
			scoped_name();
			setState(1664);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Publishes_declContext extends ParserRuleContext {
		public TerminalNode KW_PUBLISHES() { return getToken(IDLParser.KW_PUBLISHES, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Publishes_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_publishes_decl; }
	}

	public final Publishes_declContext publishes_decl() throws RecognitionException {
		Publishes_declContext _localctx = new Publishes_declContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_publishes_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1666);
			match(KW_PUBLISHES);
			setState(1667);
			scoped_name();
			setState(1668);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Consumes_declContext extends ParserRuleContext {
		public TerminalNode KW_CONSUMES() { return getToken(IDLParser.KW_CONSUMES, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Consumes_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consumes_decl; }
	}

	public final Consumes_declContext consumes_decl() throws RecognitionException {
		Consumes_declContext _localctx = new Consumes_declContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_consumes_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1670);
			match(KW_CONSUMES);
			setState(1671);
			scoped_name();
			setState(1672);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Home_declContext extends ParserRuleContext {
		public Home_headerContext home_header() {
			return getRuleContext(Home_headerContext.class,0);
		}
		public Home_bodyContext home_body() {
			return getRuleContext(Home_bodyContext.class,0);
		}
		public Home_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_decl; }
	}

	public final Home_declContext home_decl() throws RecognitionException {
		Home_declContext _localctx = new Home_declContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_home_decl);

		    System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Home declarations are not supported. Ignoring...");

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1674);
			home_header();
			setState(1675);
			home_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Home_headerContext extends ParserRuleContext {
		public TerminalNode KW_HOME() { return getToken(IDLParser.KW_HOME, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_MANAGES() { return getToken(IDLParser.KW_MANAGES, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Home_inheritance_specContext home_inheritance_spec() {
			return getRuleContext(Home_inheritance_specContext.class,0);
		}
		public Supported_interface_specContext supported_interface_spec() {
			return getRuleContext(Supported_interface_specContext.class,0);
		}
		public Primary_key_specContext primary_key_spec() {
			return getRuleContext(Primary_key_specContext.class,0);
		}
		public Home_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_header; }
	}

	public final Home_headerContext home_header() throws RecognitionException {
		Home_headerContext _localctx = new Home_headerContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_home_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1677);
			match(KW_HOME);
			setState(1678);
			match(ID);
			setState(1680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1679);
				home_inheritance_spec();
				}
			}

			setState(1683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_SUPPORTS) {
				{
				setState(1682);
				supported_interface_spec();
				}
			}

			setState(1685);
			match(KW_MANAGES);
			setState(1686);
			scoped_name();
			setState(1688);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_PRIMARYKEY) {
				{
				setState(1687);
				primary_key_spec();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Home_inheritance_specContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Home_inheritance_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_inheritance_spec; }
	}

	public final Home_inheritance_specContext home_inheritance_spec() throws RecognitionException {
		Home_inheritance_specContext _localctx = new Home_inheritance_specContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_home_inheritance_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1690);
			match(COLON);
			setState(1691);
			scoped_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_key_specContext extends ParserRuleContext {
		public TerminalNode KW_PRIMARYKEY() { return getToken(IDLParser.KW_PRIMARYKEY, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Primary_key_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_key_spec; }
	}

	public final Primary_key_specContext primary_key_spec() throws RecognitionException {
		Primary_key_specContext _localctx = new Primary_key_specContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_primary_key_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1693);
			match(KW_PRIMARYKEY);
			setState(1694);
			scoped_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Home_bodyContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public List<Home_exportContext> home_export() {
			return getRuleContexts(Home_exportContext.class);
		}
		public Home_exportContext home_export(int i) {
			return getRuleContext(Home_exportContext.class,i);
		}
		public Home_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_body; }
	}

	public final Home_bodyContext home_body() throws RecognitionException {
		Home_bodyContext _localctx = new Home_bodyContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_home_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1696);
			match(LEFT_BRACE);
			setState(1700);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_FINDER) | (1L << KW_VOID) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_FACTORY - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (KW_BITSET - 64)) | (1L << (KW_BITMASK - 64)) | (1L << (KW_INT8 - 64)) | (1L << (KW_UINT8 - 64)) | (1L << (KW_INT16 - 64)) | (1L << (KW_UINT16 - 64)) | (1L << (KW_INT32 - 64)) | (1L << (KW_UINT32 - 64)) | (1L << (KW_INT64 - 64)) | (1L << (KW_UINT64 - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1697);
				home_export();
				}
				}
				setState(1702);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1703);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Home_exportContext extends ParserRuleContext {
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public Factory_declContext factory_decl() {
			return getRuleContext(Factory_declContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Finder_declContext finder_decl() {
			return getRuleContext(Finder_declContext.class,0);
		}
		public Home_exportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_export; }
	}

	public final Home_exportContext home_export() throws RecognitionException {
		Home_exportContext _localctx = new Home_exportContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_home_export);
		try {
			setState(1712);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_TYPEDEF:
			case KW_OCTET:
			case KW_STRUCT:
			case KW_NATIVE:
			case KW_READONLY:
			case KW_VOID:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_ENUM:
			case KW_WSTRING:
			case KW_EXCEPTION:
			case KW_CONST:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_UNION:
			case KW_ONEWAY:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_TYPEPREFIX:
			case KW_TYPEID:
			case KW_ATTRIBUTE:
			case KW_BITSET:
			case KW_BITMASK:
			case KW_INT8:
			case KW_UINT8:
			case KW_INT16:
			case KW_UINT16:
			case KW_INT32:
			case KW_UINT32:
			case KW_INT64:
			case KW_UINT64:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1705);
				export(null);
				}
				break;
			case KW_FACTORY:
				enterOuterAlt(_localctx, 2);
				{
				setState(1706);
				factory_decl();
				setState(1707);
				match(SEMICOLON);
				}
				break;
			case KW_FINDER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1709);
				finder_decl();
				setState(1710);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Factory_declContext extends ParserRuleContext {
		public TerminalNode KW_FACTORY() { return getToken(IDLParser.KW_FACTORY, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Init_param_declsContext init_param_decls() {
			return getRuleContext(Init_param_declsContext.class,0);
		}
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public Factory_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factory_decl; }
	}

	public final Factory_declContext factory_decl() throws RecognitionException {
		Factory_declContext _localctx = new Factory_declContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_factory_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1714);
			match(KW_FACTORY);
			setState(1715);
			match(ID);
			setState(1716);
			match(LEFT_BRACKET);
			setState(1718);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_IN) {
				{
				setState(1717);
				init_param_decls();
				}
			}

			setState(1720);
			match(RIGHT_BRACKET);
			setState(1722);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_RAISES) {
				{
				setState(1721);
				raises_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Finder_declContext extends ParserRuleContext {
		public TerminalNode KW_FINDER() { return getToken(IDLParser.KW_FINDER, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Init_param_declsContext init_param_decls() {
			return getRuleContext(Init_param_declsContext.class,0);
		}
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public Finder_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finder_decl; }
	}

	public final Finder_declContext finder_decl() throws RecognitionException {
		Finder_declContext _localctx = new Finder_declContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_finder_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1724);
			match(KW_FINDER);
			setState(1725);
			match(ID);
			setState(1726);
			match(LEFT_BRACKET);
			setState(1728);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_IN) {
				{
				setState(1727);
				init_param_decls();
				}
			}

			setState(1730);
			match(RIGHT_BRACKET);
			setState(1732);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_RAISES) {
				{
				setState(1731);
				raises_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventContext extends ParserRuleContext {
		public Event_declContext event_decl() {
			return getRuleContext(Event_declContext.class,0);
		}
		public Event_abs_declContext event_abs_decl() {
			return getRuleContext(Event_abs_declContext.class,0);
		}
		public Event_forward_declContext event_forward_decl() {
			return getRuleContext(Event_forward_declContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_event);

		    System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Event declarations are not supported. Ignoring...");

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1737);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				{
				setState(1734);
				event_decl();
				}
				break;
			case 2:
				{
				setState(1735);
				event_abs_decl();
				}
				break;
			case 3:
				{
				setState(1736);
				event_forward_decl();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Event_forward_declContext extends ParserRuleContext {
		public TerminalNode KW_EVENTTYPE() { return getToken(IDLParser.KW_EVENTTYPE, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public Event_forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_forward_decl; }
	}

	public final Event_forward_declContext event_forward_decl() throws RecognitionException {
		Event_forward_declContext _localctx = new Event_forward_declContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_event_forward_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ABSTRACT) {
				{
				setState(1739);
				match(KW_ABSTRACT);
				}
			}

			setState(1742);
			match(KW_EVENTTYPE);
			setState(1743);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Event_abs_declContext extends ParserRuleContext {
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public TerminalNode KW_EVENTTYPE() { return getToken(IDLParser.KW_EVENTTYPE, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Value_inheritance_specContext value_inheritance_spec() {
			return getRuleContext(Value_inheritance_specContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public List<ExportContext> export() {
			return getRuleContexts(ExportContext.class);
		}
		public ExportContext export(int i) {
			return getRuleContext(ExportContext.class,i);
		}
		public Event_abs_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_abs_decl; }
	}

	public final Event_abs_declContext event_abs_decl() throws RecognitionException {
		Event_abs_declContext _localctx = new Event_abs_declContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_event_abs_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1745);
			match(KW_ABSTRACT);
			setState(1746);
			match(KW_EVENTTYPE);
			setState(1747);
			match(ID);
			setState(1748);
			value_inheritance_spec();
			setState(1749);
			match(LEFT_BRACE);
			setState(1753);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (KW_BITSET - 64)) | (1L << (KW_BITMASK - 64)) | (1L << (KW_INT8 - 64)) | (1L << (KW_UINT8 - 64)) | (1L << (KW_INT16 - 64)) | (1L << (KW_UINT16 - 64)) | (1L << (KW_INT32 - 64)) | (1L << (KW_UINT32 - 64)) | (1L << (KW_INT64 - 64)) | (1L << (KW_UINT64 - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1750);
				export(null);
				}
				}
				setState(1755);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1756);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Event_declContext extends ParserRuleContext {
		public Event_headerContext event_header() {
			return getRuleContext(Event_headerContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public List<Value_elementContext> value_element() {
			return getRuleContexts(Value_elementContext.class);
		}
		public Value_elementContext value_element(int i) {
			return getRuleContext(Value_elementContext.class,i);
		}
		public Event_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_decl; }
	}

	public final Event_declContext event_decl() throws RecognitionException {
		Event_declContext _localctx = new Event_declContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_event_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1758);
			event_header();
			setState(1759);
			match(LEFT_BRACE);
			setState(1763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_PRIVATE) | (1L << KW_WCHAR) | (1L << KW_PUBLIC) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_FACTORY - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (KW_BITSET - 64)) | (1L << (KW_BITMASK - 64)) | (1L << (KW_INT8 - 64)) | (1L << (KW_UINT8 - 64)) | (1L << (KW_INT16 - 64)) | (1L << (KW_UINT16 - 64)) | (1L << (KW_INT32 - 64)) | (1L << (KW_UINT32 - 64)) | (1L << (KW_INT64 - 64)) | (1L << (KW_UINT64 - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1760);
				value_element();
				}
				}
				setState(1765);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1766);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Event_headerContext extends ParserRuleContext {
		public TerminalNode KW_EVENTTYPE() { return getToken(IDLParser.KW_EVENTTYPE, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Value_inheritance_specContext value_inheritance_spec() {
			return getRuleContext(Value_inheritance_specContext.class,0);
		}
		public TerminalNode KW_CUSTOM() { return getToken(IDLParser.KW_CUSTOM, 0); }
		public Event_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_header; }
	}

	public final Event_headerContext event_header() throws RecognitionException {
		Event_headerContext _localctx = new Event_headerContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_event_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_CUSTOM) {
				{
				setState(1768);
				match(KW_CUSTOM);
				}
			}

			setState(1771);
			match(KW_EVENTTYPE);
			setState(1772);
			match(ID);
			setState(1773);
			value_inheritance_spec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_applContext extends ParserRuleContext {
		public Annotation annotation = null;
		public Scoped_nameContext scoped_name;
		public TerminalNode AT() { return getToken(IDLParser.AT, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Annotation_appl_paramsContext annotation_appl_params() {
			return getRuleContext(Annotation_appl_paramsContext.class,0);
		}
		public Annotation_applContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_appl; }
	}

	public final Annotation_applContext annotation_appl() throws RecognitionException {
		Annotation_applContext _localctx = new Annotation_applContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_annotation_appl);

		    AnnotationDeclaration anndecl = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1775);
			match(AT);
			setState(1776);
			((Annotation_applContext)_localctx).scoped_name = scoped_name();

			        anndecl = ctx.getAnnotationDeclaration(((Annotation_applContext)_localctx).scoped_name.pair.first());
			        if(anndecl == null)
			        {
			            System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Annotation " + ((Annotation_applContext)_localctx).scoped_name.pair.first() + " not supported. Ignoring...");
			        }
			        else
			        {
			            ((Annotation_applContext)_localctx).annotation =  new Annotation(anndecl);
			        }
			    
			setState(1783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(1778);
				match(LEFT_BRACKET);
				setState(1780);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << INTEGER_LITERAL) | (1L << HEX_LITERAL) | (1L << FLOATING_PT_LITERAL) | (1L << FIXED_PT_LITERAL) | (1L << WIDE_CHARACTER_LITERAL) | (1L << CHARACTER_LITERAL) | (1L << WIDE_STRING_LITERAL) | (1L << STRING_LITERAL) | (1L << LEFT_BRACKET) | (1L << TILDE) | (1L << PLUS) | (1L << MINUS) | (1L << DOUBLE_COLON))) != 0) || _la==ID) {
					{
					setState(1779);
					annotation_appl_params(_localctx.annotation, ((Annotation_applContext)_localctx).scoped_name.pair.second());
					}
				}

				setState(1782);
				match(RIGHT_BRACKET);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_appl_paramsContext extends ParserRuleContext {
		public Annotation annotation;
		public Token tkannot;
		public Const_expContext const_exp;
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public List<Annotation_appl_paramContext> annotation_appl_param() {
			return getRuleContexts(Annotation_appl_paramContext.class);
		}
		public Annotation_appl_paramContext annotation_appl_param(int i) {
			return getRuleContext(Annotation_appl_paramContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Annotation_appl_paramsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_appl_paramsContext(ParserRuleContext parent, int invokingState, Annotation annotation, Token tkannot) {
			super(parent, invokingState);
			this.annotation = annotation;
			this.tkannot = tkannot;
		}
		@Override public int getRuleIndex() { return RULE_annotation_appl_params; }
	}

	public final Annotation_appl_paramsContext annotation_appl_params(Annotation annotation,Token tkannot) throws RecognitionException {
		Annotation_appl_paramsContext _localctx = new Annotation_appl_paramsContext(_ctx, getState(), annotation, tkannot);
		enterRule(_localctx, 324, RULE_annotation_appl_params);
		int _la;
		try {
			setState(1796);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1785);
				((Annotation_appl_paramsContext)_localctx).const_exp = const_exp();

				        if(annotation != null && !annotation.addValue(((Annotation_appl_paramsContext)_localctx).const_exp.literalStr))
				            throw new ParseException(tkannot, "not has only one attribute.");
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1788);
				annotation_appl_param(annotation);
				setState(1793);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(1789);
					match(COMA);
					setState(1790);
					annotation_appl_param(annotation);
					}
					}
					setState(1795);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Annotation_appl_paramContext extends ParserRuleContext {
		public Annotation annotation;
		public IdentifierContext identifier;
		public Const_expContext const_exp;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(IDLParser.EQUAL, 0); }
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public Annotation_appl_paramContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_appl_paramContext(ParserRuleContext parent, int invokingState, Annotation annotation) {
			super(parent, invokingState);
			this.annotation = annotation;
		}
		@Override public int getRuleIndex() { return RULE_annotation_appl_param; }
	}

	public final Annotation_appl_paramContext annotation_appl_param(Annotation annotation) throws RecognitionException {
		Annotation_appl_paramContext _localctx = new Annotation_appl_paramContext(_ctx, getState(), annotation);
		enterRule(_localctx, 326, RULE_annotation_appl_param);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1798);
			((Annotation_appl_paramContext)_localctx).identifier = identifier();
			setState(1799);
			match(EQUAL);
			setState(1800);
			((Annotation_appl_paramContext)_localctx).const_exp = const_exp();

			        if(annotation != null && !annotation.addValue(((Annotation_appl_paramContext)_localctx).identifier.id, ((Annotation_appl_paramContext)_localctx).const_exp.literalStr))
			            throw new ParseException(tk, "is not an attribute of annotation " + annotation.getName());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public String id;
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_identifier);

		    ((IdentifierContext)_localctx).id =  _input.LT(1).getText();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1803);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3y\u0710\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\3\2\7\2\u014e\n\2\f\2\16\2\u0151\13\2"+
		"\3\2\3\2\3\2\6\2\u0156\n\2\r\2\16\2\u0157\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u018b\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\6\6\u019d\n\6\r\6\16\6\u019e\3\7"+
		"\3\7\3\7\3\7\5\7\u01a5\n\7\3\b\5\b\u01a8\n\b\3\b\3\b\3\b\3\b\3\b\5\b\u01af"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\5\t\u01b9\n\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\7\n\u01c3\n\n\f\n\16\n\u01c6\13\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u01e7"+
		"\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\7\17\u01f9\n\17\f\17\16\17\u01fc\13\17\3\20\3\20\5\20\u0200\n"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0209\n\20\f\20\16\20\u020c"+
		"\13\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u0214\n\21\3\22\5\22\u0217\n"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\7"+
		"\24\u0226\n\24\f\24\16\24\u0229\13\24\3\24\3\24\3\25\3\25\3\25\7\25\u0230"+
		"\n\25\f\25\16\25\u0233\13\25\3\25\3\25\3\26\5\26\u0238\n\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\5\27\u0240\n\27\3\27\3\27\3\27\7\27\u0245\n\27\f"+
		"\27\16\27\u0248\13\27\5\27\u024a\n\27\3\27\3\27\3\27\3\27\7\27\u0250\n"+
		"\27\f\27\16\27\u0253\13\27\5\27\u0255\n\27\3\30\3\30\3\31\3\31\3\31\5"+
		"\31\u025c\n\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\5\33\u0267"+
		"\n\33\3\33\3\33\5\33\u026b\n\33\3\33\3\33\3\34\3\34\3\34\7\34\u0272\n"+
		"\34\f\34\16\34\u0275\13\34\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u02a3\n \3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u02af\n\"\f\"\16\"\u02b2\13\"\3#\3#"+
		"\3#\3#\3#\3#\3#\7#\u02bb\n#\f#\16#\u02be\13#\3$\3$\3$\3$\3$\3$\3$\7$\u02c7"+
		"\n$\f$\16$\u02ca\13$\3%\3%\3%\3%\3%\3%\3%\7%\u02d3\n%\f%\16%\u02d6\13"+
		"%\3&\3&\3&\3&\3&\3&\3&\7&\u02df\n&\f&\16&\u02e2\13&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\7\'\u02eb\n\'\f\'\16\'\u02ee\13\'\3(\3(\3(\3(\3(\3(\3(\3(\5"+
		"(\u02f8\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0306\n)\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\5*\u0313\n*\3*\3*\3+\3+\3+\3+\5+\u031b\n+\3,\3"+
		",\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3-\3-\3-\5-\u0339\n-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\5/\u0345\n/\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0350\n\60\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u035b\n\61\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\5\62\u0372\n\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u0384\n\63\3\64\3\64\3\64\3\64"+
		"\3\64\5\64\u038b\n\64\3\65\3\65\3\65\3\65\3\65\3\65\7\65\u0393\n\65\f"+
		"\65\16\65\u0396\13\65\3\66\3\66\3\66\3\66\3\66\3\66\7\66\u039e\n\66\f"+
		"\66\16\66\u03a1\13\66\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u03a9\n\67\3"+
		"8\38\38\39\39\39\3:\3:\3:\3:\3:\3:\3:\5:\u03b8\n:\3;\3;\3;\3;\3;\3;\5"+
		";\u03c0\n;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u03ce\n<\3=\3=\3>\3"+
		">\3?\3?\3@\3@\3@\5@\u03d9\n@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\5A\u03e7"+
		"\nA\3B\3B\3C\3C\3C\5C\u03ee\nC\3D\3D\3D\5D\u03f3\nD\3E\3E\3E\3E\5E\u03f9"+
		"\nE\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3J\3K\3K\3K\3L\3L\3L\3L\5L\u040d\nL"+
		"\3M\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\5N\u041a\nN\3O\3O\3O\3O\3P\7P\u0421"+
		"\nP\fP\16P\u0424\13P\3Q\3Q\3Q\3Q\3Q\3Q\5Q\u042c\nQ\3Q\3Q\3Q\3R\3R\3R\3"+
		"S\3S\3S\3S\3S\3S\3S\5S\u043b\nS\3S\3S\3S\3S\3S\3T\3T\3T\3T\3T\3T\3T\3"+
		"T\3T\6T\u044b\nT\rT\16T\u044c\3U\3U\3U\3U\3U\3U\3U\3U\3U\3U\3U\3U\3U\3"+
		"U\3U\3U\3U\5U\u0460\nU\3V\3V\3V\3V\3V\3V\3V\3V\3W\3W\3W\7W\u046d\nW\f"+
		"W\16W\u0470\13W\3W\3W\3W\3W\3W\3W\7W\u0478\nW\fW\16W\u047b\13W\3W\3W\3"+
		"W\7W\u0480\nW\fW\16W\u0483\13W\3X\3X\3X\3X\3X\3X\3X\5X\u048c\nX\3X\3X"+
		"\3X\3X\3X\3X\3X\3X\3X\5X\u0497\nX\3Y\3Y\3Y\7Y\u049c\nY\fY\16Y\u049f\13"+
		"Y\3Z\3Z\3Z\3Z\3Z\3Z\3Z\5Z\u04a8\nZ\3[\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3\\"+
		"\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\5\\\u04c1\n\\\3]"+
		"\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04d6\n]\3^"+
		"\3^\3_\6_\u04db\n_\r_\16_\u04dc\3`\3`\3`\3`\3`\3`\3`\3`\6`\u04e7\n`\r"+
		"`\16`\u04e8\3`\3`\3`\3`\3a\3a\3a\3a\3b\3b\3b\3b\3b\3b\3b\3b\3c\3c\3c\7"+
		"c\u04fe\nc\fc\16c\u0501\13c\3d\3d\3d\3e\3e\3e\3e\3e\3e\3e\3e\3e\3e\3e"+
		"\3e\3e\3e\3e\5e\u0515\ne\3e\3e\3f\3f\3f\3f\3f\3f\3f\3f\3f\3f\3f\3f\3f"+
		"\3f\3f\5f\u0528\nf\3f\3f\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\5g\u0537\ng"+
		"\3g\3g\3g\3h\3h\3h\3h\3h\3h\3h\5h\u0543\nh\3h\3h\3i\3i\3i\3i\3i\3i\3i"+
		"\5i\u054e\ni\3i\3i\3j\3j\3j\3j\6j\u0556\nj\rj\16j\u0557\3j\3j\3k\3k\3"+
		"k\3k\3k\3l\3l\3l\3l\5l\u0565\nl\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3n\3n\3"+
		"n\7n\u0574\nn\fn\16n\u0577\13n\3o\3o\3o\5o\u057c\no\3o\3o\3o\3o\3o\3o"+
		"\3o\3o\3o\3o\3o\5o\u0589\no\3o\5o\u058c\no\3o\3o\3p\3p\3p\3q\3q\3q\3q"+
		"\5q\u0597\nq\3r\3r\5r\u059b\nr\3r\3r\3s\3s\3s\3s\3s\3s\3s\3s\7s\u05a7"+
		"\ns\fs\16s\u05aa\13s\3t\3t\3t\3t\3t\3t\3u\3u\3u\3u\3u\3u\3v\3v\3v\3v\3"+
		"v\7v\u05bd\nv\fv\16v\u05c0\13v\3v\3v\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w"+
		"\3w\5w\u05d0\nw\3x\3x\3x\3x\3x\3x\3x\3x\3y\3y\3y\3z\3z\3z\3{\3{\3{\3{"+
		"\5{\u05e4\n{\3|\3|\3|\3|\3|\3}\3}\5}\u05ed\n}\3~\3~\3~\3~\3~\3\177\3\177"+
		"\3\177\3\177\3\177\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081"+
		"\3\u0081\3\u0081\3\u0081\3\u0081\7\u0081\u0604\n\u0081\f\u0081\16\u0081"+
		"\u0607\13\u0081\5\u0081\u0609\n\u0081\3\u0082\3\u0082\3\u0082\3\u0082"+
		"\3\u0082\3\u0082\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\7\u0083\u0618\n\u0083\f\u0083\16\u0083\u061b\13\u0083\5\u0083\u061d\n"+
		"\u0083\3\u0084\3\u0084\5\u0084\u0621\n\u0084\3\u0084\5\u0084\u0624\n\u0084"+
		"\3\u0085\3\u0085\3\u0085\3\u0086\3\u0086\3\u0086\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\7\u0087\u0630\n\u0087\f\u0087\16\u0087\u0633\13\u0087\3\u0087"+
		"\3\u0087\3\u0088\3\u0088\5\u0088\u0639\n\u0088\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008b\3\u008b\3\u008b"+
		"\5\u008b\u0647\n\u008b\3\u008b\5\u008b\u064a\n\u008b\3\u008c\3\u008c\3"+
		"\u008c\3\u008c\7\u008c\u0650\n\u008c\f\u008c\16\u008c\u0653\13\u008c\3"+
		"\u008d\3\u008d\3\u008d\3\u008e\7\u008e\u0659\n\u008e\f\u008e\16\u008e"+
		"\u065c\13\u008e\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\5\u008f\u0670\n\u008f\3\u0090\3\u0090\3\u0090\3\u0090"+
		"\3\u0091\3\u0091\5\u0091\u0678\n\u0091\3\u0092\3\u0092\5\u0092\u067c\n"+
		"\u0092\3\u0092\3\u0092\3\u0092\3\u0093\3\u0093\3\u0093\3\u0093\3\u0094"+
		"\3\u0094\3\u0094\3\u0094\3\u0095\3\u0095\3\u0095\3\u0095\3\u0096\3\u0096"+
		"\3\u0096\3\u0097\3\u0097\3\u0097\5\u0097\u0693\n\u0097\3\u0097\5\u0097"+
		"\u0696\n\u0097\3\u0097\3\u0097\3\u0097\5\u0097\u069b\n\u0097\3\u0098\3"+
		"\u0098\3\u0098\3\u0099\3\u0099\3\u0099\3\u009a\3\u009a\7\u009a\u06a5\n"+
		"\u009a\f\u009a\16\u009a\u06a8\13\u009a\3\u009a\3\u009a\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\5\u009b\u06b3\n\u009b\3\u009c"+
		"\3\u009c\3\u009c\3\u009c\5\u009c\u06b9\n\u009c\3\u009c\3\u009c\5\u009c"+
		"\u06bd\n\u009c\3\u009d\3\u009d\3\u009d\3\u009d\5\u009d\u06c3\n\u009d\3"+
		"\u009d\3\u009d\5\u009d\u06c7\n\u009d\3\u009e\3\u009e\3\u009e\5\u009e\u06cc"+
		"\n\u009e\3\u009f\5\u009f\u06cf\n\u009f\3\u009f\3\u009f\3\u009f\3\u00a0"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\7\u00a0\u06da\n\u00a0\f\u00a0"+
		"\16\u00a0\u06dd\13\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a1\7\u00a1"+
		"\u06e4\n\u00a1\f\u00a1\16\u00a1\u06e7\13\u00a1\3\u00a1\3\u00a1\3\u00a2"+
		"\5\u00a2\u06ec\n\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a3\3\u00a3"+
		"\3\u00a3\3\u00a3\3\u00a3\5\u00a3\u06f7\n\u00a3\3\u00a3\5\u00a3\u06fa\n"+
		"\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\7\u00a4\u0702\n"+
		"\u00a4\f\u00a4\16\u00a4\u0705\13\u00a4\5\u00a4\u0707\n\u00a4\3\u00a5\3"+
		"\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a6\2\2\u00a7\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6"+
		"\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be"+
		"\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6"+
		"\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee"+
		"\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106"+
		"\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e"+
		"\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136"+
		"\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146\u0148\u014a\2\13\4\2"+
		"[[cc\4\2;;@@\3\2&\'\3\2\35\36\5\2\31\31\34\34##\4\2\30\30\35\36\4\2AA"+
		"nn\4\2BBpp\5\2))>>\\\\\2\u0736\2\u014f\3\2\2\2\4\u018a\3\2\2\2\6\u018c"+
		"\3\2\2\2\b\u018f\3\2\2\2\n\u019c\3\2\2\2\f\u01a4\3\2\2\2\16\u01a7\3\2"+
		"\2\2\20\u01b8\3\2\2\2\22\u01c4\3\2\2\2\24\u01e6\3\2\2\2\26\u01e8\3\2\2"+
		"\2\30\u01eb\3\2\2\2\32\u01f0\3\2\2\2\34\u01f2\3\2\2\2\36\u01ff\3\2\2\2"+
		" \u0213\3\2\2\2\"\u0216\3\2\2\2$\u021b\3\2\2\2&\u021f\3\2\2\2(\u022c\3"+
		"\2\2\2*\u0237\3\2\2\2,\u0249\3\2\2\2.\u0256\3\2\2\2\60\u025b\3\2\2\2\62"+
		"\u025d\3\2\2\2\64\u0262\3\2\2\2\66\u026e\3\2\2\28\u0276\3\2\2\2:\u027a"+
		"\3\2\2\2<\u027c\3\2\2\2>\u02a2\3\2\2\2@\u02a4\3\2\2\2B\u02a7\3\2\2\2D"+
		"\u02b3\3\2\2\2F\u02bf\3\2\2\2H\u02cb\3\2\2\2J\u02d7\3\2\2\2L\u02e3\3\2"+
		"\2\2N\u02f7\3\2\2\2P\u0305\3\2\2\2R\u0312\3\2\2\2T\u031a\3\2\2\2V\u031c"+
		"\3\2\2\2X\u0338\3\2\2\2Z\u033c\3\2\2\2\\\u0344\3\2\2\2^\u034f\3\2\2\2"+
		"`\u035a\3\2\2\2b\u0371\3\2\2\2d\u0383\3\2\2\2f\u038a\3\2\2\2h\u038c\3"+
		"\2\2\2j\u0397\3\2\2\2l\u03a8\3\2\2\2n\u03aa\3\2\2\2p\u03ad\3\2\2\2r\u03b7"+
		"\3\2\2\2t\u03bf\3\2\2\2v\u03cd\3\2\2\2x\u03cf\3\2\2\2z\u03d1\3\2\2\2|"+
		"\u03d3\3\2\2\2~\u03d8\3\2\2\2\u0080\u03e6\3\2\2\2\u0082\u03e8\3\2\2\2"+
		"\u0084\u03ed\3\2\2\2\u0086\u03f2\3\2\2\2\u0088\u03f8\3\2\2\2\u008a\u03fa"+
		"\3\2\2\2\u008c\u03fc\3\2\2\2\u008e\u03fe\3\2\2\2\u0090\u0400\3\2\2\2\u0092"+
		"\u0402\3\2\2\2\u0094\u0405\3\2\2\2\u0096\u040c\3\2\2\2\u0098\u040e\3\2"+
		"\2\2\u009a\u0414\3\2\2\2\u009c\u041b\3\2\2\2\u009e\u0422\3\2\2\2\u00a0"+
		"\u0425\3\2\2\2\u00a2\u0430\3\2\2\2\u00a4\u0433\3\2\2\2\u00a6\u044a\3\2"+
		"\2\2\u00a8\u045f\3\2\2\2\u00aa\u0461\3\2\2\2\u00ac\u046e\3\2\2\2\u00ae"+
		"\u0496\3\2\2\2\u00b0\u049d\3\2\2\2\u00b2\u04a7\3\2\2\2\u00b4\u04a9\3\2"+
		"\2\2\u00b6\u04c0\3\2\2\2\u00b8\u04d5\3\2\2\2\u00ba\u04d7\3\2\2\2\u00bc"+
		"\u04da\3\2\2\2\u00be\u04e6\3\2\2\2\u00c0\u04ee\3\2\2\2\u00c2\u04f2\3\2"+
		"\2\2\u00c4\u04fa\3\2\2\2\u00c6\u0502\3\2\2\2\u00c8\u0514\3\2\2\2\u00ca"+
		"\u0527\3\2\2\2\u00cc\u052b\3\2\2\2\u00ce\u0542\3\2\2\2\u00d0\u054d\3\2"+
		"\2\2\u00d2\u0551\3\2\2\2\u00d4\u055b\3\2\2\2\u00d6\u0564\3\2\2\2\u00d8"+
		"\u0566\3\2\2\2\u00da\u0575\3\2\2\2\u00dc\u057b\3\2\2\2\u00de\u058f\3\2"+
		"\2\2\u00e0\u0596\3\2\2\2\u00e2\u0598\3\2\2\2\u00e4\u059e\3\2\2\2\u00e6"+
		"\u05ab\3\2\2\2\u00e8\u05b1\3\2\2\2\u00ea\u05b7\3\2\2\2\u00ec\u05cf\3\2"+
		"\2\2\u00ee\u05d1\3\2\2\2\u00f0\u05d9\3\2\2\2\u00f2\u05dc\3\2\2\2\u00f4"+
		"\u05e3\3\2\2\2\u00f6\u05e5\3\2\2\2\u00f8\u05ec\3\2\2\2\u00fa\u05ee\3\2"+
		"\2\2\u00fc\u05f3\3\2\2\2\u00fe\u05f8\3\2\2\2\u0100\u0608\3\2\2\2\u0102"+
		"\u060a\3\2\2\2\u0104\u0610\3\2\2\2\u0106\u0623\3\2\2\2\u0108\u0625\3\2"+
		"\2\2\u010a\u0628\3\2\2\2\u010c\u062b\3\2\2\2\u010e\u0638\3\2\2\2\u0110"+
		"\u063a\3\2\2\2\u0112\u063e\3\2\2\2\u0114\u0643\3\2\2\2\u0116\u064b\3\2"+
		"\2\2\u0118\u0654\3\2\2\2\u011a\u065a\3\2\2\2\u011c\u066f\3\2\2\2\u011e"+
		"\u0671\3\2\2\2\u0120\u0677\3\2\2\2\u0122\u0679\3\2\2\2\u0124\u0680\3\2"+
		"\2\2\u0126\u0684\3\2\2\2\u0128\u0688\3\2\2\2\u012a\u068c\3\2\2\2\u012c"+
		"\u068f\3\2\2\2\u012e\u069c\3\2\2\2\u0130\u069f\3\2\2\2\u0132\u06a2\3\2"+
		"\2\2\u0134\u06b2\3\2\2\2\u0136\u06b4\3\2\2\2\u0138\u06be\3\2\2\2\u013a"+
		"\u06cb\3\2\2\2\u013c\u06ce\3\2\2\2\u013e\u06d3\3\2\2\2\u0140\u06e0\3\2"+
		"\2\2\u0142\u06eb\3\2\2\2\u0144\u06f1\3\2\2\2\u0146\u0706\3\2\2\2\u0148"+
		"\u0708\3\2\2\2\u014a\u070d\3\2\2\2\u014c\u014e\5\u00f6|\2\u014d\u014c"+
		"\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0155\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0153\5\4\3\2\u0153\u0154\b\2"+
		"\1\2\u0154\u0156\3\2\2\2\u0155\u0152\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\b\2"+
		"\1\2\u015a\3\3\2\2\2\u015b\u015c\5X-\2\u015c\u015d\7\17\2\2\u015d\u015e"+
		"\b\3\1\2\u015e\u018b\3\2\2\2\u015f\u0160\5<\37\2\u0160\u0161\7\17\2\2"+
		"\u0161\u0162\b\3\1\2\u0162\u018b\3\2\2\2\u0163\u0164\5\u00d8m\2\u0164"+
		"\u0165\7\17\2\2\u0165\u0166\b\3\1\2\u0166\u018b\3\2\2\2\u0167\u0168\5"+
		"\f\7\2\u0168\u0169\7\17\2\2\u0169\u016a\b\3\1\2\u016a\u018b\3\2\2\2\u016b"+
		"\u016c\5\b\5\2\u016c\u016d\7\17\2\2\u016d\u016e\b\3\1\2\u016e\u018b\3"+
		"\2\2\2\u016f\u0170\5 \21\2\u0170\u0171\7\17\2\2\u0171\u018b\3\2\2\2\u0172"+
		"\u0173\5\u00fa~\2\u0173\u0174\7\17\2\2\u0174\u018b\3\2\2\2\u0175\u0176"+
		"\5\u00fc\177\2\u0176\u0177\7\17\2\2\u0177\u018b\3\2\2\2\u0178\u0179\5"+
		"\u013a\u009e\2\u0179\u017a\7\17\2\2\u017a\u018b\3\2\2\2\u017b\u017c\5"+
		"\u010e\u0088\2\u017c\u017d\7\17\2\2\u017d\u018b\3\2\2\2\u017e\u017f\5"+
		"\u012a\u0096\2\u017f\u0180\7\17\2\2\u0180\u018b\3\2\2\2\u0181\u0182\5"+
		"\u0096L\2\u0182\u0183\7\17\2\2\u0183\u0184\b\3\1\2\u0184\u018b\3\2\2\2"+
		"\u0185\u0186\5\u0144\u00a3\2\u0186\u0187\b\3\1\2\u0187\u0188\5\6\4\2\u0188"+
		"\u0189\b\3\1\2\u0189\u018b\3\2\2\2\u018a\u015b\3\2\2\2\u018a\u015f\3\2"+
		"\2\2\u018a\u0163\3\2\2\2\u018a\u0167\3\2\2\2\u018a\u016b\3\2\2\2\u018a"+
		"\u016f\3\2\2\2\u018a\u0172\3\2\2\2\u018a\u0175\3\2\2\2\u018a\u0178\3\2"+
		"\2\2\u018a\u017b\3\2\2\2\u018a\u017e\3\2\2\2\u018a\u0181\3\2\2\2\u018a"+
		"\u0185\3\2\2\2\u018b\5\3\2\2\2\u018c\u018d\5\4\3\2\u018d\u018e\b\4\1\2"+
		"\u018e\7\3\2\2\2\u018f\u0190\7N\2\2\u0190\u0191\b\5\1\2\u0191\u0192\5"+
		"\u014a\u00a6\2\u0192\u0193\b\5\1\2\u0193\u0194\7\22\2\2\u0194\u0195\5"+
		"\n\6\2\u0195\u0196\b\5\1\2\u0196\u0197\7\23\2\2\u0197\u0198\b\5\1\2\u0198"+
		"\t\3\2\2\2\u0199\u019a\5\4\3\2\u019a\u019b\b\6\1\2\u019b\u019d\3\2\2\2"+
		"\u019c\u0199\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f"+
		"\3\2\2\2\u019f\13\3\2\2\2\u01a0\u01a1\5\16\b\2\u01a1\u01a2\b\7\1\2\u01a2"+
		"\u01a5\3\2\2\2\u01a3\u01a5\5\20\t\2\u01a4\u01a0\3\2\2\2\u01a4\u01a3\3"+
		"\2\2\2\u01a5\r\3\2\2\2\u01a6\u01a8\t\2\2\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8"+
		"\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\7e\2\2\u01aa\u01ab\b\b\1\2\u01ab"+
		"\u01ac\5\u014a\u00a6\2\u01ac\u01ae\b\b\1\2\u01ad\u01af\5\30\r\2\u01ae"+
		"\u01ad\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\7\22"+
		"\2\2\u01b1\u01b2\5\22\n\2\u01b2\u01b3\b\b\1\2\u01b3\u01b4\7\23\2\2\u01b4"+
		"\u01b5\3\2\2\2\u01b5\u01b6\b\b\1\2\u01b6\17\3\2\2\2\u01b7\u01b9\t\2\2"+
		"\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb"+
		"\7e\2\2\u01bb\u01bc\b\t\1\2\u01bc\u01bd\5\u014a\u00a6\2\u01bd\u01be\b"+
		"\t\1\2\u01be\21\3\2\2\2\u01bf\u01c0\5\24\13\2\u01c0\u01c1\b\n\1\2\u01c1"+
		"\u01c3\3\2\2\2\u01c2\u01bf\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2"+
		"\2\2\u01c4\u01c5\3\2\2\2\u01c5\23\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8"+
		"\5X-\2\u01c8\u01c9\7\17\2\2\u01c9\u01ca\b\13\1\2\u01ca\u01e7\3\2\2\2\u01cb"+
		"\u01cc\5<\37\2\u01cc\u01cd\7\17\2\2\u01cd\u01ce\b\13\1\2\u01ce\u01e7\3"+
		"\2\2\2\u01cf\u01d0\5\u00d8m\2\u01d0\u01d1\7\17\2\2\u01d1\u01d2\b\13\1"+
		"\2\u01d2\u01e7\3\2\2\2\u01d3\u01d4\5\u00d6l\2\u01d4\u01d5\7\17\2\2\u01d5"+
		"\u01d6\b\13\1\2\u01d6\u01e7\3\2\2\2\u01d7\u01d8\5\u00dco\2\u01d8\u01d9"+
		"\7\17\2\2\u01d9\u01da\b\13\1\2\u01da\u01e7\3\2\2\2\u01db\u01dc\5\u00fa"+
		"~\2\u01dc\u01dd\7\17\2\2\u01dd\u01e7\3\2\2\2\u01de\u01df\5\u00fc\177\2"+
		"\u01df\u01e0\7\17\2\2\u01e0\u01e7\3\2\2\2\u01e1\u01e2\5\u0144\u00a3\2"+
		"\u01e2\u01e3\b\13\1\2\u01e3\u01e4\5\26\f\2\u01e4\u01e5\b\13\1\2\u01e5"+
		"\u01e7\3\2\2\2\u01e6\u01c7\3\2\2\2\u01e6\u01cb\3\2\2\2\u01e6\u01cf\3\2"+
		"\2\2\u01e6\u01d3\3\2\2\2\u01e6\u01d7\3\2\2\2\u01e6\u01db\3\2\2\2\u01e6"+
		"\u01de\3\2\2\2\u01e6\u01e1\3\2\2\2\u01e7\25\3\2\2\2\u01e8\u01e9\5\24\13"+
		"\2\u01e9\u01ea\b\f\1\2\u01ea\27\3\2\2\2\u01eb\u01ec\7\20\2\2\u01ec\u01ed"+
		"\5\34\17\2\u01ed\u01ee\b\r\1\2\u01ee\u01ef\b\r\1\2\u01ef\31\3\2\2\2\u01f0"+
		"\u01f1\5\36\20\2\u01f1\33\3\2\2\2\u01f2\u01f3\5\36\20\2\u01f3\u01fa\b"+
		"\17\1\2\u01f4\u01f5\7\21\2\2\u01f5\u01f6\5\36\20\2\u01f6\u01f7\b\17\1"+
		"\2\u01f7\u01f9\3\2\2\2\u01f8\u01f4\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa\u01f8"+
		"\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\35\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fd"+
		"\u01fe\b\20\1\2\u01fe\u0200\7%\2\2\u01ff\u01fd\3\2\2\2\u01ff\u0200\3\2"+
		"\2\2\u0200\u0201\3\2\2\2\u0201\u0202\b\20\1\2\u0202\u020a\7u\2\2\u0203"+
		"\u0204\b\20\1\2\u0204\u0205\7%\2\2\u0205\u0206\5\u014a\u00a6\2\u0206\u0207"+
		"\b\20\1\2\u0207\u0209\3\2\2\2\u0208\u0203\3\2\2\2\u0209\u020c\3\2\2\2"+
		"\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\3\2\2\2\u020c\u020a"+
		"\3\2\2\2\u020d\u020e\b\20\1\2\u020e\37\3\2\2\2\u020f\u0214\5(\25\2\u0210"+
		"\u0214\5&\24\2\u0211\u0214\5$\23\2\u0212\u0214\5\"\22\2\u0213\u020f\3"+
		"\2\2\2\u0213\u0210\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0212\3\2\2\2\u0214"+
		"!\3\2\2\2\u0215\u0217\7[\2\2\u0216\u0215\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"\u0218\3\2\2\2\u0218\u0219\7L\2\2\u0219\u021a\7u\2\2\u021a#\3\2\2\2\u021b"+
		"\u021c\7L\2\2\u021c\u021d\7u\2\2\u021d\u021e\5\\/\2\u021e%\3\2\2\2\u021f"+
		"\u0220\7[\2\2\u0220\u0221\7L\2\2\u0221\u0222\7u\2\2\u0222\u0223\5,\27"+
		"\2\u0223\u0227\7\22\2\2\u0224\u0226\5\24\13\2\u0225\u0224\3\2\2\2\u0226"+
		"\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u022a\3\2"+
		"\2\2\u0229\u0227\3\2\2\2\u022a\u022b\7\23\2\2\u022b\'\3\2\2\2\u022c\u022d"+
		"\5*\26\2\u022d\u0231\7\22\2\2\u022e\u0230\5\60\31\2\u022f\u022e\3\2\2"+
		"\2\u0230\u0233\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0234"+
		"\3\2\2\2\u0233\u0231\3\2\2\2\u0234\u0235\7\23\2\2\u0235)\3\2\2\2\u0236"+
		"\u0238\7\61\2\2\u0237\u0236\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u0239\3"+
		"\2\2\2\u0239\u023a\7L\2\2\u023a\u023b\7u\2\2\u023b\u023c\5,\27\2\u023c"+
		"+\3\2\2\2\u023d\u023f\7\20\2\2\u023e\u0240\7P\2\2\u023f\u023e\3\2\2\2"+
		"\u023f\u0240\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0246\5.\30\2\u0242\u0243"+
		"\7\21\2\2\u0243\u0245\5.\30\2\u0244\u0242\3\2\2\2\u0245\u0248\3\2\2\2"+
		"\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u024a\3\2\2\2\u0248\u0246"+
		"\3\2\2\2\u0249\u023d\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u0254\3\2\2\2\u024b"+
		"\u024c\7M\2\2\u024c\u0251\5\32\16\2\u024d\u024e\7\21\2\2\u024e\u0250\5"+
		"\32\16\2\u024f\u024d\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u024f\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u0255\3\2\2\2\u0253\u0251\3\2\2\2\u0254\u024b\3\2"+
		"\2\2\u0254\u0255\3\2\2\2\u0255-\3\2\2\2\u0256\u0257\5\36\20\2\u0257/\3"+
		"\2\2\2\u0258\u025c\5\24\13\2\u0259\u025c\5\62\32\2\u025a\u025c\5\64\33"+
		"\2\u025b\u0258\3\2\2\2\u025b\u0259\3\2\2\2\u025b\u025a\3\2\2\2\u025c\61"+
		"\3\2\2\2\u025d\u025e\t\3\2\2\u025e\u025f\5\\/\2\u025f\u0260\5h\65\2\u0260"+
		"\u0261\7\17\2\2\u0261\63\3\2\2\2\u0262\u0263\7G\2\2\u0263\u0264\7u\2\2"+
		"\u0264\u0266\7\24\2\2\u0265\u0267\5\66\34\2\u0266\u0265\3\2\2\2\u0266"+
		"\u0267\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u026a\7\25\2\2\u0269\u026b\5"+
		"\u00e8u\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026c\3\2\2\2"+
		"\u026c\u026d\7\17\2\2\u026d\65\3\2\2\2\u026e\u0273\58\35\2\u026f\u0270"+
		"\7\21\2\2\u0270\u0272\58\35\2\u0271\u026f\3\2\2\2\u0272\u0275\3\2\2\2"+
		"\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274\67\3\2\2\2\u0275\u0273"+
		"\3\2\2\2\u0276\u0277\5:\36\2\u0277\u0278\5\u00ecw\2\u0278\u0279\5n8\2"+
		"\u02799\3\2\2\2\u027a\u027b\7>\2\2\u027b;\3\2\2\2\u027c\u027d\7J\2\2\u027d"+
		"\u027e\5> \2\u027e\u027f\b\37\1\2\u027f\u0280\5\u014a\u00a6\2\u0280\u0281"+
		"\b\37\1\2\u0281\u0282\7\"\2\2\u0282\u0283\5@!\2\u0283\u0284\b\37\1\2\u0284"+
		"\u0285\b\37\1\2\u0285=\3\2\2\2\u0286\u0287\5t;\2\u0287\u0288\b \1\2\u0288"+
		"\u02a3\3\2\2\2\u0289\u028a\5\u008aF\2\u028a\u028b\b \1\2\u028b\u02a3\3"+
		"\2\2\2\u028c\u028d\5\u008cG\2\u028d\u028e\b \1\2\u028e\u02a3\3\2\2\2\u028f"+
		"\u0290\5\u008eH\2\u0290\u0291\b \1\2\u0291\u02a3\3\2\2\2\u0292\u0293\5"+
		"r:\2\u0293\u0294\b \1\2\u0294\u02a3\3\2\2\2\u0295\u0296\5\u00ceh\2\u0296"+
		"\u0297\b \1\2\u0297\u02a3\3\2\2\2\u0298\u0299\5\u00d0i\2\u0299\u029a\b"+
		" \1\2\u029a\u02a3\3\2\2\2\u029b\u02a3\5\u00f0y\2\u029c\u029d\5\36\20\2"+
		"\u029d\u029e\b \1\2\u029e\u02a3\3\2\2\2\u029f\u02a0\5\u0090I\2\u02a0\u02a1"+
		"\b \1\2\u02a1\u02a3\3\2\2\2\u02a2\u0286\3\2\2\2\u02a2\u0289\3\2\2\2\u02a2"+
		"\u028c\3\2\2\2\u02a2\u028f\3\2\2\2\u02a2\u0292\3\2\2\2\u02a2\u0295\3\2"+
		"\2\2\u02a2\u0298\3\2\2\2\u02a2\u029b\3\2\2\2\u02a2\u029c\3\2\2\2\u02a2"+
		"\u029f\3\2\2\2\u02a3?\3\2\2\2\u02a4\u02a5\5B\"\2\u02a5\u02a6\b!\1\2\u02a6"+
		"A\3\2\2\2\u02a7\u02a8\5D#\2\u02a8\u02b0\b\"\1\2\u02a9\u02aa\b\"\1\2\u02aa"+
		"\u02ab\7!\2\2\u02ab\u02ac\5D#\2\u02ac\u02ad\b\"\1\2\u02ad\u02af\3\2\2"+
		"\2\u02ae\u02a9\3\2\2\2\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1"+
		"\3\2\2\2\u02b1C\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b3\u02b4\5F$\2\u02b4\u02bc"+
		"\b#\1\2\u02b5\u02b6\b#\1\2\u02b6\u02b7\7\37\2\2\u02b7\u02b8\5F$\2\u02b8"+
		"\u02b9\b#\1\2\u02b9\u02bb\3\2\2\2\u02ba\u02b5\3\2\2\2\u02bb\u02be\3\2"+
		"\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bdE\3\2\2\2\u02be\u02bc"+
		"\3\2\2\2\u02bf\u02c0\5H%\2\u02c0\u02c8\b$\1\2\u02c1\u02c2\b$\1\2\u02c2"+
		"\u02c3\7 \2\2\u02c3\u02c4\5H%\2\u02c4\u02c5\b$\1\2\u02c5\u02c7\3\2\2\2"+
		"\u02c6\u02c1\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c8\u02c9"+
		"\3\2\2\2\u02c9G\3\2\2\2\u02ca\u02c8\3\2\2\2\u02cb\u02cc\5J&\2\u02cc\u02d4"+
		"\b%\1\2\u02cd\u02ce\b%\1\2\u02ce\u02cf\t\4\2\2\u02cf\u02d0\5J&\2\u02d0"+
		"\u02d1\b%\1\2\u02d1\u02d3\3\2\2\2\u02d2\u02cd\3\2\2\2\u02d3\u02d6\3\2"+
		"\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5I\3\2\2\2\u02d6\u02d4"+
		"\3\2\2\2\u02d7\u02d8\5L\'\2\u02d8\u02e0\b&\1\2\u02d9\u02da\b&\1\2\u02da"+
		"\u02db\t\5\2\2\u02db\u02dc\5L\'\2\u02dc\u02dd\b&\1\2\u02dd\u02df\3\2\2"+
		"\2\u02de\u02d9\3\2\2\2\u02df\u02e2\3\2\2\2\u02e0\u02de\3\2\2\2\u02e0\u02e1"+
		"\3\2\2\2\u02e1K\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e3\u02e4\5N(\2\u02e4\u02ec"+
		"\b\'\1\2\u02e5\u02e6\b\'\1\2\u02e6\u02e7\t\6\2\2\u02e7\u02e8\5N(\2\u02e8"+
		"\u02e9\b\'\1\2\u02e9\u02eb\3\2\2\2\u02ea\u02e5\3\2\2\2\u02eb\u02ee\3\2"+
		"\2\2\u02ec\u02ea\3\2\2\2\u02ec\u02ed\3\2\2\2\u02edM\3\2\2\2\u02ee\u02ec"+
		"\3\2\2\2\u02ef\u02f0\b(\1\2\u02f0\u02f1\t\7\2\2\u02f1\u02f2\5P)\2\u02f2"+
		"\u02f3\b(\1\2\u02f3\u02f8\3\2\2\2\u02f4\u02f5\5P)\2\u02f5\u02f6\b(\1\2"+
		"\u02f6\u02f8\3\2\2\2\u02f7\u02ef\3\2\2\2\u02f7\u02f4\3\2\2\2\u02f8O\3"+
		"\2\2\2\u02f9\u02fa\5\36\20\2\u02fa\u02fb\b)\1\2\u02fb\u0306\3\2\2\2\u02fc"+
		"\u02fd\5R*\2\u02fd\u02fe\b)\1\2\u02fe\u0306\3\2\2\2\u02ff\u0300\b)\1\2"+
		"\u0300\u0301\7\24\2\2\u0301\u0302\5@!\2\u0302\u0303\b)\1\2\u0303\u0304"+
		"\7\25\2\2\u0304\u0306\3\2\2\2\u0305\u02f9\3\2\2\2\u0305\u02fc\3\2\2\2"+
		"\u0305\u02ff\3\2\2\2\u0306Q\3\2\2\2\u0307\u0313\7\7\2\2\u0308\u0313\7"+
		"\5\2\2\u0309\u0313\7\r\2\2\u030a\u0313\7\f\2\2\u030b\u0313\7\13\2\2\u030c"+
		"\u0313\7\n\2\2\u030d\u0313\7\t\2\2\u030e\u0313\7\b\2\2\u030f\u0310\5T"+
		"+\2\u0310\u0311\b*\1\2\u0311\u0313\3\2\2\2\u0312\u0307\3\2\2\2\u0312\u0308"+
		"\3\2\2\2\u0312\u0309\3\2\2\2\u0312\u030a\3\2\2\2\u0312\u030b\3\2\2\2\u0312"+
		"\u030c\3\2\2\2\u0312\u030d\3\2\2\2\u0312\u030e\3\2\2\2\u0312\u030f\3\2"+
		"\2\2\u0313\u0314\3\2\2\2\u0314\u0315\b*\1\2\u0315S\3\2\2\2\u0316\u0317"+
		"\7\3\2\2\u0317\u031b\b+\1\2\u0318\u0319\7\4\2\2\u0319\u031b\b+\1\2\u031a"+
		"\u0316\3\2\2\2\u031a\u0318\3\2\2\2\u031bU\3\2\2\2\u031c\u031d\5@!\2\u031d"+
		"\u031e\b,\1\2\u031e\u031f\b,\1\2\u031fW\3\2\2\2\u0320\u0321\7.\2\2\u0321"+
		"\u0322\b-\1\2\u0322\u0323\5Z.\2\u0323\u0324\b-\1\2\u0324\u0339\3\2\2\2"+
		"\u0325\u0326\5\u00aeX\2\u0326\u0327\b-\1\2\u0327\u0339\3\2\2\2\u0328\u0329"+
		"\5\u00b6\\\2\u0329\u032a\b-\1\2\u032a\u0339\3\2\2\2\u032b\u032c\5\u00c2"+
		"b\2\u032c\u032d\b-\1\2\u032d\u0339\3\2\2\2\u032e\u032f\5\u00a4S\2\u032f"+
		"\u0330\b-\1\2\u0330\u0339\3\2\2\2\u0331\u0332\5\u00aaV\2\u0332\u0333\b"+
		"-\1\2\u0333\u0339\3\2\2\2\u0334\u0335\7\66\2\2\u0335\u0336\b-\1\2\u0336"+
		"\u0339\5n8\2\u0337\u0339\5\u00f4{\2\u0338\u0320\3\2\2\2\u0338\u0325\3"+
		"\2\2\2\u0338\u0328\3\2\2\2\u0338\u032b\3\2\2\2\u0338\u032e\3\2\2\2\u0338"+
		"\u0331\3\2\2\2\u0338\u0334\3\2\2\2\u0338\u0337\3\2\2\2\u0339\u033a\3\2"+
		"\2\2\u033a\u033b\b-\1\2\u033bY\3\2\2\2\u033c\u033d\5\\/\2\u033d\u033e"+
		"\5h\65\2\u033e\u033f\b.\1\2\u033f[\3\2\2\2\u0340\u0341\5^\60\2\u0341\u0342"+
		"\b/\1\2\u0342\u0345\3\2\2\2\u0343\u0345\5f\64\2\u0344\u0340\3\2\2\2\u0344"+
		"\u0343\3\2\2\2\u0345]\3\2\2\2\u0346\u0347\5b\62\2\u0347\u0348\b\60\1\2"+
		"\u0348\u0350\3\2\2\2\u0349\u034a\5d\63\2\u034a\u034b\b\60\1\2\u034b\u0350"+
		"\3\2\2\2\u034c\u034d\5\36\20\2\u034d\u034e\b\60\1\2\u034e\u0350\3\2\2"+
		"\2\u034f\u0346\3\2\2\2\u034f\u0349\3\2\2\2\u034f\u034c\3\2\2\2\u0350_"+
		"\3\2\2\2\u0351\u0352\5t;\2\u0352\u0353\b\61\1\2\u0353\u035b\3\2\2\2\u0354"+
		"\u0355\5\u008eH\2\u0355\u0356\b\61\1\2\u0356\u035b\3\2\2\2\u0357\u0358"+
		"\5\u0090I\2\u0358\u0359\b\61\1\2\u0359\u035b\3\2\2\2\u035a\u0351\3\2\2"+
		"\2\u035a\u0354\3\2\2\2\u035a\u0357\3\2\2\2\u035ba\3\2\2\2\u035c\u035d"+
		"\5r:\2\u035d\u035e\b\62\1\2\u035e\u0372\3\2\2\2\u035f\u0360\5t;\2\u0360"+
		"\u0361\b\62\1\2\u0361\u0372\3\2\2\2\u0362\u0363\5\u008aF\2\u0363\u0364"+
		"\b\62\1\2\u0364\u0372\3\2\2\2\u0365\u0366\5\u008cG\2\u0366\u0367\b\62"+
		"\1\2\u0367\u0372\3\2\2\2\u0368\u0369\5\u008eH\2\u0369\u036a\b\62\1\2\u036a"+
		"\u0372\3\2\2\2\u036b\u036c\5\u0090I\2\u036c\u036d\b\62\1\2\u036d\u0372"+
		"\3\2\2\2\u036e\u0372\5\u0092J\2\u036f\u0372\5\u0094K\2\u0370\u0372\5\u00f2"+
		"z\2\u0371\u035c\3\2\2\2\u0371\u035f\3\2\2\2\u0371\u0362\3\2\2\2\u0371"+
		"\u0365\3\2\2\2\u0371\u0368\3\2\2\2\u0371\u036b\3\2\2\2\u0371\u036e\3\2"+
		"\2\2\u0371\u036f\3\2\2\2\u0371\u0370\3\2\2\2\u0372c\3\2\2\2\u0373\u0374"+
		"\5\u00c8e\2\u0374\u0375\b\63\1\2\u0375\u0384\3\2\2\2\u0376\u0377\5\u00ca"+
		"f\2\u0377\u0378\b\63\1\2\u0378\u0384\3\2\2\2\u0379\u037a\5\u00ccg\2\u037a"+
		"\u037b\b\63\1\2\u037b\u0384\3\2\2\2\u037c\u037d\5\u00ceh\2\u037d\u037e"+
		"\b\63\1\2\u037e\u0384\3\2\2\2\u037f\u0380\5\u00d0i\2\u0380\u0381\b\63"+
		"\1\2\u0381\u0384\3\2\2\2\u0382\u0384\5\u00eex\2\u0383\u0373\3\2\2\2\u0383"+
		"\u0376\3\2\2\2\u0383\u0379\3\2\2\2\u0383\u037c\3\2\2\2\u0383\u037f\3\2"+
		"\2\2\u0383\u0382\3\2\2\2\u0384e\3\2\2\2\u0385\u038b\5\u00aeX\2\u0386\u038b"+
		"\5\u00b6\\\2\u0387\u038b\5\u00c2b\2\u0388\u038b\5\u00a4S\2\u0389\u038b"+
		"\5\u00aaV\2\u038a\u0385\3\2\2\2\u038a\u0386\3\2\2\2\u038a\u0387\3\2\2"+
		"\2\u038a\u0388\3\2\2\2\u038a\u0389\3\2\2\2\u038bg\3\2\2\2\u038c\u038d"+
		"\5l\67\2\u038d\u0394\b\65\1\2\u038e\u038f\7\21\2\2\u038f\u0390\5l\67\2"+
		"\u0390\u0391\b\65\1\2\u0391\u0393\3\2\2\2\u0392\u038e\3\2\2\2\u0393\u0396"+
		"\3\2\2\2\u0394\u0392\3\2\2\2\u0394\u0395\3\2\2\2\u0395i\3\2\2\2\u0396"+
		"\u0394\3\2\2\2\u0397\u0398\5n8\2\u0398\u039f\b\66\1\2\u0399\u039a\7\21"+
		"\2\2\u039a\u039b\5n8\2\u039b\u039c\b\66\1\2\u039c\u039e\3\2\2\2\u039d"+
		"\u0399\3\2\2\2\u039e\u03a1\3\2\2\2\u039f\u039d\3\2\2\2\u039f\u03a0\3\2"+
		"\2\2\u03a0k\3\2\2\2\u03a1\u039f\3\2\2\2\u03a2\u03a3\5n8\2\u03a3\u03a4"+
		"\b\67\1\2\u03a4\u03a9\3\2\2\2\u03a5\u03a6\5p9\2\u03a6\u03a7\b\67\1\2\u03a7"+
		"\u03a9\3\2\2\2\u03a8\u03a2\3\2\2\2\u03a8\u03a5\3\2\2\2\u03a9m\3\2\2\2"+
		"\u03aa\u03ab\5\u014a\u00a6\2\u03ab\u03ac\b8\1\2\u03aco\3\2\2\2\u03ad\u03ae"+
		"\5\u00d2j\2\u03ae\u03af\b9\1\2\u03afq\3\2\2\2\u03b0\u03b1\7X\2\2\u03b1"+
		"\u03b8\b:\1\2\u03b2\u03b3\7_\2\2\u03b3\u03b8\b:\1\2\u03b4\u03b5\7B\2\2"+
		"\u03b5\u03b6\7_\2\2\u03b6\u03b8\b:\1\2\u03b7\u03b0\3\2\2\2\u03b7\u03b2"+
		"\3\2\2\2\u03b7\u03b4\3\2\2\2\u03b8s\3\2\2\2\u03b9\u03ba\5v<\2\u03ba\u03bb"+
		"\b;\1\2\u03bb\u03c0\3\2\2\2\u03bc\u03bd\5\u0080A\2\u03bd\u03be\b;\1\2"+
		"\u03be\u03c0\3\2\2\2\u03bf\u03b9\3\2\2\2\u03bf\u03bc\3\2\2\2\u03c0u\3"+
		"\2\2\2\u03c1\u03c2\5z>\2\u03c2\u03c3\b<\1\2\u03c3\u03ce\3\2\2\2\u03c4"+
		"\u03c5\5|?\2\u03c5\u03c6\b<\1\2\u03c6\u03ce\3\2\2\2\u03c7\u03c8\5~@\2"+
		"\u03c8\u03c9\b<\1\2\u03c9\u03ce\3\2\2\2\u03ca\u03cb\5x=\2\u03cb\u03cc"+
		"\b<\1\2\u03cc\u03ce\3\2\2\2\u03cd\u03c1\3\2\2\2\u03cd\u03c4\3\2\2\2\u03cd"+
		"\u03c7\3\2\2\2\u03cd\u03ca\3\2\2\2\u03cew\3\2\2\2\u03cf\u03d0\7l\2\2\u03d0"+
		"y\3\2\2\2\u03d1\u03d2\t\b\2\2\u03d2{\3\2\2\2\u03d3\u03d4\t\t\2\2\u03d4"+
		"}\3\2\2\2\u03d5\u03d6\7B\2\2\u03d6\u03d9\7B\2\2\u03d7\u03d9\7r\2\2\u03d8"+
		"\u03d5\3\2\2\2\u03d8\u03d7\3\2\2\2\u03d9\177\3\2\2\2\u03da\u03db\5\u0084"+
		"C\2\u03db\u03dc\bA\1\2\u03dc\u03e7\3\2\2\2\u03dd\u03de\5\u0086D\2\u03de"+
		"\u03df\bA\1\2\u03df\u03e7\3\2\2\2\u03e0\u03e1\5\u0088E\2\u03e1\u03e2\b"+
		"A\1\2\u03e2\u03e7\3\2\2\2\u03e3\u03e4\5\u0082B\2\u03e4\u03e5\bA\1\2\u03e5"+
		"\u03e7\3\2\2\2\u03e6\u03da\3\2\2\2\u03e6\u03dd\3\2\2\2\u03e6\u03e0\3\2"+
		"\2\2\u03e6\u03e3\3\2\2\2\u03e7\u0081\3\2\2\2\u03e8\u03e9\7m\2\2\u03e9"+
		"\u0083\3\2\2\2\u03ea\u03eb\7Q\2\2\u03eb\u03ee\7A\2\2\u03ec\u03ee\7o\2"+
		"\2\u03ed\u03ea\3\2\2\2\u03ed\u03ec\3\2\2\2\u03ee\u0085\3\2\2\2\u03ef\u03f0"+
		"\7Q\2\2\u03f0\u03f3\7B\2\2\u03f1\u03f3\7q\2\2\u03f2\u03ef\3\2\2\2\u03f2"+
		"\u03f1\3\2\2\2\u03f3\u0087\3\2\2\2\u03f4\u03f5\7Q\2\2\u03f5\u03f6\7B\2"+
		"\2\u03f6\u03f9\7B\2\2\u03f7\u03f9\7s\2\2\u03f8\u03f4\3\2\2\2\u03f8\u03f7"+
		"\3\2\2\2\u03f9\u0089\3\2\2\2\u03fa\u03fb\7V\2\2\u03fb\u008b\3\2\2\2\u03fc"+
		"\u03fd\7=\2\2\u03fd\u008d\3\2\2\2\u03fe\u03ff\7Y\2\2\u03ff\u008f\3\2\2"+
		"\2\u0400\u0401\7\62\2\2\u0401\u0091\3\2\2\2\u0402\u0403\7U\2\2\u0403\u0404"+
		"\bJ\1\2\u0404\u0093\3\2\2\2\u0405\u0406\7O\2\2\u0406\u0407\bK\1\2\u0407"+
		"\u0095\3\2\2\2\u0408\u0409\5\u0098M\2\u0409\u040a\bL\1\2\u040a\u040d\3"+
		"\2\2\2\u040b\u040d\5\u00a2R\2\u040c\u0408\3\2\2\2\u040c\u040b\3\2\2\2"+
		"\u040d\u0097\3\2\2\2\u040e\u040f\5\u009aN\2\u040f\u0410\7\22\2\2\u0410"+
		"\u0411\5\u009eP\2\u0411\u0412\7\23\2\2\u0412\u0413\bM\1\2\u0413\u0099"+
		"\3\2\2\2\u0414\u0415\7t\2\2\u0415\u0416\bN\1\2\u0416\u0417\5\u014a\u00a6"+
		"\2\u0417\u0419\bN\1\2\u0418\u041a\5\u009cO\2\u0419\u0418\3\2\2\2\u0419"+
		"\u041a\3\2\2\2\u041a\u009b\3\2\2\2\u041b\u041c\7\20\2\2\u041c\u041d\5"+
		"\36\20\2\u041d\u041e\bO\1\2\u041e\u009d\3\2\2\2\u041f\u0421\5\u00a0Q\2"+
		"\u0420\u041f\3\2\2\2\u0421\u0424\3\2\2\2\u0422\u0420\3\2\2\2\u0422\u0423"+
		"\3\2\2\2\u0423\u009f\3\2\2\2\u0424\u0422\3\2\2\2\u0425\u0426\5> \2\u0426"+
		"\u042b\5n8\2\u0427\u0428\7?\2\2\u0428\u0429\5@!\2\u0429\u042a\bQ\1\2\u042a"+
		"\u042c\3\2\2\2\u042b\u0427\3\2\2\2\u042b\u042c\3\2\2\2\u042c\u042d\3\2"+
		"\2\2\u042d\u042e\7\17\2\2\u042e\u042f\bQ\1\2\u042f\u00a1\3\2\2\2\u0430"+
		"\u0431\7t\2\2\u0431\u0432\5\36\20\2\u0432\u00a3\3\2\2\2\u0433\u0434\7"+
		"j\2\2\u0434\u0435\5\u014a\u00a6\2\u0435\u043a\bS\1\2\u0436\u0437\7\20"+
		"\2\2\u0437\u0438\5\36\20\2\u0438\u0439\bS\1\2\u0439\u043b\3\2\2\2\u043a"+
		"\u0436\3\2\2\2\u043a\u043b\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u043d\7\22"+
		"\2\2\u043d\u043e\5\u00a6T\2\u043e\u043f\7\23\2\2\u043f\u0440\bS\1\2\u0440"+
		"\u00a5\3\2\2\2\u0441\u0442\5\u00a8U\2\u0442\u0443\5j\66\2\u0443\u0444"+
		"\7\17\2\2\u0444\u0445\bT\1\2\u0445\u044b\3\2\2\2\u0446\u0447\5\u00a8U"+
		"\2\u0447\u0448\7\17\2\2\u0448\u0449\bT\1\2\u0449\u044b\3\2\2\2\u044a\u0441"+
		"\3\2\2\2\u044a\u0446\3\2\2\2\u044b\u044c\3\2\2\2\u044c\u044a\3\2\2\2\u044c"+
		"\u044d\3\2\2\2\u044d\u00a7\3\2\2\2\u044e\u044f\7i\2\2\u044f\u0450\7\32"+
		"\2\2\u0450\u0451\5V,\2\u0451\u0452\bU\1\2\u0452\u0453\7\33\2\2\u0453\u0454"+
		"\bU\1\2\u0454\u0460\3\2\2\2\u0455\u0456\7i\2\2\u0456\u0457\7\32\2\2\u0457"+
		"\u0458\5V,\2\u0458\u0459\bU\1\2\u0459\u045a\7\21\2\2\u045a\u045b\5`\61"+
		"\2\u045b\u045c\bU\1\2\u045c\u045d\7\33\2\2\u045d\u045e\bU\1\2\u045e\u0460"+
		"\3\2\2\2\u045f\u044e\3\2\2\2\u045f\u0455\3\2\2\2\u0460\u00a9\3\2\2\2\u0461"+
		"\u0462\7k\2\2\u0462\u0463\5\u014a\u00a6\2\u0463\u0464\bV\1\2\u0464\u0465"+
		"\7\22\2\2\u0465\u0466\5\u00acW\2\u0466\u0467\7\23\2\2\u0467\u0468\bV\1"+
		"\2\u0468\u00ab\3\2\2\2\u0469\u046a\5\u0144\u00a3\2\u046a\u046b\bW\1\2"+
		"\u046b\u046d\3\2\2\2\u046c\u0469\3\2\2\2\u046d\u0470\3\2\2\2\u046e\u046c"+
		"\3\2\2\2\u046e\u046f\3\2\2\2\u046f\u0471\3\2\2\2\u0470\u046e\3\2\2\2\u0471"+
		"\u0472\5\u014a\u00a6\2\u0472\u0481\bW\1\2\u0473\u0479\7\21\2\2\u0474\u0475"+
		"\5\u0144\u00a3\2\u0475\u0476\bW\1\2\u0476\u0478\3\2\2\2\u0477\u0474\3"+
		"\2\2\2\u0478\u047b\3\2\2\2\u0479\u0477\3\2\2\2\u0479\u047a\3\2\2\2\u047a"+
		"\u047c\3\2\2\2\u047b\u0479\3\2\2\2\u047c\u047d\5\u014a\u00a6\2\u047d\u047e"+
		"\bW\1\2\u047e\u0480\3\2\2\2\u047f\u0473\3\2\2\2\u0480\u0483\3\2\2\2\u0481"+
		"\u047f\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u00ad\3\2\2\2\u0483\u0481\3\2"+
		"\2\2\u0484\u0485\7\65\2\2\u0485\u0486\5\u014a\u00a6\2\u0486\u048b\bX\1"+
		"\2\u0487\u0488\7\20\2\2\u0488\u0489\5\36\20\2\u0489\u048a\bX\1\2\u048a"+
		"\u048c\3\2\2\2\u048b\u0487\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u048d\3\2"+
		"\2\2\u048d\u048e\7\22\2\2\u048e\u048f\5\u00b0Y\2\u048f\u0490\7\23\2\2"+
		"\u0490\u0491\bX\1\2\u0491\u0497\3\2\2\2\u0492\u0493\7\65\2\2\u0493\u0494"+
		"\5\u014a\u00a6\2\u0494\u0495\bX\1\2\u0495\u0497\3\2\2\2\u0496\u0484\3"+
		"\2\2\2\u0496\u0492\3\2\2\2\u0497\u00af\3\2\2\2\u0498\u0499\5\u00b2Z\2"+
		"\u0499\u049a\bY\1\2\u049a\u049c\3\2\2\2\u049b\u0498\3\2\2\2\u049c\u049f"+
		"\3\2\2\2\u049d\u049b\3\2\2\2\u049d\u049e\3\2\2\2\u049e\u00b1\3\2\2\2\u049f"+
		"\u049d\3\2\2\2\u04a0\u04a1\5\u00b4[\2\u04a1\u04a2\bZ\1\2\u04a2\u04a8\3"+
		"\2\2\2\u04a3\u04a4\5\u0144\u00a3\2\u04a4\u04a5\5\u00b2Z\2\u04a5\u04a6"+
		"\bZ\1\2\u04a6\u04a8\3\2\2\2\u04a7\u04a0\3\2\2\2\u04a7\u04a3\3\2\2\2\u04a8"+
		"\u00b3\3\2\2\2\u04a9\u04aa\5\\/\2\u04aa\u04ab\5h\65\2\u04ab\u04ac\7\17"+
		"\2\2\u04ac\u04ad\b[\1\2\u04ad\u00b5\3\2\2\2\u04ae\u04af\7S\2\2\u04af\u04b0"+
		"\5\u014a\u00a6\2\u04b0\u04b1\b\\\1\2\u04b1\u04b2\7,\2\2\u04b2\u04b3\7"+
		"\24\2\2\u04b3\u04b4\5\u00b8]\2\u04b4\u04b5\b\\\1\2\u04b5\u04b6\7\25\2"+
		"\2\u04b6\u04b7\b\\\1\2\u04b7\u04b8\7\22\2\2\u04b8\u04b9\5\u00ba^\2\u04b9"+
		"\u04ba\7\23\2\2\u04ba\u04bb\b\\\1\2\u04bb\u04c1\3\2\2\2\u04bc\u04bd\7"+
		"S\2\2\u04bd\u04be\5\u014a\u00a6\2\u04be\u04bf\b\\\1\2\u04bf\u04c1\3\2"+
		"\2\2\u04c0\u04ae\3\2\2\2\u04c0\u04bc\3\2\2\2\u04c1\u00b7\3\2\2\2\u04c2"+
		"\u04c3\5t;\2\u04c3\u04c4\b]\1\2\u04c4\u04d6\3\2\2\2\u04c5\u04c6\5\u008a"+
		"F\2\u04c6\u04c7\b]\1\2\u04c7\u04d6\3\2\2\2\u04c8\u04c9\5\u008cG\2\u04c9"+
		"\u04ca\b]\1\2\u04ca\u04d6\3\2\2\2\u04cb\u04cc\5\u0090I\2\u04cc\u04cd\b"+
		"]\1\2\u04cd\u04d6\3\2\2\2\u04ce\u04cf\5\u008eH\2\u04cf\u04d0\b]\1\2\u04d0"+
		"\u04d6\3\2\2\2\u04d1\u04d6\5\u00c2b\2\u04d2\u04d3\5\36\20\2\u04d3\u04d4"+
		"\b]\1\2\u04d4\u04d6\3\2\2\2\u04d5\u04c2\3\2\2\2\u04d5\u04c5\3\2\2\2\u04d5"+
		"\u04c8\3\2\2\2\u04d5\u04cb\3\2\2\2\u04d5\u04ce\3\2\2\2\u04d5\u04d1\3\2"+
		"\2\2\u04d5\u04d2\3\2\2\2\u04d6\u00b9\3\2\2\2\u04d7\u04d8\5\u00bc_\2\u04d8"+
		"\u00bb\3\2\2\2\u04d9\u04db\5\u00be`\2\u04da\u04d9\3\2\2\2\u04db\u04dc"+
		"\3\2\2\2\u04dc\u04da\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd\u00bd\3\2\2\2\u04de"+
		"\u04df\7W\2\2\u04df\u04e0\5@!\2\u04e0\u04e1\b`\1\2\u04e1\u04e2\7\20\2"+
		"\2\u04e2\u04e7\3\2\2\2\u04e3\u04e4\7?\2\2\u04e4\u04e5\b`\1\2\u04e5\u04e7"+
		"\7\20\2\2\u04e6\u04de\3\2\2\2\u04e6\u04e3\3\2\2\2\u04e7\u04e8\3\2\2\2"+
		"\u04e8\u04e6\3\2\2\2\u04e8\u04e9\3\2\2\2\u04e9\u04ea\3\2\2\2\u04ea\u04eb"+
		"\5\u00c0a\2\u04eb\u04ec\7\17\2\2\u04ec\u04ed\b`\1\2\u04ed\u00bf\3\2\2"+
		"\2\u04ee\u04ef\5\\/\2\u04ef\u04f0\5l\67\2\u04f0\u04f1\ba\1\2\u04f1\u00c1"+
		"\3\2\2\2\u04f2\u04f3\7C\2\2\u04f3\u04f4\5\u014a\u00a6\2\u04f4\u04f5\b"+
		"b\1\2\u04f5\u04f6\7\22\2\2\u04f6\u04f7\5\u00c4c\2\u04f7\u04f8\7\23\2\2"+
		"\u04f8\u04f9\bb\1\2\u04f9\u00c3\3\2\2\2\u04fa\u04ff\5\u00c6d\2\u04fb\u04fc"+
		"\7\21\2\2\u04fc\u04fe\5\u00c6d\2\u04fd\u04fb\3\2\2\2\u04fe\u0501\3\2\2"+
		"\2\u04ff\u04fd\3\2\2\2\u04ff\u0500\3\2\2\2\u0500\u00c5\3\2\2\2\u0501\u04ff"+
		"\3\2\2\2\u0502\u0503\5\u014a\u00a6\2\u0503\u0504\bd\1\2\u0504\u00c7\3"+
		"\2\2\2\u0505\u0506\7\63\2\2\u0506\u0507\7\32\2\2\u0507\u0508\5^\60\2\u0508"+
		"\u0509\be\1\2\u0509\u050a\7\21\2\2\u050a\u050b\5V,\2\u050b\u050c\be\1"+
		"\2\u050c\u050d\7\33\2\2\u050d\u0515\3\2\2\2\u050e\u050f\7\63\2\2\u050f"+
		"\u0510\7\32\2\2\u0510\u0511\5^\60\2\u0511\u0512\be\1\2\u0512\u0513\7\33"+
		"\2\2\u0513\u0515\3\2\2\2\u0514\u0505\3\2\2\2\u0514\u050e\3\2\2\2\u0515"+
		"\u0516\3\2\2\2\u0516\u0517\be\1\2\u0517\u00c9\3\2\2\2\u0518\u0519\7g\2"+
		"\2\u0519\u051a\7\32\2\2\u051a\u051b\5^\60\2\u051b\u051c\bf\1\2\u051c\u051d"+
		"\7\21\2\2\u051d\u051e\5V,\2\u051e\u051f\bf\1\2\u051f\u0520\7\33\2\2\u0520"+
		"\u0528\3\2\2\2\u0521\u0522\7g\2\2\u0522\u0523\7\32\2\2\u0523\u0524\5^"+
		"\60\2\u0524\u0525\bf\1\2\u0525\u0526\7\33\2\2\u0526\u0528\3\2\2\2\u0527"+
		"\u0518\3\2\2\2\u0527\u0521\3\2\2\2\u0528\u0529\3\2\2\2\u0529\u052a\bf"+
		"\1\2\u052a\u00cb\3\2\2\2\u052b\u052c\7h\2\2\u052c\u052d\7\32\2\2\u052d"+
		"\u052e\5^\60\2\u052e\u052f\bg\1\2\u052f\u0530\7\21\2\2\u0530\u0531\5^"+
		"\60\2\u0531\u0536\bg\1\2\u0532\u0533\7\21\2\2\u0533\u0534\5V,\2\u0534"+
		"\u0535\bg\1\2\u0535\u0537\3\2\2\2\u0536\u0532\3\2\2\2\u0536\u0537\3\2"+
		"\2\2\u0537\u0538\3\2\2\2\u0538\u0539\7\33\2\2\u0539\u053a\bg\1\2\u053a"+
		"\u00cd\3\2\2\2\u053b\u053c\7+\2\2\u053c\u053d\7\32\2\2\u053d\u053e\5V"+
		",\2\u053e\u053f\bh\1\2\u053f\u0540\7\33\2\2\u0540\u0543\3\2\2\2\u0541"+
		"\u0543\7+\2\2\u0542\u053b\3\2\2\2\u0542\u0541\3\2\2\2\u0543\u0544\3\2"+
		"\2\2\u0544\u0545\bh\1\2\u0545\u00cf\3\2\2\2\u0546\u0547\7D\2\2\u0547\u0548"+
		"\7\32\2\2\u0548\u0549\5V,\2\u0549\u054a\bi\1\2\u054a\u054b\7\33\2\2\u054b"+
		"\u054e\3\2\2\2\u054c\u054e\7D\2\2\u054d\u0546\3\2\2\2\u054d\u054c\3\2"+
		"\2\2\u054e\u054f\3\2\2\2\u054f\u0550\bi\1\2\u0550\u00d1\3\2\2\2\u0551"+
		"\u0555\7u\2\2\u0552\u0553\5\u00d4k\2\u0553\u0554\bj\1\2\u0554\u0556\3"+
		"\2\2\2\u0555\u0552\3\2\2\2\u0556\u0557\3\2\2\2\u0557\u0555\3\2\2\2\u0557"+
		"\u0558\3\2\2\2\u0558\u0559\3\2\2\2\u0559\u055a\bj\1\2\u055a\u00d3\3\2"+
		"\2\2\u055b\u055c\7\26\2\2\u055c\u055d\5V,\2\u055d\u055e\bk\1\2\u055e\u055f"+
		"\7\27\2\2\u055f\u00d5\3\2\2\2\u0560\u0565\5\u00fe\u0080\2\u0561\u0562"+
		"\5\u0102\u0082\2\u0562\u0563\bl\1\2\u0563\u0565\3\2\2\2\u0564\u0560\3"+
		"\2\2\2\u0564\u0561\3\2\2\2\u0565\u00d7\3\2\2\2\u0566\u0567\7H\2\2\u0567"+
		"\u0568\bm\1\2\u0568\u0569\5\u014a\u00a6\2\u0569\u056a\bm\1\2\u056a\u056b"+
		"\bm\1\2\u056b\u056c\7\22\2\2\u056c\u056d\5\u00dan\2\u056d\u056e\7\23\2"+
		"\2\u056e\u056f\bm\1\2\u056f\u00d9\3\2\2\2\u0570\u0571\5\u00b4[\2\u0571"+
		"\u0572\bn\1\2\u0572\u0574\3\2\2\2\u0573\u0570\3\2\2\2\u0574\u0577\3\2"+
		"\2\2\u0575\u0573\3\2\2\2\u0575\u0576\3\2\2\2\u0576\u00db\3\2\2\2\u0577"+
		"\u0575\3\2\2\2\u0578\u0579\5\u00dep\2\u0579\u057a\bo\1\2\u057a\u057c\3"+
		"\2\2\2\u057b\u0578\3\2\2\2\u057b\u057c\3\2\2\2\u057c\u057d\3\2\2\2\u057d"+
		"\u057e\5\u00e0q\2\u057e\u057f\bo\1\2\u057f\u0580\bo\1\2\u0580\u0581\7"+
		"u\2\2\u0581\u0582\bo\1\2\u0582\u0583\5\u00e2r\2\u0583\u0588\bo\1\2\u0584"+
		"\u0585\5\u00e8u\2\u0585\u0586\bo\1\2\u0586\u0587\bo\1\2\u0587\u0589\3"+
		"\2\2\2\u0588\u0584\3\2\2\2\u0588\u0589\3\2\2\2\u0589\u058b\3\2\2\2\u058a"+
		"\u058c\5\u00eav\2\u058b\u058a\3\2\2\2\u058b\u058c\3\2\2\2\u058c\u058d"+
		"\3\2\2\2\u058d\u058e\bo\1\2\u058e\u00dd\3\2\2\2\u058f\u0590\7T\2\2\u0590"+
		"\u0591\bp\1\2\u0591\u00df\3\2\2\2\u0592\u0593\5\u00ecw\2\u0593\u0594\b"+
		"q\1\2\u0594\u0597\3\2\2\2\u0595\u0597\7:\2\2\u0596\u0592\3\2\2\2\u0596"+
		"\u0595\3\2\2\2\u0597\u00e1\3\2\2\2\u0598\u059a\7\24\2\2\u0599\u059b\5"+
		"\u00e4s\2\u059a\u0599\3\2\2\2\u059a\u059b\3\2\2\2\u059b\u059c\3\2\2\2"+
		"\u059c\u059d\7\25\2\2\u059d\u00e3\3\2\2\2\u059e\u059f\5\u00e6t\2\u059f"+
		"\u05a0\bs\1\2\u05a0\u05a8\bs\1\2\u05a1\u05a2\7\21\2\2\u05a2\u05a3\5\u00e6"+
		"t\2\u05a3\u05a4\bs\1\2\u05a4\u05a5\bs\1\2\u05a5\u05a7\3\2\2\2\u05a6\u05a1"+
		"\3\2\2\2\u05a7\u05aa\3\2\2\2\u05a8\u05a6\3\2\2\2\u05a8\u05a9\3\2\2\2\u05a9"+
		"\u00e5\3\2\2\2\u05aa\u05a8\3\2\2\2\u05ab\u05ac\t\n\2\2\u05ac\u05ad\5\u00ec"+
		"w\2\u05ad\u05ae\bt\1\2\u05ae\u05af\5n8\2\u05af\u05b0\bt\1\2\u05b0\u00e7"+
		"\3\2\2\2\u05b1\u05b2\79\2\2\u05b2\u05b3\7\24\2\2\u05b3\u05b4\5\34\17\2"+
		"\u05b4\u05b5\bu\1\2\u05b5\u05b6\7\25\2\2\u05b6\u00e9\3\2\2\2\u05b7\u05b8"+
		"\7E\2\2\u05b8\u05b9\7\24\2\2\u05b9\u05be\7\r\2\2\u05ba\u05bb\7\21\2\2"+
		"\u05bb\u05bd\7\r\2\2\u05bc\u05ba\3\2\2\2\u05bd\u05c0\3\2\2\2\u05be\u05bc"+
		"\3\2\2\2\u05be\u05bf\3\2\2\2\u05bf\u05c1\3\2\2\2\u05c0\u05be\3\2\2\2\u05c1"+
		"\u05c2\7\25\2\2\u05c2\u00eb\3\2\2\2\u05c3\u05c4\5b\62\2\u05c4\u05c5\b"+
		"w\1\2\u05c5\u05d0\3\2\2\2\u05c6\u05c7\5\u00ceh\2\u05c7\u05c8\bw\1\2\u05c8"+
		"\u05d0\3\2\2\2\u05c9\u05ca\5\u00d0i\2\u05ca\u05cb\bw\1\2\u05cb\u05d0\3"+
		"\2\2\2\u05cc\u05cd\5\36\20\2\u05cd\u05ce\bw\1\2\u05ce\u05d0\3\2\2\2\u05cf"+
		"\u05c3\3\2\2\2\u05cf\u05c6\3\2\2\2\u05cf\u05c9\3\2\2\2\u05cf\u05cc\3\2"+
		"\2\2\u05d0\u00ed\3\2\2\2\u05d1\u05d2\7R\2\2\u05d2\u05d3\7\32\2\2\u05d3"+
		"\u05d4\5V,\2\u05d4\u05d5\7\21\2\2\u05d5\u05d6\5V,\2\u05d6\u05d7\7\33\2"+
		"\2\u05d7\u05d8\bx\1\2\u05d8\u00ef\3\2\2\2\u05d9\u05da\7R\2\2\u05da\u05db"+
		"\by\1\2\u05db\u00f1\3\2\2\2\u05dc\u05dd\7K\2\2\u05dd\u05de\bz\1\2\u05de"+
		"\u00f3\3\2\2\2\u05df\u05e0\7\65\2\2\u05e0\u05e4\7u\2\2\u05e1\u05e2\7S"+
		"\2\2\u05e2\u05e4\7u\2\2\u05e3\u05df\3\2\2\2\u05e3\u05e1\3\2\2\2\u05e4"+
		"\u00f5\3\2\2\2\u05e5\u05e6\7\64\2\2\u05e6\u05e7\b|\1\2\u05e7\u05e8\5\u00f8"+
		"}\2\u05e8\u05e9\7\17\2\2\u05e9\u00f7\3\2\2\2\u05ea\u05ed\5\36\20\2\u05eb"+
		"\u05ed\7\r\2\2\u05ec\u05ea\3\2\2\2\u05ec\u05eb\3\2\2\2\u05ed\u00f9\3\2"+
		"\2\2\u05ee\u05ef\7a\2\2\u05ef\u05f0\b~\1\2\u05f0\u05f1\5\36\20\2\u05f1"+
		"\u05f2\7\r\2\2\u05f2\u00fb\3\2\2\2\u05f3\u05f4\7`\2\2\u05f4\u05f5\b\177"+
		"\1\2\u05f5\u05f6\5\36\20\2\u05f6\u05f7\7\r\2\2\u05f7\u00fd\3\2\2\2\u05f8"+
		"\u05f9\7\67\2\2\u05f9\u05fa\7b\2\2\u05fa\u05fb\5\u00ecw\2\u05fb\u05fc"+
		"\5\u0100\u0081\2\u05fc\u00ff\3\2\2\2\u05fd\u05fe\5n8\2\u05fe\u05ff\5\u00e8"+
		"u\2\u05ff\u0609\3\2\2\2\u0600\u0605\5n8\2\u0601\u0602\7\21\2\2\u0602\u0604"+
		"\5n8\2\u0603\u0601\3\2\2\2\u0604\u0607\3\2\2\2\u0605\u0603\3\2\2\2\u0605"+
		"\u0606\3\2\2\2\u0606\u0609\3\2\2\2\u0607\u0605\3\2\2\2\u0608\u05fd\3\2"+
		"\2\2\u0608\u0600\3\2\2\2\u0609\u0101\3\2\2\2\u060a\u060b\7b\2\2\u060b"+
		"\u060c\5\u00ecw\2\u060c\u060d\b\u0082\1\2\u060d\u060e\5\u0104\u0083\2"+
		"\u060e\u060f\b\u0082\1\2\u060f\u0103\3\2\2\2\u0610\u0611\5n8\2\u0611\u061c"+
		"\b\u0083\1\2\u0612\u061d\5\u0106\u0084\2\u0613\u0614\7\21\2\2\u0614\u0615"+
		"\5n8\2\u0615\u0616\b\u0083\1\2\u0616\u0618\3\2\2\2\u0617\u0613\3\2\2\2"+
		"\u0618\u061b\3\2\2\2\u0619\u0617\3\2\2\2\u0619\u061a\3\2\2\2\u061a\u061d"+
		"\3\2\2\2\u061b\u0619\3\2\2\2\u061c\u0612\3\2\2\2\u061c\u0619\3\2\2\2\u061d"+
		"\u0105\3\2\2\2\u061e\u0620\5\u0108\u0085\2\u061f\u0621\5\u010a\u0086\2"+
		"\u0620\u061f\3\2\2\2\u0620\u0621\3\2\2\2\u0621\u0624\3\2\2\2\u0622\u0624"+
		"\5\u010a\u0086\2\u0623\u061e\3\2\2\2\u0623\u0622\3\2\2\2\u0624\u0107\3"+
		"\2\2\2\u0625\u0626\7I\2\2\u0626\u0627\5\u010c\u0087\2\u0627\u0109\3\2"+
		"\2\2\u0628\u0629\7(\2\2\u0629\u062a\5\u010c\u0087\2\u062a\u010b\3\2\2"+
		"\2\u062b\u062c\7\24\2\2\u062c\u0631\5\36\20\2\u062d\u062e\7\21\2\2\u062e"+
		"\u0630\5\36\20\2\u062f\u062d\3\2\2\2\u0630\u0633\3\2\2\2\u0631\u062f\3"+
		"\2\2\2\u0631\u0632\3\2\2\2\u0632\u0634\3\2\2\2\u0633\u0631\3\2\2\2\u0634"+
		"\u0635\7\25\2\2\u0635\u010d\3\2\2\2\u0636\u0639\5\u0112\u008a\2\u0637"+
		"\u0639\5\u0110\u0089\2\u0638\u0636\3\2\2\2\u0638\u0637\3\2\2\2\u0639\u010f"+
		"\3\2\2\2\u063a\u063b\7f\2\2\u063b\u063c\b\u0089\1\2\u063c\u063d\7u\2\2"+
		"\u063d\u0111\3\2\2\2\u063e\u063f\5\u0114\u008b\2\u063f\u0640\7\22\2\2"+
		"\u0640\u0641\5\u011a\u008e\2\u0641\u0642\7\23\2\2\u0642\u0113\3\2\2\2"+
		"\u0643\u0644\7f\2\2\u0644\u0646\7u\2\2\u0645\u0647\5\u0118\u008d\2\u0646"+
		"\u0645\3\2\2\2\u0646\u0647\3\2\2\2\u0647\u0649\3\2\2\2\u0648\u064a\5\u0116"+
		"\u008c\2\u0649\u0648\3\2\2\2\u0649\u064a\3\2\2\2\u064a\u0115\3\2\2\2\u064b"+
		"\u064c\7M\2\2\u064c\u0651\5\36\20\2\u064d\u064e\7\21\2\2\u064e\u0650\5"+
		"\36\20\2\u064f\u064d\3\2\2\2\u0650\u0653\3\2\2\2\u0651\u064f\3\2\2\2\u0651"+
		"\u0652\3\2\2\2\u0652\u0117\3\2\2\2\u0653\u0651\3\2\2\2\u0654\u0655\7\20"+
		"\2\2\u0655\u0656\5\36\20\2\u0656\u0119\3\2\2\2\u0657\u0659\5\u011c\u008f"+
		"\2\u0658\u0657\3\2\2\2\u0659\u065c\3\2\2\2\u065a\u0658\3\2\2\2\u065a\u065b"+
		"\3\2\2\2\u065b\u011b\3\2\2\2\u065c\u065a\3\2\2\2\u065d\u065e\5\u011e\u0090"+
		"\2\u065e\u065f\7\17\2\2\u065f\u0670\3\2\2\2\u0660\u0661\5\u0122\u0092"+
		"\2\u0661\u0662\7\17\2\2\u0662\u0670\3\2\2\2\u0663\u0664\5\u0124\u0093"+
		"\2\u0664\u0665\7\17\2\2\u0665\u0670\3\2\2\2\u0666\u0667\5\u0126\u0094"+
		"\2\u0667\u0668\7\17\2\2\u0668\u0670\3\2\2\2\u0669\u066a\5\u0128\u0095"+
		"\2\u066a\u066b\7\17\2\2\u066b\u0670\3\2\2\2\u066c\u066d\5\u00d6l\2\u066d"+
		"\u066e\7\17\2\2\u066e\u0670\3\2\2\2\u066f\u065d\3\2\2\2\u066f\u0660\3"+
		"\2\2\2\u066f\u0663\3\2\2\2\u066f\u0666\3\2\2\2\u066f\u0669\3\2\2\2\u066f"+
		"\u066c\3\2\2\2\u0670\u011d\3\2\2\2\u0671\u0672\7]\2\2\u0672\u0673\5\u0120"+
		"\u0091\2\u0673\u0674\7u\2\2\u0674\u011f\3\2\2\2\u0675\u0678\5\36\20\2"+
		"\u0676\u0678\7O\2\2\u0677\u0675\3\2\2\2\u0677\u0676\3\2\2\2\u0678\u0121"+
		"\3\2\2\2\u0679\u067b\7/\2\2\u067a\u067c\7Z\2\2\u067b\u067a\3\2\2\2\u067b"+
		"\u067c\3\2\2\2\u067c\u067d\3\2\2\2\u067d\u067e\5\u0120\u0091\2\u067e\u067f"+
		"\7u\2\2\u067f\u0123\3\2\2\2\u0680\u0681\7*\2\2\u0681\u0682\5\36\20\2\u0682"+
		"\u0683\7u\2\2\u0683\u0125\3\2\2\2\u0684\u0685\7-\2\2\u0685\u0686\5\36"+
		"\20\2\u0686\u0687\7u\2\2\u0687\u0127\3\2\2\2\u0688\u0689\7^\2\2\u0689"+
		"\u068a\5\36\20\2\u068a\u068b\7u\2\2\u068b\u0129\3\2\2\2\u068c\u068d\5"+
		"\u012c\u0097\2\u068d\u068e\5\u0132\u009a\2\u068e\u012b\3\2\2\2\u068f\u0690"+
		"\7F\2\2\u0690\u0692\7u\2\2\u0691\u0693\5\u012e\u0098\2\u0692\u0691\3\2"+
		"\2\2\u0692\u0693\3\2\2\2\u0693\u0695\3\2\2\2\u0694\u0696\5\u0116\u008c"+
		"\2\u0695\u0694\3\2\2\2\u0695\u0696\3\2\2\2\u0696\u0697\3\2\2\2\u0697\u0698"+
		"\7d\2\2\u0698\u069a\5\36\20\2\u0699\u069b\5\u0130\u0099\2\u069a\u0699"+
		"\3\2\2\2\u069a\u069b\3\2\2\2\u069b\u012d\3\2\2\2\u069c\u069d\7\20\2\2"+
		"\u069d\u069e\5\36\20\2\u069e\u012f\3\2\2\2\u069f\u06a0\7\60\2\2\u06a0"+
		"\u06a1\5\36\20\2\u06a1\u0131\3\2\2\2\u06a2\u06a6\7\22\2\2\u06a3\u06a5"+
		"\5\u0134\u009b\2\u06a4\u06a3\3\2\2\2\u06a5\u06a8\3\2\2\2\u06a6\u06a4\3"+
		"\2\2\2\u06a6\u06a7\3\2\2\2\u06a7\u06a9\3\2\2\2\u06a8\u06a6\3\2\2\2\u06a9"+
		"\u06aa\7\23\2\2\u06aa\u0133\3\2\2\2\u06ab\u06b3\5\24\13\2\u06ac\u06ad"+
		"\5\u0136\u009c\2\u06ad\u06ae\7\17\2\2\u06ae\u06b3\3\2\2\2\u06af\u06b0"+
		"\5\u0138\u009d\2\u06b0\u06b1\7\17\2\2\u06b1\u06b3\3\2\2\2\u06b2\u06ab"+
		"\3\2\2\2\u06b2\u06ac\3\2\2\2\u06b2\u06af\3\2\2\2\u06b3\u0135\3\2\2\2\u06b4"+
		"\u06b5\7G\2\2\u06b5\u06b6\7u\2\2\u06b6\u06b8\7\24\2\2\u06b7\u06b9\5\66"+
		"\34\2\u06b8\u06b7\3\2\2\2\u06b8\u06b9\3\2\2\2\u06b9\u06ba\3\2\2\2\u06ba"+
		"\u06bc\7\25\2\2\u06bb\u06bd\5\u00e8u\2\u06bc\u06bb\3\2\2\2\u06bc\u06bd"+
		"\3\2\2\2\u06bd\u0137\3\2\2\2\u06be\u06bf\78\2\2\u06bf\u06c0\7u\2\2\u06c0"+
		"\u06c2\7\24\2\2\u06c1\u06c3\5\66\34\2\u06c2\u06c1\3\2\2\2\u06c2\u06c3"+
		"\3\2\2\2\u06c3\u06c4\3\2\2\2\u06c4\u06c6\7\25\2\2\u06c5\u06c7\5\u00e8"+
		"u\2\u06c6\u06c5\3\2\2\2\u06c6\u06c7\3\2\2\2\u06c7\u0139\3\2\2\2\u06c8"+
		"\u06cc\5\u0140\u00a1\2\u06c9\u06cc\5\u013e\u00a0\2\u06ca\u06cc\5\u013c"+
		"\u009f\2\u06cb\u06c8\3\2\2\2\u06cb\u06c9\3\2\2\2\u06cb\u06ca\3\2\2\2\u06cc"+
		"\u013b\3\2\2\2\u06cd\u06cf\7[\2\2\u06ce\u06cd\3\2\2\2\u06ce\u06cf\3\2"+
		"\2\2\u06cf\u06d0\3\2\2\2\u06d0\u06d1\7<\2\2\u06d1\u06d2\7u\2\2\u06d2\u013d"+
		"\3\2\2\2\u06d3\u06d4\7[\2\2\u06d4\u06d5\7<\2\2\u06d5\u06d6\7u\2\2\u06d6"+
		"\u06d7\5,\27\2\u06d7\u06db\7\22\2\2\u06d8\u06da\5\24\13\2\u06d9\u06d8"+
		"\3\2\2\2\u06da\u06dd\3\2\2\2\u06db\u06d9\3\2\2\2\u06db\u06dc\3\2\2\2\u06dc"+
		"\u06de\3\2\2\2\u06dd\u06db\3\2\2\2\u06de\u06df\7\23\2\2\u06df\u013f\3"+
		"\2\2\2\u06e0\u06e1\5\u0142\u00a2\2\u06e1\u06e5\7\22\2\2\u06e2\u06e4\5"+
		"\60\31\2\u06e3\u06e2\3\2\2\2\u06e4\u06e7\3\2\2\2\u06e5\u06e3\3\2\2\2\u06e5"+
		"\u06e6\3\2\2\2\u06e6\u06e8\3\2\2\2\u06e7\u06e5\3\2\2\2\u06e8\u06e9\7\23"+
		"\2\2\u06e9\u0141\3\2\2\2\u06ea\u06ec\7\61\2\2\u06eb\u06ea\3\2\2\2\u06eb"+
		"\u06ec\3\2\2\2\u06ec\u06ed\3\2\2\2\u06ed\u06ee\7<\2\2\u06ee\u06ef\7u\2"+
		"\2\u06ef\u06f0\5,\27\2\u06f0\u0143\3\2\2\2\u06f1\u06f2\7$\2\2\u06f2\u06f3"+
		"\5\36\20\2\u06f3\u06f9\b\u00a3\1\2\u06f4\u06f6\7\24\2\2\u06f5\u06f7\5"+
		"\u0146\u00a4\2\u06f6\u06f5\3\2\2\2\u06f6\u06f7\3\2\2\2\u06f7\u06f8\3\2"+
		"\2\2\u06f8\u06fa\7\25\2\2\u06f9\u06f4\3\2\2\2\u06f9\u06fa\3\2\2\2\u06fa"+
		"\u0145\3\2\2\2\u06fb\u06fc\5@!\2\u06fc\u06fd\b\u00a4\1\2\u06fd\u0707\3"+
		"\2\2\2\u06fe\u0703\5\u0148\u00a5\2\u06ff\u0700\7\21\2\2\u0700\u0702\5"+
		"\u0148\u00a5\2\u0701\u06ff\3\2\2\2\u0702\u0705\3\2\2\2\u0703\u0701\3\2"+
		"\2\2\u0703\u0704\3\2\2\2\u0704\u0707\3\2\2\2\u0705\u0703\3\2\2\2\u0706"+
		"\u06fb\3\2\2\2\u0706\u06fe\3\2\2\2\u0707\u0147\3\2\2\2\u0708\u0709\5\u014a"+
		"\u00a6\2\u0709\u070a\7\"\2\2\u070a\u070b\5@!\2\u070b\u070c\b\u00a5\1\2"+
		"\u070c\u0149\3\2\2\2\u070d\u070e\7u\2\2\u070e\u014b\3\2\2\2\u0082\u014f"+
		"\u0157\u018a\u019e\u01a4\u01a7\u01ae\u01b8\u01c4\u01e6\u01fa\u01ff\u020a"+
		"\u0213\u0216\u0227\u0231\u0237\u023f\u0246\u0249\u0251\u0254\u025b\u0266"+
		"\u026a\u0273\u02a2\u02b0\u02bc\u02c8\u02d4\u02e0\u02ec\u02f7\u0305\u0312"+
		"\u031a\u0338\u0344\u034f\u035a\u0371\u0383\u038a\u0394\u039f\u03a8\u03b7"+
		"\u03bf\u03cd\u03d8\u03e6\u03ed\u03f2\u03f8\u040c\u0419\u0422\u042b\u043a"+
		"\u044a\u044c\u045f\u046e\u0479\u0481\u048b\u0496\u049d\u04a7\u04c0\u04d5"+
		"\u04dc\u04e6\u04e8\u04ff\u0514\u0527\u0536\u0542\u054d\u0557\u0564\u0575"+
		"\u057b\u0588\u058b\u0596\u059a\u05a8\u05be\u05cf\u05e3\u05ec\u0605\u0608"+
		"\u0619\u061c\u0620\u0623\u0631\u0638\u0646\u0649\u0651\u065a\u066f\u0677"+
		"\u067b\u0692\u0695\u069a\u06a6\u06b2\u06b8\u06bc\u06c2\u06c6\u06cb\u06ce"+
		"\u06db\u06e5\u06eb\u06f6\u06f9\u0703\u0706";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}