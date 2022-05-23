package com.example.BS12.Person.application;

import com.example.BS12.Person.infrastructure.dto.PersonInputDTO;
import com.example.BS12.Person.infrastructure.dto.PersonOutputDTO;

import java.util.List;

public interface PersonService {
  PersonOutputDTO addPerson(PersonInputDTO personInputDTO);

  List<PersonOutputDTO> findAll();
}
