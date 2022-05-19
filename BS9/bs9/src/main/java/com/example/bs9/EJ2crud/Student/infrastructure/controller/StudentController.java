package com.example.bs9.EJ2crud.Student.infrastructure.controller;

import com.example.EJ2crud.Student.application.StudentService;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentInputDTO;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentOutputDTO;
import com.example.EJ2crud.Student.infrastructure.controller.dto.StudentSimpleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/crud")
public class StudentController {
  @Autowired StudentService studentService;

  // Request para insertar un estudiante en la base de datos
  @PostMapping("/addStudent")
  public ResponseEntity<?> addStudent(@RequestBody StudentInputDTO studentInputDTO)
      throws Exception {
    System.out.println("En el controlador addStudent");
    return studentService.addStudent(studentInputDTO);
  }

  // Request para insertar un estudiante en la base de datos
  @PutMapping("/addStudent_Subject/{student_Id}")
  public StudentOutputDTO addStudent_Subject(
      @PathVariable String student_Id, @RequestBody List<String> subjectIdList) throws Exception {
    System.out.println("En el controlador addStudent_Subject");
    return studentService.addStudent_Subject(student_Id, subjectIdList);
  }

  // Request para obtener todos los registros de la tabla
  @GetMapping(value = "/getStudents")
  public List<StudentOutputDTO> getStudents() {
    System.out.println("En el controlador getStudents");
    return studentService.findAll();
  }

  // Request para obtener el estudiante con id pasado por parámetro
  @PutMapping(value = "/getStudent/{id}")
  public ResponseEntity<?> getStudentById(
      @PathVariable String id, @RequestParam(defaultValue = "simple") String outputType)
      throws Exception {
    if (outputType.equals("simple")) {
      StudentSimpleOutputDTO studentsimple = studentService.findSimpleById(id);
      return ResponseEntity.ok(studentsimple);
    } else {
      if (outputType.equals("full")) {
        StudentOutputDTO studentfull = studentService.findById(id);
        return ResponseEntity.ok(studentfull);
      }
      return ResponseEntity.ok("No se ha encontrado");
    }
  }

  // Request para eliminar el estudiante con id pasado por parámetro
  @DeleteMapping(value = "/delete/{id}")
  public String deleteStudentById(@PathVariable String id) throws Exception {
    studentService.deletedById(id);
    return "El Estudiante con id " + id + " ha sido eliminada de la base de datos";
  }

  // Request para insertar un estudiante en la base de datos
  @DeleteMapping("/removeStudent_Subject/{student_Id}")
  public ResponseEntity<?> removeSubjectsStudent_Subject(
      @PathVariable String student_Id, @RequestBody List<String> subjectIdList) throws Exception {
    System.out.println("En el controlador removeStudent_Subject");
    return studentService.removeSubjects(student_Id, subjectIdList);
  }
}
