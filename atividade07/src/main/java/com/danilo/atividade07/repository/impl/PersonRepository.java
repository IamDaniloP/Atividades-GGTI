package com.danilo.atividade07.repository.impl;

import com.danilo.atividade07.domain.entities.Person;
import com.danilo.atividade07.repository.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPersonRepository {
    private List<Person> personList;

    public PersonRepository() {
        this.personList = new ArrayList<>();
    }

    @Override
    public Person registerPerson(Person person) {
        personList.add(person);
        return person;
    }

    @Override
    public void deletePerson(Person person) {
        if (personList.contains(person)) {
            personList.remove(person);
        } else {
            System.out.println("Person not found!");
        }
    }

    @Override
    public List<Person> getPersonList() {
        return this.personList;
    }
}
