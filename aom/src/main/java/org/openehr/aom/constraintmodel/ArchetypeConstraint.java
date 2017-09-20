package org.openehr.aom.constraintmodel;

import org.openehr.basetypes.Any;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Abstract parent of all constraint model types. Defines conformance and congruence function signatures.
 *
 * Created by cnanjo on 5/19/16.
 */
public abstract class ArchetypeConstraint<T extends ArchetypeConstraint> implements Any {

    /**
     * Parent node, except in the case of the top of a tree,
     * i.e. root C_COMPLEX_OBJECT of an archetype definition.
     */
    private ArchetypeConstraint parent;

    /**
     * Inverse relationship for ARCHETYPE_CONSTRAINT node owned
     * by C_SECOND_ORDER.members attribute.
     */
    private CSecondOrder socParent;

    /**
     * Returns the parent node
     *
     * @return
     */
    public ArchetypeConstraint getParent() {
        return parent;
    }

    /**
     * Sets the parent node
     *
     * @param parent
     */
    public void setParent(ArchetypeConstraint parent) {
        this.parent = parent;
    }

    /**
     * Returns the second order constraint
     *
     * @return
     */
    public CSecondOrder getSocParent() {
        return socParent;
    }

    /**
     * Sets the second order constraint
     *
     * @param value;
     */
    public void setSocParent(CSecondOrder value) {
        this.socParent = value;
    }

    /**
     * True if this node (and all its sub-nodes) is a valid archetype node for its type.
     * This function should be implemented by each subtype to perform semantic validation
     * of itself, and then call the is_valid function in any subparts, and generate the result
     * appropriately.
     *
     * @return
     */
    public Boolean isProhibited() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if the relative path a_path exists at this node.
     *
     * @param aPath
     * @return
     */
    public boolean hasPath(String aPath) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Path of this node relative to root of archetype.
     */
    public String path() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts,
     * are narrower or the same as other. Typically used during validation of
     * specialized archetype nodes.
     *
     * @param other
     * @return
     */
    public abstract Boolean cConformsTo(T other);

    /**
     * True if constraints represented by this node contain no further
     * redefinitions with respect to the node other, with the exception
     * of node_id redefinition in C_OBJECT nodes. Typically used to test
     * if an inherited node locally contains any constraints.
     *
     * @param other
     * @return
     */
    public abstract Boolean cCongruentTo(T other);

    /**
     * True if there is a second order constraint such as a tuple constraint on this node.
     *
     * @return
     */
    public Boolean isSecondOrderConstrained() {
        return socParent != null || (parent != null && parent.isSecondOrderConstrained());
    }

    /**
     * Returns true if node does not have a parent.
     *
     * @return
     */
    public Boolean isRoot() {
        return parent == null;
    }

    /**
     * Returns true if node is a leaf node (has no children).
     *
     * @return
     */
    public abstract Boolean isLeaf();
}
