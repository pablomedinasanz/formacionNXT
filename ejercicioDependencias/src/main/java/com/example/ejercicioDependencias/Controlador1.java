package com.example.ejercicioDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {

    @Autowired
    PersonaService personaService;

    @Autowired
    CiudadService ciudadService;

    //recoger una persona
    @PostMapping("/addPersona")
    public Persona addPersona(@RequestBody Persona persona) {
        personaService.setNombre(persona.getNombre());
        personaService.setPoblacion(persona.getPoblacion());
        personaService.setEdad(persona.getEdad());

        return personaService.getPersona();
    }

    //recoger una ciudad y guardarla en la lista
    @PostMapping("/addCiudad")
    public  Ciudad addCiudad(@RequestBody Ciudad ciudad) {
        ciudadService.setNombre(ciudad.getNombre());
        ciudadService.setNumHabitantes(ciudad.getNumeroHabitantes());

        //se añade a List<Ciudad>
        ciudadService.addCiudad(ciudad);

        return ciudadService.getCiudad();
    }


}
