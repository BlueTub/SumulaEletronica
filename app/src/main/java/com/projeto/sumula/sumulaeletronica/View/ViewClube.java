package com.projeto.sumula.sumulaeletronica.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewClube;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;
import com.projeto.sumula.sumulaeletronica.persistence.JogadorJson;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Pedro on 29/09/2016.
 */

public class ViewClube extends AppCompatActivity {

   // private int[] lista;
    public static ListaClubes listaClubes;
    public static ListaClubes listaPesquisa = new ListaClubes();
    //public static List<Integer> imagens = new ArrayList<>();
    private ImageButton imageButton;
    private EditText etPesquisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubes);

        imageButton = (ImageButton) findViewById(R.id.imPesquisaClube);
        etPesquisa = (EditText) findViewById(R.id.etPesquisaClube);

        construirGrid(listaClubes);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listaPesquisa.clube = new ArrayList<Clube>();
                if (!listaPesquisa.clube.isEmpty()){
                    listaPesquisa.clube.clear();
                }

                pesquisa(etPesquisa.getText().toString());
                construirGrid(listaPesquisa);
            }
        });

    }

    public void construirGrid(final ListaClubes listaClubes){
        GridView gv = (GridView) findViewById(R.id.gvClubes);

        try {
            if (listaClubes != null) {
                gv.setAdapter(new AdaptadorGridViewClube(this, listaClubes));
                gv.setOnItemClickListener(new GridView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {
                        Log.i("LISTA", String.valueOf(listaClubes.clube.get(position).getId()).toString());
                        JogadorJson json = new JogadorJson();
                        json.pesquisaJogadorClube(listaClubes.clube.get(position).getId());

                        Intent intent = new Intent(ViewClube.this, ViewJogador.class);
                        startActivity(intent);
                    }
                });
            }
        } catch (NullPointerException e) {
            Log.i("catch", "NULA");
        }
    }

    public void pesquisa(String param){
        Clube c = new Clube();

        for (Clube clube : listaClubes.clube) {
            if (clube.getNome().startsWith(param) || clube.getNome().endsWith(param)) {
                c = clube;
                listaPesquisa.clube.add(c);
            }
        }

    }


}
