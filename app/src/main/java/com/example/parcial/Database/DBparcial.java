package com.example.parcial.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBparcial extends SQLiteOpenHelper{

    String userTable ="CREATE TABLE users(user TEXT,password TEXT)";

  public DBparcial(Context context,String DB_name,SQLiteDatabase.CursorFactory cursor,int dbVersion)
   {
       super(context,DB_name,cursor,dbVersion);
   }

   @Override
    public void onCreate(SQLiteDatabase db)
     {
       db.execSQL(userTable);
     }// llave del onCreate...

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
     {

     }// llave del onUpgrade...




}// llave de la clase...
