package com.example.parcial.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.parcial.Database.Entidades.Usuarios;
import com.example.parcial.R;

public class DbProccess {

/*
    Context context;
    public DbProccess(Context context) {
        super(context);
    }


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
                   db.close();
                   return true;
               }
         }
         catch(Exception e){}
         return false;
     }


     //metodo para validar el login de la BD...
    public  boolean ValidarUsuario(Usuarios usuario)
     {
         try {
             SQLiteDatabase db= _database.getReadableDatabase();
             if(db != null){
                   try {
                       String campos [] = new String[]{"user","password"};
                       String arg    [] = new String[]{usuario.getUser(), usuario.getPassword()};
                       Cursor cursor = db.query("users",campos,"user='"+arg[0]+"' AND password ='"+arg[1]+"'",arg,null,null,null);
                       if(cursor.moveToFirst())
                       {
                           return true;
                       }
                   }catch(Exception e){}
             }else{}
         }catch(Exception e){}

         return false;
     }


    */

}// llave de la clase...
