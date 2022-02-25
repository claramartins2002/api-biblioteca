package com.gft.Biblioteca.dto.leitor;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;

@Data
public class ConsultaLeitor {
    private ViaCepCtrl viaCepCtrl = new ViaCepCtrl();
    @Lazy
    public ConsultaLeitor(ViaCepCtrl viaCepCtrl) {
        this.viaCepCtrl = viaCepCtrl;
    }

    public ConsultaLeitor(Long id, String nome, String cep, LocalDate cadastro, LocalDate expiracao) {
        this.id = id;
        this.nome = nome;
        this.endereco = viaCepCtrl.doObterCep(cep);
        this.cadastro = cadastro;
        this.expiracao = expiracao;
    }

    private Long id;
    private String nome;
    private String endereco;
    private LocalDate cadastro;
    private LocalDate expiracao;
}
