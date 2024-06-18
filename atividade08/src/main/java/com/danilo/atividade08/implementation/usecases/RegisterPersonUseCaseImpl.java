package com.danilo.atividade08.implementation.usecases;

import com.danilo.atividade08.domain.entities.Person;
import com.danilo.atividade08.domain.exceptions.PersonAlreadyRegisteredException;
import com.danilo.atividade08.domain.usecases.IRegisterPersonUseCase;
import com.danilo.atividade08.implementation.repositories.IPersonRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterPersonUseCaseImpl implements IRegisterPersonUseCase {

    private IPersonRepository personRepository;

    public RegisterPersonUseCaseImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person execute(Person person) {
        if (personRepository.findAllPerson().contains(person)) {
            throw new PersonAlreadyRegisteredException();
        }

        personRepository.registerPerson(person);
        return person;
    }
}
