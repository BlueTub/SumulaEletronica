package com.projeto.sumula.sumulaeletronica.persistence;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.projeto.sumula.sumulaeletronica.enumeration.BaseURL;
import com.projeto.sumula.sumulaeletronica.model.Cadastro;
import com.android.volley.Response;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pedro on 23/06/2017.
 */

public class CadastroJson {

    private Context context;

    public CadastroJson (Context context){
        this.context = context;
    }

    public void realizarCadastro(final Cadastro cadastro){
        Log.d("Cadastro  :  ", cadastro.getTipo().toString());
        Log.d("Cadastro  :  ", cadastro.getUsuario().getSenha().toString());
        Log.d("Cadastro  :  ", cadastro.getUsuario().getUsuario().toString());
        Log.d("Cadastro  :  ", cadastro.getNome().toString());

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest postRequest = new StringRequest(Request.Method.POST, BaseURL.URL.caminho + "cadastro/insereCadastro",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.d("Error.Response", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();

                params.put("nome", cadastro.getNome());
                params.put("cpf", cadastro.getCpf());
                params.put("registro", cadastro.getRegistro());
                params.put("tipo", cadastro.getTipo().name());
                params.put("usuario", cadastro.getUsuario().getUsuario());
                params.put("senha", cadastro.getUsuario().getSenha());
                Log.d("Request", cadastro.getNome());
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("Content-Type","application/json");
                return params;
            }
        };

//        Map<String, String> params = new HashMap();
//        params.put("nome", cadastro.getNome());
//        params.put("cpf", cadastro.getCpf());
//        params.put("registro", cadastro.getRegistro());
//        params.put("tipo", cadastro.getTipo().name());
//        params.put("usuario", cadastro.getUsuario().getUsuario());
//        params.put("senha", cadastro.getUsuario().getSenha());
//        Log.d("Request", cadastro.getUsuario().getUsuario());
//
//        JSONObject parameters = new JSONObject(params);
//
//        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, BaseURL.URL.caminho + "cadastro/insereCadastro", parameters,
//                new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.i("Response", "SUCESSO : " + response);
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//
//
//        });

        queue.add(postRequest);
    }


}
