package com.example.DBA2.repository;


import com.example.DBA2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PersonRepositoryImpl implements PersonRepository {

  @Autowired
  PersonRepository personRepository;

  @Override
  public Person addPerson(Person person) {
    personRepository.save(person);

    return person;
  }

  @Override
  public <S extends Person> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Person> List<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Person> findById(String s) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(String s) {
    return false;
  }

  @Override
  public List<Person> findAll() {

    return personRepository.findAll();
  }

  @Override
  public Iterable<Person> findAllById(Iterable<String> strings) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(String s) {

  }

  @Override
  public void delete(Person entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends String> strings) {

  }

  @Override
  public void deleteAll(Iterable<? extends Person> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public List<Person> findAll(Sort sort) {
    return null;
  }

  @Override
  public Page<Person> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Person> S insert(S entity) {
    return null;
  }

  @Override
  public <S extends Person> List<S> insert(Iterable<S> entities) {
    return null;
  }

  @Override
  public <S extends Person> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends Person> List<S> findAll(Example<S> example) {
    return null;
  }

  @Override
  public <S extends Person> List<S> findAll(Example<S> example, Sort sort) {
    return null;
  }

  @Override
  public <S extends Person> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Person> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends Person> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends Person, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }

  @Override
  public Person findOneByID(String id) {
    return personRepository.findOneByID(id);
  }

  @Override
  public void deleteByID(String id) {

    Person person = personRepository.findOneByID(id);
    if (person != null) personRepository.delete(person);
  }

  @Override
  public Person updatePerson(Person person, String id) {
    Optional<Person> personToUpdate = personRepository.findById(id);

    personToUpdate.ifPresent(person1 -> {
      person.setPerson_id(id);
      personRepository.save(person);
    });

    return person;
  }
}
