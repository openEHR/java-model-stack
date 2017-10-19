package org.openehr.utils.message;

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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A repository of templates keyed by a key.
 *
 */
public class MessageDatabase {

    /**
     * Error templates in the form of a table of templates keyed by id
     */
    private Map<String,String> messageTable = new LinkedHashMap<>();

    /**
     * Default template if key does not have an associated template.
     *
     */
    private final String catchAllError = "(Error DB load failure); original error params {0}; {1}; {2}; {3}";

    public MessageDatabase() {}

    public MessageDatabase(Map<String, String> templates) {
        this.messageTable = templates;
    }

    /**
     * Returns the message table associated with this database.
     *
     * @return
     */
    public Map<String, String> getMessageTable() {
        return messageTable;
    }

    /**
     * Sets the message table associated with this database.
     *
     * @param messageTable
     */
    public void setMessageTable(Map<String, String> messageTable) {
        this.messageTable = messageTable;
    }

    /**
     * True if message for `aMessageId' exists in `message table'
     *
     * @param aMessageId
     * @return
     */
    public boolean hasMessage(String aMessageId) {
        return messageTable.containsKey(aMessageId);
    }

    /**
     * Returns true if templates are loaded in this database.
     *
     * @return
     */
    public boolean isDatabaseLoaded() {
        return messageTable != null && !messageTable.isEmpty();
    }

    /**
     * Adds the content of messageDb to this message database
     *
     * @param messageDb
     */
    public void addTable(MessageDatabase messageDb) {
        messageTable.putAll(messageDb.messageTable);
    }

    /**
     * Extract message for `an_id' from `message_table', perform substitutions from `args
     * and return the Result. If not found, return a standard message code error message.
     * @param aMessageTemplateId
     * @param aMessageArguments
     * @return
     */
    public String createMessageContent(String aMessageTemplateId, List<String> aMessageArguments) {
        String messageTemplate = null;
        List<String> argumentList = new ArrayList<>();
        if(messageTable.containsKey(aMessageTemplateId)) {
            //Obtain an error message for the code `an_id'
            messageTemplate = messageTable.get(aMessageTemplateId);
            if(aMessageArguments != null) {
                argumentList.addAll(aMessageArguments);
            }
        } else if(messageTable.containsKey ("message_code_error")){
            //Failing that, try to get an error message whose key is "message_code_error", which should
            //be a message that looks like "Error code $1 does not exist (calling context = $2.$3)"
            //(in whatever the generated language is)
            messageTemplate = messageTable.get("message_code_error");
            argumentList.add(aMessageTemplateId);
        } else {
            //Else use a hard-wired catchall error message
            messageTemplate = catchAllError;
        }
        if(argumentList != null && argumentList.size() > 0) {
            return MessageFormat.format(messageTemplate, argumentList.toArray());
        } else {
            return messageTemplate;
        }
    }

    /**
     * Same as `create_message_content' but with added newline at end
     *
     * @param aMessageTemplateId
     * @param aMessageArguments
     * @return
     */
    public String createMessageLine(String aMessageTemplateId, List<String> aMessageArguments) {
        return createMessageContent(aMessageTemplateId, aMessageArguments) + "\n";
    }

    /**
     * Extract fixed message for `an_id' from `message_table'
     * @param aMessageTemplateId
     * @return
     */
    public String returnMessageTemplateText(String aMessageTemplateId) {
        String messageTemplate = null;
        if(messageTable.containsKey(aMessageTemplateId)) {
            messageTemplate = messageTable.get(aMessageTemplateId);
        } else if(messageTable.containsKey("message_code_error")) {
            messageTemplate = messageTable.get("message_code_error");
            messageTemplate = String.format(messageTemplate, aMessageTemplateId);
        } else {
            messageTemplate = catchAllError;
        }
        return messageTemplate;
    }

}
