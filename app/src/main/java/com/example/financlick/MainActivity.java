package com.example.financlick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(30000, 1000) {

            public void onTick(long l) {

            }

            public void onFinish() {
            }
        }.start();
    }

    public void Login (View v) {
        Intent telaSingIn = new Intent(this, SingIn.class);
        startActivity(telaSingIn);
    }

}