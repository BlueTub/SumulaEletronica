package com.projeto.sumula.sumulaeletronica.fragments.sentenca;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.projeto.sumula.sumulaeletronica.R;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSentenca extends Fragment implements Serializable{

    private ListView listView;


    public FragmentSentenca() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sentenca, container, false);

        listView = (ListView) view.findViewById(R.id.lvSentencas);

        String[] items = {"Sentenciado por agressão a outro jogador", "Escalado irregularmente ", "Agressão ao Árbitro"};
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(FragmentSentenca.this.getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);

        return view;
    }

}
