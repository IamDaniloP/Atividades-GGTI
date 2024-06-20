package com.danilo.atividade09.implementation.usecases;

import com.danilo.atividade09.domain.entities.Person;
import com.danilo.atividade09.domain.exceptions.PersonNotFoundException;
import com.danilo.atividade09.domain.usecases.IUpdatePersonUseCase;
import com.danilo.atividade09.implementation.repositories.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdatePersonUseCaseImpl implements IUpdatePersonUseCase {

    private IPersonRepository personRepository;

    public UpdatePersonUseCaseImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person execute(UUID personId, String name, String lastName, String email, Integer age) {
        Person person = personRepository.findPerson(personId);
        if (person == null) throw new PersonNotFoundException();

        person.setFullName(name, lastName);
        person.setEmail(email);
        person.setAge(age);
        personRepository.updatePerson(person);
        return person;
    }
}
