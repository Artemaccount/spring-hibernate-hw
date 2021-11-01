package com.example.hibernatehw.repository;

import com.example.hibernatehw.model.Person;
import com.example.hibernatehw.model.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonCrudRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLiving(String cityOfLiving);

    List<Person> findAllByPersonId_AgeLessThanOrderByPersonId_Age(int age);

    Optional<Person>  findPersonByPersonId_NameAndAndPersonId_Surname(String name, String surname);
}
