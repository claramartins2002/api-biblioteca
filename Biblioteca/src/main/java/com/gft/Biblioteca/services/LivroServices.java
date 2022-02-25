package com.gft.Biblioteca.services;

import com.gft.Biblioteca.entities.Livro;
import com.gft.Biblioteca.exception.EntityNotFoundException;
import com.gft.Biblioteca.repositories.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroServices {
   private final LivroRepository livroRepository;

    public LivroServices(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Page<Livro> listarLivros(Pageable pageable) {
        return livroRepository.findAll(pageable);
    }

    public Livro salvarLivro (Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro buscarLivro(Long id) {

        Optional<Livro> optional = livroRepository.findById(id);
        return optional.orElseThrow(() -> new EntityNotFoundException("Livro não encontrado !! :( "));
    }

    public Livro atualizarLivro(Livro livro, Long id) {
        Livro livroOriginal = this.buscarLivro(id);
        livro.setId(livroOriginal.getId());

        return livroRepository.save(livro);
    }


    public void excluirCliente(Long id) {
        Livro livroOriginal = this.buscarLivro(id);
        livroRepository.delete(livroOriginal);
    }


}
