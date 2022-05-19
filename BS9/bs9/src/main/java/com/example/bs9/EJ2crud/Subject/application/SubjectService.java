package com.example.bs9.EJ2crud.Subject.application;

import com.example.EJ2crud.Subject.infrastructure.controller.dto.SubjectInputDTO;
import com.example.EJ2crud.Subject.infrastructure.controller.dto.SubjectOutputDTO;

import java.util.List;

public interface SubjectService {
  SubjectOutputDTO addSubject(SubjectInputDTO subjectInputDTO) throws Exception;

  SubjectOutputDTO findById(String id) throws Exception;

  List<SubjectOutputDTO> findAll();

  String deletedById(String id) throws Exception;
}
