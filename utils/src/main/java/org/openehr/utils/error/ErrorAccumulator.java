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
package org.openehr.utils.error;

import org.openehr.utils.validation.GlobalErrorReportingLevel;
import org.openehr.utils.validation.MessageDatabaseManager;

import java.util.ArrayList;
import java.util.List;

public class ErrorAccumulator {

    /**
     * Error output of validator - things that must be corrected
     */
    private List<ErrorDescriptor> errorList = new ArrayList<>();
    private boolean hasErrors;
    private boolean hasWarnings;
    private boolean hasInfo;
    private MessageDatabaseManager messageDatabaseManager = MessageDatabaseManager.getInstance();

    public ErrorDescriptor lastAdded() {
        if(errorList != null && errorList.size() > 0) {
            return errorList.get(errorList.size() - 1);
        } else {
            return null;
        }
    }

    public List<String> getErrorCodes() {
        List<String> errorCodes = new ArrayList<>();
        errorList.forEach(item -> {
            if(item.getSeverity().equals(ErrorSeverityTypes.ERROR_TYPE_ERROR)) {
                errorCodes.add(item.getCode());
            }
        });
        return errorCodes;
    }

    public List<String> getWarningCodes() {
        List<String> warningCodes = new ArrayList<>();
        errorList.forEach(item -> {
            if(item.getSeverity().equals(ErrorSeverityTypes.ERROR_TYPE_WARNING)) {
                warningCodes.add(item.getCode());
            }
        });
        return warningCodes;
    }

    public boolean isEmpty() {
        return errorList.isEmpty();
    }

    public boolean hasErrors() {
        return hasErrors;
    }

    public boolean hasWarnings() {
        return hasWarnings;
    }

    public boolean hasInfo() {
        return hasInfo;
    }

    public boolean hasErrorsOrWarnings() {
        return hasErrors || hasWarnings;
    }

    /**
     * True if there has been an error recorded with code `a_code'
     *
     * @param aCode
     * @return
     */
    public boolean hasError(String aCode) {
        return getErrorCodes().contains(aCode);
    }

    /**
     * True if there has been an error whose code starts with code `a_code'
     *
     * @param aCode
     * @return
     */
    public boolean hasMatchingError(String aCode) {
        boolean retVal = false;
        for(int index = 0; index < errorList.size(); index++) {
            ErrorDescriptor error = errorList.get(index);
            if(error.getSeverity().equals(ErrorSeverityTypes.ERROR_TYPE_ERROR) && error.getCode().startsWith(aCode)) {
                retVal = true;
                break;
            }
        }
        return retVal;
    }

    /**
     * True if there has been a warning whose code starts with code `a_code'
     *
     * @param aCode
     * @return
     */
    public boolean hasMatchingWarning(String aCode) {
        boolean retVal = false;
        for(int index = 0; index < errorList.size(); index++) {
            ErrorDescriptor error = errorList.get(index);
            if(error.getSeverity().equals(ErrorSeverityTypes.ERROR_TYPE_WARNING) && error.getCode().startsWith(aCode)) {
                retVal = true;
                break;
            }
        }
        return retVal;
    }

    public void addError(String aCode, List<String> args, String aLocation) {
        errorList.add(new ErrorDescriptor(aCode, ErrorSeverityTypes.ERROR_TYPE_ERROR, messageDatabaseManager.getMessage(aCode, args), aLocation));
    }

    public void addWarning(String aCode, List<String> args, String aLocation) {
        errorList.add(new ErrorDescriptor(aCode, ErrorSeverityTypes.ERROR_TYPE_WARNING, messageDatabaseManager.getMessage(aCode, args), aLocation));
    }

    public void addInfo(String aCode, List<String> args, String aLocation) {
        errorList.add(new ErrorDescriptor(aCode, ErrorSeverityTypes.ERROR_TYPE_INFO, messageDatabaseManager.getMessage(aCode, args), aLocation));
    }

    public void addDebug(String aMessage, String aLocation) {
        errorList.add(new ErrorDescriptor("", ErrorSeverityTypes.ERROR_TYPE_DEBUG, aMessage, aLocation));
    }

    public void add(ErrorDescriptor errorDescriptor) {
        errorList.add(errorDescriptor);
        hasErrors = hasErrors || errorDescriptor.getSeverity().equals(ErrorSeverityTypes.ERROR_TYPE_ERROR);
        hasWarnings = hasWarnings || errorDescriptor.getSeverity().equals(ErrorSeverityTypes.ERROR_TYPE_WARNING);
        hasInfo = hasInfo || errorDescriptor.getSeverity().equals(ErrorSeverityTypes.ERROR_TYPE_INFO);
    }

    public void append(ErrorAccumulator other) {
        this.errorList.addAll(other.getErrorList());
        hasErrors = hasErrors || other.hasErrors;
        hasWarnings = hasWarnings || other.hasWarnings;
        hasInfo = hasInfo || other.hasInfo;
    }

    public void clear() {
        errorList.clear();
        hasErrors = false;
        hasWarnings = false;
        hasInfo = false;
    }

    public List<ErrorDescriptor> getErrorList() {
        return errorList;
    }

    /**
     * Generate stringified version of contents, with newlines inserted after each entry
     *
     * @return
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        errorList.forEach(error -> {
            if(error.getSeverity() >= GlobalErrorReportingLevel.getGlobalErrorReportingLevel()) {
                builder.append(error.toString()).append("\n");
            }
        });
        return builder.toString();
    }

    /**
     * Generate filtered stringified version of contents, with newlines inserted after each entry
     *
     * @param includeErrors
     * @param includeWarnings
     * @param includeInfo
     * @return
     */
    public String toStringFiltered(boolean includeErrors, boolean includeWarnings, boolean includeInfo) {
        StringBuilder builder = new StringBuilder();
        errorList.forEach(error -> {
            if(includeErrors) {
                builder.append(error.toString()).append("\n");
            } else if(includeWarnings) {
                builder.append(error.toString()).append("\n");
            } else if(includeInfo) {
                builder.append(error.toString()).append("\n");
            }
        });
        return builder.toString();
    }
}