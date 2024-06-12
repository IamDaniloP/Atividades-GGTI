package com.danilo.atividade07.domain.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Invalid email exception!");
    }
}
