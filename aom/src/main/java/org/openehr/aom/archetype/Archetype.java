package org.openehr.aom.archetype;

import org.openehr.aom.constraintmodel.CComplexObject;
import org.openehr.expressions.core.Statement;
import org.openehr.aom.terminology.ArchetypeTerminology;
import org.openehr.validation.ValidationResult;

import java.util.List;

/**
 * The ARCHETYPE interface defines the core formal contract of the root object of any archetype or template.
 * It includes only basic identification information, and otherwise provides the structural connections
 * from the Archetype to its constituent parts, i.e. definition (a C_COMPLEX_OBJECT),
 * terminology (ARCHEYTPE_TERMINOLOGY) and so on.
 *
 * Created by cnanjo on 5/20/16.
 */
public interface Archetype {
    /**
     * Returns the archetype reference of the specialisation parent of this archetype,
     * if applicable. May take the form of an archetype interface identifier, i.e. the
     * identifier up to the major version only, or can be deeper.
     *
     * @return
     */
    public String getParentArchetypeId();

    /**
     * Sets the archetype reference of the specialisation parent of this archetype,
     * if applicable. May take the form of an archetype interface identifier, i.e. the
     * identifier up to the major version only, or can be deeper.
     *
     * @param parentArchetypeId
     */
    public void setParentArchetypeId(String parentArchetypeId);

    /**
     * Method returns the identifier for this archetype.
     *
     * @return Identifier of this archetype.
     */
    public ArchetypeHrid getArchetypeId();

    /**
     * Method sets the identifier for this archetype.
     *
     * @param archetypeId Identifier of this archetype.
     */
    public void setArchetypeId(ArchetypeHrid archetypeId);

    /**
     * Returns flag indicating whether this archetype is differential or flat in its contents.
     * Top-level source archetypes have this flag set to True.
     *
     * @return
     */
    public Boolean isDifferential();

    /**
     * Sets flag indicating whether this archetype is differential or flat in its contents.
     * Top-level source archetypes have this flag set to True.
     *
     * @param isDifferential
     */
    public void setDifferential(Boolean isDifferential);

    /**
     * Method returns the definition of this archetype.
     *
     * @return Root node of the definition of this archetype.
     */
    public CComplexObject getDefinition();

    /**
     * Method sets the definition for this archetype.
     *
     * @param definition Root node of the definition of this archetype.
     */
    public void setDefinition(CComplexObject definition);

    /**
     * Method returns the terminology of the archetype.
     *
     * @return The terminology of the archetype
     */
    public ArchetypeTerminology getTerminology();

    /**
     * Method sets the terminology of the archetype.
     *
     * @param archetypeTerminology The terminology of the archetype
     */
    public void setTerminology(ArchetypeTerminology archetypeTerminology);

    /**
     * Method returns rules relating to this archetype. Statements are expressed
     * in first order predicate logic, and usually refer to at least two attributes.
     *
     * @return Rules relating to this archetype
     */
    public List<Statement> getRules();

    /**
     * Method sets rules relating to this archetype. Statements are expressed
     * in first order predicate logic, and usually refer to at least two attributes.
     *
     * @param rules Rules relating to this archetype
     */
    public void setRules(List<Statement> rules);

    /**
     * Method adds a rule to this archetype.
     *
     * @param rule A rule to add to this archetype
     */
    public void addRule(Statement rule);

    /**
     * Method returns the concept code of the root object of the archetype, also
     * standing for the concept of the archetype as a whole.
     *
     * @return The concept code of the root object of the archetype
     */
    public String getConceptCode();

    /**
     * Method sets concept code of the root object of the archetype, also
     * standing for the concept of the archetype as a whole.
     *
     * @param conceptCode The concept code of the root object of the archetype
     */
    public void setConceptCode(String conceptCode);

    /**
     * Returns set of language-independent paths extracted from archetype.
     * Paths obey Xpath-like syntax and are formed from alternations of C_OBJECT.node_id and
     * C_ATTRIBUTE.rm_attribute_name values.
     *
     * @return  Set of language-independent paths extracted from archetype
     */
    public List<String> getPhysicalPaths();

    /**
     * Sets set of language-independent paths extracted from archetype.
     * Paths obey Xpath-like syntax and are formed from alternations of C_OBJECT.node_id and
     * C_ATTRIBUTE.rm_attribute_name values.
     *
     * @param physicalPaths Set of language-independent paths extracted from archetype
     */
    public void setPhysicalPaths(List<String> physicalPaths);

    /**
     * Adds a language-independent path to this archetype.
     *
     * @param physicalPath Language-independent paths extracted from archetype
     */
    public void addPhysicalPath(String physicalPath);

    /**
     * Returns set of language-dependent paths extracted from archetype. Paths obey the same syntax
     * as physical_paths, but with node_ids replaced by their meanings from the ontology.
     *
     * @param lang
     * @return Set of language-dependent paths extracted from archetype
     */
    public List<String> getLogicalPaths(String lang);

    /**
     * Sets set of language-dependent paths extracted from archetype. Paths obey the same syntax as physical_paths,
     * but with node_ids replaced by their meanings from the ontology.
     * @param lang
     * @param logicalPaths Set of language-dependent paths extracted from archetype
     */
    public void setLogicalPaths(String lang, List<String> logicalPaths);

    /**
     * Adds language-dependent path to this archetype.
     *
     * @param lang
     * @param logicalPath Language dependent path
     */
    public void addLogicalPath(String lang, String logicalPath);

    /**
     * Method returns specialisation depth of this archetype; larger than 0
     * if this archetype has a parent. Derived from terminology.specialisation_depth.
     *
     * @return Specialisation depth of this archetype
     */
    public Integer getSpecializationDepth();

    /**
     * Method sets specialisation depth of this archetype; larger than 0
     * if this archetype has a parent. Derived from terminology.specialisation_depth.
     *
     * @param depth Specialisation depth of this archetype
     */
    public void setSpecializationDepth(Integer depth);

    /**
     * True if this archetype is a specialisation of another.
     *
     * @return True if this archetype is a specialisation of another.
     */
    public boolean isSpecialized();

    /**
     * Method validates that archetype is well-formed.
     *
     * @return
     */
    public ValidationResult validation();
}
