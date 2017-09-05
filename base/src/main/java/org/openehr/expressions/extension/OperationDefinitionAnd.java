package org.openehr.expressions.extension;

/**
 * Illustrative class showing what the normally built-in logical 'and' operator looks like as an external definition.
 *
 * Created by cnanjo on 5/20/16.
 */
public class OperationDefinitionAnd extends OperatorDefinitionExternal<AndFunction> {//TODO Implement


    public OperationDefinitionAnd() {
        addSymbol("and");
        addSymbol("\u2227");
    }

}
