package com.example.hibernatehw.controller;

import com.example.hibernatehw.model.Person;
import com.example.hibernatehw.service.PersonCrudService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EntityController {
    private final PersonCrudService service;

    public EntityController(PersonCrudService service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return service.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return service.findByAgeLessThanOrderBy(age);
    }

    @GetMapping("/persons/by-nameandsurname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam("name") String name,
                                                       @RequestParam("surname") String surname) {
        return service.findByNameAndSurname(name, surname);
    }

}
