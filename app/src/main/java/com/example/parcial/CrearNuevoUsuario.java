 package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.parcial.Database.DbProccess;
import com.example.parcial.Database.Entidades.Usuarios;
import com.google.android.material.textfield.TextInputEditText;

 public class CrearNuevoUsuario extends AppCompatActivity {
    TextInputEditText usuario,password,vpassword,email;
    Spinner sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nuevo_usuario);

        iniciarController();
    }

    private void iniciarController()
      {
          usuario=(TextInputEditText) findViewById(R.id.TextInputUsuario);
          password=(TextInputEditText) findViewById(R.id.TextInputpassword);
          vpassword=(TextInputEditText) findViewById(R.id.TextInputVerificarPassword);
          email=(TextInputEditText) findViewById(R.id.TextInputEmail);

          sp2=(Spinner)findViewById(R.id.CrearNu_spinner);
          String TipoUsuario[]={"Tipo de usuario","Usuario normal","Administrador"};
          Adapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,TipoUsuario);
          sp2.setAdapter((SpinnerAdapter) adapter);
      }

      public void CrearNuevoUsuario(View view)
       {
         String usuario,pasword,vpassword,email;

         usuario=this.usuario.getText().toString();
         pasword=this.password.getText().toString();
         vpassword=this.vpassword.getText().toString();
         email=this.email.getText().toString();

         if(!usuario.isEmpty())
           {
              if(!pasword.isEmpty())
                {
                    if(!vpassword.isEmpty())
                      {

                          if(!email.isEmpty())
                            {
                                if(vpassword.equals(pasword))
                                  {
                                      try {
                                          //aqui se hace la insercion en la BD...
                                          GuardarUsuario(usuario,pasword);
                                      }catch(Exception e){}

                                  }else
                                      {
                                         this.vpassword.setError("Las contraseñas no coinciden");
                                      }
                            }else
                                {
                                   this.email.setError("Este campo es requerido");
                                }
                      }else
                          {
                              this.vpassword.setError("Este campo es requerido");
                          }
                }else
                    {
                      this.password.setError("Este campo es requerido");
                    }
           }else
               {
                 this.usuario.setError("Este campo es requerido");
               }
       }// llave del metodo...

    // metodo para registrar usuario en la db...
    private void GuardarUsuario(String usuario,String password)
     {
        try {
            Usuarios obj = new Usuarios(usuario,password);
            DbProccess dbProccess = new DbProccess(getApplicationContext());
            if(dbProccess.GuardarUsuario(obj))
              {
                  startActivity(new Intent(getApplicationContext(),Login.class));
                  //AlertaUsuarioRegistrado();
                  //Toast.makeText(this,"usuario insertado correctamente en la db",Toast.LENGTH_LONG).show();
              }
        }catch(Exception e){}
     } // llave del metodo guardar usuario...

     public void AlertaUsuarioRegistrado()
     {
         AlertDialog.Builder alerta= new AlertDialog.Builder(this);
         alerta.setMessage("Usuario creado correctamente!!!")
                 .setCancelable(false)
                 .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         startActivity(new Intent(getApplicationContext(),Login.class));
                     }
                 })
                 .show();


     } //llace del metodo...

}// llave de la clase...