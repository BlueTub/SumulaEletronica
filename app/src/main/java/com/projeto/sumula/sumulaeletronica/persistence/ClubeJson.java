package com.projeto.sumula.sumulaeletronica.persistence;

import android.util.Log;

import com.projeto.sumula.sumulaeletronica.View.ViewClube;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hury_ on 29/09/2016.
 */

public class ClubeJson {

       public void pesquisa(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JogadorService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClubeService service = retrofit.create (ClubeService.class);
        Call<ListaClubes> requestCatalog = service.listCatalog();

        requestCatalog.enqueue(new Callback<ListaClubes>(){
            @Override
            public void onResponse(Call<ListaClubes> call, Response<ListaClubes> response) {
                if (response.isSuccessful()) {
                    ViewClube.listaClubes = response.body();
                } else {
                    Log.i("TAG", "ERRO " + response.code());
                }
            }


            public void onFailure(Call<ListaClubes> call, Throwable t) {
                Log.e("TAG", "Erro: " + t.getMessage());
            }
        });


    }
}
