package com.zoroark.hackathonasapcard.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {

	
	
    @RabbitListener(queues = "orders")
    public void receiveMessage(String message) {
        System.out.println("Received message :) ");
    }
}