package com.example.EJ2CRUD.Subject.application;

import com.example.EJ2crud.Subject.domain.Subject;
import com.example.EJ2crud.Subject.infrastructure.controller.dto.SubjectInputDTO;
import com.example.EJ2crud.Subject.infrastructure.controller.dto.SubjectOutputDTO;
import com.example.EJ2crud.Subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
  @Autowired SubjectRepositoryJpa subjectRepositoryJpa;

  @Override
  public SubjectOutputDTO addSubject(SubjectInputDTO subjectInputDTO) throws Exception {
    Subject subject = new Subject(subjectInputDTO);
    subjectRepositoryJpa.save(subject);
    return new SubjectOutputDTO(subject);
  }

  @Override
  public SubjectOutputDTO findById(String id) throws Exception {
    Subject subject =
        subjectRepositoryJpa
            .findById(id)
            .orElseThrow(() -> new Exception("No se ha encontrado el estudiante indicado"));
    return new SubjectOutputDTO(subject);
  }

  @Override
  public List<SubjectOutputDTO> findAll() {
    List<SubjectOutputDTO> subjectOutputDTOList = new ArrayList<>();
    for (Subject subject : subjectRepositoryJpa.findAll()) {
      subjectOutputDTOList.add(new SubjectOutputDTO(subject));
    }
    return subjectOutputDTOList;
  }

  @Override
  public String deletedById(String id) throws Exception {
    subjectRepositoryJpa.deleteById(id);
    return "Se ha borrado la asignatura correctamente";
  }
}
