package org.openehr.basetypes.terminology;

/*
 * #%L
 * OpenEHR - Java Model Stack
 * %%
 * Copyright (C) 2016 - 2017 Cognitive Medical Systems
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 * Author: Claude Nanjo
 */

import org.openehr.basetypes.Any;

import java.net.URI;

/**
 * Logically primitive type representing a reference to a terminology concept, in the form
 * of a terminology identifier, optional version, and a code or code string from the terminology.
 *
 * Created by cnanjo on 5/19/16.
 */
public class TerminologyCode implements Any {

    /**
     * The archetype environment namespace identifier used to identify a terminology. Typically a value like
     * "snomed_ct" that is mapped elsewhere to the full URI identifying the terminology.
     */
    private String terminologyId;
    /**
     * Optional string value representing terminology version, typically a date or dotted numeric.
     */
    private String terminologyVersion;
    /**
     * A terminology code or post-coordinated code expression, if supported by the terminology. The
     * code may refer to a single term, a value set consisting of multiple terms, or some other entity
     * representable within the terminology.
     */
    private String code;
    /**
     * A display name for the code
     */
    private String displayName;
    /**
     * The URI reference that may be used as a concrete key into a notional terminology service for
     * queries that can obtain the term text, definition, and other associated elements.
     */
    private URI uri;

    /**
     * Returns the terminology identifier.
     *
     * @return
     */
    public String getTerminologyId() {
        return terminologyId;
    }

    /**
     * Sets the terminology identifier.
     *
     * @param terminologyId
     */
    public void setTerminologyId(String terminologyId) {
        this.terminologyId = terminologyId;
    }

    /**
     * Returns the version of the terminology for this particular concept.
     *
     * @return
     */
    public String getTerminologyVersion() {
        return terminologyVersion;
    }

    /**
     * Sets the version of the terminology for this particular concept.
     *
     * @param terminologyVersion
     */
    public void setTerminologyVersion(String terminologyVersion) {
        this.terminologyVersion = terminologyVersion;
    }

    /**
     * Returns the concept code.
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the concept code.
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns the display name for this concept.
     *
     * @return
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name for this concept.
     *
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the URI for the concept.
     *
     * @return
     */
    public URI getUri() {
        return uri;
    }

    /**
     * Sets the URI for the concept.
     *
     * @param uri
     */
    public void setUri(URI uri) {
        this.uri = uri;
    }
}
