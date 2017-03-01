package com.projeto.sumula.sumulaeletronica.persistence;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.projeto.sumula.sumulaeletronica.enumeration.BaseURL;
import com.projeto.sumula.sumulaeletronica.enumeration.PosicaoJogador;
import com.projeto.sumula.sumulaeletronica.enumeration.UF;
import com.projeto.sumula.sumulaeletronica.fragments.FragmentJogador;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;
import com.projeto.sumula.sumulaeletronica.services.JogadorService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hury_ on 29/09/2016.
 */

public class JogadorJson {//extends AsyncTask<Void, Void, ListaJogadores> {

    private Context context;
    private RequestQueue requestQueue;
    private List<Jogador> listaJogadores = new ArrayList<Jogador>();


     public JogadorJson (Context context){
         this.context = context;
     }


    public List<Jogador> listaTodosJogadores(){

        //REQUISIÇÃO PELO VOLLEY

        requestQueue = Volley.newRequestQueue(context);

        //Requisição do Web Service
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, BaseURL.URL.caminho + "jogador/listarTodos", null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //cria um Array com todos jogadores do banco
                            JSONArray jsonArray = response.getJSONArray("jogador");

                            //for para percorrer o array
                            for (int i = 0; i < jsonArray.length(); i++){

                                //transforma em objeto
                                JSONObject jogadores = jsonArray.getJSONObject(i);
                                Jogador j = new Jogador();
                                j.setNome(jogadores.getString("nome"));
                                j.setAltura(jogadores.getDouble("altura"));
                                j.setApelido(jogadores.getString("apelido"));
                                j.setDatanasc(jogadores.getString("datanasc"));
                                j.setId(jogadores.getInt("id"));
                                j.setNaturalidade(jogadores.getString("naturalidade"));
                                j.setPeso(jogadores.getDouble("peso"));
                                j.setPosicao(PosicaoJogador.valueOf(jogadores.getString("posicao")));
                                j.setUf(UF.valueOf(jogadores.getString("uf")));
                                j.setImg(BaseURL.URL.caminho + "imagem/foto/" + j.getId());
                                listaJogadores.add(j);
                            }

                            //for para mostrar os nomes dos jogadores no console
                            for (Jogador j : listaJogadores) {
                                Log.d("Retorno", j.getNome());
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                //Erro na requisição
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d("Error.Response", volleyError.getMessage().toString());
                    }
                }
        );

        requestQueue.add(getRequest);
        return listaJogadores;
    }

    public void listaJogadorPorNome(String nome){

    }


//    private Context context;
//    public ProgressDialog dialog;
//    public onResponseRetrofitListenner listenner;
//    private Clube clube;
//    private String pesquisa;
//    private String tipo;
//
//
//    public JogadorJson(Context context, Clube clube, String tipo, String pesquisa, onResponseRetrofitListenner listenner) {
//        this.context = context;
//        this.clube = clube;
//        this.tipo = tipo;
//        this.pesquisa = pesquisa;
//        this.listenner = listenner;
//    }
//
//    @Override
//    protected void onPreExecute() {
//        dialog = ProgressDialog.show(context, "Consumindo o web service",
//                "Aguarde", true, true);
//    }
//
//    @Override
//    protected void onPostExecute(ListaJogadores listaJogadores) {
//        listenner.responseJogadores(listaJogadores);
//        dialog.dismiss();
//    }
//
//    @Override
//    protected ListaJogadores doInBackground(Void... params) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(JogadorService.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        final JogadorService service = retrofit.create(JogadorService.class);
//        Call<ListaJogadores> listaJogadoresCall = null;
//
//        if (pesquisa.equalsIgnoreCase("id")){
//            listaJogadoresCall = service.listaPorClube(clube.getId());
//        }else if (pesquisa.equalsIgnoreCase("clube")){
//            //listaJogadoresCall = service.listaPorClubeNome(tipo);
//        }else if (pesquisa.equalsIgnoreCase("posicao")){
//            listaJogadoresCall = service.listaPorPosicao(tipo); //TODO
//        }else if (pesquisa.equalsIgnoreCase("uf")){
//            listaJogadoresCall = service.listaPorUF(tipo);//TODO
//        }else if (pesquisa.equalsIgnoreCase("nome")) {
//            Log.i("NOME", tipo);
//            listaJogadoresCall = service.listaPorNome(tipo);//TODO
//        }
//
//        try {
//            ListaJogadores listaJogadores = listaJogadoresCall.execute().body();
//
//            for (Jogador j : listaJogadores.jogador){
//                Log.i("TAG", j.getNome());
//            }
//
//            return listaJogadores;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public interface onResponseRetrofitListenner {
//        void responseJogadores(ListaJogadores listaJogadores);
//    }

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
