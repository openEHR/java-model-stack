package org.openehr.aom.rules;

import org.openehr.aom.constraintmodel.CPrimitiveObject;
import org.openehr.expressions.core.ExpressionLiteral;

/**
 * Expression tree leaf item representing a constraint on a primitive type, expressed
 * in the form of a concrete subtype of C_PRIMITIVE_OBJECT.
 *
 * Created by cnanjo on 5/20/16.
 */
public class ExpressionConstraint extends ExpressionLiteral {

    /**
     * The constraint
     */
    private CPrimitiveObject item;

    /**
     * Returns the constraint
     *
     * @return
     */
    public CPrimitiveObject getItem() {
        return item;
    }

    /**
     * Sets the constraint
     *
     * @param item
     */
    public void setItem(CPrimitiveObject item) {
        this.item = item;
    }
}
