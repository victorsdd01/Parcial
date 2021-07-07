package com.example.parcial.Normal_User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parcial.Adapters.Adaptador;
import com.example.parcial.Admin.Admin_Main;
import com.example.parcial.Clases.Recetas;
import com.example.parcial.Database.DBparcial;
import com.example.parcial.Login;
import com.example.parcial.R;

import java.util.ArrayList;
import java.util.List;

public class RecetasFavoritas extends AppCompatActivity {

    ListView lsv_recetasFavortas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas_favoritas);
        iniciarController();
        CargarRecetasFavoritas();
    }

    private void iniciarController() {

        lsv_recetasFavortas=(ListView)findViewById(R.id.RecetasFavoritas_listview);
    }// llave del metodo inicarController...

    public void volver(View view ){
        startActivity(new Intent(getApplicationContext(), Usuario_normal_Main.class));
    }// llave del metodo volver...

    public void CargarRecetasFavoritas(){
        try {
            DBparcial dbParcial = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
            SQLiteDatabase db = dbParcial.getReadableDatabase();
            List<Recetas> recetasFav = new ArrayList<>();
            Cursor c=db.rawQuery("SELECT nombre_recetaFavortia FROM t_recetasFavoritas ",null);
            if(c.moveToFirst()){
                do {
                    Recetas recetaFavoritas = new Recetas();
                    recetaFavoritas.setNombreReceta(c.getString(0));
                    recetasFav.add(recetaFavoritas);
                }while (c.moveToNext());

            }else{Toast.makeText(this,"no se ha encontrado recetas favoritas",Toast.LENGTH_LONG).show();}
            Adaptador adaptador = new Adaptador(getApplicationContext(),recetasFav);
            lsv_recetasFavortas.setAdapter(adaptador);

        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al cargar las recetas favoritas", Toast.LENGTH_LONG).show();}
    }// llave de cargarRecetasFavoritas...

}