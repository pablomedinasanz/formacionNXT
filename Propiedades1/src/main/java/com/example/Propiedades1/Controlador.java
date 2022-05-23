package com.example.Propiedades1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController("/controlador")
@EnableConfigurationProperties(ConfigurationProperties.class)
public class Controlador {

    @Autowired
    private ConfigurationProperties configurationProperties;

    @GetMapping("/variables")
    public void getVar1() {
        System.out.println("Variables 1 y 2: " + configurationProperties);
    }
}
