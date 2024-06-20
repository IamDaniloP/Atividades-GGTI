package com.danilo.atividade09.domain.exceptions;

public class PersonAlreadyRegisteredException extends RuntimeException {
    public PersonAlreadyRegisteredException() {
        super("Person already registered!");
    }
}
