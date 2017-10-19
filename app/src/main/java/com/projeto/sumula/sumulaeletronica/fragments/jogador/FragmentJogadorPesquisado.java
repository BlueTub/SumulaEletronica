
package com.projeto.sumula.sumulaeletronica.fragments.jogador;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.View.MenuLateral;
import com.projeto.sumula.sumulaeletronica.fragments.sentenca.FragmentSentenca;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJogadorPesquisado extends Fragment implements Serializable{

    private NetworkImageView imagem;
    private ImageLoader imageLoader;
    private RequestQueue queue;
    private TextView nome;
    private Spinner spinCampeonato;
    private List<String> tipos;
    private ImageButton btnSentencaJogadorPesquisado;

    public FragmentJogadorPesquisado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_jogador_pesquisado, container, false);

        Jogador jogador = (Jogador) getArguments().getSerializable("jogador");

       if (jogador == null)
            Toast.makeText(FragmentJogadorPesquisado.this.getActivity(), "Objeto Nulo", Toast.LENGTH_SHORT).show();

        queue = Volley.newRequestQueue(FragmentJogadorPesquisado.this.getContext());

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
        imagem = (NetworkImageView) view.findViewById(R.id.nivImgJogadorPesquisado);
        nome = (TextView) view.findViewById(R.id.tvTitleJogadorPesquisado);

        nome.setText(jogador.getNome());

        imagem.setVisibility(view.VISIBLE);
        imagem.setImageUrl(jogador.getImg(), imageLoader);

        //Imagem que aparece enquanto esta carregando
        imagem.setDefaultImageResId(R.drawable.loading);

        //Imagem quando não houver imagem ou de erro no carregamento
        imagem.setErrorImageResId(R.drawable.error);

        tipos = new ArrayList<>();
        tipos.add("Brasileirão");
        tipos.add("Paulista");
        tipos.add("Copa do Brasil");

        spinCampeonato = (Spinner) view.findViewById(R.id.spinnerCampeonato);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(FragmentJogadorPesquisado.this.getActivity(), android.R.layout.simple_spinner_dropdown_item, tipos);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCampeonato.setAdapter(arrayAdapter);


        btnSentencaJogadorPesquisado = (ImageButton) view.findViewById(R.id.btnSentencaJogadorPesquisado);

        btnSentencaJogadorPesquisado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSentenca fragmentJSentenca = new FragmentSentenca();
                Intent i = new Intent(getActivity(), MenuLateral.class);
                i.putExtra("fragment", fragmentJSentenca);
                startActivity(i);
            }
        });

        return view;
    }

}
