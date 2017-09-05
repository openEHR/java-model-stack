package org.openehr.aom.constraintmodel.primitive;

import org.openehr.aom.constraintmodel.ArchetypeConstraint;
import org.openehr.aom.constraintmodel.CPrimitiveObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Constraint on instances of STRING.
 *
 * Created by cnanjo on 5/20/16.
 */
public class CString extends CPrimitiveObject<String> {

    /**
     * Generate name of native type that is constrained by this C_XXX type. For most types, it is the C_XXX
     * typename without the 'C_', i.e. XXX. E.g. C_INTEGER → Integer. For the date/time types the mapping
     * is different.
     *
     * @return
     */
    @Override
    public String constrainedTypeName() {
        return "String";
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
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     *
     * @param value
     * @return
     */
    @Override
    public Boolean validValue(String value) {
        boolean isValid = false;
        if(getConstraints() == null || getConstraints().size() == 0) {
            isValid = true;
        } else {
            for(String constraint : getConstraints()) {
                if(value.equalsIgnoreCase(constraint)) {
                    isValid = true;
                    break;
                }
            }
        }
        return isValid;
    }

    /**
     * Generate a prototype value from this constraint object.
     *
     * @return
     */
    @Override
    public String generatePrototypeValue() {
        return "Prototype value";
    }
}
