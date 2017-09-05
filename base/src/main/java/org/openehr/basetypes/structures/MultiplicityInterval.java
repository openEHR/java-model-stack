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

import org.apache.commons.lang.NotImplementedException;

import java.io.Serializable;

/**
 * Created by cnanjo on 5/20/16.
 */
public class MultiplicityInterval extends Interval<Integer> implements Serializable {

    /**
     * Marker to use in string form of interval between limits.
     */
    public static final String MULTIPLICITY_RANGE_MARKER = "..";
    /**
     * Symbol to use to indicate upper limit unbounded.
     */
    public static final Character MULTIPLICITY_UNBOUNDED_MARKER = '*';

    public MultiplicityInterval(Integer lower, Boolean lowerIncluded, Boolean lowerUnbounded, Integer upper, Boolean upperIncluded, Boolean upperUnbounded) {
        setLower(lower);
        setLowerIncluded(lowerIncluded);
        setLowerUnbounded(lowerUnbounded);
        setUpper(upper);
        setUpperIncluded(upperIncluded);
        setUpperUnbounded(upperUnbounded);
    }

    /**
     * True if this interval imposes no constraints, i.e. is set to 0..*
     *
     * @return
     */
    public Boolean isOpen() {
        if(getLower() == null) {
            System.out.println("HERE");
        }
        return (getLower() >= 0) && getUpperUnbounded();
    }

    /**
     * Creates interval of type [0,inf)
     *
     * @return
     */
    public static MultiplicityInterval createOpen() {
        return new MultiplicityInterval(0, true, false, null, false, true);
    }

    /**
     * True if this interval expresses optionality, i.e. 0..1.
     *
     * @return
     */
    public Boolean isOptional() {
        return getLower() == 0 && getUpper() == 1;
    }

    /**
     * Creates interval of type [0,1]
     *
     * @return
     */
    public static MultiplicityInterval createOptional() {
        return new MultiplicityInterval(0, true, false, 1, true, false);
    }

    /**
     * True if this interval expresses mandation, i.e. 1..1.
     *
     * @return
     */
    public Boolean isMandatory() {
        return getLower() == 1 && getUpper() == 1;
    }

    /**
     * Creates interval of type [1,1]
     *
     * @return
     */
    public static MultiplicityInterval createMandatory() {
        return new MultiplicityInterval(1, true, false, 1, true, false);
    }

    /**
     * True if this interval is set to 0..0.
     *
     * @return
     */
    public Boolean isProhibited() {
        return getLower() == 0 && getUpper() == 0;
    }

    /**
     * Creates interval of type [0,1]
     *
     * @return
     */
    public static MultiplicityInterval createProhibited() {
        return new MultiplicityInterval(0, true, false, 0, true, false);
    }

    public String toString() {
        if(isOpen()) {
            return getLower() + MULTIPLICITY_RANGE_MARKER + MULTIPLICITY_UNBOUNDED_MARKER;
        } else {
            return getLower() + MULTIPLICITY_RANGE_MARKER + getUpper();
        }
    }

    public static MultiplicityInterval parseString(String aMultiplicityInterval) {
        //Use regex to parse expression
        throw new NotImplementedException();//TODO Need to implement
    }
}
