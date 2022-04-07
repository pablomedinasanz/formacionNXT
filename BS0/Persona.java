package com.example.demo;

public class Persona {

    String nombre, poblacion;
    int edad;

    public Persona() {

    }

    public Persona(String nombre, String poblacion, int edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return
                "Nombre=" + nombre +
                        ". Poblacion= " + poblacion  +
                        ". Edad= " + edad ;
    }
}
