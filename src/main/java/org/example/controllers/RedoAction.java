package org.example.controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoAction extends AbstractAction {
    private UndoSystem undo;

    public RedoAction(UndoSystem undo) {
        super("Redo");
        putValue("ACTION_COMMAND_KEY", "redo");
        this.undo = undo;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        undo.redo();
    }
}
