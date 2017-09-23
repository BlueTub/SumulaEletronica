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
import android.widget.EditText;
import android.widget.Toast;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.model.Usuario;
import com.projeto.sumula.sumulaeletronica.persistence.LoginJson;

public class MainActivity extends AppCompatActivity {

    private Button btnTorcedor;
    private Button btnCadastrar;
    private Button btnLogin;
    private EditText txtUsuario;
    private EditText txtSenha;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = (EditText) findViewById(R.id.etLogin);
        txtSenha = (EditText) findViewById(R.id.etSenha);

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
                    Intent intent = new Intent(MainActivity.this, ActivityCadastro.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Falha ao encontrar rede", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LoginJson login = new LoginJson(MainActivity.this);

                usuario = login.login(txtUsuario.getText().toString(), txtSenha.getText().toString());
                //if (usuario.equals(null)){
                    //Toast.makeText(MainActivity.this, "Usuario não cadastrado", Toast.LENGTH_SHORT).show();
               // }else{
                    Toast.makeText(MainActivity.this, usuario.getUsuario(), Toast.LENGTH_SHORT).show();
                //}

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