package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
