package com.zoroark.hackathonasapcard.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoroark.hackathonasapcard.model.Transaction;
import com.zoroark.hackathonasapcard.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> criarTransaction(@Valid @RequestBody Transaction transaction) {
        Transaction novaTransaction = transactionService.criarTransaction(transaction);
        return new ResponseEntity<>(novaTransaction, HttpStatus.CREATED);
    }

    // Outros endpoints da API para Transaction, se necessário

    @GetMapping
    public ResponseEntity<List<Transaction>> listarTransactions() {
        List<Transaction> transactions = transactionService.listarTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
