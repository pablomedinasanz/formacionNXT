package com.example.EJ2CRUD.Subject.infrastructure.repository.jpa;

import com.example.EJ2crud.Subject.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepositoryJpa extends JpaRepository<Subject, String> {}
