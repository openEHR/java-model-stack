package org.openehr.bmm.rm_access;

/*
 * #%L
 * OpenEHR - Java Model Stack
 * %%
 * Copyright (C) 2016 - 2017  Cognitive Medical Systems, Inc (http://www.cognitivemedicine.com).
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

import org.openehr.bmm.core.BmmDefinitions;
import org.openehr.bmm.persistence.PersistedBmmSchema;
import org.openehr.bmm.core.BmmModel;

import java.util.List;
import java.util.Map;

/**
 * Descriptor for a BMM schema. Contains a meta-data table of attributes obtained from a mini-ODIN parse of the schema file.
 */
public class SchemaDescriptor extends BmmDefinitions {

    /**
     * Persistent form of model.
     */
    private PersistedBmmSchema persistentSchema;
    /**
     * Computable form of model.
     */
    private BmmModel schema;
    /**
     * Schema id, formed from:
     *
     * meta_data(Metadata_model_publisher) '-' meta_data(metadata_schema_name) '-' meta_data(Metadata_model_release)
     * e.g. openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606-1_2008.
     */
    private String schemaId;
    /**
     * Table of {key, value} pairs of schema meta-data, keys as follows:
     *
     * "bmm_version",
     * "model_publisher",
     * "schema_name",
     * "model_release",
     * "schema_revision",
     * "schema_lifecycle_state",
     * "schema_description",
     * "schema_path"
     */
    private Map<String, String> metadata;
    /**
     * Schema_ids of schemas included by this schema.
     */
    private List<String> includes;

    /**
     * Returns persistent form of the model.
     *
     * @return
     */
    public PersistedBmmSchema getPersistentSchema() {
        return persistentSchema;
    }

    /**
     * Sets the persistent form of the model.
     *
     * @param persistentSchema
     */
    public void setPersistentSchema(PersistedBmmSchema persistentSchema) {
        this.persistentSchema = persistentSchema;
    }

    /**
     * Returns computable form of the model.
     *
     * @return
     */
    public BmmModel getSchema() {
        return schema;
    }

    /**
     * Sets the computable form of the model.
     *
     * @param schema
     */
    public void setSchema(BmmModel schema) {
        this.schema = schema;
    }

    /**
     * Returns the schema id.
     *
     * @return
     */
    public String getSchemaId() {
        return schemaId;
    }

    /**
     * Sets the schema id.
     *
     * @param schemaId
     */
    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    /**
     * Returns schema metadata.
     *
     * @return
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * Sets schema metadata.
     *
     * @param metadata
     */
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    /**
     * Returns Schema_ids of schemas included by this schema.
     *
     * @return
     */
    public List<String> getIncludes() {
        return includes;
    }

    /**
     * Sets Schema_ids of schemas included by this schema.
     * @param includes
     */
    public void setIncludes(List<String> includes) {
        this.includes = includes;
    }

    /**
     * True if this is a top-level schema, i.e. not included by some other schema.
     *
     * @return
     */
    public boolean isTopLevel() {
        return false;
    }

    /**
     * True if the BMM version found in the schema (or assumed, if none) is compatible with that in this software.
     *
     * @return
     */
    public boolean isBmmCompatible() {
        return false;
    }

    /**
     * Load schema into in-memory form.
     */
    public void load() {

    }

    /**
     * Validate entire schema.
     */
    public void validate() {

    }

    /**
     * Validate includes list for this schema, to see if each mentioned schema exists in read schemas.
     */
    public void validateIncludes() {

    }

    /**
     * Create `schema'.
     */
    public void createSchema() {

    }
}
