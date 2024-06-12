package com.danilo.atividade07.implementation.usecases;

import com.danilo.atividade07.domain.entities.Person;
import com.danilo.atividade07.domain.exceptions.PersonAlreadyRegisteredException;
import com.danilo.atividade07.domain.usecases.IRegisterPersonUseCase;
import com.danilo.atividade07.repository.IPersonRepository;

public class RegisterPersonUseCaseImpl implements IRegisterPersonUseCase {

    private IPersonRepository personRepository;

    public RegisterPersonUseCaseImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person execute(Person person) {
        if (personRepository.getPersonList().contains(person)) {
            throw new PersonAlreadyRegisteredException();
        }

        personRepository.registerPerson(person);
        return person;
    }
}
