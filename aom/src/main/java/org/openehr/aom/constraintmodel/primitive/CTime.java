package org.openehr.aom.constraintmodel.primitive;

import org.openehr.aom.constraintmodel.ArchetypeConstraint;
import org.openehr.basetypes.time.Time;
import org.openehr.basetypes.structures.Interval;
import org.openehr.basetypes.definitions.ValidityKind;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by cnanjo on 5/20/16.
 */
public class CTime extends CTemporal<Time> {

    /**
     * True if 'a_pattern' is a valid constraint.
     * Define in concrete descendants.
     *
     * @param pattern
     * @return
     */
    @Override
    public Boolean validPatternConstraint(String pattern) {
        return null;
    }

    /**
     * Return True if 'a_pattern' can be replaced by 'an_other_pattern' in a specialised constraint.
     * Define in concrete subtypes.
     *
     * @param pattern
     * @param otherPattern
     * @return
     */
    @Override
    public Boolean validPatternConstraintReplacement(String pattern, String otherPattern) {
        return null;
    }

    /**
     * Generate name of native type that is constrained by this C_XXX type. For most types, it is the C_XXX
     * typename without the 'C_', i.e. XXX. E.g. C_INTEGER → Integer. For the date/time types the mapping
     * is different.
     *
     * @return
     */
    @Override
    public String constrainedTypeName() {
        return null;
    }

    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     *
     * @param value
     * @return
     */
    @Override
    public Boolean validValue(Interval<Time> value) {
        return null;
    }

    /**
     * Generate a prototype value from this constraint object.
     *
     * @return
     */
    @Override
    public Interval<Time> prototypeValue() {
        return null;
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts,
     * are narrower or the same as other. Typically used during validation of
     * specialized archetype nodes.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean cConformsTo(ArchetypeConstraint other) {
        return null;
    }

    /**
     * True if constraints represented by this node contain no further
     * redefinitions with respect to the node other, with the exception
     * of node_id redefnition in C_OBJECT nodes. Typically used to test
     * if an inherited node locally contains any constraints.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean cCongruentTo(ArchetypeConstraint other) {
        return null;
    }

    /**
     * Returns true if node is a leaf node (has no children).
     *
     * @return
     */
    @Override
    public Boolean isLeaf() {
        return true;
    }

    /**
     * Validity of minute in constrained time.
     *
     * @return
     */
    public ValidityKind minuteValidity() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Validity of second in constrained time.
     *
     * @return
     */
    public ValidityKind secondValidity() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Validity of millisecond in constrained time.
     *
     * @return
     */
    public ValidityKind millisecondValidity() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Validity of timezone in constrained date.
     *
     * @return
     */
    public ValidityKind timezoneValidity() {
        throw new NotImplementedException();//TODO Need to implement
    }
}
