package org.example.models;

import java.util.ArrayList;
import java.util.Observable;

public class MessageStore extends Observable {
    private ArrayList<Message> messages = new ArrayList<>();

    public ArrayList<Message> getMessages(){
        return messages;
    }

    public void addMessage(Message message){
        messages.add(message);
        setChanged();
        notifyObservers();
    }

    public void addMessage(String sender, String contents){
        Message message = new Message(sender, contents);
        addMessage(message);
    }

    public void editMessage(Message message, String newContents){
        message.setContents(newContents);
        setChanged();
        notifyObservers();
    }

    public void deleteMessage(Message message){
        messages.remove(message);
        setChanged();
        notifyObservers();
    }
}
