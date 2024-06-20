package com.danilo.atividade09.main.controllers;

import com.danilo.atividade09.domain.entities.Person;
import com.danilo.atividade09.implementation.usecases.UpdatePersonUseCaseImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("person/update")
public class UpdatePersonController {

    @Autowired
    UpdatePersonUseCaseImpl updatePersonUseCase;

    @PutMapping("/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable UUID personId, @Valid UpdatePersonDto updatePersonDto) {

        Person person = updatePersonUseCase.execute(personId,updatePersonDto.name, updatePersonDto.lastName, updatePersonDto.email, updatePersonDto.age);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    public record UpdatePersonDto(@NotNull String name, @NotNull String lastName, @NotNull @Email String email, @NotBlank Integer age){}
}
