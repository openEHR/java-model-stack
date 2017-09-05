package org.openehr.aom.constraintmodel.primitive;

import org.apache.commons.lang.NotImplementedException;
import org.openehr.aom.constraintmodel.ArchetypeConstraint;
import org.openehr.aom.constraintmodel.CPrimitiveObject;
import org.openehr.basetypes.terminology.TerminologyCode;

import java.net.URI;
import java.util.List;

/**
 * Constrainer type for instances of TERMINOLOGY_CODE. The constraint attribute can contain:
 *     a single at-code
 *     a single ac-code, representing a value-set that is defined in the archetype terminology
 *
 * If there is an assumed value for the ac-code case above, the assumed_value attribute contains a single at-code, which must come from the list of at-codes defined as the internal value set for the ac-code.
 *
 * Created by cnanjo on 5/20/16.
 */
public class CTerminologyCode extends CPrimitiveObject<TerminologyCode> {

    /**
     * Type of individual constraint - a single string that can either be a
     * local at-code, or a local ac-code signifying a locally defined value set.
     * If an ac-code, assumed_value may contain an at-code from the value set
     * of the ac-code.
     */
    private String constraint;

    /**
     * Generate name of native type that is constrained by this C_XXX type. For most types, it is the C_XXX
     * typename without the 'C_', i.e. XXX. E.g. C_INTEGER → Integer. For the date/time types the mapping
     * is different.
     *
     * @return
     */
    @Override
    public String constrainedTypeName() {
        return "TerminologyCode";
    }

    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     *
     * @param value
     * @return
     */
    @Override
    public Boolean validValue(TerminologyCode value) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Generate a prototype value from this constraint object.
     *
     * @return
     */
    @Override
    public TerminologyCode generatePrototypeValue() {
        return new TerminologyCode();
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
        throw new NotImplementedException();//TODO Need to implement
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
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns true if node is a leaf node (has no children).
     *
     * @return
     */
    @Override
    public Boolean isLeaf() {
        return true;
    }

    /**
     * Effective set of at-code values corresponding to an ac-code for a locally defined value set.
     * Not defined for ac-codes that have no local value set.
     *
     * @return
     */
    public List<String> valueSetExpanded() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * For locally defined value sets within individual code bindings: return the term URI(s) substituted
     * from bindings for local at-codes in value_set_expanded.
     * @return
     */
    public List<URI> valueSetSubstituted() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * For locally defined value sets within individual code bindings: final set of external codes
     * to which value set is resolved.
     *
     * @return
     */
    public List<TerminologyCode> valueSetResolved() {
        throw new NotImplementedException();//TODO Need to implement
    }
}
