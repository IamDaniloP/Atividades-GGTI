package com.danilo.atividade07.repository;

import com.danilo.atividade07.domain.entities.Person;

import java.util.List;

public interface IPersonRepository {
    Person registerPerson(Person person);
    void deletePerson(Person person);
    List<Person> getPersonList();
}
