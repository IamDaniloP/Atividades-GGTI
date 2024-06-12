package com.danilo.atividade07.implementation.usecases;

import com.danilo.atividade07.domain.entities.Person;
import com.danilo.atividade07.domain.exceptions.PersonNotFoundException;
import com.danilo.atividade07.domain.usecases.IDeletePersonUseCase;
import com.danilo.atividade07.repository.IPersonRepository;

public class DeletePersonUseCaseImpl implements IDeletePersonUseCase {

    private IPersonRepository personRepository;

    public DeletePersonUseCaseImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void execute(Person person) {
        if (personRepository.getPersonList().isEmpty() || !personRepository.getPersonList().contains(person)) {
            throw new PersonNotFoundException();
        }

        personRepository.deletePerson(person);
    }
}
