package org.example.views;

import org.example.controllers.*;
import org.example.models.Message;
import org.example.models.MessageStore;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Swing extends JFrame implements Observer {
    private ArrayList<AbstractAction> actions = new ArrayList<>();
    private MessageStore model;
    private UndoSystem undo = new UndoSystem();
    private JPanel messagePanel;

    public Swing(MessageStore model) throws HeadlessException {
        this.model = model;
        model.addObserver(this);

        initializeActions();
        initializeButtonPanel();
        initializeMessagePanel();

        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void initializeButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(new JLabel("Buttons:"));
        for(AbstractAction action:actions){
            buttonPanel.add(new JButton(action));
        }
        add(buttonPanel);
    }

    private void initializeMessagePanel() {
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.PAGE_AXIS));
        add(messagePanel);
        printMessages();
        messagePanel.add(new JLabel("Messages:"));
    }

    private void printMessages() {
        messagePanel.removeAll();
        for(Message m:model.getMessages()){
            messagePanel.add(new JLabel(m.getSender()+": "+m.getContents()));
        }
        messagePanel.validate();
        messagePanel.repaint();
    }

    private void initializeActions() {
        actions.add(new AddMessageAction(model, undo));
        actions.add(new EditMessageAction(model, undo));
        actions.add(new DeleteMessageAction(model, undo));
        actions.add(new RedoAction(undo));
        actions.add(new UndoAction(undo));
    }

    @Override
    public void update(Observable observable, Object o) {
        printMessages();
    }
}
