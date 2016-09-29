package com.projeto.sumula.sumulaeletronica.model;

import java.util.Date;

/**
 * Created by Pedro on 25/09/2016.
 */
public class Substituicao {

    private Date tempo;
    private Jogador jogadorEntrada;
    private Jogador jogadorSaida;

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    public Jogador getJogadorEntrada() {
        return jogadorEntrada;
    }

    public void setJogadorEntrada(Jogador jogadorEntrada) {
        this.jogadorEntrada = jogadorEntrada;
    }

    public Jogador getJogadorSaida() {
        return jogadorSaida;
    }

    public void setJogadorSaida(Jogador jogadorSaida) {
        this.jogadorSaida = jogadorSaida;
    }
}
