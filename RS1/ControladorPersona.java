package com.example.RS1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persona")
public class ControladorPersona {

    List<Persona> listaPersonas = new ArrayList<>();
    //private final AtomicInteger idAutoincrementado = new AtomicInteger();

    @Autowired
    PersonaService personaService;

    //1. POST
    @PostMapping("/postPersona")
    public Persona postPersona(@RequestBody Persona persona) {
        personaService.setNombre(persona.getNombre());
        personaService.setPoblacion(persona.getPoblacion());
        personaService.setEdad(persona.getEdad());
        personaService.setId(persona.getId());

        listaPersonas.add(persona);

        return personaService.getPersona();
    }

    // 2. PUT POR ID
    @PutMapping("/putPersona")
    public Persona actualizarPersona(@RequestBody Persona persona) {

        personaService.setNombre(persona.getNombre());
        personaService.setPoblacion(persona.getPoblacion());
        personaService.setEdad(persona.getEdad());
        personaService.setId(persona.getId());

        listaPersonas.add(persona);

        return personaService.getPersona();

    }

    // 3. DELETE POR ID
    @DeleteMapping("/deletePersona/{id}")
    public String borrarPersona(@PathVariable(value = "id") int id) {
        Persona p = listaPersonas.stream().filter(persona -> persona.getId() == id).toList().get(0);
        listaPersonas.remove(p);

        return "Persona con id " + p.getId() + " y nombre " + p.getNombre() + " eliminada";
    }


    //4. GET POR ID
    @GetMapping("/getPersona/{id}")
    public Persona getPersona(@PathVariable(value = "id") int id) {

        return listaPersonas.stream().filter(persona -> persona.getId() == id).toList().get(0);

    }

    //MOSTRAR TODA LA LISTA
    @GetMapping("/getPersonas")
    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }
}