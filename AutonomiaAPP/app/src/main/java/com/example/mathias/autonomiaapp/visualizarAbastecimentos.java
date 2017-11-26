package com.example.mathias.autonomiaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class visualizarAbastecimentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_abastecimentos);

        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);

        AutonomiaAdapter adapter = new AutonomiaAdapter();
        adapter.setLista((ArrayList<Autonomia>) getIntent().getSerializableExtra("lista"));
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setAdapter(adapter);
    }
}
