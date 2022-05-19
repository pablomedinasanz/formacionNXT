package com.example.bs9.EJ2crud.Student.application;

import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentInputDTO;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentOutputDTO;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentSimpleOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
  ResponseEntity<?> addStudent(StudentInputDTO studentInputDTO) throws Exception;

  StudentOutputDTO findById(String id) throws Exception;

  List<StudentOutputDTO> findAll();

  String deletedById(String id) throws Exception;

  StudentOutputDTO addStudent_Subject(String studentID, List<String> subjectIdList)
      throws Exception;

  StudentSimpleOutputDTO findSimpleById(String id) throws Exception;

  ResponseEntity<?> removeSubjects(String student_id, List<String> subjectIDList) throws Exception;
}
