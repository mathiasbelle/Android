package com.example.mathias.autonomiaapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mathias on 26/11/2017.
 */

public class AutonomiaHolder extends RecyclerView.ViewHolder {

    private TextView tvData;
    private TextView tvLitros;
    private TextView tvKilometros;
    private ImageView ivFoto;

    public AutonomiaHolder(View itemView) {
        super(itemView);

        this.tvData = itemView.findViewById(R.id.tvData);
        this.tvLitros = itemView.findViewById(R.id.tvLitros);
        this.tvKilometros = itemView.findViewById(R.id.tvKilometros);
        this.ivFoto = itemView.findViewById(R.id.ivFoto);
    }

    public void atualizaObjeto(Autonomia autonomia){
        tvData.setText( autonomia.getDataA() );
        tvLitros.setText( Double.toString( autonomia.getLitros() ));
        String s = ""+autonomia.getKilometragem();
        tvKilometros.setText(s);

        if(autonomia.getPosto().equals("Petrobras")){
            ivFoto.setImageResource(R.drawable.petrobras);
        }else if (autonomia.getPosto().equals("Ipiranga")){
            ivFoto.setImageResource(R.drawable.ipiranga);
        }else if (autonomia.getPosto().equals("Shell")){
            ivFoto.setImageResource(R.drawable.shell);
        }else if (autonomia.getPosto().equals("Texaco")){
            ivFoto.setImageResource(R.drawable.texaco);
        }else{
            ivFoto.setImageResource(R.drawable.outro);
        }


    }
}
