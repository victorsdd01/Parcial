package com.example.parcial.Clases;

public class Recetas {

    private String nombreReceta;
    private String ingrediente1;
    private String ingrediente2;
    private String ingrediente3;
    private String ingrediente4;
    private String ingrediente5;
    private String procedimientoReceta;

    public Recetas(String nombreReceta){
        this.nombreReceta=nombreReceta;
    }


    public String getNombreReceta() {
        return nombreReceta;
    }

    public String getIngrediente1() {
        return ingrediente1;
    }

    public String getIngrediente2() {
        return ingrediente2;
    }

    public String getIngrediente3() {
        return ingrediente3;
    }

    public String getIngrediente4() {
        return ingrediente4;
    }

    public String getIngrediente5() {
        return ingrediente5;
    }

    public String getProcedimientoReceta() {
        return procedimientoReceta;
    }
}
