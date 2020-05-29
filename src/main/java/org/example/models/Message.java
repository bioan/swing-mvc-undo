package org.example.models;

import java.util.UUID;

public class Message {
    UUID uuid = UUID.randomUUID();
    private String sender;
    private String contents;

    public Message(String sender, String contents) {
        this.sender = sender;
        this.contents = contents;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getSender() {
        return sender;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
