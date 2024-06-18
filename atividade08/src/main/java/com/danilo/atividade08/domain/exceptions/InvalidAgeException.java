package com.danilo.atividade08.domain.exceptions;

public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException() {
        super("Invalid age exception!");
    }
}
