package com.example.parcial.Clases;

public class Recetas {

    private String nombreReceta;
    private String foto;
    private String ingrediente1;
    private String ingrediente2;
    private String ingrediente3;
    private String ingrediente4;
    private String ingrediente5;
    private String procedimientoReceta;

    /*
    public Recetas(String nombreReceta,String foto){
        this.nombreReceta=nombreReceta;
        this.foto=foto;
    }
    */
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

    public String getFoto() {
        return foto;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setIngrediente1(String ingrediente1) {
        this.ingrediente1 = ingrediente1;
    }

    public void setIngrediente2(String ingrediente2) {
        this.ingrediente2 = ingrediente2;
    }

    public void setIngrediente3(String ingrediente3) {
        this.ingrediente3 = ingrediente3;
    }

    public void setIngrediente4(String ingrediente4) {
        this.ingrediente4 = ingrediente4;
    }

    public void setIngrediente5(String ingrediente5) {
        this.ingrediente5 = ingrediente5;
    }

    public void setProcedimientoReceta(String procedimientoReceta) {
        this.procedimientoReceta = procedimientoReceta;
    }
}
