package com.projeto.sumula.sumulaeletronica.View;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projeto.sumula.sumulaeletronica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClube extends Fragment {


    public FragmentClube() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clube, container, false);
    }

}
