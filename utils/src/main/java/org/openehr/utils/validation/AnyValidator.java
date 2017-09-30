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
package org.openehr.utils.validation;

import org.openehr.utils.error.ErrorAccumulator;
import org.openehr.utils.error.ErrorDescriptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for OpenEHR model validators
 */
public abstract class AnyValidator {
    /**
     * True if validation succeeded
     */
    private boolean passed = true;

    /**
     * Error output of validator - things that must be corrected
     */
    private ErrorAccumulator errorCache = new ErrorAccumulator();

    /**
     * Returns the ErrorAccumulator for this validator
     *
     * @return
     */
    public ErrorAccumulator getErrorCache() {
        if(errorCache != null) {
            return errorCache;
        } else {
            errorCache = new ErrorAccumulator();
            return errorCache;
        }
    }

    public String getErrorStrings() {
        return errorCache.toString();
    }

    /**
     * Resets this validator for a new run
     */
    public void reset() {
        passed = true;
        errorCache = new ErrorAccumulator();
    }

    public boolean hasErrors() {
        return errorCache.hasErrors();
    }

    public boolean hasError(String aCode) {
        return errorCache.hasError(aCode);
    }

    public boolean hasWarnings(String aCode) {
        return errorCache.hasWarnings();
    }

    public void mergeErrors(ErrorAccumulator other) {
        errorCache.append(other);
        passed = passed && !(other.hasErrors());
    }

    /**
     * Append an error with key `a_key' and `args' array to the `errors' string
     * @param aKey
     * @param args
     */
    public void addError(String aKey, List<String> args) {
        addErrorWithLocation(aKey, args, "");
    }

    /**
     * Append a warning with key `a_key' and `args' array to the `warnings' string
     * @param aKey
     * @param args
     */
    public void addWarning(String aKey, List<String> args) {
        addWarningWithLocation(aKey, args, "");
    }

    /**
     * Append an information message with key `a_key' and `args' array to the `information' string
     * @param aKey
     * @param args
     */
    public void addInfo(String aKey, List<String> args) {
        addInfoWithLocation(aKey, args, "");
    }

    /**
     * Append an error with key `a_key' and `args' array to the `errors' string
     * @param aKey
     * @param args
     * @param aLocation
     */
    public void addErrorWithLocation(String aKey, List<String> args, String aLocation) {
        errorCache.addError(aKey, args, aLocation);
    }

    /**
     * Append a warning with key `a_key' and `args' array to the `warnings' string
     * @param aKey
     * @param args
     * @param aLocation
     */
    public void addWarningWithLocation(String aKey, List<String> args, String aLocation) {
        errorCache.addWarning(aKey, args, aLocation);
    }

    /**
     * Append an information message with key `a_key' and `args' array to the `information' string
     * @param aKey
     * @param args
     * @param aLocation
     */
    public void addInfoWithLocation(String aKey, List<String> args, String aLocation) {
        errorCache.addInfo(aKey, args, aLocation);
    }

    public boolean readyToValidate() {
        return passed;
    }

    /**
     * Runs validation routine
     */
    public void validate() {
        if(readyToValidate()) {
            doValidation();
            if(errorCache.hasErrorsOrWarnings()) {
                passed = false;
            }
        } else {
            new IllegalStateException("Error - not ready to validate");
        }
    }

    /**
     * Implementation of validation routine deferred to subclasses
     */
    public abstract void doValidation();
}
