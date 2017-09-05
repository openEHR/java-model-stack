package org.openehr.expressions.core;

/**
 * Binary operator expression node.
 *
 * Created by cnanjo on 5/20/16.
 */
public class ExpressionBinaryOperator extends ExpressionOperator {

    /**
     * Left operand node.
     */
    private ExpressionItem leftOperand;
    /**
     * Right operand node.
     */
    private ExpressionItem rightOperand;

    /**
     *
     * @return Left operand node.
     */
    public ExpressionItem getLeftOperand() {
        return leftOperand;
    }

    /**
     *
     * @param leftOperand Left operand node.
     */
    public void setLeftOperand(ExpressionItem leftOperand) {
        this.leftOperand = leftOperand;
    }

    /**
     *
     * @return Right operand node.
     */
    public ExpressionItem getRightOperand() {
        return rightOperand;
    }

    /**
     *
     * @param rightOperand Right operand node.
     */
    public void setRightOperand(ExpressionItem rightOperand) {
        this.rightOperand = rightOperand;
    }
}
