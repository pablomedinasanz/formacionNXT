package com.example.ejercicioDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {

    @Autowired
    PersonaService personaService;

    @Autowired
    CiudadService ciudadService;

    @GetMapping("/getPersona")
    public Persona getPersona() {
        personaService.setEdad(personaService.getEdad()*2);

        return personaService.getPersona();
    }

    @GetMapping("/getCiudades")
    public List<Ciudad> getListaCiudad() {
        ciudadService.getListaCiudad().stream().forEach(System.out::println);

        return ciudadService.getListaCiudad();
    }

    @Autowired
    @Qualifier("bean1")
    Persona persona1;

    @Autowired
    @Qualifier("bean2")
    Persona persona2;

    @Autowired
    @Qualifier("bean3")
    Persona persona3;

    @GetMapping("/bean/{bean}")
    public Persona getPersonaBean(@PathVariable int bean) {

        switch (bean) {
            case 1: return persona1;
            case 2: return persona2;
            case 3: return persona3;
            default: return new Persona();
        }
    }
}
