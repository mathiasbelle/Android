package com.example.mathias.provam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class telaResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle mochila = getIntent().getExtras();
        double resultado = mochila.getDouble("resultado");
        int id = mochila.getInt("id");
        String resultadoString;
        TextView text = (TextView) findViewById(R.id.tvResultado);
        if(id == 0){
            resultadoString = "Área do Quadrado: "+resultado;
        }else if(id == 1){
            resultadoString = "Área do Triângulo: "+resultado;
        }else{
            resultadoString = "Área do Círculo: "+resultado;
        }
        //String resultadoString = "Resultado: "+resultado;

        text.setText(resultadoString);


    }
}
