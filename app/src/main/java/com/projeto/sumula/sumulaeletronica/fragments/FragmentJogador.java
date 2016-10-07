package com.projeto.sumula.sumulaeletronica.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.enumeration.PosicaoJogador;
import com.projeto.sumula.sumulaeletronica.enumeration.UF;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJogador extends Fragment {

    private EditText etPesqusiar;
    private AutoCompleteTextView completeTextView;
    private RadioGroup radioGroup;
    private RadioButton rbNome, rbClube, rbPosicao, rbUF;
    private Button btnPesquisar;
    private Spinner spnUF, spnPosicao;
    private List<PosicaoJogador> posicoes;
    private List<UF> ufs;
    private ArrayAdapter<UF> adapterUF;
    private ArrayAdapter<PosicaoJogador> adapterPosicao;
    private static String[] CLUBES;
    private ArrayAdapter<String> adp;

    public FragmentJogador() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogador, container, false);

       CLUBES = new String[]{"Corinthians", "São Paulo", "Flamengo",
                "Palmeiras", "Vasco", "Botafogo", "Cruzeiro', 'Internacional", "Ceará", "Figueirense",
                "Coritiba", "Fluminense", "Grêmio", "Santos", "Atlético-MG", "Bahia",
                "Atlético-GO", "Avaí", "América-MG", "Atlético-PR"};

        etPesqusiar = (EditText) view.findViewById(R.id.etPesquisa);
        radioGroup = (RadioGroup) view.findViewById(R.id.rgPesquisaJogador);
        rbNome = (RadioButton) view.findViewById(R.id.rbJogadorNome);
        rbClube = (RadioButton) view.findViewById(R.id.rbJogadorClube);
        rbPosicao = (RadioButton) view.findViewById(R.id.rbJogadorPosicao);
        rbUF = (RadioButton) view.findViewById(R.id.rbJogadorUF);
        btnPesquisar = (Button) view.findViewById(R.id.btnPesquisarJogador);
        spnPosicao = (Spinner) view.findViewById(R.id.spnPosicao);
        spnUF = (Spinner) view.findViewById(R.id.spnUF);
        completeTextView = (AutoCompleteTextView) view.findViewById(R.id.actvClubes);

        rbNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        rbClube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        rbPosicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        rbUF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        //Carrega lista com o enum
        ufs = Arrays.asList(UF.values());
        posicoes = Arrays.asList(PosicaoJogador.values());

        return view;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbJogadorNome:
                if (checked)
                    btnPesquisar.setVisibility(View.VISIBLE);
                    etPesqusiar.setVisibility(View.VISIBLE);

                    spnPosicao.setVisibility(View.INVISIBLE);
                    spnUF.setVisibility(View.INVISIBLE);
                    completeTextView.setVisibility(View.INVISIBLE);
                break;
            case R.id.rbJogadorClube:
                if (checked)
                    adp = new ArrayAdapter<>(FragmentJogador.this.getActivity(), android.R.layout.simple_dropdown_item_1line, CLUBES);
                    completeTextView.setAdapter(adp);

                    completeTextView.setVisibility(View.VISIBLE);
                    btnPesquisar.setVisibility(View.VISIBLE);

                    etPesqusiar.setVisibility(View.INVISIBLE);
                    spnPosicao.setVisibility(View.INVISIBLE);
                    spnUF.setVisibility(View.INVISIBLE);
                break;
            case R.id.rbJogadorPosicao:
                if (checked)
                    adapterPosicao = new ArrayAdapter<>(
                            FragmentJogador.this.getActivity(),
                            android.R.layout.simple_spinner_item, posicoes);

                    adapterPosicao.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnPosicao.setAdapter(adapterPosicao);

                    btnPesquisar.setVisibility(View.VISIBLE);
                    spnPosicao.setVisibility(View.VISIBLE);

                    completeTextView.setVisibility(View.INVISIBLE);
                    spnUF.setVisibility(View.INVISIBLE);
                    etPesqusiar.setVisibility(View.INVISIBLE);
                    break;
            case R.id.rbJogadorUF:
                if (checked)
                    adapterUF = new ArrayAdapter<>(
                            FragmentJogador.this.getActivity(),
                            android.R.layout.simple_spinner_item, ufs);

                    adapterUF.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnUF.setAdapter(adapterUF);

                    btnPesquisar.setVisibility(View.VISIBLE);
                    spnUF.setVisibility(View.VISIBLE);

                    completeTextView.setVisibility(View.INVISIBLE);
                    spnPosicao.setVisibility(View.INVISIBLE);
                    etPesqusiar.setVisibility(View.INVISIBLE);
                    break;
        }
    }

}
