package com.danilo.atividade08.domain.usecases;

import com.danilo.atividade08.domain.entities.Person;

import java.util.List;

public interface IGetPersonListUseCase {
    List<Person> execute();
}
