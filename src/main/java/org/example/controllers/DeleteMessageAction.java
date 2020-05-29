package org.example.controllers;

import org.example.models.MessageStore;

import java.awt.event.ActionEvent;

/**
 * Delete a message
 * Currently just deletes the first message for ease of use.
 */
public class DeleteMessageAction extends MessageAction {

    public DeleteMessageAction(MessageStore model, UndoSystem undo) {
        super("Delete", model, undo);
        putValue("SHORT_DESCRIPTION", "Deletes a message from the message store");
        putValue("ACTION_COMMAND_KEY", "del");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        model.deleteMessage(model.getMessages().get(0));
        undo.addAction(this);
    }
}
