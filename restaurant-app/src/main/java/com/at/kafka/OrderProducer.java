package com.at.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.at.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "restaurant-orders";

    public void sendOrder(Order order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonOrder = mapper.writeValueAsString(order);
        kafkaTemplate.send(TOPIC, jsonOrder);
    }
}

