package org.openehr.aom.constraintmodel;

import org.apache.commons.lang.NotImplementedException;

/**
 * A constraint defined by proxy, using a reference to an object constraint defined elsewhere in the same archetype.
 * Note that since this object refers to another node, there are two objects with available occurrences values. The
 * local occurrences value on a COMPLEX_OBJECT_PROXY should always be used; when setting this from a serialised form,
 * if no occurrences is mentioned, the target occurrences should be used (not the standard default of {1..1});
 * otherwise the locally specified occurrences should be used as normal. When serialising out, if the occurrences
 * is the same as that of the target, it can be left out.
 *
 * Created by cnanjo on 5/19/16.
 */
public class CComplexObjectProxy extends CObject {

    /**
     * Reference to an object node using archetype path notation.
     */
    private String targetPath;

    /**
     * Returns reference to an object node using archetype path notation.
     * @return
     */
    public String getTargetPath() {
        return targetPath;
    }

    /**
     * Sets reference to an object node using archetype path notation.
     *
     * @param targetPath
     */
    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }
 
    /**
     * True if target occurrences are to be used as the value of occurrences in this object;
     * by the time of runtime use, the target occurrences value has to be set into this object.
     *
     * @return
     */
    public Boolean useTargetOccurrences() {
        return getOccurrences() == null;
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
        return null;
    }

    /**
     * True if this node occurrences conforms  to other.occurrences; `other' is
     * assumed to be in a flat archetype.
     * If `other' is a C_COMPLEX_OBJECT,  then always True, since if occurrences
     * defined on proxy node, it is an override of the occurrences on the target,
     * and it doesn’t have to conform to anything except the containing attribute’s
     * cardinality. However, if `other'  is also a C_COMPLEX_OBJECT then the
     * override is of another use_node, and normal occurrences apply
    */
    public Boolean occurrencesConformsTo(CObject other) {
		throw new NotImplementedException();//TODO Need to implement
    }

}
