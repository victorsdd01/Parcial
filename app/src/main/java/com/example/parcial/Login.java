package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
     EditText usuario,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciarController();
    }

    private void iniciarController()
     {
         usuario=(EditText)findViewById(R.id.edtx_usuario);
         password=(EditText)findViewById(R.id.edtx_password);

     }

     // metodo que valida que exista un usuario...
     public  void IniciarSesion(View view)
      {
          String usuario,password;
          //aqui se almacena lo que el usuario escribe en los inputs...
          usuario=this.usuario.getText().toString();
          password=this.password.getText().toString();

          if(!usuario.isEmpty())
            {
                if(!password.isEmpty())
                  {
                      //aqui se va a la otra activity
                  }else
                      {

                      }

            } else
                  {

                  }
      }

      // metodo para registrar un nuevo usuario

    public void CrearNuevoUsuario(View view)
     {
         startActivity(new Intent(getApplicationContext(),CrearNuevoUsuario.class));
     }


}