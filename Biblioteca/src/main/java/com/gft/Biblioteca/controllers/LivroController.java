package com.gft.Biblioteca.controllers;

import com.gft.Biblioteca.dto.livro.ConsultaLivro;
import com.gft.Biblioteca.dto.livro.LivroMapper;
import com.gft.Biblioteca.dto.livro.RegistroLivro;
import com.gft.Biblioteca.entities.Livro;
import com.gft.Biblioteca.services.LivroServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/livros")
@Api(tags = "Livro")
public class LivroController {
    private final LivroServices livroServices;

    public LivroController(LivroServices livroServices) {
        this.livroServices = livroServices;
    }

    @GetMapping
    @ApiOperation(value = "Ver todos os livros cadastrados")
    public ResponseEntity<Page<ConsultaLivro>> todos_os_livros(@PageableDefault() Pageable pageable) {

        return ResponseEntity.ok(livroServices.listarLivros(pageable).map(LivroMapper::fromEntity));

    }

    @PostMapping
    @ApiOperation(value = "Cadastrar um novo livro")
    public ResponseEntity<ConsultaLivro> cadastrar_Livro(@RequestBody RegistroLivro livro) {
        Livro livroSalvo = livroServices.salvarLivro(LivroMapper.fromDto(livro));
        return ResponseEntity.ok(LivroMapper.fromEntity(livroSalvo));
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Buscar um livro por seu id")
    public ResponseEntity<ConsultaLivro> buscar_livro_por_id(@PathVariable Long id) {


        Livro livro = livroServices.buscarLivro(id);
        return ResponseEntity.ok(LivroMapper.fromEntity(livro));

    }
    @PutMapping("{id}")
    @ApiOperation(value = "Editar um livro por seu id")
    public ResponseEntity<ConsultaLivro> editar_livro(@RequestBody RegistroLivro dto, @PathVariable Long id) {
        try {
            Livro livro = livroServices.atualizarLivro(LivroMapper.fromDto(dto), id);

            return ResponseEntity.ok(LivroMapper.fromEntity(livro));
        }
        catch(RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar um livro por seu id")
    public ResponseEntity<ConsultaLivro> deletar_livro(@PathVariable Long id) {
        try {
            livroServices.excluirCliente(id);
            return ResponseEntity.ok().build();
        }
        catch(RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }

}



