package com.at.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.at.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BillingConsumer {

    @KafkaListener(topics = "restaurant-orders", groupId = "billing-group")
    public void consumeOrder(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.readValue(message, Order.class);

        double total = order.getPrice() * order.getQuantity();

        System.out.println("🧾 BILL RECEIVED");
        System.out.println("Dish: " + order.getDishName());
        System.out.println("Quantity: " + order.getQuantity());
        System.out.println("Total: ₹" + total);
    }
}

