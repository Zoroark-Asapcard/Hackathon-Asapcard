package com.zoroark.hackathonasapcard.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoroark.hackathonasapcard.model.Installment;

public interface InstallmentRepository extends JpaRepository<Installment, UUID> {
	
	
}