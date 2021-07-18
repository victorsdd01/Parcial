package com.example.parcial.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcial.Clases.Recetas;
import com.example.parcial.Database.Entidades.Usuarios;
import com.example.parcial.R;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Adaptador extends ArrayAdapter<Recetas> {


    private List<Recetas> recetas = new ArrayList<>();

    public Adaptador(Context context, List<Recetas> datos) {
        super(context, R.layout.recetas_listview, datos);
        recetas = datos;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.recetas_listview, null);

        TextView nombre_receta = (TextView) item.findViewById(R.id.txv_nombreReceta);
        nombre_receta.setText(recetas.get(position).getNombreReceta());
        ImageView fotito = (ImageView) item.findViewById(R.id.imv_foto_receta);
        try {
            URL url = new URL(recetas.get(position).getFoto());
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            fotito.setImageBitmap(bitmap);
        } catch (Exception e) {
            //Toast.makeText(getContext().getApplicationContext(), "ha ocurrido un error al cargar la foto",Toast.LENGTH_LONG).show();
        }

        return (item);
    }
}
