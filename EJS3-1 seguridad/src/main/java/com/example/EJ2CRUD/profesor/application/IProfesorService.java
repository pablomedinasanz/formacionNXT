package com.example.EJ2CRUD.profesor.application;


import com.example.EJ2CRUD.profesor.infrastructure.controller.dto.ProfesorInputDTO;
import com.example.EJ2CRUD.profesor.infrastructure.controller.dto.ProfesorOutputDTO;

import java.util.List;

public interface IProfesorService {
  ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;

  ProfesorOutputDTO findById(String id) throws Exception;

  List<ProfesorOutputDTO> findAll();

  String deletedById(String id) throws Exception;
}
