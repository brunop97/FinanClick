package com.example.financlick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SingUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
    }

    public void textLogin (View v) {
        Intent telaSingIn = new Intent(this, SingIn.class);
        startActivity(telaSingIn);
    }

    public void mainScreen (View v) {
        Intent telaMainScreen = new Intent(this, MainScreen.class);
        startActivity(telaMainScreen);
    }
}