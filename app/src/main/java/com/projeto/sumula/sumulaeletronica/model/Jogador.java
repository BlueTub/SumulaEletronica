package com.projeto.sumula.sumulaeletronica.model;

import java.util.Date;

/**
 * Created by hury_ on 22/09/2016.
*/

public class Jogador {

    private String nome;
    private String apelido;
    private String datanasc;
    private float peso;
    private float altura;
    private String naturalidade;
//

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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", datanasc=" + datanasc +
                ", peso=" + peso +
                ", altura=" + altura +
                ", naturalidade='" + naturalidade + '\'' +
                '}';
    }


}
