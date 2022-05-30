package com.example.DBA1.repository;

import com.example.DBA1.dto.PersonOutputDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PersonRepositoryImpl {

  @PersistenceContext
  private EntityManager entityManager;

  public List<PersonOutputDTO> getData(HashMap<String, Object> conditions) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<PersonOutputDTO> query = cb.createQuery(PersonOutputDTO.class);
    Root<PersonOutputDTO> root = query.from(PersonOutputDTO.class);

    List<Predicate> predicates = new ArrayList<>();
    conditions.forEach(
        (field, value) -> {
            switch (field) {
                case "user", "name", "surname" -> predicates.add(cb.like(root.get(field), "%" + (String) value + "%"));
                case "created_date" -> {
                    String dateCondition = (String) conditions.get("dateCondition");
                    switch (dateCondition) {
                        case "GREATER_THAN" -> {
                            try {
                                predicates.add(cb.greaterThan(root.<Date>get(field), (Date) new SimpleDateFormat("yyyy-MM-dd").parse((String) value)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        case "LESS_THAN" -> {
                            try {
                                predicates.add(cb.lessThan(root.<Date>get(field), (Date) new SimpleDateFormat("yyyy-MM-dd").parse((String) value)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        case "EQUAL" -> {
                            try {
                                predicates.add(cb.equal(root.<Date>get(field), (Date) new SimpleDateFormat("yyyy-MM-dd").parse((String) value)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        int firstResult = Integer.parseInt((String) conditions.get("pageIndex"));
        int maxResults = 10;
        if(conditions.containsKey("pageSize")){
           maxResults= Integer.parseInt((String) conditions.get("pageSize"));
        }
        return entityManager.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
  }
}
