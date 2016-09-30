package com.projeto.sumula.sumulaeletronica.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Pedro on 25/09/2016.
 */

public class Clube implements Serializable{

    private long id;
    private String dataFundacao;
    private String nome;
  //  private String fundador;
  //  private String titulos;
  //  private int qtdJogadores;
    private String UF;
    private int caminho;
  //  private Estadio estadio;
  //  private List<Participacao> participacoes;


    public int getCaminho() {
        return caminho;
    }

    public void setCaminho(int caminho) {
        this.caminho = caminho;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(String dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}
