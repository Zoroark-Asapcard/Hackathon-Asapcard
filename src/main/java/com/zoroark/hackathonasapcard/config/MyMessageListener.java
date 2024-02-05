package com.zoroark.hackathonasapcard.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zoroark.hackathonasapcard.dto.Dto.InstallmentDto;
import com.zoroark.hackathonasapcard.dto.Dto.PersonDto;
import com.zoroark.hackathonasapcard.dto.Dto.TransactionDto;
import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.model.Person;
import com.zoroark.hackathonasapcard.model.Transaction;
import com.zoroark.hackathonasapcard.repository.InstallmentRepository;
import com.zoroark.hackathonasapcard.repository.PersonRepository;
import com.zoroark.hackathonasapcard.repository.TransactionRepository;

@Component
public class MyMessageListener {

    @Autowired    
    private TransactionRepository transactionRepository;

    @Autowired
    private InstallmentRepository installmentRepository;

    @Autowired
    private PersonRepository personRepository;

    @RabbitListener(queues = "orders")
    public void receiveMessage1(String message) {
        System.out.println("Received message: " + message);
    }

    @RabbitListener(queues = "installmentQueue")
    public void receiveMessage2(InstallmentRepository dto) {
        System.out.println("Received installment message: " + dto);
        // Converta o DTO da mensagem para a entidade Installment
        Installment installment = new Installment();
        installment.setInstallmentNumber(dto.getInstallmentNumber());
        installment.setValue(dto.getValue());

        // Persista no banco de dados
        installmentRepository.save(installment);
    }

    @RabbitListener(queues = "personQueue")
    public void receiveMessage3(PersonRepository dto) {
        System.out.println("Received person message: " + dto);
        // Converta o DTO da mensagem para a entidade Person
        Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());

        // Persista no banco de dados
        personRepository.save(person);
    }

    @RabbitListener(queues = "transactionQueue")
    public void receiveMessage4(TransactionRepository dto) {
        System.out.println("Received transaction message: " + dto);
        // Converta o DTO da mensagem para a entidade Transaction
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(dto.getTransactionDate());
        transaction.setAmount(dto.getAmount());

        // Persista no banco de dados
        transactionRepository.save(transaction);
    }
}
