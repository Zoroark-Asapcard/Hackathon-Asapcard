package com.zoroark.hackathonasapcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zoroark.hackathonasapcard.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
