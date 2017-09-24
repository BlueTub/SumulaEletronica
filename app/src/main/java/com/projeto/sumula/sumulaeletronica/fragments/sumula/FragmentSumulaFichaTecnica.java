package com.projeto.sumula.sumulaeletronica.fragments.sumula;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projeto.sumula.sumulaeletronica.R;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSumulaFichaTecnica extends Fragment implements Serializable{


    public FragmentSumulaFichaTecnica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sumula_ficha_tecnica, container, false);
    }

}
