package com.example.ejercicioDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjercicioDependenciasApplication {

	@Autowired
	PersonaService personaService;

	public static void main(String[] args) {

		SpringApplication.run(EjercicioDependenciasApplication.class, args);

	}

}
