package com.projeto.sumula.sumulaeletronica.control;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projeto.sumula.sumulaeletronica.model.Arbitro;
import com.projeto.sumula.sumulaeletronica.model.ListaArbitros;

import java.util.List;

/**
 * Created by Pedro on 05/10/2016.
 */

public class AdaptadorGridViewArbitro extends BaseAdapter {

    private Context context;
    private List<Arbitro> listaArbitros;

    public AdaptadorGridViewArbitro(Context context, List<Arbitro> listaArbitros) {
        this.context = context;
        this.listaArbitros = listaArbitros;
    }

    @Override
    public int getCount() {
        return listaArbitros.size();
    }

    @Override
    public Object getItem(int position) {
        return listaArbitros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText(listaArbitros.get(position).getNome());
        return tv;
    }
}
