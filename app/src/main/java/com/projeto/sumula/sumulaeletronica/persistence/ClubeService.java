package com.projeto.sumula.sumulaeletronica.persistence;

import com.projeto.sumula.sumulaeletronica.model.ListaClubes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hury_ on 29/09/2016.
 */

public interface ClubeService {

    public static final String BASE_URL= "http://192.168.0.14:8080/RestFul/";

    @GET("clube/listarTodos")
    Call<ListaClubes> listCatalog();
}
