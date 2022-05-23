package com.example.BS12.Person.infrastructure.dto;

import com.example.BS12.Person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDTO {
  private String person_id;
  private String user;
  private String name;
  private String surname;
  private String company_email;
  private String personal_email;
  private String city;
  private boolean active;
  private Date created_date;
  private String image_url;
  private Date termination_date;

  public PersonOutputDTO(Person person) {
    setPerson_id(person.getPerson_id());
    setUser(person.getUser());
    setName(person.getName());
    setSurname(person.getSurname());
    setCompany_email(person.getCompany_email());
    setPersonal_email(person.getPersonal_email());
    setCity(person.getCity());
    setActive(person.isActive());
    setCreated_date(person.getCreated_date());
    setImage_url(person.getImage_url());
    setTermination_date(person.getTermination_date());
  }
}
