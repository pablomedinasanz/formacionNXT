package com.example.EJ2CRUD.student.infrastructure.controller.dto;

import com.example.EJ2CRUD.profesor.domain.Profesor;
import com.example.EJ2CRUD.student.domain.Student;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentSimpleOutputDTO {
  private String id_student;
  private Integer num_hours_week;
  private String coments;
  private Profesor profesor;
  private String branch;

  public StudentSimpleOutputDTO(Student student) {
    setId_student(student.getId_student());
    setNum_hours_week(student.getNum_hours_week());
    setComents(student.getComents());
    setProfesor(student.getProfesor());
    setBranch(student.getBranch());
  }
}
