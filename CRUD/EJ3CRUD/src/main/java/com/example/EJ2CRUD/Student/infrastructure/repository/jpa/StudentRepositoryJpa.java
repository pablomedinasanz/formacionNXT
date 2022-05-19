package com.example.EJ2CRUD.Student.infrastructure.repository.jpa;

import com.example.EJ2crud.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepositoryJpa extends JpaRepository<Student, String> {
  @Query(value = "SELECT * FROM Estudiantes WHERE person_id = ?1", nativeQuery = true)
  Optional<Student> findStudentByPersonID(String id);
}
