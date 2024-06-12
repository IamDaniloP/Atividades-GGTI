package repository;

import domain.entities.Person;

import java.util.List;

public interface IPersonRepository {
    void registerPerson(Person person);
    void deletePerson(Person person);
    List<Person> getPersonList();
}
