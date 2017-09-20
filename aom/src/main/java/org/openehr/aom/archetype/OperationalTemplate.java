package org.openehr.aom.archetype;

import org.openehr.aom.terminology.ArchetypeTerminology;

import java.util.Map;

/**
 * Root object of an operational template. An operational template is derived from a
 * TEMPLATE definition and the ARCHETYPEs and/or TEMPLATE_OVERLAYs mentioned by that
 * template by a process of flattening, and potentially removal of unneeded languages
 * and terminologies.
 *
 *  An operational template is used for generating and validating RM-canonical instance data,
 *  and also as a source artefact for generating other downstream technical artefacts, including
 *  XML schemas, APIs and UI form definitions.
 *
 * The OPERATIONAL_TEMPLATE class represents the fully flattened form of a template,
 * i.e. with all fillers and references substituted and overlays processed, to form
 * what is in practical terms, a single custom-made 'operational' artefact, ready for
 * transformation to downstream artefacts. Because an operational template includes
 * one or more other archetype structures inline, it also includes their terminologies,
 * enabling it to be treated as a self-standing artefact.
 *
 * Created by cnanjo on 5/19/16.
 */
public class OperationalTemplate extends AuthoredArchetype {

    /**
     * Compendium of flattened terminologies of archetypes externally referenced from
     * this archetype, keyed by archetype identifier. This will almost always be present
     * in a template.
     */
    private Map<String, ArchetypeTerminology> componentTerminologies;
    /**
     * Directory of term definitions as a two-level table. The outer hash keys are term codes,
     * e.g. "at4", and the inner hash key are term attribute names, e.g. "text", "description"
     * etc.
     */
    private Map<String, ArchetypeTerminology> terminologyExtract;

    /**
     * Returns a compendium of flattened terminologies of archetypes externally referenced from
     * this archetype, keyed by archetype identifier. This will almost always be present
     * in a template.
     *
     * @return
     */
    public Map<String, ArchetypeTerminology> getComponentTerminologies() {
        return componentTerminologies;
    }

    /**
     * Sets a compendium of flattened terminologies of archetypes externally referenced from
     * this archetype, keyed by archetype identifier. This will almost always be present
     * in a template.
     *
     * @param componentTerminologies
     */
    public void setComponentTerminologies(Map<String, ArchetypeTerminology> componentTerminologies) {
        this.componentTerminologies = componentTerminologies;
    }

    /**
     * Returns a directory of term definitions as a two-level table. The outer hash keys are term codes,
     * e.g. "at4", and the inner hash key are term attribute names, e.g. "text", "description" etc.
     *
     * @return
     */
    public Map<String, ArchetypeTerminology> getTerminologyExtract() {
        return terminologyExtract;
    }

    /**
     * Sets Directory of term definitions as a two-level table. The outer hash
     * keys are term codes, e.g. "at4", and the inner hash key are term attribute
     * names, e.g. "text", "description" etc.
     *
     * @param terminologyExtract
     */
    public void setTerminologyExtract(Map<String, ArchetypeTerminology> terminologyExtract) {
        this.terminologyExtract = terminologyExtract;
    }

    /**
     * Returns the component terminology for the given id key.
     *
     * @param id The identifier of the component
     * @return The terminology associated with this component
     */
    public ArchetypeTerminology componentTerminology(String id) {
        return this.terminologyExtract.get(id);
    }
}
