package com.example.mathias.provam2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class dadosTriangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_triangulo);
    }

    public void clicouCalcularTriangulo(View quemClicou){
        EditText baseText = (EditText) findViewById(R.id.etBase);
        EditText alturaText = (EditText) findViewById(R.id.etAltura);
        double resultado;

        try{
        resultado = Double.parseDouble(baseText.getText().toString()) * Double.parseDouble(alturaText.getText().toString()) /2; //base*altura/2
        }catch (Exception e){
            Toast erro = Toast.makeText(getApplicationContext(), "Entrada inválida!", Toast.LENGTH_SHORT);
            erro.show();
            return;
        }

        Bundle mochila = new Bundle(getClassLoader());
        mochila.putDouble("resultado", resultado);
        Intent intencao = new Intent(this, telaResultado.class);
        mochila.putInt("id", 1);

        intencao.putExtras(mochila);
        startActivity(intencao);

    }
}
