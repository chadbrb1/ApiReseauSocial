package com.apiRest.Gather.exception;

public class RessourceNotFoundException extends RuntimeException{
    public RessourceNotFoundException(String message){
        super(message);
    }
    public RessourceNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
