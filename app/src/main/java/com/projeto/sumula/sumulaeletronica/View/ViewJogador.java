package com.projeto.sumula.sumulaeletronica.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewClube;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewJogador;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;
import com.projeto.sumula.sumulaeletronica.persistence.JogadorJson;

import java.util.ArrayList;
import java.util.List;

public class ViewJogador extends AppCompatActivity {

    public static List<Jogador> jogadores = new ArrayList<Jogador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);

        construirGrid(jogadores);


    }

    public void construirGrid(List<Jogador> jogadores){
        GridView gv = (GridView) findViewById(R.id.gvJogadores);

        try {
            if (jogadores != null) {
                gv.setAdapter(new AdaptadorGridViewJogador(this, jogadores));
                gv.setOnItemClickListener(new GridView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {
                        //TODO
                    }
                });
            }
        } catch (NullPointerException e) {
            Log.i("catch", "NULA");
        }
    }
}
