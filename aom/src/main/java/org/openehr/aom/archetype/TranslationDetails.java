package org.openehr.aom.archetype;

import org.openehr.basetypes.terminology.TerminologyCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Class providing details of a natural language translation.
 *
 * Created by cnanjo on 5/19/16.
 */
public class TranslationDetails {

    /**
     * Language of the translation, coded using ISO 639-1 (2 character) language codes.
     */
    private TerminologyCode language;
    /**
     * Translator name and other demographic details.
     */
    private Map<String, String> authors;
    /**
     * Accreditation of translator, usually a national translator’s registration or association membership id.
     */
    private String accreditation;
    /**
     * Any other meta-data.
     */
    private Map<String, String> otherDetails;
    /**
     * Version of this resource last time it was translated into the language represented by this TRANSLATION_DETAILS object.
     */
    private String versionLastTranslated;

    public TranslationDetails() {
        this.authors = new HashMap<String,String>();
        this.otherDetails = new HashMap<String,String>();
    }

    /**
     * Returns the language for this translation details.
     *
     */
    public TerminologyCode getLanguage() {
        return language;
    }

    /**
     * Sets the translation details language.
     *
     * @param language
     */
    public void setLanguage(TerminologyCode language) {
        this.language = language;
    }

    /**
     * Returns the translator names and demographic details captured
     * as key-value pairs.
     *
     * @return
     */
    public Map<String, String> getAuthors() {
        return authors;
    }

    /**
     * Sets the translators for this translation details.
     *
     */
    public void setAuthors(Map<String, String> authors) {
        this.authors = authors;
    }

    /**
     * Returns the accreditation of translator, usually a national translator’s registration or association membership id.
     * @return
     */
    public String getAccreditation() {
        return accreditation;
    }

    /**
     * Sets the accreditation of translator, usually a national translator’s registration or association membership id.
     *
     * @param accreditation
     */
    public void setAccreditation(String accreditation) {
        this.accreditation = accreditation;
    }

    /**
     * Returns other metadata associated with this translation.
     *
     * @return
     */
    public Map<String, String> getOtherDetails() {
        return otherDetails;
    }

    /**
     * Sets other metadata associated with this translation.
     *
     * @param otherDetails
     */
    public void setOtherDetails(Map<String, String> otherDetails) {
        this.otherDetails = otherDetails;
    }

    /**
     * Adds key-value pair for this translation.
     *
     * @param key
     * @param value
     */
    public void addOtherDetails(String key, String value) {
        this.otherDetails.put(key, value);
    }

    /**
     * Returns the version of this resource the last time it was translated.
     *
     * @return
     */
    public String getVersionLastTranslated() {
        return versionLastTranslated;
    }

    /**
     * Sets the version of the resource the last time it was translated.
     *
     * @param versionLastTranslated
     */
    public void setVersionLastTranslated(String versionLastTranslated) {
        this.versionLastTranslated = versionLastTranslated;
    }
}
