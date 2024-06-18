package com.danilo.atividade08.domain.usecases;

import com.danilo.atividade08.domain.entities.Person;

public interface IRegisterPersonUseCase {
    Person execute(Person person);
}
