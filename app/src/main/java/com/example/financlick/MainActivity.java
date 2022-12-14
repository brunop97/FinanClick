package com.example.financlick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarTelaLogin();
            }
        }, 2000);
    }

    private void mostrarTelaLogin() {
            Intent intent = new Intent(MainActivity.this,SingIn.class);
            startActivity(intent);
            finish();
    }
}