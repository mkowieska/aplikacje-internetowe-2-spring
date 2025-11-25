package com.example.people.rest;

import com.example.people.model.Person;
import com.example.people.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonRestController {
    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping("/{index}")
    public ResponseEntity<Person> getPerson(@PathVariable int index) {
        return personService.getPerson(index)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person p) {
        Person created = personService.addPerson(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{index}")
    public ResponseEntity<Person> updatePerson(@PathVariable int index, @RequestBody Person p) {
        return personService.setPerson(index, p)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> deletePerson(@PathVariable int index) {
        return personService.removePerson(index)
        .map(removed -> ResponseEntity.noContent().<Void>build())
        .orElse(ResponseEntity.notFound().build());
    }
}