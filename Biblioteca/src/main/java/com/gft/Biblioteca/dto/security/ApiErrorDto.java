package com.gft.Biblioteca.dto.security;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiErrorDto {
    private String message;

    public ApiErrorDto() {
    }

    public ApiErrorDto(String message, List<String> errors, HttpStatus status) {
        this.message = message;
        this.errors = errors;
        this.status = status;
    }
    public ApiErrorDto(String message, String error, HttpStatus status) {
        this.message = message;
        this.errors = Arrays.asList(error);
        this.status = status;
    }

    private List<String> errors;
    private HttpStatus status;

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
