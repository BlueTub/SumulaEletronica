package com.projeto.sumula.sumulaeletronica.View;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.fragments.clube.FragmentClube;
import com.projeto.sumula.sumulaeletronica.fragments.estadio.FragmentEstadio;
import com.projeto.sumula.sumulaeletronica.fragments.jogador.FragmentJogador;
import com.projeto.sumula.sumulaeletronica.fragments.sumula.FragmentSumulaFichaTecnica;

public class ActivityPrincipal extends AppCompatActivity {

    private ImageButton btnJogador;
    private ImageButton btnClube;
    private ImageButton btnEstadio;
    private ImageButton btnSentenca;
    private ImageButton btnArbitro;
    private ImageButton btnCampeonato;
    private ImageButton btnSumula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnJogador = (ImageButton) findViewById(R.id.btnJogadorPrincipal);
        btnJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentJogador fragmentJogador = new FragmentJogador();
                Intent intent = new Intent(ActivityPrincipal.this, MenuLateral.class);
                intent.putExtra("fragment", fragmentJogador);
                startActivity(intent);
            }
        });

        btnEstadio = (ImageButton) findViewById(R.id.btnEstadioPrincipal);
        btnEstadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentEstadio fragmentEstadio = new FragmentEstadio();
                Intent intent = new Intent(ActivityPrincipal.this, MenuLateral.class);
                intent.putExtra("fragment", fragmentEstadio);
                startActivity(intent);
            }
        });

        btnClube = (ImageButton) findViewById(R.id.btnClubePrincipal);
        btnClube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentClube fragmentClube = new FragmentClube();
                Intent intent = new Intent(ActivityPrincipal.this, MenuLateral.class);
                intent.putExtra("fragment", fragmentClube);
                startActivity(intent);
            }
        });

        btnSumula = (ImageButton) findViewById(R.id.btnSumulaPrincipal);
        btnSumula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSumulaFichaTecnica fragmentSumulaFichaTecnica = new FragmentSumulaFichaTecnica();
                Intent intent = new Intent(ActivityPrincipal.this, MenuLateral.class);
                intent.putExtra("fragment", fragmentSumulaFichaTecnica);
                startActivity(intent);
            }
        });
    }
}
