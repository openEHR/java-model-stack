package org.openehr.basetypes.structures;

import org.apache.commons.lang.NotImplementedException;
import org.openehr.basetypes.structures.MultiplicityInterval;

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

/**
 * Class expresses constraints on the cardinality of container objects which are the values of
 * multiply-valued attributes, including uniqueness and ordering, providing the means
 * to state that a container acts like a logical list, set or bag. The cardinality cannot
 * contradict the cardinality of the corresponding attribute within the relevant reference
 * model.
 *
 *
 * Created by cnanjo on 5/24/16.
 */
public class Cardinality {

    /**
     * The interval of this cardinality.
     */
    private MultiplicityInterval interval;
    /**
     * True if the members of the container attribute to which this cardinality refers are ordered.
     */
    private Boolean isOrdered;
    /**
     * True if the members of the container attribute to which this cardinality refers are unique.
     */
    private Boolean isUnique;

    /**
     * Returns the interval of this cardinality.
     * @return
     */
    public MultiplicityInterval getInterval() {
        return interval;
    }

    /**
     * Sets the interval of this cardinality.
     * @param interval
     */
    public void setInterval(MultiplicityInterval interval) {
        this.interval = interval;
    }

    /**
     * Returns true if the members of the container attribute to which this cardinality refers are ordered.
     *
     * @return
     */
    public Boolean getIsOrdered() {
        return isOrdered;
    }

    /**
     * Sets true if the members of the container attribute to which this cardinality refers are ordered.
     *
     * @param ordered
     */
    public void setIsOrdered(Boolean ordered) {
        isOrdered = ordered;
    }

    /**
     * Returns True if the members of the container attribute to which this cardinality refers are unique.
     *
     * @return
     */
    public Boolean getIsUnique() {
        return isUnique;
    }

    /**
     * Sets True if the members of the container attribute to which this cardinality refers are unique.
     *
     * @param unique
     */
    public void setIsUnique(Boolean unique) {
        isUnique = unique;
    }

    /**
     * True if the semantics of this cardinality represent a bag, i.e. unordered, non-unique membership.
     *
     * @return
     */
    public Boolean isBag() {
        return !isOrdered && !isUnique;
    }

    /**
     * True if the semantics of this cardinality represent a list, i.e. ordered, non-unique membership.
     *
     * @return
     */
    public Boolean isList() {
        return isOrdered && !isUnique;
    }

    /**
     * True if the semantics of this cardinality represent a set, i.e. unordered, unique membership.
     *
     * @return
     */
    public Boolean isSet() {
        return !isOrdered && isUnique;
    }

    /**
     * Checks whether the cardinality interval of 'other' is subsumed by the interval for this cardinality
     *
     * @param other
     * @return
     */
    public Boolean contains(Cardinality other) {
        return getInterval().contains(other.getInterval());
    }
}
