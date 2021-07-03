package com.example.parcial.Clases;

public class Recetas {

    private String nombreReceta;
    private String ingrediente1;
    private String ingrediente2;
    private String ingrediente3;
    private String ingrediente4;
    private String ingrediente5;

    public Recetas(String nombreReceta){
        this.nombreReceta=nombreReceta;
    }


    public String getNombreReceta() {
        return nombreReceta;
    }
}
