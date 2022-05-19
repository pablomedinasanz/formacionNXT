package com.example.EJ2CRUD.Student.domain;

import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Profesor.domain.Profesor;
import com.example.EJ2crud.StringPrefixedSequenceIdGenerator;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentInputDTO;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentOutputDTO;
import com.example.EJ2crud.Subject.domain.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
  @GenericGenerator(
      name = "ausencias_seq",
      strategy = "com.example.EJ2crud.StringPrefixedSequenceIdGenerator",
      parameters = {
        @org.hibernate.annotations.Parameter(
            name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,
            value = "1"),
        @org.hibernate.annotations.Parameter(
            name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
            value = "STU"),
        @org.hibernate.annotations.Parameter(
            name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
            value = "%04d")
      })
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

  @ManyToMany(mappedBy = "studentList")
  @JsonIgnore
  private List<Subject> estudios;

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
    setEstudios(studentOutputDTO.getEstudios());
  }
}
