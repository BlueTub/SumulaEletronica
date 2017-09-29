package com.projeto.sumula.sumulaeletronica.fragments.sumula;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.View.MenuLateral;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSumulaCronologia extends Fragment implements Serializable{

    private ImageButton btnProximo;


    public FragmentSumulaCronologia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sumula_cronologia, container, false);

        btnProximo = (ImageButton) view.findViewById(R.id.btnProximoSumulaCronologia);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentRelacaoAtletas fragmentRelacaoAtletas = new FragmentRelacaoAtletas();
                Intent i = new Intent(getActivity(), MenuLateral.class);
                i.putExtra("fragment", fragmentRelacaoAtletas);
                startActivity(i);
            }
        });

        return view;
    }

}
