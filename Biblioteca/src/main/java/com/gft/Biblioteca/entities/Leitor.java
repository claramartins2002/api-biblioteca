package com.gft.Biblioteca.entities;


import com.gft.Biblioteca.dto.leitor.Endereco;
import com.gft.Biblioteca.dto.leitor.ViaCepCtrl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Data @Table(name = "tb_leitor")
public class Leitor {
    //construtores

    public Leitor(Long id) {
        this.id = id;
    }

    public Leitor(Long id, String nome, String cep, LocalDate cadastro, LocalDate expiracao) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.cadastro = cadastro;
        this.expiracao = expiracao;
    }

    public Leitor() {
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cep;
    private LocalDate cadastro;
    private LocalDate expiracao;
}
