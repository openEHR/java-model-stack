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
import org.openehr.bmm.core.BmmModel;
import org.openehr.bmm.persistence.BmmIncludeSpecification;
import org.openehr.bmm.persistence.PersistedBmmSchema;
import org.openehr.bmm.persistence.deserializer.BmmSchemaDeserializer;
import org.openehr.odin.CompositeOdinObject;
import org.openehr.odin.antlr.OdinVisitorImpl;
import org.openehr.odin.loader.OdinLoaderImpl;
import org.openehr.utils.datatype.DataType;
import org.openehr.utils.file.FileAndDirUtils;

import java.io.File;
import java.util.*;

public class ReferenceModelAccess extends BmmDefinitions {

    /**
     * List of directories where all the schemas loaded here are found.
     */
    private List<String> schemaDirectories;
    /**
     * All schemas found and loaded from `schema_directory'. Keyed by schema_id, i.e.
     * <p>
     * model_publisher '' schema_name '' model_release
     * e.g. openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606-1_2008.
     * This is the same key as BMM_SCHEMA.schema_id. Does not
     * include schemas that failed to parse (i.e. SCHEMA_ACCESS.passed = False)
     */
    private Map<String, SchemaDescriptor> allSchemas;
    /**
     * Top-level (root) schemas in use. Table is keyed by logical schema_name,
     * i.e. model_publisher '_' model_name, e.g. "openehr_rm". Schemas containing
     * different variants of same model (i.e. model_publisher + model_name) are
     * considered duplicates.
     */
    private Map<String, BmmModel> validModels;

    /**
     * Cache of loaded persisted schemas.
     */
    private Map<String, PersistedBmmSchema> persistedModelIndex;

    /**
     * No-arg constructors initializing all maps and lists.
     */
    public ReferenceModelAccess() {
        schemaDirectories = new ArrayList<>();
        allSchemas = new HashMap<>();
        validModels = new HashMap<>();
        persistedModelIndex = new LinkedHashMap<>();
    }

    /**
     * Method returns list of directories where all the schemas loaded are found.
     *
     * @return
     */
    public List<String> getSchemaDirectories() {
        return schemaDirectories;
    }

    /**
     * Method sets the list of directories where all the schemas to be loaded are found.
     *
     * @param schemaDirectories
     */
    public void setSchemaDirectories(List<String> schemaDirectories) {
        this.schemaDirectories = schemaDirectories;
    }

    /**
     * Method adds a schema directory.
     */
    public void addSchemaDirectory(String directory) {
        this.schemaDirectories.add(directory);
    }

    /**
     * Method returns all schemas found and loaded from `schema_directory'. Map is keyed by schema_id.
     * <p>
     * A schema_id is formed by concatenating: model_publisher '' schema_name '' model_release
     *
     * @return
     */
    public Map<String, SchemaDescriptor> getAllSchemas() {
        return allSchemas;
    }

    /**
     * Method sets map of schemas keyed by schema_id
     * <p>
     * A schema_id is formed by concatenating: model_publisher '' schema_name '' model_release
     *
     * @param allSchemas
     */
    public void setAllSchemas(Map<String, SchemaDescriptor> allSchemas) {
        this.allSchemas = allSchemas;
    }

    public void addSchema(SchemaDescriptor schemaDescriptor) {
        this.allSchemas.put(schemaDescriptor.getSchemaId(), schemaDescriptor);
    }

    /**
     * Method returns map of BmmModels keyed by logical model id.
     * <p>
     * A logical model id is keyed by: model_publisher '_' model_name
     *
     * @return
     */
    public Map<String, BmmModel> getValidModels() {
        return validModels;
    }

    /**
     * Method sets map of BmmModels keyed by logical model id.
     * <p>
     * A logical model id is keyed by: model_publisher '_' model_name
     *
     * @param validModels
     */
    public void setValidModels(Map<String, BmmModel> validModels) {
        this.validModels = validModels;
    }


    public void addValidModel(BmmModel schema) {
        this.validModels.put(schema.getSchemaId(), schema);
    }

    /**
     * Initialise with a specific schema load list, usually a sub-set of schemas that will be found in the directory `an_absolute_dir'.
     */
    public void initializeWithLoadList(List<String> schemaDirectories, List<String> schemaLoadList) {

    }

    /**
     * Initializes all schema based on schema directory list provided.
     */
    public void initializeAll() {
        clearCache();
        if (schemaDirectories == null || schemaDirectories.size() <= 0) {
            throw new RuntimeException("Error initializing schemas. No schema directory set.");
        } else {
            Map<String, BmmIncludeSpecification> allIncludes = loadAllPersistedModels();
            Queue<PersistedBmmSchema> queue = new LinkedList<>();
            Map<String, PersistedBmmSchema> schemasToProcess = new LinkedHashMap<>();
            persistedModelIndex.forEach((id, persistedBmmSchema) -> {
                queue.add(persistedBmmSchema);
            });
            int tries = 0;
            int attempts = 100;//TODO Figure out better way to break on cycles in directed cyclic graph or when non-resolvable dependencies exist
            while (queue.size() > 0) {
                PersistedBmmSchema persistedBmmSchema = queue.remove();
                Map<String, BmmIncludeSpecification> includeMap = persistedBmmSchema.getIncludes();
                if (includeMap == null || includeMap.size() == 0) {
                    schemasToProcess.put(persistedBmmSchema.generateSchemaIdentifier().toUpperCase(), persistedBmmSchema);
                } else {
                    final DataType<Boolean> allResolved = new DataType(true);
                    for (String includeId : includeMap.keySet()) {
                        if (schemasToProcess.get(includeId.toUpperCase()) == null) {
                            allResolved.setValue(false);
                            queue.add(persistedBmmSchema);//I have an unresolved dependency so add me back to the queue.
                            break;
                        }
                    }
                    if (allResolved.getValue()) {
                        schemasToProcess.put(persistedBmmSchema.generateSchemaIdentifier().toUpperCase(), persistedBmmSchema);
                    }
                    if (tries >= attempts) {
                        //throw new RuntimeException("Unresolvable includes " + queue.toString());
                        break;
                    }
                    tries++;
                }
            }
            schemasToProcess.forEach((id, persistedBmmModel) ->{
                processSchema(persistedBmmModel);
            });
            System.out.println("Processing completed");
        }
    }

    public Map<String, BmmIncludeSpecification> loadAllPersistedModels() {
        Map<String, BmmIncludeSpecification> allIncludes = new HashMap<>();
        clearCache();
        if (schemaDirectories == null || schemaDirectories.size() <= 0) {
            throw new RuntimeException("Error initializing schemas. No schema directory set.");
        } else {
            List<File> bmmFiles = FileAndDirUtils.loadFilesWithExtensionFromDirectories(getSchemaDirectories(), ".bmm", false);
            bmmFiles.forEach(file -> {
                PersistedBmmSchema persistedBmmSchema = loadPersistedModel(file);
                allIncludes.putAll(persistedBmmSchema.getIncludes());
                persistedModelIndex.put(persistedBmmSchema.generateSchemaIdentifier().toUpperCase(), persistedBmmSchema);
            });
        }
        return allIncludes;
    }

    public PersistedBmmSchema loadPersistedModel(File file) {
        OdinLoaderImpl loader = new OdinLoaderImpl();
        OdinVisitorImpl visitor = loader.loadOdinFile(file.getAbsolutePath());
        CompositeOdinObject root = visitor.getAstRootNode();
        BmmSchemaDeserializer deserializer = new BmmSchemaDeserializer();
        return deserializer.deserialize(root);
    }

    protected void processSchema(PersistedBmmSchema persistedBmmSchema) {
        String schemaId = persistedBmmSchema.generateSchemaIdentifier();
        if(validModels.get(schemaId.toUpperCase()) == null) {
            handleMerge(persistedBmmSchema);
            persistedBmmSchema.createBmmSchema();
            //TODO Add validation here
            persistedBmmSchema.validate();
            BmmModel model = persistedBmmSchema.getBmmModel();
            if (model != null) {
                validModels.put(schemaId.toUpperCase(), model);//TODO Figure out how to handle nested bmm files
            } else {
                throw new RuntimeException("Invalid model. Model cannot be null");
            }
        }
    }

    protected void handleMerge(PersistedBmmSchema mergeTarget) {
        Map<String, Integer> includeReferenceFrequency = new HashMap<>();
        calculateIncludeReferenceFrequencies(includeReferenceFrequency, mergeTarget);
        mergeTarget.getIncludes().forEach((id, include) -> {
            if(includeReferenceFrequency.get(id.toUpperCase()) == 1) {//Only merge models that have not been already merged in other include dependencies
                PersistedBmmSchema toBeMerged = persistedModelIndex.get(id.toUpperCase());
                mergeTarget.merge(toBeMerged);
            }
        });
    }

    protected void calculateIncludeReferenceFrequencies(Map<String,Integer> includeReferenceFrequency, PersistedBmmSchema schema) {
        Map<String, BmmIncludeSpecification> includes = schema.getIncludes();
        includes.keySet().forEach(id ->{
            if(includeReferenceFrequency.get(id) == null) {
                includeReferenceFrequency.put(id, 1);
            } else {
                includeReferenceFrequency.put(id, includeReferenceFrequency.get(id) + 1);
            }
            calculateIncludeReferenceFrequencies(includeReferenceFrequency, persistedModelIndex.get(id.toUpperCase()));
        });
    }

    /**
     * Method removes all cached schemas.
     */
    public void clearCache() {
        if (validModels == null) {
            validModels = new HashMap<>();
        } else {
            validModels.clear();
        }
        if (persistedModelIndex == null) {
            persistedModelIndex = new LinkedHashMap<>();
        } else {
            persistedModelIndex.clear();
        }
    }

    /**
     * Method clears model cache and reloads all schemas located in the schema directories (files with .bmm extensions only)
     */
    public void reloadSchemas() {
        initializeAll();
    }
}
