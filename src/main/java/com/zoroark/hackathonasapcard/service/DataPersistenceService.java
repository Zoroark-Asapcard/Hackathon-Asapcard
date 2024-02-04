package com.zoroark.hackathonasapcard.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.model.Person;
import com.zoroark.hackathonasapcard.model.Transaction;
import com.zoroark.hackathonasapcard.repository.InstallmentRepository;
import com.zoroark.hackathonasapcard.repository.PersonRepository;
import com.zoroark.hackathonasapcard.repository.TransactionRepository;

@Service
public class DataPersistenceService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private InstallmentRepository installmentRepository;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

	public void persistData(String messages) {
		JSONObject message = new JSONObject(messages);
		System.out.println("JSON: "+ message);
		// Extraindo dados da mensagem
		String transactionId = message.getString("transactionId");
		String transactionDate = message.getString("transactionDate");
		String document = message.getString("document");
		String name = message.getString("name");
		int age = message.getInt("age");
		double transactionAmount = message.getDouble("transactionAmount");
		int numberOfInstallments = message.getInt("numberOfInstallments");
		

		// Logica para verificar se usuario ja existe ou não

		try {
			System.out.println("Criando usuario: ");
			// Logica para criar usuario
			Person person = new Person();
			person.setId(Long.parseLong(document));
			person.setName(name);
			person.setAge(age);
			System.out.println("Usuario: " + person);
			personRepository.save(person);

			// Logica para criar transação
			Transaction transaction = new Transaction();
			UUID uuidTransaction = UUID.fromString(transactionId);
			LocalDate dataFormated = LocalDate.parse(transactionDate, formatter);
			transaction.setId(uuidTransaction);
			transaction.setTransactionDate(dataFormated);
			transaction.setAmount(transactionAmount);
			transaction.setPerson(person);
			System.out.println("Transação: " + transaction);
			transactionRepository.save(transaction);

			double installmentValor = (transactionAmount / numberOfInstallments);
			// Logica para criar installment
			for (int i = 1; i <= numberOfInstallments; i++) {
				Installment installment = new Installment();
				installment.setId(UUID.randomUUID());
				installment.setInstallmentNumber(i);
				installment.setValue(installmentValor);
				installment.setTransaction(transaction);
				System.out.println("installment: " + installment);
				installmentRepository.save(installment);
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao converter a string para UUID: " + e.getMessage());
		}

	}
}
