package com.example.mathias.autonomiaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicouAdicionar(View quemClicou){
        Intent intencao = new Intent(this, cadastroAbastecimento.class);
        startActivity(intencao);
    }
}

