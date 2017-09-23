package com.projeto.sumula.sumulaeletronica.persistence;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.projeto.sumula.sumulaeletronica.enumeration.BaseURL;
import com.projeto.sumula.sumulaeletronica.model.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pedro on 17/06/2017.
 */

public class LoginJson {

    private Context context;
    private RequestQueue requestQueue;
    private Usuario u;

    public LoginJson (Context context){
        this.context = context;
    }

    public Usuario login(String usuario, String senha){
        requestQueue = Volley.newRequestQueue(context);
        u = new Usuario();
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, BaseURL.URL.caminho + "usuario/login/" + usuario + "/" + senha, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            u.setUsuario(response.getString("usuario"));
                            //u.setSenha(response.getString("senha"));
                            u.setChave(response.getString("chave"));
                            u.setDataCriacao(response.getString("dataCriacao"));
                            u.setId(response.getLong("id"));
                        }catch (Exception e){
                            Log.d("ERRO : ", e.getMessage());
                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.getMessage().toString());
                    }
                }
        );

        requestQueue.add(getRequest);
        return u;
    }



}
