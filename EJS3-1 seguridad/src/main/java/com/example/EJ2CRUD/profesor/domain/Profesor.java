package com.example.EJ2CRUD.profesor.domain;


import com.example.EJ2CRUD.person.domain.Person;
import com.example.EJ2CRUD.profesor.infrastructure.controller.dto.ProfesorInputDTO;
import com.example.EJ2CRUD.profesor.infrastructure.controller.dto.ProfesorOutputDTO;
import com.example.EJ2CRUD.student.domain.Student;
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
