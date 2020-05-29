package org.example.controllers;

import javax.swing.*;
import javax.swing.undo.UndoManager;

public class UndoSystem extends UndoManager{
    public void addAction(AbstractAction action){
        String type = (String) action.getValue("ACTION_COMMAND_KEY");
        switch (type){
            case "add": {
                addEdit(new AddMessageUndoableEdit((AddMessageAction) action));
                break;
            }
            case "del":{
                break;
            }
            case "edit":{

            }
            default:{
            }
        }
    }
}
