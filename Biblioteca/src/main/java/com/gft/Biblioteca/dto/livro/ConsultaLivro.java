package com.gft.Biblioteca.dto.livro;

import lombok.Data;

@Data
public class ConsultaLivro {

    //construtores

    public ConsultaLivro() {
    }

    public ConsultaLivro(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    private Long id;
    private String nome;
    private String descricao;
}
