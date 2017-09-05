package org.openehr.aom.terminology;

import java.util.List;

/**
 * Class whose instances represent any kind of 1:N relationship between a source term and 1-N target terms.
 *
 * Created by cnanjo on 5/19/16.
 */
public abstract class TerminologyRelation {

    /**
     * Code of source term of this relation.
     *
     */
    private String id;
    /**
     * List of target terms in this relation.
     *
     */
    private List<String> members;

    /**
     * Returns code of source term of this relation.
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Sets code of source term of this relation.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns list of target terms in this relation.
     *
     * @return
     */
    public List<String> getMembers() {
        return members;
    }

    /**
     * Sets list of target terms in this relation.
     *
     * @param members
     */
    public void setMembers(List<String> members) {
        this.members = members;
    }
}
