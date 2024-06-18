package com.danilo.atividade08.domain.exceptions;

public class PersonListEmptyException extends RuntimeException {
    public PersonListEmptyException() {
        super("PersonList is empty!");
    }
}
