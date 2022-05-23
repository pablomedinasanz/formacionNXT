package com.example.BS5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Bs5Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs5Application.class, args);
		log.info("INFO");
		log.error("ERROR");
		log.warn("WARN");
		log.debug("DEBUG");
		log.trace("TRACE");

	}


}
