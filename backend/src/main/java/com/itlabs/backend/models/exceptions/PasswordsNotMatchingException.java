package com.itlabs.backend.models.exceptions;

public class PasswordsNotMatchingException extends RuntimeException{
    public PasswordsNotMatchingException() {
        super(String.format("Passwords not matching exception"));
    }
}
