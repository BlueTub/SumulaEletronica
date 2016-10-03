package com.projeto.sumula.sumulaeletronica.services;

import com.projeto.sumula.sumulaeletronica.enumeration.BaseURL;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hury_ on 29/09/2016.
 */

public interface ClubeService {

    public static final String BASE_URL = BaseURL.URL.caminho;

    @GET("clube/listarTodos")
    Call<ListaClubes> listCatalog();
}
