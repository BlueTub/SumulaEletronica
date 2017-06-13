package com.projeto.sumula.sumulaeletronica.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.projeto.sumula.sumulaeletronica.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityCadastro extends AppCompatActivity {

    private Spinner spinTipo;
    private List<String> tipos;
    private EditText txtNome;
    private EditText txtCpf;
    private EditText txtRegistro;
    private EditText txtUsuario;
    private EditText txtSenha;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        spinTipo = (Spinner) findViewById(R.id.spinTipo);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtCpf = (EditText) findViewById(R.id.txtCPF);
        txtRegistro = (EditText) findViewById(R.id.txtRegistro);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);

        tipos = new ArrayList<>();
        tipos.add("Árbitro");
        tipos.add("STJD");
        tipos.add("CBF");
        tipos.add("Clube");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipos);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinTipo.setAdapter(spinnerArrayAdapter);

        spinTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                //pega nome pela posição
                String nome = parent.getItemAtPosition(posicao).toString();
                //imprime um Toast na tela com o nome que foi selecionado
                Toast.makeText(ActivityCadastro.this, "Nome Selecionado: " + nome, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
