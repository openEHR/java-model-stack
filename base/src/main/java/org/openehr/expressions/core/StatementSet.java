package org.openehr.expressions.core;

import java.util.List;

/**
 * A container for a specific set of statements intended to be used together.
 *
 * Created by cnanjo on 5/20/16.
 */
public class StatementSet {

    /**
     * Optional name of this rule set.
     */
    private String name;
    /**
     * The member statements of this statement set.
     */
    private List<Statement> statements;

    /**
     *
     * @return Optional name of this rule set.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Optional name of this rule set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The member statements of this statement set.
     */
    public List<Statement> getStatements() {
        return statements;
    }

    /**
     *
     * @param statements The member statements of this statement set.
     */
    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    /**
     * Execution result of the whole rule set. Determined by the and-ing of result
     * values of Assertions in the rule set.
     *
     * @return
     */
    public Boolean executionResult() {
        throw new UnsupportedOperationException();//TODO Implement
    }
}
