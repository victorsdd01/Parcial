package com.example.parcial.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.parcial.Clases.Recetas;
import com.example.parcial.Database.Entidades.Usuarios;
import com.example.parcial.R;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends ArrayAdapter<Recetas> {


    private List<Recetas> recetas = new ArrayList<>();

    public Adaptador(Context context, List<Recetas> datos){
        super(context,R.layout.recetas_listview,datos);
        recetas= datos;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.recetas_listview, null);

        TextView nombre_receta = (TextView)item.findViewById(R.id.txv_nombreReceta);
        nombre_receta.setText(recetas.get(position).getNombreReceta());
        //foto...

        return(item);
    }




}
