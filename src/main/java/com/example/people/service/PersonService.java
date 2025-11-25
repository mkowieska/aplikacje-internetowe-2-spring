package com.example.people.service;

import com.example.people.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
//import org.springframework.web.context.annotation.SessionScope;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
@Service
//@SessionScope
public class PersonService {
    private final List<Person> people = new ArrayList<>();

    @PostConstruct
    public void init() {
        people.add(new Person("Jan", "Kowalski"));
        people.add(new Person("Maria", "Malinowska"));
    }

    public List<Person> getPeople() {
        return people;
    }

    public Optional<Person> getPerson(int index) {
        if (index < 0 || index >= people.size()) 
            return Optional.empty();
        return Optional.of(people.get(index));
    }

    public Person addPerson(Person p) {
        people.add(p);
        return p;
    }

    public Optional<Person> setPerson(int index, Person p) {
        if (index < 0 || index >= people.size()) 
            return Optional.empty();
        people.set(index, p);
        return Optional.of(p);
    }

    public Optional<Person> removePerson(int index) {
        if (index < 0 || index >= people.size()) 
            return Optional.empty();
        return Optional.of(people.remove(index));
    }
}