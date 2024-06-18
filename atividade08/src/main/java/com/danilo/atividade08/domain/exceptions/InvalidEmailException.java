package com.danilo.atividade08.domain.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Invalid email exception!");
    }
}
