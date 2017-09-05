package org.openehr.expressions.extension;

import org.openehr.basetypes.functional.Function;
import org.openehr.basetypes.functional.IFunction;
import org.openehr.expressions.core.OperatorDefinition;

/**
 * Ancestor of concrete operator definition types. Adds an optional execution agent,
 * typically implemented by closures / lambdas/ agents in languages supporting functional
 * programming.
 *
 * Created by cnanjo on 5/20/16.
 */
public class OperatorDefinitionExternal<T extends IFunction> extends OperatorDefinition {

    /**
     * The function implementation
     */
    private T evaluationAgent;
}
