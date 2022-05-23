package com.example.EJ2CRUD.Profesor.application;

import com.example.EJ2crud.Person.infrastructure.repository.PersonRepository;
import com.example.EJ2crud.Profesor.domain.Profesor;
import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorInputDTO;
import com.example.EJ2crud.Profesor.infrastructure.controller.dto.ProfesorOutputDTO;
import com.example.EJ2crud.Profesor.infrastructure.repository.jpa.ProfesorRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {
  @Autowired private ProfesorRepositoryJpa profesorRepositoryJpa;
  @Autowired private PersonRepository personRepository;

  @Override
  public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
    Profesor profesor = new Profesor(profesorInputDTO);
    profesor.setPersona(personRepository.getById(profesorInputDTO.getPerson_id()));
    personRepository.save(profesor.getPersona());
    profesorRepositoryJpa.save(profesor);
    System.out.println(profesor);
    return new ProfesorOutputDTO(profesor);
  }

  @Override
  public ProfesorOutputDTO findById(String id) throws Exception {
    Profesor profesor =
        profesorRepositoryJpa
            .findById(id)
            .orElseThrow(() -> new Exception("No se ha encontrado el profesor indicado"));

    return new ProfesorOutputDTO(profesor);
  }

  @Override
  public List<ProfesorOutputDTO> findAll() {
    List<ProfesorOutputDTO> profesorOutputDTOList = new ArrayList<>();
    for (Profesor profesor : profesorRepositoryJpa.findAll()) {
      profesorOutputDTOList.add(new ProfesorOutputDTO(profesor));
    }
    return profesorOutputDTOList;
  }

  @Override
  public String deletedById(String id) throws Exception {
    Profesor profesor = new Profesor(this.findById(id));
    profesorRepositoryJpa.delete(profesor);
    personRepository.delete(profesor.getPersona());
    return "Se ha borrado correctamente el profesor";
  }
}
