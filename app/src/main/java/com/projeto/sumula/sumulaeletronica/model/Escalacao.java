package com.projeto.sumula.sumulaeletronica.model;

import java.util.List;

/**
 * Created by Pedro on 25/09/2016.
 */
public class Escalacao {

    private String posicoesTitulares;
    private String posicaoReservas;
    private List<Jogador> jogadors;

    public String getPosicoesTitulares() {
        return posicoesTitulares;
    }

    public void setPosicoesTitulares(String posicoesTitulares) {
        this.posicoesTitulares = posicoesTitulares;
    }

    public String getPosicaoReservas() {
        return posicaoReservas;
    }

    public void setPosicaoReservas(String posicaoReservas) {
        this.posicaoReservas = posicaoReservas;
    }

    public List<Jogador> getJogadors() {
        return jogadors;
    }

    public void setJogadors(List<Jogador> jogadors) {
        this.jogadors = jogadors;
    }
}
