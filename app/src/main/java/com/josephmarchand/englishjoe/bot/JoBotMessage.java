package com.josephmarchand.englishjoe.bot;

public class JoBotMessage {

    public enum Sender {
        USER,
        BOT
    }

    private final String message;
    private final Sender sender;
    private final long timestamp;

    public JoBotMessage(String message, Sender sender) {
        this.message = message;
        this.sender = sender;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMessage() {
        return message;
    }

    public Sender getSender() {
        return sender;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
