package com.example.RS1;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controlador {

    private static final String hola = "HOLA, %s!";
    private final AtomicInteger contador = new AtomicInteger();

    //http://localhost:8080/saludo?nombre=pablo
    @GetMapping("/saludo")
    public Saludo saludo(@RequestParam(value = "nombre", defaultValue = "MUNDO") String nombre) {
        return new Saludo(contador.incrementAndGet(), String.format(hola, nombre));
    }

    //http:localhost:8080/saludo/nombre?nombre=pablo
    @GetMapping("/saludo/{nombre}")
    public Saludo saludo2(@RequestParam(value = "nombre", defaultValue = "MUNDO") String nombre) {
        return new Saludo(contador.incrementAndGet(), String.format(hola, nombre));
    }

    @PostMapping("/postSaludo")
    public Saludo postSaludo(@RequestBody Saludo saludo) {

        return saludo;
    }

    @GetMapping("/user/{id}")
    public int getId(@RequestParam int id) {
        return id;
    }


}
