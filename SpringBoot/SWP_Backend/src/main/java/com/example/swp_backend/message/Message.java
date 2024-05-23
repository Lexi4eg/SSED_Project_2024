package com.example.swp_backend.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
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



    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }


    public String getTimestamp() {
        return timestamp;
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

    public String serialize() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing message", e);
        }
    }

    public static Message deserialize(String serialized) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(serialized, Message.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing message", e);
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
