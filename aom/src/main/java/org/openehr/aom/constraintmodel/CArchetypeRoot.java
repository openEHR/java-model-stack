package org.openehr.aom.constraintmodel;

/**
 * A specialisation of C_COMPLEX_OBJECT whose node_id attribute is an archetype identifier
 * rather than the normal internal node code (i.e. id-code). Used in two situations. The
 * first is to represent an ‘external reference’ to an archetype from within another archetype
 * or template. This supports re-use. The second use is within a template, where it is used as
 * a slot-filler.
 *
 *  For a new external reference, the node_id is set in the normal way, i.e. with a new code at
 *  the specialisation level of the archetype. For a slot-filler or a redefined external reference,
 *  the node_id is set to a specialised version of the node_id of the node being specialised,
 *  allowing matching to occur during flattening.
 *
 *  In all uses within source archetypes and templates, the children attribute is Void.
 *
 *  In an operational template, the node_id is converted to the archetype_ref, and the structure
 *  contains the result of flattening any template overlay structure and the underlying flat archetype.
 *
 * Created by cnanjo on 5/19/16.
 */
public class CArchetypeRoot extends CComplexObject {

    /**
     * Reference to archetype is being used to fill a slot or redefine an external reference.
     * Typically an ‘interface’ archetype id, i.e. identifier with partial version information.
     */
    private String archetypeReference;

    /**
     * Returns the reference to an archetype.
     *
     * @return
     */
    public String getArchetypeReference() {
        return archetypeReference;
    }

    /**
     * Sets the reference to an archetype.
     *
     * @param archetypeReference
     */
    public void setArchetypeReference(String archetypeReference) {
        this.archetypeReference = archetypeReference;
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
