package com.projeto.sumula.sumulaeletronica.control;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;

import java.util.List;

/**
 * Created by Pedro on 29/09/2016.
 */

public class AdaptadorGridViewClube extends BaseAdapter {

    private Context context;
    private ListaClubes listaClubes;

    public AdaptadorGridViewClube(Context context, ListaClubes listaClubes) {
        this.context = context;
        this.listaClubes = listaClubes;
    }

    @Override
    public int getCount() {
        return listaClubes.clube.size();
    }

    @Override
    public Object getItem(int position) {
        return listaClubes.clube.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText(listaClubes.clube.get(position).getNome());
        return tv;


//        ImageView iv = new ImageView(context);
//        iv.setAdjustViewBounds(true);
//        iv.setImageResource(lista[position]);
//        return iv;
    }
}
