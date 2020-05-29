package org.example.controllers;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

public class AddMessageUndoableEdit extends AbstractUndoableEdit{
    private AddMessageAction action;

    public AddMessageUndoableEdit(AddMessageAction action) {
        this.action = action;
    }

    @Override
    public void undo() throws CannotUndoException {
        super.undo();
        // Note: This is very bad. Don't do it like this.
        // Only done like this because of time constraints.
        new DeleteMessageAction(action.model, action.undo).actionPerformed(null);
    }

    @Override
    public void redo() throws CannotRedoException {
        super.redo();
        action.actionPerformed(null);
    }

    @Override
    public String getUndoPresentationName() {
        return "Undo "+action.getValue("Name");
    }

    @Override
    public String getRedoPresentationName() {
        return "Redo "+action.getValue("Name");
    }
}