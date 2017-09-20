package org.openehr.aom.constraintmodel;

/**
 * Defines the order indicator that can be used on a C_OBJECT within a container attribute in a specialised archetype to indicate its order with respect to a sibling defined in a higher specialisation level.
 *
 * Misuse: This type cannot be used on a C_OBJECT other than one within a container attribute in a specialised archetype.
 *
 * Created by cnanjo on 5/19/16.
 */
public class SiblingOrder {

    /**
     * True if the order relationship is ‘before’, False, if it is ‘after’.
     */
    private Boolean isBefore;
    /**
     * Node identifier of sibling before or after which this node should come.
     */
    private String siblingNodeId;

    /**
     * True if the order relationship is ‘before’, False, if it is ‘after’.
     *
     * @return
     */
    public Boolean getIsBefore() {
        return isBefore;
    }

    /**
     * True if the order relationship is ‘before’, False, if it is ‘after’.
     *
     * @param before
     */
    public void setIsBefore(Boolean before) {
        isBefore = before;
    }

    /**
     * Returns node identifier of sibling before or after which this node should come.
     *
     * @return
     */
    public String getSiblingNodeId() {
        return siblingNodeId;
    }

    /**
     * Sets node identifier of sibling before or after which this node should come.
     *
     * @param siblingNodeId
     */
    public void setSiblingNodeId(String siblingNodeId) {
        this.siblingNodeId = siblingNodeId;
    }

    /**
     * True if the order relationship is ‘after’, computed as the negation of is_before.
     *
     * @return
     */
    public Boolean isAfter() {
        return !isBefore;
    }
}
