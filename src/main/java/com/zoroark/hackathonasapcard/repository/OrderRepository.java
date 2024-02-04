package com.zoroark.hackathonasapcard.repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.criteria.Order;

 
// OrderRepository.java
	public interface OrderRepository extends JpaRepository<Order, UUID> {
		
	
	public Optional<Order> findById(UUID id);
	}
	


