package com.danilo.atividade07.domain.exceptions;

public class PersonListEmptyException extends RuntimeException {
    public PersonListEmptyException() {
        super("PersonList is empty!");
    }
}
