package org.openehr.aom.archetype;

import org.openehr.basetypes.terminology.TerminologyCode;
import org.apache.commons.lang.NotImplementedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Root object of a standalone, authored archetype, including all meta-data, description,
 * other identifiers and lifecycle.
 *
 * Created by cnanjo on 5/19/16.
 */
public class AuthoredArchetype extends BaseArchetype implements AuthoredResource {

    /**
     * Language in which this resource was initially authored. Although there is no
     * language primacy of resources overall, the language of original authoring is
     * required to ensure natural language translations can preserve quality. Language
     * is relevant in both the description and ontology sections.
     */
    private TerminologyCode originalLanguage;
    /**
     * True if this resource is under any kind of change control (even file copying),
     * in which case revision history is created.
     */
    private Boolean isControlled;
    /**
     * Unique identifier of the family of archetypes having the same interface identifier (same major version).
     */
    private UUID uuid;
    /**
     * Description and lifecycle information of the resource.
     */
    private ResourceDescription description;
    /**
     * List of details for each natural translation made of this resource,
     * keyed by language. For each translation listed here, there must be
     * corresponding sections in all language-dependent parts of the resource.
     * The original_language does not appear in this list.
     */
    private Map<String, TranslationDetails> translations;
    /**
     * Annotations on individual items within the resource, keyed by path.
     * The inner table takes the form of a Hash table of String values keyed
     * by String tags.
     */
    private ResourceAnnotations annotations;
    /**
     * ADL version if archetype was read in from an ADL sharable archetype.
     */
    private String adlVersion;
    /**
     * Unique identifier of this archetype artefact instance. A new identifier
     * is assigned every time the content is changed by a tool. Used by tools
     * to distinguish different revisions and/or interim snapshots of the same
     * artefact.
     */
    private UUID buildUid;
    /**
     * Semver.org compatible release of the most recent reference model release
     * on which the archetype in its current version is based. This does not
     * imply conformance only to this release, since an archetype may be valid
     * with respect to multiple releases of a reference model.
     */
    private String rmRelease;
    /**
     * If True, indicates that this artefact was machine-generated from some other source,
     * in which case, tools would expect to overwrite this artefact on a new generation.
     * Editing tools should set this value to False when a user starts to manually edit an archetype.
     */
    private Boolean isGenerated;
    /**
     * Additional metadata in the form of key=value pairs associated with this artifact.
     */
    private Map<String, String> otherMetadata;

    public AuthoredArchetype() {
        super();
        this.translations = new HashMap<>();
        this.otherMetadata = new HashMap<>();
    }

    /**
     * Returns the language in which this resource was initially authored.
     * Although there is no language primacy of resources overall,
     * the language of original authoring is required to ensure natural
     * language translations can preserve quality. Language is relevant
     * in both the description and ontology sections.
     *
     * @return The language in which this resource was initially authored.
     */
    @Override
    public TerminologyCode getOriginalLanguage() {
        return this.originalLanguage;
    }

    /**
     * Sets the language in which this resource was initially authored.
     * Although there is no language primacy of resources overall,
     * the language of original authoring is required to ensure natural
     * language translations can preserve quality. Language is relevant
     * in both the description and ontology sections.
     *
     * @param originalLanguage The language in which this resource was initially authored.
     */
    @Override
    public void setOriginalLanguage(TerminologyCode originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     * True if this resource is under any kind of change control (even file copying),
     * in which case revision history is created.
     *
     * @return True if this resource is under any kind of change control
     */
    @Override
    public Boolean getControlled() {
        return this.isControlled;
    }

    /**
     * Set to True if this resource is under any kind of change control (even file copying),
     * in which case revision history is created.
     *
     * @param controlled True if this resource is under any kind of change control
     */
    @Override
    public void setControlled(Boolean controlled) {
        this.isControlled = controlled;
    }

    /**
     * Returns the unique identifier of the family of archetypes having the same interface identifier (same major version).
     *
     * @return The unique identifier of the family of archetypes having the same interface identifier
     */
    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Sets the unique identifier of the family of archetypes having the same interface identifier (same major version).
     *
     * @param uuid The unique identifier of the family of archetypes having the same interface identifier
     */
    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Returns the description and lifecycle information of the resource.
     *
     * @return Description and lifecycle information of the resource.
     */
    @Override
    public ResourceDescription getDescription() {
        return this.description;
    }

    /**
     * Sets the description and lifecycle information of the resource.
     *
     * @param description Description and lifecycle information of the resource.
     */
    @Override
    public void setDescription(ResourceDescription description) {
        this.description = description;
    }

    /**
     * Returns the list of details for each natural translation made of this resource,
     * keyed by language. For each translation listed here, there must be corresponding
     * sections in all language-dependent parts of the resource.
     * The original_language does not appear in this list.
     *
     * @return The list of details for each natural translation made of this resource,
     * keyed by language
     */
    @Override
    public Map<String, TranslationDetails> getTranslations() {
        return this.translations;
    }

    /**
     * Sets the list of details for each natural translation made of this resource,
     * keyed by language. For each translation listed here, there must be corresponding
     * sections in all language-dependent parts of the resource.
     * The original_language does not appear in this list.
     *
     * @param translations
     */
    @Override
    public void setTranslations(Map<String, TranslationDetails> translations) {
        this.translations = translations;
    }

    /**
     * Adds a translation to this artefact.
     *
     * @param lang        The language of the translation
     * @param translation The translation
     */
    @Override
    public void addTranslation(String lang, TranslationDetails translation) {
        this.translations.put(lang, translation);
    }

    /**
     * Returns the annotations on individual items within the resource, keyed by path.
     * The inner table takes the form of a Hash table of String values keyed by String tags.
     *
     * @return Returns the annotations on individual items within the resource, keyed by path
     */
    @Override
    public ResourceAnnotations getAnnotations() {
        return this.annotations;
    }

    /**
     * Returns the annotations on individual items within the resource, keyed by path.
     * The inner table takes the form of a Hash table of String values keyed by String tags.
     *
     * @param annotations Returns the annotations on individual items within the resource, keyed by path
     */
    @Override
    public void setAnnotations(ResourceAnnotations annotations) {
        this.annotations = annotations;
    }

    /**
     * Returns the most recent revision in revision_history if is_controlled else (uncontrolled) .
     *
     * @return Most recent revision in revision_history if is_controlled else (uncontrolled) .
     */
    @Override
    public String getCurrentRevision() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Sets the most recent revision in revision_history if is_controlled else (uncontrolled) .
     *
     * @param revision Most recent revision in revision_history if is_controlled else (uncontrolled) .
     */
    @Override
    public void setCurrentRevision(String revision) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Total list of languages available in this resource, derived from original_language and translations.
     *
     * @return
     */
    @Override
    public List<String> getAvailableLanguages() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns the ADL version if archetype was read in from an ADL sharable archetype.
     * @return
     */
    public String getAdlVersion() {
        return adlVersion;
    }

    /**
     * Sets the ADL version if archetype was read in from an ADL sharable archetype.
     * @param adlVersion
     */
    public void setAdlVersion(String adlVersion) {
        this.adlVersion = adlVersion;
    }

    /**
     * Returns the unique identifier of this archetype artefact instance. A new identifier is assigned
     * every time the content is changed by a tool. Used by tools to distinguish different
     * revisions and/or interim snapshots of the same artefact.
     *
     * @return The Unique identifier of this archetype artefact instance
     */
    public UUID getBuildUid() {
        return buildUid;
    }

    /**
     * Sets the unique identifier of this archetype artefact instance. A new identifier is assigned
     * every time the content is changed by a tool. Used by tools to distinguish different
     * revisions and/or interim snapshots of the same artefact.
     *
     * @param buildUid The Unique identifier of this archetype artefact instance
     */
    public void setBuildUid(UUID buildUid) {
        this.buildUid = buildUid;
    }

    /**
     * Returns the Semver.org compatible release of the most recent reference model release
     * on which the archetype in its current version is based. This does not imply conformance
     * only to this release, since an archetype may be valid with respect to multiple releases
     * of a reference model.
     *
     * @return The Semver.org compatible release of the most recent reference model release
     * on which the archetype in its current version is based
     */
    public String getRmRelease() {
        return rmRelease;
    }

    /**
     * Sets the Semver.org compatible release of the most recent reference model release
     * on which the archetype in its current version is based. This does not imply conformance
     * only to this release, since an archetype may be valid with respect to multiple releases
     * of a reference model.
     *
     * @param rmRelease The Semver.org compatible release of the most recent reference model release
     * on which the archetype in its current version is based
     */
    public void setRmRelease(String rmRelease) {
        this.rmRelease = rmRelease;
    }

    /**
     * If True, indicates that this artefact was machine-generated from some other source,
     * in which case, tools would expect to overwrite this artefact on a new generation.
     * Editing tools should set this value to False when a user starts to manually edit an
     * archetype.
     *
     * @return
     */
    public Boolean getGenerated() {
        return isGenerated;
    }

    /**
     * If True, indicates that this artefact was machine-generated from some other source,
     * in which case, tools would expect to overwrite this artefact on a new generation.
     * Editing tools should set this value to False when a user starts to manually edit an
     * archetype.
     *
     * @param generated
     */
    public void setGenerated(Boolean generated) {
        isGenerated = generated;
    }

    /**
     * Returns the set of metadata name value pairs associated with this artifacts.
     *
     * @return The set of metadata name value pairs associated with this artifacts
     */
    public Map<String, String> getOtherMetadata() {
        return otherMetadata;
    }

    /**
     * Sets the set of metadata name value pairs associated with this artifacts.
     *
     * @param otherMetadata The set of metadata name value pairs associated with this artifacts
     */
    public void setOtherMetadata(Map<String, String> otherMetadata) {
        this.otherMetadata = otherMetadata;
    }
}
