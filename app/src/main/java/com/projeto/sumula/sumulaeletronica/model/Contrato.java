package com.projeto.sumula.sumulaeletronica.model;

import com.projeto.sumula.sumulaeletronica.enumeration.TipoContrato;

import java.util.Date;

/**
 * Created by Pedro on 25/09/2016.
 */

public class Contrato {

    private TipoContrato tipo;
    private int numero;
    private Date dataInicio;
    private Date dataTermino;
    private Jogador jogador;
    private Clube clube;

    public TipoContrato getTipo() {
        return tipo;
    }

    public void setTipo(TipoContrato tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "tipo=" + tipo +
                ", numero=" + numero +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", jogador=" + jogador +
                ", clube=" + clube +
                '}';
    }
}
