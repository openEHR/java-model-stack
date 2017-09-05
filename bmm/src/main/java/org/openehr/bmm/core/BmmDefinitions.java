package org.openehr.bmm.core;

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

import org.openehr.odin.utils.OdinSerializationUtils;

/**
 * Definitions used by all BMM packages.
 *
 * Created by cnanjo on 4/11/16.
 */
public abstract class BmmDefinitions {

    /**
     * Current internal version of BMM meta-model, used to determine if a given schema can be processed by a given
     * implementation of the model.
     */
    private String bmmInternalVersion;
    /**
     * Delimiter used to separate schema id from package path in a fully qualified path.
     */
    private String schemaNameDelimiter = "::";
    /**
     * Delimiter used to separate package names in a package path.
     */
    private String packageNameDelimiter = ".";
    /**
     * Extension used for BMM files.
     */
    private String bmmSchemeFileExtension = ".bmm";

    /**
     * Method returns the current internal version of BMM meta-model, used to determine if a
     * given schema can be processed by a given implementation of the model.
     *
     * @return
     */
    public String getBmmInternalVersion() {
        return bmmInternalVersion;
    }

    /**
     * Method sets the current internal version of BMM meta-model, used to determine if a
     * given schema can be processed by a given implementation of the model.
     *
     * @param bmmInternalVersion
     */
    public void setBmmInternalVersion(String bmmInternalVersion) {
        this.bmmInternalVersion = bmmInternalVersion;
    }

    /**
     * Method returns the delimiter used to separate schema id from package path in a fully qualified path.
     *
     * @return
     */
    public String getSchemaNameDelimiter() {
        return schemaNameDelimiter;
    }

    /**
     * Method sets the delimiter used to separate schema id from package path in a fully qualified path.
     *
     * @param schemaNameDelimiter
     */
    public void setSchemaNameDelimiter(String schemaNameDelimiter) {
        this.schemaNameDelimiter = schemaNameDelimiter;
    }

    /**
     * Method returns the delimiter used to separate package names in a package path.
     *
     * @return
     */
    public String getPackageNameDelimiter() {
        return packageNameDelimiter;
    }

    /**
     * Method sets the delimiter used to separate package names in a package path.
     *
     * @param packageNameDelimiter
     */
    public void setPackageNameDelimiter(String packageNameDelimiter) {
        this.packageNameDelimiter = packageNameDelimiter;
    }

    /**
     * Method returns the extension used for BMM files.
     * @return
     */
    public String getBmmSchemeFileExtension() {
        return bmmSchemeFileExtension;
    }

    /**
     * Method sets the extension used for BMM files.
     *
     * @param bmmSchemeFileExtension
     */
    public void setBmmSchemeFileExtension(String bmmSchemeFileExtension) {
        this.bmmSchemeFileExtension = bmmSchemeFileExtension;
    }

    /**
     * Convenience method to help readability when serializing BMM model elements.
     * Indents a statement by the number of tabs specified.
     * Appends requested number of tabs to StringBuilder argument.
     *
     * @param builder The string builder where the tabbed indentation is to be appended
     * @param indentCount The number of tabs to indent
     */
    protected void indentBy(StringBuilder builder, int indentCount) {//TODO Eventually deprecate this method
        builder.append(OdinSerializationUtils.indentByTabCount(indentCount));
    }
}
