package com.danilo.atividade07.domain.exceptions;

public class PersonAlreadyRegisteredException extends RuntimeException {
    public PersonAlreadyRegisteredException() {
        super("Person already registered!");
    }
}
