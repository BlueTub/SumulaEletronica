package com.projeto.sumula.sumulaeletronica.persistence;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import com.projeto.sumula.sumulaeletronica.model.ListaArbitros;
import com.projeto.sumula.sumulaeletronica.services.ArbitroService;
import com.projeto.sumula.sumulaeletronica.services.JogadorService;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pedro on 05/10/2016.
 */

public class ArbitroJson extends AsyncTask<Void, Void, ListaArbitros> {

    private Context context;
    private ProgressDialog dialog;
    private String nome;
    private OnResponseRetrofitListenner listenner;

    public ArbitroJson(Context context, String nome, OnResponseRetrofitListenner listenner) {
        this.context = context;
        this.nome = nome;
        this.listenner = listenner;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Consumindo o web service",
                "Aguarde", true, true);
    }

    @Override
    protected void onPostExecute(ListaArbitros listaArbitros) {
        listenner.responseArbitros(listaArbitros);
        dialog.dismiss();
    }

    @Override
    protected ListaArbitros doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JogadorService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArbitroService service = retrofit.create(ArbitroService.class);
        Call<ListaArbitros> listaArbitrosCall = service.buscarPorNome(nome); //TODO

        try {
            ListaArbitros listaArbitros = listaArbitrosCall.execute().body();
            return listaArbitros;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable t) {
            t.getMessage();
        }

        return null;
    }

    public interface OnResponseRetrofitListenner {
        void responseArbitros(ListaArbitros listaArbitros);
    }
}
