package com.danilo.atividade07.domain.exceptions;

public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException() {
        super("Invalid age exception!");
    }
}
