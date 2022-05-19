package com.example.bs9.EJ2crud.Subject.infrastructure.controller;

import com.example.EJ2crud.Student.domain.Student;
import com.example.EJ2crud.Student.infrastructure.repository.jpa.StudentRepositoryJpa;
import com.example.EJ2crud.Subject.application.SubjectService;
import com.example.EJ2crud.Subject.domain.Subject;
import com.example.EJ2crud.Subject.infrastructure.controller.dto.SubjectInputDTO;
import com.example.EJ2crud.Subject.infrastructure.controller.dto.SubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("subject/crud")
public class SubjectController {
  @Autowired SubjectService subjectService;
  @Autowired StudentRepositoryJpa studentRepositoryJpa;

  // Request para insertar un estudiante en la base de datos
  @PostMapping("/addSubject")
  public SubjectOutputDTO addSubject(@RequestBody SubjectInputDTO subjectInputDTO)
      throws Exception {
    System.out.println("En el controlador addSubject");
    return subjectService.addSubject(subjectInputDTO);
  }

  // Request para obtener todos los registros de la tabla
  @GetMapping(value = "/getSubjects")
  public List<SubjectOutputDTO> getSubjects() {
    System.out.println("En el controlador getSubjects");
    return subjectService.findAll();
  }

  // Request para obtener todos los registros de la tabla
  @PutMapping(value = "/getSubjects/{student_id}")
  public List<SubjectOutputDTO> getSubjectsByStudent(@PathVariable String student_id)
      throws Exception {
    System.out.println("En el controlador getSubjects");
    List<SubjectOutputDTO> subjectOutputDTOList = new ArrayList<>();
    Student student =
        studentRepositoryJpa
            .findById(student_id)
            .orElseThrow(() -> new Exception("Estudiante no encontrado"));
    for (Subject subject : student.getEstudios()) {
      SubjectOutputDTO subjectOutputDTO = new SubjectOutputDTO(subject);
      subjectOutputDTOList.add(subjectOutputDTO);
    }
    return subjectOutputDTOList;
  }

  // Request para obtener el estudiante con id pasado por parámetro
  @GetMapping(value = "/getSubject/{id}")
  public SubjectOutputDTO getSubjectById(@PathVariable String id) throws Exception {
    return subjectService.findById(id);
  }

  // Request para eliminar el estudiante con id pasado por parámetro
  @DeleteMapping(value = "/delete/{id}")
  public String deleteSubjectById(@PathVariable String id) throws Exception {
    subjectService.deletedById(id);
    return "La asignatura con id " + id + " ha sido eliminada de la base de datos";
  }
}
