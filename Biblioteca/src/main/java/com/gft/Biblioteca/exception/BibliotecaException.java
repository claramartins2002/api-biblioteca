package com.gft.Biblioteca.exception;

public class BibliotecaException extends RuntimeException{
    private String message;
    public BibliotecaException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}