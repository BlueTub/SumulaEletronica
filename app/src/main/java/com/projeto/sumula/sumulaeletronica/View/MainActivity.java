package com.projeto.sumula.sumulaeletronica.View;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.fragments.cadastro.FragmentCadastro;

public class MainActivity extends AppCompatActivity {

    private Button btnTorcedor;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTorcedor = (Button) findViewById(R.id.btnTorcedor);
        btnTorcedor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                ConnectivityManager manager = (ConnectivityManager)getSystemService(MainActivity.CONNECTIVITY_SERVICE);
                if (isNetworkConnected(manager)){
                    Intent intent = new Intent(MainActivity.this, MenuLateral.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Falha ao encontrar rede", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                ConnectivityManager manager = (ConnectivityManager)getSystemService(MainActivity.CONNECTIVITY_SERVICE);
                if (isNetworkConnected(manager)){
                    FragmentCadastro fragmentCadastro = new FragmentCadastro();
                    transaction(fragmentCadastro);
                }else{
                    Toast.makeText(MainActivity.this, "Falha ao encontrar rede", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean isNetworkConnected(ConnectivityManager connectivityManager){
        NetworkInfo network = connectivityManager.getActiveNetworkInfo();
        if (network != null && network.isAvailable() && network.isConnected()){
            return true;
        } else {
            return false;
        }
    }

    public void transaction(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.relativelayout_for_fragment,
                        fragment,
                        fragment.getTag())
                .commit();
    }
}