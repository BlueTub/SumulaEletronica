package com.projeto.sumula.sumulaeletronica.fragments.clube;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewClube;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.persistence.ClubeJson;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClube extends Fragment implements Serializable {

        private ImageButton imageButton;
        private EditText etPesquisa;
        private GridView gv;
        private ImageLoader imageLoader;
        private RequestQueue queue;
        private List<Clube> listaClubes;


    public FragmentClube() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

        ClubeJson cj = new ClubeJson(FragmentClube.this.getActivity());
        listaClubes = cj.listaTodosClubes();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_clube, container, false);

        imageButton = (ImageButton) view.findViewById(R.id.imPesquisaClube);
        gv = (GridView) view.findViewById(R.id.gvClubes);

        queue = Volley.newRequestQueue(FragmentClube.this.getContext());

        imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(10);
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });

//        ClubeJson c = new ClubeJson(FragmentClube.this.getActivity(), new ClubeJson.onResponseRetrofitListenner() {
//            @Override
//            public void responseClubes(ListaClubes listaClubes) {
//                try {
//                    if (listaClubes != null) {
//                        gv.setAdapter(new AdaptadorGridViewClube(
//                                FragmentClube.this.getActivity(),
//                                listaClubes));
//                    }
//                }catch (NullPointerException e) {
//                    Toast.makeText(FragmentClube.this.getActivity(), "ERRO", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//        c.execute();



        gv.setOnItemClickListener( new GridView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
//                Clube  clube = (Clube) parent.getAdapter().getItem(position);
//
//                JogadorJson j = new JogadorJson(FragmentClube.this.getActivity(), clube, "", "id", new JogadorJson.onResponseRetrofitListenner(){
//                    @Override
//                    public void responseJogadores(ListaJogadores listaJogadores){
//                        Bundle bundle = new Bundle();
//                        bundle.putSerializable("lista", listaJogadores);
//
//                        FragmentJogadorPesquisado fr = new FragmentJogadorPesquisado();
//                        fr.setArguments(bundle);
//                        FragmentManager fm = getFragmentManager();
//                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//                        fragmentTransaction.replace(R.id.relativelayout_for_fragment, fr, fr.getTag());
//                        fragmentTransaction.commit();
//                    }
//                 });
//
//                j.execute();



            }
        });

//    public void pesquisa(String param){
//        Clube c = new Clube();
//
//        for (Clube clube : listaClubes.clube) {
//            if (clube.getNome().startsWith(param) || clube.getNome().endsWith(param)) {
//                c = clube;
//                listaPesquisa.clube.add(c);
//            }
//        }
//
//    }


        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (listaClubes != null) {
                    gv.setAdapter(new AdaptadorGridViewClube(FragmentClube.this.getActivity(), listaClubes, imageLoader));
                }
            }
        });

        return view;
    }

}
