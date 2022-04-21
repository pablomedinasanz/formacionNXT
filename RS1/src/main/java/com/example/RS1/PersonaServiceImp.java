package com.example.RS1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements  PersonaService{

    Persona persona = new Persona();

    @Override
    public String getNombre() {
        return persona.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        persona.setNombre(nombre);
    }

    @Override
    public String getPoblacion() {
        return persona.getPoblacion();
    }

    @Override
    public void setPoblacion(String poblacion) {
        persona.setPoblacion(poblacion);
    }

    @Override
    public int getEdad() {
        return persona.getEdad();
    }

    @Override
    public void setEdad(int edad) {
        persona.setEdad(edad);
    }

    @Override
    public int getId() {
        return persona.getId();
    }

    @Override
    public void setId(int id) {
        persona.setId(id);
    }

    @Override
    public Persona getPersona() {
        return this.persona;
    }




}
