package com.danilo.atividade09.domain.exceptions;

public class InvalidNameException extends RuntimeException{
    public InvalidNameException(String message) {
        super(message);
    }
}
