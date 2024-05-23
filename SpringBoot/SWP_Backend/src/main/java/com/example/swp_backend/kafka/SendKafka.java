package com.example.swp_backend.kafka;

import com.example.swp_backend.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendKafka {

    private final KafkaService kafkaService;

    @Autowired
    public SendKafka(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    public void sendMessage() {
        Message message = new Message();
        message.setContent("Hello, Kafka!");
        String serialized = message.serialize();
        kafkaService.sendMessage("my-topic", serialized);
    }
}