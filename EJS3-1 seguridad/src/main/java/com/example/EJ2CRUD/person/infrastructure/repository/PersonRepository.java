package com.example.EJ2CRUD.person.infrastructure.repository;


import com.example.EJ2CRUD.person.domain.Person;
import com.example.EJ2CRUD.person.infrastructure.dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
  List<PersonOutputDTO> findByName(String user);
}
