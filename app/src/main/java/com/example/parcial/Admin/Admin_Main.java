package com.example.parcial.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcial.Adapters.Adaptador;
import com.example.parcial.Clases.Recetas;
import com.example.parcial.Database.DBparcial;
import com.example.parcial.R;

import java.util.ArrayList;
import java.util.List;

public class Admin_Main extends AppCompatActivity {


    TextView  nombre_usuario;
    ListView lsv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        IniciarController();
        CargarRecetas();

    }// llave del Oncreate

    private void IniciarController(){
        nombre_usuario=(TextView)findViewById(R.id.admin_main_txv_nombre_usuario);
        lsv1=(ListView)findViewById(R.id.admin_liistViewRecetas);
    }// llave del iniciarController...


    // carga toda las recetas....
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

            }else{Toast.makeText(this,"ha ocurrido un error en moveToFirst",Toast.LENGTH_LONG).show();}

            Adaptador adapter= new Adaptador(getApplicationContext(),NuevaReceta);
            lsv1.setAdapter(adapter);

        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al cargar el listView",Toast.LENGTH_LONG).show();}
    }// llave del metodo cargar Listview...


    public void agregarReceta(View view){
        startActivity(new Intent(getApplicationContext(), agregarReceta.class));
    }// llave de agregarReceta...


    public void agregarNuevoUsuario(View view){
        startActivity(new Intent(getApplicationContext(), CrearNuevoUsuario.class));
    }// llave de agregarReceta...


   public void eliminarReceta(View view){
        startActivity(new Intent(getApplicationContext(),EliminarReceta.class));
   }// llave del metodo



}// llave de la clase...