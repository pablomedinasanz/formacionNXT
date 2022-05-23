package com.example.Propiedades1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties(ConfigurationProperties.class)
public class Propiedades1Application {

	@Autowired
	private ConfigurationProperties configurationProperties;

	public static void main(String[] args) {
		SpringApplication.run(Propiedades1Application.class, args);
	}

	@GetMapping("/controlador")
	public void printVars() {

		System.out.println("Configuration properties...");
		System.out.println(configurationProperties);
	}

}
