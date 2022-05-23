package com.example.DBA1.Person.infrastructure.repository;



import com.example.DBA1.Person.domain.Person;
import com.example.DBA1.Person.infrastructure.dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
  List<PersonOutputDTO> findByName(String user);

  List<Person> getData(HashMap<String, Object> conditions);
}
