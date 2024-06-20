package com.danilo.atividade09.domain.usecases;

import com.danilo.atividade09.domain.entities.Person;

import java.util.List;

public interface IGetPersonListUseCase {
    List<Person> execute();
}
