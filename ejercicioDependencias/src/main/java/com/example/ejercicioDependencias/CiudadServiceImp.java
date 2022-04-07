package com.example.ejercicioDependencias;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImp implements  CiudadService{

    Ciudad ciudad = new Ciudad();

    @Override
    public String getNombre() {
        return ciudad.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        ciudad.setNombre(nombre);
    }

    @Override
    public int getNumHabitantes() {
        return ciudad.getNumeroHabitantes();
    }

    @Override
    public void setNumHabitantes(int numHabitantes) {
        ciudad.setNumeroHabitantes(numHabitantes);
    }

    @Override
    public Ciudad getCiudad() {
        return this.ciudad;
    }

    @Override
    public void addCiudad(Ciudad ciudad) {
        getListaCiudad().add(ciudad);
    }

    @Override
    public List<Ciudad> getListaCiudad() {
        return this.getListaCiudad();
    }
}
