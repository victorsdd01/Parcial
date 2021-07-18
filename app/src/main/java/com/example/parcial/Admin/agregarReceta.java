package com.example.parcial.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcial.Database.DBparcial;
import com.example.parcial.R;

public class agregarReceta extends AppCompatActivity {

    EditText nombre_receta,foto,i1,i2,i3,i4,i5,procedimiento;
    TextView success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_receta);
        IniciarController();
    }// llave del oncreate...

    private void IniciarController(){
        nombre_receta=(EditText)findViewById(R.id.agregarReceta_nombreReceta);
        foto=(EditText)findViewById(R.id.agregarReceta_fotoReceta);
        success=(TextView)findViewById(R.id.txv_Succsess);
        i1=(EditText)findViewById(R.id.agregarReceta_ingrediente1);
        i2=(EditText)findViewById(R.id.agregarReceta_ingrediente2);
        i3=(EditText)findViewById(R.id.agregarReceta_ingrediente3);
        i4=(EditText)findViewById(R.id.agregarReceta_ingrediente4);
        i5=(EditText)findViewById(R.id.agregarReceta_ingrediente5);
        procedimiento=(EditText)findViewById(R.id.agregarReceta_edtx_procedimiento);
    }// llave de inicar controller...

    public void AgregarNuevaReceta(View view){
        try {
            String nombreReceta,foto,i1,i2,i3,i4,i5,procedimiento;
            nombreReceta=nombre_receta.getText().toString();
            foto=this.foto.getText().toString();
            i1=this.i1.getText().toString();
            i2=this.i2.getText().toString();
            i3=this.i3.getText().toString();
            i4=this.i4.getText().toString();
            i5=this.i5.getText().toString();
            procedimiento=this.procedimiento.getText().toString();
            if(!nombreReceta.isEmpty()){
                //if(!foto.isEmpty()){
                    if(!i1.isEmpty()){
                        if(!i2.isEmpty()){
                            if(!i3.isEmpty()){
                                if(!i4.isEmpty()){
                                    if(!i5.isEmpty()){
                                        if(!procedimiento.isEmpty()){
                                            nuevaReceta(nombreReceta,foto,i1,i2,i3,i4,i5,procedimiento);
                                        }else{this.procedimiento.setError("Este campo es requerido");}
                                    }else{this.i5.setError("Este campo es requerido");}
                                }else{this.i4.setError("Este campo es requerido");}
                            }else{this.i3.setError("Este campo es requerido");}
                        }else{this.i2.setError("Este campo es requerido");}
                    }else{this.i1.setError("Este campo es requerido");}
                // }else{}
            }else{nombre_receta.setError("Este campo es requerido");}

        }catch (Exception e){Toast.makeText(this,"a ocurrido un error de excepcion al agregar la receta",Toast.LENGTH_LONG).show();}


    }// llave de agregar nueva receta...

    public void nuevaReceta(String nombreReceta,String foto,String i1,String i2,String i3,String i4,String i5,String procedimiento){
        try {
            DBparcial dbParcial = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
            SQLiteDatabase db = dbParcial.getWritableDatabase();
            if(db!=null){
                try {
                    ContentValues values = new ContentValues();
                    values.put("nombre_receta",nombreReceta);
                    if(!foto.isEmpty()){
                        values.put("foto_receta",foto);
                    }else
                        if(foto.isEmpty()){
                            values.put("foto_receta","no agrego foto");
                        }
                    values.put("ingrediente_receta1",i1);
                    values.put("ingrediente_receta2",i2);
                    values.put("ingrediente_receta3",i3);
                    values.put("ingrediente_receta4",i4);
                    values.put("ingrediente_receta5",i5);
                    values.put("procedimiento_receta",procedimiento);
                    db.insert("t_recetas",null,values);
                    //Toast.makeText(this,"en teoria se inserto la receta "+nombreReceta+" se inserto correctamente",Toast.LENGTH_LONG).show();
                    db.close();
                    succssesAlert(nombreReceta,foto);
                }catch (Exception e){Toast.makeText(this,"error de excepcion al agregar la receta",Toast.LENGTH_LONG).show();}
            }else{Toast.makeText(this,"error al agregar la receta",Toast.LENGTH_LONG).show();}

        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error de excepcion en al agregar la receta a la BD",Toast.LENGTH_LONG).show();}

    }

    public void succssesAlert(String nombreReceta,String foto){
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(R.layout.alert_layout);
            builder.setCancelable(true);
            builder.setTitle("se ha agregado la receta "+nombreReceta+" correctamente");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent();
                    if(foto!=null){
                        i.putExtra("urlFoto",foto);
                        Toast.makeText(getApplicationContext(),"mando la foto",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext()," no tiene foto",Toast.LENGTH_LONG).show();
                    }

                }
            },2300);
            builder.show();
        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al mostrar el alert",Toast.LENGTH_LONG).show();}
    }
}// llave de la clase...