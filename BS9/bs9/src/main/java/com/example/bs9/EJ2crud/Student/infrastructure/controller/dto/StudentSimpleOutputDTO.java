package com.example.bs9.EJ2crud.Student.infrastructure.controller.dto;

import com.example.EJ2crud.Profesor.domain.Profesor;
import com.example.EJ2crud.Student.domain.Student;
import com.example.EJ2crud.Subject.domain.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentSimpleOutputDTO {
  private String id_student;
  private Integer num_hours_week;
  private String coments;
  private Profesor profesor;
  private String branch;
  private List<Subject> estudios;

  public StudentSimpleOutputDTO(Student student) {
    setId_student(student.getId_student());
    setNum_hours_week(student.getNum_hours_week());
    setComents(student.getComents());
    setProfesor(student.getProfesor());
    setBranch(student.getBranch());
    setEstudios(student.getEstudios());
  }
}
