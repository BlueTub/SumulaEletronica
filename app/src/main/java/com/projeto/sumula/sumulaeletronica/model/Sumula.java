package com.projeto.sumula.sumulaeletronica.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Pedro on 25/09/2016.
 */
public class Sumula {

    private Date primeioroTempoInicio;
    private Date primeiroTempoTermino;
    private Date tempoIntervalo;
    private Date segundoTempoInicio;
    private Date segundoTempoTermino;
    private Date primeiroTempoAcrescimos;
    private Date segundoTempoAcrescimos;
    private String descricao;
    private String observacao;
    private List<Cartao> cartoes;
    private List<Gol> gols;
    private List<Substituicao> substituicoes;

    public Date getPrimeioroTempoInicio() {
        return primeioroTempoInicio;
    }

    public void setPrimeioroTempoInicio(Date primeioroTempoInicio) {
        this.primeioroTempoInicio = primeioroTempoInicio;
    }

    public Date getPrimeiroTempoTermino() {
        return primeiroTempoTermino;
    }

    public void setPrimeiroTempoTermino(Date primeiroTempoTermino) {
        this.primeiroTempoTermino = primeiroTempoTermino;
    }

    public Date getTempoIntervalo() {
        return tempoIntervalo;
    }

    public void setTempoIntervalo(Date tempoIntervalo) {
        this.tempoIntervalo = tempoIntervalo;
    }

    public Date getSegundoTempoInicio() {
        return segundoTempoInicio;
    }

    public void setSegundoTempoInicio(Date segundoTempoInicio) {
        this.segundoTempoInicio = segundoTempoInicio;
    }

    public Date getSegundoTempoTermino() {
        return segundoTempoTermino;
    }

    public void setSegundoTempoTermino(Date segundoTempoTermino) {
        this.segundoTempoTermino = segundoTempoTermino;
    }

    public Date getPrimeiroTempoAcrescimos() {
        return primeiroTempoAcrescimos;
    }

    public void setPrimeiroTempoAcrescimos(Date primeiroTempoAcrescimos) {
        this.primeiroTempoAcrescimos = primeiroTempoAcrescimos;
    }

    public Date getSegundoTempoAcrescimos() {
        return segundoTempoAcrescimos;
    }

    public void setSegundoTempoAcrescimos(Date segundoTempoAcrescimos) {
        this.segundoTempoAcrescimos = segundoTempoAcrescimos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public List<Gol> getGols() {
        return gols;
    }

    public void setGols(List<Gol> gols) {
        this.gols = gols;
    }

    public List<Substituicao> getSubstituicoes() {
        return substituicoes;
    }

    public void setSubstituicoes(List<Substituicao> substituicoes) {
        this.substituicoes = substituicoes;
    }
}
