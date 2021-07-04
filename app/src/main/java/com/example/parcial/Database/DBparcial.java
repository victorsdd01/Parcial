package com.example.parcial.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBparcial extends SQLiteOpenHelper{



    public DBparcial(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final String TABLE_USUARIO ="t_usuarios";
    private static final String TABLE_RECETAS ="t_recetas";
    private static final String TABLE_FAVORTIAS="t_recetasFavoritas";

    //-----------------------TABLAS-----------------------//

    //--------------------tabla usuarios-----------------//
    String userTable =" CREATE TABLE "+TABLE_USUARIO+"(" +
            "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre_usuario TEXT NOT NULL," +
            "password_usuario TEXT NOT NULL," +
            "tipoUsuario_usuario TEXT NOT NULL)";
    //------------------tabla de recetas-----------------//
    String recetasTable=" CREATE TABLE "+TABLE_RECETAS+"(" +
            "id_receta INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre_receta TEXT NOT NULL," +
            "ingrediente_receta1 TEXT NOT NULL," +
            "ingrediente_receta2 TEXT NOT NULL," +
            "ingrediente_receta3 TEXT NOT NULL," +
            "ingrediente_receta4 TEXT NOT NULL," +
            "ingrediente_receta5 TEXT NOT NULL," +
            "procedimiento_receta TEXT NOT NULL)";
    //-----------------tala recetas favoritas---------------------//
    String recetasFavoritasTable="CREATE TABLE "+TABLE_FAVORTIAS+"(" +
            "id_recetaFavorita INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre_recetaFavortia TEXT NOT NULL)";
//-----------------------------------------------------------

   @Override
    public void onCreate(SQLiteDatabase db)
     {
       db.execSQL(userTable);
       db.execSQL(recetasTable);
       db.execSQL(recetasFavoritasTable);
     }// llave del onCreate...

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
     {

     }// llave del onUpgrade...




}// llave de la clase...
