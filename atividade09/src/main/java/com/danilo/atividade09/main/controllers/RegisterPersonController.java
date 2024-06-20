package com.danilo.atividade09.main.controllers;

import com.danilo.atividade09.domain.entities.Person;
import com.danilo.atividade09.implementation.usecases.RegisterPersonUseCaseImpl;
import com.danilo.atividade09.main.controllers.erros.ErrorResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/register")
public class RegisterPersonController {

    @Autowired
    private RegisterPersonUseCaseImpl registerPersonUseCase;

    @PostMapping
    public ResponseEntity<ErrorResponse> create(@RequestBody @Valid CreatePersonDto personDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ErrorResponse errorResponse = new ErrorResponse();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorResponse.addError(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        Person person = new Person(personDto.name, personDto.lastName(), personDto.email(), personDto.age());
        registerPersonUseCase.execute(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    public record CreatePersonDto(@NotNull String name, @NotNull String lastName, @NotNull @Email String email, @NotBlank Integer age){}
}

