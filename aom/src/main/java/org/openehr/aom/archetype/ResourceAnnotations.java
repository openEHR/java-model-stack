package org.openehr.aom.archetype;

import java.util.HashMap;
import java.util.Map;

/**
 * Object representing annotations on an archetype. These can be of various forms,
 * with a documentation form defined so far, which has a multi-level tabular structure
 * [ language key, [path key, [String key, String value]]]. Example instance, showing
 * the documentation structure.
 *
 *  documentation = <
 *      ["en"] = <
 *          ["/data[id2]"] = <
 *              ["ui"] = <"passthrough">
 *          >
 *          ["/data[id2]/items[id3]"] = <
 *              ["design note"] = <"this is a design note on Statement">
 *              ["requirements note"] = <"this is a requirements note on Statement">
 *              ["medline ref"] = <"this is a medline ref on Statement">
 *          >
 *      >
 *  >
 *
 * Created by cnanjo on 5/19/16.
 */
public class ResourceAnnotations {

    private Map<String, Map<String, Map<String,String>>> documentation;

    public ResourceAnnotations() {
        this.documentation = new HashMap<String, Map<String, Map<String, String>>>();
    }

    /**
     *
     * @return Documentary annotations in a multi-level keyed structure.
     */
    public Map<String, Map<String, Map<String, String>>> getDocumentation() {
        return documentation;
    }

    /**
     *
     * @param documentation Documentary annotations in a multi-level keyed structure.
     */
    public void setDocumentation(Map<String, Map<String, Map<String, String>>> documentation) {
        this.documentation = documentation;
    }

    /**
     * Adds a language specific documentation node such as:
     *
     * ["en"] = <
     *     ["/data[id2]"] = <
     *        ["ui"] = <"passthrough">
     *      >
     *      ["/data[id2]/items[id3]"] = <
     *         ["design note"] = <"this is a design note on Statement">
     *         ["requirements note"] = <"this is a requirements note on Statement">
     *         ["medline ref"] = <"this is a medline ref on Statement">
     *      >
     *  >
     *
     * @param languageCode The language code key for this documentation item
     * @param documentationItem The documentation item
     */
    public void addLanguageSpecificDocumentationItem(String languageCode, Map<String, Map<String, String>> documentationItem) {
        documentation.put(languageCode, documentationItem);
    }

    /**
     * Sets key-value properties for a given path:
     *
     * ["/data[id2]/items[id3]"] = <
     *      ["design note"] = <"this is a design note on Statement">
     *      ["requirements note"] = <"this is a requirements note on Statement">
     *      ["medline ref"] = <"this is a medline ref on Statement">
     * >
     *
     * Note that this set of properties will replace any existing properties so use with caution.
     *
     * @param languageCode The language code key for this documentation item (used to retrieve the path entries)
     * @param path The path key
     * @param properties The set of properties to set for this path
     */
    public void setPropertiesForPath(String languageCode, String path, Map<String,String> properties) {
        Map<String, Map<String,String>> languageDocumentation = documentation.get(languageCode);
        if(languageDocumentation == null) {
            languageDocumentation = new HashMap<String, Map<String,String>>();
            documentation.put(languageCode, languageDocumentation);
        }
        languageDocumentation.put(path, properties);
    }

    /**
     * Adds key-value properties for a given path:
     *
     * ["/data[id2]/items[id3]"] = <
     *      ["design note"] = <"this is a design note on Statement">
     *      ["requirements note"] = <"this is a requirements note on Statement">
     *      ["medline ref"] = <"this is a medline ref on Statement">
     * >
     *
     * Note that this set of properties will add properties to an existing set
     *
     * @param languageCode The language code key for this documentation item (used to retrieve the path entries)
     * @param path The path key
     * @param properties The set of properties to set for this path
     */
    public void addPropertiesForPath(String languageCode, String path, Map<String,String> properties) {
        Map<String, Map<String,String>> languageDocumentation = documentation.get(languageCode);
        if(languageDocumentation == null) {
            languageDocumentation = new HashMap<String, Map<String,String>>();
            documentation.put(languageCode, languageDocumentation);
            languageDocumentation.put(path, new HashMap<String,String>());
        }
        Map<String, String> currentProperties = languageDocumentation.get(path);
        currentProperties.putAll(properties);
    }

}
