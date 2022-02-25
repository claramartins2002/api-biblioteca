package com.gft.Biblioteca.dto.livro;

import com.gft.Biblioteca.entities.Livro;

public class LivroMapper {
    public static Livro fromDto(RegistroLivro dto) {
        return new Livro(null, dto.getNome(), dto.getDescricao());
    }

    public static ConsultaLivro fromEntity(Livro livro) {
        return new ConsultaLivro(livro.getId(), livro.getNome(), livro.getDescricao());
    }
}
