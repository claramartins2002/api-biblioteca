package com.gft.Biblioteca.dto.livro;

import lombok.Data;

@Data
public class RegistroLivro {

    public RegistroLivro(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    public RegistroLivro(){}

    private String nome;
    private String descricao;
}
