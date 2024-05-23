package com.example.swp_backend.message;

public class Message {
    private Long id;
    private String content;
    private String sender;
    private String timestamp;

    public Message() {
    }

    public Message(Long id, String content, String sender, String receiver, String timestamp) {
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
