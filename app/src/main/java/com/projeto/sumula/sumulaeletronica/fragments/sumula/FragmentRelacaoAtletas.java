package com.projeto.sumula.sumulaeletronica.fragments.sumula;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewJogador;
import com.projeto.sumula.sumulaeletronica.fragments.jogador.FragmentJogador;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.persistence.JogadorJson;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRelacaoAtletas extends Fragment implements Serializable{

    private ListView listView;
    private RequestQueue queue;
    private List<Jogador> listaJogadores;
    private ImageButton imageButton;


    public FragmentRelacaoAtletas() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

        JogadorJson jj = new JogadorJson(FragmentRelacaoAtletas.this.getActivity());
        listaJogadores = jj.listaTodosJogadores();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relacao_atletas, container, false);
        listView = (ListView) view.findViewById(R.id.lvRelacaoAtletas);
        imageButton = (ImageButton) view.findViewById(R.id.btnPesquisarJogadorRelacaoAtletas);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listaJogadores != null) {
                    listView.setAdapter(new AdaptadorRelacaoAtletas(FragmentRelacaoAtletas.this.getActivity(), listaJogadores));
                }
            }
        });

        return view;
    }

}
