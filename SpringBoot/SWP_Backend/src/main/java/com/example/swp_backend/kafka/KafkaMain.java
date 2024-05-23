package com.example.swp_backend.kafka;

import com.example.swp_backend.message.Message;

public class KafkaMain {
    public static void main(String[] args) {
        KafakTopics kafakTopics = new KafakTopics();
        Message message = new Message();
        kafakTopics.createTopic(message);
    }
}
