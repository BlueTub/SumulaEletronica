package com.projeto.sumula.sumulaeletronica.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.projeto.sumula.sumulaeletronica.resources.BuscarClubesAsync;

/**
 * Created by Pedro on 29/09/2016.
 */

public class ViewClube extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BuscarClubesAsync basync = new BuscarClubesAsync(this);
        basync.execute();
    }
}
