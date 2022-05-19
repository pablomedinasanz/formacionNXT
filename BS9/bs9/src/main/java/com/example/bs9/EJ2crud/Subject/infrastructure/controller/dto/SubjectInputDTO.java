package com.example.bs9.EJ2crud.Subject.infrastructure.controller.dto;

import com.example.EJ2crud.Student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectInputDTO {
  private String id_study;
  private List<Student> studentList;
  private String subject;
  private String comment;
  private Date initial_date;
  private Date finish_date;
}
