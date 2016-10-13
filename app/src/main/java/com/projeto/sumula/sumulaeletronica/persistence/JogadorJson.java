package com.projeto.sumula.sumulaeletronica.persistence;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;
import com.projeto.sumula.sumulaeletronica.services.JogadorService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hury_ on 29/09/2016.
 */

public class JogadorJson extends AsyncTask<Void, Void, ListaJogadores> {

    private Context context;
    public ProgressDialog dialog;
    public onResponseRetrofitListenner listenner;
    private Clube clube;
    private String pesquisa;
    private String tipo;


    public JogadorJson(Context context, Clube clube, String tipo, String pesquisa, onResponseRetrofitListenner listenner) {
        this.context = context;
        this.clube = clube;
        this.tipo = tipo;
        this.pesquisa = pesquisa;
        this.listenner = listenner;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Consumindo o web service",
                "Aguarde", true, true);
    }

    @Override
    protected void onPostExecute(ListaJogadores listaJogadores) {
        listenner.responseJogadores(listaJogadores);
        dialog.dismiss();
    }

    @Override
    protected ListaJogadores doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JogadorService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final JogadorService service = retrofit.create(JogadorService.class);
        Call<ListaJogadores> listaJogadoresCall = null;

        if (pesquisa.equalsIgnoreCase("id")){
            listaJogadoresCall = service.listaPorClube(clube.getId());
        }else if (pesquisa.equalsIgnoreCase("clube")){
            listaJogadoresCall = service.listaPorClubeNome(clube.getNome());
        }else if (pesquisa.equalsIgnoreCase("posicao")){
            listaJogadoresCall = service.listaPorPosicao(tipo); //TODO
        }else if (pesquisa.equalsIgnoreCase("uf")){
            listaJogadoresCall = service.listaPorUF(tipo);//TODO
        }else if (pesquisa.equalsIgnoreCase("nome")) {
            listaJogadoresCall = service.listaPorNome(tipo);//TODO
        }

        try {
            ListaJogadores listaJogadores = listaJogadoresCall.execute().body();
            return listaJogadores;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface onResponseRetrofitListenner {
        void responseJogadores(ListaJogadores listaJogadores);
    }

//    public void pesquisa(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(JogadorService.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        JogadorService service = retrofit.create(JogadorService.class);
//        Call<ListaJogadores> requestCatalog = service.listCatalog();
//
//        requestCatalog.enqueue(new Callback<ListaJogadores>() {
//            @Override
//            public void onResponse(Call<ListaJogadores> call, Response<ListaJogadores> response) {
//                Log.i(TAG, "INICIADO");
//                if (response.isSuccessful()) {
//                    //Requisição retornou com sucesso
//                    ListaJogadores catalog = response.body();
//                    for (Jogador j : catalog.jogador){
//
//                        // Log.i(TAG,String.format("%s: %s", j.getNome(), j.getApelido()));
//                        Log.i(TAG, j.toString());
//                        Log.i(TAG, "----------");
//                    }
//                } else {
//
//                    //Requisição retornou com erro
//                    Log.i("TAG", "ERRO " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ListaJogadores> call, Throwable t) {
//                //ERRO
//                Log.e(TAG, "Erro: " + t.getMessage());
//            }
//        });
//    }
//
//    public void pesquisaJogadorClube(int id){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(JogadorService.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        JogadorService service = retrofit.create(JogadorService.class);
//        Call<ListaJogadores> jogadorCall = service.listaPorClube(id);
//
//        jogadorCall.enqueue(new Callback<ListaJogadores>() {
//            @Override
//            public void onResponse(Call<ListaJogadores> call, Response<ListaJogadores> response) {
//                if (response.isSuccessful()) {
//                    ViewJogador.jogadores = response.body();
//                } else {
//                    Log.i("TAG", "ERRO " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ListaJogadores> call, Throwable t) {
//                Log.e(TAG, "Erro: " + t.getMessage());
//            }
//        });
//    }


}
