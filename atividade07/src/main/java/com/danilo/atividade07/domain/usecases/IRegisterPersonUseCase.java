package com.danilo.atividade07.domain.usecases;

import com.danilo.atividade07.domain.entities.Person;

public interface IRegisterPersonUseCase {
    Person execute(Person person);
}
