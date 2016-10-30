package com.projeto.sumula.sumulaeletronica.enumeration;

/**
 * Constante da situação de um juiz
 * Created by Pedro on 06/10/2016.
 */
public enum SituacaoJuiz {

    DISPONIVEL("Disponível"),
    SUSPENSO("Suspenso - Devido a punição pelo STJD");

    private String descricao;

    SituacaoJuiz(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
