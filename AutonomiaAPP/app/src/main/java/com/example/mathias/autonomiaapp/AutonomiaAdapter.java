package com.example.mathias.autonomiaapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Mathias on 02/12/2017.
 */


public class AutonomiaAdapter extends RecyclerView.Adapter {

    private ArrayList<Autonomia> lista;

    public void setLista(ArrayList<Autonomia> lista){
        this.lista = lista;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_itens, parent, false);
        AutonomiaHolder gaveta = new AutonomiaHolder(layoutView);
        Log.d("RV", "Criando a gaveta "+gaveta.toString());
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AutonomiaHolder gaveta = (AutonomiaHolder) holder;
        Autonomia atual = this.lista.get(position);
        gaveta.atualizaObjeto( atual );
        Log.d("RV", "Atualizando a gaveta "+gaveta.toString()+" com o objteto "+position);
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }
}