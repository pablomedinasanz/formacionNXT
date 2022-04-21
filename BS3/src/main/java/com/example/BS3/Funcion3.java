package com.example.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Order(value = 2)
public class Funcion3 implements CommandLineRunner {

    String parametro;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Soy la tercera clase recogiendo el parametro ");
    }

    @GetMapping("/f3{param}")
    public String printParam(@RequestParam("param") String param) {

        parametro = param;
        return parametro;
    }
}
