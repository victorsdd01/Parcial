package com.example.parcial.Normal_User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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

public class Usuario_normal_Main extends AppCompatActivity {

    TextView nombreUsuario;
    ListView lsv_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_normal_main);
        IniciarController();
        CargarRecetas();


    }// llave del metodo...

    public void IniciarController(){
        nombreUsuario=(TextView)findViewById(R.id.usuarioNormal_txv_nombre_usuario);
        lsv_usuario=(ListView)findViewById(R.id.usuarioNormalListview);

        lsv_usuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String recetaSeleccionada=((Recetas)adapterView.getItemAtPosition(position)).getNombreReceta();
                recetasFavoritas(recetaSeleccionada);

            }
        });
    }

    public void recetasFavoritas(String nombreReceta){
        try {
            DBparcial dbParcial = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
            SQLiteDatabase db=dbParcial.getWritableDatabase();
            if(db!=null){
                try {
                    ContentValues values = new ContentValues();
                    values.put("nombre_recetaFavortia",nombreReceta);
                    db.insert("t_recetasFavoritas",null,values);

                    Toast.makeText(this,"En teoria se agrego correctamente la receta ='"+nombreReceta+"'",Toast.LENGTH_LONG).show();

                }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al insertar la receta a favorito",Toast.LENGTH_LONG).show();}

            }else{
                Toast.makeText(this, "ha ocurrido un error en db!=null ", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(this, "ha ocurrido un error al guardar la receta", Toast.LENGTH_SHORT).show();
        }

    }// llave del metodo...

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
            lsv_usuario.setAdapter(adapter);

        }catch (Exception e){Toast.makeText(this,"ha ocurrido un error al cargar el listView",Toast.LENGTH_LONG).show();}
    }// llave del metodo cargar Listview...







}// llave de la clase...