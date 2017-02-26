package com.projeto.sumula.sumulaeletronica.model;

import com.projeto.sumula.sumulaeletronica.enumeration.PosicaoJogador;
import com.projeto.sumula.sumulaeletronica.enumeration.UF;

import java.util.Date;

/**
 * Created by hury_ on 22/09/2016.
*/

public class Jogador {

    private int id;
    private String nome;
    private String apelido;
    private String datanasc;
    private double peso;
    private double altura;
    private String naturalidade;
    private UF uf;
    private PosicaoJogador posicao;

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
    public String getApelido() {
        return apelido;
    }
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    public String getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public String getNaturalidade() {
        return naturalidade;
    }
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }
    public UF getUf() {
        return uf;
    }
    public void setUf(UF uf) {
        this.uf = uf;
    }
    public PosicaoJogador getPosicao() {
        return posicao;
    }
    public void setPosicao(PosicaoJogador posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        return "Jogador [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", datanasc=" + datanasc + ", peso="
                + peso + ", altura=" + altura + ", naturalidade=" + naturalidade + ", uf=" + uf + ", posicao=" + posicao
                + "]";
    }
}
