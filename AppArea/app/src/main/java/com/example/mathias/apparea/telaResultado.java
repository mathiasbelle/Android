package com.example.mathias.apparea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class telaResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resultado);

        Bundle mochila = getIntent().getExtras();
        double resultado = mochila.getDouble("resultado");
        int id = mochila.getInt("id");
        String resultadoString;
        TextView text = (TextView) findViewById(R.id.tvResultado);
        ImageView imagem = (ImageView) findViewById(R.id.ivImagem);
        if(id == 0){
            resultadoString = "Área do Retângulo: "+resultado+" cm²";
            imagem.setImageResource(R.drawable.rectangle);
        }else if(id == 1){
            resultadoString = "Área do Triângulo: "+resultado+" cm²";
            imagem.setImageResource(R.drawable.triangle);
        }else{
            resultadoString = "Área do Círculo: "+resultado+" cm²";
            imagem.setImageResource(R.drawable.circle);
        }
        text.setText(resultadoString);
    }

    public void clicouComecarNovamente(View quemClicou){
        Intent intencao = new Intent(this, MainActivity.class);
        intencao.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intencao);
    }
}
