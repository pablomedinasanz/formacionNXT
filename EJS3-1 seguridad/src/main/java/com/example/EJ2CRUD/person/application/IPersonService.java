package com.example.EJ2CRUD.person.application;


import com.example.EJ2CRUD.person.domain.Person;
import com.example.EJ2CRUD.person.infrastructure.dto.PersonInputDTO;
import com.example.EJ2CRUD.person.infrastructure.dto.PersonOutputDTO;

import java.util.List;

public interface IPersonService {
  PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception;

  List<PersonOutputDTO> findByName(String name) throws Exception;

  PersonOutputDTO findById(String id) throws Exception;

  List<Person> findAll();

  String deletedById(String id) throws Exception;
}
