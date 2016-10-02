package com.projeto.sumula.sumulaeletronica.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewClube;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;
import com.projeto.sumula.sumulaeletronica.persistence.ClubeJson;
import com.projeto.sumula.sumulaeletronica.resources.BuscarClubesAsync;
import java.util.List;

/**
 * Created by Pedro on 29/09/2016.
 */

public class ViewClube extends AppCompatActivity {

    private int[] lista;
    public static ListaClubes listaClubes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_clubes);

        lista = new int[] {R.drawable.bo, R.drawable.sp, R.drawable.co, R.drawable.pa, R.drawable.sa};

       // BuscarClubesAsync basync = new BuscarClubesAsync(this);
       // basync.execute();

       // lista = basync.listaDeClubes();

        GridView gv = (GridView) findViewById(R.id.gvClubes);

        try {
            if (listaClubes != null)
                gv.setAdapter(new AdaptadorGridViewClube(this, listaClubes));
        } catch (NullPointerException e) {
            Log.i("catch", "NULA");
        }







    }
}
