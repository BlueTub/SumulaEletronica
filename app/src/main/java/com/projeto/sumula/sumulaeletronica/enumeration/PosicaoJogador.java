package com.projeto.sumula.sumulaeletronica.enumeration;

/**
 * Created by Pedro on 06/10/2016.
 */

public enum PosicaoJogador {

    ATACANTE("Atacante"), GOLEIRO("Goleiro");

    private String descricao;

    private PosicaoJogador(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
