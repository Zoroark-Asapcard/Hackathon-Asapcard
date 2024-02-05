package com.zoroark.hackathonasapcard.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${spring.rabbitmq.host}")
	private String rabbitHost;

	@Value("${spring.rabbitmq.port}")
	private int rabbitPort;

	@Value("${spring.rabbitmq.username}")
	private String rabbitUsername;

	@Value("${spring.rabbitmq.password}")
	private String rabbitPassword;

	@Bean
    Queue ordersQueue() {
        return new Queue("orders", true); // true para tornar a fila durável
    }
	
	@Bean
	 Queue installmentQueue() {
		return new Queue("installmentQueue", true); // true para tornar a fila durável
	}

	@Bean
	 Queue personQueue() {
		return new Queue("personQueue", true); // true para tornar a fila durável
	}

	@Bean
	 Queue transactionQueue() {
		return new Queue("transactionQueue", true); // true para tornar a fila durável
	}

	@Bean
	RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener(RabbitAdmin rabbitAdmin) {
		return event -> rabbitAdmin.initialize();
	}

	@Bean
	CachingConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitHost, rabbitPort);
		connectionFactory.setUsername(rabbitUsername);
		connectionFactory.setPassword(rabbitPassword);
		return connectionFactory;
	}

	@Bean
	SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(jsonMessageConverter());
		return factory;
	}

	@Bean
	MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	MyMessageListener myMessageListener() {
		return new MyMessageListener();
	}
}