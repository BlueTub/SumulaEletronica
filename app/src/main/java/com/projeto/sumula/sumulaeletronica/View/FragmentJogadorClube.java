package com.projeto.sumula.sumulaeletronica.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewJogador;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJogadorClube extends Fragment {

    private ImageButton imageButton;
    private EditText etPesquisa;
    private GridView gv;

    public FragmentJogadorClube() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_jogador_clube, container, false);

        ListaJogadores listaJogadores = (ListaJogadores) getArguments().getSerializable("lista");

        imageButton = (ImageButton) view.findViewById(R.id.ibPesquisarJogador);
        etPesquisa = (EditText) view.findViewById(R.id.etPesquisaJogador);
        gv = (GridView) view.findViewById(R.id.gvJogadores);

        gv.setAdapter( new AdaptadorGridViewJogador(
                FragmentJogadorClube.this.getContext(),
                listaJogadores.jogador));

        gv.setOnItemClickListener( new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                //TODO
                Jogador jogador = (Jogador) parent.getAdapter().getItem(position);
                String apelido = jogador.getApelido();
                Toast.makeText(FragmentJogadorClube.this.getActivity(), apelido, Toast.LENGTH_SHORT).show();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                Toast.makeText(FragmentJogadorClube.this.getActivity(), "Pesquisar", Toast.LENGTH_SHORT).show();
            }
        });


        // Inflate the layout for this fragment

        return view;
    }

}
