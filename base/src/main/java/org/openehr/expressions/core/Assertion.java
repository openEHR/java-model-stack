package org.openehr.expressions.core;

/**
 * Structural model of a typed first order predicate logic assertion, in the form of an expression tree,
 * including optional variable definitions.
 *
 * Created by cnanjo on 5/20/16.
 */
public class Assertion extends Statement {

    /**
     * Expression tag, used for differentiating multiple assertions. Offers a way to name
     * expressions.
     */
    private String tag;
    /**
     * String form of expression, in case an expression evaluator taking String expressions
     * is used for evaluation.
     */
    private String stringExpression;
    /**
     * Root of expression tree.
     */
    private ExpressionItem expression;
    /**
     * Execution result of this assertion.
     */
    private Boolean executionResult;

    /**
     *
     * @return Expression tag, used for differentiating multiple assertions. Offers a way to name
     * expressions.
     */
    public String getTag() {
        return tag;
    }

    /**
     *
     * @param tag Expression tag, used for differentiating multiple assertions. Offers a way to name
     * expressions.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     *
     * @return String form of expression, in case an expression evaluator taking String expressions
     * is used for evaluation.
     */
    public String getStringExpression() {
        return stringExpression;
    }

    /**
     *
     * @param stringExpression String form of expression, in case an expression evaluator taking String expressions
     * is used for evaluation.
     */
    public void setStringExpression(String stringExpression) {
        this.stringExpression = stringExpression;
    }

    /**
     *
     * @return Root of expression tree.
     */
    public ExpressionItem getExpression() {
        return expression;
    }

    /**
     *
     * @param expression Root of expression tree.
     */
    public void setExpression(ExpressionItem expression) {
        this.expression = expression;
    }

    /**
     *
     * @return Execution result of this assertion.
     */
    public Boolean getExecutionResult() {
        return executionResult;
    }
}
