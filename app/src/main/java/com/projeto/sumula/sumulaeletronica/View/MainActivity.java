package com.projeto.sumula.sumulaeletronica.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;
import com.projeto.sumula.sumulaeletronica.persistence.JogadorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "hury";
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "INICIADO");
        botao = (Button) findViewById(R.id.button);
        botao.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //Intent intent = new Intent(MainActivity.this, ViewJogador.class);
                //startActivity(intent);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(JogadorService.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JogadorService service = retrofit.create(JogadorService.class);
                Call<ListaJogadores> requestCatalog = service.listCatalog();

                requestCatalog.enqueue(new Callback<ListaJogadores>() {
                    @Override
                    public void onResponse(Call<ListaJogadores> call, Response<ListaJogadores> response) {
                        if (response.isSuccessful()) {
                            //Requisição retornou com sucesso
                            ListaJogadores catalog = response.body();
                            for (Jogador j : catalog.jogador){

                                Log.i(TAG,String.format("%s: %s", j.nome, j.apelido));
                                Log.i(TAG, "----------");
                            }
                        } else {
                            //Requisição retornou com erro
                            Log.i("TAG", "ERRO " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<ListaJogadores> call, Throwable t) {
                        //ERRO
                        Log.e(TAG, "Erro: " + t.getMessage());
                    }
                });


            }
        });



    }
}