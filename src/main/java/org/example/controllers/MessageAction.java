package org.example.controllers;

import org.example.models.MessageStore;

import javax.swing.*;

/**
 * Generic class for allowing interaction with the model
 */
public abstract class MessageAction extends AbstractAction {
    protected MessageStore model;
    protected UndoSystem undo;

    public MessageAction(String name, MessageStore model, UndoSystem undo) {
        super(name);
        this.model = model;
        this.undo = undo;
    }
}
