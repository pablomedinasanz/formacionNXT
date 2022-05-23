package com.example.EJ2CRUD.Profesor.infrastructure.repository.jpa;

import com.example.EJ2crud.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfesorRepositoryJpa extends JpaRepository<Profesor, String> {
  @Query(value = "SELECT * FROM Estudiantes WHERE person_id = ?1", nativeQuery = true)
  Optional<Profesor> findProfesorByPersonID(String id);
}
