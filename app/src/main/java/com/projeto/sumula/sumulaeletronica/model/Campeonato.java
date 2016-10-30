package com.projeto.sumula.sumulaeletronica.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Pedro on 25/09/2016.
 */

public class Campeonato {

    private int id;
    private String nome;
    private Date ano;
    private List<Partida> partidas;
    private List<Inscricao> inscricoes;
    private List<Participacao> participacoes;

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = participacoes;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Campeonato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                ", partidas=" + partidas +
                ", inscricoes=" + inscricoes +
                ", participacoes=" + participacoes +
                '}';
    }
}
