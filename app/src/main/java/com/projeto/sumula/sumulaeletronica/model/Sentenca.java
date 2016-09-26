package com.projeto.sumula.sumulaeletronica.model;

import java.util.Date;

/**
 * Created by Pedro on 25/09/2016.
 */

public class Sentenca {

    private double valorPena;
    private int pontos;
    private Date dataSentenca;
    private String motivo;
    private String descricao;
    private int qtdJogosACumprir;
    private Clube clube;
    private  Jogador jogador;
    private Arbitro arbitro;

    public double getValorPena() {
        return valorPena;
    }

    public void setValorPena(double valorPena) {
        this.valorPena = valorPena;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Date getDataSentenca() {
        return dataSentenca;
    }

    public void setDataSentenca(Date dataSentenca) {
        this.dataSentenca = dataSentenca;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdJogosACumprir() {
        return qtdJogosACumprir;
    }

    public void setQtdJogosACumprir(int qtdJogosACumprir) {
        this.qtdJogosACumprir = qtdJogosACumprir;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }
}
