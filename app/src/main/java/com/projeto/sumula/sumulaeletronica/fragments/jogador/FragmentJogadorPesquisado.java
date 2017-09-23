package com.projeto.sumula.sumulaeletronica.fragments.jogador;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJogadorPesquisado extends Fragment {

    private GridView gv;

    public FragmentJogadorPesquisado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_jogador_pesquisado, container, false);

        ListaJogadores listaJogadores = (ListaJogadores) getArguments().getSerializable("lista");

        gv = (GridView) view.findViewById(R.id.gvJogadores);

//        gv.setAdapter( new AdaptadorGridViewJogador(
//                FragmentJogadorPesquisado.this.getContext(),
//                listaJogadores.jogador));

        gv.setOnItemClickListener( new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                //TODO
                Jogador jogador = (Jogador) parent.getAdapter().getItem(position);
                String apelido = jogador.getApelido();
                Toast.makeText(FragmentJogadorPesquisado.this.getActivity(), apelido, Toast.LENGTH_SHORT).show();


            }
        });

        return view;
    }

}
