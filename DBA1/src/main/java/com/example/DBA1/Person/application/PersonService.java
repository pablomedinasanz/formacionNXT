package com.example.DBA1.Person.application;



import com.example.DBA1.Person.domain.Person;
import com.example.DBA1.Person.infrastructure.dto.PersonInputDTO;
import com.example.DBA1.Person.infrastructure.dto.PersonOutputDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;

public interface PersonService {
  PersonOutputDTO addPerson(PersonInputDTO personInputDTO);

  List<PersonOutputDTO> findAll();

  List<Person> findPeopleByConditions(HashMap<String, Object> conditions);
}
