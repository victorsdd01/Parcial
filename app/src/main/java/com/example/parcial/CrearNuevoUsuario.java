 package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial.Database.DbProccess;
import com.example.parcial.Database.Entidades.Usuarios;

 public class CrearNuevoUsuario extends AppCompatActivity {
    EditText usuario,password,vpassword,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nuevo_usuario);

        iniciarController();
    }

    private void iniciarController()
      {
          usuario=(EditText)findViewById(R.id.CrearNu_edtxUsuario);
          password=(EditText)findViewById(R.id.CrearNu_edtxPassword);
          vpassword=(EditText)findViewById(R.id.CrearNu_edtxVerificarPassword);
          email=(EditText)findViewById(R.id.CrearNu_edtxEmail);
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
                                     //aqui se hace la insercion en la BD...
                                      GuardarUsuario(usuario,pasword);
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
                  Toast.makeText(this,"usuario insertado correctamente en la db",Toast.LENGTH_LONG).show();
              }
        }catch(Exception e){}
     } // llave del metodo guardar usuario...

}// llave de la clase...