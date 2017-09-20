package org.openehr.aom.constraintmodel;

import java.util.List;

/**
 * Abstract parent of classes defining second order constraints.
 *
 * Created by cnanjo on 5/19/16.
 */
public abstract class CSecondOrder<T extends ArchetypeConstraint> {

    /**
     * Members of this second order constrainer. Normally redefined in descendants.
     */
    private List<T> members;

    /**
     * Returns the members of this second order constrainer. Normally redefined in descendants.
     *
     * @return
     */
    public List<T> getMembers() {
        return members;
    }

    /**
     * Sets the members of this second order constrainer. Normally redefined in descendants.
     * @param members
     */
    public void setMembers(List<T> members) {
        this.members = members;
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of specialised archetype nodes.
     *
     * @param other
     * @return
     */
    public abstract Boolean cConformsTo(CSecondOrder other);

    /**
     * True if constraints represented by this node contain no further redefinitions with respect to the node
     * other. Typically used to test if an inherited node locally contains any constraints.
     *
     * @param other
     * @return
     */
    public abstract Boolean cCongruentTo(CSecondOrder other);
}
