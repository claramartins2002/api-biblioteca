package com.gft.Biblioteca.controllers;

import com.gft.Biblioteca.dto.security.AutenticacaoForm;
import com.gft.Biblioteca.dto.security.tokenDto;
import com.gft.Biblioteca.services.AutenticacaoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("v1/auth")
@Api(tags = "Geração de token - Para testes em Postman")

public class AutenticacaoController {
    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public ResponseEntity<tokenDto> Autenticar(@RequestBody AutenticacaoForm authForm){
            try {
                return ResponseEntity.ok(autenticacaoService.autenticar(authForm));

            }
            catch (AuthenticationException ae){
                ae.printStackTrace();
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
    }

}
