package com.zoroark.hackathonasapcard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoroark.hackathonasapcard.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	public Optional<Transaction> findByIdList(Long transaction);

}