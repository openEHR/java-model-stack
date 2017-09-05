// Generated from /Users/cnanjo/repository/mine/adl-tools/adl/src/main/resources/antlr/adl.g4 by ANTLR 4.5.1
package org.openehr.adl.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link adlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface adlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link adlParser#adl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdl(adlParser.AdlContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#authored_archetype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthored_archetype(adlParser.Authored_archetypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(adlParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#template_overlay}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate_overlay(adlParser.Template_overlayContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#operational_template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperational_template(adlParser.Operational_templateContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#specialize_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialize_section(adlParser.Specialize_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#language_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguage_section(adlParser.Language_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#description_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription_section(adlParser.Description_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#definition_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition_section(adlParser.Definition_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#rules_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules_section(adlParser.Rules_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#terminology_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminology_section(adlParser.Terminology_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#annotations_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotations_section(adlParser.Annotations_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#component_terminologies_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent_terminologies_section(adlParser.Component_terminologies_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#meta_data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta_data(adlParser.Meta_dataContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#meta_data_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta_data_item(adlParser.Meta_data_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#meta_data_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta_data_value(adlParser.Meta_data_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#meta_data_tag_adl_version}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta_data_tag_adl_version(adlParser.Meta_data_tag_adl_versionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#meta_data_tag_uid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta_data_tag_uid(adlParser.Meta_data_tag_uidContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#meta_data_tag_build_uid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta_data_tag_build_uid(adlParser.Meta_data_tag_build_uidContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#meta_data_tag_rm_release}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta_data_tag_rm_release(adlParser.Meta_data_tag_rm_releaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#meta_data_tag_is_controlled}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta_data_tag_is_controlled(adlParser.Meta_data_tag_is_controlledContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#meta_data_tag_is_generated}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta_data_tag_is_generated(adlParser.Meta_data_tag_is_generatedContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_complex_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_complex_object(adlParser.C_complex_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_objects}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_objects(adlParser.C_objectsContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#sibling_order}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSibling_order(adlParser.Sibling_orderContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_non_primitive_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_non_primitive_object(adlParser.C_non_primitive_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_archetype_root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_archetype_root(adlParser.C_archetype_rootContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_complex_object_proxy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_complex_object_proxy(adlParser.C_complex_object_proxyContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#archetype_slot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchetype_slot(adlParser.Archetype_slotContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_attribute_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_attribute_def(adlParser.C_attribute_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_attribute(adlParser.C_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#adl_dir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdl_dir(adlParser.Adl_dirContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_attribute_tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_attribute_tuple(adlParser.C_attribute_tupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_primitive_tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_primitive_tuple(adlParser.C_primitive_tupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_includes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_includes(adlParser.C_includesContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_excludes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_excludes(adlParser.C_excludesContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_existence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_existence(adlParser.C_existenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#existence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistence(adlParser.ExistenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_cardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_cardinality(adlParser.C_cardinalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#cardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCardinality(adlParser.CardinalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#ordering_mod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdering_mod(adlParser.Ordering_modContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#unique_mod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnique_mod(adlParser.Unique_modContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#multiplicity_mod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicity_mod(adlParser.Multiplicity_modContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_occurrences}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_occurrences(adlParser.C_occurrencesContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#multiplicity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicity(adlParser.MultiplicityContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(adlParser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#boolean_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_expr(adlParser.Boolean_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#boolean_leaf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_leaf(adlParser.Boolean_leafContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#boolean_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_constraint(adlParser.Boolean_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#boolean_binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_binop(adlParser.Boolean_binopContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_literal(adlParser.Boolean_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#arithmetic_relop_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_relop_expr(adlParser.Arithmetic_relop_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#arithmetic_leaf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_leaf(adlParser.Arithmetic_leafContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#arithmetic_arith_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_arith_expr(adlParser.Arithmetic_arith_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#relational_binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_binop(adlParser.Relational_binopContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#arithmetic_binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_binop(adlParser.Arithmetic_binopContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_primitive_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_primitive_object(adlParser.C_primitive_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_integer(adlParser.C_integerContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#assumed_integer_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumed_integer_value(adlParser.Assumed_integer_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_real(adlParser.C_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#assumed_real_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumed_real_value(adlParser.Assumed_real_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_date_time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_date_time(adlParser.C_date_timeContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#assumed_date_time_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumed_date_time_value(adlParser.Assumed_date_time_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_date(adlParser.C_dateContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#assumed_date_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumed_date_value(adlParser.Assumed_date_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_time(adlParser.C_timeContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#assumed_time_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumed_time_value(adlParser.Assumed_time_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_duration(adlParser.C_durationContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#assumed_duration_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumed_duration_value(adlParser.Assumed_duration_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_string(adlParser.C_stringContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#assumed_string_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumed_string_value(adlParser.Assumed_string_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#regex_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegex_constraint(adlParser.Regex_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_terminology_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_terminology_code(adlParser.C_terminology_codeContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#c_boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_boolean(adlParser.C_booleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#assumed_boolean_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssumed_boolean_value(adlParser.Assumed_boolean_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#adl_path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdl_path(adlParser.Adl_pathContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#adl_relative_path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdl_relative_path(adlParser.Adl_relative_pathContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#adl_path_segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdl_path_segment(adlParser.Adl_path_segmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#adl_path_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdl_path_element(adlParser.Adl_path_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#string_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_value(adlParser.String_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#string_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_list_value(adlParser.String_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#integer_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_value(adlParser.Integer_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#integer_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_list_value(adlParser.Integer_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#integer_interval_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_interval_value(adlParser.Integer_interval_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#integer_interval_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_interval_list_value(adlParser.Integer_interval_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#real_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_value(adlParser.Real_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#real_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_list_value(adlParser.Real_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#real_interval_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_interval_value(adlParser.Real_interval_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#real_interval_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_interval_list_value(adlParser.Real_interval_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#boolean_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_value(adlParser.Boolean_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#boolean_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_list_value(adlParser.Boolean_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#character_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter_value(adlParser.Character_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#character_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter_list_value(adlParser.Character_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#date_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_value(adlParser.Date_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#date_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_list_value(adlParser.Date_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#date_interval_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_interval_value(adlParser.Date_interval_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#date_interval_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_interval_list_value(adlParser.Date_interval_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#time_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_value(adlParser.Time_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#time_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_list_value(adlParser.Time_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#time_interval_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_interval_value(adlParser.Time_interval_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#time_interval_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_interval_list_value(adlParser.Time_interval_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#date_time_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_time_value(adlParser.Date_time_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#date_time_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_time_list_value(adlParser.Date_time_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#date_time_interval_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_time_interval_value(adlParser.Date_time_interval_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#date_time_interval_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_time_interval_list_value(adlParser.Date_time_interval_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#duration_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration_value(adlParser.Duration_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#duration_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration_list_value(adlParser.Duration_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#duration_interval_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration_interval_value(adlParser.Duration_interval_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#duration_interval_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration_interval_list_value(adlParser.Duration_interval_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#term_code_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_code_value(adlParser.Term_code_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#term_code_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_code_list_value(adlParser.Term_code_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#uri_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUri_value(adlParser.Uri_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(adlParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#rm_type_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRm_type_id(adlParser.Rm_type_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#rm_attribute_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRm_attribute_id(adlParser.Rm_attribute_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(adlParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#archetype_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchetype_ref(adlParser.Archetype_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#odin_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOdin_text(adlParser.Odin_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#attr_vals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_vals(adlParser.Attr_valsContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#attr_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_val(adlParser.Attr_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#object_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_block(adlParser.Object_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#object_value_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_value_block(adlParser.Object_value_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#keyed_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyed_object(adlParser.Keyed_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#primitive_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_object(adlParser.Primitive_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#primitive_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_value(adlParser.Primitive_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#primitive_list_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_list_value(adlParser.Primitive_list_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#primitive_interval_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_interval_value(adlParser.Primitive_interval_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#object_reference_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_reference_block(adlParser.Object_reference_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#odin_path_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOdin_path_list(adlParser.Odin_path_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#odin_path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOdin_path(adlParser.Odin_pathContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#odin_path_segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOdin_path_segment(adlParser.Odin_path_segmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link adlParser#odin_path_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOdin_path_element(adlParser.Odin_path_elementContext ctx);
}