package org.openehr.aom.constraintmodel;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.openehr.basetypes.structures.MultiplicityInterval;
import org.openehr.bmm.util.ReferenceModelPropertyMultiplicity;
import org.openehr.bmm.util.ReferenceModelTypesConformant;

/**
 * Abstract model of constraint on any kind of object node.
 *
 * Created by cnanjo on 5/19/16.
 */
public abstract class CObject extends ArchetypeConstraint {

    /**
     * Reference model type that this node corresponds to.
     */
    private String rmTypeName;
    /**
     * Occurrences of this object node in the data, under the owning attribute. Upper limit can only be greater than 1
     * if owning attribute has a cardinality of more than 1. Only set if it overrides the parent archetype in the case
     * of specialised archetypes, or else the occurrences inferred from the underlying reference model existence and/or
     * cardinality of the containing attribute.
     */
    private MultiplicityInterval occurrences;
    /**
     * Semantic identifier of this node, used to distinguish sibling nodes. All nodes must have a node_id; for nodes
     * under a container C_ATTRIBUTE, the id must be an id-code must be defined in the archetype terminolo-gy. For valid
     * structures, all node ids are id-codes. For C_PRIMITIVE_OBJECTs, it will have the special value Primitive_node_id.
     */
    private String nodeId;
    /**
     * True if this node and by implication all sub-nodes are deprecated for use.
     */
    private Boolean isDeprecated;
    /**
     * Optional indicator of order of this node with respect to another sibling. Only meaningful in a specialised
     * archetype for a C_OBJECT within a C_ATTRIBUTE with is_multiple = True.
     */
    private SiblingOrder siblingOrder;

    /**
     * Returns the reference model type that this node corresponds to.
     *
     * @return
     */
    public String getRmTypeName() {
        return rmTypeName;
    }

    /**
     * Sets the reference model type that this node corresponds to.
     *
     * @param rmTypeName
     */
    public void setRmTypeName(String rmTypeName) {
        this.rmTypeName = rmTypeName;
    }

    /**
     * Returns the occurrences of this object node in the data, under the owning attribute.
     *
     * @return
     */
    public MultiplicityInterval getOccurrences() {
        return occurrences;
    }

    /**
     * Sets the occurrences of this object node in the data, under the owning attribute.
     *
     * @param occurrences
     */
    public void setOccurrences(MultiplicityInterval occurrences) {
        this.occurrences = occurrences;
    }

    /**
     * Returns the semantic identifier of this node, used to distinguish sibling nodes.
     *
     * @return
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * Sets the semantic identifier of this node, used to distinguish sibling nodes.
     *
     * @param nodeId
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * Returns true if C_OBJECT is deprecated.
     *
     * @return
     */
    public Boolean getDeprecated() {
        return isDeprecated;
    }

    /**
     * Sets whether C_OBJECT is deprecated.
     *
     * @param deprecated
     */
    public void setDeprecated(Boolean deprecated) {
        isDeprecated = deprecated;
    }

    /**
     * Returns the indicator of order of this node with respect to another sibling. Only meaningful in a specialised
     * archetype for a C_OBJECT within a C_ATTRIBUTE with is_multiple = True.
     *
     * @return
     */
    public SiblingOrder getSiblingOrder() {
        return siblingOrder;
    }

    /**
     * Sets the indicator of order of this node with respect to another sibling. Only meaningful in a specialised
     * archetype for a C_OBJECT within a C_ATTRIBUTE with is_multiple = True.
     *
     * @param siblingOrder
     */
    public void setSiblingOrder(SiblingOrder siblingOrder) {
        this.siblingOrder = siblingOrder;
    }

    /**
     * Level of specialisation of this archetype node, based on its node_id. The value 0 corresponds to non-specialised,
     * 1 to first-level specialisation and so on. The level is the same as the number of ‘.’ characters in the node_id
     * code. If node_id is not set, the return value is -1, signifying that the specialisation level should be determined
     * from the nearest parent C_OBJECT node having a node_id.
     *
     * @return
     */
    public Integer specializationDepth() {
        if(nodeId == null) {
            return -1;
        } else if(nodeId.indexOf('.') < 0) {
            return 0;
        } else {
            return StringUtils.countMatches(nodeId, ".");
        }
    }

    /**
     * See section 4.5.5.1
     *
     * @param rmPropMult
     * @return
     */
    public MultiplicityInterval effectiveOccurrences(ReferenceModelPropertyMultiplicity rmPropMult) {
//        Integer occLower = null;
//        if(occurrences != null) {
//            return occurrences;
//        } else if(getParent() != null) {
//            if(getParent().getExistence() != null) {
//                occLower = getParent().getExistence().getLower();
//            }
//            if(getParent().getCardinality() != null) {
//                if(getParent().getCardinality().getInterval().isUpperUnbounded()) {
//                    MultiplicityInterval retVal = new MultiplicityInterval();
//                    retVal.makeUpperUnbounded(ocLower);
//                    return retVal;
//                } else {
//                    MultiplicityInterval retVal = new MultiplicityInterval();
//                    retVal.makeBounded(occLower, parent.cardinality.interval.upper);
//                    return retVal;
//                }
//            } else if(getParent().getParent() != null) {
//                return rmPropMult (getParent().getParent().getRmTypeName, getParent().getParent().getRmAttributePath());
//            } else {
//                MultiplicityInterval retVal = new MultiplicityInterval();
//                retVal.makeUpperUnbounded(occLower);
//                return retVal;
//            }
//        } else {
//            MultiplicityInterval retVal = new MultiplicityInterval();
//            retVal.makeOpen();
//            return retVal;
//        }
        throw new NotImplementedException();//TODO Need to implement
    }

    //See Section 4.5.5.2

    public Boolean constraintConformsTo(CObject other){throw new NotImplementedException();//TODO Need to implement
        }//, ReferenceModelTypesConformant rmTypesConformant) {}

    public Boolean constraintCongruentTo(CObject other) {throw new NotImplementedException();//TODO Need to implement
        }

    public Boolean occurrencesConformsTo(CObject other) {throw new NotImplementedException();//TODO Need to implement
        }

    public Boolean nodeIdConformsTo(CObject other) {throw new NotImplementedException();//TODO Need to implement
        }

    public Boolean nodeReuseCongruent(CObject other) {throw new NotImplementedException();//TODO Need to implement
        }
}
