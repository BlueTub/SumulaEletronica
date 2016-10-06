package com.projeto.sumula.sumulaeletronica.persistence;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.projeto.sumula.sumulaeletronica.model.Arbitro;
import com.projeto.sumula.sumulaeletronica.services.ArbitroService;
import com.projeto.sumula.sumulaeletronica.services.JogadorService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pedro on 05/10/2016.
 */

public class ArbitroJson extends AsyncTask<Void, Void, List<Arbitro>> {

    private Context context;
    private ProgressDialog dialog;
    private OnResponseRetrofitListenner listenner;

    public ArbitroJson(Context context, OnResponseRetrofitListenner listenner) {
        this.context = context;
        this.listenner = listenner;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Consumindo o web service",
                "Aguarde", true, true);
    }

    @Override
    protected void onPostExecute(List<Arbitro> listaArbitros) {
        listenner.responseArbitros(listaArbitros);
        dialog.dismiss();
    }

    @Override
    protected List<Arbitro> doInBackground(Void... params) {

        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JogadorService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final ArbitroService service = retrofit.create(ArbitroService.class);
        Call<List<Arbitro>> listaArbitrosCall = service.listarTodos(); //TODO

        try {
            List<Arbitro> listaArbitros = listaArbitrosCall.execute().body();
            return listaArbitros;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public interface OnResponseRetrofitListenner {
        void responseArbitros(List<Arbitro> listaArbitros);
    }
}
