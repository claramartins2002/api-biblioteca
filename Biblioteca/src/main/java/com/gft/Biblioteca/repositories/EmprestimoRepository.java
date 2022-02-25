package com.gft.Biblioteca.repositories;

import com.gft.Biblioteca.entities.Emprestimo;
import com.gft.Biblioteca.entities.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Page<Emprestimo> findAll(Pageable pageable);
    Emprestimo findByLivro_id(Long livro);

}
