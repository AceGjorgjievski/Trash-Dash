package com.itlabs.backend.models.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException() {
        super(String.format("Invalid credentials"));
    }
}
