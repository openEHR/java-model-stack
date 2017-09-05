package org.openehr.expressions.core;

/**
 * Ancestor type for types that define a function for use in the Rules evaluator.
 *
 * Created by cnanjo on 5/20/16.
 */
public abstract class FunctionDefinition {

    /**
     * Unique identifier of this function within the Rules system.
     */
    private String identifier;

    /**
     *
     * @return Unique identifier of this function within the Rules system.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @param identifier Unique identifier of this function within the Rules system.
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
