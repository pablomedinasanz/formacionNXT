package com.example.EJ2CRUD.Person.domain;

import com.example.EJ2CRUD.Person.infrastructure.dto.PersonInputDTO;
import com.example.EJ2CRUD.Person.infrastructure.dto.PersonOutputDTO;
import com.example.EJ2CRUD.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  @GenericGenerator(
      name = "seq",
      strategy = "com.example.EJ2crud.StringPrefixedSequenceIdGenerator",
      parameters = {
        @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
        @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PER"),
        @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
      })
  private String person_id;

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

  public Person(PersonOutputDTO personOutputDTO) {
    setPerson_id(personOutputDTO.getPerson_id());
    setUser(personOutputDTO.getUser());
    setName(personOutputDTO.getName());
    setSurname(personOutputDTO.getSurname());
    setCompany_email(personOutputDTO.getCompany_email());
    setPersonal_email(personOutputDTO.getPersonal_email());
    setCity(personOutputDTO.getCity());
    setActive(personOutputDTO.isActive());
    setCreated_date(personOutputDTO.getCreated_date());
    setImage_url(personOutputDTO.getImage_url());
    setTermination_date(personOutputDTO.getTermination_date());
  }
}
