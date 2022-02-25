package com.gft.Biblioteca.dto.leitor;

import com.gft.Biblioteca.entities.Leitor;

import java.time.LocalDate;

public class LeitorMapper {
    public static Leitor fromDto(RegistroLeitor dto) {
        return new Leitor(null, dto.getNome(),dto.getCep(), LocalDate.now(), LocalDate.now().plusDays(365) );
    }

    public static ConsultaLeitor fromEntity(Leitor leitor){
        return new ConsultaLeitor(leitor.getId(), leitor.getNome(), leitor.getCep(), leitor.getCadastro(), leitor.getExpiracao());
    }
}
