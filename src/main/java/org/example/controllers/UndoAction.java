package org.example.controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractAction {
    private UndoSystem undo;

    public UndoAction(UndoSystem undo) {
        super("Undo");
        putValue("ACTION_COMMAND_KEY", "undo");
        this.undo = undo;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(undo.canUndo()) undo.undo();
    }
}
