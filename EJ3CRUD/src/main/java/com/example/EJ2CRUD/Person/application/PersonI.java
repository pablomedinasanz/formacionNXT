package com.example.EJ2CRUD.Person.application;

import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Person.infrastructure.dto.PersonInputDTO;
import com.example.EJ2crud.Person.infrastructure.dto.PersonOutputDTO;

import java.util.List;

public interface PersonI {
  PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception;

  List<PersonOutputDTO> findByName(String name) throws Exception;

  PersonOutputDTO findById(String id) throws Exception;

  List<Person> findAll();

  String deletedById(String id) throws Exception;
}
