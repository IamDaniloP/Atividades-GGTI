package com.danilo.atividade08.infra.repositories.impl;

import com.danilo.atividade08.domain.entities.Person;
import com.danilo.atividade08.implementation.repositories.IPersonRepository;
import com.danilo.atividade08.infra.repositories.IPersonRepositoryJPA;
import com.danilo.atividade08.infra.repositories.schemas.PersonSchema;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PersonRepositoryJPA implements IPersonRepository {

    private final IPersonRepositoryJPA personRepository;

    public PersonRepositoryJPA(IPersonRepositoryJPA personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person registerPerson(Person person) {
        var personSchema = new PersonSchema(person.getId(), person.getFullName(), person.getEmail(), person.getAge());
        personRepository.save(personSchema);
        return person;
    }

    @Override
    public void deletePerson(Person person) {
        var personSchema = new PersonSchema(person.getId(), person.getFullName(), person.getEmail(), person.getAge());
        personRepository.delete(personSchema);
    }

    @Override
    public Person findPerson(UUID personId) {
        var personSchema = personRepository.findById(personId);
        if (personSchema.isPresent()) {
            return new Person(personSchema.get().getId(), personSchema.get().getFullName(), personSchema.get().getEmail(), personSchema.get().getAge());
        }
        return null;
    }

    @Override
    public List<Person> findAllPerson() {
        List<Person> personList = new ArrayList<>();
        for (PersonSchema personSchema : personRepository.findAll()) {
            var person = new Person(personSchema.getId(), personSchema.getFullName(), personSchema.getEmail(), personSchema.getAge());
            personList.add(person);
        }

        return personList;
    }
}
