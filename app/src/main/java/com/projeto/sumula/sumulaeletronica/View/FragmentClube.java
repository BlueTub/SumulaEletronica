package com.projeto.sumula.sumulaeletronica.View;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewClube;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;
import com.projeto.sumula.sumulaeletronica.persistence.ClubeJson;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClube extends Fragment {

        private ImageButton imageButton;
        private EditText etPesquisa;
        private GridView gv;
        private ListaClubes listaClubes;


    public FragmentClube() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_clube, container, false);

        imageButton = (ImageButton) view.findViewById(R.id.imPesquisaClube);
        etPesquisa = (EditText) view.findViewById(R.id.etPesquisaClube);
        gv = (GridView) view.findViewById(R.id.gvClubes);

        ClubeJson c = new ClubeJson(FragmentClube.this.getActivity(), new ClubeJson.onResponseRetrofitListenner() {
            @Override
            public void responseClubes(ListaClubes listaClubes) {

                for (Clube c : listaClubes.clube) {
                    Log.i("TAG", c.getNome());
                }

                gv.setAdapter(new AdaptadorGridViewClube(
                        FragmentClube.this.getActivity(),
                        listaClubes));


//                listaClubes = listaClubes;
//

            }
        });

        c.execute();


        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(FragmentClube.this.getActivity(), "Pesquisar", Toast.LENGTH_SHORT).show();

//                listaPesquisa.clube = new ArrayList<Clube>();
//                if (!listaPesquisa.clube.isEmpty()){
//                    listaPesquisa.clube.clear();
//                }
//
//                pesquisa(etPesquisa.getText().toString());
//                construirGrid(listaPesquisa);
            }
        });

        return view;
    }

}
