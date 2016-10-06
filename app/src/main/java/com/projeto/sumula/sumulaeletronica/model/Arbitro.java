package com.projeto.sumula.sumulaeletronica.model;

import com.projeto.sumula.sumulaeletronica.enumeration.SituacaoJuiz;

import java.util.Date;

/**
 * Created by Pedro on 25/09/2016.
 */
public class Arbitro {

    private int id;
    private String nome;
    private int idade;
    private Date dataNascimento;
    private String UF;
    private String ufDescricao;
    private SituacaoJuiz situacao;
    private String situacaoDescritivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getUfDescricao() {
        return ufDescricao;
    }

    public void setUfDescricao(String ufDescricao) {
        this.ufDescricao = ufDescricao;
    }

    public SituacaoJuiz getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoJuiz situacao) {
        this.situacao = situacao;
    }

    public String getSituacaoDescritivo() {
        return situacaoDescritivo;
    }

    public void setSituacaoDescritivo(String situacaoDescritivo) {
        this.situacaoDescritivo = situacaoDescritivo;
    }
}


