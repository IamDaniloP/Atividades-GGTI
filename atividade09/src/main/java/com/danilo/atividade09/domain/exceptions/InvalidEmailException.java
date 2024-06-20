package com.danilo.atividade09.domain.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Invalid email exception!");
    }
}
