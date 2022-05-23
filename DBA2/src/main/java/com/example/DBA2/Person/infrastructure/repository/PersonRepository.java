package com.example.DBA2.Person.infrastructure.repository;


import com.example.DBA2.Person.domain.Person;

import java.util.List;

public interface PersonRepository {

  Person addPerson(Person person);

  List<Person> findAll();

  Person findOneByID(String id);

  void deleteByID(String id);

  Person updatePerson(Person person, String id);
}
