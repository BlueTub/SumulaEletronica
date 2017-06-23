package com.projeto.sumula.sumulaeletronica.model;

import com.projeto.sumula.sumulaeletronica.enumeration.Tipo;

/**
 * Created by Pedro on 23/06/2017.
 */

public class Cadastro {

    private String nome;
    private String cpf;
    private Tipo tipo;
    private String registro;
    private Usuario usuario;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public String getRegistro() {
        return registro;
    }
    public void setRegistro(String registro) {
        this.registro = registro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
