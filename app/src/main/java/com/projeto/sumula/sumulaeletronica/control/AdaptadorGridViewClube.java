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
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;

import java.util.List;


/**
 * Created by Pedro on 29/09/2016.
 */

public class AdaptadorGridViewClube extends BaseAdapter {

    private Context context;
    private List<Clube> listaClubes;
    private ImageLoader  imageLoader;
    private LayoutInflater inflater;

    public AdaptadorGridViewClube(Context context, List<Clube> listaClubes, ImageLoader imageLoader) {
        this.context = context;
        this.listaClubes = listaClubes;
        this.imageLoader = imageLoader;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listaClubes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaClubes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;

        if(view == null){
            view = inflater.inflate(R.layout.item, parent, false);
            holder = new ViewHolder();
            view.setTag(holder);

            holder.networkImageView = (NetworkImageView) view.findViewById(R.id.nivImg);
            holder.imageView = (ImageView) view.findViewById(R.id.ivImg);
            holder.textView = (TextView) view.findViewById(R.id.tvTitle);

        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.networkImageView.setVisibility(view.VISIBLE);
        holder.networkImageView.setImageUrl(listaClubes.get(position).getImg(), imageLoader);

        //Imagem que aparece enquanto esta carregando
        holder.networkImageView.setDefaultImageResId(R.drawable.loading);

        //Imagem quando não houver imagem ou de erro no carregamento
        holder.networkImageView.setErrorImageResId(R.drawable.error);

        holder.textView.setText(listaClubes.get(position).getNome());

        return view;
    }

    private static class ViewHolder{
        NetworkImageView networkImageView;
        ImageView imageView;
        TextView textView;
    }
}
