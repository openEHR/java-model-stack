package org.openehr.expressions.core;

import java.util.List;

/**
 * Node representing a function with 0 or more arguments.
 *
 * Created by cnanjo on 5/20/16.
 */
public class ExpressionFunction extends ExpressionLeaf {

    /**
     * Arguments of this function, which can be from 0 to any number. Functions with no arguments
     * are typically used to represent real world varying values like 'current time' and so on.
     */
    private List<ExpressionItem> arguments;
    /**
     * The function definition.
     */
    private FunctionDefinition functionDefinition;

    /**
     *
     * @return Arguments of this function, which can be from 0 to any number. Functions with no arguments
     * are typically used to represent real world varying values like 'current time' and so on.
     */
    public List<ExpressionItem> getArguments() {
        return arguments;
    }

    /**
     *
     * @param arguments Arguments of this function, which can be from 0 to any number. Functions with no arguments
     * are typically used to represent real world varying values like 'current time' and so on.
     */
    public void setArguments(List<ExpressionItem> arguments) {
        this.arguments = arguments;
    }

    /**
     *
     * @return The function definition.
     */
    public FunctionDefinition getFunctionDefinition() {
        return functionDefinition;
    }

    /**
     *
     * @param functionDefinition The function definition.
     */
    public void setFunctionDefinition(FunctionDefinition functionDefinition) {
        this.functionDefinition = functionDefinition;
    }
}
