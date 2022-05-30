package com.example.EJ2CRUD.student.application;

import com.example.EJ2CRUD.student.infrastructure.controller.dto.StudentInputDTO;
import com.example.EJ2CRUD.student.infrastructure.controller.dto.StudentOutputDTO;
import com.example.EJ2CRUD.student.infrastructure.controller.dto.StudentSimpleOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {
  ResponseEntity<?> addStudent(StudentInputDTO studentInputDTO) throws Exception;

  StudentOutputDTO findById(String id) throws Exception;

  List<StudentOutputDTO> findAll();

  String deletedById(String id) throws Exception;


  StudentSimpleOutputDTO findSimpleById(String id) throws Exception;


}
