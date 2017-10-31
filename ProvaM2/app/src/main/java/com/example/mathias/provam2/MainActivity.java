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
//        int check = grupo.getCheckedRadioButtonId();
//        String u = ""+check;
//        Toast t1 = Toast.makeText(getApplicationContext(), u, Toast.LENGTH_SHORT);

        if(grupo.getCheckedRadioButtonId() == -1){
            Toast erro = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
            erro.show();
            //t1.show();
            return;
        }else{
            //Toast torrada = Toast.makeText(getApplicationContext(), "Tudo certo!", Toast.LENGTH_SHORT);
           // t1.show();
            switch (grupo.getCheckedRadioButtonId()){
                case R.id.rbQuadrado:
                    Intent intencao = new Intent(this, dadosQuadrado.class);
                    startActivity(intencao);
                    break;
                case R.id.rbTriangulo:
                    Intent intencao2 = new Intent(this, dadosTriangulo.class);
                    startActivity(intencao2);
                    break;
                case R.id.rbCirculo:
                    //Toast torrada = Toast.makeText(getApplicationContext(), "Tudo certo!", Toast.LENGTH_SHORT);
                    Intent intencao3 = new Intent(this, dadosCirculo.class);
                    startActivity(intencao3);
                    break;


            }
        }


    }
}
