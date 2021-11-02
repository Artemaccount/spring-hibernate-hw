package com.example.hibernatehw.service;


import com.example.hibernatehw.model.Person;
import com.example.hibernatehw.repository.PersonCrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonCrudService {
    private final PersonCrudRepository repository;

    public PersonCrudService(PersonCrudRepository repository) {
        this.repository = repository;
    }

    public List<Person> findByCityOfLiving(String city) {
        return repository.findByCityOfLiving(city);
    }

    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return repository.findPersonByPersonId_NameAndAndPersonId_Surname(name, surname);
    }

    public List<Person> findByAgeLessThanOrderBy(int age) {
        return repository.findAllByPersonId_AgeLessThanOrderByPersonId_Age(age);
    }
}