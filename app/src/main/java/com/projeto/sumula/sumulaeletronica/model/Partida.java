package com.projeto.sumula.sumulaeletronica.model;

import java.util.Date;

/**
 * Created by Pedro on 25/09/2016.
 */

public class Partida {

    private Date data;
    private Date hora;
    private Estadio estadio;
    private Arbitro arbitro;
    private Escalacao escalacao;
    private Sumula sumula;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Escalacao getEscalacao() {
        return escalacao;
    }

    public void setEscalacao(Escalacao escalacao) {
        this.escalacao = escalacao;
    }

    public Sumula getSumula() {
        return sumula;
    }

    public void setSumula(Sumula sumula) {
        this.sumula = sumula;
    }
}
