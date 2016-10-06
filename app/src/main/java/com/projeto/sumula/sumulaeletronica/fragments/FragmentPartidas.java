package com.projeto.sumula.sumulaeletronica.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.projeto.sumula.sumulaeletronica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPartidas extends Fragment {

    private EditText etPesquisar;
    private RadioGroup rgCampeonato, rgPesquisa;
    private RadioButton rbData, rbClube, rbBrasilerao, rbPaulista;
    private DatePicker datePicker;
    private ImageButton imageButton;



    public FragmentPartidas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_partidas, container, false);

        etPesquisar = (EditText) view.findViewById(R.id.etPesquisarPartidaClube);
        rgCampeonato = (RadioGroup) view.findViewById(R.id.rgCampeonato);
        rgPesquisa = (RadioGroup) view.findViewById(R.id.rgPesquisa);
        rbData = (RadioButton) view.findViewById(R.id.rbData);
        rbClube = (RadioButton) view.findViewById(R.id.rbClube);
        rbBrasilerao = (RadioButton) view.findViewById(R.id.rbBrasileirao);
        rbPaulista = (RadioButton) view.findViewById(R.id.rbPaulista);
        datePicker = (DatePicker) view.findViewById(R.id.datePicker);
        imageButton = (ImageButton) view.findViewById(R.id.imageButton);

        rbClube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        rbData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });


        return view;
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbClube:
                if (checked)
                    datePicker.setVisibility(View.INVISIBLE);
                    etPesquisar.setVisibility(View.VISIBLE);
                    imageButton.setVisibility(View.VISIBLE);
                    break;
            case R.id.rbData:
                if (checked)
                    datePicker.setVisibility(View.VISIBLE);
                    etPesquisar.setVisibility(View.INVISIBLE);
                    imageButton.setVisibility(View.VISIBLE);
                    break;
        }
    }

}
