package com.example.DBA1.Person.infrastructure;


import com.example.DBA1.Person.application.PersonService;
import com.example.DBA1.Person.infrastructure.dto.PersonInputDTO;
import com.example.DBA1.Person.infrastructure.dto.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

  @GetMapping("/getPeopleByConditions")
  public ResponseEntity<?> getPeopleByConditions(@RequestParam HashMap<String, Object> conditions) {

    return ResponseEntity.ok(personService.findPeopleByConditions(conditions));
  }
}
