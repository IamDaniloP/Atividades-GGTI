package com.danilo.atividade07.domain.usecases;

import com.danilo.atividade07.domain.entities.Person;

import java.util.List;

public interface IGetPersonListUseCase {
    List<Person> execute();
}
