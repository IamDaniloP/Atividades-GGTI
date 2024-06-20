package com.danilo.atividade09.implementation.usecases;

import com.danilo.atividade09.domain.entities.Person;
import com.danilo.atividade09.domain.exceptions.PersonNotFoundException;
import com.danilo.atividade09.domain.usecases.IDeletePersonUseCase;
import com.danilo.atividade09.implementation.repositories.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeletePersonUseCaseImpl implements IDeletePersonUseCase {

    private IPersonRepository personRepository;

    public DeletePersonUseCaseImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void execute(UUID personId) {
        Person person = personRepository.findPerson(personId);
        if (person == null) {
            throw new PersonNotFoundException();
        }

        personRepository.deletePerson(person);
    }
}
