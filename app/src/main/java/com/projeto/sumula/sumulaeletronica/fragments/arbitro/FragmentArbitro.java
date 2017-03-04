package com.projeto.sumula.sumulaeletronica.fragments.arbitro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewArbitro;
import com.projeto.sumula.sumulaeletronica.model.Arbitro;
import com.projeto.sumula.sumulaeletronica.persistence.ArbitroJson;

import java.text.SimpleDateFormat;
import java.util.List;

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
                ArbitroJson arbitroJson = new ArbitroJson(FragmentArbitro.this.getActivity(), new ArbitroJson.OnResponseRetrofitListenner() {
                    @Override
                    public void responseArbitros(List<Arbitro> listaArbitros) {

                        for (Arbitro a : listaArbitros) {
                            String data = new SimpleDateFormat("dd/MM/yyyy").format(a.getDataNascimento());
                            Log.i("TAG", data);
                        }

                        gv.setAdapter(new AdaptadorGridViewArbitro(
                                FragmentArbitro.this.getContext(),
                                listaArbitros));
                    }
                });

                arbitroJson.execute();
            }
        });

        return view;
    }

}
