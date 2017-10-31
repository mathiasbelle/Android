package com.example.mathias.provam2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicouAvancar(View quemClicou){
        RadioGroup grupo = (RadioGroup) findViewById(R.id.opcoesCalculo);

        if(grupo.getCheckedRadioButtonId() == -1){
            Toast erro = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
            erro.show();
            return;
        }else{
            switch (grupo.getCheckedRadioButtonId()){
                case R.id.rbRetangulo:
                    Intent intencao = new Intent(this, dadosRetangulo.class);
                    startActivity(intencao);
                    break;
                case R.id.rbTriangulo:
                    Intent intencao2 = new Intent(this, dadosTriangulo.class);
                    startActivity(intencao2);
                    break;
                case R.id.rbCirculo:
                    Intent intencao3 = new Intent(this, dadosCirculo.class);
                    startActivity(intencao3);
                    break;
            }
        }

    }
}
