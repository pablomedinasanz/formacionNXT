package com.example.DBA2.controller;

import com.example.DBA2.service.PersonService;
import com.example.DBA2.dto.PersonInputDTO;
import com.example.DBA2.dto.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
    origins = "*",
    methods = {RequestMethod.POST, RequestMethod.GET})
@RestController
public class PersonController {
  @Autowired
  PersonService personService;

  @PostMapping("/addperson")
  public String addPerson(@RequestBody PersonInputDTO personInputDTO) throws Exception {
    personService.addPerson(personInputDTO);

    return "Persona insertada correctamente";
  }

  @GetMapping("/getall")
  public ResponseEntity<?> getAll() {
    List<PersonOutputDTO> personOutputDTOList = personService.findAll();

    return ResponseEntity.ok(personOutputDTOList);
  }

  // Request para person by id
  @GetMapping("/get/{id}")
  public ResponseEntity<?> getPersonById(@PathVariable String id) throws Exception {

    PersonOutputDTO personOutputDTO = personService.findOneByID(id);
    return ResponseEntity.ok().body(personOutputDTO);
  }

  // Modifica person
  @PutMapping("/{id}")
  public ResponseEntity<?> updatePersonById(
      @PathVariable String id, @RequestBody PersonInputDTO personInputDTO) {
    personService.updatePerson(personInputDTO, id);
    return ResponseEntity.ok().body("Updated succesfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable String id) {
    personService.deleteByID(id);
    return ResponseEntity.ok().body("Deleted succesfully");
  }
}
