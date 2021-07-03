package com.example.parcial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.parcial.Admin.Admin_Main;
import com.example.parcial.Admin.CrearNuevoUsuario;
import com.example.parcial.Database.DBparcial;
import com.example.parcial.Database.DbProccess;
import com.example.parcial.Database.Entidades.Usuarios;
import com.example.parcial.Normal_User.Usuario_normal_Main;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
     TextInputEditText usuario,password;
     Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciarController();
    }

    private void iniciarController()
     {
         usuario=(TextInputEditText) findViewById(R.id.edtx_usuario);
         password=(TextInputEditText) findViewById(R.id.edtx_password);
         sp1=(Spinner)findViewById(R.id.login_spinner_tipoUsuario);

         String TipoUsuario [] ={"Tipo de usuario","Usuario normal","Administrador"};
         Adapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,TipoUsuario);
         sp1.setAdapter((SpinnerAdapter) adapter);

     }

     // metodo que valida que exista un usuario...
     public  void IniciarSesion(View view){
          String usuario,password;
          //aqui se almacena lo que el usuario escribe en los inputs...

          usuario=this.usuario.getText().toString();
          password=this.password.getText().toString();

          if(!usuario.isEmpty()){
                if(!password.isEmpty()){
                      String seleccion=sp1.getSelectedItem().toString();
                      if(seleccion.equals("Usuario normal")|| seleccion.equals("Administrador")){
                            if(seleccion.equals("Usuario normal")){
                                startActivity(new Intent(getApplicationContext(), Usuario_normal_Main.class));
                            }else
                                if(seleccion.equals("Administrador")){
                                    startActivity(new Intent(getApplicationContext(), Admin_Main.class));
                                }

                      }else
                            {
                                AlertError();
                            }

                }else
                      {
                          this.password.setError("Este campo es requerido");
                      }

          } else
                  {
                     this.usuario.setError("Este campo es requerido");
                  }
    }

     public void  AlertError()
      {
          AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setTitle("Error");
            builder.setMessage("Debe elegir un tipo de usuario");
            builder.setCancelable(false);
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).show();
      }





}