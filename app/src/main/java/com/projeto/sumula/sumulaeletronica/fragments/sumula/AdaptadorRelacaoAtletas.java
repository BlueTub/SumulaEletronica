package com.projeto.sumula.sumulaeletronica.fragments.sumula;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.model.Jogador;

import java.util.List;

/**
 * Created by Pedro on 26/09/2017.
 */

public class AdaptadorRelacaoAtletas extends BaseAdapter {

    private Context context;
    private List<Jogador> jogadores;
    private LayoutInflater inflater;

    public AdaptadorRelacaoAtletas(Context context, List<Jogador> jogadores) {
        this.context = context;
        this.jogadores = jogadores;
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
            view = inflater.inflate(R.layout.item_relacao_atletas, parent, false);
            holder = new ViewHolder();
            view.setTag(holder);

            holder.descricao = (TextView) view.findViewById(R.id.itemRelacaoNomeJogador);
            holder.cartaoAmarelo = (CheckBox) view.findViewById(R.id.cbCartaoAmarelo);
            holder.descricaoCartaoAmarelo = (TextView) view.findViewById(R.id.itemRelacaoCartaoAmarelo);
            holder.cartaoAmarelo2 = (CheckBox) view.findViewById(R.id.cbCartaoAmarelo2);
            holder.descricaoCartaoAmarelo2 = (TextView) view.findViewById(R.id.itemRelacaoCartaoAmarelo2);
            holder.cartaoVermelho = (CheckBox) view.findViewById(R.id.cbCartaoVermelho);
            holder.descricaoCartaoVermelho = (TextView) view.findViewById(R.id.itemRelacaoCartaoVermelho);
            holder.npGols = (NumberPicker) view.findViewById(R.id.npGols);
            holder.descricaoGols = (TextView) view.findViewById(R.id.itemRelacaoGols);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.descricao.setText(jogadores.get(position).getNome());
        holder.cartaoVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.cartaoAmarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.descricaoCartaoAmarelo.setText(" Cartão Amarelo");
        holder.descricaoCartaoAmarelo2.setText(" Cartão Amarelo");
        holder.descricaoCartaoVermelho.setText(" Cartão Vermelho");
        holder.descricaoGols.setText(" Gols");
        return view;
    }

    private static class ViewHolder{
        TextView descricao;
        CheckBox cartaoAmarelo;
        TextView descricaoCartaoAmarelo;
        CheckBox cartaoAmarelo2;
        TextView descricaoCartaoAmarelo2;
        CheckBox cartaoVermelho;
        TextView descricaoCartaoVermelho;
        NumberPicker npGols;
        TextView descricaoGols;

    }
}
