package com.zoroark.hackathonasapcard.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoroark.hackathonasapcard.model.Person;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
