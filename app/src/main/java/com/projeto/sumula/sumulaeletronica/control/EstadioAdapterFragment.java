package com.projeto.sumula.sumulaeletronica.control;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.model.Estadio;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

import static com.projeto.sumula.sumulaeletronica.R.layout.dialog_estadio_info;
import static com.projeto.sumula.sumulaeletronica.R.layout.estadio_flow_view;


/**
 * Created by Thiago on 02/03/2017.
 */

public class EstadioAdapterFragment extends BaseAdapter{

    private ArrayList<Estadio> listaEstadios;
    private Context context;
    private LayoutInflater inflater;

    public EstadioAdapterFragment(Context context, ArrayList<Estadio> listaEstadios) {
        this.listaEstadios = listaEstadios;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listaEstadios.size();
    }

    @Override
    public Estadio getItem(int position) {
        return listaEstadios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(estadio_flow_view, parent, false);
            viewHolder = new ViewHolder(convertView);

           // LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (EstadioAdapterFragment.ViewHolder) convertView.getTag();
        }

        viewHolder.imagemEstadio.setImageResource(listaEstadios.get(position).getFoto());
        viewHolder.nomeEstadio.setText(listaEstadios.get(position).getNome());

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(dialog_estadio_info);
                dialog.setCancelable(true); // dimiss when touching outside
                dialog.setTitle("Game Details");

                TextView text = (TextView) dialog.findViewById(R.id.name);
                text.setText(getItem(position).getNome());
                TextView textCapacidade = (TextView) dialog.findViewById(R.id.capacidade);
                textCapacidade.setText(String.valueOf(getItem(position).getCapacidade()));
                TextView textUF = (TextView) dialog.findViewById(R.id.uf);
                textUF.setText(getItem(position).getUf().toString());
                TextView textEndereco = (TextView) dialog.findViewById(R.id.endereco);
                textUF.setText((getItem(position).getEndereco()));
                TextView textData = (TextView) dialog.findViewById(R.id.data_inauguracao);
                textData.setText(String.valueOf(getItem(position).getDataInauguracao()));
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(getItem(position).getFoto());


                dialog.show();
            }
        };
    }

    private static class ViewHolder {
        private TextView nomeEstadio;
        private ImageView imagemEstadio;
        private TextView capacidade;


        public ViewHolder(View v) {
            imagemEstadio = (ImageView) v.findViewById(R.id.image);
            nomeEstadio = (TextView) v.findViewById(R.id.name);
        }
    }
}
