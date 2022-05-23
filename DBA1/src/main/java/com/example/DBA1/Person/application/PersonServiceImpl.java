package com.example.DBA1.Person.application;


import com.example.DBA1.Person.domain.Person;
import com.example.DBA1.Person.infrastructure.dto.PersonInputDTO;
import com.example.DBA1.Person.infrastructure.dto.PersonOutputDTO;
import com.example.DBA1.Person.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
  @Autowired private PersonRepository personRepository;

  @Override
  public PersonOutputDTO addPerson(PersonInputDTO personInputDTO) {
    Person person = new Person(personInputDTO);
    personRepository.save(person);
    return new PersonOutputDTO(person);
  }

  @Override
  public List<PersonOutputDTO> findAll() {
    List<PersonOutputDTO> personOutputDTOList = new ArrayList<>();
    for (Person person : personRepository.findAll()) {
      personOutputDTOList.add(new PersonOutputDTO(person));
    }
    return personOutputDTOList;
  }

  @Override
  public List<Person> findPeopleByConditions(HashMap<String, Object> conditions) {

    return personRepository.getData(conditions);
  }
}
