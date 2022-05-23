package com.example.DBA2.Person.application;

import com.example.DBA2.Person.domain.Person;


import com.example.DBA2.Person.infrastructure.dto.PersonInputDTO;
import com.example.DBA2.Person.infrastructure.dto.PersonOutputDTO;
import com.example.DBA2.Person.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
  @Autowired private PersonRepository personRepository;

  @Override
  public void addPerson(PersonInputDTO personInputDTO) {
    Person person = new Person(personInputDTO);

    new PersonOutputDTO(personRepository.addPerson(person));
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
  public PersonOutputDTO findOneByID(String id) {

    return new PersonOutputDTO(personRepository.findOneByID(id));
  }

  @Override
  public void deleteByID(String id) {
    personRepository.deleteByID(id);
  }

  @Override
  public void updatePerson(PersonInputDTO personInputDTO, String id) {

    new PersonOutputDTO(personRepository.updatePerson(new Person(personInputDTO), id));
  }
}
