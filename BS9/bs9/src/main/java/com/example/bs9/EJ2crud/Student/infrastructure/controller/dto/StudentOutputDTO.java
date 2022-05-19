package com.example.bs9.EJ2crud.Student.infrastructure.controller.dto;

import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Profesor.domain.Profesor;
import com.example.EJ2crud.Student.domain.Student;
import com.example.EJ2crud.Subject.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentOutputDTO {
  private String id_student;
  private Person persona;
  private Integer num_hours_week;
  private String coments;
  private Profesor profesor;
  private String branch;
  private List<Subject> estudios;

  public StudentOutputDTO(Student student) {
    setId_student(student.getId_student());
    setPersona(student.getPersona());
    setNum_hours_week(student.getNum_hours_week());
    setComents(student.getComents());
    setProfesor(student.getProfesor());
    setBranch(student.getBranch());
    setEstudios(student.getEstudios());
  }
}
