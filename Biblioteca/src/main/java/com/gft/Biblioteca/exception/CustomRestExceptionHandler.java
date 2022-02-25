package com.gft.Biblioteca.exception;

import com.gft.Biblioteca.dto.security.ApiErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler({BibliotecaException.class})
    public ResponseEntity<ApiErrorDto> handleLojaException(BibliotecaException ex, WebRequest request){
        String error ="Erro no sistema";
        ApiErrorDto apiErrorDto = new ApiErrorDto(ex.getMessage(), error, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ApiErrorDto>(apiErrorDto, new HttpHeaders(), apiErrorDto.getStatus());
    }
}
