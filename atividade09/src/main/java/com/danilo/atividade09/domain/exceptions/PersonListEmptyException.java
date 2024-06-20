package com.danilo.atividade09.domain.exceptions;

public class PersonListEmptyException extends RuntimeException {
    public PersonListEmptyException() {
        super("PersonList is empty!");
    }
}
