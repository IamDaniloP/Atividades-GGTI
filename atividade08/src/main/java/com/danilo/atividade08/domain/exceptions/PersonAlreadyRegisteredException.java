package com.danilo.atividade08.domain.exceptions;

public class PersonAlreadyRegisteredException extends RuntimeException {
    public PersonAlreadyRegisteredException() {
        super("Person already registered!");
    }
}
