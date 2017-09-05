package org.openehr.aom.terminology;

import java.util.Map;

/**
 * Representation of any coded entity (term or constraint) in the archetype ontology.
 *
 * Created by cnanjo on 5/19/16.
 */
public class ArchetypeTerm {
    /**
     * Code of this term.
     */
    private String code;
    /**
     * Short term text, typically for display.
     */
    private String text;
    /**
     * Full description text.
     */
    private String description;
    /**
     * Hash of keys and corresponding values for other items in a term, e.g. provenance.
     * Hash of keys ("text", "description" etc) and corresponding values.
     */
    private Map<String, String> otherItems;

    /**
     * Returns the code for this term.
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code for this term.
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns short term text, typically for display.
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Sets short term text, typically for display.
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns full description text.
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets full description text.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns map of keys and corresponding values for other items in a term, e.g. provenance.
     * Hash of keys ("text", "description" etc) and corresponding values.
     *
     * @return
     */
    public Map<String, String> getOtherItems() {
        return otherItems;
    }

    /**
     * Sets map of keys and corresponding values for other items in a term, e.g. provenance.
     * Hash of keys ("text", "description" etc) and corresponding values.
     *
     * @param otherItems
     */
    public void setOtherItems(Map<String, String> otherItems) {
        this.otherItems = otherItems;
    }
}
