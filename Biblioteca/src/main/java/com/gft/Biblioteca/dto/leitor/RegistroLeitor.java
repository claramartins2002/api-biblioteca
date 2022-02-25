package com.gft.Biblioteca.dto.leitor;

import lombok.Data;

import java.time.LocalDate;
@Data
public class RegistroLeitor {

    public RegistroLeitor() {
    }

    public RegistroLeitor(String nome, String cep, LocalDate cadastro, LocalDate expiracao) {
        this.nome = nome;
        this.cep = cep;

    }

    private String nome;
    private String cep;

}
