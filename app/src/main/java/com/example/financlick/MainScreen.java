package com.example.financlick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        findViewById(R.id.fab).setOnClickListener(view -> telaMovimentacao());
    }


//    FloatingActionButton myFloatActBut = (FloatingActionButton) findViewById(R.id.floatingActionButton);
//    myFloatActBut.setOnClickListener(new View.OnClickListener() {
//        public void onClick(View v) {
//            Intent telaMovimentacao = new Intent(this, MainScreen.class);
//            startActivity(telaMovimentacao);
//        }
//    });

    private void setupFab() {

    }

    public void telaMovimentacao () {
        Intent telaMovimentacao = new Intent(this, Movimentacao.class);
        startActivity(telaMovimentacao);
    }

}
