package com.gft.Biblioteca.repositories;

import com.gft.Biblioteca.entities.Leitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {
    Page<Leitor> findAll(Pageable pageable);

}
