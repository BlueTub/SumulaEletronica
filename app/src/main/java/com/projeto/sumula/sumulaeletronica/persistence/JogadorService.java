package com.projeto.sumula.sumulaeletronica.persistence;

import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hury_ on 23/09/2016.
 */

public interface JogadorService {
    //url base do web service
    public static final String BASE_URL= "http://192.168.1.14:8080/RestFul/";

    //url do metodo no web service
    @GET("jogador/listarTodos")
    Call<ListaJogadores> listCatalog();

}
