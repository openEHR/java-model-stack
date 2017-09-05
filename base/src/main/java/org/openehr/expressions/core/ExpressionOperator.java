package org.openehr.expressions.core;

/**
 * Abstract parent of operator types.
 *
 * Created by cnanjo on 5/20/16.
 */
public abstract class ExpressionOperator extends ExpressionItem {

    /**
     * True if the natural precedence of operators is overridden in the expression
     * represented by this node of the expression tree. If True, parentheses should
     * be introduced around the totality of the syntax expression corresponding to
     * this operator node and its operands.
     */
    private Boolean precedenceOverridden;
    /**
     * Operator definition.
     */
    private OperatorDefinition operatorDefinition;
    /**
     * The symbol actually used in the rule, or intended to be used for serialisation.
     * Must be a member of operator_def.symbols.
     */
    private String symbol;

    /**
     *
     * @return True if the natural precedence of operators is overridden in the expression
     * represented by this node of the expression tree. If True, parentheses should
     * be introduced around the totality of the syntax expression corresponding to
     * this operator node and its operands.
     */
    public Boolean getPrecedenceOverridden() {
        return precedenceOverridden;
    }

    /**
     *
     * @param precedenceOverridden True if the natural precedence of operators is overridden in the expression
     * represented by this node of the expression tree. If True, parentheses should
     * be introduced around the totality of the syntax expression corresponding to
     * this operator node and its operands.
     */
    public void setPrecedenceOverridden(Boolean precedenceOverridden) {
        this.precedenceOverridden = precedenceOverridden;
    }

    /**
     *
     * @return Operator definition.
     */
    public OperatorDefinition getOperatorDefinition() {
        return operatorDefinition;
    }

    /**
     *
     * @param operatorDefinition Operator definition.
     */
    public void setOperatorDefinition(OperatorDefinition operatorDefinition) {
        this.operatorDefinition = operatorDefinition;
    }

    /**
     *
     * @return The symbol actually used in the rule, or intended to be used for serialisation.
     * Must be a member of operator_def.symbols.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @param symbol The symbol actually used in the rule, or intended to be used for serialisation.
     * Must be a member of operator_def.symbols.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
