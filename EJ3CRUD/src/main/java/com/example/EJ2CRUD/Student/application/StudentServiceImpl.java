package com.example.EJ2CRUD.Student.application;

import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Person.infrastructure.repository.PersonRepository;
import com.example.EJ2crud.Profesor.application.ProfesorService;
import com.example.EJ2crud.Profesor.domain.Profesor;
import com.example.EJ2crud.Profesor.infrastructure.repository.jpa.ProfesorRepositoryJpa;
import com.example.EJ2crud.Student.domain.Student;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentInputDTO;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentOutputDTO;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentSimpleOutputDTO;
import com.example.EJ2crud.Student.infrastructure.repository.jpa.StudentRepositoryJpa;
import com.example.EJ2crud.Subject.domain.Subject;
import com.example.EJ2crud.Subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired private StudentRepositoryJpa studentRepositoryJpa;
  @Autowired private PersonRepository personRepository;
  @Autowired private ProfesorService profesorService;
  @Autowired private ProfesorRepositoryJpa profesorRepositoryJpa;
  @Autowired private SubjectRepositoryJpa subjectRepositoryJpa;

  @Override
  public ResponseEntity<?> addStudent(StudentInputDTO studentInputDTO) throws Exception {
    Optional<Person> person = personRepository.findById(studentInputDTO.getPerson_id());

    // Comprobamos si la persona existe
    if (person.isPresent()) {
      Student student = new Student(studentInputDTO);
      student.setPersona(person.get());

      // Comprobamos que el profesor existe
      if (studentInputDTO.getProfesor_id() != null) {
        Profesor profesor =
            new Profesor(profesorService.findById(studentInputDTO.getProfesor_id()));
        student.setProfesor(profesor);
      } else {
        return new ResponseEntity<>("El profesor asociado no existe", HttpStatus.NOT_FOUND);
      }

      // Comprobamos que la persona asociada no sea un Profesor
      if (studentRepositoryJpa.findStudentByPersonID(person.get().getPerson_id()).isEmpty()
          && profesorRepositoryJpa.findProfesorByPersonID(person.get().getPerson_id()).isEmpty()) {
        studentRepositoryJpa.save(student);
        return new ResponseEntity<>("Estudiante guardado correctamente", HttpStatus.OK);
      } else {
        return new ResponseEntity<>(
            "Error al insertar estudiante, la persona ya esta asociada a un estudiante o a un profesor",
            HttpStatus.BAD_REQUEST);
      }

    } else {
      return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public StudentOutputDTO findById(String id) throws Exception {
    Student student =
        studentRepositoryJpa
            .findById(id)
            .orElseThrow(() -> new Exception("No se ha encontrado el Estudiante."));
    return new StudentOutputDTO(student);
  }

  @Override
  public StudentSimpleOutputDTO findSimpleById(String id) throws Exception {
    Student student =
        studentRepositoryJpa
            .findById(id)
            .orElseThrow(() -> new Exception("No se ha encontrado el Estudiante."));
    return new StudentSimpleOutputDTO(student);
  }

  @Override
  public List<StudentOutputDTO> findAll() {
    List<StudentOutputDTO> studentOutputDTOArrayList = new ArrayList<>();
    for (Student student : studentRepositoryJpa.findAll()) {
      studentOutputDTOArrayList.add(new StudentOutputDTO(student));
    }
    return studentOutputDTOArrayList;
  }

  @Override
  public String deletedById(String id) throws Exception {
    Student student = new Student(this.findById(id));
    studentRepositoryJpa.delete(student);
    return "Se ha borrado correctamente el estudiante";
  }

  @Override
  public StudentOutputDTO addStudent_Subject(String studentID, List<String> subjectIDList)
      throws Exception {
    Optional<Student> student = studentRepositoryJpa.findById(studentID);
    if (student.isEmpty()) {
      throw new Exception("No existe un estudiante asociado a este id");
    }
    List<Subject> subjectsFromStudent = student.get().getEstudios();
    for (String id : subjectIDList) {
      Optional<Subject> subject = subjectRepositoryJpa.findById(id);
      if (subject.isPresent()) {
        subjectsFromStudent.add(subject.get());
        List<Student> studentsFromSubject = subject.get().getStudentList();
        studentsFromSubject.add(student.get());

        student.get().setEstudios(subjectsFromStudent);
        subject.get().setStudentList(studentsFromSubject);
      }
    }
    studentRepositoryJpa.save(student.get());
    return new StudentOutputDTO(student.get());
  }

  @Override
  public ResponseEntity<?> removeSubjects(String student_id, List<String> subjectIDList)
      throws Exception {
    Optional<Student> student = studentRepositoryJpa.findById(student_id);
    if (student.isEmpty()) {
      throw new Exception("No existe un estudiante asociado a este id");
    }
    for (String id : subjectIDList) {
      Optional<Subject> subject = subjectRepositoryJpa.findById(id);
      if (subject.isPresent()) {
        subject.get().getStudentList().remove(student.get());
        student.get().getEstudios().remove(subject.get());
      }
    }
    studentRepositoryJpa.save(student.get());
    return new ResponseEntity<>(
        "Se han borrado las asignaturas del estudiante correctamente", HttpStatus.OK);
  }
}
