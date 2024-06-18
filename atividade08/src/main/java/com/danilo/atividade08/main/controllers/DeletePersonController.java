package com.danilo.atividade08.main.controllers;

import com.danilo.atividade08.implementation.usecases.DeletePersonUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("person/delete")
public class DeletePersonController {

    @Autowired
    DeletePersonUseCaseImpl deletePersonUseCase;

    @DeleteMapping("/{personId}")
    public ResponseEntity<String> delete(@PathVariable("personId")UUID personId) {
        deletePersonUseCase.execute(personId);
        return ResponseEntity.status(HttpStatus.OK).body("Operação realizada!");
    }
}
