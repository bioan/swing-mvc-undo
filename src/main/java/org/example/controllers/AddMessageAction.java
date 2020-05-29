package org.example.controllers;

import org.example.models.MessageStore;
import java.awt.event.ActionEvent;

public class AddMessageAction extends MessageAction {
    public AddMessageAction(MessageStore model, UndoSystem undo) {
        super("Add message", model, undo);
        putValue("SHORT_DESCRIPTION", "Adds a message to the message store");
        putValue("ACTION_COMMAND_KEY", "add");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.addMessage("Dear Leader", "All hail glorious OOP");
        undo.addAction(this);
    }
}
