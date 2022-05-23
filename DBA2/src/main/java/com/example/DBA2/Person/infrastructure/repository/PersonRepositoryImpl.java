package com.example.DBA2.Person.infrastructure.repository;


import com.example.DBA2.Person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRepositoryImpl implements PersonRepository {
  private final MongoTemplate mongoTemplate;

  @Autowired
  public PersonRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public Person addPerson(Person person) {
    mongoTemplate.save(person);
    return person;
  }

  @Override
  public List<Person> findAll() {

    return mongoTemplate.findAll(Person.class);
  }

  @Override
  public Person findOneByID(String id) {
    return mongoTemplate.findById(id, Person.class);
  }

  @Override
  public void deleteByID(String id) {
    Person person = mongoTemplate.findById(id, Person.class);
    if (person != null) mongoTemplate.remove(person);
  }

  @Override
  public Person updatePerson(Person person, String id) {
    Person personToUpdate = mongoTemplate.findById(id, Person.class);
    if (personToUpdate != null) {
      person.setPerson_id(id);
      mongoTemplate.save(person);
    }

    return person;
  }
}
