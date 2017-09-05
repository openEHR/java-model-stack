package org.openehr.expressions.core;

import java.util.List;

/**
 * Definition of a variable whose value is derived from a query run on a data context in the operational environment.
 * Typical uses of this kind of variable are to obtain values like the patient date of birth, sex, weight, and so on.
 * It could also be used to obtain items from a knowledge context, such as a drug database.
 *
 * Created by cnanjo on 5/20/16.
 */
public class ExternalQuery extends ExpressionValue {

    /**
     * Optional name of context. This allows a basic separation of query types to be done in more sophisticated
     * environments. Possible values might be “patient”, “medications” and so on. Not yet standardised.
     */
    private String context;
    /**
     * Identifier of query in the external context, e.g. “date_of_birth”. Not yet standardised.
     */
    private String queryId;
    /**
     * Optional arguments to query. Not yet standardised.
     */
    private List<String> queryArguments;

    /**
     *
     * @return Optional name of context. This allows a basic separation of query types to be done in more sophisticated
     * environments. Possible values might be “patient”, “medications” and so on. Not yet standardised.
     */
    public String getContext() {
        return context;
    }

    /**
     *
     * @param context Optional name of context. This allows a basic separation of query types to be done in more sophisticated
     * environments. Possible values might be “patient”, “medications” and so on. Not yet standardised.
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     *
     * @return Identifier of query in the external context, e.g. “date_of_birth”. Not yet standardised.
     */
    public String getQueryId() {
        return queryId;
    }

    /**
     *
     * @param queryId Identifier of query in the external context, e.g. “date_of_birth”. Not yet standardised.
     */
    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    /**
     *
     * @return Optional arguments to query. Not yet standardised.
     */
    public List<String> getQueryArguments() {
        return queryArguments;
    }

    /**
     *
     * @param queryArguments Optional arguments to query. Not yet standardised.
     */
    public void setQueryArguments(List<String> queryArguments) {
        this.queryArguments = queryArguments;
    }
}
