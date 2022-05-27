package com.example.DBA2.entity;


import com.example.DBA2.dto.PersonInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document(collection = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  @Id @MongoId private String person_id;

  @NonNull private String user;
  @NonNull private String password;
  @NonNull private String name;
  private String surname;
  @NonNull private String company_email;
  @NonNull private String personal_email;
  @NonNull private String city;
  @NonNull private boolean active;

  @NonNull private Date created_date = new Date();

  private String image_url;
  private Date termination_date;

  public Person(PersonInputDTO personInputDTO) {
    setPerson_id(personInputDTO.getPerson_id());
    setUser(personInputDTO.getUser());
    setPassword(personInputDTO.getPassword());
    setName(personInputDTO.getName());
    setSurname(personInputDTO.getSurname());
    setCompany_email(personInputDTO.getCompany_email());
    setPersonal_email(personInputDTO.getPersonal_email());
    setCity(personInputDTO.getCity());
    setActive(personInputDTO.isActive());
    setCreated_date(personInputDTO.getCreated_date());
    setImage_url(personInputDTO.getImage_url());
    setTermination_date(personInputDTO.getTermination_date());
  }
}
