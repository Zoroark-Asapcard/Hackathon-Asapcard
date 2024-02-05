package com.zoroark.hackathonasapcard.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.model.Person;
import com.zoroark.hackathonasapcard.model.Transaction;

@Component
public class RabbitMQConsumer {

    @Autowired
    private InstallmentService installmentService;

    @Autowired
    private PersonService personService;

    @Autowired
    private TransactionService transactionService;

    @RabbitListener(queues = "installmentQueue")
    public void processInstallmentMessage(Installment installment) {
        System.out.println("Recebida mensagem do RabbitMQ para Installment: " + installment);
        installmentService.criarInstallment(installment);
    }

    @RabbitListener(queues = "personQueue")
    public void processPersonMessage(Person person) {
        System.out.println("Recebida mensagem do RabbitMQ para Person: " + person);
        personService.criarPerson(person);
    }

    @RabbitListener(queues = "transactionQueue")
    public void processTransactionMessage(Transaction transaction) {
        System.out.println("Recebida mensagem do RabbitMQ para Transaction: " + transaction);
        transactionService.criarTransaction(transaction);
    }
}