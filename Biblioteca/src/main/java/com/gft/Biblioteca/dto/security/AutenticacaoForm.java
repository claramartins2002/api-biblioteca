package com.gft.Biblioteca.dto.security;

public class AutenticacaoForm {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String email;
    private String senha;

}
