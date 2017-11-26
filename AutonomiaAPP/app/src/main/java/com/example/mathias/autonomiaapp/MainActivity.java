package com.example.mathias.autonomiaapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Autonomia> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        double litros=0;
//        double kilometragem=0;
//        for(int i = 0; i < lista.size(); i++){
//            litros+=lista.get(i).getLitros();
//            kilometragem+=lista.get(i).getLitros();
//        }
//        litros/=kilometragem;
//        String at = ""+litros;
//        TextView autonomia  = (TextView) findViewById(R.id.tvAutonomia);
//        autonomia.setText("Autonomia atual: \n"+at+" km/l");


    }

    public void clicouAdicionar(View quemClicou){

//        lista.add(new Autonomia(120.5, 50.9, "19/05/2012", "Petrobras"));
//        lista.add(new Autonomia(120.5, 50.9, "02/01/2013", "Ipiranga"));
//        lista.add(new Autonomia(120.5, 50.9, "30/07/2014", "Texaco"));
//        lista.add(new Autonomia(120.5, 50.9, "01/05/2015", "foda-se"));

        Intent intencao = new Intent(this, cadastroAbastecimento.class);
        intencao.putExtra("lista", lista);
        startActivityForResult(intencao, 1);
    }

    public void clicouVisualizar(View quemClicou){
        //ArrayList<Autonomia> lista = new ArrayList<>();
//        lista.add(new Autonomia(120.5, 50.9, "19/05/2012", "Petrobras"));
//        lista.add(new Autonomia(120.5, 50.9, "02/01/2013", "Ipiranga"));
//        lista.add(new Autonomia(120.5, 50.9, "30/07/2014", "Texaco"));
//        lista.add(new Autonomia(120.5, 50.9, "01/05/2015", "foda-se"));

        //Toast.makeText(getApplicationContext(), "AQUI "+lista.get(0).getPosto(), Toast.LENGTH_LONG);
        Intent intencao = new Intent(this, visualizarAbastecimentos.class);
        intencao.putExtra("lista", lista);
        startActivity(intencao);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                lista = (ArrayList<Autonomia>) data.getSerializableExtra("lista");
                double litros=0;
                double kilometragem=0;
                for(int i = 0; i < lista.size(); i++){
                    litros+=lista.get(i).getLitros();
                    kilometragem+=lista.get(i).getKilometragem();
                }
                kilometragem/=litros;
                TextView autonomia  = (TextView) findViewById(R.id.tvAutonomia);
                autonomia.setText(String.format("%.2f", kilometragem));
            }
        }
    }
}

