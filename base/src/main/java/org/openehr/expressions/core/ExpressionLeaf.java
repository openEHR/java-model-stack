package org.openehr.expressions.core;

/**
 * Expression tree leaf item representing one of:
 *
 * <ul>
 * <li>a manifest constant of any primitive type;</li>
 * <li>a path referring to a value in the archetype;</li>
 * <li>a constraint;</li>
 * <li>a variable reference.</li>
 * </ul>
 *
 * Created by cnanjo on 5/20/16.
 */
public abstract class ExpressionLeaf<T> extends ExpressionItem {

    /**
     * The reference item from which the value of this node can be computed.
     */
    private T item;

    /**
     *
     * @return The reference item from which the value of this node can be computed.
     */
    public T getItem() {
        return item;
    }

    /**
     *
     * @param item The reference item from which the value of this node can be computed.
     */
    public void setItem(T item) {
        this.item = item;
    }
}
