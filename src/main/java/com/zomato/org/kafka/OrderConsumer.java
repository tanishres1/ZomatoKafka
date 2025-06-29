package com.zomato.org.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zomato.org.entity.FoodOrder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "zomato-food-orders", groupId = "zomato-group")
    public void consumeOrder(ConsumerRecord<String, String> record) {
        try {
            String orderJson = record.value();
            FoodOrder order = objectMapper.readValue(orderJson, FoodOrder.class);
            System.out.println("🍽️ Received order from Kafka: " + order);
        } catch (Exception e) {
            System.err.println("❌ Failed to deserialize Kafka message: " + e.getMessage());
        }
    }
}
