package com.example.BS12.Person.application;

import com.example.BS12.Person.domain.Person;
import com.example.BS12.Person.infrastructure.dto.PersonInputDTO;
import com.example.BS12.Person.infrastructure.dto.PersonOutputDTO;
import com.example.BS12.Person.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
