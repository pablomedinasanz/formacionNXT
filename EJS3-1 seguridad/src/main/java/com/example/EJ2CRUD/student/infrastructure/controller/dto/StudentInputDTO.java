package com.example.EJ2CRUD.student.infrastructure.controller.dto;

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
}
