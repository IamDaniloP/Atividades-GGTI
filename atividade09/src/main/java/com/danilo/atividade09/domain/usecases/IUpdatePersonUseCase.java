package com.danilo.atividade09.domain.usecases;

import com.danilo.atividade09.domain.entities.Person;

import java.util.UUID;

public interface IUpdatePersonUseCase {
    Person execute(UUID personId, String name, String lastName, String email, Integer age);
}
