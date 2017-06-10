package com.projeto.sumula.sumulaeletronica.fragments.cadastro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.projeto.sumula.sumulaeletronica.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pedro on 07/06/2017.
 */

public class FragmentCadastro extends Fragment {

    private Spinner spinTipo;
    private List<String> tipos;

    public FragmentCadastro() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_cadastro, container, false);
        spinTipo = (Spinner) view.findViewById(R.id.spinTipo);

        tipos = new ArrayList<String>();
        tipos.add("Árbitro");
        tipos.add("STJD");
        tipos.add("CBF");
        tipos.add("Clube");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(FragmentCadastro.this.getActivity(), android.R.layout.simple_spinner_dropdown_item, tipos);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinTipo.setAdapter(spinnerArrayAdapter);

        spinTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                //pega nome pela posição
                String nome = parent.getItemAtPosition(posicao).toString();
                //imprime um Toast na tela com o nome que foi selecionado
                Toast.makeText(FragmentCadastro.this.getActivity(), "Nome Selecionado: " + nome, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
}
