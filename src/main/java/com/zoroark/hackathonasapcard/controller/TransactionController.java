package com.zoroark.hackathonasapcard.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.zoroark.hackathonasapcard.model.Transaction;
import com.zoroark.hackathonasapcard.repository.TransactionRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;

	@GetMapping
	public ResponseEntity<List<Transaction>> getAll() {
		return ResponseEntity.ok(transactionRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaction> getById(@PathVariable Long id) {
		return transactionRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping("/create")
	public ResponseEntity<Transaction> post(@Valid @RequestBody Transaction Transactions) {

		return ResponseEntity.status(HttpStatus.CREATED).body(transactionRepository.save(Transactions));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Transaction> put(@Valid @RequestBody Transaction Transactions) {
		if (transactionRepository.existsById(Transactions.getId())) {
			return ResponseEntity.status(HttpStatus.OK).body(transactionRepository.save(Transactions));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "person not found!", null);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable UUID id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);

		if (transaction.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		transactionRepository.deleteById(id);
	}

}
