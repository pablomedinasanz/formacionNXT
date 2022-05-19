package com.example.bs9.EJ2crud.Subject.infrastructure.controller.dto;

import com.example.EJ2crud.Student.domain.Student;
import com.example.EJ2crud.Subject.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOutputDTO {
  private String id_study;
  private List<Student> studentList;
  private String subject;
  private String comment;
  private Date initial_date;
  private Date finish_date;

  public SubjectOutputDTO(Subject subject) {
    setId_study(subject.getId_study());
    setSubject(subject.getSubject());
    setComment(subject.getComment());
    setInitial_date(subject.getInitial_date());
    setFinish_date(subject.getFinish_date());
  }
}
