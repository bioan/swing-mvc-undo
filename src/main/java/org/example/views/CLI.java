package org.example.views;

import org.example.controllers.*;
import org.example.models.Message;
import org.example.models.MessageStore;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class CLI implements Observer {
    private ArrayList<AbstractAction> actions = new ArrayList<>();
    private MessageStore model;
    private Scanner in = new Scanner(System.in);
    private UndoSystem undo = new UndoSystem();
    private boolean running;

    public CLI(MessageStore model) {
        this.model=model;
        model.addObserver(this);
        initializeActions();
        startEventLoop();
    }

    private void startEventLoop() {
        running=true;
        while(running) {
            printActions();
            getUserSelection();
        }
    }

    private void getUserSelection() {
        int choice = in.nextInt();
        actions.get(choice).actionPerformed(null);
    }

    @Override
    public void update(Observable observable, Object o) {
        printMessages();
    }

    private void printMessages() {
        for(Message m:model.getMessages()){
            System.out.println(m.getSender() + ": "+m.getContents());
        }
    }

    private void printActions(){
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i+") "+actions.get(i).getValue("Name"));
        }
    }

    private void initializeActions() {
        actions.add(new AddMessageAction(model, undo));
        actions.add(new EditMessageAction(model, undo));
        actions.add(new DeleteMessageAction(model, undo));
        actions.add(new RedoAction(undo));
        actions.add(new UndoAction(undo));
    }
}
