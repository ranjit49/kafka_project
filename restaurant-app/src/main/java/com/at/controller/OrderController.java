package com.at.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.at.kafka.OrderProducer;
import com.at.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderProducer producer;

    @PostMapping
    public String placeOrder(@RequestBody Order order) throws JsonProcessingException {
        producer.sendOrder(order);
        return "✅ Order placed!";
    }
}

