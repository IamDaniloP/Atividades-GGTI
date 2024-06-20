package com.danilo.atividade09.domain.usecases;

import com.danilo.atividade09.domain.entities.Person;

public interface IRegisterPersonUseCase {
    Person execute(Person person);
}
