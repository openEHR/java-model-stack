package org.openehr.aom.terminology;

import org.apache.commons.lang.NotImplementedException;
import org.openehr.aom.archetype.Archetype;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Local terminology of an archetype. This class defines the semantics of the terminology of an archetype.
 *
 * Created by cnanjo on 5/19/16.
 */
public class ArchetypeTerminology {
    /**
     * Indicates whether terminology is differential or the result of flattening
     */
    private Boolean isDifferential;
    /**
     * Original language of the terminology, as set at archetype creation or parsing time;
     * must be a code in the ISO 639-1 2 character language code-set.
     */
    private String originalLanguage;
    /**
     * Term code defining the meaning of the archetype as a whole, and always used as the at-code
     * on the root node of the archetype. Must be defined in the term_definitions property.
     */
    private String conceptCode;
    /**
     * Directory of term definitions as a two-level table. The outer hash keys are language codes, e.g. “en”, “de”,
     * while the inner hash keys are term codes, e.g. “id17”, “at4”.
     */
    private Map<String, Map<String, ArchetypeTerm>> termDefinitions;
    /**
     * Directory of bindings to external terminology codes and value sets, as a two-level table. The outer hash keys
     * are terminology ids, e.g. “SNOMED_CT”, and the inner hash keys are constraint codes, e.g. “at4”, “ac13” or paths.
     * The indexed DV_URI objects represent references to externally defined resources, either terms, ontology concepts,
     * or terminology subsets / ref-sets.
     */
    private Map<String, Map<String, URI>> termBindings;
    /**
     * Archetype that owns this terminology.
     */
    private Archetype ownerArchetype;
    /**
     * Archetype-local value sets, each keyed by value-set id, i.e. an ac-code.
     */
    private Map<String, ValueSet> valueSets;
    /**
     * Directory of extracts of external terminologies, as a two-level table. The outer hash keys are terminology ids,
     * e.g. “SNOMED_CT”, while the inner hash keys are term codes or code-phrases from the relevant terminology,
     * e.g. “10094842”.
     */
    private Map<String, Map<String, ArchetypeTerm>> terminologyExtracts;

    /**
     * True if this terminology is a differential terminology
     * (as opposed to the terminology that results from the flattening
     * of the archetype hierarchy)
     *
     * @return
     */
    public Boolean isDifferential() {
        return isDifferential;
    }

    /**
     * Set to True if this terminology is a differential terminology
     * (as opposed to the terminology that results from the flattening
     * of the archetype hierarchy). Set to false, otherwise.
     *
     * @param differential
     */
    public void setDifferential(Boolean differential) {
        isDifferential = differential;
    }

    /**
     * Returns the original language of the terminology, as set at archetype creation or parsing time;
     * must be a code in the ISO 639-1 2 character language code-set.
     *
     * @return
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     * Sets the original language of the terminology, as set at archetype creation or parsing time; must
     * be a code in the ISO 639-1 2 character language code-set.
     *
     * @param originalLanguage
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     * Sets the term code defining the meaning of the archetype as a whole, and always used as the at-code on the root
     * node of the archetype. Must be defined in the term_definitions property.
     *
     * @return
     */
    public String getConceptCode() {
        return conceptCode;
    }

    /**
     * Returns the term code defining the meaning of the archetype as a whole, and always used as the at-code on the root
     * node of the archetype. Must be defined in the term_definitions property.
     *
     * @param conceptCode
     */
    public void setConceptCode(String conceptCode) {
        this.conceptCode = conceptCode;
    }

    /**
     * Sets the directory of term definitions as a two-level table. The outer hash keys are language codes,
     * e.g. “en”, “de”, while the inner hash keys are term codes, e.g. “id17”, “at4”.
     *
     * @return
     */
    public Map<String, Map<String, ArchetypeTerm>> getTermDefinitions() {
        return termDefinitions;
    }

    /**
     * Returns the directory of term definitions as a two-level table. The outer hash keys are language codes,
     * e.g. “en”, “de”, while the inner hash keys are term codes, e.g. “id17”, “at4”.
     *
     * @param termDefinitions
     */
    public void setTermDefinitions(Map<String, Map<String, ArchetypeTerm>> termDefinitions) {
        this.termDefinitions = termDefinitions;
    }

    /**
     * Returns the directory of bindings to external terminology codes and value sets, as a two-level table.
     * The outer hash keys are terminology ids, e.g. “SNOMED_CT”, and the inner hash keys are constraint codes,
     * e.g. “at4”, “ac13” or paths. The indexed DV_URI objects represent references to externally defined
     * resources, either terms, ontology concepts, or terminology subsets / ref-sets.
     *
     * @return
     */
    public Map<String, Map<String, URI>> getTermBindings() {
        return termBindings;
    }

    /**
     * Setsthe directory of bindings to external terminology codes and value sets, as a two-level table.
     * The outer hash keys are terminology ids, e.g. “SNOMED_CT”, and the inner hash keys are constraint codes,
     * e.g. “at4”, “ac13” or paths. The indexed DV_URI objects represent references to externally defined
     * resources, either terms, ontology concepts, or terminology subsets / ref-sets.
     *
     * @param termBindings
     */
    public void setTermBindings(Map<String, Map<String, URI>> termBindings) {
        this.termBindings = termBindings;
    }

    /**
     * Returns the owning archetype.
     *
     * @return
     */
    public Archetype getOwnerArchetype() {
        return ownerArchetype;
    }

    /**
     * Sets the owning archetype.
     *
     * @param ownerArchetype
     */
    public void setOwnerArchetype(Archetype ownerArchetype) {
        this.ownerArchetype = ownerArchetype;
    }

    /**
     * Returns Archetype-local value sets, each keyed by value-set id, i.e. an ac-code.
     *
     * @return
     */
    public Map<String, ValueSet> getValueSets() {
        return valueSets;
    }

    /**
     * Sets Archetype-local value sets, each keyed by value-set id, i.e. an ac-code.
     *
     * @param valueSets
     */
    public void setValueSets(Map<String, ValueSet> valueSets) {
        this.valueSets = valueSets;
    }

    /**
     * Returns directory of extracts of external terminologies, as a two-level table.
     * The outer hash keys are terminology ids, e.g. “SNOMED_CT”, while the inner hash
     * keys are term codes or code-phrases from the relevant terminology, e.g. “10094842”.
     *
     * @return
     */
    public Map<String, Map<String, ArchetypeTerm>> getTerminologyExtracts() {
        return terminologyExtracts;
    }

    /**
     * Sets directory of extracts of external terminologies, as a two-level table.
     * The outer hash keys are terminology ids, e.g. “SNOMED_CT”, while the inner hash
     * keys are term codes or code-phrases from the relevant terminology, e.g. “10094842”.
     *
     * @param terminologyExtracts
     */
    public void setTerminologyExtracts(Map<String, Map<String, ArchetypeTerm>> terminologyExtracts) {
        this.terminologyExtracts = terminologyExtracts;
    }

    /**
     * Specialisation depth of this archetype. Unspecialised archetypes have depth 0,
     * with each additional level of specialisation adding 1 to the specialisation_depth.
     *
     * @return
     */
    public Integer specializationDepth() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * List of all id codes in the terminology., i.e. the “id” codes in an ADL archetype,
     * which are the node_ids on C_OBJECT descendants.
     *
     * @return
     */
    public List<String> idCodes() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * List of all value term codes in the terminology, i.e. the “at” codes in an ADL archetype,
     * which are used as possible values on terminological constrainer nodes.
     *
     * @return
     */
    public List<String> valueCodes() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * List of all value set codes in the terminology defining value sets.
     * These correspond to the “ac” codes in an ADL archetype.
     *
     * @return
     */
    public List<String> valueSetCodes() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns True if language `a_lang' is present in archetype terminology.
     *
     * @param aLanguage
     * @return
     */
    public Boolean hasLanguage(String aLanguage) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns True if terminology `a_terminology' is present in archetype ontology.
     *
     * @param aTerminologyId
     * @return
     */
    public Boolean hasTerminology(String aTerminologyId) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns True if code 'a_code' defined in this terminology.
     *
     * @param aCode
     * @return
     */
    public Boolean hasTermCode(String aCode) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns term definition for a code, in a specified language.
     *
     * @param aLang
     * @param aCode
     * @return
     */
    public ArchetypeTerm termDefinition(String aLang, String aCode) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Binding of constraint corresponding to a_code in target external terminology
     * a_terminology_id, as a string, which is usually a formal query expression.
     *
     * @param aTerminology
     * @param aCode
     * @return
     */
    public URI termBinding(String aTerminology, String aCode) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns list of terminologies to which term or constraint bindings exist in this terminology,
     * computed from bindings.
     *
     * @return
     */
    public List<String> terminologiesAvailable() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Return an ARCHETYPE_TERM from specified terminology extract and the specified term code.
     * @param aTerminologyId
     * @param aCode
     * @return
     */
    public ArchetypeTerm terminologyExtractTerm(String aTerminologyId, String aCode) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns true if a terminology extract exists for the given terminology ID.
     *
     * @param aTerminologyId
     * @return
     */
    public Boolean hasTerminologyExtract(String aTerminologyId) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * List of languages in which terms in this terminology are available.
     *
     * @return
     */
    public List<String> languagesAvailable() {
        throw new NotImplementedException();//TODO Need to implement
    }
}
