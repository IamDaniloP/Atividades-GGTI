package com.danilo.atividade07.domain.exceptions;

public class InvalidNameException extends RuntimeException{
    public InvalidNameException(String message) {
        super(message);
    }
}
