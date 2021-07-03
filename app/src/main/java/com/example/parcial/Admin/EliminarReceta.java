package com.example.parcial.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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

            DBparcial dbParcial = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
            SQLiteDatabase db =dbParcial.getWritableDatabase();
            if(db!=null){
                db.delete("t_recetas","nombre_receta='"+nombreReceta+"'",null);
                Toast.makeText(getApplicationContext(), "en teoria la receta se elimino", Toast.LENGTH_SHORT).show();

            }else{Toast.makeText(getApplicationContext(), "ha ocurrido un error en db!=null", Toast.LENGTH_SHORT).show();}

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "ha ocurrido un error de excepcion al eliminar la receta", Toast.LENGTH_SHORT).show();
        }

    }//llave del metodo eliminarReceta...


    public void CargarRecetas(){
        try {
            DBparcial nuevaReceta = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
            SQLiteDatabase db = nuevaReceta.getReadableDatabase();
            List<Recetas> NuevaReceta = new ArrayList<>();
            String campos[]={"nombre_receta"};
            //String [] campos= {"nombre_receta,ingrediente_receta1,ingrediente_receta2,ingrediente_receta3,ingrediente_receta4,ingrediente_receta5"};
            Cursor c = db.query("t_recetas",campos,null,null,null,null,null);
            if(c.moveToFirst()){
                do{
                    Recetas receta = new Recetas(
                            c.getString(0)

                    );
                    NuevaReceta.add(receta);
                }while (c.moveToNext());

            }else{
                Toast.makeText(this,"ha ocurrido un error en moveToFirst",Toast.LENGTH_LONG).show();}

            Adaptador adapter= new Adaptador(getApplicationContext(),NuevaReceta);
            lsv_eliminarReceta.setAdapter(adapter);

        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al cargar el listView",Toast.LENGTH_LONG).show();}
    }// llave del metodo cargar Listview...




}