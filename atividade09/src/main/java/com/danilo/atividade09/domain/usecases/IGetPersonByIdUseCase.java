package com.danilo.atividade09.domain.usecases;

import com.danilo.atividade09.domain.entities.Person;

import java.util.UUID;

public interface IGetPersonByIdUseCase {
    Person execute(UUID personId);
}
