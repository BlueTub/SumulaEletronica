package com.projeto.sumula.sumulaeletronica.model;

import com.projeto.sumula.sumulaeletronica.enumeration.UF;

import java.util.Date;

/**
 * Created by Pedro on 25/09/2016.
 */

public class Estadio {
    private String nome;
    private UF uf;
    private int capacidade;
    private String dataInauguracao;
    private String endereco;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public UF getUf() {
        return uf;
    }
    public void setUf(UF uf) {
        this.uf = uf;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    public String getDataInauguracao() {
        return dataInauguracao;
    }
    public void setDataInauguracao(String dataInauguracao) {
        this.dataInauguracao = dataInauguracao;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Estadio [nome=" + nome + ", uf=" + uf + ", capacidade=" + capacidade + ", dataInauguracao="
                + dataInauguracao + ", endereco=" + endereco + "]";
    }

}
