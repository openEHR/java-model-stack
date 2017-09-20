package org.openehr.aom.constraintmodel;

/**
 * Class representing a single object tuple instance in a tuple constraint.
 * Each such instance is a vector of object constraints, where each member
 * (each C_PRIMITIVE_OBJECT) corresponds to one of the C_ATTRIBUTEs referred
 * to by the owning C_ATTRIBUTE_TUPLE.
 *
 * Created by cnanjo on 5/19/16.
 */
public class CPrimitiveTuple extends CSecondOrder<CPrimitiveObject> {

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of specialised archetype nodes.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean cConformsTo(CSecondOrder other) {
        return null;
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
        return null;
    }
}
