package com.projeto.sumula.sumulaeletronica.fragments.julgamento;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projeto.sumula.sumulaeletronica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJulgamento extends Fragment {


    public FragmentJulgamento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_julgamento, container, false);

        return view;
    }

}
