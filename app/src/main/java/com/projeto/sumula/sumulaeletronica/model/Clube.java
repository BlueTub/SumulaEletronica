package com.projeto.sumula.sumulaeletronica.model;

import com.projeto.sumula.sumulaeletronica.enumeration.UF;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Pedro on 25/09/2016.
 */

public class Clube implements Serializable {

    // private long id;
    // private String dataFundacao;
    // private String nome;
    //  private String fundador;
    //  private String titulos;
    //  private int qtdJogadores;
    // private String UF;
    // private int caminho;
    // private Estadio estadio;
    //  private List<Participacao> participacoes;

    private int id;
    private String dataFundacao;
    private String nome;
    private Estadio estadio;
    private int imagem;
    private UF uf;
    private Tecnico tecnico;

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
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

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return "Clube [id=" + id + ", dataFundacao=" + dataFundacao + ", nome=" + nome + ", estadio=" + estadio
                + ", uf=" + uf + ", tecnico=" + tecnico + "]";
    }

}




