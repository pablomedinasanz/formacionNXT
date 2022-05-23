package com.example.BS12.Person.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDTO {
  private String person_id;

  private String user;
  private String password;
  private String name;
  private String surname;
  private String company_email;
  private String personal_email;
  private String city;
  private boolean active;
  private Date created_date = new Date();
  private String image_url;
  private Date termination_date;
}
