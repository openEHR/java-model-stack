package org.openehr.basetypes.structures;

/*
 * #%L
 * OpenEHR - Java Model Stack
 * %%
 * Copyright (C) 2016 - 2017 Cognitive Medical Systems
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 * Author: Claude Nanjo
 */

import java.util.Objects;

/**
 * Interval abstraction, featuring upper and lower limits that may be open or closed, included or not included. Interval of ordered items.
 *
 * Created by cnanjo on 5/20/16.
 */
public class Interval<T extends Comparable> {

    /**
     * lower bound.
     */
    private T lower;
    /**
     * Upper bound.
     */
    private T upper;
    /**
     * lower boundary open (i.e. = -infinity)
     */
    private Boolean lowerUnbounded;
    /**
     * upper boundary open (i.e. = +infinity)
     */
    private Boolean upperUnbounded;
    /**
     * lower boundary value included in range if not lower_unbounded.
     */
    private Boolean lowerIncluded;
    /**
     * upper boundary value included in range if not upper_unbounded.
     */
    private Boolean upperIncluded;

    /**
     * Returns the lower bound of the interval.
     *
     * @return
     */
    public T getLower() {
        return lower;
    }

    /**
     * Sets the lower bound of the interval.
     *
     * @param lower
     */
    public void setLower(T lower) {
        this.lower = lower;
    }

    /**
     * Returns the upper bound of the interval.
     *
     * @return
     */
    public T getUpper() {
        return upper;
    }

    /**
     * Sets the upper bound of the interval.
     *
     * @param upper
     */
    public void setUpper(T upper) {
        this.upper = upper;
    }

    /**
     * Returns true if the lower boundary is open (i.e. = -infinity)
     *
     * @return
     */
    public Boolean getLowerUnbounded() {
        return lowerUnbounded;
    }

    /**
     * Sets this interval's lower bound to -infinity
     *
     * @param lowerUnbounded
     */
    public void setLowerUnbounded(Boolean lowerUnbounded) {
        this.lowerUnbounded = lowerUnbounded;
    }

    /**
     * Returns true if the upper boundary is open (i.e., = +infinity)
     *
     * @return
     */
    public Boolean getUpperUnbounded() {
        return upperUnbounded;
    }

    /**
     * Sets this interval's upper bound to +infinity
     *
     * @param upperUnbounded
     */
    public void setUpperUnbounded(Boolean upperUnbounded) {
        this.upperUnbounded = upperUnbounded;
    }

    /**
     * Lower boundary value included in range if not lower_unbounded.
     *
     * @return
     */
    public Boolean getLowerIncluded() {
        return lowerIncluded;
    }

    /**
     * Lower boundary value included in range if not lower_unbounded.
     *
     * @return
     */
    public void setLowerIncluded(Boolean lowerIncluded) {
        this.lowerIncluded = lowerIncluded;
    }

    /**
     * Upper boundary value included in range if not lower_unbounded.
     *
     * @return
     */
    public Boolean getUpperIncluded() {
        return upperIncluded;
    }

    /**
     * Upper boundary value included in range if not lower_unbounded.
     *
     * @return
     */
    public void setUpperIncluded(Boolean upperIncluded) {
        this.upperIncluded = upperIncluded;
    }

    /**
     * True if (lower_unbounded or lower_included and v >= lower) or v > lower
     * and (upper_unbounded or upper_included and v <= upper or v < upper)
     *
     * @param value
     * @return
     */
    public Boolean has(T value) {
        return (lowerUnbounded || (lowerIncluded && value.compareTo(lower) >= 0)) && (upperUnbounded || (upperIncluded && value.compareTo(upper) <= 0));
    }

    /**
     * True if there is any overlap between intervals represented by Current and
     * `other'. True if at least one limit of other is strictly inside the limits
     * of this interval.
     *
     * @param other
     * @return
     */
    public Boolean intersects(Interval<T> other) {
        return (lowerUnbounded && other.lowerUnbounded) ||
                (upperUnbounded && other.upperUnbounded) ||
                (lower.compareTo(other.lower) < 0 && upper.compareTo(other.upper) < 0 && other.lower.compareTo(upper) < 0) ||
                (other.lower.compareTo(lower) < 0 && other.upper.compareTo(upper) < 0 && lower.compareTo(other.upper) < 0) ||
                other.contains(this) || this.contains(other);
    }

    /**
     * True if current interval properly contains `other'? True if all points of
     * `other' are inside the current interval.
     *
     * @param other
     * @return
     */
    public Boolean contains(Interval<T> other) {
        return has(other.lower) && has(other.upper);
    }

    /**
     * Returns true if both sets subsume each other.
     *
     * @param other
     * @return
     */
    public Boolean setsAreEqual(Interval<T> other) {
        return this.contains(other) && other.contains(this);
    }

    /**
     * Method returns true if the state of both intervals is the same.
     * It is a stricter equality than the set equality operation above.
     *
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Interval<?> interval = (Interval<?>) other;
        return Objects.equals(lower, interval.lower) &&
                Objects.equals(upper, interval.upper) &&
                Objects.equals(lowerUnbounded, interval.lowerUnbounded) &&
                Objects.equals(upperUnbounded, interval.upperUnbounded) &&
                Objects.equals(lowerIncluded, interval.lowerIncluded) &&
                Objects.equals(upperIncluded, interval.upperIncluded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lower, upper, lowerUnbounded, upperUnbounded, lowerIncluded, upperIncluded);
    }
}
