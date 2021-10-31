package com.example.hibernatehw.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class DataProvider implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) {
        var random = new Random();
        var cities = List.of("Moscow", "Tula", "Saint-P");
        var names = List.of("Ivan", "Petr", "Sergey");
        var surnames = List.of("Ivanov", "Petrov", "Sidorov");

        IntStream.range(0, 5)
                .forEach(i -> {
                    var person = Person.builder()
                            .personId(PersonId.builder()
                                    .age(random.nextInt(33))
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surnames.get(random.nextInt(surnames.size())))
                                    .build())
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .phoneNumber(String.valueOf(random.nextInt(99999999)))
                            .build();
                    entityManager.persist(person);
                });
    }
}