package com.example.bs9.EJ2crud.Profesor.application;

import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorInputDTO;
import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorOutputDTO;

import java.util.List;

public interface ProfesorService {
  ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;

  ProfesorOutputDTO findById(String id) throws Exception;

  List<ProfesorOutputDTO> findAll();

  String deletedById(String id) throws Exception;
}
