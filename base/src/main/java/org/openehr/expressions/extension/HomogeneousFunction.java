package org.openehr.expressions.extension;

import org.openehr.basetypes.functional.IFunction;

/**
 * Created by cnanjo on 5/31/16.
 */
public interface HomogeneousFunction<T> extends IFunction {

    public T evaluate(T... arguments);
}
