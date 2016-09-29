package com.projeto.sumula.sumulaeletronica.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewClube;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.resources.BuscarClubesAsync;

import java.util.List;

/**
 * Created by Pedro on 29/09/2016.
 */

public class ViewClube extends AppCompatActivity {

    private List<Clube> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BuscarClubesAsync basync = new BuscarClubesAsync(this);
        basync.execute();

        lista = basync.listaDeClubes();

        GridView gv = (GridView) findViewById(R.id.gvClubes);

        gv.setAdapter(new AdaptadorGridViewClube(this, lista));

    }
}
