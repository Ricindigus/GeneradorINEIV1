package pe.com.ricindigus.generadorinei.adapters.creacion;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.pojos.Modulo;

/**
 * Created by otin016 on 28/06/2017.
 */

public class CreacionModulosAdapter extends RecyclerView.Adapter<CreacionModulosAdapter.ViewHolder>{
    ArrayList<Modulo> modulos;
    Context context;

    public CreacionModulosAdapter(ArrayList<Modulo> modulos, Context context) {
        this.modulos = modulos;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modulo,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtId.setText(modulos.get(position).getID());
        holder.txtTitulo.setText(modulos.get(position).getTITULO());
        holder.txtCabecera.setText(modulos.get(position).getCABECERA());
        holder.txtNombreTabla.setText(modulos.get(position).getTABLA_XML());
        holder.txtNumeroPagina.setText(modulos.get(position).getNPAGINAS());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView txtId;
        TextView txtTitulo;
        TextView txtCabecera;
        TextView txtNombreTabla;
        TextView txtNumeroPagina;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_modulos);
            txtId = (TextView) itemView.findViewById(R.id.modulo_id);
            txtTitulo = (TextView) itemView.findViewById(R.id.modulo_titulo);
            txtCabecera = (TextView) itemView.findViewById(R.id.modulo_cabecera);
            txtNombreTabla = (TextView) itemView.findViewById(R.id.modulo_tabla);
            txtNumeroPagina = (TextView) itemView.findViewById(R.id.modulo_pagina);
        }
    }

    @Override
    public int getItemCount() {
        return modulos.size();
    }
}
