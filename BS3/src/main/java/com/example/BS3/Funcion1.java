package com.example.BS3;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Funcion1 {

    @PostConstruct
    private void funcion1() {
        System.out.println("Hola desde clase inicial");
    }
}
