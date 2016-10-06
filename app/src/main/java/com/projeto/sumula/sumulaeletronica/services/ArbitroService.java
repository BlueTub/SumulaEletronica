package com.projeto.sumula.sumulaeletronica.services;

import com.projeto.sumula.sumulaeletronica.enumeration.BaseURL;
import com.projeto.sumula.sumulaeletronica.model.ListaArbitros;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Pedro on 05/10/2016.
 */

public interface ArbitroService {

    public static final String BASE_URL = BaseURL.URL.caminho;

    @GET("arbitro/listarTodos") //TODO
    Call<ListaArbitros> listarTodos();


}
