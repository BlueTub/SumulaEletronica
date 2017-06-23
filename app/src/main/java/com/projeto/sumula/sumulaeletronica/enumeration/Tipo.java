package com.projeto.sumula.sumulaeletronica.enumeration;

/**
 * Created by Pedro on 23/06/2017.
 */

public enum Tipo {

    ARBITRO("Árbitro"), CBF("CBF"), STJD("STJD"), CLUBE("Clube");

    private String tipo;

    private Tipo(String tipo){
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
