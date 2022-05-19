package com.example.bs9.EJ2crud.Profesor.infrastructure.controller.dto;

import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Profesor.domain.Profesor;
import com.example.EJ2crud.Student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfesorOutputDTO {

  private String id_profesor;
  private Person persona;
  private List<Student> students;
  private String branch;

  public ProfesorOutputDTO(Profesor profesor) {
    setId_profesor(profesor.getId_profesor());
    setPersona(profesor.getPersona());
    setStudents(profesor.getStudents());
    setBranch(profesor.getBranch());
  }
}
