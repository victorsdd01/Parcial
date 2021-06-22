package com.example.parcial.Database.Entidades;

public class Usuarios {

    private  String user;
    private String password;

    public Usuarios(String user,String password)
    {
        this.user=user;
        this.password=password;
    }


    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
