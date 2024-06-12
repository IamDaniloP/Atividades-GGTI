package com.danilo.atividade07.implementation.usecases;

import com.danilo.atividade07.domain.entities.Person;
import com.danilo.atividade07.domain.exceptions.PersonListEmptyException;
import com.danilo.atividade07.domain.usecases.IGetPersonListUseCase;
import com.danilo.atividade07.repository.IPersonRepository;

import java.util.List;

public class GetPersonListUseCaseImpl implements IGetPersonListUseCase {

    private IPersonRepository personRepository;

    public GetPersonListUseCaseImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> execute() {
        if (personRepository.getPersonList().isEmpty()) {
            throw new PersonListEmptyException();
        }

        return personRepository.getPersonList();
    }
}
