package org.openehr.aom.constraintmodel;

import java.util.List;

/**
 * Parent of types representing constraints on primitive types.
 *
 * Created by cnanjo on 5/19/16.
 */
public abstract class CPrimitiveObject<T> extends CDefinedObject<T> {

    /**
     * Value to be assumed if none sent in data.
     */
    private T assumedValue;
    /**
     * True if this object represents a constraint on an enumerated type from the reference model,
     * where the latter is assumed to be based on a primitive type, generally Integer or String.
     */
    private Boolean isEnumeratedTypeConstraint;
    /**
     * Constraints represented by this object; redefine in descendants.
     */
    private List<T> constraints;

    /**
     * Returns value to be assumed if none sent in data.
     *
     * @return
     */
    public T getAssumedValue() {
        return assumedValue;
    }

    /**
     * Sets value to be assumed if none sent in data.
     *
     * @param assumedValue
     */
    public void setAssumedValue(T assumedValue) {
        this.assumedValue = assumedValue;
    }

    /**
     * Returns True if this object represents a constraint on an enumerated type from the reference model,
     * where the latter is assumed to be based on a primitive type, generally Integer or String.
     *
     * @return
     */
    public Boolean getIsEnumeratedTypeConstraint() {
        return isEnumeratedTypeConstraint;
    }

    /**
     * Set to True if this object represents a constraint on an enumerated type from the reference model,
     * where the latter is assumed to be based on a primitive type, generally Integer or String.
     *
     * @param enumeratedTypeConstraint
     */
    public void setEnumeratedTypeConstraint(Boolean enumeratedTypeConstraint) {
        isEnumeratedTypeConstraint = enumeratedTypeConstraint;
    }

    /**
     * Returns constraints represented by this object
     *
     * @return
     */
    public List<T> getConstraints() {
        return constraints;
    }

    /**
     * Sets constraint represented by this object
     *
     * @param constraints
     */
    public void setConstraints(List<T> constraints) {
        this.constraints = constraints;
    }

    /**
     * True if there is an assumed value.
     *
     * @return
     */
    public Boolean hasAssumedValue() {
        return assumedValue != null;
    }

    /**
     * Generate name of native type that is constrained by this C_XXX type. For most types, it is the C_XXX
     * typename without the 'C_', i.e. XXX. E.g. C_INTEGER → Integer. For the date/time types the mapping
     * is different.
     *
     * @return
     */
    public abstract String constrainedTypeName();
}
