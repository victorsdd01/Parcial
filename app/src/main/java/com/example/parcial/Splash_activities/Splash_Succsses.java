package com.example.parcial.Splash_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.parcial.Login;
import com.example.parcial.R;

public class Splash_Succsses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_succsses);
        Time();
    }

    public void Time(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        },2400);

    }// llave del metodo time...

}// llave de la clase...