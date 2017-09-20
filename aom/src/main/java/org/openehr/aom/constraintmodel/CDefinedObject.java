package org.openehr.aom.constraintmodel;

import org.apache.commons.lang.NotImplementedException;
import org.openehr.basetypes.Any;

/**
 * Abstract parent type of C_OBJECT subtypes that are defined by value, i.e. whose definitions
 * are actually in the archetype rather than being by reference.
 *
 *
 * Created by cnanjo on 5/19/16.
 */
public abstract class CDefinedObject<T> extends CObject {

    /**
     * Default value set in a template, and present in an operational template.
     * Generally limited to leaf and near-leaf nodes.
     */
    private T defaultValue;

    /**
     * Returns the default value
     *
     * @return
     */
    public T getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the default value
     *
     * @param defaultValue
     */
    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     *
     * @param value
     * @return
     */
    public abstract Boolean validValue(T value);

    /**
     * Generate a prototype value from this constraint object.
     *
     * @return
     */
    public abstract T prototypeValue();

    /**
     * True if there is an assumed value.
     *
     * @return
     */
    public Boolean hasDefaultValue() {
        return defaultValue != null;
    }
}
