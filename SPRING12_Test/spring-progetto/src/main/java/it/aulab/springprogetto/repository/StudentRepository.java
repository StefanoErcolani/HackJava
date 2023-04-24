package it.aulab.springprogetto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springprogetto.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
