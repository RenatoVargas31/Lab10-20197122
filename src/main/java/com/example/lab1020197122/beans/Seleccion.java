package com.example.lab1020197122.beans;

public class Seleccion {
    private int id;
    private String nombre;
    private String tecnico;
    private Estadio estadios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public Estadio getEstadios() {
        return estadios;
    }

    public void setEstadios(Estadio estadios) {
        this.estadios = estadios;
    }
}
