package com.danilo.atividade09.main.controllers;

import com.danilo.atividade09.domain.entities.Person;
import com.danilo.atividade09.implementation.usecases.GetPersonByIdUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("person")
public class GetPersonByIdController {

    @Autowired
    GetPersonByIdUseCaseImpl getPersonByIdUseCase;

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonByIdUseCase(@PathVariable UUID personId) {
        Person person = getPersonByIdUseCase.execute(personId);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }
}
