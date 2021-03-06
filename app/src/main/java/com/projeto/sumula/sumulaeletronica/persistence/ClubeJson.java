package com.projeto.sumula.sumulaeletronica.persistence;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.projeto.sumula.sumulaeletronica.enumeration.BaseURL;
import com.projeto.sumula.sumulaeletronica.enumeration.UF;
import com.projeto.sumula.sumulaeletronica.model.Clube;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hury_ on 29/09/2016.
 */

public class ClubeJson {//extends AsyncTask<Void, Void, ListaClubes>{

    private RequestQueue requestQueue;
    private List<Clube> listaClubes = new ArrayList<Clube>();
    private Context context;

    public ClubeJson (Context context){
        this.context = context;
    }

    public List<Clube> listaTodosClubes(){

        //REQUISIÇÃO PELO VOLLEY

        requestQueue = Volley.newRequestQueue(context);

        //Requisição do Web Service
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, BaseURL.URL.caminho + "clube/listarTodos", null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("clube");

                            for (int i = 0; i < jsonArray.length(); i++){

                                //transforma em objeto
                                JSONObject jogadores = jsonArray.getJSONObject(i);
                                Clube c = new Clube();
                                c.setNome(jogadores.getString("nome"));
                                c.setId(jogadores.getInt("id"));
                                c.setUf(UF.valueOf(jogadores.getString("uf")));
                                c.setImg(BaseURL.URL.caminho + "imagem/escudo/" + c.getId());

                                listaClubes.add(c);
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
        return listaClubes;
    }

//    private Context context;
//    public ProgressDialog dialog;
//    public onResponseRetrofitListenner listenner;
//
//    public ClubeJson(Context context, onResponseRetrofitListenner listenner) {
//        this.context = context;
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
//    protected void onPostExecute(ListaClubes listaClubes) {
//        listenner.responseClubes(listaClubes);
//        dialog.dismiss();
//    }
//
//    @Override
//    protected ListaClubes doInBackground(Void... params) {
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(JogadorService.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        final ClubeService service = retrofit.create(ClubeService.class);
//        Call<ListaClubes> requestCatalog = service.listCatalog();
//
//        try {
//            ListaClubes listaClubes = requestCatalog.execute().body();
//            return listaClubes;
//        } catch (IOException e) {
//            Log.i("TAG", "ERRO DE CONEXÃO COM O WEB SERVICE");
//        }
//
////        requestCatalog.enqueue(new Callback<ListaClubes>(){
////            @Override
////            public void onResponse(Call<ListaClubes> call, Response<ListaClubes> response) {
////                if (response.isSuccessful()) {
////                    ViewClube.listaClubes = response.body();
////                } else {
////                    Log.i("TAG", "ERRO " + response.code());
////                }
////            }
////
////
////            public void onFailure(Call<ListaClubes> call, Throwable t) {
////                Log.e("TAG", "Erro: " + t.getMessage());
////            }
////        });
//
//
//        return null;
    }
//
//    public interface onResponseRetrofitListenner {
//            void responseClubes(ListaClubes listaClubes);
//    }