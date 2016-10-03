package com.projeto.sumula.sumulaeletronica.control;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projeto.sumula.sumulaeletronica.model.Jogador;

import java.util.List;

/**
 * Created by Pedro on 03/10/2016.
 */

public class AdaptadorGridViewJogador extends BaseAdapter {

    private Context context;
    private List<Jogador> jogadores;

    public AdaptadorGridViewJogador(Context context, List<Jogador> jogadores) {
        this.context = context;
        this.jogadores = jogadores;
    }

    @Override
    public int getCount() {
        return jogadores.size();
    }

    @Override
    public Object getItem(int position) {
        return jogadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText(jogadores.get(position).getNome());
        return tv;
    }
}
