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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.repository.InstallmentRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/installment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InstallmentController {

	@Autowired
	private InstallmentRepository installmentRepository;

	@GetMapping
	public ResponseEntity<List<Installment>> getAll() {
		return ResponseEntity.ok(installmentRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Installment> getById(@PathVariable UUID id) {
		return installmentRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Installment> post(@Valid @RequestBody Installment installment) {
		return ResponseEntity.status(HttpStatus.CREATED).body(installmentRepository.save(installment));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Installment> put(@Valid @RequestBody Installment Transactions) {
		if (installmentRepository.existsById(Transactions.getId())) {
			return ResponseEntity.status(HttpStatus.OK).body(installmentRepository.save(Transactions));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "person not found!", null);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable UUID id) {
		Optional<Installment> installment = installmentRepository.findById(id);

		if (installment.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		installmentRepository.deleteById(id);
	}
}