package com.projeto.sumula.sumulaeletronica.control;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.model.Jogador;

import java.util.List;

/**
 * Created by Pedro on 03/10/2016.
 */

public class AdaptadorGridViewJogador extends BaseAdapter {

    private Context context;
    private List<Jogador> jogadores;
    private ImageLoader imageLoader;
    private LayoutInflater inflater;

    public AdaptadorGridViewJogador(Context context, List<Jogador> jogadores, ImageLoader imageLoader) {
        this.context = context;
        this.jogadores = jogadores;
        this.imageLoader = imageLoader;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
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
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;

        if(view == null){
            view = inflater.inflate(R.layout.item_jogador, parent, false);
            holder = new ViewHolder();
            view.setTag(holder);

            holder.networkImageView = (NetworkImageView) view.findViewById(R.id.nivImgJogador);
            holder.textView = (TextView) view.findViewById(R.id.tvTitleJogador);

        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.networkImageView.setVisibility(view.VISIBLE);
        holder.networkImageView.setImageUrl(jogadores.get(position).getImg(), imageLoader);

        //Imagem que aparece enquanto esta carregando
        holder.networkImageView.setDefaultImageResId(R.drawable.loading);

        //Imagem quando não houver imagem ou de erro no carregamento
        holder.networkImageView.setErrorImageResId(R.drawable.error);

        holder.textView.setText(jogadores.get(position).getNome());

        return view;
    }

    private static class ViewHolder{
        NetworkImageView networkImageView;
        TextView textView;
    }
}
