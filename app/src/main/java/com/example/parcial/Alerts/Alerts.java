package com.example.parcial.Alerts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.example.parcial.CrearNuevoUsuario;
import com.example.parcial.Login;

public class Alerts {

    Activity activity;

    public  Alerts(Activity activity)
     {
         this.activity=activity;
     }

    //En esta clase estan todas las ventanitas emergentes "alertas" usen POO para invocarlas...

   public void AlertaUsuario()
    {
        AlertDialog.Builder alerta= new AlertDialog.Builder(activity);
        alerta.setMessage("Usuario creado correctamente!!!")
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.startActivity(new Intent(activity,Login.class));
                    }
                })
                .show();


    } //llace del metodo...
}
