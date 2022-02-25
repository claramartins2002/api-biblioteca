package com.gft.Biblioteca.dto.emprestimo;

import com.gft.Biblioteca.entities.Leitor;
import com.gft.Biblioteca.entities.Livro;
import lombok.Data;

@Data
public class RegistroEmprestimo {

    public RegistroEmprestimo(Leitor leitor, Livro livro) {
        this.leitor = leitor;
        this.livro = livro;
    }

    private Leitor leitor;
    private Livro livro;

}
