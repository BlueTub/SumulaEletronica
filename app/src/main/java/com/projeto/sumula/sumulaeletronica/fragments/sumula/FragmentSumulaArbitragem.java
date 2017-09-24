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
public class FragmentSumulaArbitragem extends Fragment implements Serializable{


    public FragmentSumulaArbitragem() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_sumula_arbitragem, container, false);



        return view;
    }

}
