package com.example.DBA1.service;



import com.example.DBA1.dto.PersonInputDTO;
import com.example.DBA1.dto.PersonOutputDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public interface PersonService {
  PersonOutputDTO addPerson(PersonInputDTO personInputDTO);

  List<PersonOutputDTO> findAll();

  List<PersonOutputDTO> findPeopleByConditions(HashMap<String, Object> conditions);

  PersonOutputDTO findById(int id);

  PersonOutputDTO findByName(String nombre);

   PersonOutputDTO deletedById(int id);
}
