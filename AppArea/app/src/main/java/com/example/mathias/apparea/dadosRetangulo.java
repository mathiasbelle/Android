package com.example.mathias.apparea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class dadosRetangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_retangulo);
    }

    public void clicouCalcularRetangulo(View quemClicou){
        EditText baseText = (EditText) findViewById(R.id.etBase);
        EditText alturaText = (EditText) findViewById(R.id.etAltura);
        double resultado;

        try{
            resultado = Double.parseDouble(baseText.getText().toString()) * Double.parseDouble(alturaText.getText().toString()); // base*altura
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Entrada inválida!", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle mochila = new Bundle(getClassLoader());
        mochila.putDouble("resultado", resultado);
        Intent intencao = new Intent(this, telaResultado.class);
        mochila.putInt("id", 0);

        intencao.putExtras(mochila);
        startActivity(intencao);
    }
}
