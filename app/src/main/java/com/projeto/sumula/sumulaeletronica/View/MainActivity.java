package com.projeto.sumula.sumulaeletronica.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;
import com.projeto.sumula.sumulaeletronica.persistence.ClubeJson;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    public ListaClubes listaClubes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       // c.execute();

        botao = (Button) findViewById(R.id.btnTorcedor);
        botao.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
               // setContentView(R.layout.activity_clubes);

               // Intent intent = new Intent(MainActivity.this, ViewClube.class);
               // startActivity(intent);

              //  JogadorJson j = new JogadorJson();
               // j.pesquisa();

                Intent intent = new Intent(MainActivity.this, MenuLateral.class);
               // intent.putExtra("clubes", listaClubes);
                startActivity(intent);

            }
        });



    }
}