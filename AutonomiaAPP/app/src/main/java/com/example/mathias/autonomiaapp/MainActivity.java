package com.example.mathias.autonomiaapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    ArrayList<Autonomia> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        setContentView(R.layout.activity_main);

       // if(!lista.isEmpty()) {
            Realm realm = Realm.getDefaultInstance();
            RealmResults<Autonomia> results = realm.where(Autonomia.class).findAll();
            for (Autonomia atual : results) {
                lista.add(atual);
            }
        if(!lista.isEmpty()) {
            // FAZ A PARADA
            double litros = 0;
            double kilometragem = 0;
            for (int i = 0; i < lista.size(); i++) {
                litros += lista.get(i).getLitros();
                kilometragem += lista.get(i).getKilometragem();
            }
            kilometragem /= litros;
            TextView autonomia = (TextView) findViewById(R.id.tvAutonomia);
            autonomia.setText(String.format("%.2f", kilometragem));


        }

    }

//    public void onStart(Bundle abcs){
//                Realm realm = Realm.getDefaultInstance();
//                realm.beginTransaction();
//                Autonomia a = realm.createObject(Autonomia.class);
//                a.setDataA(lista.get(lista.size()-1).getDataA());
//                a.setPosto(lista.get(lista.size()-1).getPosto());
//                a.setKilometragem(lista.get(lista.size()-1).getKilometragem());
//                a.setLitros(lista.get(lista.size()-1).getLitros());
//                realm.copyFromRealm(a);
//                realm.commitTransaction();
//    }

    public void clicouAdicionar(View quemClicou){

        Intent intencao = new Intent(this, cadastroAbastecimento.class);
        //intencao.putExtra("lista", lista);
        startActivityForResult(intencao, 1);
    }

    public void clicouVisualizar(View quemClicou){

        Intent intencao = new Intent(this, visualizarAbastecimentos.class);
       // intencao.putExtra("lista", lista);
        startActivity(intencao);

    }


 //   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (requestCode == 1) {
//            if (resultCode == Activity.RESULT_OK) {
                //lista = (ArrayList<Autonomia>) data.getSerializableExtra("lista");
//                double litros = 0;
//                double kilometragem = 0;
//                for (int i = 0; i < lista.size(); i++) {
//                    litros += lista.get(i).getLitros();
//                    kilometragem += lista.get(i).getKilometragem();
//                }
//                kilometragem /= litros;
//                TextView autonomia = (TextView) findViewById(R.id.tvAutonomia);
//                autonomia.setText(String.format("%.2f", kilometragem));
//
////
////                Realm realm = Realm.getDefaultInstance();
////                realm.beginTransaction();
////                Autonomia a = realm.createObject(Autonomia.class);
////                a.setDataA(lista.get(lista.size()-1).getDataA());
////                a.setPosto(lista.get(lista.size()-1).getPosto());
////                a.setKilometragem(lista.get(lista.size()-1).getKilometragem());
////                a.setLitros(lista.get(lista.size()-1).getLitros());
////                realm.copyFromRealm(a);
////                realm.commitTransaction();
//            }
            //}


        //}
  //  }


}

