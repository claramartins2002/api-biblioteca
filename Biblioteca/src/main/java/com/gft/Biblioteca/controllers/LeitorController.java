package com.gft.Biblioteca.controllers;

import com.gft.Biblioteca.dto.leitor.ConsultaLeitor;
import com.gft.Biblioteca.dto.leitor.LeitorMapper;
import com.gft.Biblioteca.dto.leitor.RegistroLeitor;
import com.gft.Biblioteca.entities.Leitor;
import com.gft.Biblioteca.services.LeitorServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/leitores")
@Api(tags = "Leitor")
public class LeitorController {
    private final LeitorServices leitorServices;

    public LeitorController(LeitorServices leitorServices) {
        this.leitorServices = leitorServices;
    }

    @GetMapping
    @ApiOperation(value = "Ver todos os leitores cadastrados")
public ResponseEntity<Page<ConsultaLeitor>> Ver_todos_os_Leitores(@PageableDefault() Pageable pageable) {

        return ResponseEntity.ok(leitorServices.listarLeitores(pageable).map(LeitorMapper::fromEntity));

    }

    @PostMapping
    @ApiOperation(value = "Cadastrar um novo leitor")
    public ResponseEntity<ConsultaLeitor> cadastrar_leitor(@RequestBody RegistroLeitor leitor) {
        Leitor leitorSalvo = leitorServices.salvarLeitor(LeitorMapper.fromDto(leitor));
        return ResponseEntity.ok(LeitorMapper.fromEntity(leitorSalvo));
    }

    @GetMapping("{id}") //localhost:8080/v1/clientes/2
    @ApiOperation(value = "Buscar um leitor por id")
    public ResponseEntity<ConsultaLeitor> buscar_leitor(@PathVariable Long id) {


        Leitor leitor = leitorServices.buscarLeitor(id);
        return ResponseEntity.ok(LeitorMapper.fromEntity(leitor));

    }
    @PutMapping("{id}")
    @ApiOperation(value = "Editar o cadastro de um leitor por seu id")
    public ResponseEntity<ConsultaLeitor> editar_Leitor(@RequestBody RegistroLeitor dto, @PathVariable Long id) {
        try {
            Leitor leitor = leitorServices.atualizarLeitor(LeitorMapper.fromDto(dto), id);

            return ResponseEntity.ok(LeitorMapper.fromEntity(leitor));
        }
        catch(RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar o cadastro de um leitor por seu id")
    public ResponseEntity<ConsultaLeitor> deletar_leitor(@PathVariable Long id) {
        try {
            leitorServices.excluirLeitor(id);
            return ResponseEntity.ok().build();
        }
        catch(RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }

}




