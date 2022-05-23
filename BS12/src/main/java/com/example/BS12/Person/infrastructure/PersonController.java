package com.example.BS12.Person.infrastructure;

import com.example.BS12.Person.application.PersonService;
import com.example.BS12.Person.infrastructure.dto.PersonInputDTO;
import com.example.BS12.Person.infrastructure.dto.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
    origins = "*",
    methods = {RequestMethod.POST, RequestMethod.GET})
@RestController
public class PersonController {
  @Autowired PersonService personService;

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
}
