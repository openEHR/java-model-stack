package org.openehr.aom.constraintmodel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Object representing a constraint on an atttribute tuple, i.e. a group of attributes
 * that are constrained together. Typically used for representing co-varying constraints
 * like {units, range} constraints.
 *
 * Created by cnanjo on 5/19/16.
 */
public class CAttributeTuple extends CSecondOrder<CAttribute> {

    /**
     * Tuple definitions.
     */
    private List<CPrimitiveTuple> tuples;

    /**
     * Returns tuple definitions.
     * @return
     */
    public List<CPrimitiveTuple> getTuples() {
        return tuples;
    }

    /**
     * Sets tuple definitions.
     *
     * @param tuples
     */
    public void setTuples(List<CPrimitiveTuple> tuples) {
        this.tuples = tuples;
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of specialised archetype nodes.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean cConformsTo(CSecondOrder other) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if constraints represented by this node contain no further redefinitions with respect to the node
     * other. Typically used to test if an inherited node locally contains any constraints.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean cCongruentTo(CSecondOrder other) {
        throw new NotImplementedException();//TODO Need to implement
    }
}
