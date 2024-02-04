package com.zoroark.hackathonasapcard.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoroark.hackathonasapcard.model.DataFromRabbitMQ;

@Service
public class RabbitMQConsumer {
	
	/*@Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = "orders")
    public void receiveMessage(Order order) {
    	
        // Manipular a mensagem recebida
        orderService.saveOrder(order);
    }
}*/

@Autowired
private DataProcessingService dataProcessingService;
    

    @RabbitListener(queues = "orders")
    public void receiveMessage(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            DataFromRabbitMQ data = objectMapper.readValue(message, DataFromRabbitMQ.class);

            // Chame o serviço para processar os dados e persistir nas tabelas
            dataProcessingService.processAndPersistData(data);
        } catch (JsonProcessingException e) {
            // Lide com erros de parsing do JSON
            e.printStackTrace();
        }
    }
}

