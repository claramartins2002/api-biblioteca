package com.gft.Biblioteca.dto.emprestimo;

import com.gft.Biblioteca.entities.Emprestimo;

import java.time.LocalDate;

public class EmprestimoMapper {

    public static Emprestimo fromDto(RegistroEmprestimo dto) {
        return new Emprestimo(null, dto.getLeitor(), dto.getLivro(), LocalDate.now(), LocalDate.now().plusDays(15));
    }

    public static ConsultaEmprestimo fromEntity(Emprestimo emprestimo){
        return new ConsultaEmprestimo(emprestimo.getId(), emprestimo.getLeitor(), emprestimo.getLivro(), emprestimo.getEmprestimo(), emprestimo.getDevolucao());

    }
}
