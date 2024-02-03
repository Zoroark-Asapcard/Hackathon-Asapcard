package com.zoroark.hackathonasapcard.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zoroark.hackathonasapcard.model.Installment;


public interface InstallmentRepository extends JpaRepository<Installment, UUID> {

		Optional<Installment> findById(UUID id);
        public boolean exists(UUID id);



}

