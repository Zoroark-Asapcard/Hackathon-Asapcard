package com.zoroark.hackathonasapcard.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoroark.hackathonasapcard.model.Person;
import com.zoroark.hackathonasapcard.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person criarPerson(Person person) {
        // Lógica de validação ou processamento, se necessário
        return personRepository.save(person);
    }
}