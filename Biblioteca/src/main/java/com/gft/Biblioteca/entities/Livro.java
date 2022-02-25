package com.gft.Biblioteca.entities;

import lombok.Data;

import javax.persistence.*;

@Entity @Data @Table(name = "tb_livro")
public class Livro {

    public Livro(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    public Livro() {}

    public Livro(Long id) {
        this.id = id;
    }


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
}
