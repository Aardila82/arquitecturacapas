package com.relacionales.persona.Excepciones;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
