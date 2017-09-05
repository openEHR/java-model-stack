package org.openehr.expressions.core;

import java.util.List;
import java.util.Map;

/**
 * Builtin function pseudo-type. An implementation will typically use the 'identifer' attribute
 * to determine which piece of internal code to execute to evaluate the function.
 *
 * Created by cnanjo on 5/20/16.
 */
public class FunctionDefinitionBuiltin extends FunctionDefinition implements BuiltinFunction {
    private Map<String, List<String>> functionTable; //TODO Check this

    /**
     * List of built-in functions in the form of a keyed table of List<String>, where the latter represents one or more lexical symbols used for the function, e.g. "max", and the key is the function identifier, e.g. "max".
     * <p>
     * Implementations may choose to populate this table with all functions defined in the core specifications,
     * or only partially, in which case functions not in the table are implemented using the closure/agent
     * approach for externally defined functions.
     *
     * @return
     */
    @Override
    public Map<String, List<String>> getFunctionTable() {
        return null;
    }
}
