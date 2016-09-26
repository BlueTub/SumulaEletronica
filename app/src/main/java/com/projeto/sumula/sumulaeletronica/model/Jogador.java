package com.projeto.sumula.sumulaeletronica.model;

import java.util.List;

/**
 * Created by hury_ on 22/09/2016.
*/

public class Jogador {

    public String nome;
    public String apelido;
    private List<Inscricao> inscricoes;

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    /*private boolean valid;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
*/
}
