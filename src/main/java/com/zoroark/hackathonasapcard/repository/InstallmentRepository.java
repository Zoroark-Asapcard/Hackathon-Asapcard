package com.zoroark.hackathonasapcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface InstallmentRepository extends JpaRepository<InstallmentRepository, Long> {
	public List<InstallmentRepository> findAllByDescricaoContainingIgnoreCase(@Param("installmentNumber") Long installmentNumber);

}
