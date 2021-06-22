package com.example.parcial.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.parcial.Database.Entidades.Usuarios;
import com.example.parcial.R;

public class DbProccess {

    DBparcial _database;

    public DbProccess(Context context)
     {
       _database=new DBparcial(context,"Usuarios",null, R.integer.dbVersion);
     }// llave del constructor...



     //metodo para insertar o guardar usuario...
    public  boolean GuardarUsuario(Usuarios usuario)
     {
         try{
             SQLiteDatabase db= _database.getWritableDatabase();
             if(db!=null)
               {
                   ContentValues values= new ContentValues();
                   values.put("user",usuario.getUser());
                   values.put("password",usuario.getPassword());

                   db.insert("users",null,values);
                   return true;
               }
         }
         catch(Exception e){}
         return false;
     }


}// llave de la clase...
