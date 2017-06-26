package com.projeto.sumula.sumulaeletronica.model;

import com.projeto.sumula.sumulaeletronica.enumeration.SituacaoJuiz;
import com.projeto.sumula.sumulaeletronica.enumeration.UF;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pedro on 25/09/2016.
 */
public class Arbitro implements Serializable{

    private int id;
    private String nome;
    private Date dataNascimento;
    private UF UF;
    private String ufDescricao;
    private SituacaoJuiz situacao;
    private String situacaoDescritivo;
    private String caminhoimg;

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public com.projeto.sumula.sumulaeletronica.enumeration.UF getUF() {
        return UF;
    }

    public void setUF(com.projeto.sumula.sumulaeletronica.enumeration.UF UF) {
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

    public String getCaminhoimg() {
        return caminhoimg;
    }

    public void setCaminhoimg(String caminhoimg) {
        this.caminhoimg = caminhoimg;
    }
}


