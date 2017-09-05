package org.openehr.aom.constraintmodel.primitive;

/**
 * Purpose Abstract parent of C_ORDERED types whose base type is an ISO date/time type.
 *
 * Created by cnanjo on 5/20/16.
 */
public abstract class CTemporal<T extends Comparable> extends COrdered<T> {

    /**
     * Optional alternative constraint in the form of a pattern based on ISO8601. See descendants for details.
     */
    private String patternConstraint;

    /**
     * Returns optional alternative constraint in the form of a pattern based on ISO8601. See descendants for details.
     *
     * @return
     */
    public String getPatternConstraint() {
        return patternConstraint;
    }

    /**
     * Sets optional alternative constraint in the form of a pattern based on ISO8601. See descendants for details.
     *
     * @param patternConstraint
     */
    public void setPatternConstraint(String patternConstraint) {
        this.patternConstraint = patternConstraint;
    }

    /**
     * True if 'a_pattern' is a valid constraint.
     * Define in concrete descendants.
     *
     * @param pattern
     * @return
     */
    public abstract Boolean validPatternConstraint(String pattern);

    /**
     * Return True if 'a_pattern' can be replaced by 'an_other_pattern' in a specialised constraint.
     * Define in concrete subtypes.
     *
     * @param pattern
     * @param otherPattern
     * @return
     */
    public abstract Boolean validPatternConstraintReplacement(String pattern, String otherPattern);
}
