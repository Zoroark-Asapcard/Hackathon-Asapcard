package com.zoroark.hackathonasapcard.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoroark.hackathonasapcard.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
