package com.example.BS12.Person.infrastructure.repository;

import com.example.BS12.Person.domain.Person;
import com.example.BS12.Person.infrastructure.dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
  List<PersonOutputDTO> findByName(String user);
}
