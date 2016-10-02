package com.projeto.sumula.sumulaeletronica.control;

/**
 * Created by Pedro on 01/10/2016.
 */
import android.util.Log;

import com.projeto.sumula.sumulaeletronica.View.ViewClube;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestClube implements Callback<ListaClubes> {

    private static final String TAG = "hury";
    
    @Override
    public void onResponse(Call<ListaClubes> call, Response<ListaClubes> response) {
        if (response.isSuccessful()) {
            ViewClube.listaClubes = response.body();

            for (Clube c : ViewClube.listaClubes.clube){
                Log.i(TAG, c.toString());
                Log.i(TAG, "----------");
            }
        } else {
            Log.i("TAG", "ERRO " + response.code());
        }
    }


    public void onFailure(Call<ListaClubes> call, Throwable t) {
        Log.e(TAG, "Erro: " + t.getMessage());
    }
}
