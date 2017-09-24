package com.projeto.sumula.sumulaeletronica.fragments.sumula;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.View.ActivityPrincipal;
import com.projeto.sumula.sumulaeletronica.View.MenuLateral;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSumulaFichaTecnica extends Fragment implements Serializable{

    private ImageButton btnProximo;


    public FragmentSumulaFichaTecnica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sumula_ficha_tecnica, container, false);

        btnProximo = (ImageButton) view.findViewById(R.id.btnProximoFichaTecnica);
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSumulaArbitragem fragmentSumulaArbitragem = new FragmentSumulaArbitragem();
                Intent i = new Intent(getActivity(), MenuLateral.class);
                i.putExtra("fragment", fragmentSumulaArbitragem);
                startActivity(i);
            }
        });

        return view;
    }

}
