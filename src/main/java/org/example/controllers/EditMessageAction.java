package org.example.controllers;

import org.example.models.MessageStore;
import java.awt.event.ActionEvent;

public class EditMessageAction extends MessageAction {

    public EditMessageAction(MessageStore model, UndoSystem undo) {
        super("Edit", model, undo);
        putValue("SHORT_DESCRIPTION", "Edit the contents of the message");
        putValue("ACTION_COMMAND_KEY", "edit");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
