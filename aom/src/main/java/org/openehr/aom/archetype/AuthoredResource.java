package org.openehr.aom.archetype;

import org.openehr.basetypes.terminology.TerminologyCode;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Abstract idea of an online resource created by a human author.
 *
 * Created by cnanjo on 5/19/16.
 */
public interface AuthoredResource {

    /**
     * Returns the language in which this resource was initially authored.
     * Although there is no language primacy of resources overall,
     * the language of original authoring is required to ensure natural
     * language translations can preserve quality. Language is relevant
     * in both the description and ontology sections.
     *
     * @return The language in which this resource was initially authored.
     */
    public TerminologyCode getOriginalLanguage();

    /**
     * Sets the language in which this resource was initially authored.
     * Although there is no language primacy of resources overall,
     * the language of original authoring is required to ensure natural
     * language translations can preserve quality. Language is relevant
     * in both the description and ontology sections.
     *
     * @param originalLanguage The language in which this resource was initially authored.
     */
    public void setOriginalLanguage(TerminologyCode originalLanguage);

    /**
     * True if this resource is under any kind of change control (even file copying),
     * in which case revision history is created.
     *
     * @return True if this resource is under any kind of change control
     */
    public Boolean getControlled();

    /**
     * Set to True if this resource is under any kind of change control (even file copying),
     * in which case revision history is created.
     *
     * @param controlled True if this resource is under any kind of change control
     */
    public void setControlled(Boolean controlled);

    /**
     * Returns the unique identifier of the family of archetypes having the same interface identifier (same major version).
     *
     * @return The unique identifier of the family of archetypes having the same interface identifier
     */
    public UUID getUuid();

    /**
     * Sets the unique identifier of the family of archetypes having the same interface identifier (same major version).
     *
     * @param uuid The unique identifier of the family of archetypes having the same interface identifier
     */
    public void setUuid(UUID uuid);

    /**
     * Returns the description and lifecycle information of the resource.
     *
     * @return Description and lifecycle information of the resource.
     */
    public ResourceDescription getDescription();

    /**
     * Sets the description and lifecycle information of the resource.
     *
     * @param description Description and lifecycle information of the resource.
     */
    public void setDescription(ResourceDescription description);

    /**
     * Returns the list of details for each natural translation made of this resource,
     * keyed by language. For each translation listed here, there must be corresponding
     * sections in all language-dependent parts of the resource.
     * The original_language does not appear in this list.
     *
     * @return The list of details for each natural translation made of this resource,
     * keyed by language
     */
    public Map<String, TranslationDetails> getTranslations();

    /**
     * Sets the list of details for each natural translation made of this resource,
     * keyed by language. For each translation listed here, there must be corresponding
     * sections in all language-dependent parts of the resource.
     * The original_language does not appear in this list.
     *
     * @param translationsThe list of details for each natural translation made of this resource,
     * keyed by language
     */
    public void setTranslations(Map<String, TranslationDetails> translations);

    /**
     * Adds a translation to this artefact.
     *
     * @param lang The language of the translation
     * @param translation The translation
     */
    public void addTranslation(String lang, TranslationDetails translation);

    /**
     * Returns the annotations on individual items within the resource, keyed by path.
     * The inner table takes the form of a Hash table of String values keyed by String tags.
     *
     * @return Returns the annotations on individual items within the resource, keyed by path
     */
    public ResourceAnnotations getAnnotations();

    /**
     * Returns the annotations on individual items within the resource, keyed by path.
     * The inner table takes the form of a Hash table of String values keyed by String tags.
     *
     * @param annotations Returns the annotations on individual items within the resource, keyed by path
     */
    public void setAnnotations(ResourceAnnotations annotations);

    /**
     * Returns the most recent revision in revision_history if is_controlled else (uncontrolled) .
     *
     * @return Most recent revision in revision_history if is_controlled else (uncontrolled) .
     */
    public String getCurrentRevision();

    /**
     * Sets the most recent revision in revision_history if is_controlled else (uncontrolled) .
     * @param revision Most recent revision in revision_history if is_controlled else (uncontrolled) .
     */
    public void setCurrentRevision(String revision);

    /**
     * Total list of languages available in this resource, derived from original_language and translations.
     *
     * @return
     */
    public List<String> getAvailableLanguages();
}
