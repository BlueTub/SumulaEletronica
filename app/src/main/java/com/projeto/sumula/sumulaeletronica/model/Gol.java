package com.projeto.sumula.sumulaeletronica.model;

import java.util.Date;

/**
 * Created by Pedro on 25/09/2016.
 */
public class Gol {

    private int qtd;
    private Date tempo;
    private Jogador jogador;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
