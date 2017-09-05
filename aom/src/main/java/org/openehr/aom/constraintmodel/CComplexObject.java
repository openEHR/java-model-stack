package org.openehr.aom.constraintmodel;

import org.apache.commons.lang.NotImplementedException;

import java.util.List;

/**
 * Constraint on complex objects, i.e. any object that consists of other object constraints.
 *
 * Created by cnanjo on 5/19/16.
 */
public class CComplexObject extends CDefinedObject {

    /**
     * List of constraints on attributes of the reference model type represented by this object.
     */
    private List<CAttribute> attributes;
    /**
     * List of attribute tuple constraints under this object constraint, if any.
     */
    private List<CAttributeTuple> attributeTuples;

    /**
     * Returns list of constraints on attributes of the reference model type represented by this object.
     * @return
     */
    public List<CAttribute> getAttributes() {
        return attributes;
    }

    /**
     * Sets list of constraints on attributes of the reference model type represented by this object.
     * @param attributes
     */
    public void setAttributes(List<CAttribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * Returns list of attribute tuple constraints under this object constraint, if any.
     * @return
     */
    public List<CAttributeTuple> getAttributeTuples() {
        return attributeTuples;
    }

    /**
     * Sets list of attribute tuple constraints under this object constraint, if any.
     * @param attributeTuples
     */
    public void setAttributeTuples(List<CAttributeTuple> attributeTuples) {
        this.attributeTuples = attributeTuples;
    }

    /**
     * True if any value (i.e. instance) of the reference model type would be allowed. Redefined in descendants.
     *
     * @return
     */
    public Boolean anyAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     *
     * @param value
     * @return
     */
    @Override
    public Boolean validValue(Object value) {
        return null;
    }

    /**
     * Generate a prototype value from this constraint object.
     *
     * @return
     */
    @Override
    public Object generatePrototypeValue() {
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
}
