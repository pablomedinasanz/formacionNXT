package com.example.bs9.EJ2crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Ej2crudApplication {

  public static void main(String[] args) {
    SpringApplication.run(Ej2crudApplication.class, args);
  }
}
