package com.example.parcial.Normal_User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.parcial.R;

public class Verprocedimiento extends AppCompatActivity {

    TextView procedimiento;
    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verprocedimiento);
        iniciarController();

    }

    private void iniciarController() {
        procedimiento=(TextView)findViewById(R.id.verProcedimiento_TxvProcedimiento);
        datos=getIntent().getExtras();
        procedimiento.setText(datos.getString("procedimiento"));
    }

    public void volver(View view ){
        startActivity(new Intent(getApplicationContext(), Usuario_normal_Main.class));
    }// llave del metodo volver...


}