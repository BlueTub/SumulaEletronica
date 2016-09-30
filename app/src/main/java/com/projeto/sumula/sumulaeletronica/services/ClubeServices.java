package com.projeto.sumula.sumulaeletronica.services;

import com.projeto.sumula.sumulaeletronica.model.Clube;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Pedro on 29/09/2016.
 */

public interface ClubeServices {

    @GET("listarTodos")
    Call<List<Clube>> listarTodos();
}
