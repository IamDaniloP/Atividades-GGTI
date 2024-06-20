package com.danilo.atividade09.implementation.usecases;

import com.danilo.atividade09.domain.entities.Person;
import com.danilo.atividade09.domain.exceptions.PersonNotFoundException;
import com.danilo.atividade09.domain.usecases.IGetPersonByIdUseCase;
import com.danilo.atividade09.implementation.repositories.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetPersonByIdUseCaseImpl implements IGetPersonByIdUseCase {

    private IPersonRepository personRepository;

    public GetPersonByIdUseCaseImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person execute(UUID personId) {
        Person person = personRepository.findPerson(personId);
        if (person == null) throw new PersonNotFoundException();

        return person;
    }
}
