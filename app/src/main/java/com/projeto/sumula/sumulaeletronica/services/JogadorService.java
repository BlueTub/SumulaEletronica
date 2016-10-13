package com.projeto.sumula.sumulaeletronica.services;

import com.projeto.sumula.sumulaeletronica.enumeration.BaseURL;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hury_ on 23/09/2016.
 */

public interface JogadorService {
    //url base do web service
    //public static final String BASE_URL= "http://192.168.1.14:8080/RestFul/";
    public static final String BASE_URL = BaseURL.URL.caminho;

    //url do metodo no web service
    @GET("jogador/listarTodos")
    Call<ListaJogadores> listCatalog();

    @GET("jogador/listaPorClubeId/{id}")
    Call<ListaJogadores> listaPorClube(@Path("id") int id );

    @GET("jogador/listaPorClubeNome/{nome}")
    Call<ListaJogadores> listaPorClubeNome(@Path("nome") String nome);

    @GET("jogador/listaPorPosicao/{posicao}")
    Call<ListaJogadores> listaPorPosicao(@Path("posicao") String posicao);

    @GET("jogador/listaPorUf/{UF}")
    Call<ListaJogadores> listaPorUF(@Path("UF") String UF);

    @GET("jogador/listaPorNome/{nome}")
    Call<ListaJogadores> listaPorNome(@Path("nome") String nome);

}
