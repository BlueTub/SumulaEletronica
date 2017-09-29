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
public class FragmentSumulaArbitragem extends Fragment implements Serializable{

    private ImageButton btnProximo;
    private ImageButton btnAnterior;


    public FragmentSumulaArbitragem() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_sumula_arbitragem, container, false);

        btnAnterior = (ImageButton) view.findViewById(R.id.btnAnteriorArbitragem);
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSumulaFichaTecnica fragmentSumulaFichaTecnica = new FragmentSumulaFichaTecnica();
                Intent i = new Intent(getActivity(), MenuLateral.class);
                i.putExtra("fragment", fragmentSumulaFichaTecnica);
                startActivity(i);
            }
        });

        btnProximo= (ImageButton) view.findViewById(R.id.btnProximoArbitragem);
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSumulaCronologia fragmentSumulaCronologia = new FragmentSumulaCronologia();
                Intent i = new Intent(getActivity(), MenuLateral.class);
                i.putExtra("fragment", fragmentSumulaCronologia);
                startActivity(i);
            }
        });

        return view;
    }

}
