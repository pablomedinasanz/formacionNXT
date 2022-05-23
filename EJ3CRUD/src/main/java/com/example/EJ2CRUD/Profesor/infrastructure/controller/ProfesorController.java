package com.example.EJ2CRUD.Profesor.infrastructure.controller;

import com.example.EJ2crud.Profesor.application.ProfesorService;
import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorInputDTO;
import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profesor/crud")
public class ProfesorController {

  @Autowired ProfesorService profesorService;

  // Request para insertar un profesor en la base de datos
  @PostMapping("/addProfesor")
  public ProfesorOutputDTO addProfesor(@RequestBody ProfesorInputDTO profesorInputDTO)
      throws Exception {
    System.out.println("En el controlador addProfesor");

    return profesorService.addProfesor(profesorInputDTO);
  }

  // Request para obtener todos los registros de la tabla
  @GetMapping(value = "/getProfesors")
  public List<ProfesorOutputDTO> getProfesors() {
    System.out.println("En el controlador getProfesors");
    return profesorService.findAll();
  }

  // Request para obtener el profesor con id pasado por parámetro
  @GetMapping(value = "/getProfesor/{id}")
  public ProfesorOutputDTO getProfesorById(@PathVariable String id) throws Exception {
    return profesorService.findById(id);
  }

  // Request para eliminar el profesor con id pasado por parámetro
  @DeleteMapping(value = "/delete/{id}")
  public String deletePersonById(@PathVariable String id) throws Exception {
    profesorService.deletedById(id);
    return "El profesor con id " + id + " ha sido eliminada de la base de datos";
  }
}
