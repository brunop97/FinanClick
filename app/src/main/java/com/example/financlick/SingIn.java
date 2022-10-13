package com.example.financlick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SingIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
    }

    public void textCadastreSe (View v) {
        Intent telaSingUp = new Intent(this, SingUp.class);
        startActivity(telaSingUp);
    }

    public void mainScreen (View v) {
        Intent telaMainScreen = new Intent(this, MainScreen.class);
        startActivity(telaMainScreen);
    }
}