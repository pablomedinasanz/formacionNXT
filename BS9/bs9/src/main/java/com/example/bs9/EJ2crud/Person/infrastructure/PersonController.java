package com.example.bs9.EJ2crud.Person.infrastructure;

import com.example.EJ2crud.Person.application.PersonService;
import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Person.infrastructure.dto.PersonInputDTO;
import com.example.EJ2crud.Person.infrastructure.dto.PersonOutputDTO;
import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorOutputDTO;
import com.example.EJ2crud.feign.IFeignServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("person/crud")
public class PersonController {

  @Autowired PersonService personService;
  @Autowired
  private IFeignServer feignClient;

  // Request para insertar una persona en la base de datos
  @PostMapping("/addPerson")
  public String insertPerson(@RequestBody PersonInputDTO personInputDTO) throws Exception {
    System.out.println("En el controlador addPerson");
    personService.addPerson(personInputDTO);
    return "Persona insertada correctamente";
  }

  // Request para obtener todos los registros de la tabla
  @GetMapping(value = "/getPeople")
  public List<Person> getPeople() {
    System.out.println("En el controlador getPeople");
    return personService.findAll();
  }

  // Request para obtener la persona con id pasado por parámetro
  @GetMapping(value = "/getPerson/{id}")
  public PersonOutputDTO getPersonById(@PathVariable String id) throws Exception {
    return personService.findById(id);
  }

  // Request para eliminar la persona con id pasado por parámetro
  @DeleteMapping(value = "/delete/{id}")
  public String deletePersonById(@PathVariable String id) throws Exception {
    personService.deletedById(id);
    return "La persona con id " + id + " ha sido eliminada de la base de datos";
  }

  // Request para obtener la persona con nombre pasado por parámetro
  @GetMapping(value = "/getPerson/name/{name}")
  public List<PersonOutputDTO> getPersonByName(@PathVariable String name) throws Exception {
    return personService.findByName(name);
  }

  //Request para obtener un profesor usando RestTemplate
  @GetMapping("/profesor/{id}")
  public ResponseEntity<ProfesorOutputDTO> getProfesor(@PathVariable String id){
    ResponseEntity<ProfesorOutputDTO> responseEntity= new RestTemplate().getForEntity("http://localhost:8080/profesor/crud/getProfesor/"+id,ProfesorOutputDTO.class);
    return ResponseEntity.ok(responseEntity.getBody());

  }

  @GetMapping("/feign/{id}")
  public ResponseEntity<?> findProfesorUsingFeign(@PathVariable String id){
    ResponseEntity<ProfesorOutputDTO> profesor = feignClient.getProfesor(id);
    return ResponseEntity.ok(profesor.getBody());
  }
}
