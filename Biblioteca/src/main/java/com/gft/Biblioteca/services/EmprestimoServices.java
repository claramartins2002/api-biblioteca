package com.gft.Biblioteca.services;

import com.gft.Biblioteca.entities.Emprestimo;
import com.gft.Biblioteca.entities.Leitor;
import com.gft.Biblioteca.exception.EntityNotFoundException;
import com.gft.Biblioteca.repositories.EmprestimoRepository;
import com.gft.Biblioteca.repositories.LeitorRepository;
import com.gft.Biblioteca.repositories.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmprestimoServices {
    private final EmprestimoRepository emprestimoRepository;
    private final LeitorRepository leitorRepository;
    private final LivroRepository livroRepository;

    public EmprestimoServices(EmprestimoRepository emprestimoRepository, LeitorRepository leitorRepository, LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.leitorRepository = leitorRepository;
        this.livroRepository = livroRepository;
    }

    public Page<Emprestimo> listarEmprestimos(Pageable pageable) {
        return emprestimoRepository.findAll(pageable);
    }

    public Emprestimo salvarEmprestimo (Emprestimo emprestimo) {


        return emprestimoRepository.save(emprestimo);
    }
    public Emprestimo buscarEmprestimo(Long id) {

        Optional<Emprestimo> optional = emprestimoRepository.findById(id);
        return optional.orElseThrow(() -> new EntityNotFoundException("Empréstimo não encontrado !! :( "));
    }

    public Emprestimo atualizarEmprestimo(Emprestimo emprestimo, Long id) {
        Emprestimo emprestimoOriginal = this.buscarEmprestimo(id);
        emprestimo.setId(emprestimoOriginal.getId());

        return emprestimoRepository.save(emprestimo);
    }


    public void excluirEmprestimo(Long id) {
        Emprestimo emprestimoOriginal = this.buscarEmprestimo(id);
        emprestimoRepository.delete(emprestimoOriginal);
    }


}
