package com.example.mathias.autonomiaapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;

public class cadastroAbastecimento extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_abastecimento);

        Spinner postos = (Spinner) findViewById(R.id.spPostos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.postos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        postos.setAdapter(adapter);

    }

    public void clicouEscolher(View quemClicou){

        Intent intencao = new Intent(this, datePick.class);
        startActivityForResult(intencao, 2);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent dados) {

        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                String data = dados.getStringExtra("data");
                EditText editText = (EditText) findViewById(R.id.etData);
                editText.setText(data);
            }
        }
    }

//    public void clicouSalvar(View quemClicou){
//
//        ArrayList<Autonomia> lista;
//
//        lista = (ArrayList<Autonomia>) getIntent().getSerializableExtra("lista");
//
//        EditText kilometragem = (EditText) findViewById(R.id.etKilometragem);
//        EditText litros = (EditText) findViewById(R.id.etLitros);
//        EditText data = (EditText) findViewById(R.id.etData);
//        Spinner posto = (Spinner) findViewById(R.id.spPostos);
//        try {
//            double km = Double.parseDouble(kilometragem.getText().toString());
//
//            if (!lista.isEmpty()) {
//                if (km < lista.get(lista.size() - 1).getKilometragem()) {
//                    Toast.makeText(getApplicationContext(), "ERRO! A quilometragem atual não pode ser menor que a anterior!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//            Autonomia novo = new Autonomia(km, Double.parseDouble(litros.getText().toString()), data.getText().toString(), posto.getSelectedItem().toString());
//
//            lista.add(novo);
//
//            Intent intencao = new Intent(this, MainActivity.class);
//            intencao.putExtra("lista", lista);
//            setResult(Activity.RESULT_OK, intencao);
//            intencao.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            finish();
//        }catch (Exception e){
//            Toast.makeText(getApplicationContext(), "ERRO! Campo vazio!", Toast.LENGTH_SHORT).show();
//        }
//    }

    public void clicouSalvar(View quemClicou){

        //ArrayList<Autonomia> lista;

       // lista = (ArrayList<Autonomia>) getIntent().getSerializableExtra("lista");

        EditText kilometragem = (EditText) findViewById(R.id.etKilometragem);
        EditText litros = (EditText) findViewById(R.id.etLitros);
        EditText data = (EditText) findViewById(R.id.etData);
        Spinner posto = (Spinner) findViewById(R.id.spPostos);
        try {
            double km = Double.parseDouble(kilometragem.getText().toString());
//
//            if (!lista.isEmpty()) {
//                if (km < lista.get(lista.size() - 1).getKilometragem()) {
//                    Toast.makeText(getApplicationContext(), "ERRO! A quilometragem atual não pode ser menor que a anterior!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }



           Realm realm = Realm.getDefaultInstance();
           realm.beginTransaction();

            Autonomia a = realm.createObject(Autonomia.class);
            a.setKilometragem(km);
            a.setLitros(Double.parseDouble(litros.getText().toString()));
            a.setDataA(data.getText().toString());
            a.setPosto(posto.getSelectedItem().toString());
           // Autonomia novo = new Autonomia(km, Double.parseDouble(litros.getText().toString()), data.getText().toString(), posto.getSelectedItem().toString());




            realm.copyFromRealm(a);
            realm.commitTransaction();


            //lista.add(a);

            Intent intencao = new Intent(this, MainActivity.class);
           // intencao.putExtra("lista", lista);
           // setResult(Activity.RESULT_OK, intencao);
            intencao.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intencao);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERRO! Campo vazio!", Toast.LENGTH_SHORT).show();
        }
    }
}
