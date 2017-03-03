package com.projeto.sumula.sumulaeletronica.fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;


import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.projeto.sumula.sumulaeletronica.control.EstadioAdapterFragment;
import com.projeto.sumula.sumulaeletronica.enumeration.UF;
import com.projeto.sumula.sumulaeletronica.model.Estadio;
import com.projeto.sumula.sumulaeletronica.R;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEstadio extends Fragment {

    private FeatureCoverFlow coverFlow;
    private EstadioAdapterFragment adapter;
    private ArrayList<Estadio> listaEstadios;


  /*  @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getActivity().setContentView(R.layout.fragment_estadio);
        coverFlow = (FeatureCoverFlow) this.getActivity().findViewById(R.id.coverflow);

        settingDummyData();
        adapter = new EstadioAdapterFragment(listaEstadios, this.getContext());
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
    }
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_estadio, container, false);
        coverFlow = (FeatureCoverFlow) view.findViewById(R.id.coverflow);
        popular();

        adapter = new EstadioAdapterFragment(FragmentEstadio.this.getActivity(), listaEstadios);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());

        return view;

    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainFragment", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainFragment", "scrolling");
            }
        };
    }

    private void popular() {
        listaEstadios = new ArrayList<>();
        listaEstadios.add(new Estadio("Arena Corinthians", UF.SP, 49205, "10 de maio de 2014", "Av. Miguel Ignácio Curi, 111 - Artur Alvim", R.mipmap.arena_corinthians));
        listaEstadios.add(new Estadio("Allianz Parque", UF.SP, 43000, "19 de novembro de 2014", "Francisco Matarazzo, 1705 - Água Branca", R.mipmap.arena_palmeiras));
        listaEstadios.add(new Estadio("Vila Belmiro", UF.SP, 16068, "12 de outubro de 1916", "Rua Princesa Isabel, S/N, Vila Belmiro", R.mipmap.vila_belmiro));
        listaEstadios.add(new Estadio("Morumbi", UF.SP, 72039, "2 de outubro de 1960", "Praça Roberto Gomes Pedrosa, 1 - Morumbi", R.mipmap.morumbi));
        listaEstadios.add(new Estadio("Maracanã", UF.RJ, 78838, "16 de junho de 1950", "Av. Pres. Castelo Branco, Portão 3 - Maracanã", R.mipmap.maracana));
        listaEstadios.add(new Estadio("Independência", UF.MG, 23018, "25 de junho de 1950", "R. Pitangui, 3230 - Horto, Belo Horizonte", R.mipmap.independencia));
        listaEstadios.add(new Estadio("São Januário", UF.RJ, 21880, "21 de abril de 1927", "R. Gen. Almério de Moura, 131 - Vasco da Gama", R.mipmap.sao_januario));
        listaEstadios.add(new Estadio("Arena Condá", UF.SC, 22600, "6 de fevereiro de 1980", "R. Clevelândia, 656 E - Centro, Chapecó", R.mipmap.arena_conda));
        listaEstadios.add(new Estadio("Mineirão", UF.MG, 61846, "5 de setembro de 1965", "Av. Antônio Abrahão Caran, 1001 - São José", R.mipmap.mineirao));
        listaEstadios.add(new Estadio("Couto Pereira", UF.PR, 40310, "20 de novembro de 1932", "R. Ubaldino do Amaral, 37 - Alto da Glória", R.mipmap.couto_pereira));
        listaEstadios.add(new Estadio("Serra Dourada", UF.GO, 50049, "9 de março de 1975", "Av. Fued José Sebba, 1170 - Jardim Goiás", R.mipmap.serra_dourada));
        listaEstadios.add(new Estadio("Arena Grêmio", UF.RS, 60540, "8 de dezembro de 2012", "Av. Padre Leopoldo Brentano, 110 - Humaitá", R.mipmap.arena_gremio));
        listaEstadios.add(new Estadio("Engenhão - Nilton Santos", UF.RJ, 44661, "30 de junho de 2007", "R. José dos Reis, 425 - Engenho de Dentro", R.mipmap.engenhao));
        listaEstadios.add(new Estadio("Fonte Nova", UF.BA, 50000, "7 de abril de 2013", "Ladeira da Fonte das Pedras, s/n - Nazaré", R.mipmap.fonte_nova));
        listaEstadios.add(new Estadio("Arena da Baixada", UF.PR, 42372, "20 de junho de 1999", "R. Buenos Aires, 1260 - Água Verde, Curitiba", R.mipmap.arena_baixada));
        listaEstadios.add(new Estadio("Moisés Lucarelli", UF.SP, 17728, "12 de setembro de 1948", "Praça Dr. Francisco Ursaia, 1900 - Jd. Proença", R.mipmap.moises_lucarelli));
        listaEstadios.add(new Estadio("Ilha do Retiro", UF.PE, 32983, "4 de julho de 1937", "Rua Sport Club do Recife - Ilha do Retiro", R.mipmap.ilha_retiro));
        listaEstadios.add(new Estadio("Ressacada", UF.SC, 17826, "15 de novembro de 1983", "Av. Dep. Diomício Freitas, 1000 - Carianos", R.mipmap.ressacada));
        listaEstadios.add(new Estadio("Barradão", UF.BA, 34535, "9 de novembro de 1986", "Rua Artênio Valente, 1 - Canabrava", R.mipmap.barradao));
        listaEstadios.add(new Estadio("Beira-Rio", UF.RS, 51300, "6 de abril de 1969", "Av. Padre Cacique, 891 - Praia de Belas", R.mipmap.beira_rio));


    }

}
