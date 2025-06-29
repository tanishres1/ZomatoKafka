package com.zomato.org.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zomato.org.entity.FoodOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String TOPIC_NAME = "zomato-food-orders";
    public void sendOrder(FoodOrder order) {
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            kafkaTemplate.send(TOPIC_NAME, orderJson);
            System.out.println("✅ Order sent to Kafka: " + orderJson);
        } catch (JsonProcessingException e) {
            System.err.println("❌ Failed to serialize order: " + e.getMessage());
        }
    }
}
