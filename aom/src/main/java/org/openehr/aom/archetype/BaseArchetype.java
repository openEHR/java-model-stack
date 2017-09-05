package org.openehr.aom.archetype;

import org.openehr.aom.constraintmodel.CComplexObject;
import org.openehr.expressions.core.Statement;
import org.openehr.aom.terminology.ArchetypeTerminology;
import org.openehr.validation.ValidationResult;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cnanjo on 5/19/16.
 *
 * An archetype is a specification of data groups and data constraints.
 */
public abstract class BaseArchetype implements Archetype {

    /**
     * Archetype reference of the specialisation par-ent of this archetype, if applicable.
     * May take the form of an archetype interface identifier, i.e. the identifier up to
     * the major version only, or can be deeper.
     *
     */
    private String parentArchetypeId;
    /**
     * Identifier of this archetype.
     */
    private ArchetypeHrid archetypeId;
    /**
     * Flag indicating whether this archetype is differential or flat in its contents.
     * Top-level source archetypes have this flag set to True.
     */
    private Boolean isDifferential;
    /**
     * Root node of the definition of this archetype.
     */
    private CComplexObject definition;
    /**
     * Rules relating to this archetype. Statements are expressed in first order predicate logic,
     * and usually refer to at least two attributes.
     */
    private List<Statement> rules;
    /**
     * The terminology of the archetype.
     */
    private ArchetypeTerminology terminology;

    protected BaseArchetype() {
        this.rules = new ArrayList<>();
    }

    /**
     * Returns the archetype reference of the specialisation parent of this archetype,
     * if applicable. May take the form of an archetype interface identifier, i.e. the
     * identifier up to the major version only, or can be deeper.
     *
     * @return
     */
    @Override
    public String getParentArchetypeId() {
        return this.parentArchetypeId;
    }

    /**
     * Sets the archetype reference of the specialisation parent of this archetype,
     * if applicable. May take the form of an archetype interface identifier, i.e. the
     * identifier up to the major version only, or can be deeper.
     *
     * @param parentArchetypeId
     */
    @Override
    public void setParentArchetypeId(String parentArchetypeId) {
        this.parentArchetypeId = parentArchetypeId;
    }

    /**
     * Method returns the identifier for this archetype.
     *
     * @return Identifier of this archetype.
     */
    @Override
    public ArchetypeHrid getArchetypeId() {
        return this.archetypeId;
    }

    /**
     * Method sets the identifier for this archetype.
     *
     * @param archetypeId Identifier of this archetype.
     */
    @Override
    public void setArchetypeId(ArchetypeHrid archetypeId) {
        this.archetypeId = archetypeId;
    }

    public void setArchetypeId(String archetypeId) {
        this.archetypeId = ArchetypeHrid.fromString(archetypeId);
    }

    /**
     * Returns flag indicating whether this archetype is differential or flat in its contents.
     * Top-level source archetypes have this flag set to True.
     *
     * @return
     */
    @Override
    public Boolean isDifferential() {
        return this.isDifferential;
    }

    /**
     * Sets flag indicating whether this archetype is differential or flat in its contents.
     * Top-level source archetypes have this flag set to True.
     *
     * @param isDifferential
     */
    @Override
    public void setDifferential(Boolean isDifferential) {
        this.isDifferential = isDifferential;
    }

    /**
     * Method returns the definition of this archetype.
     *
     * @return Root node of the definition of this archetype.
     */
    @Override
    public CComplexObject getDefinition() {
        return this.definition;
    }

    /**
     * Method sets the definition for this archetype.
     *
     * @param definition Root node of the definition of this archetype.
     */
    @Override
    public void setDefinition(CComplexObject definition) {
        this.definition = definition;
    }

    /**
     * Method returns the terminology of the archetype.
     *
     * @return The terminology of the archetype
     */
    @Override
    public ArchetypeTerminology getTerminology() {
        return this.terminology;
    }

    /**
     * Method sets the terminology of the archetype.
     *
     * @param archetypeTerminology The terminology of the archetype
     */
    @Override
    public void setTerminology(ArchetypeTerminology archetypeTerminology) {
        this.terminology = archetypeTerminology;
    }

    /**
     * Method returns rules relating to this archetype. Statements are expressed
     * in first order predicate logic, and usually refer to at least two attributes.
     *
     * @return Rules relating to this archetype
     */
    @Override
    public List<Statement> getRules() {
        return this.rules;
    }

    /**
     * Method sets rules relating to this archetype. Statements are expressed
     * in first order predicate logic, and usually refer to at least two attributes.
     *
     * @param rules Rules relating to this archetype
     */
    @Override
    public void setRules(List<Statement> rules) {
        this.rules = rules;
    }

    /**
     * Method adds a rule to this archetype.
     *
     * @param rule A rule to add to this archetype
     */
    @Override
    public void addRule(Statement rule) {
        this.rules.add(rule);
    }

    /**
     * Method returns the concept code of the root object of the archetype, also
     * standing for the concept of the archetype as a whole.
     *
     * @return The concept code of the root object of the archetype
     */
    @Override
    public String getConceptCode() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Method sets concept code of the root object of the archetype, also
     * standing for the concept of the archetype as a whole.
     *
     * @param conceptCode The concept code of the root object of the archetype
     */
    @Override
    public void setConceptCode(String conceptCode) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns set of language-independent paths extracted from archetype.
     * Paths obey Xpath-like syntax and are formed from alternations of C_OBJECT.node_id and
     * C_ATTRIBUTE.rm_attribute_name values.
     *
     * @return Set of language-independent paths extracted from archetype
     */
    @Override
    public List<String> getPhysicalPaths() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Sets set of language-independent paths extracted from archetype.
     * Paths obey Xpath-like syntax and are formed from alternations of C_OBJECT.node_id and
     * C_ATTRIBUTE.rm_attribute_name values.
     *
     * @param physicalPaths Set of language-independent paths extracted from archetype
     */
    @Override
    public void setPhysicalPaths(List<String> physicalPaths) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Adds a language-independent path to this archetype.
     *
     * @param physicalPath Language-independent paths extracted from archetype
     */
    @Override
    public void addPhysicalPath(String physicalPath) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns set of language-dependent paths extracted from archetype. Paths obey the same syntax
     * as physical_paths, but with node_ids replaced by their meanings from the ontology.
     *
     * @param lang
     * @return Set of language-dependent paths extracted from archetype
     */
    @Override
    public List<String> getLogicalPaths(String lang) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Sets set of language-dependent paths extracted from archetype. Paths obey the same syntax as physical_paths,
     * but with node_ids replaced by their meanings from the ontology.
     *
     * @param lang
     * @param logicalPaths Set of language-dependent paths extracted from archetype
     */
    @Override
    public void setLogicalPaths(String lang, List<String> logicalPaths) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Adds language-dependent path to this archetype.
     *
     * @param lang
     * @param logicalPath Language dependent path
     */
    @Override
    public void addLogicalPath(String lang, String logicalPath) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Method returns specialisation depth of this archetype; larger than 0
     * if this archetype has a parent. Derived from terminology.specialisation_depth.
     *
     * @return Specialisation depth of this archetype
     */
    @Override
    public Integer getSpecializationDepth() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Method sets specialisation depth of this archetype; larger than 0
     * if this archetype has a parent. Derived from terminology.specialisation_depth.
     *
     * @param depth Specialisation depth of this archetype
     */
    @Override
    public void setSpecializationDepth(Integer depth) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if this archetype is a specialisation of another.
     *
     * @return True if this archetype is a specialisation of another.
     */
    @Override
    public boolean isSpecialized() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Method validates that archetype is well-formed.
     *
     * @return
     */
    @Override
    public ValidationResult validation() {
        throw new NotImplementedException();//TODO Need to implement
    }
}
