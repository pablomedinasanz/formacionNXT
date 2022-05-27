package com.example.DBA2.service;


import com.example.DBA2.dto.PersonInputDTO;
import com.example.DBA2.dto.PersonOutputDTO;

import java.util.List;

public interface PersonService {
  void addPerson(PersonInputDTO personInputDTO);

  List<PersonOutputDTO> findAll();

  PersonOutputDTO findOneByID(String id);

  void deleteByID(String id);

  void updatePerson(PersonInputDTO personInputDTO, String id);
}
