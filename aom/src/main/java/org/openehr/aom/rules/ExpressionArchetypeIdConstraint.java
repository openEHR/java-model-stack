package org.openehr.aom.rules;

import org.openehr.aom.constraintmodel.primitive.CString;

/**
 * Expression tree leaf item representing a constraint on an archetype identifier.
 *
 * Created by cnanjo on 5/20/16.
 */
public class ExpressionArchetypeIdConstraint extends ExpressionConstraint {

    /**
     * A C_STRING representing a regular expression for matching Archetype identifiers.
     */
    private CString item;

    /**
     * Returns a C_STRING representing a regular expression for matching Archetype identifiers.
     * @return
     */
    @Override
    public CString getItem() {
        return item;
    }

    /**
     * Sets C_STRING representing a regular expression for matching Archetype identifiers.
     *
     * @param item
     */
    public void setItem(CString item) {
        this.item = item;
    }
}
