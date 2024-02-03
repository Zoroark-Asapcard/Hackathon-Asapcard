package com.zoroark.hackathonasapcard.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.zoroark.hackathonasapcard.model.Person;

public interface PersonRepository extends JpaRepository<Person, UUID> {

	/*
	 * Retrieves a person based on the provided ID.
	 * 
	 * @param id The UUID uniquely identifying the person to be retrieved.
	 * 
	 * @return An Optional containing the found person or empty if not found.
	 */

	boolean existsById(@Param("id") UUID id);

	public Optional<Person> findById(UUID id);

	public void deleteById(UUID id);

}
