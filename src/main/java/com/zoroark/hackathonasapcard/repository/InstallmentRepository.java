package com.zoroark.hackathonasapcard.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.zoroark.hackathonasapcard.model.Installment;

public interface InstallmentRepository extends JpaRepository<Installment, UUID> {

	boolean existsById(@Param("id") UUID id);

	Optional<Installment> findById(UUID id);

	

}
