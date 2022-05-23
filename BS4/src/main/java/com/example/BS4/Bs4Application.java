package com.example.BS4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@SpringBootApplication
public class Bs4Application {

	@Autowired
	Properties properties;

	@Autowired
	MiConfiguracionProperties miConfiguracionProperties;

	@Autowired
	Perfil perfil;

	public static void main(String[] args) {
		SpringApplication.run(Bs4Application.class, args);
	}

	@GetMapping("/parametros")
	public String printProperties() {
		System.out.println(properties);
		return properties.toString();
	}

	@PostConstruct
	@GetMapping("/miconfiguracion")
	public String printMiConfiguracion() {
		System.out.println(miConfiguracionProperties);

		return miConfiguracionProperties.toString();
	}

	@GetMapping("/perfil")
	public void printPerfil() {
		perfil.miFuncion();
	}

}
