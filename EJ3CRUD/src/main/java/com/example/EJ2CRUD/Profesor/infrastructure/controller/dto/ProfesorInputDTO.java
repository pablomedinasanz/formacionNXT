package com.example.EJ2CRUD.Profesor.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfesorInputDTO {
  private String id_profesor;
  private String person_id;
  private String branch;
}
