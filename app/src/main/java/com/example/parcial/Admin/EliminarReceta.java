package com.example.parcial.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parcial.Adapters.Adaptador;
import com.example.parcial.Clases.Recetas;
import com.example.parcial.Database.DBparcial;
import com.example.parcial.R;

import java.util.ArrayList;
import java.util.List;

public class EliminarReceta extends AppCompatActivity {

    EditText nombreReceta;
    ListView lsv_eliminarReceta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_receta);
        iniciarController();
        CargarRecetas();
    }

    private void iniciarController() {
        nombreReceta=(EditText)findViewById(R.id.eliminarReceta_nombreReceta);
        lsv_eliminarReceta=(ListView)findViewById(R.id.eliminarReceta_listview);
    }// llave del metodo...

    public void EliminarReceta(View view){
        try {
            String nombreReceta=this.nombreReceta.getText().toString();
            if(!nombreReceta.isEmpty()){
                DBparcial dbParcial = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
                SQLiteDatabase db =dbParcial.getWritableDatabase();
                Cursor c=db.rawQuery("SELECT nombre_receta FROM t_recetas WHERE nombre_receta='"+nombreReceta+"'",null);
                if(db!=null){
                    if(c.moveToFirst()){
                        db.delete("t_recetas","nombre_receta='"+nombreReceta+"'",null);
                        db.close();
                        succssesAlert(nombreReceta);
                    }else{
                        errorSuccess(nombreReceta);
                        this.nombreReceta.setText("");
                    }
                }else{Toast.makeText(getApplicationContext(), "ha ocurrido un error en db!=null", Toast.LENGTH_SHORT).show();}
            }else{this.nombreReceta.setError("Este capo es requerido");}
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "ha ocurrido un error de excepcion al eliminar la receta", Toast.LENGTH_SHORT).show();
        }

    }//llave del metodo eliminarReceta...

    public void CargarRecetas(){
        try {
            DBparcial nuevaReceta = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
            SQLiteDatabase db = nuevaReceta.getReadableDatabase();
            List<Recetas> NuevaReceta = new ArrayList<>();
            String campos[]={"nombre_receta","foto_receta"};
            //String [] campos= {"nombre_receta,ingrediente_receta1,ingrediente_receta2,ingrediente_receta3,ingrediente_receta4,ingrediente_receta5"};
            Cursor c = db.query("t_recetas",campos,null,null,null,null,null);
            if(c.moveToFirst()){
                do{
                    Recetas receta = new Recetas();
                    receta.setNombreReceta(c.getString(0));
                    receta.setFoto(c.getString(1));
                    NuevaReceta.add(receta);
                }while (c.moveToNext());

            }else{
                Toast.makeText(this,"ha ocurrido un error en moveToFirst",Toast.LENGTH_LONG).show();}

            Adaptador adapter= new Adaptador(getApplicationContext(),NuevaReceta);
            lsv_eliminarReceta.setAdapter(adapter);

        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al cargar el listView",Toast.LENGTH_LONG).show();}
    }// llave del metodo cargar Listview...

    public void succssesAlert(String nombreReceta){
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(R.layout.alert_layout);
            builder.setCancelable(true);
            builder.setTitle("se ha eliminado la receta "+nombreReceta+" correctamente");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(),Admin_Main.class));
                }
            },2300);
            builder.show();
        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al mostrar el alert",Toast.LENGTH_LONG).show();}
    }

    public void errorSuccess(String nombreReceta){
       try {
           AlertDialog.Builder builder= new AlertDialog.Builder(this);
           builder.setTitle("¡ERROR!");
           builder.setView(R.layout.error_layout);
           builder.setCancelable(false);
           builder.setMessage("la receta "+nombreReceta+" no existe");
           builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {

               }
           });
           builder.show();
       }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al mostrar el alert",Toast.LENGTH_LONG).show();}

    }// llave del metodo




}