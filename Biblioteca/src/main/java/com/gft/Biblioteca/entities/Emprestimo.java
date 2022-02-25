package com.gft.Biblioteca.entities;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Data @Table(name = "tb_emprestimo")
public class Emprestimo {

    public Emprestimo() {
    }

    public Emprestimo(Long id, Leitor leitor, Livro livro, LocalDate emprestimo, LocalDate devolucao) {
        this.id = id;
        this.leitor = leitor;
        this.livro = livro;
        this.emprestimo =   emprestimo;
        this.devolucao = devolucao;
    }


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "leitor_id")
    private Leitor leitor;
    @OneToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;
    private LocalDate emprestimo;
    private LocalDate devolucao;





}
