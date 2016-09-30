package com.projeto.sumula.sumulaeletronica.persistence;

import android.util.Log;

import com.projeto.sumula.sumulaeletronica.model.Clube;
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
    private static final String TAG = "hury";

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
                Log.i(TAG, "INICIADO");
                if (response.isSuccessful()) {
                    //Requisição retornou com sucesso
                    ListaClubes catalog = response.body();
                    for (Clube c : catalog.clube){

                        // Log.i(TAG,String.format("%s: %s", j.getNome(), j.getApelido()));
                        Log.i(TAG, c.toString());
                        Log.i(TAG, "----------");
                    }
                } else {

                    //Requisição retornou com erro
                    Log.i("TAG", "ERRO " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ListaClubes> call, Throwable t) {
                //ERRO
                Log.e(TAG, "Erro: " + t.getMessage());
            }
        });
    }

}
