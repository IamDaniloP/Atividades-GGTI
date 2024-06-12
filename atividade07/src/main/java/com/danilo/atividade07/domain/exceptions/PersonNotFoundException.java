package com.danilo.atividade07.domain.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException() {
        super("Person not found exception!");
    }
}
