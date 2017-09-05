package org.openehr.aom.rules;

import org.openehr.aom.constraintmodel.ArchetypeConstraint;
import org.openehr.expressions.extension.ExpressionValueReference;

/**
 * Expression tree leaf item representing a reference to a value found in data at a location specified by a
 * path in the archetype definition.
 *
 * A path referring to a value in the archetype (paths with a leading ‘/’ are in the definition section.
 * Paths with no leading ‘/’ are in the outer part of the archetype, e.g. “archetype_id/value” refers
 * to the String value of the archetype_id attribute of the enclosing archetype.
 *
 * Created by cnanjo on 5/20/16.
 */
public class ExpressionArchetypeReference extends ExpressionValueReference {

    /**
     * The path to the archetype node.
     */
    private String path;
    /**
     * The archetype constraint
     */
    private ArchetypeConstraint item;

    /**
     * Return the path to the archetype node.
     *
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path to the archetype node.
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Returns the constraint item.
     *
     * @return
     */
    public ArchetypeConstraint getItem() {
        return item;
    }

    /**
     * Sets the constraint item.
     *
     * @param item
     */
    public void setItem(ArchetypeConstraint item) {
        this.item = item;
    }
}
