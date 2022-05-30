package com.example.DBA1.controller;

import com.example.DBA1.entity.Person;
import com.example.DBA1.service.PersonService;
import com.example.DBA1.dto.PersonInputDTO;
import com.example.DBA1.dto.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class PersonController {

  public static final String DATE_PATTERN = "yyyy/MM/dd";
  @Autowired
  PersonService personService;

  @PostMapping("/addperson")
  public String addPerson(@RequestBody PersonInputDTO personInputDTO) throws Exception {
    personService.addPerson(personInputDTO);

    return "Persona insertada correctamente \n" + ResponseEntity.ok(personInputDTO);
  }

  @GetMapping("/getall")
  public ResponseEntity<?> getAll() {
    List<PersonOutputDTO> personOutputDTOList = personService.findAll();

    return ResponseEntity.ok(personOutputDTOList);
  }

  @GetMapping("/getPeopleByConditions")
  public ResponseEntity<?> findPeopleByConditions(@RequestParam HashMap<String, Object> conditions) {
    return ResponseEntity.ok().body(personService.findPeopleByConditions(conditions));
  }

  @GetMapping("/getPersonId{id}")
  public ResponseEntity<?> getPersonById(@RequestParam int id) {
    PersonOutputDTO personOutputDTO = personService.findById(id);

    return ResponseEntity.ok(personOutputDTO);
  }

  @DeleteMapping("/getPersonName{name}")
  public ResponseEntity<?> getPeopleByName(@RequestParam String name) {
    PersonOutputDTO personOutputDTO = personService.findByName(name);

    return ResponseEntity.ok(personOutputDTO);
  }

  @DeleteMapping("/deletePerson{id}")
  public ResponseEntity<?> deletePerson(@RequestParam int id) {
    PersonOutputDTO personOutputDTO = personService.deletedById(id);

    return ResponseEntity.ok(personOutputDTO + "Persona eliminada");
  }
}
