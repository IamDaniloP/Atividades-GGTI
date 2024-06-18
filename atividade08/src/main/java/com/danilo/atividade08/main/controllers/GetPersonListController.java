package com.danilo.atividade08.main.controllers;

import com.danilo.atividade08.domain.entities.Person;
import com.danilo.atividade08.implementation.usecases.GetPersonListUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class GetPersonListController {

    @Autowired
    GetPersonListUseCaseImpl getPersonListUseCase;

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        List<Person> personList = getPersonListUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(personList);
    }
}
