package org.openehr.aom.constraintmodel;

import org.openehr.expressions.core.Assertion;

import java.util.List;

/**
 * Constraint describing a slot' where another archetype can occur.
 *
 * Created by cnanjo on 5/19/16.
 */
public class ArchetypeSlot extends CObject {

    /**
     * List of constraints defining other archetypes that could be included at this point.
     */
    private List<Assertion> includes;
    /**
     * List of constraints defining other archetypes that cannot be included at this point.
     */
    private List<Assertion> excludes;
    /**
     * True if this slot specification in this artefact is closed to further filling either
     * in further specialisations or at runtime. Default value False, i.e. unless explicitly
     * set, a slot remains open.
     */
    private Boolean isClosed;

    /**
     * Returns list of constraints defining other archetypes that could be included at this point.
     *
     * @return
     */
    public List<Assertion> getIncludes() {
        return includes;
    }

    /**
     * Sets list of constraints defining other archetypes that could be included at this point.
     *
     * @param includes
     */
    public void setIncludes(List<Assertion> includes) {
        this.includes = includes;
    }

    /**
     * Returns list of constraints defining other archetypes that cannot be included at this point.
     *
     * @return
     */
    public List<Assertion> getExcludes() {
        return excludes;
    }

    /**
     * Sets list of constraints defining other archetypes that cannot be included at this point.
     *
     * @param excludes
     */
    public void setExcludes(List<Assertion> excludes) {
        this.excludes = excludes;
    }

    /**
     * True if this slot specification in this artefact is closed to further filling either
     * in further specialisations or at runtime. Default value False, i.e. unless explicitly
     * set, a slot remains open.
     *
     * @return
     */
    public Boolean getIsClosed() {
        return isClosed;
    }

    /**
     * True if this slot specification in this artefact is closed to further filling either
     * in further specialisations or at runtime. Default value False, i.e. unless explicitly
     * set, a slot remains open.
     *
     * @param closed
     */
    public void setIsClosed(Boolean closed) {
        isClosed = closed;
    }

    /**
     *
     * @return
     */
    public Boolean anyAllowed() {
        return !isClosed && (includes == null || includes.size() == 0) && (excludes == null && excludes.size() == 0);
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
}
