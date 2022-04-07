package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringBoot1 {

	public static void main(String[] args) {

		SpringApplication.run(SpringBoot1.class, args);
	}

	// EJEMPLO BASICO HOLA
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	//EJEMPLO GET
	@GetMapping("/user/{nombre}")
	@ResponseBody
	public String getSaludar(@PathVariable String nombre) {
		return "HOLA " + nombre;
	}

	//EJEMPLO POST
	@PostMapping("/useradd")
	public String postUser(@RequestBody Persona persona) {

		System.out.println("La edad del usuario " + persona.getNombre() + " +1 año es " + (persona.getEdad() + 1));

		return "La edad del usuario " + persona.getNombre() + " +1 año es " + (persona.getEdad() + 1);
	}

}
