package com.example.DOCKER;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("hola/{name}")
    public String saludo(@PathVariable String name) {
        return "Hola, " + name;

    }

    @GetMapping("adios/{name}")
    public String despedida(@PathVariable String name) {
        return "Adios, " + name;

    }
}
