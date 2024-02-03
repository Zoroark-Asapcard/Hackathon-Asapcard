package controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import model.Person;
import repository.PersonRepository;

@RequestMapping("/persons")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		return ResponseEntity.ok(personRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> getById(@PathVariable UUID id) {
		return personRepository.findById(id).map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Person> put(@PathVariable UUID id, @Valid @RequestBody Person updatedPerson) {
		if (personRepository.exists(id)) {
			updatedPerson.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(personRepository.save(updatedPerson));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person not found!", null);
	}


	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		if (personRepository.exists(id)) {
			personRepository.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Person> post(@Valid @RequestBody Person person) {
		return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.save(person));
	}
	
}