package com.projeto.sumula.sumulaeletronica.enumeration;

/**
 * Created by hury_ on 03/10/2016.
 */

public enum BaseURL {

    //Caminho do WebService
    URL("http://192.168.0.14:8080/RestFul/");

    public String caminho;

    BaseURL(String caminho){
        this.caminho = caminho;
    }


}
