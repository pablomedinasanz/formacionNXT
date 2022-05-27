package com.example.DBA1.service;


import com.example.DBA1.entity.Person;
import com.example.DBA1.dto.PersonInputDTO;
import com.example.DBA1.dto.PersonOutputDTO;
import com.example.DBA1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {
  @Autowired private PersonRepository personRepository;

  @PersistenceContext
  private EntityManager entityManager;

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
  public List<PersonOutputDTO> findPeopleByConditions(HashMap<String, Object> conditions) {

    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<PersonOutputDTO> query = cb.createQuery(PersonOutputDTO.class);
    Root<PersonOutputDTO> root = query.from(PersonOutputDTO.class);

    List<Predicate> predicates = new ArrayList<>();
    conditions.forEach((field, value) -> {

      switch (field){
        case "usuario":
          predicates.add(cb.like(root.get(field),(String)value));
          break;
        case "name":
          predicates.add(cb.like(root.get(field),(String)value));
          break;
        case "surname":
          predicates.add(cb.like(root.get(field),(String)value));
          break;
        case "created_date":
          String dateCondition = (String) conditions.get("dateCondition");
          switch(dateCondition){
            case "greater":
              predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
              break;
            case "less":
              predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
              break;
            case "equal":
              predicates.add(cb.equal(root.<Date>get(field),(Date)value));
              break;
          }
          break;
        case "orderBy":
          query.orderBy(cb.asc(root.get((String)value)));
          break;
      }
    });
    query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

    int pageSize = 10;
    if(conditions.get(pageSize) != null){
      pageSize= Integer.parseInt((String)conditions.get("pageSize"));
    }
    return entityManager.createQuery(query).setMaxResults(pageSize).getResultList();
  }
}
