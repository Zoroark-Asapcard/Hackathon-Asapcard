package com.zoroark.hackathonasapcard.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.zoroark.hackathonasapcard.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

	
	
	boolean existsById(@Param("id") UUID id);

	public Optional<Transaction> findById(UUID id);

	public void deleteById(UUID id);

}