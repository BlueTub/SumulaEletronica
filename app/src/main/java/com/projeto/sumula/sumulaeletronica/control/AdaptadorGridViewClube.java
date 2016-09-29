package com.projeto.sumula.sumulaeletronica.control;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projeto.sumula.sumulaeletronica.model.Clube;

import java.util.List;

/**
 * Created by Pedro on 29/09/2016.
 */

public class AdaptadorGridViewClube extends BaseAdapter {

    private Context context;
    List<Clube> lista;

    public AdaptadorGridViewClube(Context context, List<Clube> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText(lista.get(position).getNome());
        return tv;
    }
}
