package com.example.bs9.EJ2crud.Student.infrastructure.controller.dto;

import com.example.EJ2crud.Subject.domain.Subject;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentInputDTO {
  private String id_student;
  private String person_id;
  private Integer num_hours_week;
  private String coments;
  private String profesor_id;
  private String branch;
  private List<Subject> estudios;
}
