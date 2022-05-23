package com.example.EJ2CRUD.Person.infrastructure.repository;

import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Person.infrastructure.dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
  List<PersonOutputDTO> findByName(String user);
}
