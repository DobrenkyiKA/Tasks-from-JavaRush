package com.javarush.task.task30.task3008;

import java.io.Serializable;

public class Message implements Serializable {
    final private MessageType type;
    final private String data;

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public Message(MessageType type) {
        this.type = type;
        this.data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }
}
