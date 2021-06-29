package com.example.parcial.Splash_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.parcial.Login;
import com.example.parcial.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        time();

    }

    public void time()
     {
         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 startActivity(new Intent(SplashScreen.this, Login.class));
             }
         },5000);
     }
}// llave de la clase...