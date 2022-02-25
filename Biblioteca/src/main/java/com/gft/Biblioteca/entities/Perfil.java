package com.gft.Biblioteca.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity @Data
@Table(name = "perfil")
public class Perfil implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return getNome();
    }


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
