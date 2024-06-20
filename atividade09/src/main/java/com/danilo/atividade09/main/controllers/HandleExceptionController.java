package com.danilo.atividade09.main.controllers;

import com.danilo.atividade09.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidAgeException.class)
    private ResponseEntity<String> invalidAgeExceptionHandler(InvalidAgeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(InvalidEmailException.class)
    private ResponseEntity<String> invalidEmailExceptionHandler(InvalidEmailException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(InvalidNameException.class)
    private ResponseEntity<String> invalidNameExceptionHandler(InvalidNameException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(PersonAlreadyRegisteredException.class)
    private ResponseEntity<String> personAlreadyRegisteredExceptionHandler(PersonAlreadyRegisteredException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(PersonListEmptyException.class)
    private ResponseEntity<String> personListEmptyExceptionHandler(PersonListEmptyException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(PersonNotFoundException.class)
    private ResponseEntity<String> personNotFoundExceptionHandler(PersonNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
