package com.gft.Biblioteca.dto.emprestimo;

import com.gft.Biblioteca.entities.Leitor;
import com.gft.Biblioteca.entities.Livro;
import lombok.Data;


import java.time.LocalDate;

@Data
public class ConsultaEmprestimo {

    public ConsultaEmprestimo(Long id, Leitor leitor, Livro livro, LocalDate ëmprestimo, LocalDate devolucao) {
        this.id = id;
        this.leitor = leitor;
        this.livro = livro;
        this.ëmprestimo = ëmprestimo;
        this.devolucao = devolucao;
    }

    private Long id;
    private Leitor leitor;
    private Livro livro;
    private LocalDate ëmprestimo;
    private LocalDate devolucao;


}
