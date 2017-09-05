package org.openehr.expressions.extension;

/**
 * Illustrative class showing what the normally built-in logical 'exists' operator looks like as an external definition.
 *
 * Created by cnanjo on 5/20/16.
 */
public class OperationDefinitionExists extends OperatorDefinitionExternal<AndFunction> {//TODO Implement

    public OperationDefinitionExists() {
        addSymbol("exists");
        addSymbol("\u2203");
    }

}
