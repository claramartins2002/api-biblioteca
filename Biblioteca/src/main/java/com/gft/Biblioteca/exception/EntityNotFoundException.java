package com.gft.Biblioteca.exception;

import com.gft.Biblioteca.dto.security.ApiErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class EntityNotFoundException extends BibliotecaException {

    public EntityNotFoundException(String message) {
        super(message);
    }
    @ExceptionHandler({BibliotecaException.class})
    public ResponseEntity<ApiErrorDto> handleLojaException(BibliotecaException ex, WebRequest request){
        String error ="Erro no sistema!!! :(";
        ApiErrorDto apiErrorDto = new ApiErrorDto(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ApiErrorDto>(apiErrorDto, new HttpHeaders(), apiErrorDto.getStatus());
    }

    @ExceptionHandler({BibliotecaException.class})
    public ResponseEntity<ApiErrorDto> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
        String error ="Recurso não encontrado!! :/";
        ApiErrorDto apiErrorDto = new ApiErrorDto(ex.getMessage(), error, HttpStatus.NOT_FOUND);
        return new ResponseEntity<ApiErrorDto>(apiErrorDto, new HttpHeaders(), apiErrorDto.getStatus());
    }
}
