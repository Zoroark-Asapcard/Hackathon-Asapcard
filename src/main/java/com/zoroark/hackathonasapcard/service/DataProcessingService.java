package com.zoroark.hackathonasapcard.service;

import com.zoroark.hackathonasapcard.model.DataFromRabbitMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.model.Transaction;



@Service
public class DataProcessingService {
	
	@Autowired
	private TransactionService transactionService;

	@Autowired
	private InstallmentService installmentService;


	public void processAndPersistData(DataFromRabbitMQ data) {
		// Extraia os dados do objeto 'data' e insira nas tabelas apropriadas
		Transaction transaction = new Transaction();
		transaction.setTransactionDate(data.parseTransactionDate());
		transaction.setAmount(data.getAmount());

		Installment installment = new Installment();
		installment.setInstallmentNumber(data.getInstallmentNumber());
		installment.setAmount(data.getInstallmentAmount());

		// Persista nas tabelas

		transactionService.saveTransaction(transaction);
		installmentService.saveInstallment(installment);

		// Você pode adicionar lógica semelhante para a terceira tabela
	}
}
