package com.gft.Biblioteca.services;

import com.gft.Biblioteca.entities.Leitor;
import com.gft.Biblioteca.exception.EntityNotFoundException;
import com.gft.Biblioteca.repositories.LeitorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeitorServices {
    private final LeitorRepository leitorRepository;

    public LeitorServices(LeitorRepository leitorRepository) {
        this.leitorRepository = leitorRepository;
    }

    public Page<Leitor> listarLeitores(Pageable pageable) {
        return leitorRepository.findAll(pageable);
    }

    public Leitor salvarLeitor (Leitor leitor) {
        return leitorRepository.save(leitor);
    }

    public Leitor buscarLeitor(Long id) {

        Optional<Leitor> optional =leitorRepository.findById(id);
        return optional.orElseThrow(() -> new EntityNotFoundException("Leitor não encontrado !! :( "));
    }

    public Leitor atualizarLeitor(Leitor leitor, Long id) {
        Leitor leitorOriginal = this.buscarLeitor(id);
        leitor.setId(leitorOriginal.getId());

        return leitorRepository.save(leitor);
    }


    public void excluirLeitor(Long id) {
        Leitor leitorOriginal = this.buscarLeitor(id);
        leitorRepository.delete(leitorOriginal);
    }


}
