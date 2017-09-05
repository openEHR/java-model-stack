package org.openehr.expressions.core;

import org.openehr.expressions.types.ExpressionTypeDefinition;

/**
 * Definition of a named variable that can be used in an expression.
 *
 * Created by cnanjo on 5/20/16.
 */
public class VariableDeclaration extends Statement {

    /**
     * Name of the variable.
     */
    private String name;
    /**
     * Primitive type of the variable, enabling its use to be type-checked in expressions.
     */
    private ExpressionTypeDefinition type;

    /**
     *
     * @return Name of the variable.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Name of the variable.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Primitive type of the variable, enabling its use to be type-checked in expressions.
     */
    public ExpressionTypeDefinition getType() {
        return type;
    }

    /**
     *
     * @param type Primitive type of the variable, enabling its use to be type-checked in expressions.
     */
    public void setType(ExpressionTypeDefinition type) {
        this.type = type;
    }
}
