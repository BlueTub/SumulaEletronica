
package com.projeto.sumula.sumulaeletronica.fragments.jogador;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJogadorPesquisado extends Fragment implements Serializable{

    private NetworkImageView imagem;
    private ImageLoader imageLoader;
    private RequestQueue queue;
    private TextView nome;

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





        return view;
    }

}
