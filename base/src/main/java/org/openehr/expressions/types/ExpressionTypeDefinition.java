package org.openehr.expressions.types;

import org.openehr.basetypes.Any;

/**
 * Ancestor class for type definitions known in the openEHR Expression formalism.
 *
 * Created by cnanjo on 5/20/16.
 */
public class ExpressionTypeDefinition<T> {

    /**
     * Natural language type name of this type as used in abstract rules syntax variable declarations.
     */
    private String typeName;
    /**
     * Attribute of the openEHR primitive type (or Any) corresponding to this type definition meta-type.
     */
    private T typeAnchor;

    /**
     *
     * @return Natural language type name of this type as used in abstract rules syntax variable declarations.
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     *
     * @param typeName Natural language type name of this type as used in abstract rules syntax variable declarations.
     */
    protected void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     *
     * @return Attribute of the openEHR primitive type (or Any) corresponding to this type definition meta-type.
     */
    public T getTypeAnchor() {
        return typeAnchor;
    }

    /**
     *
     * @param typeAnchor Attribute of the openEHR primitive type (or Any) corresponding to this type definition meta-type.
     */
    protected void setTypeAnchor(T typeAnchor) {
        this.typeAnchor = typeAnchor;
    }
}
