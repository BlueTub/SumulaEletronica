package com.projeto.sumula.sumulaeletronica.persistence;

import android.util.Log;

import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;
import com.projeto.sumula.sumulaeletronica.services.JogadorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hury_ on 29/09/2016.
 */

public class JogadorJson {
    private static final String TAG = "hury";

    public void pesquisa(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JogadorService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JogadorService service = retrofit.create(JogadorService.class);
        Call<ListaJogadores> requestCatalog = service.listCatalog();

        requestCatalog.enqueue(new Callback<ListaJogadores>() {
            @Override
            public void onResponse(Call<ListaJogadores> call, Response<ListaJogadores> response) {
                Log.i(TAG, "INICIADO");
                if (response.isSuccessful()) {
                    //Requisição retornou com sucesso
                    ListaJogadores catalog = response.body();
                    for (Jogador j : catalog.jogador){

                        // Log.i(TAG,String.format("%s: %s", j.getNome(), j.getApelido()));
                        Log.i(TAG, j.toString());
                        Log.i(TAG, "----------");
                    }
                } else {

                    //Requisição retornou com erro
                    Log.i("TAG", "ERRO " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ListaJogadores> call, Throwable t) {
                //ERRO
                Log.e(TAG, "Erro: " + t.getMessage());
            }
        });
    }
}
