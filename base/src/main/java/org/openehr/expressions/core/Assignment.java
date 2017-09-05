package org.openehr.expressions.core;

/**
 * Abstract ancestor of types representing the assignment statement, which does not produce a value in the way
 * that operators such as '=', 'and' etc do. An assignment associates a named variable with an expression.
 *
 * Created by cnanjo on 5/20/16.
 */
public abstract class Assignment extends Statement {

    /**
     * The target variable on the notional left-hand side of this assignment.
     */
    private ExpressionValue source;
    /**
     * Source right hand side) of the assignment.
     */
    private VariableDeclaration target;

    /**
     *
     * @return The target variable on the notional left-hand side of this assignment.
     */
    public ExpressionValue getSource() {
        return source;
    }

    /**
     *
     * @param source The target variable on the notional left-hand side of this assignment.
     */
    public void setSource(ExpressionValue source) {
        this.source = source;
    }

    /**
     *
     * @return Source right hand side) of the assignment.
     */
    public VariableDeclaration getTarget() {
        return target;
    }

    /**
     *
     * @param target Source right hand side) of the assignment.
     */
    public void setTarget(VariableDeclaration target) {
        this.target = target;
    }
}
