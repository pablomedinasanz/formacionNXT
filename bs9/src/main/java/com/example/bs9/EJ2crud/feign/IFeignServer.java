package com.example.bs9.EJ2crud.feign;

import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleClient",url = "http://localhost:8080/")
public interface IFeignServer {
    @GetMapping("person/crud/profesor/{id}")
    ResponseEntity<ProfesorOutputDTO> getProfesor(@PathVariable String id);
}
