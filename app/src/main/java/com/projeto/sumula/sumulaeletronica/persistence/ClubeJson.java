package com.projeto.sumula.sumulaeletronica.persistence;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.projeto.sumula.sumulaeletronica.model.ListaClubes;
import com.projeto.sumula.sumulaeletronica.services.ClubeService;
import com.projeto.sumula.sumulaeletronica.services.JogadorService;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hury_ on 29/09/2016.
 */

public class ClubeJson extends AsyncTask<Void, Void, ListaClubes>{

    private Context context;
    public ProgressDialog dialog;
    public onResponseRetrofitListenner listenner;

    public ClubeJson(Context context, onResponseRetrofitListenner listenner) {
        this.context = context;
        this.listenner = listenner;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Consumindo o web service",
                "Aguarde", true, true);
    }

    @Override
    protected void onPostExecute(ListaClubes listaClubes) {
        listenner.responseClubes(listaClubes);
        dialog.dismiss();
    }

    @Override
    protected ListaClubes doInBackground(Void... params) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JogadorService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ClubeService service = retrofit.create(ClubeService.class);
        Call<ListaClubes> requestCatalog = service.listCatalog();

        try {
            ListaClubes listaClubes = requestCatalog.execute().body();
            return listaClubes;
        } catch (IOException e) {
            e.printStackTrace();
        }

//        requestCatalog.enqueue(new Callback<ListaClubes>(){
//            @Override
//            public void onResponse(Call<ListaClubes> call, Response<ListaClubes> response) {
//                if (response.isSuccessful()) {
//                    ViewClube.listaClubes = response.body();
//                } else {
//                    Log.i("TAG", "ERRO " + response.code());
//                }
//            }
//
//
//            public void onFailure(Call<ListaClubes> call, Throwable t) {
//                Log.e("TAG", "Erro: " + t.getMessage());
//            }
//        });


        return null;
    }

    public interface onResponseRetrofitListenner {
            void responseClubes(ListaClubes listaClubes);
    }
}
