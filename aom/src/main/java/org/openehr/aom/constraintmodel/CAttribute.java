package org.openehr.aom.constraintmodel;

import org.openehr.basetypes.structures.Cardinality;
import org.openehr.basetypes.structures.MultiplicityInterval;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract model of constraint on any kind of attribute in a class model.
 *
 * Created by cnanjo on 5/19/16.
 */
public class CAttribute extends ArchetypeConstraint<CAttribute> {

    /**
     * Reference model attribute within the enclosing type represented by a C_OBJECT.
     */
    private String rmAttributeName;
    /**
     * Constraint settable on every attribute, regardless of whether it is singular or
     * of a container type, which indicates whether its target object exists or not
     * (i.e. is mandatory or not). Only set if it overrides the underlying reference model
     * or parent archetype in the case of specialised archetypes.
     */
    private MultiplicityInterval existence;
    /**
     * Child C_OBJECT nodes. Each such node represents a constraint on the type of this
     * attribute in its reference model. Multiples occur both for multiple items in the
     * case of container attributes, and alternatives in the case of singular attributes.
     */
    private List<CObject> children;
    /**
     * Path to the parent object of this attribute (i.e. doesn’t include the name of this attribute).
     * Used only for attributes in differential form, specialised archetypes. Enables only the
     * re-defined parts of a specialised archetype to be expressed, at the path where they occur.
     */
    private String differentialPath;
    /**
     * Cardinality constraint of attribute, if a container attribute.
     */
    private Cardinality cardinality;
    /**
     * Flag indicating whether this attribute constraint is on a container (i.e. multiply-valued) attribute.
     */
    private Boolean isMultiple;

    /**
     * Default no-arg constructor
     *
     */
    public CAttribute() {
        this.children = new ArrayList<>();
    }

    /**
     * Returns the reference model attribute within the enclosing type represented by a C_OBJECT.
     * @return
     */
    public String getRmAttributeName() {
        return rmAttributeName;
    }

    /**
     * Sets the reference model attribute within the enclosing type represented by a C_OBJECT.
     * @param rmAttributeName
     */
    public void setRmAttributeName(String rmAttributeName) {
        this.rmAttributeName = rmAttributeName;
    }

    /**
     * Returns the existence value for this node.
     *
     * @return
     */
    public MultiplicityInterval getExistence() {
        return existence;
    }

    /**
     * Sets the existence attribute for this node.
     *
     * @param existence
     */
    public void setExistence(MultiplicityInterval existence) {
        this.existence = existence;
    }

    /**
     * Returns the list of children C_OBJECT nodes for this C_ATTRIBUTE.
     *
     * @return
     */
    public List<CObject> getChildren() {
        return children;
    }

    /**
     * Sets the list of children C_OBJECT nodes for this C_ATTRIBUTE.
     *
     * @param children
     */
    public void setChildren(List<CObject> children) {
        this.children = children;
    }

    /**
     * Returns the path to the parent object of this attribute (i.e. doesn’t include
     * the name of this attribute). Used only for attributes in differential
     * form, specialised archetypes. Enables only the re-defined parts of a
     * specialised archetype to be expressed, at the path where they occur.
     *
     * @return
     */
    public String getDifferentialPath() {
        return differentialPath;
    }

    /**
     * Sets the path to the parent object of this attribute (i.e. doesn’t include
     * the name of this attribute). Used only for attributes in differential
     * form, specialised archetypes. Enables only the re-defined parts of a
     * specialised archetype to be expressed, at the path where they occur.
     *
     * @param differentialPath
     */
    public void setDifferentialPath(String differentialPath) {
        this.differentialPath = differentialPath;
    }

    /**
     * Returns the cardinality constraint of attribute, if a container attribute.
     *
     * @return
     */
    public Cardinality getCardinality() {
        return cardinality;
    }

    /**
     * Sets the cardinality constraint of attribute, if a container attribute.
     *
     * @param cardinality
     */
    public void setCardinality(Cardinality cardinality) {
        this.cardinality = cardinality;
    }

    /**
     * Returns flag indicating whether this attribute constraint is on a container (i.e. multiply-valued) attribute.
     * @return
     */
    public Boolean getIsMultiple() {
        return isMultiple;
    }

    /**
     * Sets flag indicating whether this attribute constraint is on a container (i.e. multiply-valued) attribute.
     * @param multiple
     */
    public void setIsMultiple(Boolean multiple) {
        isMultiple = multiple;
    }

    @Override
    public Boolean isLeaf() {
        return children != null && children.size() > 0;
    }

    public Boolean anyAllowed() {
        throw new NotImplementedException();//TODO Need to implement
    }

    public Boolean isMandatory() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Path of this attribute with respect to owning C_OBJECT, including differential path where applicable.
     *
     * @return
     */
    public String rmAttributePath() {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if this node logically represents a single-valued attribute. Evaluated as not is_multiple.
     *
     * @return
     */
    public Boolean isSingle() {
        return !isMultiple;
    }

    /**
     * True if constraints represented by this node contain no further redefinitions
     * with respect to the node other, with the exception of node_id redefnition in
     * C_OBJECT nodes. Typically used to test if an inherited node locally contains
     * any constraints.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean cCongruentTo(CAttribute other) {
        //True if this node on its own (ignoring any subparts) expresses no additional constraints than `other'.
        if(other == null) {
            return false;
        }

        return existence == null && ((isSingle() && other.isSingle()) || (isMultiple && other.isMultiple && cardinality == null));
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts,
     * are narrower or the same as other. Typically used during validation of
     * specialised archetype nodes.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean cConformsTo(CAttribute other) {
        //True if this node on its own (ignoring any subparts) expresses the same or narrower constraints as `other'.
        // Returns False if any of the following is incompatible:
        //	 * cardinality
        //   * existence
        if(other == null) {
            return false;
        }

        return existenceConformsTo(other) && ((isSingle() && other.isSingle()) || (isMultiple && cardinalityConformsTo(other)));
    }

    protected Boolean existenceConformsTo(CAttribute other) {
        //True if the existence of this node conforms to other.existence
        if(other == null) {
            return false;
        }
        if(existence != null && other.existence != null) {
            return other.existence.contains(existence);
        } else {
            return true;
        }
    }

    protected Boolean cardinalityConformsTo(CAttribute other) {
        //True if the cardinality of this node conforms to other.cardinality, if it exists
        if(other == null) {
            return false;
        }
        if(cardinality != null && other.cardinality != null) {
            return other.cardinality.contains(cardinality);
        } else {
            return true;
        }
    }

    /**
     * Post: Result = existence /= Void
     * and then existence.is_prohibited
     * True if this C_ATTRIBUTE has an existence
     * constraint of 0..0, i.e. prohibition.
     * <EOF>
     */
    public Boolean isProhibited() {
        throw new NotImplementedException();
    }
}
