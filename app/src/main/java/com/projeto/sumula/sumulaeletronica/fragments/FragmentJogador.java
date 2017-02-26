package com.projeto.sumula.sumulaeletronica.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.enumeration.PosicaoJogador;
import com.projeto.sumula.sumulaeletronica.enumeration.UF;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.Jogador;
import com.projeto.sumula.sumulaeletronica.model.ListaJogadores;
import com.projeto.sumula.sumulaeletronica.persistence.JogadorJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJogador extends Fragment {

    private EditText etPesquisar;
    private AutoCompleteTextView completeTextView;
    private RadioGroup radioGroup;
    private RadioButton rbNome, rbClube, rbPosicao, rbUF;
    private Button btnPesquisar;
    private Spinner spnUF, spnPosicao;
    private List<PosicaoJogador> posicoes;
    private List<UF> ufs;
    private ArrayAdapter<UF> adapterUF;
    private ArrayAdapter<PosicaoJogador> adapterPosicao;
    private static String[] CLUBES;
    private ArrayAdapter<String> adp;
    private GridView gridView;

    private RequestQueue requestQueue;

    public FragmentJogador() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogador, container, false);

       CLUBES = new String[]{"Corinthians", "São Paulo", "Flamengo",
                "Palmeiras", "Vasco", "Botafogo", "Cruzeiro', 'Internacional", "Ceará", "Figueirense",
                "Coritiba", "Fluminense", "Grêmio", "Santos", "Atlético-MG", "Bahia",
                "Atlético-GO", "Avaí", "América-MG", "Atlético-PR"};

        etPesquisar = (EditText) view.findViewById(R.id.etPesquisa);
        radioGroup = (RadioGroup) view.findViewById(R.id.rgPesquisaJogador);
        rbNome = (RadioButton) view.findViewById(R.id.rbJogadorNome);
        rbClube = (RadioButton) view.findViewById(R.id.rbJogadorClube);
        rbPosicao = (RadioButton) view.findViewById(R.id.rbJogadorPosicao);
        rbUF = (RadioButton) view.findViewById(R.id.rbJogadorUF);
        btnPesquisar = (Button) view.findViewById(R.id.btnPesquisarJogador);
        spnPosicao = (Spinner) view.findViewById(R.id.spnPosicao);
        spnUF = (Spinner) view.findViewById(R.id.spnUF);
        completeTextView = (AutoCompleteTextView) view.findViewById(R.id.actvClubes);
        gridView = (GridView) view.findViewById(R.id.gvPCJ);


        requestQueue = Volley.newRequestQueue(FragmentJogador.this.getActivity());

        rbNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        rbClube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        rbPosicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        rbUF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        gridView.setOnItemClickListener( new GridView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Clube  clube = (Clube) parent.getAdapter().getItem(position);

                JogadorJson j = new JogadorJson(FragmentJogador.this.getActivity(), clube, "", "id", new JogadorJson.onResponseRetrofitListenner(){
                    @Override
                    public void responseJogadores(ListaJogadores listaJogadores){
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("lista", listaJogadores);

                        FragmentJogadorPesquisado fr = new FragmentJogadorPesquisado();
                        fr.setArguments(bundle);
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.relativelayout_for_fragment, fr, fr.getTag());
                        fragmentTransaction.commit();
                    }
                });

                j.execute();
            }
        });

        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String param = null;
//                String tipo = null;
//                if (rbPosicao.isChecked()) {
//                    param = spnPosicao.getSelectedItem().toString();
//                    tipo = "posicao";
//                }else if (rbUF.isChecked()){
//                    param = spnUF.getSelectedItem().toString();
//                    tipo = "uf";
//                }else if (rbNome.isChecked()){
//                    param = etPesquisar.getText().toString();
//                    Log.i("PARAM", param);
//                    tipo = "nome";
//                }else if (rbClube.isChecked()){
//                    ClubeJson c = new ClubeJson(FragmentJogador.this.getActivity(), new ClubeJson.onResponseRetrofitListenner() {
//                        @Override
//                        public void responseClubes(ListaClubes listaClubes) {
//                            try {
//                                if (listaClubes != null) {
//                                    gridView.setAdapter(new AdaptadorGridViewClube(
//                                            FragmentJogador.this.getActivity(),
//                                            listaClubes));
//                                }
//                            }catch (NullPointerException e) {
//                                Toast.makeText(FragmentJogador.this.getActivity(), "ERRO", Toast.LENGTH_LONG).show();
//                            }
//                        }
//                    });
//
//                    c.execute();
//                    //param = completeTextView.getText().toString();
//                    //tipo = "clube";
//                }else{
//                    Toast.makeText(FragmentJogador.this.getActivity(),
//                            "Selecione um tipo de pesquisa", Toast.LENGTH_LONG).show();
//                }
//
//                if (param != null && tipo != null)
//                    pesquisa(param, tipo);



                //REQUISIÇÃO PELO VOLLEY

                //Requisição do Web Service
                JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, "http://192.168.0.14:8080/RestFul/jogador/listarTodos", null,
                        new Response.Listener<JSONObject>()
                        {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    //lista de jogadores
                                    List<Jogador> listaJogadores = new ArrayList<Jogador>();

                                    //cria um Array com todos jogadores do banco
                                    JSONArray jsonArray = response.getJSONArray("jogador");

                                    //for para percorrer o array
                                    for (int i = 0; i < jsonArray.length(); i++){

                                        //transforma em objeto
                                        JSONObject jogadores = jsonArray.getJSONObject(i);
                                        Jogador j = new Jogador();
                                        j.setNome(jogadores.getString("nome"));
                                        listaJogadores.add(j);
                                    }

                                    //for para mostrar os nomes dos jogadores no console
                                    for (Jogador j : listaJogadores) {
                                        Log.d("Retorno", j.getNome());
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        //Erro na requisição
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.d("Error.Response", volleyError.getMessage().toString());
                            }
                        }
                );

                requestQueue.add(getRequest);
            }
        });

        //Carrega lista com o enum
        ufs = Arrays.asList(UF.values());
        posicoes = Arrays.asList(PosicaoJogador.values());

        return view;
    }

    public void pesquisa(String param, String tipo){
        JogadorJson j = new JogadorJson(FragmentJogador.this.getActivity(), new Clube(), param, tipo, new JogadorJson.onResponseRetrofitListenner(){
            @Override
            public void responseJogadores(ListaJogadores listaJogadores){
                Bundle bundle = new Bundle();
                bundle.putSerializable("lista", listaJogadores);

                FragmentJogadorPesquisado fr = new FragmentJogadorPesquisado();
                fr.setArguments(bundle);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.relativelayout_for_fragment, fr, fr.getTag());
                fragmentTransaction.commit();
            }
        });

        j.execute();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbJogadorNome:
                if (checked)
                    btnPesquisar.setVisibility(View.VISIBLE);
                    etPesquisar.setVisibility(View.VISIBLE);

                    spnPosicao.setVisibility(View.INVISIBLE);
                    spnUF.setVisibility(View.INVISIBLE);
                    completeTextView.setVisibility(View.INVISIBLE);
                break;
            case R.id.rbJogadorClube:
                if (checked)
                    adp = new ArrayAdapter<>(FragmentJogador.this.getActivity(), android.R.layout.simple_dropdown_item_1line, CLUBES);
                    completeTextView.setAdapter(adp);

                    completeTextView.setVisibility(View.VISIBLE);
                    btnPesquisar.setVisibility(View.VISIBLE);

                    etPesquisar.setVisibility(View.INVISIBLE);
                    spnPosicao.setVisibility(View.INVISIBLE);
                    spnUF.setVisibility(View.INVISIBLE);
                break;
            case R.id.rbJogadorPosicao:
                if (checked)
                    adapterPosicao = new ArrayAdapter<>(
                            FragmentJogador.this.getActivity(),
                            android.R.layout.simple_spinner_item, posicoes);

                    adapterPosicao.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnPosicao.setAdapter(adapterPosicao);

                    btnPesquisar.setVisibility(View.VISIBLE);
                    spnPosicao.setVisibility(View.VISIBLE);

                    completeTextView.setVisibility(View.INVISIBLE);
                    spnUF.setVisibility(View.INVISIBLE);
                    etPesquisar.setVisibility(View.INVISIBLE);
                    break;
            case R.id.rbJogadorUF:
                if (checked)
                    adapterUF = new ArrayAdapter<>(
                            FragmentJogador.this.getActivity(),
                            android.R.layout.simple_spinner_item, ufs);

                    adapterUF.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnUF.setAdapter(adapterUF);

                    btnPesquisar.setVisibility(View.VISIBLE);
                    spnUF.setVisibility(View.VISIBLE);

                    completeTextView.setVisibility(View.INVISIBLE);
                    spnPosicao.setVisibility(View.INVISIBLE);
                    etPesquisar.setVisibility(View.INVISIBLE);
                    break;
        }
    }

}
