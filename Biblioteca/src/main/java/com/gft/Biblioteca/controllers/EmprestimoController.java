package com.gft.Biblioteca.controllers;

import com.gft.Biblioteca.dto.emprestimo.ConsultaEmprestimo;
import com.gft.Biblioteca.dto.emprestimo.EmprestimoMapper;
import com.gft.Biblioteca.dto.emprestimo.RegistroEmprestimo;
import com.gft.Biblioteca.entities.Emprestimo;
import com.gft.Biblioteca.services.EmprestimoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/emprestimos")
@Api(tags = "Empréstimo")
public class EmprestimoController {
   private final EmprestimoServices emprestimoServices;

    public EmprestimoController(EmprestimoServices emprestimoServices) {
        this.emprestimoServices = emprestimoServices;
    }

    @GetMapping      @ApiOperation(value = "Ver todos os empréstimos realizados")
    public ResponseEntity<Page<ConsultaEmprestimo>> Emprestimos(@PageableDefault() Pageable pageable) {

        return ResponseEntity.ok(emprestimoServices.listarEmprestimos(pageable).map(EmprestimoMapper::fromEntity));

    }

    @PostMapping
    @ApiOperation(value = "Realizar novo empréstimo de livro")
    public ResponseEntity<ConsultaEmprestimo> novo_Emprestimo(@RequestBody RegistroEmprestimo emprestimo) {
        Emprestimo emprestimoSalvo = emprestimoServices.salvarEmprestimo(EmprestimoMapper.fromDto(emprestimo));
        return ResponseEntity.ok(EmprestimoMapper.fromEntity(emprestimoSalvo));
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Buscar empréstimo por id")
    public ResponseEntity<ConsultaEmprestimo> buscar_emprestimo_por_id(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoServices.buscarEmprestimo(id);
        return ResponseEntity.ok(EmprestimoMapper.fromEntity(emprestimo));
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Alterar um empréstimo")
    public ResponseEntity<ConsultaEmprestimo> editar_emprestimo(@RequestBody RegistroEmprestimo dto, @PathVariable Long id) {
        try {
            Emprestimo emprestimo = emprestimoServices.atualizarEmprestimo(EmprestimoMapper.fromDto(dto), id);

            return ResponseEntity.ok(EmprestimoMapper.fromEntity(emprestimo));
        }
        catch(RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Dar baixa em um empréstimo")
    public ResponseEntity<ConsultaEmprestimo> dar_baixa_em_emprestimo(@PathVariable Long id) {
        try {
            emprestimoServices.excluirEmprestimo(id);
            return ResponseEntity.ok().build();
        }
        catch(RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }

}




