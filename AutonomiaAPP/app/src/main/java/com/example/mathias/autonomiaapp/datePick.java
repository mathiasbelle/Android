package com.example.mathias.autonomiaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.DatePicker;

public class datePick extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_pick);
    }

    public void clicouConfirmar(View quemClicou){
        DatePicker data = (DatePicker) findViewById(R.id.dpData);
        String dataString = ""+data.getDayOfMonth()+"/"+(data.getMonth()+1)+"/"+data.getYear();

        Intent intencao = new Intent(this, cadastroAbastecimento.class);
        intencao.putExtra("data", dataString);
        setResult(Activity.RESULT_OK, intencao);
        finish();
    }
}
