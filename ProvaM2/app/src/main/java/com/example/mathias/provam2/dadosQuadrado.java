package com.example.mathias.provam2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class dadosQuadrado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_quadrado);
    }

    public void clicouCalcular(View quemClicou){
        EditText baseText = (EditText) findViewById(R.id.etBase);
        EditText alturaText = (EditText) findViewById(R.id.etAltura);
        double base = Double.parseDouble(baseText.getText().toString());
        double altura = Double.parseDouble(alturaText.getText().toString());
        double resultado = base*altura;
        String u = ""+resultado;

        Bundle mochila = new Bundle(getClassLoader());
        mochila.putDouble("resultado", resultado);
        Intent intencao = new Intent(this, telaResultado.class);
        int id = 0;
        mochila.putInt("id", id);

        intencao.putExtras(mochila);
        startActivity(intencao);
        //Toast t1 = Toast.makeText(getApplicationContext(), u, Toast.LENGTH_SHORT);
        //t1.show();
    }


}
