package com.itlabs.backend.models.exceptions;


public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException() {
        super(String.format("The username already exists exception!"));
    }
}
