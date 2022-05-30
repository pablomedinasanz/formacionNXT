package com.example.EJ2CRUD.student.domain;

import com.example.EJ2CRUD.person.domain.Person;
import com.example.EJ2CRUD.profesor.domain.Profesor;
import com.example.EJ2CRUD.student.infrastructure.controller.dto.StudentInputDTO;
import com.example.EJ2CRUD.student.infrastructure.controller.dto.StudentOutputDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "estudiantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
  private String id_student;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person persona;

  @Column(name = "horas_por_semana")
  private Integer num_hours_week;

  @Column(name = "comentarios")
  private String coments;

  @ManyToOne(
      fetch = FetchType.LAZY)
  @JoinColumn(name = "id_profesor")
  @JsonIgnore
  private Profesor profesor;

  @Column(name = "rama")
  private String branch;


  public Student(StudentInputDTO studentInputDTO) {
    setId_student(studentInputDTO.getId_student());
    setNum_hours_week(studentInputDTO.getNum_hours_week());
    setComents(studentInputDTO.getComents());
    setBranch(studentInputDTO.getBranch());
  }

  public Student(StudentOutputDTO studentOutputDTO) {
    setId_student(studentOutputDTO.getId_student());
    setPersona(studentOutputDTO.getPersona());
    setNum_hours_week(studentOutputDTO.getNum_hours_week());
    setComents(studentOutputDTO.getComents());
    setProfesor(studentOutputDTO.getProfesor());
    setBranch(studentOutputDTO.getBranch());
  }
}
