package org.openehr.expressions.core;

import org.openehr.expressions.types.ExpressionTypeDefinition;

/**
 * Abstract parent of all typed expression tree items.
 *
 * Created by cnanjo on 5/20/16.
 */
public abstract class ExpressionItem extends ExpressionValue {

    /**
     * The primitive type of this node, which must be determined by redefinitions in concrete classes.
     */
    private ExpressionTypeDefinition type;

    /**
     *
     * @return The primitive type of this node, which must be determined by redefinitions in concrete classes.
     */
    public ExpressionTypeDefinition getType() {
        return type;
    }

    /**
     *
     * @param type The primitive type of this node, which must be determined by redefinitions in concrete classes.
     */
    public void setType(ExpressionTypeDefinition type) {
        this.type = type;
    }
}
