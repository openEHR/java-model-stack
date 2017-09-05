package org.openehr.expressions.extension;

import org.openehr.expressions.core.ExpressionLeaf;

/**
 * Abstract parent type of concrete types enabling access to values in a specific information structure.
 * This type provides an extension point for specific syntaxes to connect a generic rule structure to a
 * data source.
 *
 * Created by cnanjo on 5/20/16.
 */
public abstract class ExpressionValueReference extends ExpressionLeaf {
}
