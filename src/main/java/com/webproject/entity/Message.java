package com.webproject.entity;


import java.io.Serializable;

/**
 * Объектное представление сущности Message
 */
public class Message implements Serializable {
    private int messageId;
    private int chatId;
    private int sender;
    private String text;

    public Message(int chatId, int sender, String text) {

        this.chatId = chatId;
        this.sender = sender;
        this.text = text;
    }

    public int getMessageId() {
        return messageId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
