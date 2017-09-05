package org.openehr.aom.constraintmodel.primitive;


import org.apache.commons.lang.NotImplementedException;
import org.joda.time.Duration;
import org.openehr.aom.constraintmodel.ArchetypeConstraint;
import org.openehr.basetypes.structures.Interval;

import java.util.List;

/**
 * Created by cnanjo on 5/20/16.
 */
public class CDuration extends CTemporal<Duration> {

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
    public Boolean validValue(Interval<Duration> value) {
        return null;
    }

    /**
     * Generate a prototype value from this constraint object.
     *
     * @return
     */
    @Override
    public Interval<Duration> generatePrototypeValue() {
        return null;
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts,
     * are narrower or the same as other. Typically used during validation of
     * special-ised archetype nodes.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean constraintConformsTo(ArchetypeConstraint other) {
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
    public Boolean constraintCongruentTo(ArchetypeConstraint other) {
        return null;
    }

    /**
     * Returns true if node is a leaf node (has no children).
     *
     * @return
     */
    @Override
    public Boolean isLeaf() {
        return null;
    }

    /**
     * True if years are allowed in the constrained Duration.
     *
     * @return
     */
    public Boolean yearsAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if months are allowed in the constrained Duration.
     *
     * @return
     */
    public Boolean monthsAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if weeks are allowed in the constrained Duration.
     *
     * @return
     */
    public Boolean weeksAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if days are allowed in the constrained Duration.
     *
     * @return
     */
    public Boolean daysAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if hours are allowed in the constrained Duration.
     *
     * @return
     */
    public Boolean hoursAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if minutes are allowed in the constrained Duration.
     *
     * @return
     */
    public Boolean minutesAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if seconds are allowed in the constrained Duration.
     *
     * @return
     */
    public Boolean secondsAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if fractional seconds are allowed in the constrained Duration.
     *
     * @return
     */
    public Boolean fractionalSecondsAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }
}
