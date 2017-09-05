package org.openehr.expressions.core;

/**
 * Unary operator expression node.
 *
 * Created by cnanjo on 5/20/16.
 */
public class ExpressionUnaryOperator extends ExpressionOperator {

    /**
     * Operand node.
     */
    private ExpressionItem operand;

    /**
     *
     * @return Operand node.
     */
    public ExpressionItem getOperand() {
        return operand;
    }

    /**
     *
     * @param operand Operand node.
     */
    public void setOperand(ExpressionItem operand) {
        this.operand = operand;
    }
}
