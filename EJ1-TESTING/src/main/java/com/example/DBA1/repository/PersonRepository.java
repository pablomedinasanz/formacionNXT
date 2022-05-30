package com.example.DBA1.repository;



import com.example.DBA1.entity.Person;
import com.example.DBA1.dto.PersonOutputDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> , JpaSpecificationExecutor<Person> {

  @Query("select p from Person p where p.name = ?1")
  List<PersonOutputDTO> findByName(String name);

  List<PersonOutputDTO> findPeopleByConditions(Date fromDate, Date toDate, String name, Pageable pageable);

}
