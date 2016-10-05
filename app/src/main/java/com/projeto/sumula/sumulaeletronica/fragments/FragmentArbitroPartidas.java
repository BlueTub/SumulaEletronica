package com.projeto.sumula.sumulaeletronica.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projeto.sumula.sumulaeletronica.R;

/**
 * Created by Pedro on 05/10/2016.
 */
public class FragmentArbitroPartidas extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_arbitro_tab_partidas, container, false);
        return view;
    }
}
