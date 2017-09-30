package org.openehr.utils.validation;

import java.util.List;

public class MessageDatabaseManager {

    private static final MessageDatabaseManager instance = new MessageDatabaseManager();

    private MessageDatabase messageDb = new MessageDatabase();

    public static MessageDatabaseManager getInstance() {
        return instance;
    }

    public String getMessageLine(String anId, List<String> args) {
        return messageDb.createMessageLine(anId, args);
    }

    public String getMessage(String anId, List<String> args) {
        return messageDb.createMessageContent(anId, args);
    }

    public String getText(String anId) {
        return messageDb.createMessageText(anId);
    }
}
