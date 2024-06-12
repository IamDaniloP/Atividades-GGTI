package repository.impl;

import domain.entities.Person;
import repository.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPersonRepository {
    private List<Person> personList;

    public PersonRepository() {
        this.personList = new ArrayList<>();
    }

    @Override
    public void registerPerson(Person person) {
        if (personList.isEmpty() || !personList.contains(person)) {
            personList.add(person);
        } else {
            System.out.println("Person already register.");
        }

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
