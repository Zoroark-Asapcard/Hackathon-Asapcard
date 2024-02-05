package com.zoroark.hackathonasapcard.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoroark.hackathonasapcard.model.Person;
import com.zoroark.hackathonasapcard.service.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> criarPerson(@Valid @RequestBody Person person) {
        Person novaPerson = personService.criarPerson(person);
        return new ResponseEntity<>(novaPerson, HttpStatus.CREATED);

    }
}
