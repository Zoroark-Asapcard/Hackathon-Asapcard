package com.zoroark.hackathonasapcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoroark.hackathonasapcard.model.Transaction;
import com.zoroark.hackathonasapcard.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	public Transaction criarTransaction(Transaction transaction) {
	
		return transactionRepository.save(transaction);
	}

	public List<Transaction> listarTransactions() {
		return transactionRepository.findAll();
	}
}


