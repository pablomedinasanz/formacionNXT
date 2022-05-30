package com.example.EJ2CRUD.student.infrastructure.controller.dto;


import com.example.EJ2CRUD.person.domain.Person;
import com.example.EJ2CRUD.profesor.domain.Profesor;
import com.example.EJ2CRUD.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  public StudentOutputDTO(Student student) {
    setId_student(student.getId_student());
    setPersona(student.getPersona());
    setNum_hours_week(student.getNum_hours_week());
    setComents(student.getComents());
    setProfesor(student.getProfesor());
    setBranch(student.getBranch());
  }
}
