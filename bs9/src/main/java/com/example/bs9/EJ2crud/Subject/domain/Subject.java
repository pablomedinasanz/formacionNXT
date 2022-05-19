package com.example.bs9.EJ2crud.Subject.domain;

import com.example.EJ2crud.StringPrefixedSequenceIdGenerator;
import com.example.EJ2crud.Student.domain.Student;
import com.example.EJ2crud.Subject.infrastructure.controller.dto.SubjectInputDTO;
import com.example.EJ2crud.Subject.infrastructure.controller.dto.SubjectOutputDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
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
            value = "SUB"),
        @org.hibernate.annotations.Parameter(
            name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
            value = "%04d")
      })
  private String id_study;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "student_subject",
      joinColumns = {@JoinColumn(name = "id_study")},
      inverseJoinColumns = {@JoinColumn(name = "id_student")})
  @JsonIgnore
  private List<Student> studentList;

  @Column(name = "asignatura")
  private String subject;

  @Column(name = "comentarios")
  private String comment;

  @Column(name = "initial_date")
  private Date initial_date;

  @Column(name = "finish_date")
  private Date finish_date;

  public Subject(SubjectInputDTO subjectInputDTO) {
    setId_study(subjectInputDTO.getId_study());
    setSubject(subjectInputDTO.getSubject());
    setComment(subjectInputDTO.getComment());
    setInitial_date(subjectInputDTO.getInitial_date());
    setFinish_date(subjectInputDTO.getFinish_date());
  }

  public Subject(SubjectOutputDTO subjectOutputDTO) {
    setId_study(subjectOutputDTO.getId_study());
    setSubject(subjectOutputDTO.getSubject());
    setComment(subjectOutputDTO.getComment());
    setInitial_date(subjectOutputDTO.getInitial_date());
    setFinish_date(subjectOutputDTO.getFinish_date());
  }
}
