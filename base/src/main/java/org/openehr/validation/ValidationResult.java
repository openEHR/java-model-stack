package org.openehr.validation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cnanjo on 5/23/16.
 */
public class ValidationResult {

    private boolean isValid;
    private Map<String, String> validationErrorMessages;

    public ValidationResult() {
        this.validationErrorMessages = new HashMap<String, String>();
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Map<String, String> getValidationErrorMessages() {
        return validationErrorMessages;
    }

    public void setValidationErrorMessages(Map<String, String> validationErrorMessages) {
        this.validationErrorMessages = validationErrorMessages;
    }

    public void addValidationErrorMessage(String invariant, String message) {
        this.validationErrorMessages.put(invariant, message);
    }
}
