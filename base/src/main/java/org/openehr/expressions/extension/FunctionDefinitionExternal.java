package org.openehr.expressions.extension;

import org.openehr.basetypes.Any;
import org.openehr.basetypes.functional.Function;
import org.openehr.basetypes.functional.IFunction;
import org.openehr.basetypes.functional.Tuple;
import org.openehr.expressions.core.FunctionDefinition;

/**
 * Ancestor class of externally defined function types.
 *
 * Created by cnanjo on 5/20/16.
 */
public class FunctionDefinitionExternal<T extends IFunction> extends FunctionDefinition {//TODO Implement
    private T evaluationAgent;
}
