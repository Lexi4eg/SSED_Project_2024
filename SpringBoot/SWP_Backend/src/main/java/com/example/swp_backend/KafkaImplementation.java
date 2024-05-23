package com.example.swp_backend;

import com.example.swp_backend.kafka.SendKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaImplementation implements CommandLineRunner {

    private final SendKafka sendKafka;

    @Autowired
    public KafkaImplementation(SendKafka sendKafka) {
        this.sendKafka = sendKafka;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaImplementation.class, args);
    }

    @Override
    public void run(String... args) {
        sendKafka.sendMessage();
    }
}