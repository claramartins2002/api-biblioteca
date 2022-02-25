package com.gft.Biblioteca.dto.leitor;

import lombok.Data;
import javax.persistence.Table;

@Data
@Table(name = "tb_endereco")
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;

    @Override
    public String toString() {
        return "CEP:'" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + localidade + '\'' +
                ", estado='" + uf + '\'' +
                '}';
    }
}
