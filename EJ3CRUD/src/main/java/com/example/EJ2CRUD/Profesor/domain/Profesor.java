package com.example.EJ2CRUD.Profesor.domain;

import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorInputDTO;
import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorOutputDTO;
import com.example.EJ2crud.StringPrefixedSequenceIdGenerator;
import com.example.EJ2crud.Student.domain.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor")
@Data
public class Profesor {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
  @GenericGenerator(
      name = "ausencias_seq",
      strategy = "com.example.EJ2crud.StringPrefixedSequenceIdGenerator",
      parameters = {
        @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
        @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PRO"),
        @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
      })
  private String id_profesor;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person persona;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private List<Student> students;

  @Column(name = "materia")
  private String branch;

  public Profesor(ProfesorInputDTO profesorInputDTO) {
    setId_profesor(profesorInputDTO.getId_profesor());
    setBranch(profesorInputDTO.getBranch());
  }

  public Profesor(ProfesorOutputDTO profesorOutputDTO) {
    setId_profesor(profesorOutputDTO.getId_profesor());
    setPersona(profesorOutputDTO.getPersona());
    setStudents(profesorOutputDTO.getStudents());
    setBranch(profesorOutputDTO.getBranch());
  }
}
