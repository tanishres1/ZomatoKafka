package com.zomato.org.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @KafkaListener(topics = "zomato-orders", groupId = "zomato-group")
    public void consumeOrder(String message) {
        System.out.println("🛎️ Order Received from Kafka Topic: " + message);
        // You can write logic to save order to database, or notify restaurant
    }
}
