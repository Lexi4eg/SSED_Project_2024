package com.example.swp_backend.kafka;
import com.example.swp_backend.message.Message;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.AdminClientConfig;

import java.util.Collections;
import java.util.Properties;

public class KafakTopics {
    public void createTopic(Message message) {
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        try (AdminClient admin = AdminClient.create(config)) {
            NewTopic newTopic = new NewTopic(message.getContent(), 1, (short) 1);
            admin.createTopics(Collections.singletonList(newTopic)).all().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}