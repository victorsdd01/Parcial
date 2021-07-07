package com.example.parcial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcial.Admin.Admin_Main;
import com.example.parcial.Database.DBparcial;
import com.example.parcial.Normal_User.Usuario_normal_Main;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
     TextInputEditText usuario,password;
     TextView Usuario,Password,TipoUsuario,u,p,t;
     Spinner sp1;
     Button datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciarController();
        cargaInicial();
    }

    private void cargaInicial(){
        try {
            String usuario="victor";
            String password="123";
            String TipoUsuario="Administrador";
            DBparcial dbParcial = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
            SQLiteDatabase db = dbParcial.getWritableDatabase();
            Cursor c = db.rawQuery("SELECT nombre_usuario FROM t_usuarios WHERE nombre_usuario ='"+usuario+"' AND password_usuario='"+password+"' AND tipoUsuario_usuario='"+TipoUsuario+"' ", null);
            if(db!=null){
                if(c.moveToFirst()){
                    //Toast.makeText(this,"el usuario admin ya existe, por lo tanto no se crea",Toast.LENGTH_SHORT).show();
                }else{
                    ContentValues values = new ContentValues();
                    values.put("nombre_usuario",usuario);
                    values.put("password_usuario",password);
                    values.put("tipoUsuario_usuario",TipoUsuario);
                    db.insert("t_usuarios",null,values);
                    Toast.makeText(this,"en teoria se inserto el usuario inicial "+usuario+"como administrador",Toast.LENGTH_LONG).show();
                }

            }else{ Toast.makeText(this,"error en db!=null",Toast.LENGTH_LONG).show();}

        }catch (Exception e){Toast.makeText(this,"ha ocurrido una error con la carga inicial",Toast.LENGTH_LONG).show();}
    }

    private void iniciarController()
     {
         usuario=(TextInputEditText) findViewById(R.id.edtx_usuario);
         password=(TextInputEditText) findViewById(R.id.edtx_password);

         datos=(Button)findViewById(R.id.btn_verDatos);

         datos.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 u=(TextView)findViewById(R.id.login_lbl_usuario);
                 p=(TextView)findViewById(R.id.login_lbl_password);
                 t=(TextView)findViewById(R.id.login_lbl_tipousuario);
                 u.setText("Usuario:");
                 p.setText("Password:");
                 t.setText("TipoUsuario:");
                 Usuario=(TextView)findViewById(R.id.login_txvUsuario);
                 Password=(TextView)findViewById(R.id.login_txvPassword);
                 TipoUsuario=(TextView)findViewById(R.id.login_txvTipoUsuario);
                 Usuario.setText("victor");
                 Password.setText("123");
                 TipoUsuario.setText("admin");
             }
         });
         sp1=(Spinner)findViewById(R.id.login_spinner_tipoUsuario);
         String TipoUsuario [] ={"Tipo de usuario","Usuario normal","Administrador"};
         Adapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,TipoUsuario);
         sp1.setAdapter((SpinnerAdapter) adapter);

     }

     public  void IniciarSesion(View view){
          String usuario,password;

          usuario=this.usuario.getText().toString();
          password=this.password.getText().toString();

          if(!usuario.isEmpty()){
                if(!password.isEmpty()){
                      String seleccion=sp1.getSelectedItem().toString();
                      if(seleccion.equals("Usuario normal")|| seleccion.equals("Administrador")){
                          /*
                            if(seleccion.equals("Usuario normal")){
                                validarUsuario(usuario,password,seleccion);

                            }else
                                if(seleccion.equals("Administrador")){

                                }

                           */
                          validarUsuario(usuario,password,seleccion);
                      }else{ AlertError(); }

                }else { this.password.setError("Este campo es requerido"); }

          } else { this.usuario.setError("Este campo es requerido"); }
    }// llave del metodo iniciar sesion...

    public void validarUsuario(String usuario,String pass,String tipoUsuario){
        try {
            DBparcial dbParcial = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
            SQLiteDatabase db= dbParcial.getReadableDatabase();
            Cursor c= db.rawQuery("SELECT nombre_usuario,password_usuario,tipoUsuario_usuario FROM t_usuarios WHERE nombre_usuario='"+usuario+"' AND password_usuario='"+pass+"' AND tipoUsuario_usuario='"+tipoUsuario+"' ",null);
            if(db!=null){
                if(c.moveToFirst()){
                    Toast.makeText(this, "si loguea", Toast.LENGTH_LONG).show();
                    if(tipoUsuario.equals("Usuario normal")){
                        try {
                            Intent i = new Intent(getApplicationContext(),Usuario_normal_Main.class);
                            i.putExtra("nombre_usuarioNormal",usuario);
                            startActivity(i);
                        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error de excepcion en usuario normal",Toast.LENGTH_LONG).show();}

                    }else
                        if(tipoUsuario.equals("Administrador")){
                            try {
                                Intent i = new Intent(getApplicationContext(),Admin_Main.class);
                                i.putExtra("nombre_administrador",usuario);
                                startActivity(i);
                            }catch (Exception e){Toast.makeText(this,"ha ocurrido un error de excepcion en usuario administrador",Toast.LENGTH_LONG).show(); }
                        }


                }else{Toast.makeText(this,"El usuario o contraseña son incorrectos",Toast.LENGTH_LONG).show();}
            }else{
                Toast.makeText(this, "error en db!=null", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al validar el usuario",Toast.LENGTH_SHORT).show();}
    }//

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