package com.danilo.atividade08.implementation.usecases;

import com.danilo.atividade08.domain.entities.Person;
import com.danilo.atividade08.domain.exceptions.PersonListEmptyException;
import com.danilo.atividade08.domain.usecases.IGetPersonListUseCase;
import com.danilo.atividade08.implementation.repositories.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonListUseCaseImpl implements IGetPersonListUseCase {

    private IPersonRepository personRepository;

    public GetPersonListUseCaseImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> execute() {

        if (personRepository.findAllPerson().isEmpty()) {
            throw new PersonListEmptyException();
        }

        return personRepository.findAllPerson();
    }
}
