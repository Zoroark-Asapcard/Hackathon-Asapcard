package com.zoroark.hackathonasapcard;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zoroark.hackathonasapcard.service.DataPersistenceService;

import jakarta.annotation.PostConstruct;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HackathonasapcardApplication {

    private final static String QUEUE_NAME = "orders";

    private final DataPersistenceService dps;

    @Autowired
    public HackathonasapcardApplication(DataPersistenceService dps) {
        this.dps = dps;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HackathonasapcardApplication.class, args);
    }

    @PostConstruct
    public void consumeMessages() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // Define o prefetch count como 1 para receber apenas uma mensagem por vez
        channel.basicQos(1);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
            dps.persistData(message);

            // Confirma a recepção da mensagem
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };

        // Configura a resposta manual (manual acknowledgment)
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, deliverCallback, consumerTag -> {
        });
    }

}
