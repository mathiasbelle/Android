package com.example.mathias.provam2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class dadosCirculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_circulo);
    }

    public void clicouCalcularCirculo(View quemClicou){
        EditText entradaRaio = (EditText) findViewById(R.id.etRaio);
        double resultado;

        try {
            resultado = Double.parseDouble(entradaRaio.getText().toString());
            resultado = 3.14 * resultado * resultado; // pi*r*r
        }catch (Exception e){
            Toast erro = Toast.makeText(getApplicationContext(), "Entrada inválida!", Toast.LENGTH_SHORT);
            erro.show();
            return;
        }

        Bundle mochila = new Bundle(getClassLoader());
        mochila.putDouble("resultado", resultado);
        mochila.putInt("id", 2);
        Intent intencao = new Intent(this, telaResultado.class);
        intencao.putExtras(mochila);
        startActivity(intencao);
    }
}
