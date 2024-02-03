package com.zoroark.hackathonasapcard.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.repository.InstallmentRepository;

public class InstallmentController{
	

	@Autowired
	private InstallmentRepository installmentRepository;
	
	@GetMapping
	public ResponseEntity<List<InstallmentRepository>> getAll() {
		return ResponseEntity.ok(installmentRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Installment> getById(@PathVariable UUID id) {
		return installmentRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
}