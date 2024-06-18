package com.danilo.atividade08.implementation.repositories;

import com.danilo.atividade08.domain.entities.Person;

import java.util.List;
import java.util.UUID;

public interface IPersonRepository {
    Person registerPerson(Person person);
    void deletePerson(Person person);
    Person findPerson(UUID personId);
    List<Person> findAllPerson();
}
