package org.openehr.aom.archetype;

import org.openehr.basetypes.terminology.TerminologyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Language-specific detail of resource description. When a resource is translated for use in another language
 * environment, each RESOURCE_DESCRIPTION_ITEM needs to be copied and translated into the new language.
 *
 * Created by cnanjo on 5/18/16.
 */
public class ResourceDescriptionItem {
    /**
     * The localised language in which the items in this description item are written. Coded using ISO 639-1 (2 character) language codes.
     */
    private TerminologyCode language;
    /**
     * Purpose of the resource.
     */
    private String purpose;
    /**
     * Keywords which characterise this resource, used e.g. for indexing and searching.
     */
    private List<String> keywords;
    /**
     * Description of the uses of the resource, i.e. contexts in which it could be used.
     */
    private String use;
    /**
     * Description of any misuses of the resource, i.e. contexts in which it should not be used.
     */
    private String misuse;
    /**
     * URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.
     */
    private Map<String, String> originalResourceUri;
    /**
     * Additional language-sensitive resource metadata, as a list of name/value pairs.
     */
    private Map<String, String> otherDetails;

    public ResourceDescriptionItem() {
        this.keywords = new ArrayList<>();
        this.originalResourceUri = new HashMap<String, String>();
        this.otherDetails = new HashMap<String, String>();
    }

    /**
     * Returns the language associated with the resource.
     *
     * @return
     */
    public TerminologyCode getLanguage() {
        return language;
    }

    /**
     * Sets the language associated with this resource.
     *
     * @param language
     */
    public void setLanguage(TerminologyCode language) {
        this.language = language;
    }

    /**
     * Returns the purpose of the resource.
     *
     * @return
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * Sets the purpose of the resource.
     *
     * @param purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * Returns the keywords associated with this resource.
     *
     * @return
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * Sets the keywords associated with this resource.
     *
     * @param keywords
     */
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns the usage information for this resource.
     *
     * @return
     */
    public String getUse() {
        return use;
    }

    /**
     * Sets the usage information for this resource.
     *
     * @param use
     */
    public void setUse(String use) {
        this.use = use;
    }

    /**
     * Returns information on misuse of this resource.
     *
     * @return
     */
    public String getMisuse() {
        return misuse;
    }

    /**
     * Sets information about misuse of this resource.
     *
     * @param misuse
     */
    public void setMisuse(String misuse) {
        this.misuse = misuse;
    }

    /**
     * Returns the original resource URIs.
     *
     * @return
     */
    public Map<String, String> getOriginalResourceUri() {
        return originalResourceUri;
    }

    /**
     * Sets the original resource URIs.
     *
     * @param originalResourceUri
     */
    public void setOriginalResourceUri(Map<String, String> originalResourceUri) {
        this.originalResourceUri = originalResourceUri;
    }

    /**
     * Adds an original resource URI
     *
     * @param key
     * @param value
     */
    public void addOriginalResourceUri(String key, String value) {
        this.originalResourceUri.put(key, value);
    }


    /**
     * Returns other details associated with this resources.
     *
     * @return
     */
    public Map<String, String> getOtherDetails() {
        return otherDetails;
    }

    /**
     * Sets other details associated with this resource.
     *
     * @param otherDetails
     */
    public void setOtherDetails(Map<String, String> otherDetails) {
        this.otherDetails = otherDetails;
    }

    /**
     * Adds a key=value attribute to this resource
     *
     * @param key
     * @param value
     */
    public void addOtherDetails(String key, String value) {
        this.otherDetails.put(key, value);
    }
}
