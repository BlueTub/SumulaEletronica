package com.projeto.sumula.sumulaeletronica.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;
import com.projeto.sumula.sumulaeletronica.persistence.ClubeJson;
import com.projeto.sumula.sumulaeletronica.persistence.JogadorJson;
import com.projeto.sumula.sumulaeletronica.persistence.JogadorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.btnTorcedor);
        botao.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
               // setContentView(R.layout.activity_clubes);

               // Intent intent = new Intent(MainActivity.this, ViewClube.class);
               // startActivity(intent);

              //  JogadorJson j = new JogadorJson();
               // j.pesquisa();

                Intent intent = new Intent(MainActivity.this, ViewClube.class);
                startActivity(intent);

            }
        });



    }
}