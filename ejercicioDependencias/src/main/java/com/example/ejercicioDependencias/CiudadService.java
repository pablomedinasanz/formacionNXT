package com.example.ejercicioDependencias;

import java.util.List;

public interface CiudadService {

    String getNombre();
    void setNombre(String nombre);
    int getNumHabitantes();
    void setNumHabitantes(int numHabitantes);
    Ciudad getCiudad();
    void addCiudad(Ciudad ciudad);
    List<Ciudad> getListaCiudad();
}
