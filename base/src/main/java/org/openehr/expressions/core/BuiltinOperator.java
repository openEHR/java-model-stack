package org.openehr.expressions.core;

import java.util.List;
import java.util.Map;

/**
 * Singleton accessor object for list of builtin operators.
 *
 * Created by cnanjo on 5/20/16.
 */
public interface BuiltinOperator {

    /**
     * List of built-in operators in the form of a keyed table of List<String>, where the latter represents
     * one or more lexical symbols used for the operator, e.g. "+", and the key is the operator identifier,
     * e.g. "plus".
     *
     * Implementations may choose to populate this table with all operators defined in the core specifications,
     * or only partially, in which case operators not in the table are implemented using the closure/agent approach
     * for externally defined operators.
     *
     * @return
     */
    public static Map<String, List<String>> getOpTable() {
        throw new UnsupportedOperationException(); //TODO Implement
    }
}
