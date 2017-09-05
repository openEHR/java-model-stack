package org.openehr.expressions.core;

/**
 * Any kind of statement element that can be evaluated. The type will either be supplied
 * in descendant types or else will be inferred by an assignment statement linked to a
 * typed variable.
 *
 * Created by cnanjo on 5/20/16.
 */
public abstract class ExpressionValue<T> {

    /**
     * The computed value of this node as a result of the nodes below it,
     * for operator nodes, or else statically set or otherwise derived values.
     */
    private T value;

    /**
     *
     * @return The computed value of this node as a result of the nodes below it,
     * for operator nodes, or else statically set or otherwise derived values.
     */
    public T getValue() {
        return value;
    }

    /**
     *
     * @param value The computed value of this node as a result of the nodes below it,
     *              for operator nodes, or else statically set or otherwise derived values.
     */
    public void setValue(T value) {
        this.value = value;
    }
}
