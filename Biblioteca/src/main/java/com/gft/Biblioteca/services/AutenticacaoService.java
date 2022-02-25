package com.gft.Biblioteca.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gft.Biblioteca.dto.security.AutenticacaoForm;
import com.gft.Biblioteca.dto.security.tokenDto;
import com.gft.Biblioteca.entities.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Date;

@Service
public class AutenticacaoService {
    private AuthenticationManager authManager;
    @Lazy
    public AutenticacaoService(AuthenticationManager authManager){
        this.authManager = authManager;
    }
    @Value("${biblioteca.jwt.expiration}")
    private String expiration;
    @Value("${biblioteca.jwt.secret}")
    private String secret;
    @Value("${biblioteca.jwt.issuer}")
    private String issuer;


    public tokenDto autenticar(AutenticacaoForm authForm) throws AuthenticationException {
       Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(authForm.getEmail(), authForm.getSenha()));
        String token = gerarToken(authenticate);
    return new tokenDto(token);
    }


    private Algorithm criarAlgoritmo() {
        return Algorithm.HMAC256(secret);
    }
    private String gerarToken(Authentication authenticate) {
            Usuario principal = (Usuario)authenticate.getPrincipal();


        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return JWT.create().withIssuer(issuer).withExpiresAt(dataExpiracao)
                .withSubject(principal.getId().toString()).sign(this.criarAlgoritmo());
        }

        public boolean verificaToken(String token) {

            try {
                if (token == null)
                    return false;

                    JWT.require(this.criarAlgoritmo()).withIssuer(issuer).build().verify(token);

                return true;
            }
            catch (JWTVerificationException exception){
                return false;
            }
        }

        public Long retornarIdUsuario(String token){
        String subject =JWT.require(this.criarAlgoritmo()).withIssuer(issuer).build().verify(token).getSubject();

            return Long.parseLong(subject);
    }
}
