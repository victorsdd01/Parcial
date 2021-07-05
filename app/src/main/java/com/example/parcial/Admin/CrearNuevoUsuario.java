 package com.example.parcial.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.parcial.Database.DBparcial;
import com.example.parcial.R;
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
                                      String TipoUsuario=sp2.getSelectedItem().toString();
                                      if(TipoUsuario.equals("Usuario normal") || TipoUsuario.equals("Administrador")){
                                          InsertarNuevoUsuario(TipoUsuario);
                                      }else{errorAlert();}

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

     private void errorAlert(){

        androidx.appcompat.app.AlertDialog.Builder builder= new androidx.appcompat.app.AlertDialog.Builder(this);
         builder.setTitle("Error");
         builder.setMessage("Debe elegir un tipo de usuario");
         builder.setCancelable(false);
         builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {

             }
         }).show();
     }

     public void InsertarNuevoUsuario(String tipoUsuario){

        String usuario,password;

         usuario=this.usuario.getText().toString();
         password=this.password.getText().toString();

         DBparcial dbParcial  = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
         SQLiteDatabase db = dbParcial.getWritableDatabase();
         if(db!=null){
             try {
                 ContentValues values = new ContentValues();
                 values.put("nombre_usuario",usuario);
                 values.put("password_usuario",password);
                 values.put("tipoUsuario_usuario",tipoUsuario);

                 db.insert("t_usuarios",null,values);
                 db.close();
                 Toast.makeText(this,"Se a insertado correctamente el usaurio: "+usuario+"y el password: "+password+"",Toast.LENGTH_LONG).show();
                 startActivity(new Intent(getApplicationContext(),Admin_Main.class));
             }catch (Exception e){Toast.makeText(this,"ha ocurrido un error de excepcion al insertar el usuario",Toast.LENGTH_LONG).show();}
         }else{Toast.makeText(this,"Error en db!=null :( ",Toast.LENGTH_LONG).show();}
     }//llave del metodo crearUsuario...

}// llave de la clase...