package com.example.parcial.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial.Database.DBparcial;
import com.example.parcial.R;

public class agregarReceta extends AppCompatActivity {

    EditText nombre_receta,i1,i2,i3,i4,i5,procedimiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_receta);
        IniciarController();
    }// llave del oncreate...

    private void IniciarController(){
        nombre_receta=(EditText)findViewById(R.id.agregarReceta_nombreReceta);
        i1=(EditText)findViewById(R.id.agregarReceta_ingrediente1);
        i2=(EditText)findViewById(R.id.agregarReceta_ingrediente2);
        i3=(EditText)findViewById(R.id.agregarReceta_ingrediente3);
        i4=(EditText)findViewById(R.id.agregarReceta_ingrediente4);
        i5=(EditText)findViewById(R.id.agregarReceta_ingrediente5);
        procedimiento=(EditText)findViewById(R.id.agregarReceta_edtx_procedimiento);
    }// llave de inicar controller...

    public void AgregarNuevaReceta(View view){

        String nombreReceta,i1,i2,i3,i4,i5,procedimiento;

        nombreReceta=nombre_receta.getText().toString();
        i1=this.i1.getText().toString();
        i2=this.i2.getText().toString();
        i3=this.i3.getText().toString();
        i4=this.i4.getText().toString();
        i5=this.i5.getText().toString();
        procedimiento=this.procedimiento.getText().toString();

        DBparcial dbParcial = new DBparcial(getApplicationContext(),"RecetasDB",null,1);
        SQLiteDatabase db = dbParcial.getWritableDatabase();
        if(db!=null){
            try {
                ContentValues values = new ContentValues();
                values.put("nombre_receta",nombreReceta);
                values.put("ingrediente_receta1",i1);
                values.put("ingrediente_receta2",i2);
                values.put("ingrediente_receta3",i3);
                values.put("ingrediente_receta4",i4);
                values.put("ingrediente_receta5",i5);
                values.put("procedimiento_receta",procedimiento);

                db.insert("t_recetas",null,values);
                Toast.makeText(this,"receta agregada",Toast.LENGTH_LONG).show();

            }catch (Exception e){Toast.makeText(this,"error de excepcion al agregar la receta",Toast.LENGTH_LONG).show();}
        }else{Toast.makeText(this,"error al agregar la receta",Toast.LENGTH_LONG).show();}

    }// llave de agregar nueva receta...

}// llave de la clase...