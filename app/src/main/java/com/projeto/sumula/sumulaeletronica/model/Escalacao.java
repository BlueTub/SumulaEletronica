package com.projeto.sumula.sumulaeletronica.model;

import java.util.List;

/**
 * Created by Pedro on 25/09/2016.
 */
public class Escalacao {

    private List<Jogador> titulares;
    private List<Jogador> reservas;
    private Clube clube;
    private String data;

    public List<Jogador> getTitulares() {
        return titulares;
    }
    public void setTitulares(List<Jogador> titulares) {
        this.titulares = titulares;
    }
    public List<Jogador> getReservas() {
        return reservas;
    }
    public void setReservas(List<Jogador> reservas) {
        this.reservas = reservas;
    }
    public Clube getClube() {
        return clube;
    }
    public void setClube(Clube clube) {
        this.clube = clube;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Escalacao [titulares=" + titulares + ", reservas=" + reservas + ", clube=" + clube + ", data=" + data
                + "]";
    }
}
