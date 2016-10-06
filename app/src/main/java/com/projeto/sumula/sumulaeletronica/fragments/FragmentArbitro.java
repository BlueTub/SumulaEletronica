package com.projeto.sumula.sumulaeletronica.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewArbitro;
import com.projeto.sumula.sumulaeletronica.model.ListaArbitros;
import com.projeto.sumula.sumulaeletronica.persistence.ArbitroJson;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentArbitro extends Fragment {

    private ImageButton imageButton;
    private EditText etPesquisa;
    private GridView gv;


    public FragmentArbitro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_arbitro, container, false);

        imageButton = (ImageButton) view.findViewById(R.id.ibPesquisarArbitro);
        etPesquisa = (EditText) view.findViewById(R.id.etPesquisarArbitro);
        gv = (GridView) view.findViewById(R.id.gvArbitro);



        gv.setOnItemClickListener( new GridView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                //TODO
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ArbitroJson arbitroJson = new ArbitroJson(FragmentArbitro.this.getActivity(), etPesquisa.getText().toString(), new ArbitroJson.OnResponseRetrofitListenner() {
                    @Override
                    public void responseArbitros(ListaArbitros listaArbitros) {
                        gv.setAdapter(new AdaptadorGridViewArbitro(
                                FragmentArbitro.this.getActivity(),
                                listaArbitros));
                    }
                });

                arbitroJson.execute();
            }
        });

        return view;
    }

}